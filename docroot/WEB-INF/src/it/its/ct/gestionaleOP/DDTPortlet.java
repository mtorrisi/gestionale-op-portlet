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
import it.bysoftware.ct.NoSuchAssociatoException;
import it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException;
import it.bysoftware.ct.model.Anagrafica;
import it.bysoftware.ct.model.AnagraficaAssociatoOP;
import it.bysoftware.ct.model.ArticoliAssociatoOP;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.CMR;
import it.bysoftware.ct.model.OrganizzazioneProduttori;
import it.bysoftware.ct.model.Progressivo;
import it.bysoftware.ct.model.RigoDocumento;
import it.bysoftware.ct.model.TestataDocumento;
import it.bysoftware.ct.model.TracciabilitaGrezzi;
import it.bysoftware.ct.model.TracciabilitaScheda;
import it.bysoftware.ct.model.WKRigoDocumento;
import it.bysoftware.ct.model.WKTestataDocumento;
import it.bysoftware.ct.model.impl.RigoDocumentoImpl;
import it.bysoftware.ct.service.AnagraficaAssociatoOPLocalServiceUtil;
import it.bysoftware.ct.service.AnagraficaLocalServiceUtil;
import it.bysoftware.ct.service.ArticoliAssociatoOPLocalServiceUtil;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.CMRLocalServiceUtil;
import it.bysoftware.ct.service.DescrizioniVariantiLocalServiceUtil;
import it.bysoftware.ct.service.FileUploaderLocalServiceUtil;
import it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil;
import it.bysoftware.ct.service.ProgressivoLocalServiceUtil;
import it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.TracciabilitaGrezziLocalServiceUtil;
import it.bysoftware.ct.service.TracciabilitaSchedaLocalServiceUtil;
import it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil;
import it.bysoftware.ct.service.persistence.AnagraficaAssociatoOPPK;
import it.bysoftware.ct.service.persistence.ArticoliAssociatoOPPK;
import it.bysoftware.ct.service.persistence.CMRPK;
import it.bysoftware.ct.service.persistence.ProgressivoPK;
import it.bysoftware.ct.service.persistence.RigoDocumentoPK;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;
import it.bysoftware.ct.service.persistence.WKRigoDocumentoPK;
import it.bysoftware.ct.service.persistence.WKTestataDocumentoPK;
import it.its.ct.gestionaleOP.csvParser.CSVParser;
import it.its.ct.gestionaleOP.pojos.Documento;
import it.its.ct.gestionaleOP.pojos.Response;
import it.its.ct.gestionaleOP.pojos.Response.Code;
import it.its.ct.gestionaleOP.report.Report;
import it.its.ct.gestionaleOP.utils.Constants;
import it.its.ct.gestionaleOP.utils.DocumentType;
import it.its.ct.gestionaleOP.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import net.sf.jasperreports.engine.JRException;

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
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserIdMapper;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserIdMapperLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DDTPortlet extends MVCPortlet {

    private static final String[][] CMR_HEADER = {
            { "il mittente", "l'expediteur", "sender" },
            { "il destinatario", "le destinataire", "consignee" },
            { "il trasportatore", "le transporteur", "carrier" },
            { "il controllo", "le contrôle", "check" },
            { "uso interno", "utilisation intérieure", "internal use" } };

    private final Log _log = LogFactoryUtil.getLog(DDTPortlet.class);
    private final static int ONE_GB = 1073741824;
    public static final String DDA = DocumentType.DDA.name();
    public static final String DDT = DocumentType.DDT.name();
    public static final String FAC = DocumentType.FAC.name();
    public static final String FAT = DocumentType.FAT.name();
    public static final String FAV = DocumentType.FAV.name();
    public static final String NAC = DocumentType.NAC.name();
    public static final String TRAC = DocumentType.TRAC.name();
    public static final String CMR = DocumentType.CMR.name();
    public static final String OP_VAT_CENTER = "1";

    private static final int ANNO = Calendar.getInstance().get(Calendar.YEAR);
    public static final String COMPLETED = "completo";
    public static final String INVOICED = "fatturato";

    public enum CommandID {
        save, print, send, modify, generateInvoice, printInvoice, updateInvoice, saveTrace, printTrace, saveCreditNote, updateCreditNote, printCreditNote, printCMR, saveCMR
    }

    public void generateInvoice(ActionRequest areq, ActionResponse ares) {

        boolean filter = ParamUtil.getBoolean(areq, "filter");
        boolean update = ParamUtil.getBoolean(areq, "update");
        String codiceCliente = null; // = ParamUtil.getString(areq, "clientId");
        int anno = Calendar.getInstance().get(Calendar.YEAR);
        String ids[] = ParamUtil.getString(areq, "documentIds").split(",");
        UserIdMapper userIdMapper;
        try {
            userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                    Long.parseLong(areq.getRemoteUser()), Constants.FUTURO_NET);
            Associato a = AssociatoLocalServiceUtil
                    .findByLiferayId(userIdMapper.getUserIdMapperId());
            boolean success = true;
            for (String id : ids) {
                long numOrd = Long.parseLong(id);
                TestataDocumento t = TestataDocumentoLocalServiceUtil
                        .fetchTestataDocumento(new TestataDocumentoPK(anno,
                                numOrd, DDT, a.getId()));
                if (codiceCliente == null) {
                    codiceCliente = t.getCodiceSoggetto();
                }
                if (!t.getCodiceSoggetto().equals(codiceCliente)) {
                    SessionErrors.add(areq, "different-customers");
                    ares.setRenderParameter("update", String.valueOf(update));
                    ares.setRenderParameter("filter", String.valueOf(filter));
                    ares.setRenderParameter("codiceCliente", codiceCliente);
                    ares.setRenderParameter("jspPage", "/jsps/search-ddt.jsp");
                    success = false;
                    break;
                }
            }
            if (success) {
                ares.setRenderParameter("codiceCliente",
                        ParamUtil.getString(areq, "clientId"));
                // ares.setRenderParameter("jspPage", "/jsps/search-ddt.jsp");
                ares.setRenderParameter("anno", String.valueOf(Calendar
                        .getInstance().get(Calendar.YEAR)));
                ares.setRenderParameter("documentIds",
                        ParamUtil.getString(areq, "documentIds"));
                ares.setRenderParameter("jspPage", "/jsps/edit-invoice.jsp");
            }

        } catch (NumberFormatException | PortalException | SystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void deleteDDT(ActionRequest areq, ActionResponse ares) {

        int anno = ParamUtil.getInteger(areq, "anno");
        int numeroOrdine = ParamUtil.getInteger(areq, "numeroOrdine");
        Long idAssociato = ParamUtil.getLong(areq, "idAssociato");
        String codiceCliente = ParamUtil.getString(areq, "codiceCliente");
        String tipoDocumento = ParamUtil.getString(areq, "tipoDocumento");
        _log.info("Deleting " + tipoDocumento + ": " + anno + " "
                + numeroOrdine + " " + idAssociato);

        try {
            Progressivo createProgressivo = ProgressivoLocalServiceUtil
                    .createProgressivo(new ProgressivoPK(anno, idAssociato,
                            Constants.DDT_ID, numeroOrdine));

            ProgressivoLocalServiceUtil.addProgressivo(createProgressivo);

            // List<RigoDocumento> listRigo =
            // RigoDocumentoLocalServiceUtil.getByNumeroOrdineAnno(numeroOrdine,
            // anno, idAssociato);
            // List<RigoDocumento> listRigo =
            // RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(numeroOrdine,
            // anno, idAssociato, tipoDocumento);
            List<RigoDocumento> listRigo = RigoDocumentoLocalServiceUtil
                    .getDDTByNumeroOrdineAnnoAssociato(numeroOrdine, anno,
                            idAssociato);
            for (RigoDocumento rigoDocumento : listRigo) {
                RigoDocumentoLocalServiceUtil
                        .deleteRigoDocumento(rigoDocumento);
            }
            TestataDocumentoLocalServiceUtil
                    .deleteTestataDocumento(new TestataDocumentoPK(anno,
                            numeroOrdine, DDT, idAssociato));

            ThemeDisplay themeDisplay = (ThemeDisplay) areq
                    .getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getLayout().getGroupId();
            long repositoryId = themeDisplay.getScopeGroupId();

            Associato a = AssociatoLocalServiceUtil.fetchAssociato(idAssociato);
            OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil
                    .getOrganizzazioneProduttori(a.getIdOp());
            UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                    .getUserIdMapper(a.getIdLiferay());
            User liferayAssociato = UserLocalServiceUtil.getUser(userIdMapper
                    .getUserId());
            User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
            DLFolder opFolder = Utils.getOpFolder(groupId, liferayOp);
            DLFolder associatoFolder = Utils.getAssociatoFolder(groupId,
                    opFolder, liferayAssociato);
            _log.info("Deleting file: " + ANNO + "_" + numeroOrdine + "_"
                    + a.getCentro() + ".pdf");
            DLAppServiceUtil.deleteFileEntryByTitle(repositoryId,
                    associatoFolder.getFolderId(), DDT + "_" + ANNO + "_"
                            + numeroOrdine + "_" + a.getCentro() + ".pdf");

        } catch (PortalException ex) {
            _log.error(ex.getMessage());
            // SessionErrors.add(areq, "error-delete");
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "error-delete");
        }

        ares.setRenderParameter("filter", "false");
        ares.setRenderParameter("update", "true");
        ares.setRenderParameter("codiceCliente", codiceCliente);
        ares.setRenderParameter("jspPage", "/jsps/search-ddt.jsp");
    }

    public void deleteInvoice(ActionRequest areq, ActionResponse ares) {
        int anno = ParamUtil.getInteger(areq, "anno");
        int numeroOrdine = ParamUtil.getInteger(areq, "numeroOrdine");
        Long idAssociato = ParamUtil.getLong(areq, "idAssociato");
        String codiceCliente = ParamUtil.getString(areq, "codiceCliente");
        String tipoDocumento = ParamUtil.getString(areq, "tipoDocumento",
                DocumentType.FAV.name());
        int nDocConf = -1;

        _log.info("Deleting Invoice: " + anno + " " + numeroOrdine + " "
                + idAssociato + " " + tipoDocumento);

        try {
            TestataDocumento fattura = TestataDocumentoLocalServiceUtil
                    .fetchTestataDocumento(new TestataDocumentoPK(anno,
                            numeroOrdine, tipoDocumento, idAssociato));
            // Elimino righe FAV
            List<RigoDocumento> righeFattura = RigoDocumentoLocalServiceUtil
                    .getFatturaByNumeroOrdineAnnoAssociato(
                            fattura.getNumeroOrdine(), fattura.getAnno(),
                            fattura.getIdAssociato(), tipoDocumento);
            for (RigoDocumento rigoDocumento : righeFattura) {
                RigoDocumentoLocalServiceUtil
                        .deleteRigoDocumento(rigoDocumento);
            }
            TestataDocumentoLocalServiceUtil.deleteTestataDocumento(fattura);

            if (fattura.getNota2() != null && !fattura.getNota2().isEmpty()) {
                nDocConf = Integer.parseInt(fattura.getNota2());
                TestataDocumento fac;
                if (tipoDocumento.equals(DocumentType.FAV.name())) {
                    // Recupero il FAC
                    fac = TestataDocumentoLocalServiceUtil
                            .getTestataDocumento(new TestataDocumentoPK(anno,
                                    nDocConf, FAC, idAssociato));
                } else {
                    fac = fattura;
                }
                // Elimino righe FAC
                List<RigoDocumento> righeFAC = RigoDocumentoLocalServiceUtil
                        .getFatturaByNumeroOrdineAnnoAssociato(
                                fac.getNumeroOrdine(), fac.getAnno(),
                                fac.getIdAssociato(), FAC);
                for (RigoDocumento rigoDocumento : righeFAC) {
                    RigoDocumentoLocalServiceUtil
                            .deleteRigoDocumento(rigoDocumento);
                }
                TestataDocumentoLocalServiceUtil.deleteTestataDocumento(fac);
            }

            List<TestataDocumento> origDDTs = TestataDocumentoLocalServiceUtil
                    .getDocumentiCollegati(anno, DDT, idAssociato,
                            String.valueOf(numeroOrdine));
            for (TestataDocumento origDDT : origDDTs) {
                _log.info("Sto riaprendo il DDT: " + origDDT);
                origDDT.setCompleto(COMPLETED);
                origDDT.setNota2("");
                TestataDocumentoLocalServiceUtil
                        .updateTestataDocumento(origDDT);
            }

            // Creo il progressivo da reccuperare.
            Progressivo createProgressivo = ProgressivoLocalServiceUtil
                    .createProgressivo(new ProgressivoPK(anno, idAssociato,
                            Constants.INVOICE_ID, numeroOrdine));
            ProgressivoLocalServiceUtil.addProgressivo(createProgressivo);

            ThemeDisplay themeDisplay = (ThemeDisplay) areq
                    .getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getLayout().getGroupId();
            long repositoryId = themeDisplay.getScopeGroupId();

            Associato a = AssociatoLocalServiceUtil.fetchAssociato(idAssociato);
            OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil
                    .getOrganizzazioneProduttori(a.getIdOp());
            UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                    .getUserIdMapper(a.getIdLiferay());
            User liferayAssociato = UserLocalServiceUtil.getUser(userIdMapper
                    .getUserId());
            User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
            DLFolder opFolder = Utils.getOpFolder(groupId, liferayOp);
            DLFolder associatoFolder = Utils.getAssociatoFolder(groupId,
                    opFolder, liferayAssociato);
            DLFolder yearFolder = Utils.getAssociatoYearFolder(groupId,
                    associatoFolder, anno);
            DLFolder docFolder;
            if (tipoDocumento.equals(DocumentType.FAV.name())) {
                docFolder = Utils.getAssociatoDocumentFolder(groupId,
                        yearFolder, FAV);
                _log.info("Deleting file: " + FAV + "_" + ANNO + "_"
                        + numeroOrdine + "_" + a.getCentro() + ".pdf");
                DLAppServiceUtil.deleteFileEntryByTitle(repositoryId,
                        docFolder.getFolderId(), FAV + "_" + ANNO + "_"
                                + numeroOrdine + "_" + a.getCentro() + ".pdf");
            }
            if (nDocConf != -1) {
                docFolder = Utils.getAssociatoDocumentFolder(groupId,
                        yearFolder, FAC);
                _log.info("Deleting file: " + FAC + "_" + ANNO + "_" + nDocConf
                        + "_" + OP_VAT_CENTER + ".pdf");
                DLAppServiceUtil.deleteFileEntryByTitle(repositoryId,
                        docFolder.getFolderId(), FAC + "_" + ANNO + "_"
                                + nDocConf + "_" + OP_VAT_CENTER + ".pdf");
            }

        } catch (PortalException ex) {
            _log.warn(ex.getMessage());
            SessionMessages.add(areq, "error-delete");
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "error");
        }

        ares.setRenderParameter("update", "true");
        ares.setRenderParameter("codiceCliente", codiceCliente);
        ares.setRenderParameter("jspPage", "/jsps/search-invoice.jsp");
    }

    public void deleteCreditNote(ActionRequest areq, ActionResponse ares) {
        int anno = ParamUtil.getInteger(areq, "anno");
        int numeroOrdine = ParamUtil.getInteger(areq, "numeroOrdine");
        Long idAssociato = ParamUtil.getLong(areq, "idAssociato");
        String codiceCliente = ParamUtil.getString(areq, "codiceCliente");

        _log.info("Deleting Credit note: " + anno + " " + numeroOrdine + " "
                + idAssociato);

        try {
            TestataDocumento nac = TestataDocumentoLocalServiceUtil
                    .fetchTestataDocumento(new TestataDocumentoPK(anno,
                            numeroOrdine, NAC, idAssociato));
            // Elimino righe NAC
            List<RigoDocumento> righeNAC = RigoDocumentoLocalServiceUtil
                    .getFatturaByNumeroOrdineAnnoAssociato(
                            nac.getNumeroOrdine(), nac.getAnno(),
                            nac.getIdAssociato(), NAC);
            for (RigoDocumento rigoDocumento : righeNAC) {
                RigoDocumentoLocalServiceUtil
                        .deleteRigoDocumento(rigoDocumento);
            }
            TestataDocumentoLocalServiceUtil.deleteTestataDocumento(nac);

            // Creo il progressivo da reccuperare.
            Progressivo createProgressivo = ProgressivoLocalServiceUtil
                    .createProgressivo(new ProgressivoPK(anno, idAssociato,
                            Constants.NOTE_ID, numeroOrdine));
            ProgressivoLocalServiceUtil.addProgressivo(createProgressivo);

            ThemeDisplay themeDisplay = (ThemeDisplay) areq
                    .getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getLayout().getGroupId();
            long repositoryId = themeDisplay.getScopeGroupId();

            Associato a = AssociatoLocalServiceUtil.fetchAssociato(idAssociato);
            OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil
                    .getOrganizzazioneProduttori(a.getIdOp());
            UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                    .getUserIdMapper(a.getIdLiferay());
            User liferayAssociato = UserLocalServiceUtil.getUser(userIdMapper
                    .getUserId());
            User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
            DLFolder opFolder = Utils.getOpFolder(groupId, liferayOp);
            DLFolder associatoFolder = Utils.getAssociatoFolder(groupId,
                    opFolder, liferayAssociato);
            DLFolder yearFolder = Utils.getAssociatoYearFolder(groupId,
                    associatoFolder, anno);
            DLFolder docFolder = Utils.getAssociatoDocumentFolder(groupId,
                    yearFolder, NAC);
            _log.info("Deleting file: " + NAC + "_" + ANNO + "_" + numeroOrdine
                    + "_" + a.getCentro() + ".pdf");
            DLAppServiceUtil.deleteFileEntryByTitle(repositoryId,
                    docFolder.getFolderId(), NAC + "_" + ANNO + "_"
                            + numeroOrdine + "_" + a.getCentro() + ".pdf");

        } catch (PortalException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "error-delete");
        } catch (SystemException ex) {
            _log.error(ex.getMessage());
            SessionErrors.add(areq, "error-delete");
        }

        ares.setRenderParameter("update", "true");
        ares.setRenderParameter("codiceCliente", codiceCliente);
        ares.setRenderParameter("jspPage", "/jsps/search-creditNote.jsp");
    }

    public void upload(ActionRequest areq, ActionResponse ares) {

        UploadPortletRequest uploadRequest = PortalUtil
                .getUploadPortletRequest(areq);
        long idAssociato = Long.parseLong(ParamUtil.getString(uploadRequest,
                "idAssociato"));

        File uploadedFile;
        try {
            UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                    .getUserIdMapper(idAssociato, Constants.FUTURO_NET);
            Associato associato = AssociatoLocalServiceUtil
                    .findByLiferayId(userIdMapper.getUserIdMapperId());
            uploadedFile = uploadFile(uploadRequest, idAssociato);
            _log.info("Uploaded file: " + uploadedFile.getName());
            List<Documento> importedDocs = parseImportedFile(uploadedFile,
                    associato.getId());

            List<Documento> docsReady = new ArrayList<Documento>(); // new
                                                                    // ArrayList<Documento>(importedDocs);
            List<Documento> docsToCheck = new ArrayList<Documento>();

            for (Documento d : importedDocs) {
                _log.info("TESTATA: " + d.getTestata().toString());
                WKTestataDocumento t = d.getTestata();
                List<WKRigoDocumento> rows = d.getRighe();

                AnagraficaAssociatoOP associatoOP = null;
                try {
                    associatoOP = AnagraficaAssociatoOPLocalServiceUtil
                            .getAnagraficaAssociatoOP(new AnagraficaAssociatoOPPK(
                                    associato.getId(), t.getCodiceSoggetto()));
                } catch (PortalException ex) {
                    _log.info("Cliente non codificato: "
                            + t.getCodiceSoggetto());
                }
                if (associatoOP != null) {
                    _log.info("Cliente codificato, sostituisco: "
                            + t.getCodiceSoggetto() + "<->"
                            + associatoOP.getCodiceSogettoOP());
                    // Sostituisco il codice sogetto dell'assocaito con quello
                    // della OP
                    t.setCodiceSoggetto(associatoOP.getCodiceSogettoOP());

                    Anagrafica cliente = AnagraficaLocalServiceUtil
                            .getAnagrafica(associatoOP.getCodiceSogettoOP());
                    t.setRagioneSociale(cliente.getRagioneSociale());
                    boolean addToReady = true;
                    for (WKRigoDocumento rigoDocumento : rows) {
                        if (!rigoDocumento.getCodiceArticolo().equals("")) {
                            ArticoliAssociatoOP articoloAssociato = null;
                            try {
                                articoloAssociato = ArticoliAssociatoOPLocalServiceUtil
                                        .getArticoliAssociatoOP(new ArticoliAssociatoOPPK(
                                                associato.getId(),
                                                rigoDocumento
                                                        .getCodiceArticolo()));
                            } catch (PortalException ex) {
                                _log.info("Articolo non trovato: "
                                        + rigoDocumento.getCodiceArticolo());
                            }
                            if (articoloAssociato == null) {
                                _log.info("Articolo: "
                                        + rigoDocumento.getCodiceArticolo()
                                        + " non ancora codificato.");
                                rigoDocumento.setVerificato(false);
                                addToReady = false;
                            } else {
                                _log.info("Articolo codificato, sostituisco: "
                                        + rigoDocumento.getCodiceArticolo()
                                        + "<->"
                                        + articoloAssociato
                                                .getCodiceArticoloOP());
                                rigoDocumento
                                        .setCodiceArticolo(articoloAssociato
                                                .getCodiceArticoloOP());
                                rigoDocumento.setVerificato(true);
                            }
                        } else {
                            rigoDocumento.setVerificato(true);
                        }
                    }
                    if (addToReady) {
                        t.setVerificato(true);
                        docsReady.add(d);
                    } else {
                        t.setVerificato(false);
                        docsToCheck.add(d);
                    }
                } else {
                    _log.info("Cliente: " + t.getCodiceSoggetto()
                            + " non codificato.");
                    t.setVerificato(false);
                    for (WKRigoDocumento rigoDocumento : rows) {
                        if (!rigoDocumento.getCodiceArticolo().equals("")) {
                            ArticoliAssociatoOP articoloAssociato = null;
                            try {
                                articoloAssociato = ArticoliAssociatoOPLocalServiceUtil
                                        .getArticoliAssociatoOP(new ArticoliAssociatoOPPK(
                                                associato.getId(),
                                                rigoDocumento
                                                        .getCodiceArticolo()));
                            } catch (PortalException ex) {
                                _log.info("Articolo non trovato: "
                                        + rigoDocumento.getCodiceArticolo());
                            }
                            if (articoloAssociato == null) {
                                _log.info("Articolo: "
                                        + rigoDocumento.getCodiceArticolo()
                                        + " non ancora codificato.");
                                rigoDocumento.setVerificato(false);
                            } else {
                                _log.info("Articolo codificato, sostituisco: "
                                        + rigoDocumento.getCodiceArticolo()
                                        + "<->"
                                        + articoloAssociato
                                                .getCodiceArticoloOP());
                                rigoDocumento
                                        .setCodiceArticolo(articoloAssociato
                                                .getCodiceArticoloOP());
                                rigoDocumento.setVerificato(true);
                            }
                        } else {
                            rigoDocumento.setVerificato(true);
                        }
                    }
                    docsToCheck.add(d);
                }
            }

            storeImportedDocument(docsReady, docsToCheck);

            ares.setRenderParameter("uploadedFile", uploadedFile.getName());
            ares.setRenderParameter("jspPage", "/jsps/validate.jsp");
            areq.setAttribute("docsReady", docsReady);
            areq.setAttribute("docsToCheck", docsToCheck);
            SessionMessages.add(areq, "imported-docs");
        } catch (Exception e) {
            SessionErrors.add(areq, e.getMessage());
            _log.error(e.getMessage());
            e.printStackTrace();
        }

    }

    public void saveWKRigoDocumento(ActionRequest areq, ActionResponse ares) {

        String codiceArticolo = ParamUtil.getString(areq, "codice", null);
        String json = ParamUtil.getString(areq, "WKRigoDocumentoPK");
        WKRigoDocumentoPK rigoDocumentoPK = JSONFactoryUtil
                .looseDeserializeSafe(json, WKRigoDocumentoPK.class);
        if (codiceArticolo != null && !codiceArticolo.equals("")) {
            _log.info("Codice Articolo: " + codiceArticolo);
            String codiceAssociato = ParamUtil.getString(areq,
                    "codiceAssociato", null);
            if (codiceAssociato != null && !codiceAssociato.equals("")) {
                ArticoliAssociatoOP articoliAssociatoOP = ArticoliAssociatoOPLocalServiceUtil
                        .createArticoliAssociatoOP(new ArticoliAssociatoOPPK(
                                rigoDocumentoPK.getIdAssociato(),
                                codiceAssociato));
                articoliAssociatoOP.setCodiceArticoloOP(codiceArticolo);
                try {
                    _log.info("Adding: " + articoliAssociatoOP);
                    ArticoliAssociatoOPLocalServiceUtil
                            .addArticoliAssociatoOP(articoliAssociatoOP);
                    _log.info("Saved: " + articoliAssociatoOP);
                } catch (SystemException e) {
                    SessionErrors.add(areq, "error-saving-articoliAssociatoOP");
                    e.printStackTrace();
                }
                try {
                    List<WKRigoDocumento> rows = WKRigoDocumentoLocalServiceUtil
                            .getByAnnoAssociato(rigoDocumentoPK.getAnno(),
                                    rigoDocumentoPK.getIdAssociato());
                    for (WKRigoDocumento wkRigoDocumento : rows) { // Aggiorno
                                                                   // tutti i
                                                                   // documenti
                                                                   // con
                                                                   // quell'articolo
                        if (wkRigoDocumento.getCodiceArticolo().equals(
                                codiceAssociato)) {
                            _log.info("Updating: " + wkRigoDocumento);
                            wkRigoDocumento.setCodiceArticolo(codiceArticolo);
                            wkRigoDocumento.setVerificato(true);
                            WKRigoDocumentoLocalServiceUtil
                                    .updateWKRigoDocumento(wkRigoDocumento);
                        }
                    }

                } catch (SystemException e) {
                    SessionErrors.add(areq, "error-updating");
                    e.printStackTrace();
                }
            }
            WKTestataDocumentoPK testataDocumentoPK = new WKTestataDocumentoPK(
                    rigoDocumentoPK.getAnno(),
                    rigoDocumentoPK.getNumeroOrdine(),
                    rigoDocumentoPK.getTipoDocumento(),
                    rigoDocumentoPK.getIdAssociato());
            ares.setRenderParameter("WKTestataDocumentoPK",
                    JSONFactoryUtil.looseSerialize(testataDocumentoPK));
            ares.setRenderParameter("jspPage", "/jsps/edit-document.jsp");
        } else {
            SessionErrors.add(areq, "no-valid-code");

            ares.setRenderParameter("WKRigoDocumentoPK", json);
            ares.setRenderParameter("jspPage", "/jsps/edit-row.jsp");
        }

    }

    public void validateDocument(ActionRequest areq, ActionResponse ares) {

        String json = ParamUtil.getString(areq, "WKTestataDocumentoPK", null);
        String codClienteAssociato = ParamUtil.getString(areq,
                "codClienteAssociato", "");
        String codCliente = ParamUtil.getString(areq, "codCliente", "");
        String ragioneSociale = ParamUtil.getString(areq, "cliente", "");

        if (json != null && !json.equals("")) {
            WKTestataDocumentoPK testataDocumentoPK = JSONFactoryUtil
                    .looseDeserializeSafe(json, WKTestataDocumentoPK.class);

            _log.info("codCliente: " + codCliente);
            _log.info("codClienteAssociato: " + codClienteAssociato);
            _log.info("cliente: " + ragioneSociale);

            if (!codClienteAssociato.equals("")) { // &&
                                                   // !codClienteAssociato.equals(codCliente)){
                                                   // // devo aggiungere alla
                                                   // tabella di associazione
                                                   // dei codici clienti
                AnagraficaAssociatoOP anagraficaAssociatoOP = null;
                try {
                    anagraficaAssociatoOP = AnagraficaAssociatoOPLocalServiceUtil
                            .getAnagraficaAssociatoOP(new AnagraficaAssociatoOPPK(
                                    testataDocumentoPK.getIdAssociato(),
                                    codClienteAssociato));

                } catch (PortalException e) {
                    _log.warn(e.getMessage());
                } catch (SystemException e) {
                    _log.warn(e.getMessage());
                }

                if (anagraficaAssociatoOP == null) {
                    anagraficaAssociatoOP = AnagraficaAssociatoOPLocalServiceUtil
                            .createAnagraficaAssociatoOP(new AnagraficaAssociatoOPPK(
                                    testataDocumentoPK.getIdAssociato(),
                                    codClienteAssociato));
                    anagraficaAssociatoOP.setCodiceSogettoOP(codCliente);
                    _log.info("Adding: " + anagraficaAssociatoOP
                            + " to anagrafica_associato_op");
                    try {
                        AnagraficaAssociatoOPLocalServiceUtil
                                .addAnagraficaAssociatoOP(anagraficaAssociatoOP);
                    } catch (SystemException e) {
                        _log.error(e.getMessage());
                        SessionErrors.add(areq, "error-updating");
                    }
                }
            }
            try {
                WKTestataDocumento t = WKTestataDocumentoLocalServiceUtil
                        .getWKTestataDocumento(testataDocumentoPK);
                List<WKRigoDocumento> rows = WKRigoDocumentoLocalServiceUtil
                        .getByNumeroOrdineAnnoAssociatoTipoDocumento(
                                t.getNumeroOrdine(), t.getAnno(),
                                t.getIdAssociato(), t.getTipoDocumento());
                boolean isReady = true;
                for (WKRigoDocumento wkRigoDocumento : rows) {

                    if (!wkRigoDocumento.getVerificato())
                        isReady = false;
                }

                _log.info("Updating: " + t);
                t.setVerificato(isReady);
                t.setCodiceSoggetto(codCliente);
                t.setRagioneSociale(ragioneSociale);
                WKTestataDocumentoLocalServiceUtil.updateWKTestataDocumento(t);

                if (isReady) {
                    SessionMessages.add(areq, "correctly-updated");
                } else {
                    ares.setRenderParameter("message",
                            "Attenzione non tutte le righe del documento sono state convalidate.");
                }
            } catch (PortalException e) {
                SessionErrors.add(areq, "error-updating");
                e.printStackTrace();
            } catch (SystemException e) {
                SessionErrors.add(areq, "error-updating");
                e.printStackTrace();
            }
            ares.setRenderParameter("WKTestataDocumentoPK",
                    JSONFactoryUtil.looseSerialize(testataDocumentoPK));

        }

        ares.setRenderParameter("jspPage", "/jsps/edit-document.jsp");
    }

    public void saveImported(ActionRequest areq, ActionResponse ares) {
        Associato a;
        try {
            UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                    .getUserIdMapper(Long.parseLong(areq.getRemoteUser()),
                            Constants.FUTURO_NET);
            a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper
                    .getUserIdMapperId());
            List<WKTestataDocumento> list = WKTestataDocumentoLocalServiceUtil
                    .getReady(Calendar.getInstance().get(Calendar.YEAR),
                            a.getId());

            for (WKTestataDocumento wkTestataDocumento : list) {
                if (wkTestataDocumento.getVerificato()) {
                    String tTipoDocumento = wkTestataDocumento
                            .getTipoDocumento();
                    boolean venditaDiretta = false;
                    if (tTipoDocumento.equals(FAT)) {
                        tTipoDocumento = FAC;
                        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil
                                .fetchOrganizzazioneProduttori(a.getIdOp());
                        venditaDiretta = (wkTestataDocumento
                                .getCodiceSoggetto().equals(String.valueOf(op
                                .getIdLiferay())));
                    }
                    TestataDocumento t;
                    try {
                        Anagrafica cliente = AnagraficaLocalServiceUtil
                                .getAnagrafica(wkTestataDocumento
                                        .getCodiceSoggetto());
                        t = TestataDocumentoLocalServiceUtil
                                .fetchTestataDocumento(new TestataDocumentoPK(
                                        wkTestataDocumento.getAnno(),
                                        wkTestataDocumento.getNumeroOrdine(),
                                        tTipoDocumento /*
                                                        * wkTestataDocumento.
                                                        * getTipoDocumento()
                                                        */, wkTestataDocumento
                                                .getIdAssociato()));
                        if (t == null)
                            t = TestataDocumentoLocalServiceUtil
                                    .createTestataDocumento(new TestataDocumentoPK(
                                            wkTestataDocumento.getAnno(),
                                            wkTestataDocumento
                                                    .getNumeroOrdine(),
                                            tTipoDocumento /*
                                                            * wkTestataDocumento.
                                                            * getTipoDocumento()
                                                            */,
                                            wkTestataDocumento.getIdAssociato()));
                        t.setCentro((tTipoDocumento.equals(FAC)) ? "1"
                                : wkTestataDocumento.getCentro());
                        if (tTipoDocumento.equals(FAC) && !venditaDiretta) {
                            t.setCodiceSoggetto(areq.getRemoteUser());
                        } else {
                            t.setCodiceSoggetto(wkTestataDocumento
                                    .getCodiceSoggetto());
                        }
                        t.setRagioneSociale(wkTestataDocumento
                                .getRagioneSociale());
                        t.setDestinazione(cliente.getIndirizzo());
                        t.setAspettoEsteriore(wkTestataDocumento
                                .getAspettoEsteriore());
                        t.setVettore(wkTestataDocumento.getVettore());
                        t.setVettore2(wkTestataDocumento.getVettore());
                        t.setDataOrdine(wkTestataDocumento.getDataOrdine());
                        t.setDataConsegna(wkTestataDocumento.getDataConsegna());
                        t.setLotto(wkTestataDocumento.getLotto());
                        t.setCompleto(COMPLETED);
                        t.setOperatore(areq.getRemoteUser());
                        t.setAutista(wkTestataDocumento.getAutista());
                        t.setCuraTrasporto(wkTestataDocumento
                                .getCuraTrasporto());
                        t.setCausaleTrasporto(wkTestataDocumento
                                .getCausaleTrasporto());
                        t.setPorto(wkTestataDocumento.getPorto());
                        t.setOrigine(wkTestataDocumento.getOrigine());
                        t.setRigoDescrittivo(wkTestataDocumento
                                .getRigoDescrittivo());
                        t.setCostoTrasporto(wkTestataDocumento
                                .getCostoTrasporto());
                        t.setNumeroPedaneEuro(wkTestataDocumento
                                .getNumeroPedaneEuro());
                        t.setNumeroPedaneNormali(wkTestataDocumento
                                .getNumeroPedaneNormali());
                        t.setTargaCamion(wkTestataDocumento.getTargaCamion());
                        t.setTargaRimorchio(wkTestataDocumento
                                .getTargaRimorchio());
                        t.setInviato(0);

                        TestataDocumentoLocalServiceUtil
                                .updateTestataDocumento(t); // Adds o updates

                        /** NON PIU' NECESSARIO NELLE NUOVE SPECIFICHE **/
                        // if(wkTestataDocumento.getTipoDocumento().equals(FAV)){
                        // t.setTipoDocumento(FAC);
                        // t.setCodiceSoggetto(areq.getRemoteUser());
                        // t.setRagioneSociale(a.getRagioneSociale());
                        // t.setDestinazione(a.getIndirizzo());
                        //
                        // TestataDocumentoLocalServiceUtil.updateTestataDocumento(t);
                        // // adds or update FAC
                        // }

                        List<WKRigoDocumento> rows = WKRigoDocumentoLocalServiceUtil
                                .getByNumeroOrdineAnnoAssociatoTipoDocumento(
                                        wkTestataDocumento.getNumeroOrdine(),
                                        wkTestataDocumento.getAnno(),
                                        wkTestataDocumento.getIdAssociato(),
                                        wkTestataDocumento.getTipoDocumento());
                        // for (WKRigoDocumento wkRigoDocumento : rows) {
                        RigoDocumentoLocalServiceUtil
                                .deleteRigoByNumeroOrdineAnnoAssociato(
                                        wkTestataDocumento.getNumeroOrdine(),
                                        wkTestataDocumento.getAnno(),
                                        wkTestataDocumento.getIdAssociato(),
                                        tTipoDocumento /*
                                                        * wkTestataDocumento.
                                                        * getTipoDocumento()
                                                        */);
                        for (int i = 0; i < rows.size(); i++) {
                            WKRigoDocumento wkRigoDocumento = rows.get(i);
                            // RigoDocumento r =
                            // RigoDocumentoLocalServiceUtil.fetchRigoDocumento(new
                            // RigoDocumentoPK(wkRigoDocumento.getAnno(),
                            // wkRigoDocumento.getNumeroOrdine(),
                            // wkRigoDocumento.getRigoOrdine(),
                            // wkRigoDocumento.getTipoDocumento(),
                            // wkRigoDocumento.getIdAssociato()));
                            // if(r == null)
                            if (!wkRigoDocumento.getDescrizione().contains(
                                    "Documento di trasporto")
                                    || wkRigoDocumento.getTipoDocumento()
                                            .equals(FAV)) {
                                RigoDocumento r = RigoDocumentoLocalServiceUtil
                                        .createRigoDocumento(new RigoDocumentoPK(
                                                wkRigoDocumento.getAnno(),
                                                wkRigoDocumento
                                                        .getNumeroOrdine(),
                                                wkRigoDocumento.getRigoOrdine(),
                                                tTipoDocumento /*
                                                                * wkRigoDocumento.
                                                                * getTipoDocumento
                                                                * ()
                                                                */,
                                                wkRigoDocumento
                                                        .getIdAssociato()));
                                r.setCodiceArticolo(wkRigoDocumento
                                        .getCodiceArticolo());
                                r.setDescrizione(wkRigoDocumento
                                        .getDescrizione());
                                r.setCodiceVariante(wkRigoDocumento
                                        .getCodiceVariante());
                                String variante = "";
                                if (!wkRigoDocumento.getCodiceVariante()
                                        .isEmpty())
                                    variante = DescrizioniVariantiLocalServiceUtil
                                            .getDescrizioniVarianti(
                                                    wkRigoDocumento
                                                            .getCodiceVariante())
                                            .getDescrizioneVariante();
                                r.setDescrizioneVariante(variante);
                                r.setUnitaMisura(wkRigoDocumento
                                        .getUnitaMisura());
                                r.setColli(wkRigoDocumento.getColli());
                                r.setPedane(wkRigoDocumento.getPesoLordo());
                                r.setPesoLordo(wkRigoDocumento.getPesoLordo());
                                r.setTara(wkRigoDocumento.getTara());
                                r.setPesoNetto(wkRigoDocumento.getPesoNetto());
                                r.setPrezzo(wkRigoDocumento.getPrezzo());
                                r.setPedane(wkRigoDocumento.getPedane());
                                r.setNote(wkRigoDocumento.getNote());
                                r.setTotalePesata(wkRigoDocumento
                                        .getTotalePesata());
                                r.setGestioneReti(wkRigoDocumento
                                        .getGestioneReti());
                                r.setRtxCl(wkRigoDocumento.getRtxCl());
                                r.setKgRete(wkRigoDocumento.getKgRete());
                                r.setLotto(wkRigoDocumento.getLotto());
                                r.setPassaporto(wkRigoDocumento.getPassaporto());
                                r.setSconto1(wkRigoDocumento.getSconto1());
                                r.setSconto2(wkRigoDocumento.getSconto2());
                                r.setSconto3(wkRigoDocumento.getSconto3());
                                if (!wkRigoDocumento.getCodiceArticolo()
                                        .equals("")
                                        && !wkRigoDocumento.getDescrizione()
                                                .equals("")) {
                                    if (i + 1 < rows.size()) {
                                        WKRigoDocumento rigoImballo = rows
                                                .get(i + 1);
                                        if (wkTestataDocumento
                                                .getTipoDocumento().equals(DDT))
                                            r.setRigoOrdine(wkRigoDocumento
                                                    .getRigoOrdine() + 1);
                                        r.setImballo(rigoImballo
                                                .getCodiceArticolo());
                                        WKRigoDocumentoLocalServiceUtil
                                                .deleteWKRigoDocumento(rigoImballo);
                                        i++;
                                    }
                                }
                                _log.info("Adding/updating: " + r);
                                RigoDocumentoLocalServiceUtil
                                        .updateRigoDocumento(r);
                            }
                            /** NON PIU' NECESSARIO NELLE NUOVE SPECIFICHE **/
                            // if(wkRigoDocumento.getTipoDocumento().equals(FAV)){
                            // r.setTipoDocumento(FAC);
                            // RigoDocumentoLocalServiceUtil.updateRigoDocumento(r);
                            // }
                            WKRigoDocumentoLocalServiceUtil
                                    .deleteWKRigoDocumento(wkRigoDocumento);

                        }

                        WKTestataDocumentoLocalServiceUtil
                                .deleteWKTestataDocumento(wkTestataDocumento);
                        stampaENotifica(t, a, areq);
                    } catch (PortalException e) {
                        e.printStackTrace();
                    } catch (AddressException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (JRException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }

        } catch (NoSuchAssociatoException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ares.setRenderParameter("jspPage", "/jsps/validate.jsp");
    }

    private void stampaENotifica(TestataDocumento t, Associato a,
            ActionRequest areq) throws PortalException, SystemException,
            ClassNotFoundException, JRException, SQLException,
            AddressException, IOException {

        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil
                .getOrganizzazioneProduttori(a.getIdOp());
        boolean toOp = t.getCodiceSoggetto().equals(
                String.valueOf(op.getIdLiferay()));
        Report r = new Report();
        String ddt = r.print(t.getAnno(), (int) t.getNumeroOrdine(),
                new Long(a.getId()).intValue(), t.getTipoDocumento()
                        .toLowerCase(), op.getIdLiferay(), toOp,
                getLogoAssociato(areq, a, op));

        File file = new File(ddt);

        addToDL(t.getAnno(), (int) t.getNumeroOrdine(), file, areq, !t
                .getTipoDocumento().equals(DDA) ? t.getTipoDocumento() : DDT);

        // sendEmail(a, op, (int) t.getNumeroOrdine(), false,
        // (t.getTipoDocumento().equals(FAC)) ? FAV.toLowerCase() :
        // t.getTipoDocumento().toLowerCase(), file, fileName + ".pdf");

    }

    private void storeImportedDocument(List<Documento> docsReady,
            List<Documento> docsToCheck) throws PortalException {
        try {

            for (Documento documento : docsReady) {
                WKTestataDocumento t = documento.getTestata();

                WKTestataDocumentoLocalServiceUtil.addWKTestataDocumento(t);
                List<WKRigoDocumento> rows = documento.getRighe();
                // for (WKRigoDocumento rigo : documento.getRighe()) {
                for (int i = 0; i < rows.size(); i++) {
                    WKRigoDocumento rigo = rows.get(i);
                    if (rigo.getRigoOrdine() == 0)
                        rigo.setRigoOrdine(rows.size());
                    // else
                    // rigo.setRigoOrdine(i);

                    if (rigo.getTipoDocumento().equals(FAV)) {
                        int riferimentoBolla = rigo.getRiferimentoBolla();
                        if (riferimentoBolla != 0) {
                            TestataDocumento testataDDT = TestataDocumentoLocalServiceUtil
                                    .getTestataDocumento(new TestataDocumentoPK(
                                            t.getAnno(), riferimentoBolla, DDT,
                                            rigo.getIdAssociato()));
                            testataDDT.setCompleto(INVOICED);
                            TestataDocumentoLocalServiceUtil
                                    .updateTestataDocumento(testataDDT);
                        }

                    } else if (rigo.getTipoDocumento().equals(FAT)) {
                        long idOp = Long.parseLong(t.getCodiceSoggetto());
                        OrganizzazioneProduttori op = null;
                        try {
                            op = OrganizzazioneProduttoriLocalServiceUtil
                                    .getOP(idOp);
                        } catch (NoSuchOrganizzazioneProduttoriException ex) {
                            _log.warn("Nesuna OP trovata con il codice: "
                                    + idOp);
                        }
                        if (op != null) {
                            int riferimentoBolla = rigo.getRiferimentoBolla();
                            if (riferimentoBolla != 0) {
                                TestataDocumento testataDDA = TestataDocumentoLocalServiceUtil
                                        .getTestataDocumento(new TestataDocumentoPK(
                                                t.getAnno(), riferimentoBolla,
                                                DDA, rigo.getIdAssociato()));
                                testataDDA.setCompleto(INVOICED);
                                TestataDocumentoLocalServiceUtil
                                        .updateTestataDocumento(testataDDA);
                            }
                        }
                    }
                    WKRigoDocumentoLocalServiceUtil.addWKRigoDocumento(rigo);
                }

            }
            for (Documento documento : docsToCheck) {
                WKTestataDocumento t = documento.getTestata();
                WKTestataDocumentoLocalServiceUtil.addWKTestataDocumento(t);

                List<WKRigoDocumento> rows = documento.getRighe();
                // for (WKRigoDocumento rigo : documento.getRighe()) {
                for (int i = 0; i < rows.size(); i++) {
                    WKRigoDocumento rigo = rows.get(i);
                    if (rigo.getRigoOrdine() == 0)
                        rigo.setRigoOrdine(rows.size());
                    // else
                    // rigo.setRigoOrdine(i);
                    WKRigoDocumentoLocalServiceUtil.addWKRigoDocumento(rigo);
                }

            }
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }

    private List<Documento> parseImportedFile(File uploadedFile,
            long idAssociato) throws Exception {

        FileReader fileReader = new FileReader(uploadedFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Documento> tmpDocs = new ArrayList<Documento>();
        WKTestataDocumento testataDocumento = null;
        List<WKRigoDocumento> righeDocumento = null;

        String line = bufferedReader.readLine();
        while (line != null) {
            String[] st = line.split(";");
            if (st.length > 0) {
                switch (st[0]) {
                case "WorkTestataDocumento":
                    // if(testataDocumento != null && righeDocumento != null){
                    if (righeDocumento != null) {
                        _log.info("Adding to tmpDocs ...");
                        tmpDocs.add(new Documento(testataDocumento,
                                righeDocumento));
                    }

                    testataDocumento = null;
                    righeDocumento = null;

                    _log.info("Found document header, read the single line...");
                    if ((line = bufferedReader.readLine()) != null) {
                        _log.info("Line: " + line);
                        st = line.split(";");
                        testataDocumento = CSVParser
                                .getTestata(st, idAssociato);
                        line = bufferedReader.readLine();
                    }
                    break;
                case "WorkRigaDocumento":
                    _log.info("Found row header, loop on rows...");
                    if (testataDocumento != null) {
                        righeDocumento = new ArrayList<WKRigoDocumento>();

                        int i = 1;
                        while ((line = bufferedReader.readLine()) != null) {
                            _log.info("Line: [" + line + "] i: " + i);
                            st = line.split(";");
                            if (!st[0].equals("WorkTestataDocumento")) {
                                if (testataDocumento.getTipoDocumento().equals(
                                        DDT)
                                        || testataDocumento.getTipoDocumento()
                                                .equals(DDA))
                                    righeDocumento
                                            .add(CSVParser.getRigo(
                                                    st,
                                                    testataDocumento,
                                                    (Integer.parseInt(st[26]) > righeDocumento
                                                            .size()) ? -1
                                                            : righeDocumento
                                                                    .get(righeDocumento
                                                                            .size() - 1)
                                                                    .getRigoOrdine() + 1,
                                                    idAssociato));
                                else { // if(testataDocumento.getTipoDocumento().contains("FA")){
                                    Map.Entry<Integer, WKRigoDocumento> entry = CSVParser
                                            .getRigoFattura(st,
                                                    testataDocumento,
                                                    idAssociato);
                                    if (entry != null) {

                                        if (righeDocumento.isEmpty())
                                            righeDocumento
                                                    .add(entry.getValue());
                                        else {
                                            for (int j = 0; j < righeDocumento
                                                    .size(); j++) {
                                                if (entry.getKey() < righeDocumento
                                                        .get(j).getRigoOrdine()) {
                                                    righeDocumento.add(j,
                                                            entry.getValue());
                                                    entry = null;
                                                    break;
                                                }
                                            }
                                            if (entry != null)
                                                righeDocumento.add(entry
                                                        .getValue());
                                        }
                                    }
                                }
                                // else if
                                // (testataDocumento.getTipoDocumento().equals(NAC)){
                                // throw new NotImplementedException();
                                // }
                                // else if
                                // (testataDocumento.getTipoDocumento().equals(FAT))
                                // {
                                // testataDocumento.setTipoDocumento(DDTPortlet.FAC);
                                // testataDocumento.setCentro(DDTPortlet.OP_VAT_CENTER);
                                // Map.Entry<Integer, WKRigoDocumento> entry =
                                // CSVParser.getRigoFattura(st,
                                // testataDocumento, idAssociato);
                                // if(entry != null){
                                //
                                // if(righeDocumento.isEmpty())
                                // righeDocumento.add(entry.getValue());
                                // else{
                                // for (int j = 0; j < righeDocumento.size();
                                // j++) {
                                // if(entry.getKey() <
                                // righeDocumento.get(j).getRigoOrdine()){
                                // righeDocumento.add(j, entry.getValue());
                                // entry = null;
                                // break;
                                // }
                                // }
                                // if(entry != null)
                                // righeDocumento.add(entry.getValue());
                                // }
                                // }
                                // }
                            } else {
                                break;
                            }
                            i++;
                        }
                    } else {
                        throw new Exception(
                                "Documento non formattato correttamente.");
                    }

                    break;
                default:
                    _log.error("Unrecognized string for: "
                            + StringUtil.merge(Arrays.asList(st), ";"));
                    throw new Exception(
                            "Documento non formattato correttamente.");
                }
            }
        }
        fileReader.close();

        // Add last document
        if (testataDocumento != null && righeDocumento != null) {
            _log.info("Adding last to tmpDocs ...");
            tmpDocs.add(new Documento(testataDocumento, righeDocumento));
        }
        return tmpDocs;
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException {
        // System.out.println("#############AJAX CALL####################");

        String resourceID = resourceRequest.getResourceID();

        Gson gson = new Gson();
        PrintWriter writer;
        Response response = new Response();
        resourceResponse.setContentType(MediaType.APPLICATION_JSON);
        Associato associato;
        OrganizzazioneProduttori op;
        Report r;
        int nDocConf, nDoc, year;
        String codiceCliente;
        boolean update;
        boolean send;
        UserIdMapper userIdMapper = null;

        switch (CommandID.valueOf(resourceID)) {
        case modify: {
            writer = resourceResponse.getWriter();
            try {
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                op = OrganizzazioneProduttoriLocalServiceUtil
                        .fetchOrganizzazioneProduttori(associato.getIdOp());
                codiceCliente = ParamUtil.getString(resourceRequest,
                        "codiceCliente");
                if (codiceCliente.equals(String.valueOf(op.getIdLiferay()))) { // Se
                                                                               // il
                                                                               // cliente
                                                                               // è
                                                                               // la
                                                                               // OP
                    response = saveDDT(resourceRequest, associato, true, DDA);
                } else {
                    response = saveDDT(resourceRequest, associato, true, DDT);
                }
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
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                op = OrganizzazioneProduttoriLocalServiceUtil
                        .fetchOrganizzazioneProduttori(associato.getIdOp());
                codiceCliente = ParamUtil.getString(resourceRequest,
                        "codiceCliente");
                int protocollo = ParamUtil.getInteger(resourceRequest,
                        "avanzaProtocollo");
                if (codiceCliente.equals(String.valueOf(op.getIdLiferay()))) { // Se
                                                                               // il
                                                                               // cliente
                                                                               // è
                                                                               // la
                                                                               // OP
                    if (protocollo != 0) { // Il numero del DDT deve essere
                                           // valorizzato
                        response = saveDDT(resourceRequest, associato, false,
                                DDA);
                    } else {
                        response = new Response(Code.SPECIFY_NUMBER, -1);
                    }
                } else {
                    response = saveDDT(resourceRequest, associato, false, DDT);
                }
            } catch (JSONException ex) {
                _log.error(ex.getMessage());
                response = new Response(Response.Code.PARSING_JSON_ERROR, -1);
            } catch (SystemException ex) {
                _log.error(ex.getMessage());
                response = new Response(Response.Code.INSERT_ERROR, -1);
                // writer.print(response);
            } catch (NoSuchAssociatoException ex) {
                _log.error(ex.getMessage());
                response = new Response(Response.Code.SENDING_MAIL_ERROR, -1);
                // writer.print(response);
            } catch (PortalException ex) {
                _log.error(ex.getMessage());
                response = new Response(Response.Code.INSERT_ERROR, -1);
                // writer.print(response);
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

            year = ParamUtil.getInteger(resourceRequest, "year", ANNO);
            nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
            codiceCliente = ParamUtil.getString(resourceRequest,
                    "codiceCliente");
            update = ParamUtil.getBoolean(resourceRequest, "update");
            send = ParamUtil.getBoolean(resourceRequest, "send");

            if (nDoc != 0) {
                try {
                    userIdMapper = UserIdMapperLocalServiceUtil
                            .getUserIdMapper(Long.parseLong(resourceRequest
                                    .getRemoteUser()), Constants.FUTURO_NET);
                    associato = AssociatoLocalServiceUtil
                            .findByLiferayId(userIdMapper.getUserIdMapperId());
                    op = OrganizzazioneProduttoriLocalServiceUtil
                            .getOrganizzazioneProduttori(associato.getIdOp());
                    String ddt;
                    String tipoDocumento;
                    if (!codiceCliente
                            .equals(String.valueOf(op.getIdLiferay()))) { // DDT
                                                                          // to
                                                                          // final
                                                                          // client
                        ddt = r.print(year, nDoc,
                                new Long(associato.getId()).intValue(),
                                op.getIdLiferay());
                        tipoDocumento = DDT;
                    } else {// DDT to OP
                        ddt = r.print(
                                year,
                                nDoc,
                                new Long(associato.getId()).intValue(),
                                DDT.toLowerCase(),
                                op.getIdLiferay(),
                                true,
                                getLogoAssociato(resourceRequest, associato, op));
                        tipoDocumento = DDA;
                    }

                    File file = new File(ddt);
                    InputStream in = new FileInputStream(file);

                    String fileName = addToDL(year, nDoc, file,
                            resourceRequest, tipoDocumento);

                    if (send) {
                        sendEmail(associato, op, nDoc, update, DDT, file,
                                fileName + ".pdf");
                    }

                    HttpServletResponse httpRes = PortalUtil
                            .getHttpServletResponse(resourceResponse);
                    HttpServletRequest httpReq = PortalUtil
                            .getHttpServletRequest(resourceRequest);
                    ServletResponseUtil.sendFile(httpReq, httpRes,
                            file.getName(), in, "application/pdf");

                    in.close();

                } catch (JRException ex) {
                    _log.error(ex.getMessage());
                    ex.printStackTrace();
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
                    // response = new Response(Response.Code.SENDING_MAIL_ERROR,
                    // -1);
                }
            }
            break;
        }
        case generateInvoice: {
            writer = resourceResponse.getWriter();
            try {
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                op = OrganizzazioneProduttoriLocalServiceUtil
                        .getOrganizzazioneProduttori(associato.getIdOp());
                response = saveInvoice(resourceRequest, associato, op, false);
                // sendEmail(associato, op, response.getId(), false, FAV);
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
            year = ParamUtil.getInteger(resourceRequest, "year", ANNO);
            nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
            nDocConf = ParamUtil.getInteger(resourceRequest, "nDocConf");
            codiceCliente = ParamUtil.getString(resourceRequest,
                    "codiceCliente");
            update = ParamUtil.getBoolean(resourceRequest, "update");
            send = ParamUtil.getBoolean(resourceRequest, "send");

            try {
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                op = OrganizzazioneProduttoriLocalServiceUtil
                        .getOrganizzazioneProduttori(associato.getIdOp());
                File fileFattura = null;
                if (nDocConf != 0) {
                    String fac = r.print(year, nDocConf,
                            new Long(associato.getId()).intValue(),
                            FAC.toLowerCase(), op.getIdLiferay(), false,
                            getLogoAssociato(resourceRequest, associato, op));

                    File fileFac = new File(fac);
                    addToDL(year, nDocConf, fileFac, resourceRequest, FAC);
                    fileFattura = fileFac;
                }

                if (nDoc != 0) {
                    String fav;
                    if (codiceCliente.equals(String.valueOf(op.getIdLiferay())))
                        fav = r.print(
                                year,
                                nDoc,
                                new Long(associato.getId()).intValue(),
                                FAV.toLowerCase(),
                                op.getIdLiferay(),
                                true,
                                getLogoAssociato(resourceRequest, associato, op));
                    else
                        fav = r.print(year, nDoc,
                                new Long(associato.getId()).intValue(),
                                FAV.toLowerCase(), op.getIdLiferay());
                    File fileFav = new File(fav);

                    String fileName = addToDL(year, nDoc, fileFav,
                            resourceRequest, FAV);

                    if (send) {
                        sendEmail(associato, op, nDoc, update, FAV, fileFav,
                                fileName + ".pdf");
                    }
                    fileFattura = fileFav;
                }

                InputStream in = new FileInputStream(fileFattura);
                HttpServletResponse httpRes = PortalUtil
                        .getHttpServletResponse(resourceResponse);
                HttpServletRequest httpReq = PortalUtil
                        .getHttpServletRequest(resourceRequest);
                ServletResponseUtil.sendFile(httpReq, httpRes,
                        fileFattura.getName(), in, "application/pdf");

                in.close();

            } catch (JRException ex) {
                _log.error(ex.getMessage());
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                _log.error(ex.getMessage());
            } catch (SQLException ex) {
                _log.error(ex.getMessage());
            } catch (SystemException ex) {
                _log.error(ex.getMessage());
                // ex.printStackTrace();
            } catch (PortalException ex) {
                _log.error(ex.getMessage());
                ex.printStackTrace();
            } catch (AddressException ex) {
                _log.error(ex.getMessage());
                // response = new Response(Response.Code.SENDING_MAIL_ERROR,
                // -1);
            }
            break;
        }
        case updateInvoice: {
            writer = resourceResponse.getWriter();
            try {
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                op = OrganizzazioneProduttoriLocalServiceUtil
                        .getOrganizzazioneProduttori(associato.getIdOp());
                response = saveInvoice(resourceRequest, associato, op, true);
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
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                // op =
                // OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(associato.getIdOp());
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

            year = ParamUtil.getInteger(resourceRequest, "year", ANNO);
            nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
            // boolean update = ParamUtil.getBoolean(resourceRequest, "update");
            send = ParamUtil.getBoolean(resourceRequest, "send");

            if (nDoc != 0) {
                try {
                    userIdMapper = UserIdMapperLocalServiceUtil
                            .getUserIdMapper(Long.parseLong(resourceRequest
                                    .getRemoteUser()), Constants.FUTURO_NET);
                    associato = AssociatoLocalServiceUtil
                            .findByLiferayId(userIdMapper.getUserIdMapperId());
                    op = OrganizzazioneProduttoriLocalServiceUtil
                            .getOrganizzazioneProduttori(associato.getIdOp());
                    String trace = r.printTrace(ANNO, nDoc,
                            new Long(associato.getId()).intValue(), TRAC,
                            op.getIdLiferay());

                    File file = new File(trace);
                    InputStream in = new FileInputStream(file);

                    String fileName = addToDL(year, nDoc, file,
                            resourceRequest, TRAC);
                    if (send) {
                        sendEmail(associato, op, nDoc, false, TRAC, file,
                                fileName + ".pdf");
                    }

                    HttpServletResponse httpRes = PortalUtil
                            .getHttpServletResponse(resourceResponse);
                    HttpServletRequest httpReq = PortalUtil
                            .getHttpServletRequest(resourceRequest);
                    ServletResponseUtil.sendFile(httpReq, httpRes,
                            file.getName(), in, "application/pdf");

                    in.close();
                } catch (JRException ex) {
                    _log.error(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    _log.error(ex.getMessage());
                } catch (SQLException ex) {
                    _log.error(ex.getMessage());
                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    // ex.printStackTrace();
                } catch (PortalException ex) {
                    _log.error(ex.getMessage());
                    ex.printStackTrace();
                } catch (AddressException ex) {
                    _log.error(ex.getMessage());
                    // response = new Response(Response.Code.SENDING_MAIL_ERROR,
                    // -1);
                    // writer.print(response);
                }
            }
            break;
        }
        case saveCreditNote: {
            writer = resourceResponse.getWriter();
            try {
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                op = OrganizzazioneProduttoriLocalServiceUtil
                        .getOrganizzazioneProduttori(associato.getIdOp());
                response = saveCreditNote(resourceRequest, associato, op, false);
                // sendEmail(associato, op, response.getId(), false, FAV);
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
        case updateCreditNote: {
            writer = resourceResponse.getWriter();
            try {
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                op = OrganizzazioneProduttoriLocalServiceUtil
                        .getOrganizzazioneProduttori(associato.getIdOp());
                response = saveCreditNote(resourceRequest, associato, op, true);
                sendEmail(associato, op, response.getId(), true, NAC);
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
        case printCreditNote: {

            r = new Report();
            year = ParamUtil.getInteger(resourceRequest, "year", ANNO);
            nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
            codiceCliente = ParamUtil.getString(resourceRequest,
                    "codiceCliente");
            update = ParamUtil.getBoolean(resourceRequest, "update");
            send = ParamUtil.getBoolean(resourceRequest, "send");

            if (nDoc != 0) {
                try {
                    userIdMapper = UserIdMapperLocalServiceUtil
                            .getUserIdMapper(Long.parseLong(resourceRequest
                                    .getRemoteUser()), Constants.FUTURO_NET);
                    associato = AssociatoLocalServiceUtil
                            .findByLiferayId(userIdMapper.getUserIdMapperId());
                    op = OrganizzazioneProduttoriLocalServiceUtil
                            .getOrganizzazioneProduttori(associato.getIdOp());
                    String nac;
                    if (codiceCliente.equals(String.valueOf(op.getIdLiferay())))
                        nac = r.print(
                                year,
                                nDoc,
                                new Long(associato.getId()).intValue(),
                                NAC.toLowerCase(),
                                op.getIdLiferay(),
                                true,
                                getLogoAssociato(resourceRequest, associato, op));
                    else
                        nac = r.print(year, nDoc,
                                new Long(associato.getId()).intValue(),
                                NAC.toLowerCase(), op.getIdLiferay());

                    File fileNac = new File(nac);
                    InputStream in = new FileInputStream(fileNac);

                    String fileName = addToDL(year, nDoc, fileNac,
                            resourceRequest, NAC);

                    if (send) {
                        sendEmail(associato, op, nDoc, update, NAC, fileNac,
                                fileName + ".pdf");
                    }

                    HttpServletResponse httpRes = PortalUtil
                            .getHttpServletResponse(resourceResponse);
                    HttpServletRequest httpReq = PortalUtil
                            .getHttpServletRequest(resourceRequest);
                    ServletResponseUtil.sendFile(httpReq, httpRes,
                            fileNac.getName(), in, "application/pdf");

                    in.close();

                } catch (JRException ex) {
                    _log.error(ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    _log.error(ex.getMessage());
                } catch (SQLException ex) {
                    _log.error(ex.getMessage());
                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    // ex.printStackTrace();
                } catch (PortalException ex) {
                    _log.error(ex.getMessage());
                    ex.printStackTrace();
                } catch (AddressException ex) {
                    _log.error(ex.getMessage());
                    // response = new Response(Response.Code.SENDING_MAIL_ERROR,
                    // -1);
                }
            }
            break;
        }
        case printCMR: {
            r = new Report();
            nDoc = ParamUtil.getInteger(resourceRequest, "nDoc");
            if (nDoc > 0) {
                try {
                    userIdMapper = UserIdMapperLocalServiceUtil
                            .getUserIdMapper(Long.parseLong(resourceRequest
                                    .getRemoteUser()), Constants.FUTURO_NET);
                    associato = AssociatoLocalServiceUtil
                            .findByLiferayId(userIdMapper.getUserIdMapperId());
                    op = OrganizzazioneProduttoriLocalServiceUtil
                            .getOrganizzazioneProduttori(associato.getIdOp());
                    year = Calendar.getInstance().get(Calendar.YEAR);
                    String cmr = r.printCMR(CMR_HEADER, year, nDoc, new Long(
                            associato.getId()).intValue(), CMR, op
                            .getIdLiferay());

                    File fileCMR = new File(cmr);
                    InputStream in = new FileInputStream(fileCMR);
                    HttpServletResponse httpRes = PortalUtil
                            .getHttpServletResponse(resourceResponse);
                    HttpServletRequest httpReq = PortalUtil
                            .getHttpServletRequest(resourceRequest);
                    ServletResponseUtil.sendFile(httpReq, httpRes,
                            fileCMR.getName(), in, "application/pdf");

                    in.close();
                } catch (NumberFormatException | SystemException
                        | ClassNotFoundException | JRException | SQLException
                        | PortalException ex) {
                    _log.error(ex.getMessage());
                }
            }
            break;
        }
        case saveCMR: {
            writer = resourceResponse.getWriter();
            try {
                year = Calendar.getInstance().get(Calendar.YEAR);
                userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
                associato = AssociatoLocalServiceUtil
                        .findByLiferayId(userIdMapper.getUserIdMapperId());
                nDoc = ParamUtil.getInteger(resourceRequest, "nDoc", -1);
                if (nDoc != -1) {
                    long nCMR = ParamUtil.getInteger(resourceRequest,
                            "numeroCMR", 0);
                    CMR cmr;
                    if (nCMR == 0) {
                        List<CMR> list = CMRLocalServiceUtil
                                .getCMRByAnnoAssociato(year, associato.getId());
                        if (list.size() > 0) {
                            nCMR = list.get(0).getNumeroCMR();
                        }
                        cmr = CMRLocalServiceUtil.createCMR(new CMRPK(nCMR + 1,
                                year, nDoc, (int) associato.getId()));
                    } else {
                        cmr = CMRLocalServiceUtil.getCMR(new CMRPK(nCMR, year,
                                nDoc, (int) associato.getId()));
                    }
                    cmr.setRiserve(ParamUtil.getString(resourceRequest,
                            "riserve", ""));
                    cmr.setAllegati(ParamUtil.getString(resourceRequest,
                            "allegati", ""));
                    cmr.setClasse(ParamUtil.getString(resourceRequest,
                            "classe", ""));
                    cmr.setCifra(ParamUtil.getString(resourceRequest, "cifra",
                            ""));
                    cmr.setLettera(ParamUtil.getString(resourceRequest,
                            "lettera", ""));
                    cmr.setAdr(ParamUtil.getString(resourceRequest, "adr", ""));
                    cmr.setIstruzioni(ParamUtil.getString(resourceRequest,
                            "istruzioni", ""));
                    cmr.setConvenzioni(ParamUtil.getString(resourceRequest,
                            "convenzioni", ""));
                    cmr.setRimborso(ParamUtil.getString(resourceRequest,
                            "rimborso", ""));
                    _log.info("Adding / Updating CRMR data: " + cmr);
                    CMRLocalServiceUtil.updateCMR(cmr);
                    response = new Response(Code.OK, new Long(
                            cmr.getNumeroCMR()).intValue());
                } else {
                    response = new Response(Code.NOT_VALID, -1);
                }
            } catch (NumberFormatException | SystemException | PortalException e) {
                _log.error(e.getMessage());
                response = new Response(Code.GENERIC_ERROR, e.hashCode());
            } finally {
                writer.print(gson.toJson(response));
                writer.flush();
                writer.close();
            }

            break;
        }
        default:
            _log.warn("Uknown operation.");
        }
    }

    public void addStack(ActionRequest arq, ActionResponse ars) {
        UploadPortletRequest ureq = PortalUtil.getUploadPortletRequest(arq);
        File file = (File) ureq.getFile("file");
        FileUploaderLocalServiceUtil.add((java.io.File) file);
    }

    private void sendEmail(Associato a, OrganizzazioneProduttori o,
            int numeroOrdine, boolean update, String tipoDocumento)
            throws AddressException {
        sendEmail(a, o, numeroOrdine, update, tipoDocumento, null, "");
    }

    private void sendEmail(Associato a, OrganizzazioneProduttori o,
            int numeroOrdine, boolean update, String tipoDocumento, File f,
            String fn) throws AddressException {
        MailMessage mailMessage = new MailMessage();
        String articolo = "";
        if (tipoDocumento.equals(DDT)) {
            articolo = "il DDT";
        } else if (tipoDocumento.equals(FAV)) {
            articolo = "la fattura";
        } else if (tipoDocumento.equals(TRAC)) {
            articolo = "l'allegato di tracciabilita' relativo al DDT";
        } else if (tipoDocumento.equals(NAC)) {
            articolo = "la nota di credito";
        }
        String action = update ? "\nha appena modificato " + articolo + ": "
                : "\nha appena creato " + articolo + ": ";
        String subject = update ? "Notifica modifica documento."
                : "Notifica creazione documento.";
        mailMessage
                .setBody("Spett. "
                        + o.getRagioneSociale()
                        + "\n\nLa presente per informarla che l'associato: "
                        + a.getRagioneSociale()
                        + action
                        + numeroOrdine
                        + "."
                        + "\nDistinti saluti."
                        + "\n\nP.S. Il presente messagio e' stato generato automaticamente per comunicazione all'associato scrivere all'indirizzo: "
                        + a.getEmail());
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

    private String addToDL(int year, int nDoc, File ddt,
            ResourceRequest resourceRequest, String tipoDocumento)
            throws SystemException, PortalException, FileNotFoundException {

        UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                .getUserIdMapper(
                        Long.parseLong(resourceRequest.getRemoteUser()),
                        Constants.FUTURO_NET);
        Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper
                .getUserIdMapperId());
        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil
                .getOrganizzazioneProduttori(a.getIdOp());
        User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
        User liferayAssociato = UserLocalServiceUtil.getUser(userIdMapper
                .getUserId());
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
                .getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getLayout().getGroupId();
        long repositoryId = themeDisplay.getScopeGroupId();
        DLFolder opFolder = Utils.getOpFolder(groupId, liferayOp);
        // _log.info("OP FOLDER: " + opFolder);
        DLFolder associatofolder = Utils.getAssociatoFolder(groupId, opFolder,
                liferayAssociato);
        // _log.info("ASSOCIATO FOLDER: " + associatofolder);
        DLFolder yearFolder = Utils.getAssociatoYearFolder(groupId,
                associatofolder, year);
        String nomeCartella = tipoDocumento;
        if (tipoDocumento.equals(TRAC) || tipoDocumento.equals(DDA)) {
            nomeCartella = DDT;
        }
        DLFolder documentFolder = Utils.getAssociatoDocumentFolder(groupId,
                yearFolder, nomeCartella);
        String sezionaleIva = a.getCentro();
        if (tipoDocumento.equals(FAC) || tipoDocumento.equals(DDA)) {
            sezionaleIva = OP_VAT_CENTER;
        }
        String fileName = tipoDocumento + "_" + year + "_" + nDoc + "_"
                + sezionaleIva;

        FileEntry fileEntry = null;
        try {
            fileEntry = DLAppServiceUtil.getFileEntry(groupId,
                    documentFolder.getFolderId(), fileName + ".pdf");
            _log.info("Entry found, the file will be replaced.");
        } catch (PortalException e) {
            _log.info("File Entry not found, a new file will be created.");
        }

        if (fileEntry != null) {
            DLAppServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
        }
        fileEntry = DLAppServiceUtil.addFileEntry(repositoryId,
                documentFolder.getFolderId(), fileName + ".pdf",
                MimeTypesUtil.getContentType(fileName + ".pdf"), fileName
                        + ".pdf", "", "", ddt, new ServiceContext());

        _log.info("Added: " + fileEntry.getTitle() + " to: /"
                + opFolder.getName() + "/" + associatofolder.getName() + "/"
                + yearFolder.getName() + "/" + documentFolder.getName());
        DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(),
                themeDisplay, fileName);

        return fileName;

    }

    private String addToDL(int year, int nDoc, File ddt, ActionRequest areq,
            String tipoDocumento) throws NumberFormatException,
            SystemException, PortalException {
        UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                .getUserIdMapper(Long.parseLong(areq.getRemoteUser()),
                        Constants.FUTURO_NET);
        Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper
                .getUserIdMapperId());
        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil
                .getOrganizzazioneProduttori(a.getIdOp());
        User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
        User liferayAssociato = UserLocalServiceUtil.getUser(a.getIdLiferay());
        ThemeDisplay themeDisplay = (ThemeDisplay) areq
                .getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getLayout().getGroupId();
        long repositoryId = themeDisplay.getScopeGroupId();
        DLFolder opFolder = Utils.getOpFolder(groupId, liferayOp);
        // _log.info("OP FOLDER: " + opFolder);
        DLFolder associatofolder = Utils.getAssociatoFolder(groupId, opFolder,
                liferayAssociato);
        // _log.info("ASSOCIATO FOLDER: " + associatofolder);
        DLFolder yearFolder = Utils.getAssociatoYearFolder(groupId,
                associatofolder, year);
        DLFolder documentFolder = Utils.getAssociatoDocumentFolder(groupId,
                yearFolder, tipoDocumento);
        String fileName = tipoDocumento + "_" + year + "_" + nDoc + "_"
                + (tipoDocumento.equals(FAC) ? OP_VAT_CENTER : a.getCentro());

        FileEntry fileEntry = null;
        try {
            fileEntry = DLAppServiceUtil.getFileEntry(groupId,
                    documentFolder.getFolderId(), fileName + ".pdf");
            _log.info("Entry found, the file will be replaced.");
        } catch (PortalException e) {
            _log.info("File Entry not found, a new file will be created.");
        }

        if (fileEntry != null) {
            DLAppServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
        }
        fileEntry = DLAppServiceUtil.addFileEntry(repositoryId,
                documentFolder.getFolderId(), fileName + ".pdf",
                MimeTypesUtil.getContentType(fileName + ".pdf"), fileName
                        + ".pdf", "", "", ddt, new ServiceContext());

        _log.info("Added: " + fileEntry.getTitle() + " to: /"
                + documentFolder.getName());
        DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(),
                themeDisplay, fileName);

        return fileName;
    }

    private String getLogoAssociato(ActionRequest actionRequest, Associato a,
            OrganizzazioneProduttori op) throws PortalException,
            SystemException, IOException {

        User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
        UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                .getUserIdMapper(a.getIdLiferay());
        User liferayAssociato = UserLocalServiceUtil.getUser(userIdMapper
                .getUserId());
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
                .getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getLayout().getGroupId();
        DLFolder opFolder = Utils.getOpFolder(groupId, liferayOp);
        // _log.info("OP FOLDER: " + opFolder);
        DLFolder associatofolder = Utils.getAssociatoFolder(groupId, opFolder,
                liferayAssociato);

        FileEntry fileEntry = null;
        try {
            fileEntry = DLAppServiceUtil.getFileEntry(groupId,
                    associatofolder.getFolderId(), "logo.jpg");
            _log.info("Entry found, the file will be replaced.");
        } catch (PortalException e) {
            _log.info("File Entry not found, a new file will be created.");
        }
        if (fileEntry != null) {
            File f = new File("/tmp/logo_" + a.getId() + ".jpg");
            if (!f.exists())
                f.createNewFile();
            FileUtil.write(f, fileEntry.getContentStream());
            return "/tmp/logo_" + a.getId() + ".jpg";
        } else
            return "";
    }

    private String getLogoAssociato(ResourceRequest resourceRequest,
            Associato a, OrganizzazioneProduttori op) throws PortalException,
            SystemException, IOException {

        User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
        UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                .getUserIdMapper(a.getIdLiferay());
        User liferayAssociato = UserLocalServiceUtil.getUser(userIdMapper
                .getUserId());
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
                .getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getLayout().getGroupId();
        DLFolder opFolder = Utils.getOpFolder(groupId, liferayOp);
        // _log.info("OP FOLDER: " + opFolder);
        DLFolder associatofolder = Utils.getAssociatoFolder(groupId, opFolder,
                liferayAssociato);

        FileEntry fileEntry = null;
        try {
            fileEntry = DLAppServiceUtil.getFileEntry(groupId,
                    associatofolder.getFolderId(), "logo.jpg");
            _log.info("Entry found, the file will be replaced.");
        } catch (PortalException e) {
            _log.info("File Entry not found, a new file will be created.");
        }
        if (fileEntry != null) {
            File f = new File("/tmp/logo_" + a.getId() + ".jpg");
            if (!f.exists())
                f.createNewFile();
            FileUtil.write(f, fileEntry.getContentStream());
            return "/tmp/logo_" + a.getId() + ".jpg";
        } else
            return "";
    }

    private Response saveDDT(ResourceRequest resourceRequest,
            Associato associato, boolean update, String tipoDocumento)
            throws SystemException, NoSuchAssociatoException, PortalException,
            ParseException {

        String string = new String(Base64.decode(ParamUtil.getString(
                resourceRequest, "data", null)));
        String codiceCliente = ParamUtil.getString(resourceRequest,
                "codiceCliente", null);
        String cliente = ParamUtil.getString(resourceRequest, "clienteTxt",
                null);
        String destinazioneTxt = ParamUtil.getString(resourceRequest,
                "destinazioneTxt", null);
        String codiceDestinazione = ParamUtil.getString(resourceRequest,
                "codiceDestinazione", null);
        String orderDate = ParamUtil.getString(resourceRequest, "orderDate",
                null);
        String deliveryDate = ParamUtil.getString(resourceRequest,
                "deliveryDate", null);
        String lottoTestata = ParamUtil.getString(resourceRequest,
                "lottoTestata", null);
        String vettore1 = ParamUtil
                .getString(resourceRequest, "vettore1", null);
        String vettore2 = ParamUtil
                .getString(resourceRequest, "vettore2", null);
        String autista = ParamUtil.getString(resourceRequest, "autista", null);
        String trasporto = ParamUtil.getString(resourceRequest, "trasporto",
                null);
        String aspetto = ParamUtil.getString(resourceRequest, "aspetto", null);
        String causale = ParamUtil.getString(resourceRequest, "causale", null);
        String porto = ParamUtil.getString(resourceRequest, "porto", null);
        String origine = ParamUtil.getString(resourceRequest, "origine", null);
        String rigoDescrittivo = ParamUtil.getString(resourceRequest, "rigo",
                null);
        double costo = ParamUtil.getDouble(resourceRequest, "costo");
        int pedaneEuro = ParamUtil.getInteger(resourceRequest, "pedane-euro");
        int pedaneNormali = ParamUtil.getInteger(resourceRequest,
                "pedane-normali");
        String motrice = ParamUtil.getString(resourceRequest, "motrice", null);
        String rimorchio = ParamUtil.getString(resourceRequest, "rimorchio",
                null);
        String numeroOrdineStr = ParamUtil.getString(resourceRequest,
                "numeroOrdine", null);
        int avanzaProtocollo = ParamUtil.getInteger(resourceRequest,
                "avanzaProtocollo", -1);

        int numeroOrdine;

        if (!numeroOrdineStr.equals("")) {
            numeroOrdine = Integer.parseInt(numeroOrdineStr);
            if (!update) { // RECUPERO PROTOCOLLO
                ProgressivoLocalServiceUtil
                        .deleteProgressivo(new ProgressivoPK(Calendar
                                .getInstance().get(Calendar.YEAR), associato
                                .getId(), Constants.DDT_ID, numeroOrdine));
            }
        } else if (avanzaProtocollo == -1) { // AVANZAMENTO PROTOCOLLO
                                             // AUTOMATICO
            try {
                // numeroOrdine =
                // TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR),
                // DDT, associato.getId()).size() + 1;
                // numeroOrdine = (int)
                // TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR),
                // DDT, associato.getId()).get(0).getNumeroOrdine() + 1;
                List<TestataDocumento> documentiSoggetto = TestataDocumentoLocalServiceUtil
                        .getDocumentiSoggetto(
                                Calendar.getInstance().get(Calendar.YEAR),
                                tipoDocumento, associato.getId());
                if (documentiSoggetto.size() > 0) {
                    numeroOrdine = (int) documentiSoggetto.get(0)
                            .getNumeroOrdine() + 1;
                    String dataTestataStr = documentiSoggetto.get(0)
                            .getDataOrdine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Date dataTestata = sdf.parse(dataTestataStr);
                    Date dataDocumento = sdf.parse(orderDate);
                    if (dataDocumento.before(dataTestata)) { // Verifico se la
                                                             // data è minore
                                                             // della data
                                                             // dell'ultimo
                                                             // documento
                        return new Response(Response.Code.DATE_BEFORE,
                                numeroOrdine);
                    }
                } else {
                    numeroOrdine = 1;
                }

            } catch (SystemException ex) {
                _log.error(ex.getMessage());
                return new Response(Response.Code.GET_PRIMARY_KEY_ERROR, -1);
            }
        } else { // AVANZAMENTO PROTOCOLLO MANUALE
            List<TestataDocumento> testate = TestataDocumentoLocalServiceUtil
                    .getDocumentiSoggetto(
                            Calendar.getInstance().get(Calendar.YEAR),
                            tipoDocumento, associato.getId());
            TestataDocumento t = TestataDocumentoLocalServiceUtil
                    .fetchTestataDocumento(new TestataDocumentoPK(ANNO,
                            avanzaProtocollo, tipoDocumento, associato.getId()));
            if (t != null) {
                _log.warn("Protocol already exists.");
                return new Response(Response.Code.ALREADY_EXISTS,
                        avanzaProtocollo);
            }
            for (TestataDocumento testata : testate) {
                if (avanzaProtocollo < testata.getNumeroOrdine()) {
                    String dataTestataStr = testata.getDataOrdine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Date dataTestata = sdf.parse(dataTestataStr);
                    Date dataDocumento = sdf.parse(orderDate);
                    if (dataDocumento.after(dataTestata)
                            || dataDocumento.equals(dataTestata)) {
                        return new Response(Response.Code.NOT_VALID,
                                avanzaProtocollo);
                    }
                }
            }
            numeroOrdine = avanzaProtocollo;
        }

        TestataDocumento testataDocumento;
        if (update) {
            testataDocumento = TestataDocumentoLocalServiceUtil
                    .fetchTestataDocumento(new TestataDocumentoPK(ANNO,
                            numeroOrdine, tipoDocumento, associato.getId()));
        } else {
            testataDocumento = TestataDocumentoLocalServiceUtil
                    .createTestataDocumento(new TestataDocumentoPK(ANNO,
                            numeroOrdine, tipoDocumento, associato.getId()));
        }
        testataDocumento.setAnno(ANNO);
        testataDocumento.setCodiceSoggetto(codiceCliente);
        if (tipoDocumento.equals(DDA)) {
            testataDocumento.setCentro(associato.getSezionaleOP());
        } else {
            testataDocumento.setCentro(associato.getCentro());
        }
        testataDocumento.setRagioneSociale(cliente);
        testataDocumento.setCodiceDestinazione(codiceDestinazione);
        testataDocumento.setDestinazione(destinazioneTxt);
        testataDocumento.setDataOrdine(orderDate);
        testataDocumento.setDataConsegna(deliveryDate);
        testataDocumento.setLotto(lottoTestata);
        testataDocumento.setCompleto(COMPLETED);
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

        // List<RigoDocumento> righe;
        if (update) {
            TestataDocumentoLocalServiceUtil
                    .updateTestataDocumento(testataDocumento);
            // righe =
            // RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(numeroOrdine,
            // ANNO, associato.getId());
        } else {
            TestataDocumentoLocalServiceUtil
                    .addTestataDocumento(testataDocumento);
        }

        JSONArray rowsJSON = JSONFactoryUtil.createJSONArray(string);
        for (int i = 0; i < rowsJSON.length(); i++) {

            JSONObject rowJSON = rowsJSON.getJSONObject(i);
            RigoDocumento rigo = JSONFactoryUtil.looseDeserialize(
                    rowJSON.toString(), RigoDocumentoImpl.class);

            _log.info("Variante: " + rigo.getDescrizioneVariante());

            String[] tmp = rigo.getDescrizioneVariante().split("-");

            if (tmp.length != 0) {
                rigo.setCodiceVariante(tmp[0].trim());
                if (tmp.length > 1)
                    rigo.setDescrizioneVariante(tmp[1].trim());
            }

            rigo.setAnno(ANNO);

            rigo.setNumeroOrdine(testataDocumento.getNumeroOrdine());
            rigo.setRigoOrdine(i + 1);
            rigo.setGestioneReti(rowJSON.getString("reti").equalsIgnoreCase(
                    "si"));
            rigo.setIdAssociato(associato.getId());
            rigo.setTipoDocumento(tipoDocumento);
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

    private Response saveInvoice(ResourceRequest resourceRequest,
            Associato associato, OrganizzazioneProduttori op, boolean update)
            throws PortalException, SystemException, ParseException {

        String string = new String(Base64.decode(ParamUtil.getString(
                resourceRequest, "data", null)));
        String codiceCliente = ParamUtil.getString(resourceRequest, "codCli",
                null);
        _log.info("****** codiceCliente: " + codiceCliente + " !!!");
        String cliente = ParamUtil.getString(resourceRequest, "clienteTxt",
                null);
        _log.info("****** cliente: " + cliente + " !!!");
        String destinazioneTxt = ParamUtil.getString(resourceRequest,
                "destinazioneTxt", null);
        _log.info("****** destinazioneTxt: " + destinazioneTxt + " !!!");
        String codiceDestinazione = ParamUtil.getString(resourceRequest,
                "codiceDestinazione", null);
        _log.info("****** codiceDestinazione: " + codiceDestinazione + " !!!");
        String documentDate = ParamUtil.getString(resourceRequest,
                "documentDate", null);
        _log.info("****** documentDate: " + documentDate + " !!!");
        String numeroFatturaStr = ParamUtil.getString(resourceRequest,
                "numeroFattura", null);
        _log.info("****** numeroFatturaStr: " + numeroFatturaStr + " !!!");
        int avanzaProtocollo = ParamUtil.getInteger(resourceRequest,
                "avanzaProtocollo", -1);
        _log.info("****** avanzaProtocollo: " + avanzaProtocollo + " !!!");
        int nDocConf = ParamUtil.getInteger(resourceRequest, "nDocConf", -1);
        _log.info("****** nDocDonf: " + nDocConf + " !!!");
        String dateDocConf = ParamUtil.getString(resourceRequest,
                "dateDocConf", null);
        _log.info("****** dateDocConf: " + dateDocConf + " !!!");

        long origDoc = ParamUtil
                .getLong(resourceRequest, "numeroDocumento", -1);
        _log.info("****** origDoc: " + origDoc + " !!!");
        String[] origIds = StringUtil.split(ParamUtil.getString(
                resourceRequest, "documentIds", ""));
        _log.info("****** documentIds: "
                + ParamUtil.getString(resourceRequest, "documentIds", "")
                + " !!!");
        long[] idsToUpdate = new long[] {};

        if (origDoc != -1) {
            idsToUpdate = new long[1];
            idsToUpdate[0] = origDoc;
        } else if (origIds.length != 0) {
            idsToUpdate = new long[origIds.length];
            for (int i = 0; i < origIds.length; i++) {
                idsToUpdate[i] = Long.parseLong(origIds[i]);
            }
        }

        int numeroFattura = 0;
        _log.info("******: " + numeroFatturaStr + " !!!");
        if (!update) {
            if (!numeroFatturaStr.equals("")) {
                numeroFattura = Integer.parseInt(numeroFatturaStr);
                if (!update) { // RECUPERO PROTOCOLLO
                    ProgressivoLocalServiceUtil
                            .deleteProgressivo(new ProgressivoPK(Calendar
                                    .getInstance().get(Calendar.YEAR),
                                    associato.getId(), Constants.INVOICE_ID,
                                    numeroFattura));
                }
            } else if (avanzaProtocollo == -1) { // AVANZAMENTO AUTOMATICO
                                                 // PROTOCOLLO
                // numeroFattura =
                // TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR),
                // FAV, associato.getId()).size() + 1;
                try {
                    List<TestataDocumento> documentiSoggetto = TestataDocumentoLocalServiceUtil
                            .getDocumentiSoggetto(
                                    Calendar.getInstance().get(Calendar.YEAR),
                                    FAV, associato.getId());
                    if (documentiSoggetto.size() > 0) {
                        numeroFattura = (int) documentiSoggetto.get(0)
                                .getNumeroOrdine() + 1;

                        String dataTestataStr = documentiSoggetto.get(0)
                                .getDataOrdine();
                        SimpleDateFormat sdf = new SimpleDateFormat(
                                "dd/MM/yyyy");

                        Date dataTestata = sdf.parse(dataTestataStr);
                        Date dataDocumento = sdf.parse(documentDate);
                        if (dataDocumento.before(dataTestata)) { // Verifico se
                                                                 // la
                                                                 // data è
                                                                 // minore
                                                                 // della data
                                                                 // dell'ultimo
                                                                 // FAV
                            return new Response(Response.Code.DATE_BEFORE,
                                    numeroFattura);
                        }

                    } else {
                        numeroFattura = 1;
                    }

                } catch (SystemException ex) {
                    _log.error(ex.getMessage());
                    return new Response(Response.Code.GET_PRIMARY_KEY_ERROR, -1);
                }
            } else { // AVANZAMENTO PROTOCOLLO MANUALE
                List<TestataDocumento> testate = TestataDocumentoLocalServiceUtil
                        .getDocumentiSoggetto(
                                Calendar.getInstance().get(Calendar.YEAR), FAV,
                                associato.getId());
                TestataDocumento t = TestataDocumentoLocalServiceUtil
                        .fetchTestataDocumento(new TestataDocumentoPK(ANNO,
                                avanzaProtocollo, FAV, associato.getId()));
                if (t != null && !update) {
                    _log.warn("Protocol already exists.");
                    return new Response(Response.Code.ALREADY_EXISTS,
                            avanzaProtocollo);
                }
                for (TestataDocumento testata : testate) {
                    if (avanzaProtocollo < testata.getNumeroOrdine()) {
                        String dataTestataStr = testata.getDataOrdine();
                        SimpleDateFormat sdf = new SimpleDateFormat(
                                "dd/MM/yyyy");

                        Date dataTestata = sdf.parse(dataTestataStr);
                        Date dataDocumento = sdf.parse(documentDate);
                        if (dataDocumento.after(dataTestata)) {
                            if (!update && dataDocumento.equals(dataTestata)) {
                                return new Response(Response.Code.NOT_VALID,
                                        avanzaProtocollo);
                            }
                        }
                    }
                }
                numeroFattura = avanzaProtocollo;
            }
        }

        List<TestataDocumento> invoices = new ArrayList<TestataDocumento>();
        TestataDocumento sellInvoice = null;
        if (!codiceCliente.equals(String.valueOf(op.getIdLiferay()))) {
            if (update) {
                sellInvoice = TestataDocumentoLocalServiceUtil
                        .fetchTestataDocumento(new TestataDocumentoPK(ANNO,
                                origDoc, FAV, associato.getId()));
            } else {
                sellInvoice = TestataDocumentoLocalServiceUtil
                        .createTestataDocumento(new TestataDocumentoPK(ANNO,
                                numeroFattura, FAV, associato.getId()));
            }

            sellInvoice.setCodiceSoggetto(codiceCliente);
            sellInvoice.setCentro(associato.getCentro());
            sellInvoice.setRagioneSociale(cliente);
            sellInvoice.setCodiceDestinazione(codiceDestinazione);
            sellInvoice.setDestinazione(destinazioneTxt);
            sellInvoice.setDataOrdine(documentDate);
            sellInvoice.setOperatore(resourceRequest.getRemoteUser());
            sellInvoice.setInviato(0);
            sellInvoice.setCompleto(COMPLETED);
            if (nDocConf != -1) {
                if (update && !sellInvoice.getNota2().isEmpty()) {
                    int nOldFac;
                    try {
                        nOldFac = Integer.parseInt(sellInvoice.getNota2());

                    } catch (NumberFormatException ex) {
                        _log.error("Il riferimanto alla FAC non è valido: "
                                + sellInvoice.getNota2());
                        return new Response(Code.GENERIC_ERROR, ex.hashCode());
                    }
                    if (nOldFac != nDocConf) {
                        TestataDocumento oldFac = TestataDocumentoLocalServiceUtil
                                .fetchTestataDocumento(new TestataDocumentoPK(
                                        ANNO, nOldFac, FAC, associato.getId()));
                        _log.info("Deleting invoice: " + oldFac);
                        List<RigoDocumento> oldFacRows = RigoDocumentoLocalServiceUtil
                                .getFatturaByNumeroOrdineAnnoAssociato(nOldFac,
                                        ANNO, associato.getId(), FAC);
                        for (RigoDocumento rigoDocumento : oldFacRows) {
                            _log.debug("Elimino rigo: " + rigoDocumento);
                            RigoDocumentoLocalServiceUtil
                                    .deleteRigoDocumento(rigoDocumento);
                            _log.info("Rigo eliminato: {"
                                    + rigoDocumento.getPrimaryKey() + "}");
                        }
                        TestataDocumentoLocalServiceUtil
                                .deleteTestataDocumento(oldFac);
                        _log.info("Fattura eliminata: {"
                                + oldFac.getPrimaryKey() + "}");
                        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
                                .getAttribute(WebKeys.THEME_DISPLAY);
                        User liferayOp = UserLocalServiceUtil.getUser(op
                                .getIdLiferay());
                        long groupId = themeDisplay.getLayout().getGroupId();
                        long repositoryId = themeDisplay.getScopeGroupId();
                        DLFolder opFolder = Utils.getOpFolder(groupId,
                                liferayOp);
                        UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil
                                .getUserIdMapper(associato.getIdLiferay());
                        User liferayAssociato = UserLocalServiceUtil
                                .getUser(userIdMapper.getUserId());
                        DLFolder associatoFolder = Utils.getAssociatoFolder(
                                groupId, opFolder, liferayAssociato);
                        DLFolder yearFolder = Utils.getAssociatoYearFolder(
                                groupId, associatoFolder, ANNO);
                        DLFolder docFolder = Utils.getAssociatoDocumentFolder(
                                groupId, yearFolder, FAC);
                        _log.info("Deleting file: " + FAC + "_" + ANNO + "_"
                                + nDocConf + "_" + OP_VAT_CENTER + ".pdf");
                        DLAppServiceUtil.deleteFileEntryByTitle(repositoryId,
                                docFolder.getFolderId(), FAC + "_" + ANNO + "_"
                                        + nOldFac + "_" + OP_VAT_CENTER
                                        + ".pdf");
                    }
                }
                // Memorizzo il riferimento alla fattura di conferimento
                // nella fattura di vendita.
                sellInvoice.setNota2(String.valueOf(nDocConf));
            }
            invoices.add(sellInvoice);
        } else if (nDocConf == -1) {
            return new Response(Code.SPECIFY_NUMBER, -1);
        }

        if (nDocConf != -1) {
            TestataDocumento purchaseInvoice = TestataDocumentoLocalServiceUtil
                    .fetchTestataDocumento(new TestataDocumentoPK(ANNO,
                            nDocConf, FAC, associato.getId()));
            if (purchaseInvoice != null) {
                return new Response(Code.FAC_ALREADY_EXISTS, nDocConf);
            } else {
                purchaseInvoice = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(ANNO,
                            nDocConf, FAC, associato.getId()));
            }

            purchaseInvoice.setCodiceSoggetto(String.valueOf(associato
                    .getIdLiferay()));
            purchaseInvoice.setCentro(OP_VAT_CENTER);
            purchaseInvoice.setRagioneSociale(op.getRagioneSociale());
            purchaseInvoice.setDestinazione(op.getIndirizzo());
            purchaseInvoice.setDataOrdine(dateDocConf);
            purchaseInvoice.setOperatore(resourceRequest.getRemoteUser());
            purchaseInvoice.setInviato(0);
            purchaseInvoice.setCompleto(COMPLETED);
            if (codiceCliente.equals(String.valueOf(op.getIdLiferay()))) {
                // nel caso di FAC per vendita diretta ad OP
                purchaseInvoice.setNota2(String.valueOf(nDocConf));
            }
            invoices.add(purchaseInvoice);
        }

        JSONArray rowsJSON = JSONFactoryUtil.createJSONArray(string);
        for (TestataDocumento invoice : invoices) {
            _log.info("Fattura: " + invoice);
            if (update) {
                TestataDocumentoLocalServiceUtil
                        .updateTestataDocumento(invoice);
            } else {
                TestataDocumentoLocalServiceUtil.addTestataDocumento(invoice);
            }
            for (int i = 0; i < rowsJSON.length(); i++) {

                JSONObject rowJSON = rowsJSON.getJSONObject(i);
                RigoDocumento rigo = JSONFactoryUtil.looseDeserialize(
                        rowJSON.toString(), RigoDocumentoImpl.class);

                rigo.setAnno(ANNO);
                rigo.setNumeroOrdine(invoice.getNumeroOrdine());
                rigo.setRigoOrdine(i + 1);
                rigo.setTipoDocumento(invoice.getTipoDocumento());
                rigo.setIdAssociato(associato.getId());

                if (update) {
                    // ****elimino i vecchi righi****
                    try {
                        RigoDocumento rigoOrig = RigoDocumentoLocalServiceUtil
                                .getRigoDocumento(new RigoDocumentoPK(rigo
                                        .getAnno(), rigo.getNumeroOrdine(),
                                        rigo.getRigoOrdine(), rigo
                                                .getTipoDocumento(), rigo
                                                .getIdAssociato()));
                        RigoDocumentoLocalServiceUtil
                                .deleteRigoDocumento(rigoOrig);
                    } catch (Exception e) {
                        _log.warn("Non esiste un rigo con chiave: "
                                + rigo.getAnno() + "-" + rigo.getNumeroOrdine()
                                + "-" + rigo.getRigoOrdine() + "-"
                                + rigo.getTipoDocumento() + "-"
                                + rigo.getIdAssociato());
                    }

                    if (!rigo.getDescrizione().contains(
                            "Documento di trasporto")
                            || rigo.getTipoDocumento().equals(FAV)) {
                        _log.info("UPDATING Rigo FATTURA: " + rigo);
                        RigoDocumentoLocalServiceUtil.updateRigoDocumento(rigo);
                    }
                } else { // non inserisco il rigo descrittivo 'Documento di
                         // trasporto ....' nei FAC
                    if (!rigo.getDescrizione().contains(
                            "Documento di trasporto")
                            || rigo.getTipoDocumento().equals(FAV)) {
                        _log.info("ADDING Rigo FATTURA: " + rigo);
                        RigoDocumentoLocalServiceUtil.addRigoDocumento(rigo);
                    }

                    for (int j = 0; j < idsToUpdate.length; j++) {
                        TestataDocumento origDDT;
                        if (!codiceCliente.equals(String.valueOf(op
                                .getIdLiferay())))
                            origDDT = TestataDocumentoLocalServiceUtil
                                    .getTestataDocumento(new TestataDocumentoPK(
                                            ANNO, idsToUpdate[j], DDT,
                                            associato.getId()));
                        else
                            origDDT = TestataDocumentoLocalServiceUtil
                                    .getTestataDocumento(new TestataDocumentoPK(
                                            ANNO, idsToUpdate[j], DDA,
                                            associato.getId()));
                        origDDT.setCompleto(INVOICED);
                        origDDT.setNota2(String.valueOf(invoice
                                .getNumeroOrdine()));
                        _log.info("Updating DDT: " + origDDT);
                        TestataDocumentoLocalServiceUtil
                                .updateTestataDocumento(origDDT);
                    }
                }
            }

        }

        return new Response(Response.Code.OK, numeroFattura);

    }

    private Response saveCreditNote(ResourceRequest resourceRequest,
            Associato associato, OrganizzazioneProduttori op, boolean update)
            throws SystemException, PortalException, ParseException {
        String string = new String(Base64.decode(ParamUtil.getString(
                resourceRequest, "data", null)));
        String codiceCliente = ParamUtil.getString(resourceRequest,
                "codiceCliente", null);
        String cliente = ParamUtil.getString(resourceRequest, "clienteTxt",
                null);
        String destinazioneTxt = ParamUtil.getString(resourceRequest,
                "destinazioneTxt", null);
        String codiceDestinazione = ParamUtil.getString(resourceRequest,
                "codiceDestinazione", null);
        String documentDate = ParamUtil.getString(resourceRequest,
                "documentDate", null);
        String numeroNotaStr = ParamUtil.getString(resourceRequest,
                "numeroNota", null);
        int avanzaProtocollo = ParamUtil.getInteger(resourceRequest,
                "avanzaProtocollo", -1);

        long origDoc = ParamUtil
                .getLong(resourceRequest, "numeroDocumento", -1);

        int numeroNota;
        if (!numeroNotaStr.equals("")) {
            numeroNota = Integer.parseInt(numeroNotaStr);
            if (!update) { // RECUPERO PROTOCOLLO
                ProgressivoLocalServiceUtil
                        .deleteProgressivo(new ProgressivoPK(Calendar
                                .getInstance().get(Calendar.YEAR), associato
                                .getId(), Constants.NOTE_ID, numeroNota));
            }
        } else if (avanzaProtocollo == -1) { // AVANZAMENTO AUTOMATICO
                                             // PROTOCOLLO
            try {
                List<TestataDocumento> documentiSoggetto = TestataDocumentoLocalServiceUtil
                        .getDocumentiSoggetto(
                                Calendar.getInstance().get(Calendar.YEAR), NAC,
                                associato.getId());
                if (documentiSoggetto.size() > 0) {
                    numeroNota = (int) documentiSoggetto.get(0)
                            .getNumeroOrdine() + 1;
                } else {
                    numeroNota = 1;
                }
            } catch (SystemException ex) {
                _log.error(ex.getMessage());
                return new Response(Response.Code.GET_PRIMARY_KEY_ERROR, -1);
            }
        } else { // AVANZAMENTO PROTOCOLLO MANUALE
            List<TestataDocumento> testate = TestataDocumentoLocalServiceUtil
                    .getDocumentiSoggetto(
                            Calendar.getInstance().get(Calendar.YEAR), NAC,
                            associato.getId());
            TestataDocumento t = TestataDocumentoLocalServiceUtil
                    .fetchTestataDocumento(new TestataDocumentoPK(ANNO,
                            avanzaProtocollo, NAC, associato.getId()));
            if (t != null && !update) {
                _log.warn("Protocol already exists.");
                return new Response(Response.Code.ALREADY_EXISTS,
                        avanzaProtocollo);
            }
            for (TestataDocumento testata : testate) {
                if (avanzaProtocollo < testata.getNumeroOrdine()) {
                    String dataTestataStr = testata.getDataOrdine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Date dataTestata = sdf.parse(dataTestataStr);
                    Date dataDocumento = sdf.parse(documentDate);
                    if (dataDocumento.after(dataTestata)) {
                        if (!update && dataDocumento.equals(dataTestata)) {
                            return new Response(Response.Code.NOT_VALID,
                                    avanzaProtocollo);
                        }
                    }
                }
            }
            numeroNota = avanzaProtocollo;
        }

        TestataDocumento creditnote = null;
        if (update) {
            creditnote = TestataDocumentoLocalServiceUtil
                    .fetchTestataDocumento(new TestataDocumentoPK(ANNO,
                            origDoc, NAC, associato.getId()));
        } else {
            creditnote = TestataDocumentoLocalServiceUtil
                    .createTestataDocumento(new TestataDocumentoPK(ANNO,
                            numeroNota, NAC, associato.getId()));
        }

        creditnote.setCodiceSoggetto(codiceCliente);
        creditnote.setCentro(associato.getCentro());
        creditnote.setRagioneSociale(cliente);
        creditnote.setCodiceDestinazione(codiceDestinazione);
        creditnote.setDestinazione(destinazioneTxt);
        creditnote.setDataOrdine(documentDate);
        creditnote.setOperatore(resourceRequest.getRemoteUser());
        creditnote.setCompleto(COMPLETED);

        JSONArray rowsJSON = JSONFactoryUtil.createJSONArray(string);
        if (update) {
            TestataDocumentoLocalServiceUtil.updateTestataDocumento(creditnote);
        } else {
            TestataDocumentoLocalServiceUtil.addTestataDocumento(creditnote);
        }
        for (int i = 0; i < rowsJSON.length(); i++) {

            JSONObject rowJSON = rowsJSON.getJSONObject(i);
            RigoDocumento rigo = JSONFactoryUtil.looseDeserialize(
                    rowJSON.toString(), RigoDocumentoImpl.class);

            rigo.setAnno(ANNO);
            rigo.setNumeroOrdine(creditnote.getNumeroOrdine());
            rigo.setRigoOrdine(i + 1);
            rigo.setTipoDocumento(creditnote.getTipoDocumento());
            rigo.setIdAssociato(associato.getId());

            if (update) {
                RigoDocumentoLocalServiceUtil.updateRigoDocumento(rigo);
            } else {
                RigoDocumentoLocalServiceUtil.addRigoDocumento(rigo);
            }
        }

        return new Response(Response.Code.OK, numeroNota);
    }

    private Response saveTraceability(ResourceRequest resourceRequest,
            Associato a) throws JSONException, SystemException {

        String string = new String(Base64.decode(ParamUtil.getString(
                resourceRequest, "data", null)));
        long nDoc = ParamUtil.getLong(resourceRequest, "nDoc", 0);

        JSONObject objectJson = JSONFactoryUtil.createJSONObject(string);
        _log.info(objectJson);
        JSONArray schedeJson = objectJson.getJSONArray("scheda");

        Map<Long, TracciabilitaScheda> newSchede = new HashMap<Long, TracciabilitaScheda>();
        Map<Long, List<TracciabilitaGrezzi>> newGrezzi = new HashMap<Long, List<TracciabilitaGrezzi>>();
        Map<Long, TracciabilitaScheda> updatingSchede = new HashMap<Long, TracciabilitaScheda>();
        Map<Long, List<TracciabilitaGrezzi>> updatingGrezzi = new HashMap<Long, List<TracciabilitaGrezzi>>();

        for (int i = 0; i < schedeJson.length(); i++) {
            JSONObject schedaJson = schedeJson.getJSONObject(i);

            long id = schedaJson.getLong("idScheda");
            TracciabilitaScheda scheda;
            if (id > 0) {
                scheda = TracciabilitaSchedaLocalServiceUtil
                        .fetchTracciabilitaScheda(id);
            } else {
                id = 0; // CounterLocalServiceUtil.increment(TracciabilitaScheda.class.getName());
                scheda = TracciabilitaSchedaLocalServiceUtil
                        .createTracciabilitaScheda((int) id);
            }
            scheda.setCodiceProdotto(schedaJson.getString("codiceProdotto"));
            scheda.setProdottoVenduto(schedaJson.getString("prodottoVenduto"));
            scheda.setKgVenduti(Double.parseDouble(schedaJson
                    .getString("kgVenduti")));
            scheda.setLottoVendita(schedaJson.getString("lottoVendita"));
            scheda.setAnno(ANNO);
            scheda.setNumeroDocumento(Long.parseLong(schedaJson
                    .getString("numeroDocumento")));
            scheda.setRigoOrdine(Integer.parseInt(schedaJson
                    .getString("rigoOrdine")));
            scheda.setTipoDocumento(DDT);
            scheda.setIdAssociato(a.getId());

            JSONArray grezziJson = schedaJson.getJSONArray("grezzi");
            List<TracciabilitaGrezzi> listGrezzi = new ArrayList<TracciabilitaGrezzi>();
            for (int j = 0; j < grezziJson.length(); j++) {
                JSONObject grezzoJson = grezziJson.getJSONObject(j);

                long idGrezzo = grezzoJson.getLong("idGrezzo");
                TracciabilitaGrezzi grezzo;
                if (idGrezzo > 0) {
                    grezzo = TracciabilitaGrezziLocalServiceUtil
                            .fetchTracciabilitaGrezzi(idGrezzo);
                } else {
                    idGrezzo = 0; // CounterLocalServiceUtil.increment(TracciabilitaGrezzi.class.getName());
                    grezzo = TracciabilitaGrezziLocalServiceUtil
                            .createTracciabilitaGrezzi((int) idGrezzo);
                }

                grezzo.setFoglio(Integer.parseInt(grezzoJson
                        .getString("foglio")));
                grezzo.setKg(Double.parseDouble(grezzoJson.getString("kg")));
                grezzo.setLottoGrezzo(grezzoJson.getString("lottoGrezzo"));
                grezzo.setParticella(Integer.parseInt(grezzoJson
                        .getString("particella")));
                grezzo.setProdotto(grezzoJson.getString("prodotto"));
                grezzo.setProduttore(grezzoJson.getString("produttore"));
                grezzo.setNote(grezzoJson.getString("note"));
                grezzo.setNumeroColli(grezzoJson.getInt("colli"));
                grezzo.setKgScarto(grezzoJson.getDouble("kg_scarto"));
                grezzo.setIdSchedaTracciabilta((int) id);

                listGrezzi.add(grezzo);
            }

            if (scheda.getId() == 0) {
                _log.info("SAVING: " + scheda);
                long idScheda = CounterLocalServiceUtil
                        .increment(TracciabilitaScheda.class.getName());
                scheda.setId(idScheda);
                TracciabilitaSchedaLocalServiceUtil
                        .addTracciabilitaScheda(scheda);
                for (TracciabilitaGrezzi grezzoToSave : listGrezzi) {
                    long idGrezzo = CounterLocalServiceUtil
                            .increment(TracciabilitaGrezzi.class.getName());
                    grezzoToSave.setId(idGrezzo);
                    grezzoToSave.setIdSchedaTracciabilta(idScheda);
                    _log.info("SAVING GREZZO: " + grezzoToSave);
                    TracciabilitaGrezziLocalServiceUtil
                            .addTracciabilitaGrezzi(grezzoToSave);
                }
                newSchede.put(scheda.getId(), scheda);
                newGrezzi.put(scheda.getId(), listGrezzi);
            } else {
                updatingSchede.put(scheda.getId(), scheda);
                updatingGrezzi.put(scheda.getId(), listGrezzi);
            }
        }

        if (updatingSchede.size() > 0) {
            List<TracciabilitaScheda> oldSchede = TracciabilitaSchedaLocalServiceUtil
                    .getByAnnoIdAssociato(ANNO, nDoc, a.getId());
            for (TracciabilitaScheda oldScheda : oldSchede) {
                List<TracciabilitaGrezzi> grezzi = updatingGrezzi.get(oldScheda
                        .getId());
                if (updatingSchede.containsKey(oldScheda.getId())) { // UPDATE
                    _log.info("UPDATING: " + oldScheda);
                    oldScheda = updatingSchede.get(oldScheda.getId());
                    TracciabilitaSchedaLocalServiceUtil
                            .updateTracciabilitaScheda(oldScheda);
                    for (TracciabilitaGrezzi grezzo : grezzi) {
                        if (grezzo.getId() != 0) { // UPDATE
                            _log.info("UPDATING OLD GREZZO: " + grezzo);
                            TracciabilitaGrezziLocalServiceUtil
                                    .updateTracciabilitaGrezzi(grezzo);
                        } else {
                            long idGrezzo = CounterLocalServiceUtil
                                    .increment(TracciabilitaGrezzi.class
                                            .getName());
                            grezzo.setId(idGrezzo);
                            _log.info("INSERTING GREZZO: " + grezzo);
                            TracciabilitaGrezziLocalServiceUtil
                                    .addTracciabilitaGrezzi(grezzo);
                        }
                    }
                } else if (!newSchede.containsKey(oldScheda.getId())) {// DELETE
                    _log.info("DELETING OLD SCHEDA: " + oldScheda);
                    List<TracciabilitaGrezzi> oldGrezzi = TracciabilitaGrezziLocalServiceUtil
                            .getIdSchedaTracciabilita(oldScheda.getId());
                    for (TracciabilitaGrezzi oldGrezzo : oldGrezzi) {
                        _log.info("DELETING OLD GREZZO: " + oldGrezzo);
                        TracciabilitaGrezziLocalServiceUtil
                                .deleteTracciabilitaGrezzi(oldGrezzo);
                    }
                    TracciabilitaSchedaLocalServiceUtil
                            .deleteTracciabilitaScheda(oldScheda);
                }
            }
        }

        return new Response(Response.Code.OK, 0);
    }

    private File uploadFile(UploadPortletRequest uploadRequest, long idAssociato)
            throws Exception {
        if (uploadRequest.getSize("fileupload") == 0) {
            throw new Exception("empty-file");
        }

        // Get the uploaded file as a file.
        File uploadedFile = uploadRequest.getFile("fileupload");

        String sourceFileName = uploadRequest.getFileName("fileupload");

        // Where should we store this file?
        File folder = new File("/tmp");

        // Check minimum 1GB storage space to save new files...
        if (folder.getUsableSpace() < ONE_GB) {
            throw new Exception("disk-space");
        }

        // replace all illegal characters
        sourceFileName = sourceFileName.replaceAll("[^a-zA-Z0-9.-]", "_");

        // This is our final file path.
        File filePath = new File(folder.getAbsolutePath() + File.separator
                + idAssociato + "_" + sourceFileName);

        // Move the existing temporary file to new location.
        FileUtil.copyFile(uploadedFile, filePath);

        return filePath;
    }
}
