/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.its.ct.gestionaleOP.op;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.UserIdMapper;
import com.liferay.portal.service.UserIdMapperLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.bysoftware.ct.NoSuchAssociatoException;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.ClientiDatiAgg;
import it.bysoftware.ct.model.DescrizioniDocumenti;
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil;
import it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.ClientiDatiAggPK;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;

import it.its.ct.gestionaleOP.utils.DocumentType;

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

/**
 *
 * @author mario
 */
public class RecuperoDocumentiPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil
            .getLog(RecuperoDocumentiPortlet.class);
    private static final String SEPARATOR = ";";

    @Override
    public void doView(RenderRequest renderRequest,
            RenderResponse renderResponse) throws IOException, PortletException {

        _log.info("doView()");
        super.doView(renderRequest, renderResponse); // To change body of

        // generated methods,
        // choose Tools |
        // Templates.

    }

    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException {

        String tracciato = creaFileTracciato(
                ParamUtil.getString(resourceRequest, "userId", null),
                resourceRequest.getRemoteUser(),
                ParamUtil.getInteger(resourceRequest, "inviato", 0),
                ParamUtil.getString(resourceRequest, "testata", null));

        File file = new File(tracciato);
        InputStream in = new FileInputStream(file);
        HttpServletResponse httpRes = PortalUtil
                .getHttpServletResponse(resourceResponse);
        HttpServletRequest httpReq = PortalUtil
                .getHttpServletRequest(resourceRequest);
        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in,
                "application/download");

        in.close();
    }

    private String creaFileTracciato(String utente, String opId, int inviato,
            String jsonTestata) {

        File file;
        FileWriter fw;
        try {
            Associato a = AssociatoLocalServiceUtil.getAssociato(Long
                    .parseLong(utente));
            String nomeAssociato = a.getRagioneSociale().replaceAll("[^A-Za-z0-9]+", "_");
//            file = new File("/tmp/documenti_" + a.getCentro() + ".txt");
            file = new File("/tmp/" + nomeAssociato + "_" + a.getCentro() + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            } else {
                Path path = FileSystems.getDefault().getPath("/tmp/",
                        nomeAssociato + "_" + a.getCentro() + ".txt");
                Files.deleteIfExists(path);
                _log.info("Deleted " + nomeAssociato + "_" + a.getCentro() + ".txt");
            }

            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            List<TestataDocumento> list = new ArrayList<TestataDocumento>();

            if (jsonTestata != null) {
                TestataDocumentoPK testataDocumentoPK = JSONFactoryUtil
                        .looseDeserializeSafe(jsonTestata,
                                TestataDocumentoPK.class);
                list.add(TestataDocumentoLocalServiceUtil
                        .fetchTestataDocumento(testataDocumentoPK));
            } else {
                UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                        .getUserIdMapper(a.getIdLiferay());
                list = TestataDocumentoLocalServiceUtil.getByCodiceOperatore(
                        String.valueOf(userIdMapper.getUserId()), "completo",
                        inviato);
            }

            for (TestataDocumento testata : list) {
                if (!testata.getCodiceSoggetto().equals(opId)
                        || (!testata.getTipoDocumento().equals(
                                DocumentType.FAV.name()) && !testata
                                .getTipoDocumento().equals(
                                        DocumentType.NAC.name()))) { // non

                    // esporto
                    // NAC E
                    // FAV
                    // verso
                    // OP.

                    _log.info(testata);

                    String stringTestata = "WorkTestataDocumento;Tipdoc;Codcen;Datreg;Codsog;Codspe;Codpor;Codase;Codve1;Codve2;Numdoc;Protoc;Datdoc;Datann\n";
                    bw.write(stringTestata);

                    // DDT;03/07/2015;F0009;;;;;;0;24;03/07/2015

                    String valoriTestata = testata.getTipoDocumento()
                            + SEPARATOR;
                    String codCen = testata.getCentro() + SEPARATOR;
                    String dataReg = testata.getDataOrdine() + SEPARATOR;// sdf.format(new

                    // Timestamp(date.getTime()))
                    // +
                    // SEPARATOR;

                    String codSog = testata.getCodiceSoggetto() + SEPARATOR;
                    String codSpe = SEPARATOR;
                    String codPor = testata.getPorto() + SEPARATOR;
                    String codAse = testata.getAspettoEsteriore() + SEPARATOR;
                    String codVe1 = testata.getCodiceVettore() + SEPARATOR;
                    String codVe2 = testata.getVettore2() + SEPARATOR;
                    String numDoc = testata.getNumeroOrdine() + SEPARATOR;
                    String protoc = ((testata.getTipoDocumento()
                            .equals(DocumentType.FAV.name())) ? testata
                            .getNumeroOrdine() : 0)
                            + SEPARATOR;
                    String dataDoc = testata.getDataOrdine() + SEPARATOR;
                    String Datann = testata.getDataOrdine();

                    valoriTestata += codCen + dataReg + codSog + codSpe
                            + codPor + codAse + codVe1 + codVe2 + numDoc
                            + protoc + dataDoc + Datann + "\n";

                    bw.write(valoriTestata);

                    // CodlottoGR

                    String stringRigo = "WorkRigaDocumento;Tiprig;Codart;Codvar;Descri;Quanet;Qm2net;Prezzo;Scont1;Scont2;Scont3;Libstr1;Libstr2;Libstr3;Libdbl1;Libdbl2;Libdbl3;Liblng1;Liblng2;Liblng3;Libdat1;Libdat2;Libdat3;CodLotto;CodlottoGR;Impnet;Codiva\n";
                    bw.write(stringRigo);
                    List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil
                            .getFatturaByNumeroOrdineAnnoAssociato(
                                    testata.getNumeroOrdine(),
                                    testata.getAnno(), a.getId(),
                                    testata.getTipoDocumento());

                    for (RigoDocumento rigo : righe) {
                        _log.info(rigo);
                        String valoriRigo = "";
                        String Tiprig, Codart, Codvar, Descri, Quanet, Qm2net, Prezzo, Scont1, Scont2, Scont3, Libstr1, Libstr2, Libstr3, Libdbl1, Libdbl2, Libdbl3, Liblng1, Liblng2, Liblng3, Libdat1, Libdat2, Libdat3, Codlotto = "", CodlottoGR, Impnet = "0.0"
                                + SEPARATOR, Codiva = "";

                        if (rigo.getPesoNetto() != 0) {
//                            if (rigo.getCodiceArticolo().equals("")) {
                            if (rigo.getColli() == 0) {
                                // RIGO FORFAIT
                                Tiprig = "1" + SEPARATOR;
                            } else {
                                // RIGO ARTICOLO
                                Tiprig = "0" + SEPARATOR;
                            }

                            Codart = rigo.getCodiceArticolo() + SEPARATOR;
                            Codvar = rigo.getCodiceVariante() + SEPARATOR;
                            Descri = rigo.getDescrizione() + SEPARATOR;
                            Quanet = rigo.getPesoNetto() + SEPARATOR;
                            Qm2net = rigo.getColli() + SEPARATOR;
                            Prezzo = rigo.getPrezzo() + SEPARATOR;
                            Scont1 = "-" + rigo.getSconto1() + SEPARATOR;
                            Scont2 = "-" + rigo.getSconto2() + SEPARATOR;
                            Scont3 = "-" + rigo.getSconto3() + SEPARATOR;
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
                            CodlottoGR = SEPARATOR;

                            if (rigo.getTipoDocumento().equals(
                                    DocumentType.NAC.name())) {
                                Impnet = String.valueOf(rigo.getPrezzo())
                                        + SEPARATOR;
                            }

                            if (!rigo.getCodiceArticolo().equals("PR")
                                    && !rigo.getCodiceArticolo().equals("")
                                    && rigo.getColli() != 0) {
                                valoriRigo = Tiprig + Codart + Codvar + Descri
                                        + Quanet + Qm2net + Prezzo + Scont1
                                        + Scont2 + Scont3 + Libstr1 + Libstr2
                                        + Libstr3 + Libdbl1 + Libdbl2 + Libdbl3
                                        + Liblng1 + Liblng2 + Liblng3 + Libdat1
                                        + Libdat2 + Libdat3 + Codlotto
                                        + CodlottoGR + Impnet + Codiva + "\n";

                                // VALORI RIGO IMBALLO

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
                                CodlottoGR = SEPARATOR;
                            }
                        } else {
                            if (rigo.getTipoDocumento().equals(
                                    DocumentType.NAC.name())) {
                                Tiprig = "1" + SEPARATOR;
                                Impnet = String.valueOf(rigo.getPrezzo())
                                        + SEPARATOR;

                                if (rigo.getCodiceArticolo().isEmpty()) {
                                    ClientiDatiAgg cliente = ClientiDatiAggLocalServiceUtil
                                            .fetchClientiDatiAgg(new ClientiDatiAggPK(
                                                    testata.getCodiceSoggetto(),
                                                    false));
                                    Codiva = cliente.getCodiceAliquota();
                                } else {
                                    DescrizioniDocumenti descr = DescrizioniDocumentiLocalServiceUtil
                                            .fetchDescrizioniDocumenti(rigo
                                                    .getCodiceArticolo());
                                    Codiva = descr.getCodiceIVA();
                                }
                            } else {
                                Tiprig = "2" + SEPARATOR;
                            }

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
                            CodlottoGR = SEPARATOR;
                        }

                        valoriRigo += Tiprig + Codart + Codvar + Descri
                                + Quanet + Qm2net + Prezzo + Scont1 + Scont2
                                + Scont3 + Libstr1 + Libstr2 + Libstr3
                                + Libdbl1 + Libdbl2 + Libdbl3 + Liblng1
                                + Liblng2 + Liblng3 + Libdat1 + Libdat2
                                + Libdat3 + Codlotto + CodlottoGR + Impnet
                                + Codiva + "\n";

                        bw.write(valoriRigo);
                    }

                    testata.setInviato(1); // SETTO INVIATO A 1
                    TestataDocumentoLocalServiceUtil
                            .updateTestataDocumento(testata);
                }
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