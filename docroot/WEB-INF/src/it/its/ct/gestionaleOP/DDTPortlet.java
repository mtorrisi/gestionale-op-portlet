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
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import com.liferay.util.bridges.mvc.MVCPortlet;
import it.bysoftware.ct.model.Articoli;
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.model.impl.RigoDocumentoImpl;
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoServiceUtil;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;
import it.its.ct.gestionaleOP.report.Report;
import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.ws.rs.core.MediaType;
import net.sf.jasperreports.engine.JRException;

public class DDTPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(DDTPortlet.class);

    public enum CommandID {

        save, print;
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
            List<Articoli> imballaggi = ArticoliLocalServiceUtil.getImballaggi();
            _log.info(imballaggi.size());
            for (Articoli articoli1 : imballaggi) {
                _log.info("IMBALLAGGIO: " + articoli1.getDescrizione() + " cat: " + articoli1.getCategoriaMerceologica());
            }

//            List<Articoli> searchArticoli = ArticoliLocalServiceUtil.searchArticoli("ARMO", true, 0, 105, null);
//            _log.info(searchArticoli.size());
//            for (Articoli searchArticoli1 : searchArticoli) {
//                _log.info(searchArticoli1.getCodiceArticolo());
//            }
        } catch (SystemException ex) {
            _log.error(ex);
        }
    }

    @Override
    public void processAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        PortletPreferences prefs = actionRequest.getPreferences();
        String greeting = actionRequest.getParameter("greeting");

        if (greeting != null) {
            prefs.setValue("greeting", greeting);
            prefs.store();
        }
        SessionMessages.add(actionRequest, "success");

        super.processAction(actionRequest, actionResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException {
//        System.out.println("#############AJAX CALL####################");

        String resourceID = resourceRequest.getResourceID();

        resourceResponse.setContentType(MediaType.APPLICATION_JSON);
        PrintWriter writer = resourceResponse.getWriter();

        switch (CommandID.valueOf(resourceID)) {
            case save:
                String string = new String(Base64.decode(ParamUtil.getString(resourceRequest, "data", null)));
                String codiceCliente = ParamUtil.getString(resourceRequest, "codiceCliente", null);
                String cliente = ParamUtil.getString(resourceRequest, "clienteTxt", null);
                String destinazioneTxt = ParamUtil.getString(resourceRequest, "destinazioneTxt", null);
                String codiceDestinazione = ParamUtil.getString(resourceRequest, "codiceDestinazione", null);
                String orderDate = ParamUtil.getString(resourceRequest, "orderDate", null);
                String deliveryDate = ParamUtil.getString(resourceRequest, "deliveryDate", null);
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

                try {
                    
                    
                    TestataDocumento testataDocumento = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(Calendar.getInstance().get(Calendar.YEAR), CounterLocalServiceUtil.increment(TestataDocumento.class.getName())));

                    testataDocumento.setCodiceSoggetto(codiceCliente);
                    testataDocumento.setRagioneSociale(cliente);
                    testataDocumento.setCodiceDestinazione(codiceDestinazione);
                    testataDocumento.setDestinazione(destinazioneTxt);
                    testataDocumento.setDataOrdine(orderDate);
                    testataDocumento.setDataConsegna(deliveryDate);
                    testataDocumento.setCompleto("no");
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
                        rigo.setAnno(Calendar.getInstance().get(Calendar.YEAR));
                        rigo.setNumeroOrdine(testataDocumento.getNumeroOrdine());
                        rigo.setRigoOrdine(i+1);
                        rigo.setGestioneReti(rowJSON.getString("reti").equalsIgnoreCase("si"));

                        _log.info("Rigo Documento: " + rigo);
//                        RigoDocumentoLocalServiceUtil.addRigoDocumento(rigo);
                    }

                } catch (JSONException ex) {
                    _log.error("JSONException: " + ex.getLocalizedMessage());
                } catch (SystemException ex) {
                     _log.error("ERRORE: " + ex.getLocalizedMessage());
                }
                break;
            case print:

                Report r = new Report();

                try {
                    r.print();

                    ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
                    Long groupId = themeDisplay.getLayout().getGroupId();
                    DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "test");

                    ServiceContext serviceContext = ServiceContextFactory.getInstance(DDTPortlet.class.getName(), resourceRequest);
                    User currentUser = PortalUtil.getUser(resourceRequest);
                    DLAppLocalServiceUtil.addFileEntry(currentUser.getUserId(), groupId, folder.getFolderId(), "/home/mario/test/report.pdf", new MimetypesFileTypeMap().getContentType("/home/mario/test/report.pdf"), "DDT.pdf", "DDT PRINTED OUT", "LOG MARIO", new File("/home/mario/test/report.pdf"), serviceContext);
                    _log.info("TEST");
                    String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "//" + folder.getFolderId() + "//" + HttpUtil.encodeURL(HtmlUtil.unescape("DDT.pdf"));
                    _log.info(fileUrl);
                } catch (ClassNotFoundException ex) {
                    _log.error(ex.getLocalizedMessage());
                } catch (JRException ex) {
                    _log.error(ex.getLocalizedMessage());
                } catch (SQLException ex) {
                    _log.error(ex.getLocalizedMessage());
                } catch (PortalException ex) {
                    Logger.getLogger(DDTPortlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SystemException ex) {
                    Logger.getLogger(DDTPortlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                _log.warn("Uknown operation.");
        }
        writer.print("ID: " + resourceID);

        writer.flush();
        writer.close();
//        super.serveResource(resourceRequest, resourceResponse);
    }
}
