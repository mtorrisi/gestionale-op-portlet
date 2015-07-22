/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.op;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mario
 */
public class RecuperoDocumentiPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(RecuperoDocumentiPortlet.class);
    private static final String SEPARATOR = ";";

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        _log.info("doView()");
        super.doView(renderRequest, renderResponse); //To change body of generated methods, choose Tools | Templates.
//        try {
//
//            List<User> users = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
//
//            for (User user : users) {
//                _log.info(user.getUserId());
//            }
//        } catch (SystemException ex) {
//            Logger.getLogger(RecuperoDocumentiPortlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException {

        String tracciato = creaFileTracciato(ParamUtil.getString(resourceRequest, "userId", null));
//        System.out.println("#############AJAX CALL####################");

//        String resourceID = resourceRequest.getResourceID();
//        PrintWriter writer = resourceResponse.getWriter();
//        if (resourceID.equalsIgnoreCase("download")) {
//            String userId = ParamUtil.getString(resourceRequest, "userId", null);
//            resourceResponse.setContentType(MediaType.APPLICATION_JSON);
//            writer.write(userId);
            File file = new File(tracciato);
            InputStream in = new FileInputStream(file);
            HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
            HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
            ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/download");
//
//            in.close();
//
//        } else {
//            _log.warn("Unknown resource id.");
//        }
//
//        writer.flush();
//        writer.close();
    }

    private String creaFileTracciato(String utente) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");

        File file = new File("/tmp/" + utente + "_" + sdf.format(new Timestamp(date.getTime())) + ".txt");
        // if file doesnt exists, then create it

        FileWriter fw;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            List<TestataDocumento> list = TestataDocumentoLocalServiceUtil.getByCodiceOperatore(utente, "completo", 0);
            for (TestataDocumento testata : list) {
                _log.info(testata);

                
                String stringTestata = "WorkTestataDocumento;Tipdoc;Datreg;Codsog;Codspe;Codpor;Codase;Codve1;Codve2;Numdoc;Protoc;Datdoc\n";
                bw.write(stringTestata);
                //DDT;03/07/2015;F0009;;;;;;0;24;03/07/2015
                String valoriTestata ="DDT;";
                sdf = new SimpleDateFormat("dd/MM/yyyy");
                String dataReg = sdf.format(new Timestamp(date.getTime())) + SEPARATOR;
                String codSog = testata.getCodiceSoggetto() + SEPARATOR;
                String codSpe = SEPARATOR;
                String codPor = testata.getPorto() + SEPARATOR;
                String codAse = testata.getAspettoEsteriore() + SEPARATOR;
                String codVe1 = testata.getCodiceVettore() + SEPARATOR;
                String codVe2 = testata.getVettore2() + SEPARATOR;
                String numDoc = testata.getNumeroOrdine() + SEPARATOR;
                String protoc= SEPARATOR;
                String dataDoc = sdf.format(new Timestamp(date.getTime()));
                
                valoriTestata += dataReg + codSog + codSpe +codPor + codAse + codVe1 +codVe2 + numDoc + protoc + dataDoc + "\n";
                
                bw.write(valoriTestata);
                
//                List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.
            }

            bw.close();
        } catch (IOException ex) {
            _log.error("Error creating file: " + file.getName() + "\n" + ex.getLocalizedMessage());
        } catch (SystemException ex) {
            _log.error(ex.getLocalizedMessage());
        }

        return file.getAbsolutePath();
    }
}
