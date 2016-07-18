/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.op;

import it.bysoftware.ct.NoSuchAssociatoException;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

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

        String tracciato = creaFileTracciato(ParamUtil.getString(resourceRequest, "userId", null), ParamUtil.getInteger(resourceRequest, "inviato", 0), ParamUtil.getString(resourceRequest, "testata", null));
//        System.out.println("#############AJAX CALL####################");

        File file = new File(tracciato);
        InputStream in = new FileInputStream(file);
        HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/download");

        in.close();

    }

    private String creaFileTracciato(String utente, int inviato, String jsonTestata) {

        File file;
        FileWriter fw;
        try {
            Associato a = AssociatoLocalServiceUtil.getAssociato(Long.parseLong(utente));
            file = new File("/tmp/documenti_" + a.getCentro() + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            } else {
                Path path = FileSystems.getDefault().getPath("/tmp/", "documenti_" + a.getCentro() + ".txt");
                boolean success = Files.deleteIfExists(path);
                _log.info("Deleted documenti_" + a.getCentro() + ".txt");
            }
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            List<TestataDocumento> list = new ArrayList<TestataDocumento>();
            if(jsonTestata != null){
            	TestataDocumentoPK testataDocumentoPK = JSONFactoryUtil.looseDeserializeSafe(jsonTestata, TestataDocumentoPK.class);
            	list.add(TestataDocumentoLocalServiceUtil.fetchTestataDocumento(testataDocumentoPK));
            	testataDocumentoPK.setTipoDocumento("FAC");
            	list.add(TestataDocumentoLocalServiceUtil.fetchTestataDocumento(testataDocumentoPK));
            	
            }
            else
            	list = TestataDocumentoLocalServiceUtil.getByCodiceOperatore(String.valueOf(a.getIdLiferay()), "completo", inviato);
            for (TestataDocumento testata : list) {
                _log.info(testata);

                String stringTestata = "WorkTestataDocumento;Tipdoc;Codcen;Datreg;Codsog;Codspe;Codpor;Codase;Codve1;Codve2;Numdoc;Protoc;Datdoc;Datann\n";
                bw.write(stringTestata);
                //DDT;03/07/2015;F0009;;;;;;0;24;03/07/2015
                String valoriTestata = testata.getTipoDocumento() + SEPARATOR;
                String codCen = a.getCentro() + SEPARATOR;
                String dataReg = testata.getDataOrdine() + SEPARATOR;//sdf.format(new Timestamp(date.getTime())) + SEPARATOR;
                String codSog = testata.getCodiceSoggetto() + SEPARATOR;
                String codSpe = SEPARATOR;
                String codPor = testata.getPorto() + SEPARATOR;
                String codAse = testata.getAspettoEsteriore() + SEPARATOR;
                String codVe1 = testata.getCodiceVettore() + SEPARATOR;
                String codVe2 = testata.getVettore2() + SEPARATOR;
                String numDoc = testata.getNumeroOrdine() + SEPARATOR;
                String protoc = testata.getNumeroOrdine() + SEPARATOR;
                String dataDoc = testata.getDataOrdine() + SEPARATOR;
                String Datann = testata.getDataOrdine();

                valoriTestata += codCen + dataReg + codSog + codSpe + codPor + codAse + codVe1 + codVe2 + numDoc + protoc + dataDoc + Datann + "\n";

                bw.write(valoriTestata);

//              CodlottoGR
                String stringRigo = "WorkRigaDocumento;Tiprig;Codart;Codvar;Descri;Quanet;Qm2net;Prezzo;Scont1;Scont2;Scont3;Libstr1;Libstr2;Libstr3;Libdbl1;Libdbl2;Libdbl3;Liblng1;Liblng2;Liblng3;Libdat1;Libdat2;Libdat3;CodLotto;CodlottoGR\n";
                bw.write(stringRigo);
                List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getFatturaByNumeroOrdineAnnoAssociato(testata.getNumeroOrdine(), testata.getAnno(), a.getId(), testata.getTipoDocumento());
                for (RigoDocumento rigo : righe) {
                    _log.info(rigo);
                    String valoriRigo = "";
                    String Tiprig,
                            Codart,
                            Codvar,
                            Descri,
                            Quanet,
                            Qm2net,
                            Prezzo,
                            Scont1,
                            Scont2,
                            Scont3,
                            Libstr1,
                            Libstr2,
                            Libstr3,
                            Libdbl1,
                            Libdbl2,
                            Libdbl3,
                            Liblng1,
                            Liblng2,
                            Liblng3,
                            Libdat1,
                            Libdat2,
                            Libdat3,
                            Codlotto = "";
                    if (rigo.getPesoNetto() != 0) {
                        //VALORI RIGO ARTICOLO
                        Tiprig = "0" + SEPARATOR;
                        Codart = rigo.getCodiceArticolo() + SEPARATOR;
                        Codvar = rigo.getCodiceVariante() + SEPARATOR;
                        Descri = SEPARATOR;
                        Quanet = rigo.getPesoNetto() + SEPARATOR;
                        Qm2net = rigo.getColli() + SEPARATOR;
                        Prezzo = rigo.getPrezzo() + SEPARATOR;
                        Scont1 = "-" + rigo.getSconto1()+ SEPARATOR;
                        Scont2 = "-" + rigo.getSconto2() + SEPARATOR;
                        Scont3 = "-" + rigo.getSconto3()+ SEPARATOR;
                        Libstr1 = SEPARATOR;
                        Libstr2 = SEPARATOR;
                        Libstr3 = SEPARATOR;
                        Libdbl1 = rigo.getPesoLordo() + SEPARATOR;
                        Libdbl2 = "1" + SEPARATOR;
                        Libdbl3 = "0" + SEPARATOR;
                        Liblng1 = "0" + SEPARATOR;
                        Liblng2 = "0" + SEPARATOR;
                        Liblng3 = "0" + SEPARATOR;
                        Libdat1 = testata.getDataOrdine() + SEPARATOR;
                        Libdat2 = testata.getDataOrdine() + SEPARATOR;
                        Libdat3 = testata.getDataOrdine() + SEPARATOR;
                        Codlotto = rigo.getLotto() + SEPARATOR;

                        if(!rigo.getCodiceArticolo().equals("PR")){
                        	valoriRigo = Tiprig + Codart + Codvar + Descri + Quanet + Qm2net + Prezzo + Scont1 + Scont2 + Scont3 + Libstr1 + Libstr2 + Libstr3 + Libdbl1 + Libdbl2 + Libdbl3 + Liblng1 + Liblng2 + Liblng3 + Libdat1 + Libdat2 + Libdat3 + Codlotto + "\n";
                        	//VALORI RIGO IMBALLO
	                        Tiprig = "0" + SEPARATOR;
	                        Codart = rigo.getImballo() + SEPARATOR;
	                        Codvar = SEPARATOR;
	                        Descri = SEPARATOR;
	                        Quanet = rigo.getColli() + SEPARATOR;
	                        Qm2net = rigo.getColli() + SEPARATOR;
	                        Prezzo = "0" + SEPARATOR;
	                        Scont1 = SEPARATOR;
	                        Scont2 = SEPARATOR;
	                        Scont3 = SEPARATOR;
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
	                        Libdat2 = testata.getDataOrdine() + SEPARATOR;
	                        Libdat3 = testata.getDataOrdine() + SEPARATOR;
	                        Codlotto = SEPARATOR;
                        }
                    } else {
                        Tiprig = "2" + SEPARATOR;
                        Codart = rigo.getCodiceArticolo() + SEPARATOR;
                        Codvar = rigo.getDescrizioneVariante() + SEPARATOR;
                        Descri = rigo.getDescrizione() + SEPARATOR;
                        Quanet = rigo.getPesoNetto() + SEPARATOR;
                        Qm2net = rigo.getColli() + SEPARATOR;
                        Prezzo = rigo.getPrezzo() + SEPARATOR;
                        Scont1 = SEPARATOR;
                        Scont2 = SEPARATOR;
                        Scont3 = SEPARATOR;
                        Libstr1 = SEPARATOR;
                        Libstr2 = SEPARATOR;
                        Libstr3 = SEPARATOR;
                        Libdbl1 = rigo.getPesoLordo() + SEPARATOR;
                        Libdbl2 = "1" + SEPARATOR;
                        Libdbl3 = "0" + SEPARATOR;
                        Liblng1 = "0" + SEPARATOR;
                        Liblng2 = "0" + SEPARATOR;
                        Liblng3 = "0" + SEPARATOR;
                        Libdat1 = testata.getDataOrdine() + SEPARATOR;
                        Libdat2 = testata.getDataOrdine() + SEPARATOR;
                        Libdat3 = testata.getDataOrdine() + SEPARATOR;
                        Codlotto = rigo.getLotto() + SEPARATOR;

                    }
                    valoriRigo += Tiprig + Codart + Codvar + Descri + Quanet + Qm2net + Prezzo + Scont1 + Scont2 + Scont3 + Libstr1 + Libstr2 + Libstr3 + Libdbl1 + Libdbl2 + Libdbl3 + Liblng1 + Liblng2 + Liblng3 + Libdat1 + Libdat2 + Libdat3 + Codlotto + "\n";

                    bw.write(valoriRigo);
                }
                testata.setInviato(1); // SETTO INVIATO A 1
                TestataDocumentoLocalServiceUtil.updateTestataDocumento(testata);
            }

            bw.close();
            return file.getAbsolutePath();

        } catch (IOException ex) {
            _log.error(ex.getMessage());
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
        } catch (NoSuchAssociatoException ex) {
            _log.error(ex.getMessage());
        } catch (PortalException ex) {
            _log.error(ex.getMessage());
        }
        return null;

    }
}
