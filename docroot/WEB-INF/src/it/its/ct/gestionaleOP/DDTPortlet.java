/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP;

/**
 *
 * @author mario
 */
import com.google.gson.Gson;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import it.bysoftware.ct.NoSuchAssociatoException;
import it.bysoftware.ct.model.Anagrafica;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.ClientiDatiAgg;
import it.bysoftware.ct.model.OrganizzazioneProduttori;
import it.bysoftware.ct.model.Progressivo;
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.model.TracciabilitaGrezzi;
import it.bysoftware.ct.model.TracciabilitaScheda;
import it.bysoftware.ct.model.impl.RigoDocumentoImpl;
import it.bysoftware.ct.service.AnagraficaLocalServiceUtil;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil;
import it.bysoftware.ct.service.ProgressivoLocalServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TracciabilitaGrezziLocalServiceUtil;
import it.bysoftware.ct.service.TracciabilitaSchedaLocalServiceUtil;
import it.bysoftware.ct.service.persistence.ProgressivoPK;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;
import it.its.ct.gestionaleOP.pojos.Response;
import it.its.ct.gestionaleOP.report.Report;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import net.sf.jasperreports.engine.JRException;

public class DDTPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(DDTPortlet.class);
    public static final String DDT = "DDT";
    public static final String FAV = "FAV";
    public static final String FAC = "FAC";
    public static final String NAC = "NAC";
    public static final String TRAC = "TRAC";
    public static final int DDT_ID = 16;
    public static final int NOTE_ID = 3;
    private static final int INVOICE_ID = 2;
    private static final int PROVISION_INVOICE_ID = 4;

    private static final int ANNO = Calendar.getInstance().get(Calendar.YEAR);
    public static final String COMPLETED = "completo";
    public static final String INVOICED = "fatturato";

    public enum CommandID {

        save, print, send, modify, generateInvoice, printInvoice, updateInvoice, saveTrace, printTrace;
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        super.doView(renderRequest, renderResponse);

        try {

            List<Anagrafica> clienti = AnagraficaLocalServiceUtil.getClienti();
            List<Anagrafica> clientiAssociato = new ArrayList<Anagrafica>();
            for (Anagrafica cliente : clienti) {
                ClientiDatiAgg datiAgg = ClientiDatiAggLocalServiceUtil.fetchClientiDatiAgg(cliente.getCodiceAnagrafica());
                String[] idAssociati = datiAgg.getAssociati().split(",");
                for (String idAssociato : idAssociati) {
                    if (idAssociato.equals(renderRequest.getRemoteUser())) {
                        clientiAssociato.add(cliente);
                        break;
                    }
                }
            }

            _log.info("Associato: " + renderRequest.getRemoteUser() + " has " + clientiAssociato.size() + " clients.");
            renderRequest.setAttribute("clientiAssociato", clientiAssociato);

        } catch (SystemException ex) {
            _log.error(ex);
        }

    }

    public void generateInvoice(ActionRequest areq, ActionResponse ares) {
//        _log.info("Cliente: " + ParamUtil.getString(areq, "clientId"));
//        _log.info("Documents");
//        String[] ids = StringUtil.split(ParamUtil.getString(areq, "documentIds"));
//        for (String id : ids) {
//            _log.info("Document: " + id);
//        }
//        _log.info("*** " + ids.length);
        ares.setRenderParameter("codiceCliente", ParamUtil.getString(areq, "clientId"));
//        ares.setRenderParameter("jspPage", "/jsps/search-ddt.jsp");
        ares.setRenderParameter("anno", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        ares.setRenderParameter("documentIds", ParamUtil.getString(areq, "documentIds"));
        ares.setRenderParameter("jspPage", "/jsps/edit-invoice.jsp");
    }

    public void deleteDDT(ActionRequest areq, ActionResponse ares) {

        int anno = ParamUtil.getInteger(areq, "anno");
        int numeroOrdine = ParamUtil.getInteger(areq, "numeroOrdine");
        Long idAssociato = ParamUtil.getLong(areq, "idAssociato");
        String codiceCliente = ParamUtil.getString(areq, "codiceCliente");

        _log.info("Deleting DDT: " + anno + " " + numeroOrdine + " " + idAssociato);

        try {
            Progressivo createProgressivo = ProgressivoLocalServiceUtil.createProgressivo(new ProgressivoPK(anno, idAssociato, DDT_ID, numeroOrdine));

            ProgressivoLocalServiceUtil.addProgressivo(createProgressivo);

//            List<RigoDocumento> listRigo = RigoDocumentoLocalServiceUtil.getByNumeroOrdineAnno(numeroOrdine, anno, idAssociato);
            List<RigoDocumento> listRigo = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato);
            for (RigoDocumento rigoDocumento : listRigo) {
                RigoDocumentoLocalServiceUtil.deleteRigoDocumento(rigoDocumento);
            }
            TestataDocumentoLocalServiceUtil.deleteTestataDocumento(new TestataDocumentoPK(anno, numeroOrdine, DDT, idAssociato));

            ThemeDisplay themeDisplay = (ThemeDisplay) areq.getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getLayout().getGroupId();
            long repositoryId = themeDisplay.getScopeGroupId();

            Associato a = AssociatoLocalServiceUtil.fetchAssociato(idAssociato);
            OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
            User liferayAssociato = UserLocalServiceUtil.getUser(a.getIdLiferay());
            User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
            DLFolder opFolder = getOpFolder(groupId, liferayOp);
            DLFolder associatoFolder = getAssociatoFolder(groupId, opFolder, liferayAssociato);
            _log.info("Deleting file: " + ANNO + "_" + numeroOrdine + "_" + a.getCentro() + ".pdf");
            DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, associatoFolder.getFolderId(), DDT + "_" + ANNO + "_" + numeroOrdine + "_" + a.getCentro() + ".pdf");

        } catch (PortalException ex) {
            _log.error(ex.getMessage());
//            SessionErrors.add(areq, "error-delete");
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "error-delete");
        }

        ares.setRenderParameter("update", "true");
        ares.setRenderParameter("codiceCliente", codiceCliente);
        ares.setRenderParameter("jspPage", "/jsps/search-ddt.jsp");
    }

    public void deleteInvoice(ActionRequest areq, ActionResponse ares) {
        int anno = ParamUtil.getInteger(areq, "anno");
        int numeroOrdine = ParamUtil.getInteger(areq, "numeroOrdine");
        Long idAssociato = ParamUtil.getLong(areq, "idAssociato");
        String codiceCliente = ParamUtil.getString(areq, "codiceCliente");

        _log.info("Deleting Invoice: " + anno + " " + numeroOrdine + " " + idAssociato);

        try {
            Progressivo createProgressivo = ProgressivoLocalServiceUtil.createProgressivo(new ProgressivoPK(anno, idAssociato, INVOICE_ID, numeroOrdine));

            ProgressivoLocalServiceUtil.addProgressivo(createProgressivo);

            //Elimino righe FAV
            List<RigoDocumento> righeFAV = RigoDocumentoLocalServiceUtil.getFatturaByNumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, FAV);
            for (RigoDocumento rigoDocumento : righeFAV) {
                RigoDocumentoLocalServiceUtil.deleteRigoDocumento(rigoDocumento);
            }
            //Elimino righe FAC
            List<RigoDocumento> righeFAC = RigoDocumentoLocalServiceUtil.getFatturaByNumeroOrdineAnnoAssociato(numeroOrdine, anno, idAssociato, FAC);
            for (RigoDocumento rigoDocumento : righeFAC) {
                RigoDocumentoLocalServiceUtil.deleteRigoDocumento(rigoDocumento);
            }

            TestataDocumentoLocalServiceUtil.deleteTestataDocumento(new TestataDocumentoPK(anno, numeroOrdine, FAV, idAssociato));
            TestataDocumentoLocalServiceUtil.deleteTestataDocumento(new TestataDocumentoPK(anno, numeroOrdine, FAC, idAssociato));

            ThemeDisplay themeDisplay = (ThemeDisplay) areq.getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getLayout().getGroupId();
            long repositoryId = themeDisplay.getScopeGroupId();

            Associato a = AssociatoLocalServiceUtil.fetchAssociato(idAssociato);
            OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
            User liferayAssociato = UserLocalServiceUtil.getUser(a.getIdLiferay());
            User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
            DLFolder opFolder = getOpFolder(groupId, liferayOp);
            DLFolder associatoFolder = getAssociatoFolder(groupId, opFolder, liferayAssociato);
            _log.info("Deleting file: " + FAV + "_" + ANNO + "_" + numeroOrdine + "_" + a.getCentro() + ".pdf");
            DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, associatoFolder.getFolderId(), FAV + "_" + ANNO + "_" + numeroOrdine + "_" + a.getCentro() + ".pdf");

        } catch (PortalException ex) {
            _log.error(ex.getMessage());
//            SessionErrors.add(areq, "error-delete");
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "error-delete");
        }

        ares.setRenderParameter("update", "true");
        ares.setRenderParameter("codiceCliente", codiceCliente);
        ares.setRenderParameter("jspPage", "/jsps/search-invoice.jsp");
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException {
//        System.out.println("#############AJAX CALL####################");

        String resourceID = resourceRequest.getResourceID();

        Gson gson = new Gson();
        PrintWriter writer;
        Response response = new Response();
        resourceResponse.setContentType(MediaType.APPLICATION_JSON);
        Associato associato;
        OrganizzazioneProduttori op;
        Report r;
        int nDoc;
        boolean update;
        boolean send;

        switch (CommandID.valueOf(resourceID)) {
            case modify: {
                writer = resourceResponse.getWriter();
                try {
                    associato = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
                    response = saveDDT(resourceRequest, associato, true);
                } catch (JSONException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.PARSING_JSON_ERROR, -1);
                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
                    writer.print(response);
                } catch (NoSuchAssociatoException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    writer.print(response);
                } catch (PortalException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
                    writer.print(response);
                } catch (ParseException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.DATE_FORMAT_ERROR, -1);
                    writer.print(response);
                }
                writer.print(gson.toJson(response));
                writer.flush();
                writer.close();
                break;
            }

            case save: {
                writer = resourceResponse.getWriter();
                try {
                    associato = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
                    response = saveDDT(resourceRequest, associato, false);
                } catch (JSONException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.PARSING_JSON_ERROR, -1);
                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
//                    writer.print(response);
                } catch (NoSuchAssociatoException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
//                    writer.print(response);
                } catch (PortalException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
//                    writer.print(response);
                } catch (ParseException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.DATE_FORMAT_ERROR, -1);
                }
                writer.print(gson.toJson(response));
                writer.flush();
                writer.close();
                break;
            }
            case print: {

                r = new Report();

                nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
                update = ParamUtil.getBoolean(resourceRequest, "update");
                send = ParamUtil.getBoolean(resourceRequest, "send");

                if (nDoc != 0) {
                    try {
                        associato = AssociatoLocalServiceUtil.findByLiferayId(Integer.parseInt(resourceRequest.getRemoteUser()));
                        op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(associato.getIdOp());
                        String ddt = r.print(nDoc, new Long(associato.getId()).intValue());

                        File file = new File(ddt);
                        InputStream in = new FileInputStream(file);

                        String fileName = addToDL(nDoc, file, resourceRequest, DDT);

                        if (send) {
                            sendEmail(associato, op, nDoc, update, DDT, file, fileName + ".pdf");
                        }

                        HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
                        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
                        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/pdf");
                    } catch (JRException ex) {
                        _log.error(ex.getMessage());
                    } catch (ClassNotFoundException ex) {
                        _log.error(ex.getMessage());
                    } catch (SQLException ex) {
                        _log.error(ex.getMessage());
                    } catch (SystemException ex) {
                        _log.error(ex.getMessage());
                    } catch (PortalException ex) {
                        _log.error(ex.getMessage());
                        ex.printStackTrace();
                    } catch (AddressException ex) {
                        _log.error(ex.getMessage());
//                        response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    }
                }
                break;
            }
            case generateInvoice: {
                writer = resourceResponse.getWriter();
                try {
                    associato = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
                    response = saveInvoice(resourceRequest, associato, false);
//                    sendEmail(associato, op, response.getId(), false, FAV);
                } catch (JSONException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.PARSING_JSON_ERROR, -1);
                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
                    writer.print(response);
                } catch (NoSuchAssociatoException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    writer.print(response);
                } catch (PortalException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
                    writer.print(response);
                } catch (ParseException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.DATE_FORMAT_ERROR, -1);
                }
                writer.print(gson.toJson(response));
                writer.flush();
                writer.close();
                break;
            }
            case printInvoice: {

                r = new Report();

                nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
                update = ParamUtil.getBoolean(resourceRequest, "update");
                send = ParamUtil.getBoolean(resourceRequest, "send");

                if (nDoc != 0) {
                    try {
                        associato = AssociatoLocalServiceUtil.findByLiferayId(Integer.parseInt(resourceRequest.getRemoteUser()));
                        op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(associato.getIdOp());
                        String ddt = r.print(nDoc, new Long(associato.getId()).intValue(), "fav");

                        File file = new File(ddt);
                        InputStream in = new FileInputStream(file);

                        String fileName = addToDL(nDoc, file, resourceRequest, FAV);

                        if (send) {
                            sendEmail(associato, op, nDoc, update, FAV, file, fileName + ".pdf");
                        }

                        HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
                        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
                        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/pdf");
                    } catch (JRException ex) {
                        _log.error(ex.getMessage());
                    } catch (ClassNotFoundException ex) {
                        _log.error(ex.getMessage());
                    } catch (SQLException ex) {
                        _log.error(ex.getMessage());
                    } catch (SystemException ex) {
                        _log.error(ex.getMessage());
//                        ex.printStackTrace();
                    } catch (PortalException ex) {
                        _log.error(ex.getMessage());
                        ex.printStackTrace();
                    } catch (AddressException ex) {
                        _log.error(ex.getMessage());
//                        response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    }
                }
                break;
            }
            case updateInvoice: {
                writer = resourceResponse.getWriter();
                try {
                    associato = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
                    op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(associato.getIdOp());
                    response = saveInvoice(resourceRequest, associato, true);
                    sendEmail(associato, op, response.getId(), true, FAV);
                } catch (JSONException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.PARSING_JSON_ERROR, -1);
                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
                    writer.print(response);
                } catch (NoSuchAssociatoException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    writer.print(response);
                } catch (PortalException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
                    writer.print(response);
                } catch (AddressException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    writer.print(response);
                } catch (ParseException ex) {
                    _log.error(ex.getMessage());
                    response = new Response(Response.Code.DATE_FORMAT_ERROR, -1);
                }
                writer.print(gson.toJson(response));
                writer.flush();
                writer.close();
                break;
            }
            case saveTrace: {
                writer = resourceResponse.getWriter();
                try {
                    associato = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
//                    op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(associato.getIdOp());
                    response = saveTraceability(resourceRequest, associato);
                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    ex.printStackTrace();
                } catch (NoSuchAssociatoException ex) {
                    _log.error(ex.getMessage());
                    ex.printStackTrace();
                } catch (PortalException ex) {
                    _log.error(ex.getMessage());
                    ex.printStackTrace();
                }
                writer.print(gson.toJson(response));
                writer.flush();
                writer.close();
                break;
            }
            case printTrace: {
                r = new Report();

                nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
//                boolean update = ParamUtil.getBoolean(resourceRequest, "update");
                send = ParamUtil.getBoolean(resourceRequest, "send");

                if (nDoc != 0) {
                    try {
                        associato = AssociatoLocalServiceUtil.findByLiferayId(Integer.parseInt(resourceRequest.getRemoteUser()));
                        op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(associato.getIdOp());
                        String trace = r.printTrace(ANNO, nDoc, new Long(associato.getId()).intValue(), TRAC);

                        File file = new File(trace);
                        InputStream in = new FileInputStream(file);

                        String fileName = addToDL(nDoc, file, resourceRequest, TRAC);
                        if (send) {
                            sendEmail(associato, op, nDoc, false, TRAC, file, fileName + ".pdf");
                        }

                        HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
                        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
                        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/pdf");
                    } catch (JRException ex) {
                        _log.error(ex.getMessage());
                    } catch (ClassNotFoundException ex) {
                        _log.error(ex.getMessage());
                    } catch (SQLException ex) {
                        _log.error(ex.getMessage());
                    } catch (SystemException ex) {
                        _log.error(ex.getMessage());
//                        ex.printStackTrace();
                    } catch (PortalException ex) {
                        _log.error(ex.getMessage());
                        ex.printStackTrace();
                    } catch (AddressException ex) {
                        _log.error(ex.getMessage());
//                        response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
//                    writer.print(response);
                    }
                }

                break;
            }
            default:
                _log.warn("Uknown operation.");
        }
    }

    private void sendEmail(Associato a, OrganizzazioneProduttori o, int numeroOrdine, boolean update, String tipoDocumento) throws AddressException {
        sendEmail(a, o, numeroOrdine, update, tipoDocumento, null, "");
    }

    private void sendEmail(Associato a, OrganizzazioneProduttori o, int numeroOrdine, boolean update, String tipoDocumento, File f, String fn) throws AddressException {
        MailMessage mailMessage = new MailMessage();
        String articolo = "";
        if (tipoDocumento.equals(DDT)) {
            articolo = "il DDT";
        } else if (tipoDocumento.equals(FAV)) {
            articolo = "la fattura";
        } else if (tipoDocumento.equals(TRAC)) {
            articolo = "l'allegato di tracciabilita' relativo al DDT";
        }
        String action = update ? "\nha appena modificato " + articolo + ": " : "\nha appena creato " + articolo + ": ";
        String subject = update ? "Notifica modifica documento." : "Notifica creazione documento.";
        mailMessage.setBody("Spett. " + o.getRagioneSociale()
                + "\n\nLa presente per informarla che l'associato: " + a.getRagioneSociale()
                + action + numeroOrdine + "."
                + "\nDistinti saluti."
                + "\n\nP.S. Il presente messagio e' stato generato automaticamente per comunicazione all'associato scrivere all'indirizzo: " + a.getEmail());
        if (f != null) {
            mailMessage.addFileAttachment(f, fn);
        }

        mailMessage.setSubject("[" + o.getRagioneSociale() + "] " + subject);
        mailMessage.setFrom(new InternetAddress(a.getEmail()));
        mailMessage.setTo(new InternetAddress(o.getEmail()));
        MailServiceUtil.sendEmail(mailMessage);
        _log.info(("FROM: " + mailMessage.getFrom().getAddress()));
        _log.info(("TO: " + mailMessage.getTo()[0].getAddress()));
    }

    private String addToDL(int nDoc, File ddt, ResourceRequest resourceRequest, String tipoDocumento) throws SystemException, PortalException, FileNotFoundException {

        Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
        User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
        User liferayAssociato = UserLocalServiceUtil.getUser(a.getIdLiferay());
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getLayout().getGroupId();
        long repositoryId = themeDisplay.getScopeGroupId();
        DLFolder opFolder = getOpFolder(groupId, liferayOp);
//        _log.info("OP FOLDER: " + opFolder);
        DLFolder associatofolder = getAssociatoFolder(groupId, opFolder, liferayAssociato);
//        _log.info("ASSOCIATO FOLDER: " + associatofolder);
        String fileName = tipoDocumento + "_" + ANNO + "_" + nDoc + "_" + a.getCentro();

        FileEntry fileEntry = null;
        try {
            fileEntry = DLAppServiceUtil.getFileEntry(groupId, associatofolder.getFolderId(), fileName + ".pdf");
            _log.info("Entry found, the file will be replaced.");
        } catch (PortalException e) {
            _log.info("File Entry not found, a new file will be created.");
        }

        if (fileEntry != null) {
            DLAppServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
        }
        fileEntry = DLAppServiceUtil.addFileEntry(
                repositoryId,
                associatofolder.getFolderId(),
                fileName + ".pdf",
                MimeTypesUtil.getContentType(fileName + ".pdf"),
                fileName + ".pdf", "", "", ddt, new ServiceContext());

        _log.info("Added: " + fileEntry.getTitle() + " to: /" + associatofolder.getName());
        DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, fileName);

        return fileName;

    }

    private DLFolder getOpFolder(long groupId, User liferayOp) throws PortalException, SystemException {
        return DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, liferayOp.getScreenName());
    }

    private DLFolder getAssociatoFolder(long groupId, DLFolder opFolder, User liferayAssociato) throws PortalException, SystemException {
        return DLFolderLocalServiceUtil.getFolder(groupId, opFolder.getFolderId(), liferayAssociato.getScreenName());
    }

    private Response saveDDT(ResourceRequest resourceRequest, Associato associato, boolean update) throws SystemException, NoSuchAssociatoException, PortalException, ParseException {

        String string = new String(Base64.decode(ParamUtil.getString(resourceRequest, "data", null)));
        String codiceCliente = ParamUtil.getString(resourceRequest, "codiceCliente", null);
        String cliente = ParamUtil.getString(resourceRequest, "clienteTxt", null);
        String destinazioneTxt = ParamUtil.getString(resourceRequest, "destinazioneTxt", null);
        String codiceDestinazione = ParamUtil.getString(resourceRequest, "codiceDestinazione", null);
        String orderDate = ParamUtil.getString(resourceRequest, "orderDate", null);
        String deliveryDate = ParamUtil.getString(resourceRequest, "deliveryDate", null);
        String lottoTestata = ParamUtil.getString(resourceRequest, "lottoTestata", null);
        String vettore1 = ParamUtil.getString(resourceRequest, "vettore1", null);
        String vettore2 = ParamUtil.getString(resourceRequest, "vettore2", null);
        String autista = ParamUtil.getString(resourceRequest, "autista", null);
        String trasporto = ParamUtil.getString(resourceRequest, "trasporto", null);
        String aspetto = ParamUtil.getString(resourceRequest, "aspetto", null);
        String causale = ParamUtil.getString(resourceRequest, "causale", null);
        String porto = ParamUtil.getString(resourceRequest, "porto", null);
        String origine = ParamUtil.getString(resourceRequest, "origine", null);
        String rigoDescrittivo = ParamUtil.getString(resourceRequest, "rigo", null);
        double costo = ParamUtil.getDouble(resourceRequest, "costo");
        int pedaneEuro = ParamUtil.getInteger(resourceRequest, "pedane-euro");
        int pedaneNormali = ParamUtil.getInteger(resourceRequest, "pedane-normali");
        String motrice = ParamUtil.getString(resourceRequest, "motrice", null);
        String rimorchio = ParamUtil.getString(resourceRequest, "rimorchio", null);
        String numeroOrdineStr = ParamUtil.getString(resourceRequest, "numeroOrdine", null);
        int avanzaProtocollo = ParamUtil.getInteger(resourceRequest, "avanzaProtocollo", -1);

        int numeroOrdine;

        if (!numeroOrdineStr.equals("")) {
            numeroOrdine = Integer.parseInt(numeroOrdineStr);
            if (!update) { //RECUPERO PROTOCOLLO
                ProgressivoLocalServiceUtil.deleteProgressivo(new ProgressivoPK(Calendar.getInstance().get(Calendar.YEAR), associato.getId(), DDT_ID, numeroOrdine));
            }
        } else if (avanzaProtocollo == -1) { //AVANZAMENTO PROTOCOLLO MANUALE
            try {
//                numeroOrdine = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DDT, associato.getId()).size() + 1;
                numeroOrdine = (int) TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DDT, associato.getId()).get(0).getNumeroOrdine() + 1;
            } catch (SystemException ex) {
                _log.error(ex.getMessage());
                return new Response(Response.Code.GET_PRIMARY_KEY_ERROR, -1);
            }
        } else { //AVANZAMENTO PROTOCOLLO MANUALE
            List<TestataDocumento> testate = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DDT, associato.getId());
            TestataDocumento t = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ANNO, avanzaProtocollo, DDT, associato.getId()));
            if (t != null) {
                _log.warn("Protocol already exists.");
                return new Response(Response.Code.ALREADY_EXISTS, avanzaProtocollo);
            }
            for (TestataDocumento testata : testate) {
                if (avanzaProtocollo < testata.getNumeroOrdine()) {
                    String dataTestataStr = testata.getDataOrdine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Date dataTestata = sdf.parse(dataTestataStr);
                    Date dataDocumento = sdf.parse(orderDate);
                    if (dataDocumento.after(dataTestata) || dataDocumento.equals(dataTestata)) {
                        return new Response(Response.Code.NOT_VALID, avanzaProtocollo);
                    }
                }
            }
            numeroOrdine = avanzaProtocollo;
        }

        TestataDocumento testataDocumento;
        if (update) {
            testataDocumento = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ANNO, numeroOrdine, DDT, associato.getId()));
        } else {
            testataDocumento = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(ANNO, numeroOrdine, DDT, associato.getId()));
        }
        testataDocumento.setAnno(ANNO);
        testataDocumento.setCodiceSoggetto(codiceCliente);
        testataDocumento.setRagioneSociale(cliente);
        testataDocumento.setCodiceDestinazione(codiceDestinazione);
        testataDocumento.setDestinazione(destinazioneTxt);
        testataDocumento.setDataOrdine(orderDate);
        testataDocumento.setDataConsegna(deliveryDate);
        testataDocumento.setLotto(lottoTestata);
        testataDocumento.setCompleto("completo");
        testataDocumento.setOperatore(resourceRequest.getRemoteUser());
        testataDocumento.setVettore(vettore1);
        testataDocumento.setVettore2(vettore2);
        testataDocumento.setAutista(autista);
        testataDocumento.setCuraTrasporto(trasporto);
        testataDocumento.setAspettoEsteriore(aspetto);
        testataDocumento.setCausaleTrasporto(causale);
        testataDocumento.setPorto(porto);
        testataDocumento.setOrigine(origine);
        testataDocumento.setRigoDescrittivo(rigoDescrittivo);
        testataDocumento.setCostoTrasporto(costo);
        testataDocumento.setNumeroPedaneEuro(pedaneEuro);
        testataDocumento.setNumeroPedaneNormali(pedaneNormali);
        testataDocumento.setTargaCamion(motrice);
        testataDocumento.setTargaRimorchio(rimorchio);

        _log.info("Testata Documento: " + testataDocumento);

//        List<RigoDocumento> righe;
        if (update) {
            TestataDocumentoLocalServiceUtil.updateTestataDocumento(testataDocumento);
//            righe = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(numeroOrdine, ANNO, associato.getId());
        } else {
            TestataDocumentoLocalServiceUtil.addTestataDocumento(testataDocumento);
        }

        JSONArray rowsJSON = JSONFactoryUtil.createJSONArray(string);
        for (int i = 0; i < rowsJSON.length(); i++) {

            JSONObject rowJSON = rowsJSON.getJSONObject(i);
            RigoDocumento rigo = JSONFactoryUtil.looseDeserialize(rowJSON.toString(), RigoDocumentoImpl.class);

            String[] tmp = rigo.getDescrizioneVariante().split("-");

            if (tmp.length != 0) {
                rigo.setDescrizioneVariante(tmp[0].trim());
            }

            rigo.setAnno(ANNO);

            rigo.setNumeroOrdine(testataDocumento.getNumeroOrdine());
            rigo.setRigoOrdine(i + 1);
            rigo.setGestioneReti(rowJSON.getString("reti").equalsIgnoreCase("si"));
            rigo.setIdAssociato(associato.getId());
            rigo.setTipoDocumento(DDT);
            if (update) {
                _log.info("UPDATING Rigo Documento: " + rigo);
                RigoDocumentoLocalServiceUtil.updateRigoDocumento(rigo);
            } else {
                _log.info("SAVING Rigo Documento: " + rigo);
                RigoDocumentoLocalServiceUtil.addRigoDocumento(rigo);
            }
        }

        return new Response(Response.Code.OK, numeroOrdine);
    }

    private Response saveInvoice(ResourceRequest resourceRequest, Associato associato, boolean update) throws PortalException, SystemException, ParseException {

        String string = new String(Base64.decode(ParamUtil.getString(resourceRequest, "data", null)));
        String codiceCliente = ParamUtil.getString(resourceRequest, "codiceCliente", null);
        String cliente = ParamUtil.getString(resourceRequest, "clienteTxt", null);
        String destinazioneTxt = ParamUtil.getString(resourceRequest, "destinazioneTxt", null);
        String codiceDestinazione = ParamUtil.getString(resourceRequest, "codiceDestinazione", null);
        String documentDate = ParamUtil.getString(resourceRequest, "documentDate", null);
        String numeroFatturaStr = ParamUtil.getString(resourceRequest, "numeroFattura", null);
        int avanzaProtocollo = ParamUtil.getInteger(resourceRequest, "avanzaProtocollo", -1);

        long origDoc = ParamUtil.getLong(resourceRequest, "numeroDocumento", -1);
        String[] origIds = StringUtil.split(ParamUtil.getString(resourceRequest, "documentIds", ""));

        long[] idsToUpdate = new long[]{};

        if (origDoc != -1) {
            idsToUpdate = new long[1];
            idsToUpdate[0] = origDoc;
        } else if (origIds.length != 0) {
            idsToUpdate = new long[origIds.length];
            for (int i = 0; i < origIds.length; i++) {
                idsToUpdate[i] = Long.parseLong(origIds[i]);
            }
        }

        int numeroFattura;

        if (!numeroFatturaStr.equals("")) {
            numeroFattura = Integer.parseInt(numeroFatturaStr);
            if (!update) { //RECUPERO PROTOCOLLO
                ProgressivoLocalServiceUtil.deleteProgressivo(new ProgressivoPK(Calendar.getInstance().get(Calendar.YEAR), associato.getId(), INVOICE_ID, numeroFattura));
            }
        } else if (avanzaProtocollo == -1) { //AVANZAMENTO AUTOMATICO PROTOCOLLO
//            numeroFattura = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), FAV, associato.getId()).size() + 1;
            try {
                numeroFattura = (int) (TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), FAV, associato.getId()).get(0).getNumeroOrdine() + 1);
            } catch (SystemException ex) {
                _log.error(ex.getMessage());
                return new Response(Response.Code.GET_PRIMARY_KEY_ERROR, -1);
            }
        } else { //AVANZAMENTO PROTOCOLLO MANUALE
            List<TestataDocumento> testate = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), FAV, associato.getId());
            TestataDocumento t = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ANNO, avanzaProtocollo, FAV, associato.getId()));
            if (t != null) {
                _log.warn("Protocol already exists.");
                return new Response(Response.Code.ALREADY_EXISTS, avanzaProtocollo);
            }
            for (TestataDocumento testata : testate) {
                if (avanzaProtocollo < testata.getNumeroOrdine()) {
                    String dataTestataStr = testata.getDataOrdine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Date dataTestata = sdf.parse(dataTestataStr);
                    Date dataDocumento = sdf.parse(documentDate);
                    if (dataDocumento.after(dataTestata) || dataDocumento.equals(dataTestata)) {
                        return new Response(Response.Code.NOT_VALID, avanzaProtocollo);
                    }
                }
            }
            numeroFattura = avanzaProtocollo;
        }

//        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(associato.getIdOp());
        TestataDocumento sellInvoice = null;
        if (update) {
            sellInvoice = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ANNO, origDoc, FAV, associato.getId()));
        } else {
            sellInvoice = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(ANNO, numeroFattura, FAV, associato.getId()));
        }

        sellInvoice.setCodiceSoggetto(codiceCliente);
        sellInvoice.setRagioneSociale(cliente);
        sellInvoice.setCodiceDestinazione(codiceDestinazione);
        sellInvoice.setDestinazione(destinazioneTxt);
        sellInvoice.setDataOrdine(documentDate);
        sellInvoice.setOperatore(resourceRequest.getRemoteUser());
        sellInvoice.setCompleto(COMPLETED);

        TestataDocumento purchaseInvoice;

        if (update) {
            purchaseInvoice = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ANNO, origDoc, FAC, associato.getId()));
        } else {
            purchaseInvoice = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(ANNO, numeroFattura, FAC, associato.getId()));
        }

        purchaseInvoice.setCodiceSoggetto(String.valueOf(associato.getIdLiferay()));
        purchaseInvoice.setRagioneSociale(associato.getRagioneSociale());
        purchaseInvoice.setDestinazione(associato.getIndirizzo());
        purchaseInvoice.setDataOrdine(documentDate);
        purchaseInvoice.setOperatore(resourceRequest.getRemoteUser());
        purchaseInvoice.setCompleto(COMPLETED);

        List<TestataDocumento> invoices = new ArrayList<TestataDocumento>();

        invoices.add(sellInvoice);
        invoices.add(purchaseInvoice);

        JSONArray rowsJSON = JSONFactoryUtil.createJSONArray(string);
        for (TestataDocumento invoice : invoices) {
            _log.info("Fattura: " + invoice);
            if (update) {
                TestataDocumentoLocalServiceUtil.updateTestataDocumento(invoice);
            } else {
                TestataDocumentoLocalServiceUtil.addTestataDocumento(invoice);
            }
            for (int i = 0; i < rowsJSON.length(); i++) {

                JSONObject rowJSON = rowsJSON.getJSONObject(i);
                RigoDocumento rigo = JSONFactoryUtil.looseDeserialize(rowJSON.toString(), RigoDocumentoImpl.class);

                rigo.setAnno(ANNO);
                rigo.setNumeroOrdine(invoice.getNumeroOrdine());
                rigo.setRigoOrdine(i + 1);
                rigo.setTipoDocumento(invoice.getTipoDocumento());
                rigo.setIdAssociato(associato.getId());

                if (update) {
                    _log.info("UPDATING Rigo FATTURA: " + rigo);
                    RigoDocumentoLocalServiceUtil.updateRigoDocumento(rigo);
                } else {
                    _log.info("ADDING Rigo FATTURA: " + rigo);
                    RigoDocumentoLocalServiceUtil.addRigoDocumento(rigo);

                    for (int j = 0; j < idsToUpdate.length; j++) {
                        TestataDocumento origDDT = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ANNO, idsToUpdate[j], DDT, associato.getId()));
                        origDDT.setCompleto(INVOICED);
                        _log.info("Updating DDT: " + origDDT);
                        TestataDocumentoLocalServiceUtil.updateTestataDocumento(origDDT);
                    }
                }
            }

        }

        return new Response(Response.Code.OK, numeroFattura);

    }

    private Response saveTraceability(ResourceRequest resourceRequest, Associato a) throws JSONException, SystemException {

        String string = new String(Base64.decode(ParamUtil.getString(resourceRequest, "data", null)));

        JSONObject objectJson = JSONFactoryUtil.createJSONObject(string);
        _log.info(objectJson);
        JSONArray schedeJson = objectJson.getJSONArray("scheda");

        for (int i = 0; i < schedeJson.length(); i++) {
            JSONObject schedaJson = schedeJson.getJSONObject(i);

            long id = CounterLocalServiceUtil.increment(TracciabilitaScheda.class.getName());
            TracciabilitaScheda scheda = TracciabilitaSchedaLocalServiceUtil.createTracciabilitaScheda((int) id);
            scheda.setCodiceProdotto(schedaJson.getString("codiceProdotto"));
            scheda.setProdottoVenduto(schedaJson.getString("prodottoVenduto"));
            scheda.setKgVenduti(Double.parseDouble(schedaJson.getString("kgVenduti")));
            scheda.setLottoVendita(schedaJson.getString("lottoVendita"));
            scheda.setAnno(ANNO);
            scheda.setNumeroDocumento(Long.parseLong(schedaJson.getString("numeroDocumento")));
            scheda.setRigoOrdine(Integer.parseInt(schedaJson.getString("rigoOrdine")));
            scheda.setTipoDocumento(DDT);
            scheda.setIdAssociato(a.getId());

            JSONArray grezziJson = schedaJson.getJSONArray("grezzi");
            List<TracciabilitaGrezzi> listGrezzi = new ArrayList<TracciabilitaGrezzi>();
            for (int j = 0; j < grezziJson.length(); j++) {
                JSONObject grezzoJson = grezziJson.getJSONObject(j);

                long idGrezzi = CounterLocalServiceUtil.increment(TracciabilitaGrezzi.class.getName());
                TracciabilitaGrezzi grezzo = TracciabilitaGrezziLocalServiceUtil.createTracciabilitaGrezzi((int) idGrezzi);

                grezzo.setFoglio(Integer.parseInt(grezzoJson.getString("foglio")));
                grezzo.setKg(Double.parseDouble(grezzoJson.getString("kg")));
                grezzo.setLottoGrezzo(grezzoJson.getString("lottoGrezzo"));
                grezzo.setParticella(Integer.parseInt(grezzoJson.getString("particella")));
                grezzo.setProdotto(grezzoJson.getString("prodotto"));
                grezzo.setProduttore(grezzoJson.getString("produttore"));
                grezzo.setIdSchedaTracciabilta((int) id);

                listGrezzi.add(grezzo);
            }
            _log.info("SAVING: " + scheda);
            TracciabilitaSchedaLocalServiceUtil.addTracciabilitaScheda(scheda);
            for (TracciabilitaGrezzi grezzoToSave : listGrezzi) {
                _log.info("SAVING: " + grezzoToSave);
                TracciabilitaGrezziLocalServiceUtil.addTracciabilitaGrezzi(grezzoToSave);
            }
        }

        return new Response(Response.Code.OK, 0);
    }
}
