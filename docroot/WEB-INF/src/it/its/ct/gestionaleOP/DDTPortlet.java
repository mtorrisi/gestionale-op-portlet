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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import com.liferay.util.bridges.mvc.MVCPortlet;
import it.bysoftware.ct.model.Anagrafica;
import it.bysoftware.ct.model.Articoli;
import it.bysoftware.ct.model.DestinatariDiversi;
import it.bysoftware.ct.service.AnagraficaLocalServiceUtil;
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil;
import java.io.PrintWriter;
import java.util.List;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class DDTPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(DDTPortlet.class);

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
        
        resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();

        writer.print("ID: " + resourceID);

        writer.flush();
        writer.close();
        
//        super.serveResource(resourceRequest, resourceResponse);
    }
}
