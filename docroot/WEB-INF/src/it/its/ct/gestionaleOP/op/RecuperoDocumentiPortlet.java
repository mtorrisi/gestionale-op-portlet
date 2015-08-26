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
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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
        in.close();
//
//        } else {
//            _log.warn("Unknown resource id.");
//        }
//
//        writer.flush();
//        writer.close();
    }

    private String creaFileTracciato(String utente) {

        File file = new File("/tmp/documenti.txt");
        // if file doesnt exists, then create it

        FileWriter fw;
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                Path path = FileSystems.getDefault().getPath("/tmp/", "documenti.txt");
                boolean success = Files.deleteIfExists(path);
                _log.info("Deleted documenti.txt");
            }
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            List<TestataDocumento> list = TestataDocumentoLocalServiceUtil.getByCodiceOperatore(utente, "completo", 0);
            for (TestataDocumento testata : list) {
                _log.info(testata);

                String stringTestata = "WorkTestataDocumento;Tipdoc;Datreg;Codsog;Codspe;Codpor;Codase;Codve1;Codve2;Numdoc;Protoc;Datdoc\n";
                bw.write(stringTestata);
                //DDT;03/07/2015;F0009;;;;;;0;24;03/07/2015
                String valoriTestata = "FAV" + SEPARATOR;
                String dataReg = testata.getDataOrdine() + SEPARATOR;//sdf.format(new Timestamp(date.getTime())) + SEPARATOR;
                String codSog = testata.getCodiceSoggetto() + SEPARATOR;
                String codSpe = SEPARATOR;
                String codPor = testata.getPorto() + SEPARATOR;
                String codAse = testata.getAspettoEsteriore() + SEPARATOR;
                String codVe1 = testata.getCodiceVettore() + SEPARATOR;
                String codVe2 = testata.getVettore2() + SEPARATOR;
                String numDoc = testata.getNumeroOrdine() + SEPARATOR;
                String protoc = SEPARATOR;
                String dataDoc = testata.getDataOrdine();//sdf.format(new Timestamp(date.getTime()));

                valoriTestata += dataReg + codSog + codSpe + codPor + codAse + codVe1 + codVe2 + numDoc + protoc + dataDoc + "\n";

                bw.write(valoriTestata);

//              CodlottoGR
                String stringRigo = "WorkRigaDocumento;Tiprig;Codart;Codvar;Quanet;Qm2net;Prezzo;Libstr1;Libstr2;Libstr3;Libdbl1;Libdbl2;Libdbl3;Liblng1;Liblng2;Liblng3;Libdat1;Libdat2;Libdat3;CodLotto;CodlottoGR\n";
                bw.write(stringRigo);
                List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getByNumeroOrdineAnno(testata.getNumeroOrdine(), testata.getAnno());
                for (RigoDocumento rigo : righe) {
//                    _log.info(rigo);
                    String valoriRigo = "";
                    //VALORI RIGO ARTICOLO
                    String Tiprig = "0" + SEPARATOR;
                    String Codart = rigo.getCodiceArticolo() + SEPARATOR;
                    String Codvar = SEPARATOR;
                    String Quanet = rigo.getPesoNetto() + SEPARATOR;
                    String Qm2net = rigo.getTara() + SEPARATOR;
                    String Prezzo = rigo.getPrezzo() + SEPARATOR;
                    String Libstr1 = SEPARATOR;
                    String Libstr2 = SEPARATOR;
                    String Libstr3 = SEPARATOR;
                    String Libdbl1 = rigo.getPesoLordo() + SEPARATOR;
                    String Libdbl2 = "1" + SEPARATOR;
                    String Libdbl3 = "0" + SEPARATOR;
                    String Liblng1 = "0" + SEPARATOR;
                    String Liblng2 = "0" + SEPARATOR;
                    String Liblng3 = "0" + SEPARATOR;
                    String Libdat1 = testata.getDataOrdine() + SEPARATOR;
                    String Libdat2 = "00:00:00" + SEPARATOR;
                    String Libdat3 = rigo.getLotto() + SEPARATOR;
                    String CodlottoGR = SEPARATOR;

                    valoriRigo = Tiprig + Codart + Codvar + Quanet + Qm2net + Prezzo + Libstr1 + Libstr2 + Libstr3 + Libdbl1 + Libdbl2 + Libdbl3 + Liblng1 + Liblng2 + Liblng3 + Libdat1 + Libdat2 + Libdat3 + CodlottoGR + "\n";

                    //VALORI RIGO IMBALLO
                    Tiprig = "0" + SEPARATOR;
                    Codart = rigo.getImballo() + SEPARATOR;
                    Codvar = SEPARATOR;
                    Quanet = "40" + SEPARATOR;
                    Qm2net = "40" + SEPARATOR;
                    Prezzo = "0" + SEPARATOR;
                    Libstr1 = SEPARATOR;
                    Libstr2 = SEPARATOR;
                    Libstr3 = SEPARATOR;
                    Libdbl1 = "0" + SEPARATOR;
                    Libdbl2 = "0" + SEPARATOR;
                    Libdbl3 = "0" + SEPARATOR;
                    Liblng1 = "0" + SEPARATOR;
                    Liblng2 = "0" + SEPARATOR;
                    Liblng3 = "0" + SEPARATOR;
                    Libdat1 = testata.getDataOrdine() + SEPARATOR;
                    Libdat2 = "00:00:00" + SEPARATOR;
                    Libdat3 = SEPARATOR;
                    CodlottoGR = SEPARATOR;

                    valoriRigo += Tiprig + Codart + Codvar + Quanet + Qm2net + Prezzo + Libstr1 + Libstr2 + Libstr3 + Libdbl1 + Libdbl2 + Libdbl3 + Liblng1 + Liblng2 + Liblng3 + Libdat1 + Libdat2 + Libdat3 + CodlottoGR + "\n";
                    bw.write(valoriRigo);
                }
                testata.setInviato(1); // SETTO INVIATO A 1
                TestataDocumentoLocalServiceUtil.updateTestataDocumento(testata);
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
