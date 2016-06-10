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
import it.bysoftware.ct.model.Anagrafica;
import it.bysoftware.ct.model.AnagraficaAssociatoOP;
import it.bysoftware.ct.model.Articoli;
import it.bysoftware.ct.model.ArticoliAssociatoOP;
import it.bysoftware.ct.model.Associato;
import it.bysoftware.ct.model.ClientiDatiAgg;
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
import it.bysoftware.ct.service.ArticoliLocalServiceUtil;
import it.bysoftware.ct.service.AssociatoLocalServiceUtil;
import it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil;
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
import it.bysoftware.ct.service.persistence.ProgressivoPK;
import it.bysoftware.ct.service.persistence.RigoDocumentoPK;
import it.bysoftware.ct.service.persistence.TestataDocumentoPK;
import it.bysoftware.ct.service.persistence.WKRigoDocumentoPK;
import it.bysoftware.ct.service.persistence.WKTestataDocumentoPK;
import it.its.ct.gestionaleOP.csvParser.CSVParser;
import it.its.ct.gestionaleOP.pojos.Documento;
import it.its.ct.gestionaleOP.pojos.Response;
import it.its.ct.gestionaleOP.report.Report;

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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
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
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DDTPortlet extends MVCPortlet {

    private final Log _log = LogFactoryUtil.getLog(DDTPortlet.class);
    private final static int ONE_GB = 1073741824;
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

    public void upload(ActionRequest areq, ActionResponse ares) {

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(areq);
        long idAssociato = Long.parseLong(ParamUtil.getString(uploadRequest, "idAssociato"));
                
        File uploadedFile;
		try {
			Associato associato = AssociatoLocalServiceUtil.findByLiferayId(idAssociato);
			uploadedFile = uploadFile(uploadRequest, idAssociato);
			_log.info("Uploaded file: " + uploadedFile.getName());
			List<Documento> importedDocs = parseImportedFile(uploadedFile, associato.getId());
			
			List<Documento> docsReady =  new ArrayList<Documento>(); // new ArrayList<Documento>(importedDocs);
	    	List<Documento> docsToCheck = new ArrayList<Documento>();
	    	
	    	for (Documento d : importedDocs) {
	    		_log.info("TESTATA: " + d.getTestata().toString());
				WKTestataDocumento t = d.getTestata();
	    		List<WKRigoDocumento> rows = d.getRighe();
	    		
	    		AnagraficaAssociatoOP associatoOP = null;
	    		try {
	    			associatoOP = AnagraficaAssociatoOPLocalServiceUtil.getAnagraficaAssociatoOP(new AnagraficaAssociatoOPPK(associato.getId(), t.getCodiceSoggetto()));
	    		} catch (PortalException ex) {
	    			_log.info("Cliente non codifiacto: " + t.getCodiceSoggetto());
	    		}
	    		if(associatoOP != null){
	    			_log.info("Cliente codificato, sostituisco: " + t.getCodiceSoggetto() + "<->" + associatoOP.getCodiceSogettoOP());
	    			//Sostituisco il codice sogetto dell'assocaito con quello della OP
	    			t.setCodiceSoggetto(associatoOP.getCodiceSogettoOP());
	    			
	    			Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(associatoOP.getCodiceSogettoOP());
	    			t.setRagioneSociale(cliente.getRagioneSociale());
	    			boolean addToReady = true;
					for (WKRigoDocumento rigoDocumento : rows) {
	    				if(!rigoDocumento.getCodiceArticolo().equals("")){
	    					ArticoliAssociatoOP articoloAssociato = null;
	    					try {
	    						articoloAssociato = ArticoliAssociatoOPLocalServiceUtil.getArticoliAssociatoOP(new ArticoliAssociatoOPPK(associato.getId(), rigoDocumento.getCodiceArticolo()));
	    					} catch (PortalException ex){
	    						_log.info("Articolo non trovato: " + rigoDocumento.getCodiceArticolo());
	    					}
							if(articoloAssociato == null){
								_log.info("Articolo: " + rigoDocumento.getCodiceArticolo() + " non ancora codificato.");
								rigoDocumento.setVerificato(false);
								addToReady = false;
							} else {
								_log.info("Articolo codificato, sostituisco: " + rigoDocumento.getCodiceArticolo() + "<->" + articoloAssociato.getCodiceArticoloOP());
								rigoDocumento.setCodiceArticolo(articoloAssociato.getCodiceArticoloOP());
								Articoli articolo = ArticoliLocalServiceUtil.getArticoli(articoloAssociato.getCodiceArticoloOP());
								rigoDocumento.setDescrizione(articolo.getDescrizione());
								rigoDocumento.setVerificato(true);
							}
	    				} else {
    						rigoDocumento.setVerificato(true);
    					}
					}
	    			if(addToReady) {
	    				t.setVerificato(true);
	    				docsReady.add(d);
	    			} else {
	    				t.setVerificato(false);
	    				docsToCheck.add(d);
	    			}
	    		} else {
	    			_log.info("Cliente: " + t.getCodiceSoggetto() + " non codificato.");
//	    			t.setCodiceSoggetto("");
	    			t.setVerificato(false);
//	    			boolean addToReady = true;
    				for (WKRigoDocumento rigoDocumento : rows) {
    					if(!rigoDocumento.getCodiceArticolo().equals("")){
    						ArticoliAssociatoOP articoloAssociato = null;
    						try {
    							articoloAssociato = ArticoliAssociatoOPLocalServiceUtil.getArticoliAssociatoOP(new ArticoliAssociatoOPPK(associato.getId(), rigoDocumento.getCodiceArticolo()));
    						} catch (PortalException ex){
    							_log.info("Articolo non trovato: " + rigoDocumento.getCodiceArticolo());
    						}
    						if(articoloAssociato == null){
    							_log.info("Articolo: " + rigoDocumento.getCodiceArticolo() + " non ancora codificato.");
    							rigoDocumento.setVerificato(false);
//    							addToReady = false;
//    							break; // stop loop on rows
    						} else {
    							_log.info("Articolo codificato, sostituisco: " + rigoDocumento.getCodiceArticolo() + "<->" + articoloAssociato.getCodiceArticoloOP());
								rigoDocumento.setCodiceArticolo(articoloAssociato.getCodiceArticoloOP());
								Articoli articolo = ArticoliLocalServiceUtil.getArticoli(articoloAssociato.getCodiceArticoloOP());
								rigoDocumento.setDescrizione(articolo.getDescrizione());
								rigoDocumento.setVerificato(true);
    						}
    					} else {
    						rigoDocumento.setVerificato(true);
    					}
					}
//    				if(addToReady){
//    					docsReady.add(d);
//    				} else {
    					docsToCheck.add(d);
//    				}
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
    	WKRigoDocumentoPK rigoDocumentoPK = JSONFactoryUtil.looseDeserializeSafe(json, WKRigoDocumentoPK.class);
    	if (codiceArticolo != null && !codiceArticolo.equals("")) {
    		_log.info("Codice Articolo: " + codiceArticolo);
    		String codiceAssociato = ParamUtil.getString(areq, "codiceAssociato", null);
    		if(codiceAssociato != null && !codiceAssociato.equals("")){
    			ArticoliAssociatoOP articoliAssociatoOP = ArticoliAssociatoOPLocalServiceUtil.createArticoliAssociatoOP(new ArticoliAssociatoOPPK(rigoDocumentoPK.getIdAssociato(), codiceAssociato));
    			articoliAssociatoOP.setCodiceArticoloOP(codiceArticolo);
    			try {
    				_log.info("Adding: " + articoliAssociatoOP);
					ArticoliAssociatoOPLocalServiceUtil.addArticoliAssociatoOP(articoliAssociatoOP);
					_log.info("Saved: " + articoliAssociatoOP);
				} catch (SystemException e) {
					SessionErrors.add(areq, "error-saving-articoliAssociatoOP");
					e.printStackTrace();
				}
    			try {
    				List<WKRigoDocumento> rows = WKRigoDocumentoLocalServiceUtil.getByAnnoAssociato(rigoDocumentoPK.getAnno(), rigoDocumentoPK.getIdAssociato());
    				for (WKRigoDocumento wkRigoDocumento : rows) { // Aggiorno tutti i documenti con quell'articolo
						if(wkRigoDocumento.getCodiceArticolo().equals(codiceAssociato)){
							_log.info("Updating: " + wkRigoDocumento);
							wkRigoDocumento.setCodiceArticolo(codiceArticolo);
							wkRigoDocumento.setVerificato(true);
							WKRigoDocumentoLocalServiceUtil.updateWKRigoDocumento(wkRigoDocumento);
						}
					}
					
				} catch (SystemException e) {
					SessionErrors.add(areq, "error-updating");
					e.printStackTrace();
				}
    		}
    		WKTestataDocumentoPK testataDocumentoPK = new WKTestataDocumentoPK(rigoDocumentoPK.getAnno(), rigoDocumentoPK.getNumeroOrdine(), rigoDocumentoPK.getTipoDocumento(), rigoDocumentoPK.getIdAssociato());
    		ares.setRenderParameter("WKTestataDocumentoPK", JSONFactoryUtil.looseSerialize(testataDocumentoPK));
        	ares.setRenderParameter("jspPage", "/jsps/edit-document.jsp");
    	} else {
    		SessionErrors.add(areq, "no-valid-code");
    		
    		ares.setRenderParameter("WKRigoDocumentoPK", json);
        	ares.setRenderParameter("jspPage", "/jsps/edit-row.jsp");
    	}
    	
    }
    
    public void validateDocument(ActionRequest areq, ActionResponse ares) {
    	
    	String json = ParamUtil.getString(areq, "WKTestataDocumentoPK", null);
    	String codClienteAssociato = ParamUtil.getString(areq, "codClienteAssociato", "");
    	String codCliente = ParamUtil.getString(areq, "codCliente", "");
    	String ragioneSociale = ParamUtil.getString(areq, "cliente", "");
    	
    	if(json != null && !json.equals("")){
    		WKTestataDocumentoPK testataDocumentoPK = JSONFactoryUtil.looseDeserializeSafe(json, WKTestataDocumentoPK.class);
        	        	
        	_log.info("codCliente: "  + codCliente);
        	_log.info("codClienteAssociato: "  + codClienteAssociato);
        	_log.info("cliente: "  + ragioneSociale);
        	
        	if(!codClienteAssociato.equals("") && !codClienteAssociato.equals(codCliente)){ // devo aggiungere alla tabella di associazione dei codici clienti
        		AnagraficaAssociatoOP anagraficaAssociatoOP = null;
				try {
					anagraficaAssociatoOP = AnagraficaAssociatoOPLocalServiceUtil.getAnagraficaAssociatoOP(new AnagraficaAssociatoOPPK(testataDocumentoPK.getIdAssociato(), codClienteAssociato));
					
				} catch (PortalException e) {
					_log.warn(e.getMessage());
				} catch (SystemException e) {
					_log.warn(e.getMessage());
				}
				
				if (anagraficaAssociatoOP == null){
					anagraficaAssociatoOP = AnagraficaAssociatoOPLocalServiceUtil.createAnagraficaAssociatoOP(new AnagraficaAssociatoOPPK(testataDocumentoPK.getIdAssociato(), codClienteAssociato));
					anagraficaAssociatoOP.setCodiceSogettoOP(codCliente);
	        		_log.info("Adding: "  + anagraficaAssociatoOP + " to anagrafica_associato_op");
	        		try {
						AnagraficaAssociatoOPLocalServiceUtil.addAnagraficaAssociatoOP(anagraficaAssociatoOP);
					} catch (SystemException e) {
						_log.error(e.getMessage());
						SessionErrors.add(areq, "error-updating");
					}
				}
        	}
    		try {
				WKTestataDocumento t = WKTestataDocumentoLocalServiceUtil.getWKTestataDocumento(testataDocumentoPK);
				List<WKRigoDocumento> rows = WKRigoDocumentoLocalServiceUtil.getByNumeroOrdineAnnoAssociatoTipoDocumento(t.getNumeroOrdine(), t.getAnno(), t.getIdAssociato(), t.getTipoDocumento());
				boolean isReady = true;
				for (WKRigoDocumento wkRigoDocumento : rows) {
					
					if(!wkRigoDocumento.getVerificato())
						isReady = false;
				}
				
				_log.info("Updating: " + t);
				t.setVerificato(isReady);
				t.setCodiceSoggetto(codCliente);
				t.setRagioneSociale(ragioneSociale);
				WKTestataDocumentoLocalServiceUtil.updateWKTestataDocumento(t);
				
				if(isReady){
					SessionMessages.add(areq, "correctly-updated");
				} else {
					ares.setRenderParameter("message", "Attenzione non tutte le righe del documento sono state convalidate.");
				}
			} catch (PortalException e) {
				SessionErrors.add(areq, "error-updating");
				e.printStackTrace();
			} catch (SystemException e) {
				SessionErrors.add(areq, "error-updating");
				e.printStackTrace();
			}    		
    		ares.setRenderParameter("WKTestataDocumentoPK", JSONFactoryUtil.looseSerialize(testataDocumentoPK));
        	
    	}
    	
    	ares.setRenderParameter("jspPage", "/jsps/edit-document.jsp");
    }
    
    public void saveImported(ActionRequest areq, ActionResponse ares) {
    	Associato a;
		try {
			a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(areq.getRemoteUser()));
	    	List<WKTestataDocumento> list = WKTestataDocumentoLocalServiceUtil.getReady(Calendar.getInstance().get(Calendar.YEAR), a.getId());
	    	
	    	for (WKTestataDocumento wkTestataDocumento : list) {
	    		if(wkTestataDocumento.getVerificato()) {
	    			TestataDocumento t;
	    			try {
	    				Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(wkTestataDocumento.getCodiceSoggetto());
	    				t = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(wkTestataDocumento.getAnno(), wkTestataDocumento.getNumeroOrdine(), wkTestataDocumento.getTipoDocumento(), wkTestataDocumento.getIdAssociato()));
	    				if(t == null)
	    					t = TestataDocumentoLocalServiceUtil.createTestataDocumento(new TestataDocumentoPK(wkTestataDocumento.getAnno(), wkTestataDocumento.getNumeroOrdine(), wkTestataDocumento.getTipoDocumento(), wkTestataDocumento.getIdAssociato()));
	    				t.setCentro(wkTestataDocumento.getCentro());
	    				t.setCodiceSoggetto(wkTestataDocumento.getCodiceSoggetto());
	    				t.setRagioneSociale(wkTestataDocumento.getRagioneSociale());
	    				t.setDestinazione(cliente.getIndirizzo());
	    				t.setAspettoEsteriore(wkTestataDocumento.getAspettoEsteriore());
	    				t.setVettore(wkTestataDocumento.getVettore());
	    				t.setVettore2(wkTestataDocumento.getVettore());
	    				t.setDataOrdine(wkTestataDocumento.getDataOrdine());
	    				t.setDataConsegna(wkTestataDocumento.getDataConsegna());
	    				t.setLotto(wkTestataDocumento.getLotto());
	    				t.setCompleto("completo");
	    				t.setOperatore(areq.getRemoteUser());
	    				t.setAutista(wkTestataDocumento.getAutista());
	    				t.setCuraTrasporto(wkTestataDocumento.getCuraTrasporto());
	    				t.setCausaleTrasporto(wkTestataDocumento.getCausaleTrasporto());
	    				t.setPorto(wkTestataDocumento.getPorto());
	    				t.setOrigine(wkTestataDocumento.getOrigine());
	    				t.setRigoDescrittivo(wkTestataDocumento.getRigoDescrittivo());
	    				t.setCostoTrasporto(wkTestataDocumento.getCostoTrasporto());
	    				t.setNumeroPedaneEuro(wkTestataDocumento.getNumeroPedaneEuro());
	    				t.setNumeroPedaneNormali(wkTestataDocumento.getNumeroPedaneNormali());
	    				t.setTargaCamion(wkTestataDocumento.getTargaCamion());
	    				t.setTargaRimorchio(wkTestataDocumento.getTargaRimorchio());
	    				t.setInviato(0);
	    				
	    				TestataDocumentoLocalServiceUtil.updateTestataDocumento(t); //Adds o updates
	    				
	    				if(wkTestataDocumento.getTipoDocumento().equals(FAV)){
	    					t.setTipoDocumento(FAC);
	    					t.setCodiceSoggetto(areq.getRemoteUser());
	    					t.setRagioneSociale(a.getRagioneSociale());
	    					t.setDestinazione(a.getIndirizzo());
	    					
	    					TestataDocumentoLocalServiceUtil.updateTestataDocumento(t); // adds or update FAC
	    				}
	    				
	    				List<WKRigoDocumento> rows = WKRigoDocumentoLocalServiceUtil.getByNumeroOrdineAnnoAssociatoTipoDocumento(wkTestataDocumento.getNumeroOrdine(), wkTestataDocumento.getAnno(), wkTestataDocumento.getIdAssociato(), wkTestataDocumento.getTipoDocumento());
//	    				for (WKRigoDocumento wkRigoDocumento : rows) {
	    				for (int i = 0; i < rows.size(); i++) {
	    					WKRigoDocumento wkRigoDocumento = rows.get(i);
	    					RigoDocumento r = RigoDocumentoLocalServiceUtil.fetchRigoDocumento(new RigoDocumentoPK(wkRigoDocumento.getAnno(), wkRigoDocumento.getNumeroOrdine(), wkRigoDocumento.getRigoOrdine(), wkRigoDocumento.getTipoDocumento(), wkRigoDocumento.getIdAssociato()));
	    					if(r == null)
	    						r = RigoDocumentoLocalServiceUtil.createRigoDocumento(new RigoDocumentoPK(wkRigoDocumento.getAnno(), wkRigoDocumento.getNumeroOrdine(), wkRigoDocumento.getRigoOrdine(), wkRigoDocumento.getTipoDocumento(), wkRigoDocumento.getIdAssociato()));
	    					r.setCodiceArticolo(wkRigoDocumento.getCodiceArticolo());
	    					r.setDescrizione(wkRigoDocumento.getDescrizione());
	    					r.setCodiceVariante(wkRigoDocumento.getCodiceVariante());
	    					r.setUnitaMisura(wkRigoDocumento.getUnitaMisura());
	    					r.setColli(wkRigoDocumento.getColli());
	    					r.setPedane(wkRigoDocumento.getPesoLordo());
	    					r.setTara(wkRigoDocumento.getTara());
	    					r.setPesoNetto(wkRigoDocumento.getPesoNetto());
	    					r.setPrezzo(wkRigoDocumento.getPrezzo());
	    					r.setPedane(wkRigoDocumento.getPedane());
	    					r.setNote(wkRigoDocumento.getNote());
	    					r.setTotalePesata(wkRigoDocumento.getTotalePesata());
	    					r.setGestioneReti(wkRigoDocumento.getGestioneReti());
	    					r.setRtxCl(wkRigoDocumento.getRtxCl());
	    					r.setKgRete(wkRigoDocumento.getKgRete());
	    					r.setLotto(wkRigoDocumento.getLotto());
	    					r.setPassaporto(wkRigoDocumento.getPassaporto());
	    					r.setSconto1(wkRigoDocumento.getSconto1());
	    					r.setSconto2(wkRigoDocumento.getSconto2());
	    					r.setSconto3(wkRigoDocumento.getSconto3());
	    					if(!wkRigoDocumento.getCodiceArticolo().equals("") && !wkRigoDocumento.getDescrizione().equals("")){
	    						if(i + 1 < rows.size()){
	    							WKRigoDocumento rigoImballo = rows.get(i + 1);
	    							if(wkTestataDocumento.getTipoDocumento().equals(DDT))
	    								r.setRigoOrdine(wkRigoDocumento.getRigoOrdine() + 1);
	    							r.setImballo(rigoImballo.getCodiceArticolo());
		    						WKRigoDocumentoLocalServiceUtil.deleteWKRigoDocumento(rigoImballo);
		    						i++;
	    						}
	    					} 
	    					_log.info("Adding/updating: " + r);
	    					RigoDocumentoLocalServiceUtil.updateRigoDocumento(r);
	    					
	    					if(wkRigoDocumento.getTipoDocumento().equals(FAV)){
    	    					r.setTipoDocumento(FAC);
    	    					RigoDocumentoLocalServiceUtil.updateRigoDocumento(r);
	    					}
		    				WKRigoDocumentoLocalServiceUtil.deleteWKRigoDocumento(wkRigoDocumento);
		    			
	    				}
	    				
	    				WKTestataDocumentoLocalServiceUtil.deleteWKTestataDocumento(wkTestataDocumento);
	    				stampaENotifica(t, a, areq);
	    			} catch (PortalException e) {
	    				e.printStackTrace();
	    			} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			
	    		}
	    		
			}
	    	
		} catch (NoSuchAssociatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ares.setRenderParameter("jspPage", "/jsps/validate.jsp");
    }
    
    private void stampaENotifica(TestataDocumento t, Associato a,
			ActionRequest areq) throws PortalException, SystemException, ClassNotFoundException, JRException, SQLException, FileNotFoundException, AddressException {


		Report r = new Report();
        
        OrganizzazioneProduttori  op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
        String ddt = r.print((int) t.getNumeroOrdine(), new Long(a.getId()).intValue(), (t.getTipoDocumento().equals(FAC)) ? FAV.toLowerCase() : t.getTipoDocumento().toLowerCase(), op.getIdLiferay());

        File file = new File(ddt);

        String fileName = addToDL((int)t.getNumeroOrdine(), file, areq, (t.getTipoDocumento().equals(FAC)) ? FAV : t.getTipoDocumento());

        sendEmail(a, op, (int) t.getNumeroOrdine(), false, (t.getTipoDocumento().equals(FAC)) ? FAV.toLowerCase() : t.getTipoDocumento().toLowerCase(), file, fileName + ".pdf");
		
	}

	private String addToDL(int nDoc, File ddt, ActionRequest areq,
			String tipoDocumento) throws NumberFormatException, SystemException, PortalException {
		Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(areq.getRemoteUser()));
        OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
        User liferayOp = UserLocalServiceUtil.getUser(op.getIdLiferay());
        User liferayAssociato = UserLocalServiceUtil.getUser(a.getIdLiferay());
        ThemeDisplay themeDisplay = (ThemeDisplay) areq.getAttribute(WebKeys.THEME_DISPLAY);
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

	private void storeImportedDocument(List<Documento> docsReady, List<Documento> docsToCheck) {
		try {
		
			for (Documento documento : docsReady) {
				WKTestataDocumento t = documento.getTestata();
			
				WKTestataDocumentoLocalServiceUtil.addWKTestataDocumento(t);
				List<WKRigoDocumento> rows = documento.getRighe();
//				for (WKRigoDocumento rigo : documento.getRighe()) {
				for (int i = 0; i < rows.size(); i++) {
					WKRigoDocumento rigo = rows.get(i);
					if(rigo.getRigoOrdine() == 0)
						rigo.setRigoOrdine(rows.size());
					else
						rigo.setRigoOrdine(i);
					
					if(rigo.getTipoDocumento().equals(FAV)){
						int riferimentoBolla = rigo.getRiferimentoBolla();
						if(riferimentoBolla != 0){
							TestataDocumento testataDDT = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(t.getAnno(), riferimentoBolla, DDT, rigo.getIdAssociato()));
							testataDDT.setCompleto(INVOICED);
							TestataDocumentoLocalServiceUtil.updateTestataDocumento(testataDDT);
						}
						
					}
						
					WKRigoDocumentoLocalServiceUtil.addWKRigoDocumento(rigo);
				}
			
			}
			for (Documento documento : docsToCheck) {
				WKTestataDocumento t = documento.getTestata();
				WKTestataDocumentoLocalServiceUtil.addWKTestataDocumento(t);
				
				List<WKRigoDocumento> rows = documento.getRighe();
//				for (WKRigoDocumento rigo : documento.getRighe()) {
				for (int i = 0; i < rows.size(); i++) {
					WKRigoDocumento rigo = rows.get(i);
					if(rigo.getRigoOrdine() == 0)
						rigo.setRigoOrdine(rows.size());
					else
						rigo.setRigoOrdine(i);
					WKRigoDocumentoLocalServiceUtil.addWKRigoDocumento(rigo);
				}
				
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Documento> parseImportedFile(
			File uploadedFile, long idAssociato) throws Exception {

//    	List<Map<TestataDocumento, List<RigoDocumento>>> result = new ArrayList<Map<TestataDocumento,List<RigoDocumento>>>();

    	FileReader fileReader = new FileReader(uploadedFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<List<WKRigoDocumento>>orderedRows = new ArrayList<List<WKRigoDocumento>>();
		List<Documento> tmpDocs = new ArrayList<Documento>();
		WKTestataDocumento testataDocumento = null;
		List<WKRigoDocumento> righeDocumento = null;
//		Map<List<Integer>, WKRigoDocumento> righeFAV = null;
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] st = line.split(";");
			if(st.length > 0){
				switch (st[0]) {
				case "WorkTestataDocumento":
					//if(testataDocumento != null && righeDocumento != null){
					if(righeDocumento != null){
						_log.info("Adding to tmpDocs ...");
						tmpDocs.add(new Documento(testataDocumento, righeDocumento));
					} 
//					else if(righeFAV != null) {
//						_log.info("Adding to tmpDocs ...");
//						int minDocIndex = Integer.MAX_VALUE;
//						for (List<Integer> k : righeFAV.keySet()) {
//							_log.info("INDICI: " + k);
//							_log.info("RIGO FATTURA: " + righeFAV.get(k));
//							if(k.get(0) != 0 && k.get(0) < minDocIndex)
//								minDocIndex = k.get(0);
//						}
//					}
						
					testataDocumento = null;
					righeDocumento = null;
//					righeFAV = null;
					_log.info("Found document header, read the single line...");					
					if((line = bufferedReader.readLine()) != null){
						_log.info("Line: " + line);
						st = line.split(";");
						testataDocumento = CSVParser.getTestata(st, idAssociato);
						line = bufferedReader.readLine();
					}
					break;
				case "WorkRigaDocumento":
					_log.info("Found row header, loop on rows...");
					if(testataDocumento != null){
//						if(!testataDocumento.getTipoDocumento().equals(FAV))
							righeDocumento = new ArrayList<WKRigoDocumento>();
//						else
//							righeFAV = new HashMap<List<Integer>, WKRigoDocumento>();
						int i = 1;
						while((line = bufferedReader.readLine()) != null){
							_log.info("Line: " + line);
							st = line.split(";");
							if(!st[0].equals("WorkTestataDocumento")){
								if(!testataDocumento.getTipoDocumento().equals(FAV))
									righeDocumento.add(CSVParser.getRigo(st, testataDocumento, i, idAssociato));
								else {
									Map.Entry<Integer, WKRigoDocumento> entry = CSVParser.getRigoFattura(st, testataDocumento, idAssociato);
									if(entry != null){
										
										if(righeDocumento.isEmpty())
											righeDocumento.add(entry.getValue());
										else{
											for (int j = 0; j < righeDocumento.size(); j++) {
												if(entry.getKey() < righeDocumento.get(j).getRigoOrdine()){
													righeDocumento.add(j, entry.getValue());
													entry = null;
													break;
												}
											}
											if(entry != null)
												righeDocumento.add(entry.getValue());
										}
									}
//									if(entry.getKey() < righeDocumento.size())
//										righeDocumento.add(entry.getKey(), entry.getValue());
//									else {
//										List<WKRigoDocumento> tmp = new ArrayList<WKRigoDocumento>(entry.getKey());
//										tmp.addAll(righeDocumento);
//										tmp.add(entry.getKey(), entry.getValue());
//										righeDocumento = new ArrayList<WKRigoDocumento>(tmp);
//									}
//									righeFAV.put(entry.getKey(), entry.getValue());
								}
							} else {
								break;
							}
							i++;
						}
					} else {
						throw new Exception("Documento non formattato correttamente.");
					}
																		
					break;
				default:
					_log.error("Unrecognized string for: " + StringUtil.merge(Arrays.asList(st), ";"));
					throw new Exception("Documento non formattato correttamente.");
				}
			}
		}
		fileReader.close();
		
		//Add last document
		if(testataDocumento != null && righeDocumento != null){
			_log.info("Adding last to tmpDocs ...");
			tmpDocs.add(new Documento(testataDocumento, righeDocumento));
		}
		return tmpDocs;
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
                        String ddt = r.print(nDoc, new Long(associato.getId()).intValue(), op.getIdLiferay());

                        File file = new File(ddt);
                        InputStream in = new FileInputStream(file);

                        String fileName = addToDL(nDoc, file, resourceRequest, DDT);

                        if (send) {
                            sendEmail(associato, op, nDoc, update, DDT, file, fileName + ".pdf");
                        }

                        HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
                        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
                        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/pdf");
                        
                        in.close();
                        
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
                        String ddt = r.print(nDoc, new Long(associato.getId()).intValue(), "fav", op.getIdLiferay());

                        File file = new File(ddt);
                        InputStream in = new FileInputStream(file);

                        String fileName = addToDL(nDoc, file, resourceRequest, FAV);

                        if (send) {
                            sendEmail(associato, op, nDoc, update, FAV, file, fileName + ".pdf");
                        }

                        HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
                        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
                        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/pdf");
                        
                        in.close();
                        
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
                        String trace = r.printTrace(ANNO, nDoc, new Long(associato.getId()).intValue(), TRAC, op.getIdLiferay());

                        File file = new File(trace);
                        InputStream in = new FileInputStream(file);

                        String fileName = addToDL(nDoc, file, resourceRequest, TRAC);
                        if (send) {
                            sendEmail(associato, op, nDoc, false, TRAC, file, fileName + ".pdf");
                        }

                        HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
                        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
                        ServletResponseUtil.sendFile(httpReq, httpRes, file.getName(), in, "application/pdf");
                        
                        in.close();
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
//                numeroOrdine = (int) TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DDT, associato.getId()).get(0).getNumeroOrdine() + 1;
                List<TestataDocumento> documentiSoggetto = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DDT, associato.getId());
                if (documentiSoggetto.size() > 0) {
                    numeroOrdine = (int) documentiSoggetto.get(0).getNumeroOrdine() + 1;
                } else {
                    numeroOrdine = 1;
                }
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
                List<TestataDocumento> documentiSoggetto = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), FAV, associato.getId());
                if (documentiSoggetto.size() > 0) {
                    numeroFattura = (int) documentiSoggetto.get(0).getNumeroOrdine() + 1;
                } else {
                    numeroFattura = 1;
                }
            } catch (SystemException ex) {
                _log.error(ex.getMessage());
                return new Response(Response.Code.GET_PRIMARY_KEY_ERROR, -1);
            }
        } else { //AVANZAMENTO PROTOCOLLO MANUALE
            List<TestataDocumento> testate = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), FAV, associato.getId());
            TestataDocumento t = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ANNO, avanzaProtocollo, FAV, associato.getId()));
            if (t != null && !update) {
                _log.warn("Protocol already exists.");
                return new Response(Response.Code.ALREADY_EXISTS, avanzaProtocollo);
            }
            for (TestataDocumento testata : testate) {
                if (avanzaProtocollo < testata.getNumeroOrdine()) {
                    String dataTestataStr = testata.getDataOrdine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Date dataTestata = sdf.parse(dataTestataStr);
                    Date dataDocumento = sdf.parse(documentDate);
                    if (dataDocumento.after(dataTestata)) {
                        if (!update && dataDocumento.equals(dataTestata)) {
                            return new Response(Response.Code.NOT_VALID, avanzaProtocollo);
                        }
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
                scheda = TracciabilitaSchedaLocalServiceUtil.fetchTracciabilitaScheda(id);
            } else {
                id = 0; //CounterLocalServiceUtil.increment(TracciabilitaScheda.class.getName());
                scheda = TracciabilitaSchedaLocalServiceUtil.createTracciabilitaScheda((int) id);
            }
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

                long idGrezzo = grezzoJson.getLong("idGrezzo");
                TracciabilitaGrezzi grezzo;
                if (idGrezzo > 0) {
                    grezzo = TracciabilitaGrezziLocalServiceUtil.fetchTracciabilitaGrezzi(idGrezzo);
                } else {
                    idGrezzo = 0; //CounterLocalServiceUtil.increment(TracciabilitaGrezzi.class.getName());
                    grezzo = TracciabilitaGrezziLocalServiceUtil.createTracciabilitaGrezzi((int) idGrezzo);
                }

                grezzo.setFoglio(Integer.parseInt(grezzoJson.getString("foglio")));
                grezzo.setKg(Double.parseDouble(grezzoJson.getString("kg")));
                grezzo.setLottoGrezzo(grezzoJson.getString("lottoGrezzo"));
                grezzo.setParticella(Integer.parseInt(grezzoJson.getString("particella")));
                grezzo.setProdotto(grezzoJson.getString("prodotto"));
                grezzo.setProduttore(grezzoJson.getString("produttore"));
                grezzo.setIdSchedaTracciabilta((int) id);

                listGrezzi.add(grezzo);
            }

            if (scheda.getId() == 0) {
                _log.info("SAVING: " + scheda);
                long idScheda = CounterLocalServiceUtil.increment(TracciabilitaScheda.class.getName());
                scheda.setId(idScheda);
                TracciabilitaSchedaLocalServiceUtil.addTracciabilitaScheda(scheda);
                for (TracciabilitaGrezzi grezzoToSave : listGrezzi) {
                    long idGrezzo = CounterLocalServiceUtil.increment(TracciabilitaGrezzi.class.getName());
                    grezzoToSave.setId(idGrezzo);
                    grezzoToSave.setIdSchedaTracciabilta(idScheda);
                    _log.info("SAVING GREZZO: " + grezzoToSave);
                    TracciabilitaGrezziLocalServiceUtil.addTracciabilitaGrezzi(grezzoToSave);
                }
                newSchede.put(scheda.getId(), scheda);
                newGrezzi.put(scheda.getId(), listGrezzi);
            } else {
                updatingSchede.put(scheda.getId(), scheda);
                updatingGrezzi.put(scheda.getId(), listGrezzi);
            }
        }

        if (updatingSchede.size() > 0) {
            List<TracciabilitaScheda> oldSchede = TracciabilitaSchedaLocalServiceUtil.getByAnnoIdAssociato(ANNO, nDoc, a.getId());
            for (TracciabilitaScheda oldScheda : oldSchede) {
                List<TracciabilitaGrezzi> grezzi = updatingGrezzi.get(oldScheda.getId());
                if (updatingSchede.containsKey(oldScheda.getId())) { //UPDATE
                    _log.info("UPDATING: " + oldScheda);
                    oldScheda = updatingSchede.get(oldScheda.getId());
                    TracciabilitaSchedaLocalServiceUtil.updateTracciabilitaScheda(oldScheda);
                    for (TracciabilitaGrezzi grezzo : grezzi) {
                        if (grezzo.getId() != 0) { //UPDATE
                            _log.info("UPDATING OLD GREZZO: " + grezzo);
                            TracciabilitaGrezziLocalServiceUtil.updateTracciabilitaGrezzi(grezzo);
                        } else {
                            long idGrezzo = CounterLocalServiceUtil.increment(TracciabilitaGrezzi.class.getName());
                            grezzo.setId(idGrezzo);
                            _log.info("INSERTING GREZZO: " + grezzo);
                            TracciabilitaGrezziLocalServiceUtil.addTracciabilitaGrezzi(grezzo);
                        }
                    }
                } else if (!newSchede.containsKey(oldScheda.getId())) {//DELETE
                    _log.info("DELETING OLD SCHEDA: " + oldScheda);
                    List<TracciabilitaGrezzi> oldGrezzi = TracciabilitaGrezziLocalServiceUtil.getIdSchedaTracciabilita(oldScheda.getId());
                    for (TracciabilitaGrezzi oldGrezzo : oldGrezzi) {
                        _log.info("DELETING OLD GREZZO: " + oldGrezzo);
                        TracciabilitaGrezziLocalServiceUtil.deleteTracciabilitaGrezzi(oldGrezzo);
                    }
                    TracciabilitaSchedaLocalServiceUtil.deleteTracciabilitaScheda(oldScheda);
                }
            }
        }

        return new Response(Response.Code.OK, 0);
    }
    
    private File uploadFile(UploadPortletRequest uploadRequest, long idAssociato) throws Exception {
        long sizeInBytes = uploadRequest.getSize("fileupload");

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

        //replace all illegal characters
        sourceFileName = sourceFileName.replaceAll("[^a-zA-Z0-9.-]", "_");

        // This is our final file path.
        File filePath = new File(folder.getAbsolutePath() + File.separator + idAssociato+ "_" +sourceFileName);

        // Move the existing temporary file to new location.
        FileUtil.copyFile(uploadedFile, filePath);
        
        return filePath;
    }
}
