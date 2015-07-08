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
import it.bysoftware.ct.model.impl.RigoDocumentoImpl;
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.VettoriLocalServiceUtil;
import it.its.ct.gestionaleOP.report.Report;
import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
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

        try {

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
                _log.info("DATA: " + string + "\nCodiceCliente: " + codiceCliente);
                 {

                    try {

                        JSONArray JSONArray = JSONFactoryUtil.createJSONArray(string);
                        JSONObject obj = JSONArray.getJSONObject(0);
                        obj.getString("gestioneReti");
                        RigoDocumento rigo = JSONFactoryUtil.looseDeserialize(obj.toString(), RigoDocumentoImpl.class);
                        rigo.setAnno(2015);
                        rigo.setNumeroOrdine(1000);
                        rigo.setRigoOrdine(1);
                        rigo.setGestioneReti(obj.getString("reti").equalsIgnoreCase("si"));
                        _log.info("****************** rigo: " + rigo + " *********************");
//                        RigoDocumentoLocalServiceUtil.addRigoDocumento(rigo);
                    } catch (JSONException ex) {
//                        Logger.getLogger(DDTPortlet.class.getName()).log(Level.SEVERE, null, ex);
                        _log.error("JSONException: " + ex.getLocalizedMessage());
                    }
//                    catch (SystemException ex) {
////                        Logger.getLogger(DDTPortlet.class.getName()).log(Level.SEVERE, null, ex);
//                        _log.error("SystemException: " + ex.getLocalizedMessage());
//                    }

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
