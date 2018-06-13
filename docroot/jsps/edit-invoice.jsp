<%@page import="com.google.gson.JsonArray"%>
<%@page import="it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DescrizioniDocumenti"%>
<%@page import="it.bysoftware.ct.service.ArticoliLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Articoli"%>
<%@page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserIdMapper"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException"%>
<%@page import="it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.OrganizzazioneProduttori"%>
<%@page import="it.its.ct.gestionaleOP.utils.Constants"%>
<%@page import="it.its.ct.gestionaleOP.utils.DocumentType"%>
<%@page import="it.bysoftware.ct.service.persistence.ClientiDatiAggPK"%>
<%@page import="it.bysoftware.ct.service.IvaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Iva"%>
<%@page import="it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.ClientiDatiAgg"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.bysoftware.ct.service.ProgressivoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Progressivo"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.RigoDocumento"%>
<%@page import="it.bysoftware.ct.service.persistence.TestataDocumentoPK"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.AnagraficaLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.DestinatariDiversiLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DestinatariDiversi"%>
<%@include file="../init.jsp" %>

<%
    JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
    TestataDocumento testata;
    List<TestataDocumento> listTestata = new ArrayList<TestataDocumento>();
    Anagrafica cliente;
    ClientiDatiAgg datiAggCliente;
    String codiceAliquotaCliente;
    String indirizzoCompleto;
    UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(Long.parseLong(renderRequest.getRemoteUser()), Constants.FUTURO_NET);
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper.getUserIdMapperId());
    String origDoc = ParamUtil.getString(renderRequest, "numeroDocumento", "");
    String origDocs = ParamUtil.getString(renderRequest, "documentIds", "");
    TestataDocumento fac = null;
    boolean document2op = false;
    boolean update = false;
    if (ParamUtil.getLong(renderRequest, "numeroDocumento", -1) != -1) {
    	update = true;
    	long cod = ParamUtil.getLong(renderRequest, "codiceCliente");
    	if (a.getIdLiferay() == cod){
    		testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), ParamUtil.getLong(renderRequest, "numeroDocumento", -1), DocumentType.FAC.name(), a.getId()));
    		document2op = true;
    		OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
    		cliente = AnagraficaLocalServiceUtil.getAnagrafica(String.valueOf(op.getIdLiferay()));
    	} else {
    		testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), ParamUtil.getLong(renderRequest, "numeroDocumento", -1), DocumentType.FAV.name(), a.getId()));
    		cliente = AnagraficaLocalServiceUtil.getAnagrafica(testata.getCodiceSoggetto());
    	}
        
        indirizzoCompleto = cliente.getIndirizzo() + " - " + cliente.getCap() + ", " + cliente.getComune() + " (" + cliente.getProvincia() + ") - " + cliente.getStato();
        datiAggCliente = ClientiDatiAggLocalServiceUtil.fetchClientiDatiAgg(new ClientiDatiAggPK(cliente.getCodiceAnagrafica(), false));
        codiceAliquotaCliente = datiAggCliente.getCodiceAliquota();
        
        if(testata.getNota2()!=null
        		&& !testata.getNota2().isEmpty()
        		&& !testata.getNota2().equals(String.valueOf(testata.getNumeroOrdine()))){
        	fac = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), Long.parseLong(testata.getNota2()), DocumentType.FAC.name(), a.getId())); 
        } else {
        	fac = testata;
        }
        
        List<RigoDocumento> righe;
        if(document2op){
        	righe = RigoDocumentoLocalServiceUtil.getFatturaByNumeroOrdineAnnoAssociato(testata.getNumeroOrdine(), testata.getAnno(), a.getId(), DocumentType.FAC.name());
        } else {
        	righe = RigoDocumentoLocalServiceUtil.getFatturaByNumeroOrdineAnnoAssociato(testata.getNumeroOrdine(), testata.getAnno(), a.getId(), DocumentType.FAV.name());
        }
        	

        for (RigoDocumento rigo : righe) {
            JSONObject json = JSONFactoryUtil.createJSONObject();
            json.put("codiceArticolo", rigo.getCodiceArticolo());
            json.put("descrizione", rigo.getDescrizione());
            json.put("codiceVariante", rigo.getCodiceVariante());
            json.put("descrizioneVariante", rigo.getDescrizioneVariante());
            json.put("imballo", rigo.getImballo());
            json.put("lotto", rigo.getLotto());
            json.put("unitaMisura", rigo.getUnitaMisura());
            json.put("colli", rigo.getColli());
            json.put("pesoLordo", rigo.getPesoLordo());
            json.put("pesoNetto", rigo.getPesoNetto());
            json.put("prezzo", rigo.getPrezzo());
            json.put("sconto1", rigo.getSconto1());
            json.put("sconto2", rigo.getSconto2());
            json.put("sconto3", rigo.getSconto3());
            if (!rigo.getCodiceArticolo().equals("")) {
                if (rigo.getPesoLordo() != 0) {
                    if (!datiAggCliente.getCodiceAliquota().isEmpty()) {
                        codiceAliquotaCliente = datiAggCliente.getCodiceAliquota();
                    } else {
                        Articoli articolo = ArticoliLocalServiceUtil.getArticoli(rigo.getCodiceArticolo());
                        if (articolo != null) {
                            codiceAliquotaCliente = articolo.getCodiceIVA();
                        } else {
                            codiceAliquotaCliente = "04";
                        }
                    }
                } else {
                    DescrizioniDocumenti descr = DescrizioniDocumentiLocalServiceUtil.fetchDescrizioniDocumenti(rigo.getCodiceArticolo());
                    if (descr != null) {
                        codiceAliquotaCliente = descr.getCodiceIVA();
                    }
                }
                json.put("codiceIva", codiceAliquotaCliente);
                Iva iva = IvaLocalServiceUtil.fetchIva(codiceAliquotaCliente);
                if (iva != null) {
                    json.put("aliquotaIva", iva.getAliquota());
                }
            } else if (rigo.getPrezzo() != 0) {
                if (!datiAggCliente.getCodiceAliquota().isEmpty()) {
                    codiceAliquotaCliente = datiAggCliente.getCodiceAliquota();
                } else if (!"".equals(rigo.getCodiceIva())) {
                    codiceAliquotaCliente = rigo.getCodiceIva();
                }
                json.put("codiceIva", codiceAliquotaCliente);
                Iva iva = IvaLocalServiceUtil.fetchIva(codiceAliquotaCliente);
                if (iva != null) {
                    json.put("aliquotaIva", iva.getAliquota());
                }
            }
            
            double importo = 0;

            double sconto1 = rigo.getSconto1();
            double sconto2 = rigo.getSconto2();
            double sconto3 = rigo.getSconto3();

            double importo1, importo2 = 0;
            double tmpImporto = rigo.getPrezzo() * rigo.getPesoNetto();

            importo1 = tmpImporto - ((tmpImporto * sconto1) / 100);
            importo2 = importo1 - ((importo1 * sconto2) / 100);
            importo = importo2 - ((importo2 * sconto3) / 100);
            importo = Math.round(importo * 100);
            json.put("importo", importo / 100);

            jsonArr.put(json);
        }
    } else {
        String[] ids = StringUtil.split(ParamUtil.getString(renderRequest, "documentIds"));
        
        String cod = ParamUtil.getString(renderRequest, "codiceCliente", null);
        OrganizzazioneProduttori op = null;
        if(cod != null && !cod.isEmpty()){
        	try {
        		op = OrganizzazioneProduttoriLocalServiceUtil.getOP(Long.parseLong(cod));
        	} catch (Exception ex){
        		op = null;
        	}
        }
		List<RigoDocumento> righeDocumenti = new ArrayList<RigoDocumento>();
        
        if (op == null) {
        	testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), Long.parseLong(ids[0]), DocumentType.DDT.name(), a.getId()));
            for (int i = 0; i < ids.length; i++) {
                listTestata.add(TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), Long.parseLong(ids[i]), DocumentType.DDT.name(), a.getId())));
            }
            cliente = AnagraficaLocalServiceUtil.getAnagrafica(listTestata.get(0).getCodiceSoggetto());
            
            for (String id : ids) {
                List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(Long.parseLong(id), ParamUtil.getInteger(renderRequest, "anno"), a.getId());
                righeDocumenti.addAll(righe);
            }
            
        } else {
        	document2op = true;
        	testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), Long.parseLong(ids[0]), DocumentType.DDA.name(), a.getId()));
            for (int i = 0; i < ids.length; i++) {
                listTestata.add(TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), Long.parseLong(ids[i]), DocumentType.DDA.name(), a.getId())));
            }
            cliente = AnagraficaLocalServiceUtil.getAnagrafica(listTestata.get(0).getCodiceSoggetto());
            for (String id : ids) {
                List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getDDAByNumeroOrdineAnnoAssociato(Long.parseLong(id), ParamUtil.getInteger(renderRequest, "anno"), a.getId());
                righeDocumenti.addAll(righe);
            }
            
        }

        datiAggCliente = ClientiDatiAggLocalServiceUtil.fetchClientiDatiAgg(new ClientiDatiAggPK(cliente.getCodiceAnagrafica(), false));
        codiceAliquotaCliente = datiAggCliente.getCodiceAliquota();
        indirizzoCompleto = cliente.getIndirizzo() + " - " + cliente.getCap() + ", " + cliente.getComune() + " (" + cliente.getProvincia() + ") - " + cliente.getStato();

        long oldDocument = -1;
        for (RigoDocumento rigo : righeDocumenti) {
            System.out.println(rigo);
            int i = 0;
            JSONObject json = JSONFactoryUtil.createJSONObject();
            if (oldDocument != rigo.getNumeroOrdine()) {
            	TestataDocumento tmpTestataDocumento = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(rigo.getAnno(), rigo.getNumeroOrdine(), rigo.getTipoDocumento(), rigo.getIdAssociato()));
                json.put("descrizione", "Documento di trasporto N. " + rigo.getNumeroOrdine() + "/" + a.getCentro() + " del " + tmpTestataDocumento.getDataOrdine());
                jsonArr.put(json);
                json = JSONFactoryUtil.createJSONObject();
                oldDocument = rigo.getNumeroOrdine();
            }
            json.put("codiceArticolo", rigo.getCodiceArticolo());
            json.put("descrizione", rigo.getDescrizione());
            json.put("codiceVariante", rigo.getCodiceVariante());
            json.put("descrizioneVariante", rigo.getDescrizioneVariante());
            json.put("imballo", rigo.getImballo());
            json.put("lotto", rigo.getLotto());
            json.put("unitaMisura", rigo.getUnitaMisura());
            json.put("colli", rigo.getColli());
            json.put("pesoLordo", rigo.getPesoLordo());
            json.put("pesoNetto", rigo.getPesoNetto());
            json.put("prezzo", rigo.getPrezzo());
            json.put("sconto1", rigo.getSconto1());
            json.put("sconto2", rigo.getSconto2());
            json.put("sconto3", rigo.getSconto3());
            if (!rigo.getCodiceArticolo().equals("")) {
                if (rigo.getPesoLordo() != 0) {
                    if (!datiAggCliente.getCodiceAliquota().isEmpty()) {
                        codiceAliquotaCliente = datiAggCliente.getCodiceAliquota();
                    } else {
                        Articoli articolo = ArticoliLocalServiceUtil.getArticoli(rigo.getCodiceArticolo());
                        if (articolo != null) {
                            codiceAliquotaCliente = articolo.getCodiceIVA();
                        } else {
                            codiceAliquotaCliente = "04";
                        }
                    }
                } else {
                    DescrizioniDocumenti descr = DescrizioniDocumentiLocalServiceUtil.fetchDescrizioniDocumenti(rigo.getCodiceArticolo());
                    if (descr != null) {
                        codiceAliquotaCliente = descr.getCodiceIVA();
                    }
                }
                json.put("codiceIva", codiceAliquotaCliente);
                Iva iva = IvaLocalServiceUtil.fetchIva(codiceAliquotaCliente);
                if (iva != null) {
                    json.put("aliquotaIva", iva.getAliquota());
                }
            }
            
            double importo = 0;

            double sconto1 = rigo.getSconto1();
            double sconto2 = rigo.getSconto2();
            double sconto3 = rigo.getSconto3();

            double importo1, importo2 = 0;
            double tmpImporto = rigo.getPrezzo() * rigo.getPesoNetto();

            importo1 = tmpImporto - ((tmpImporto * sconto1) / 100);
            importo2 = importo1 - ((importo1 * sconto2) / 100);
            importo = importo2 - ((importo2 * sconto3) / 100);
            
            json.put("importo", String.format("%.2f", importo));

            jsonArr.put(json);
            i++;
        }

    }

    List<Progressivo> listProgressivo = ProgressivoLocalServiceUtil.getByAnnoIdAssociatoTipoDocumento(Calendar.getInstance().get(Calendar.YEAR), a.getId(), Constants.INVOICE_ID);

    ArrayList<Integer> idToRecover = new ArrayList<Integer>();

    for (Progressivo p : listProgressivo) {
        idToRecover.add(p.getNumeroProgressivo());
    }

    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Iva iva;
    if (!codiceAliquotaCliente.equals("")) {
        iva = IvaLocalServiceUtil.fetchIva(codiceAliquotaCliente);
    } else {
        iva = IvaLocalServiceUtil.fetchIva("04");
    }
    
    List<Iva> vats = IvaLocalServiceUtil.getIvas(0,
            IvaLocalServiceUtil.getIvasCount());
    String vatCodes = "";
    for (Iva vat : vats) {
        vatCodes += "|" + vat.getCodiceIva() + " --> " + vat.getDescrizione() + " --> " + (int)vat.getAliquota();
    }
//     JSONObject jsonTotali = JSONFactoryUtil.createJSONObject();
//     for (int i = 0; i < jsonArr.length(); i++) {
//         JSONObject rigo = jsonArr.getJSONObject(i);
//         JSONObject totale;
//         JSONArray imponibili;
//         if(!rigo.getString("codiceIva").isEmpty()) {
// 	        if(jsonTotali.length() == 0 || jsonTotali.isNull(rigo.getString("codiceIva"))) {
// 	            totale = JSONFactoryUtil.createJSONObject();
// 	            imponibili = JSONFactoryUtil.createJSONArray();
// 	            imponibili.put(rigo.getDouble("importo"));
// 	            totale.put("imponibili", imponibili);
// 	            totale.put("aliquota", rigo.getDouble("aliquotaIva"));
// 	            jsonTotali.put(rigo.getString("codiceIva"), totale);
// 	        } else {
// 	            totale = jsonTotali.getJSONObject(rigo.getString("codiceIva"));
// 	            imponibili = totale.getJSONArray("imponibili");
// 	            imponibili.put(rigo.getDouble("importo"));
// 	        }
//         }
//     }
%>

<liferay-portlet:resourceURL var="updateInvoice"  id="updateInvoice" >
    <liferay-portlet:param name="numeroDocumento" value="<%= origDoc%>" />
    <%--<liferay-portlet:param name="documentIds" value="<%= origDocs%>" />--%>
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL var="saveInvoice"  id="generateInvoice" >
    <%--<liferay-portlet:param name="numeroDocumento" value="<%= origDoc%>" />--%>
    <liferay-portlet:param name="documentIds" value="<%= origDocs%>" />
</liferay-portlet:resourceURL>
<portlet:resourceURL var="printInvoice" id="printInvoice" />
<portlet:renderURL var="printCreditTransferUrl" >
    <liferay-portlet:param name="idAssociato"  value="<%= String.valueOf(a.getId()) %>" />
    <liferay-portlet:param name="codiceCliente" value="<%= cliente.getCodiceAnagrafica() %>" />
    <liferay-portlet:param name="dataFattura" value="<%= origDoc.equals("") ? sdf.format(date) : testata.getDataOrdine()%>" /> 
    <liferay-portlet:param name="jspPage"  value="/jsps/edit-credit-transfer.jsp" />
</portlet:renderURL>
<liferay-portlet:renderURL var="descrURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectDescription.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="itemURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectItem.jsp" />
</liferay-portlet:renderURL>

<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <c:choose>
                <c:when test="<%= origDoc.equals("")%>">
                    <button id="btnInvoice" class="btn" onclick="saveInvoice()"><i class="icon-list-alt"></i>Genera Fattura</button>
                </c:when>
                <c:when test="<%= !origDoc.equals("")%>">
                    <button id="btnInvoice" class="btn" onclick="saveInvoice(<%= origDoc%>)"><i class="icon-save"></i>Salva Modifiche</button>
                </c:when>
            </c:choose>
            <button id="btnPrint"   class="btn" <%= origDoc.equals("") ? "disabled=\"true\"" : ""%>><i class="icon-print"></i>Stampa</button>
            <button id="btnPrintCessione" class="btn" <%= origDoc.equals("") ? "disabled=\"true\"" : ""%>><i class="icon-envelope"></i> Cessione Credito</button>
        </div>
    </div>  
</aui:field-wrapper>

<aui:fieldset label="Testata Fattura">
    <aui:layout>
        <aui:column columnWidth="60" cssClass="detail-column detail-column-first">
            <aui:input id="codiceClienteTxt" type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
            <aui:input id="clienteTxt" type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=cliente.getRagioneSociale()%>"/>
            <aui:input id="destinazioneTxt" type="text" name="destinazione" label="Destinazione diversa" cssClass="input-xxlarge" value="<%=indirizzoCompleto%>" inlineField="true"/>
            <aui:input id="codiceDestinazione" type="text" name="codiceDest" label="" inlineField="true" style="display: none" value="<%= testata.getCodiceDestinazione()%>" />    
            <aui:input id="documentDate" type="text" name="documentDate" label="Data Documento" inlineField="true" value="<%= origDoc.equals("") ? sdf.format(date) : testata.getDataOrdine()%>"/>
        </aui:column>
        <c:choose>
	        <c:when test="<%= !document2op %>">
			        <aui:column columnWidth="20" cssClass="test" >
		        	<aui:fieldset label="Fattura vendita">
			            <aui:input type="text" name="nDoc" label="N. Documento" value="<%= origDoc%>" disabled="<%= update %>">
			            	<aui:validator name="digits"></aui:validator>
			            </aui:input>
			            <aui:select label="Rec Protocollo" name="recProt" style="background-color: #FFFFCC;" disabled="<%= update %>"> 
			                <c:forEach items="<%= idToRecover%>" var="id">
			                    <aui:option value="${id}">
			                        ${id}
			                    </aui:option>
			                </c:forEach>
			            </aui:select>
		            </aui:fieldset>
		        </aui:column>
		        <aui:column columnWidth="20" cssClass="test" last="true" >
		            <aui:fieldset label="Fattura conferimento">
			            <aui:input type="text" name="nDocConf" label="N. Documento" value="<%= testata.getNota2()%>" >
			            	<aui:validator name="digits"></aui:validator>
			            </aui:input>
			            <aui:input type="text" name="dateDocConf" label="Data Documento" value="<%= (fac != null) ? fac.getDataOrdine() : sdf.format(date)%>" >
			            	<aui:validator name="date" ></aui:validator>
			            </aui:input>
		            </aui:fieldset>
		        </aui:column>
	        </c:when>
	        <c:otherwise>
	        	<aui:column columnWidth="20" cssClass="test" last="true" >
		            <aui:fieldset label="Fattura conferimento">
			            <aui:input type="text" name="nDocConf" label="N. Documento" value="<%= testata.getNota2()%>" >
			            	<aui:validator name="digits"></aui:validator>
			            </aui:input>
			            <aui:input type="text" name="dateDocConf" label="Data Documento" value="<%= (fac != null) ? fac.getDataOrdine() : sdf.format(date)%>" >
			            	<aui:validator name="date" ></aui:validator>
			            </aui:input>
		            </aui:fieldset>
		        </aui:column>
	        </c:otherwise>
        </c:choose>
        
    </aui:layout>
</aui:fieldset>
<div id="myTab">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#tab-1">Corpo Fattura</a></li>
        <li><a href="#tab-2">Totali</a></li>
    </ul>

    <div class="tab-content">
        <div id="tab-1" class="tab-pane">
            <aui:fieldset label="Corpo Fattura">
                <aui:field-wrapper >
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <aui:a id="btnAdd" cssClass="btn" href="#a"><i class="icon-plus"></i>Aggiungi Articolo</aui:a>
                            <aui:a id="btnAddDescription" cssClass="btn" href="#a"><i class="icon-plus"></i>Aggiungi Descrizione</aui:a>
                            <aui:a id="btnRemove" cssClass="btn" href="#a"><i class="icon-trash"></i>Rimuovi</aui:a>
                            </div>
                        </div>
                </aui:field-wrapper>
                <aui:fieldset id="myDataTable" />
            </aui:fieldset>
        </div>
        <div id="tab-2">
            <aui:fieldset label="Totali Fattura">
                <aui:fieldset id="tabellaTotali" />
<%--                 <aui:input id="totaleImponibileTxt" type="text" name="totImponibile" label="Totale imponiible" disabled="true" inlineField="true"/> --%>
<%--                 <aui:input id="aliquotaTxt" type="text" name="aliquota" label="Aliquota" disabled="true" inlineField="true" value="<%= String.valueOf(iva.getAliquota()) + "%"%>"/> --%>
<%--                 <aui:input id="totaleIVATxt" type="text" name="totIVA" label="Totale IVA" disabled="true" inlineField="true"/> --%>
                <aui:input id="totaleDocumentoTxt" type="text" name="totDocumento" label="Totale documento" disabled="true" inlineField="true"/>
                
            </aui:fieldset>
        </div>
    </div>
</div>


<script type="text/javascript">
//        window.onbeforeunload = function () {
//            return "";
//        };

    var aliquotaIVA     = <%= iva.getAliquota()%>;
    var codiceAliquota  = '<%= iva.getCodiceIva()%>';
    var printCreditTransferUrl = "<%= printCreditTransferUrl.toString() %>";
    var vatCodes = '<%= vatCodes%>';
    YUI().use(
            'aui-tabview',
            function (Y) {
                new Y.TabView(
                        {
                            srcNode: '#myTab'
                        }
                ).render();
            }
    );

    YUI({lang: 'it'}).use('aui-datepicker', 'aui-modal', function (Y) {

        var documentDate = new Y.DatePicker({
            trigger: '#<portlet:namespace />documentDate',
            mask: '%d/%m/%Y',
            popover: {
                position: 'top',
                toolbars: {
                    header: [[
                            {
                                icon: 'icon-trash',
                                label: 'Cancella',
                                on: {
                                    click: function () {
                                    	documentDate.clearSelection();
                                    }
                                }
                            }
                        ]]
                },
                zIndex: 1
            },
            on: {
                selectionChange: function (event) {
                    console.log(event.newSelection);
                }
            }
        });
        
        var confDate = new Y.DatePicker({
            trigger: '#<portlet:namespace />dateDocConf',
            mask: '%d/%m/%Y',
            popover: {
                position: 'top',
                toolbars: {
                    header: [[
                            {
                                icon: 'icon-trash',
                                label: 'Cancella',
                                on: {
                                    click: function () {
                                    	confDate.clearSelection();
                                    }
                                }
                            }
                        ]]
                },
                zIndex: 1
            },
            on: {
                selectionChange: function (event) {
                    console.log(event.newSelection);
                }
            }
        });

    });

    var recordSelected;
    var table;

    YUI({lang: 'it'}).use('aui-datatable', 'aui-datatype', 'datatable-sort', 'datatable-mutable', function (Y) {

        var nameEditor = new Y.TextAreaCellEditor({
            validator: {
                rules: {
                    name: {
                        email: true,
                        required: true
                    }
                }
            }
        });

        var data = <%=jsonArr%>;
        var numberEditor = new Y.TextCellEditor(
                {
                    inputFormatter: Y.DataType.String.evaluate,
                    validator: {
                        rules: {
                            value: {
                                number: true,
                                required: true
                            }
                        }
                    }
                }
        );

        var columns = [
            //            {
            //                key: 'select',
            //                allowHTML: true, // to avoid HTML escaping
            //                label: '<input type="checkbox" class="protocol-select-all" title="Seleziona tutti"/>',
            //                formatter: '<input type="checkbox" checked/>',
            //                emptyCellValue: '<input type="checkbox"/>'
            //            },
            {
                //                allowHTML: true,
                key: 'codiceArticolo',
                label: 'Codice',
                width: '30px'
                        //                emptyCellValue: '<button class="selectArt"><i class="icon-hdd"></i>Seleziona</button>'
            },
            {
                key: 'descrizione',
                label: 'Descrizione Articolo'
            },
            {
            	key: 'codiceVariante',
                label: 'Cod. Var.',
                className: 'hide'
            },
            {
                key: 'descrizioneVariante',
                label: 'Var.'
            },
            {
                key: 'imballo',
                label: 'Imballo '
            },
            {
//                editor: nameEditor,
                key: 'lotto',
                label: 'Lotto'
            },
            {
                key: 'unitaMisura',
                label: 'U.M.'
            },
            {
                key: 'colli',
                label: 'Colli'
            },
            {
                key: 'pesoLordo',
                label: 'P. Lordo'
            },
            {
                editor: nameEditor,
                key: 'pesoNetto',
                label: 'Quant.'
            },
            {
                editor: numberEditor,
                key: 'prezzo',
                label: 'Prezzo'
            },
            {
                editor: numberEditor,
                key: 'sconto1',
                label: 'Sc. 1'
            },
            {
                editor: numberEditor,
                key: 'sconto2',
                label: 'Sc. 2'
            },
            {
                editor: numberEditor,
                key: 'sconto3',
                label: 'Sc. 3'
            },
            {
                key: 'importo',
                label: 'Importo'
            },
            {
            	editor: new Y.DropDownCellEditor({
            		centered: 'Node',
            		options: vatCodes.split('|'), 
           		}),
                key: 'codiceIva',
                label: 'C.I.' 
            },
            {
              key: 'aliquotaIva',
              label: '%',
              className: 'hide'
            }
        ];

        //        var data = [{}];
        table = new Y.DataTable({
            columns: columns,
            data: data,
            editEvent: 'click',
            plugins: [
                {
                    cfg: {
                        highlightRange: false
                    },
                    fn: Y.Plugin.DataTableHighlight
                }
            ]

        }).render('#<portlet:namespace />myDataTable');

        table.addAttr("selectedRow", {value: null});

        table.delegate('click', function (e) {
            recordSelected = table.getRecord(e.currentTarget);
        }, 'tr', table);
        table.after('*:pesoNettoChange', function (e) {
            calcolaSconto();
        });
        table.after('*:prezzoChange', function (e) {
            calcolaSconto();
        });
        table.after('*:sconto1Change', function (e) {
            calcolaSconto();
        });
        table.after('*:sconto2Change', function (e) {
            calcolaSconto();
        });
        table.after('*:sconto3Change', function (e) {
            calcolaSconto();
        });

        table.after('*:importoChange', function (e) {
            calcolaImporti();
        });

        table.after('*:codiceIvaChange', function (e) {
            setCodiceIva();
        });
        
        Y.one("#<portlet:namespace />btnAddDescription").on("click", function () {
            recordSelected = undefined;
            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    draggable: true//,
                            //                    height: '600px',
                            //                    width: '1024px'
                },
                id: '<portlet:namespace/>DescriptionDialog',
                title: 'Descrizione',
                uri: '<%=descrURL%>'
            });
        });

        Y.one("#<portlet:namespace />btnRemove").on("click", function () {
            var row = table.getActiveRecord();
            if (row.getAttrs().codiceArticolo === '' || row.getAttrs().codiceArticolo === "PR"){
                table.removeRow(row);
                calcolaImporti();
            }
//             else if(row.getAttrs().prezzo === '' || row.getAttrs().prezzo === 0)
	        else if(!row.getAttrs().colli || row.getAttrs().colli === '') {
                table.removeRow(row);
                calcolaImporti();
            }
            else
                alert("Attenzione non e' possibile rimuovere un rigo con un prodotto.");
            recordSelected = "";
        });

        Y.one("#<portlet:namespace />btnAdd").on("click", function () {
            recordSelected = undefined;
            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: true,
                    draggable: true//,
                            //                    height: '600px',
                            //                    width: '1024px'
                },
                id: '<portlet:namespace/>itemDialog',
                title: 'Seleziona Prodotto',
                uri: '<%=itemURL%>'
            });
        });
    });

    Liferay.provide(window, 'closePopup', function (data, dialogId) {
        // Closing the dialog
        var dialog = Liferay.Util.Window.getById(dialogId);
        //        console.log(dialog);
        dialog.hide();
        console.log(data);
        switch (dialogId) {
            case '<portlet:namespace/>DescriptionDialog':
                setDescription(data);
                break;
            case '<portlet:namespace/>itemDialog':
                setItem(data);
                break;
        }
    }, ['liferay-util-window']);



    function calcolaSconto() {

        var record = recordSelected.getAttrs();
        var importo = 0;
//        var sconto1 = record.sconto1;
        var sconto1 = (!isNaN(record.sconto1)) ? record.sconto1 : 0;
        var sconto2 = (!isNaN(record.sconto2)) ? record.sconto2 : 0;
        var sconto3 = (!isNaN(record.sconto3)) ? record.sconto3 : 0;
        var importo1 = 0;
        var importo2 = 0;
        var tmpImporto = record.prezzo * record.pesoNetto;

        importo1 = tmpImporto - ((tmpImporto * sconto1) / 100);
        importo2 = importo1 - ((importo1 * sconto2) / 100);
        importo = importo2 - ((importo2 * sconto3) / 100);

        recordSelected.setAttrs({importo: importo.toFixed(2)});

    }

//     function calcolaImporti() {
//         var imponibile = 0;
//         var iva = 0;
//         var totaledocumento = 0;

//         for (var i = 0; i < table.data.size(); i++) {
//             var importo = table.getRecord(i).getAttrs().importo;
//             if (!isNaN(importo))
//                 imponibile += parseFloat(table.getRecord(i).getAttrs().importo);
//             console.log(imponibile);
//         }
//         iva = imponibile * aliquotaIVA / 100;
//         totaledocumento = imponibile + iva;

//         document.getElementById('<portlet:namespace />totaleImponibileTxt').value = imponibile.toFixed(2);
//         document.getElementById('<portlet:namespace />totaleIVATxt').value = iva.toFixed(2);
//         document.getElementById('<portlet:namespace />totaleDocumentoTxt').value = totaledocumento.toFixed(2);
//     }

    function setDescription(data) {
    	var tmp = data.split('|');
        console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({descrizione: tmp[0], codiceArticolo: tmp[1], codiceIva: tmp[2], aliquotaIva: tmp[3]});
            //recordSelected = undefined;
        } else {
            table.addRow({descrizione: tmp[0], codiceArticolo: tmp[1], codiceIva: tmp[2], aliquotaIva: tmp[3]}, {sync: true});
        }
    }

    function setItem(data) {
        var tmp = data.split('|');

        console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2]});
            recordSelected = undefined;
        } else {
            table.addRow({codiceArticolo: tmp[0], descrizione: tmp[1], unitaMisura: "Kg", codiceIva: tmp[4], aliquotaIva: tmp[5]}, {sync: true});
//            console.log("####: " + tmp[0] + " " + tmp[1] + " " + tmp[2]);
        }
    }

    function saveInvoice(origDoc) {
        var rows = [];
        var ok = true;
        for (var i = 0; i < table.data.size(); i++) {
            if (table.data.item(i).toJSON().pesoLordo !== 0)
                if (table.data.item(i).toJSON().importo === 0 || table.data.item(i).toJSON().importo === "0.00") {
                    ok = false;
                    break;
                }
            rows[i] = table.data.item(i).toJSON();
        }
        console.log(rows);
        var msg = checkInfoDocs();
        if (rows.length !== 0 && ok) {
        	if (msg === '') {
            	sendData(rows, origDoc);
        	} else {
        		alert("Attenzione non e' possibile generare la fattura.\n" + msg);
        	}
        } else {
        	alert("Attenzione non e' possibile generare la fattura.\nVerificare di aver inserito i prezzi per tutti gli articoli.");
        }

    }
    
    function checkInfoDocs() {
    	var msg = '';
    	YUI().use('aui-io-request', 'node', function (Y) {
    		var nDocConf = Y.one('#<portlet:namespace/>nDocConf').val();
    		var tmp=Y.one('#<portlet:namespace/>dateDocConf').val().split("/");
    		var timestamp = Date.parse(tmp[1] + "/" + tmp[0] + "/" + tmp[2]);
    		if(nDocConf !== '' && isNaN(nDocConf)){
    			msg = 'Inserire un valore numerico per il numero di fattura di conferimento.';
    		}
    		if (isNaN(timestamp)){
    			msg = "La data del documento di conferimento non e' valida";
    		} 
    	});
    	return msg;
	}
    
    function sendData(rows, origDoc) {
    	var document2op = <%= document2op %>;
        YUI().use('aui-io-request', 'node', function (Y) {

            /******CAMPI TESTATA******/
            var codiceCliente = Y.one('#<portlet:namespace />codiceClienteTxt').val();
            var clienteTxt = Y.one('#<portlet:namespace />clienteTxt').val();
            var destinazioneTxt = Y.one('#<portlet:namespace />destinazioneTxt').val();
            var codiceDestinazione = Y.one('#<portlet:namespace />codiceDestinazione').val();
            var documentDate = Y.one('#<portlet:namespace />documentDate').val();
            var numeroFattura = (!document2op) ? Y.one('#<portlet:namespace/>recProt').val() : '';
            var avanzaProtocollo = (!document2op) ? Y.one('#<portlet:namespace/>recProt').val() : '';
            var nDocConf = Y.one('#<portlet:namespace/>nDocConf').val();
            var dateDocConf = Y.one('#<portlet:namespace/>dateDocConf').val();
            var datiDocConf = '';
            if(nDocConf !== ''){
            	datiDocConf = "&<portlet:namespace/>nDocConf=" + nDocConf + "&<portlet:namespace/>dateDocConf=" + dateDocConf;
            }
            
            var queryString = "&<portlet:namespace/>codCli=" + codiceCliente +
                    "&<portlet:namespace/>clienteTxt=" + clienteTxt + "&<portlet:namespace/>destinazioneTxt=" + destinazioneTxt +
                    "&<portlet:namespace/>codiceDestinazione=" + codiceDestinazione + "&<portlet:namespace/>documentDate=" + documentDate +
                    "&<portlet:namespace/>numeroFattura=" + numeroFattura + "&<portlet:namespace/>avanzaProtocollo=" + avanzaProtocollo + datiDocConf;
            //        Y.one('#btnSave').on('click', function () {
            Y.io.request(((origDoc) ? '${updateInvoice}' : '${saveInvoice}') + queryString + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(rows)), {
                on: {
                    success: function () {
                        var data = JSON.parse(this.get('responseData'));
                        if (data.code === 0) {
                            alert("Salvataggio effettuato con successo.");
                            if (Y.one('#<portlet:namespace/>nDoc').get('value') === '' ) {
								Y.one('#<portlet:namespace/>nDoc').set('value', data.id);
							}
                            document.getElementById("btnPrint").disabled = false;
                            document.getElementById("btnPrintCessione").disabled = false;
                            document.getElementById("btnInvoice").disabled = true;
                            if (Y.one('#<portlet:namespace/>recProt').val() !== "") {
                                document.getElementById('<portlet:namespace/>recProt').value = "";
                            }
                        } else {
                            console.log(data);
                            switch (data.code) {
                                case 1:
                                case 2:
                                case 3:
                                case 7:
                                    alert("Errore durante il salvataggio dei dati.\n" + JSON.stringify(data));
                                    break;
                                case 4:
                                    alert("Salvataggio effettuato con successo.");
                                    Y.one('#<portlet:namespace/>nDoc').set('value', data.id);
                                    document.getElementById("btnPrint").disabled = false;
                                    document.getElementById("btnPrintCessione").disabled = false;
                                    document.getElementById("btnInvoice").disabled = true;
                                    if (Y.one('#<portlet:namespace/>recProt').val() !== "") {
                                        document.getElementById('<portlet:namespace/>recProt').value = "";
                                    }
                                    alert("Attenzione, non e' stato possibile invare la mail di notifica.\n");
                                    break;
                                case 5:
                                    alert("Attenzione, il numero di protocollo: " + data.id + " e' gia' presente in archivio.\n");
                                    break;
                                case 6:
                                    alert("Attenzione, esiste almeno un numero di protocollo maggiore di " + data.id + " con una data precedente a: " + documentDate + ".");
                                    break;
                                case 9:
                                    alert("Attenzione, non e' stato possibile salvare la fattura, e' necessario specificare il numero di protocollo da assegnare.");
                                    break;
                                case 10:
                                    alert("Attenzione, non e' stato possibile salvare la fattura, esiste almeno una fattura con protocollo minore di: " + data.id + " e data maggiore di: " + documentDate);
                                    break;
                                case 11:
                                    alert("Attenzione, esiste gia' una fattura di conferimento con muero di portocollo: " + data.id);
                                    break;
                            }
                        }
                    }
                }
            });

        });
    }

    YUI().use('aui-io-request', 'node', function (Y) {
    	var document2op = <%= document2op %>;
        Y.one('#btnPrint').on('click', function () {
            var nDoc = (!document2op) ? Y.one('#<portlet:namespace/>nDoc').val() : '';
            var nDocConf = Y.one('#<portlet:namespace/>nDocConf').val();
            var dateDocConf = Y.one('#<portlet:namespace/>dateDocConf').val();
            var codiceCliente = Y.one('#<portlet:namespace/>codiceClienteTxt').val();
            var datiDocConf = '';
            if(nDocConf !== ''){
            	datiDocConf = "&<portlet:namespace/>nDocConf=" + nDocConf + "&<portlet:namespace/>dateDocConf=" + dateDocConf;
            }
            var win = window.open('${printInvoice}' + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />codiceCliente=' + codiceCliente + '&<portlet:namespace />update=' + false + '&<portlet:namespace />send=' + true + datiDocConf, '_blank');
            win.focus();

        });
        Y.one('#btnPrintCessione').on('click', function () {
            var nDoc = Y.one('#<portlet:namespace/>nDoc').val();
            var codiceCliente = Y.one('#<portlet:namespace/>codiceClienteTxt').val();
            var totaleFattura = Y.one('#<portlet:namespace/>totaleDocumentoTxt').val();
            window.location.href = printCreditTransferUrl + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />codiceCliente=' + codiceCliente +'&<portlet:namespace />totaleFattura=' + totaleFattura;
        });
    });

    var t1;
    YUI().use('aui-datatable', 'aui-datatype', 'datatable-sort', 'datatable-mutable', function(Y) {

    	var data = calcolaImporti();
    	
    	var columns = [{
    		key: 'imponibile',
    		label: 'Imponibile'
    	},
    	{
    		label: 'Aliquota',
    		key: 'aliquota'
    	},
    	{
    		key: 'IVA',
    		label: 'Totale IVA'
    	},
    	{
            key: 'totale',
            label: 'Totale'
        }];
    	
    	t1 = new Y.DataTable(
    			{
    				columns: columns,
    		        data: data
   		        }
    		    
    	).render('#<portlet:namespace />tabellaTotali');
   	});
    
    function setCodiceIva() {
    	var record = recordSelected.getAttrs();
    	var codice = record.codiceIva.split(" --> ")[0];
    	var aliquota = record.codiceIva.split(" --> ")[2];
    	recordSelected.setAttrs({codiceIva: codice, aliquotaIva: aliquota});
    	calcolaImporti();
    }
    
    function calcolaImporti(){
        var data = [];
        var i = 0;
        var somma = 0.0;
        var jsonTotali = {};
        
        for (var k = 0; k < table.data.size(); k++) {
            var rigo = table.getRecord(k).getAttrs();
            if(rigo.codiceIva){         
                var codiceIva = rigo.codiceIva;
                if(!jsonTotali[codiceIva]) {
                    jsonTotali[codiceIva]={};
                    jsonTotali[codiceIva].aliquota = Number(rigo.aliquotaIva);
                    jsonTotali[codiceIva].imponibili=[]; 
                }
                jsonTotali[codiceIva].imponibili.push(Number(rigo.importo));
            }
        }
        console.log("OLELLEL " + JSON.stringify(jsonTotali));
        
        for (var key in jsonTotali) {
            var totale = jsonTotali[key];
            var sommaImponibili = 0.0;
            for (var j = 0; j < totale.imponibili.length; j++) {
                sommaImponibili += totale.imponibili[j];
            }
            var x = sommaImponibili * (totale.aliquota / 100);
            var y = sommaImponibili * (1 + totale.aliquota / 100);
            somma += y;
            data[i] = {
                    imponibile: sommaImponibili.toFixed(2),
                    aliquota: totale.aliquota + '%',
                    IVA: x.toFixed(2),
                    totale: y.toFixed(2)
            }
            i++;
            console.log(JSON.stringify(data));
        }
        
        document.getElementById('<portlet:namespace />totaleDocumentoTxt').value = somma.toFixed(2);
        data.sort(function(a, b) {
            return parseFloat(a.aliquota.replace("%","")) - parseFloat(b.aliquota.replace("%",""));
        });
        if(t1) {
            t1.set('data', eval(data)); 
        }
        return data;
    }
</script>

