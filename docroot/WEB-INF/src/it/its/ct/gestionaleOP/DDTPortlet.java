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
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.model.impl.RigoDocumentoImpl;
import it.bysoftware.ct.service.AnagraficaLocalServiceUtil;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;
import it.its.ct.gestionaleOP.pojos.Response;
import it.its.ct.gestionaleOP.report.Report;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    public enum CommandID {

        save, print, send;
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        super.doView(renderRequest, renderResponse);
        long idMax = 0;
        ArrayList<Long> idToRecover = new ArrayList<Long>();
        try {

            List<TestataDocumento> listTestata = TestataDocumentoLocalServiceUtil.getTestataDocumentos(0, TestataDocumentoLocalServiceUtil.getTestataDocumentosCount());

            for (TestataDocumento testata : listTestata) {
                _log.info("ID: " + testata.getNumeroOrdine());
                if ((testata.getNumeroOrdine() - 1) != idMax) {
                    idToRecover.add(testata.getNumeroOrdine() - 1);
                }
                if (testata.getNumeroOrdine() > idMax) {
                    idMax = testata.getNumeroOrdine();
                }
            }

            for (Long id : idToRecover) {
                _log.info("IDTORECOVER: " + id);
            }
            _log.info("IDMAX: " + idMax);
            renderRequest.setAttribute("idMax", idMax);

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
//            List<Anagrafica> listClienti = AnagraficaLocalServiceUtil.getClienti();
//            int countClienti = AnagraficaLocalServiceUtil.countClienti();
//            for (Anagrafica cliente : listClienti) {
//                _log.info(cliente.getRagioneSociale());
//            }
//            _log.info(countClienti);
//
//            List<DestinatariDiversi> destinazioni = DestinatariDiversiLocalServiceUtil.getDestinazioni("00003");
//            _log.info(destinazioni.size());
//            for (DestinatariDiversi destinazione : destinazioni) {
//                _log.info(destinazione.getComune());
//            }
//            
//            List<Articoli> articoli = ArticoliLocalServiceUtil.getArticoli();
//            _log.info(articoli.size());
//            for (Articoli articoli1 : articoli) {
//                _log.info("ARTICOLO: " + articoli1.getDescrizione() + " cat: " + articoli1.getCategoriaMerceologica());
//            }
//            List<Articoli> imballaggi = ArticoliLocalServiceUtil.getImballaggi();
//            _log.info(imballaggi.size());
//            for (Articoli articoli1 : imballaggi) {
//                _log.info("IMBALLAGGIO: " + articoli1.getDescrizione() + " cat: " + articoli1.getCategoriaMerceologica());
//            }
//            List<Articoli> searchArticoli = ArticoliLocalServiceUtil.searchArticoli("ARMO", true, 0, 105, null);
//            _log.info(searchArticoli.size());
//            for (Articoli searchArticoli1 : searchArticoli) {
//                _log.info(searchArticoli1.getCodiceArticolo());
//            }
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

    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException {
//        System.out.println("#############AJAX CALL####################");

        String resourceID = resourceRequest.getResourceID();

        switch (CommandID.valueOf(resourceID)) {
            case save:
                Gson gson = new Gson();
                Response response = new Response();
                PrintWriter writer = resourceResponse.getWriter();

                resourceResponse.setContentType(MediaType.APPLICATION_JSON);

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

                int numeroOrdine = 0;
                if (!numeroOrdineStr.equals("")) {
                    numeroOrdine = Integer.parseInt(numeroOrdineStr);
                } else {
                    try {
                        numeroOrdine = TestataDocumentoLocalServiceUtil.getTestataDocumentosCount() + 1;
                    } catch (SystemException ex) {
                        _log.error("ERRORE: " + ex.getLocalizedMessage());
                        response = new Response(Response.Code.GET_PRIMARY_KEY_ERROR, -1);
                    }
                }

                try {
                    int anno = Calendar.getInstance().get(Calendar.YEAR);

                    TestataDocumento testataDocumento = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(anno, numeroOrdine));
                    testataDocumento.setAnno(anno);
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

                    TestataDocumentoLocalServiceUtil.addTestataDocumento(testataDocumento);
                    JSONArray rowsJSON = JSONFactoryUtil.createJSONArray(string);
                    for (int i = 0; i < rowsJSON.length(); i++) {

                        JSONObject rowJSON = rowsJSON.getJSONObject(i);
                        RigoDocumento rigo = JSONFactoryUtil.looseDeserialize(rowJSON.toString(), RigoDocumentoImpl.class);

                        rigo.setAnno(anno);
                        rigo.setNumeroOrdine(testataDocumento.getNumeroOrdine());
                        rigo.setRigoOrdine(i + 1);
                        rigo.setGestioneReti(rowJSON.getString("reti").equalsIgnoreCase("si"));

                        _log.info("Rigo Documento: " + rigo);
                        RigoDocumentoLocalServiceUtil.addRigoDocumento(rigo);
                        response = new Response(Response.Code.OK, numeroOrdine);
                    }
                    Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
                    OrganizzazioneProduttori o = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());

                    sendEmail(a, o, numeroOrdine);
                } catch (JSONException ex) {
                    _log.error("JSONException: " + ex.getLocalizedMessage());
                    response = new Response(Response.Code.PARSING_JSON_ERROR, -1);
                } catch (SystemException ex) {
                    _log.error("ERRORE: " + ex.getLocalizedMessage());
                    response = new Response(Response.Code.INSERT_ERROR, -1);
                    writer.print(response);
                } catch (NoSuchAssociatoException ex) {
                    _log.error("ERRORE: " + ex.getLocalizedMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    writer.print(response);
                } catch (PortalException ex) {
                    _log.error("ERRORE: " + ex.getLocalizedMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    writer.print(response);
                } catch (AddressException ex) {
                    _log.error("ERRORE: " + ex.getLocalizedMessage());
                    response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                    writer.print(response);
                }
                writer.print(gson.toJson(response));
                writer.flush();
                writer.close();
                break;
            case print:

                Report r = new Report();

                int nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
                if (nDoc != 0) {
                    try {
                        String ddt = r.print(nDoc);

                        File file = new File(ddt);
                        InputStream in = new FileInputStream(file);

                        addToDL(nDoc, file, resourceRequest);
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
                        ex.printStackTrace();
                    } catch (PortalException ex) {
                        _log.error(ex.getMessage());
                        ex.printStackTrace();
                    }
                }

                break;

            default:
                _log.warn("Uknown operation.");
        }

//        super.serveResource(resourceRequest, resourceResponse);
    }

    private void sendEmail(Associato a, OrganizzazioneProduttori o, int numeroOrdine) throws AddressException {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setBody("Spett. " + o.getRagioneSociale() + 
                "\n\nLa presente per infromarla che l'associato: " + a.getRagioneSociale() 
                + "\nha appena creato il documento: " + numeroOrdine +"."
                + "\nDistinti saluti."
                + "\n\nP.S. Il presente messagio è stato generato automaticamente per comunicazione all'associato scrivere all'indirizzo: " + a.getEmail());
        mailMessage.setSubject("["+ o.getRagioneSociale() +"] Notifica creazioen documento.");
        mailMessage.setFrom(new InternetAddress(a.getEmail()));
        mailMessage.setTo(new InternetAddress(o.getEmail()));
        MailServiceUtil.sendEmail(mailMessage);
        _log.info(("FROM: " + mailMessage.getFrom().getAddress()));
        _log.info(("TO: " + mailMessage.getTo()[0].getAddress()));
    }

    private void addToDL(int nDoc, File ddt, ResourceRequest resourceRequest) throws SystemException, PortalException, FileNotFoundException {

        Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(resourceRequest.getRemoteUser()));
        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
        User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
        User liferayAssociato = UserLocalServiceUtil.getUser(a.getIdLiferay());
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getLayout().getGroupId();
        long repositoryId = themeDisplay.getScopeGroupId();
        DLFolder opFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, liferayOp.getScreenName());
//        _log.info("OP FOLDER: " + opFolder);
        DLFolder associatofolder = DLFolderLocalServiceUtil.getFolder(groupId, opFolder.getFolderId(), liferayAssociato.getScreenName());
//        _log.info("ASSOCIATO FOLDER: " + associatofolder);
        String fileName = Calendar.getInstance().get(Calendar.YEAR) + "_" + nDoc + "_" + a.getCentro();

        FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
                repositoryId,
                associatofolder.getFolderId(),
                fileName + ".pdf",
                MimeTypesUtil.getContentType(fileName + ".pdf"),
                fileName + ".pdf", "", "", ddt, new ServiceContext());
//
//        Role associateRole = RoleLocalServiceUtil.getRole(liferayAssociato.getCompanyId(), "OP");
//            String[] actionsRW = new String[]{ActionKeys.VIEW};
////            String[] actionsRW = new String[]{ActionKeys.ACCESS, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER, ActionKeys.DELETE, ActionKeys.UPDATE, ActionKeys.VIEW};
//
//            ResourcePermissionLocalServiceUtil.setResourcePermissions(liferayAssociato.getCompanyId(),
//                    FileEntry.class.getName(),
//                    ResourceConstants.SCOPE_INDIVIDUAL,
//                    fileEntry.getTitle(),
//                    associateRole.getRoleId(),
//                    actionsRW);
                    
        _log.info("Added: " + fileEntry.getTitle() + " to: /" + associatofolder.getName());

    }

}
