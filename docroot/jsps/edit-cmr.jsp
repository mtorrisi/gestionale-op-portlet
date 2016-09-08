<%@page import="it.bysoftware.ct.service.PortoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Porto"%>
<%@page import="it.bysoftware.ct.service.VettoriLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Vettori"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.RigoDocumento"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.bysoftware.ct.service.persistence.TestataDocumentoPK"%>
<%@page
	import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@include file="../init.jsp"%>

<%
	JSONArray righeJson = JSONFactoryUtil.createJSONArray();
	int anno = Calendar.getInstance().get(Calendar.YEAR);
	long idAssociato = ParamUtil.getLong(renderRequest, "idAssociato");
	Associato a = AssociatoLocalServiceUtil.getAssociato(idAssociato);
	String codiceCliente = ParamUtil.getString(renderRequest, "codiceCliente");
	String tmp = ParamUtil.getString(renderRequest, "numeroDocumento");
	Anagrafica cliente = null;
	TestataDocumento testata = null;
	Vettori vettore = null;
	Vettori vettore2 = null;
	Porto porto = null;
	long nDoc = -1;
	if (tmp != null && !tmp.equals("null")){
		nDoc = Long.parseLong(tmp);
		cliente = AnagraficaLocalServiceUtil.getAnagrafica(codiceCliente);
		testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(anno, nDoc, "DDT", idAssociato));
		vettore = VettoriLocalServiceUtil.fetchVettori(testata.getVettore());
		vettore2 = VettoriLocalServiceUtil.fetchVettori(testata.getVettore());
		porto = PortoLocalServiceUtil.fetchPorto(testata.getPorto());
		List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(nDoc, anno, idAssociato);
		for(RigoDocumento rigo : righe){
	if(!rigo.getCodiceArticolo().equals("")){
		JSONObject rigoJson = JSONFactoryUtil.createJSONObject();
		rigoJson.put("numeroColli", rigo.getColli());
		rigoJson.put("denominazione", rigo.getDescrizione());
		rigoJson.put("pesoLordo", rigo.getPesoLordo());
		
		righeJson.put(rigoJson);
	}
		}
	}
%>

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="codiceCliente" value="<%=codiceCliente%>" />
	<liferay-portlet:param name="numeroDocumento"
		value="<%=String.valueOf(nDoc)%>" />
	<liferay-portlet:param name="jspPage" value="/jsps/edit-ddt.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:header backLabel="Back" title="Indietro"
	backURL="<%=backURL%>" />
<portlet:resourceURL var="printCMR" id="printCMR">
	<portlet:param name="nDoc" value="<%=String.valueOf(nDoc)%>" />
</portlet:resourceURL>
<portlet:resourceURL var="saveCMR" id="saveCMR" />

<c:choose>
	<c:when test="<%=nDoc != -1%>">
		<aui:field-wrapper>
			<div class="btn-toolbar">
				<div class="btn-group">
					<button id="btnSave" class="btn">
						<i class="icon-hdd"></i>&nbsp;Salva
					</button>
					<button id="printCMR" class="btn">
						<i class="icon-print"></i>&nbsp;Stampa
					</button>
				</div>
			</div>
		</aui:field-wrapper>

		<aui:fieldset label="Compila CMR">
			<aui:form id="form" name="aform" method="post">
				<aui:row id="row_0">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel title="1 - Mittente" id="panel_1" state="open">
							<aui:input type="textarea" name="mittente" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%=a.getRagioneSociale() + "\n" + a.getIndirizzo()%>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel title="Lettera di vettura internazionale"
							id="panel_0" state="open">
							<aui:input type="textarea" name="numero" label=""
								cssClass="input-xxlarge" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_1">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel title="2 - Destinatario" id="panel_2"
							state="open">
							<aui:input type="textarea" name="destinatario" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%=cliente.getRagioneSociale() + "\n" + cliente.getIndirizzo()%>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel title="16 - Trasportatore" id="panel_16"
							state="open">
							<aui:input type="textarea" name="vettore" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%=vettore != null ? vettore.getRagioneSociale() + "\n" + vettore.getIndirizzo() + 
							" - " + vettore.getCAP() + vettore.getComune() + " (" + vettore.getProvincia() + ") " + vettore.getStato() : ""%>" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_2">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel
							title="3 - Luogo di presa in consegna delle merce" id="panel_3"
							state="open">
							<aui:input type="textarea" name="luogo-consegna" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%=a.getIndirizzo()%>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel title="17 - Trasportatori successivi"
							id="panel_17" state="open">
							<aui:input type="textarea" name="vettore2" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%=vettore2 != null ? vettore2.getRagioneSociale() + "\n" + vettore2.getIndirizzo() + 
							" - " + vettore2.getCAP() + vettore2.getComune() + " (" + vettore2.getProvincia() + ") " + vettore2.getStato() : ""%>" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_3">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel title="4 - Luogo di destinazione della merce"
							id="panel_4" state="open">
							<aui:input type="textarea" name="luogo-presa" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%=cliente.getIndirizzo()%>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel
							title="18 - Riserve ed osservazioni del trasportatore"
							id="panel_18" state="open">
							<aui:input type="textarea" name="riserve-vettore" label=""
								cssClass="input-xxlarge" resizable="false" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_4">
					<aui:col width="100">
						<liferay-ui:panel title="5 - Documenti allegati" id="panel_5"
							state="open">
							<aui:input name="allegati" label="" cssClass="input-xxlarge" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<br />
				<aui:row id="row_5">
					<%-- 				<aui:field-wrapper label="Corpo del documento"> --%>
					<aui:col width="100">
						<div id="myDataTable"></div>
					</aui:col>
					<%-- 				</aui:field-wrapper> --%>
				</aui:row>
				<aui:row id="row_6">
					<aui:col width="25">
						<aui:input name="classe" label="Classe " inlineLabel="true"
							cssClass="input-small" />
					</aui:col>
					<aui:col width="25">
						<aui:input name="cifra" label="Cifra " inlineLabel="true"
							cssClass="input-small" />
					</aui:col>
					<aui:col width="25">
						<aui:input name="lettera" label="Lettera " inlineLabel="true"
							cssClass="input-small" />
					</aui:col>
					<aui:col width="25">
						<aui:input name="adr" label="(ADR) " inlineLabel="true"
							cssClass="input-small" />
					</aui:col>
				</aui:row>
				<aui:row id="row_7">
					<aui:col width="50">
						<liferay-ui:panel title="13 - Istruzioni del mittente"
							id="panel_6" state="open">
							<aui:input type="textarea" name="istruzioni" label=""
								cssClass="input-xxlarge" resizable="false" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col width="50">
						<liferay-ui:panel title="19 - Convenzioni particolari"
							id="panel_7" state="open">
							<aui:input type="textarea" name="convenzioni" label=""
								cssClass="input-xxlarge" resizable="false" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_8">
					<aui:col width="50">
						<liferay-ui:panel
							title="14 - Istruzioni per il pagamento del nolo" id="panel_8"
							state="open">
							<aui:input type="textarea" name="istruzioni-pagamento" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%=(porto != null) ? (porto.getDescrizione()) : ""%>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col width="50">
						<liferay-ui:panel title="15 - Rimborso" id="panel_9" state="open">
							<aui:input type="textarea" name="rimborso" label=""
								cssClass="input-xxlarge" resizable="false" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_9">
					<aui:col width="100">
						<liferay-ui:panel title="21 - Dati compilazione" id="panel_10"
							state="open">
							<aui:input name="compilato-a" label="Compilato a "
								inlineField="true" cssClass="input-large" resizable="false"
								disabled="true" value="<%=a.getIndirizzo()%>" />
							<aui:input name="data-compilazione" label="il "
								inlineField="true" cssClass="input-large" resizable="false"
								disabled="true" value="<%=testata.getDataOrdine()%>" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_10">
					<aui:col width="50">
						<liferay-ui:panel title="22 - Firma e timbro del mittente"
							id="panel_10" state="open">
							<aui:input type="textarea" name="mittente" label=""
								cssClass="input-large" resizable="false" disabled="true"
								value="<%=a.getRagioneSociale() + "\n" + a.getIndirizzo()%>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col width="50">
						<liferay-ui:panel title="23 - Firma e timbro del trasportatore"
							id="panel_11" state="open">
							<aui:input name="motrice" label="Motrice " cssClass="input-large"
								value="<%=testata.getTargaCamion()%>" disabled="true" />
							<aui:input name="rimorchio" label="Rimorchio "
								value="<%=testata.getTargaRimorchio()%>" cssClass=" input-large"
								disabled="true" />
						</liferay-ui:panel>
					</aui:col>
					<%-- 				<aui:col width="34"> --%>
					<%-- 					<liferay-ui:panel title="24 - Merce ricevuta" id="panel_12" --%>
					<%-- 						state="open"> --%>
					<%-- 						<aui:input name="merce-ricevuta" label="Luogo " --%>
					<%-- 							cssClass="input-large" resizable="false" /> --%>
					<%-- 						<aui:input name="data-ricevuta" label="Data " --%>
					<%-- 							cssClass="input-large" resizable="false" /> --%>
					<%-- 					</liferay-ui:panel> --%>
					<%-- 				</aui:col> --%>
				</aui:row>
			</aui:form>
		</aui:fieldset>

		<aui:script>
			YUI().use('aui-datatable', 'aui-datatype', 'datatable-sort',
					'datatable-mutable', function(Y) {

						var data = <%= righeJson %>;
						var columns = [ {
							key : 'contrassegno',
							label : '6 - Contrassegno'
						}, {
							key : 'numeroColli',
							label : '7 - Numero colli'
						}, {
							key : 'imballaggio',
							label : '8 - Tipo di imballaggio'
						}, {
							key : 'denominazione',
							label : '9 - Descrizione delle merci',
							width : '500px'
						}, {
							key : 'numeroStatistica',
							label : '10 - N. Statistico'
						}, {
							key : 'pesoLordo',
							label : '11 - Peso Lordo Kg'
						}, {
							key : 'volume',
							label : '12 - Volume m3'
						} ];

						var table = new Y.DataTable({
							data : data,
							columns : columns,
							plugins : [ {
								cfg : {
									highlightRange : false
								},
								fn : Y.Plugin.DataTableHighlight
							} ]
						}).render('#myDataTable');
						table.get('boundingBox').unselectable();
					});

			YUI().use('aui-io-request', 'node', function(Y) {
				Y.one('#printCMR').on('click', function() {
					var win = window.open('${printCMR}', '_blank');
					win.focus();
				});
			});
			
			YUI().use('aui-io-request', 'node', function(Y) {
				Y.one('#saveCMR').on('click', function() {
					Y.io.request('${saveCMR}', {
						method: 'post', 
						form: { id: 'form' }, 
						on: { 
							success: function() { 
								var data = this.get('responseData'); 
								var content= JSON.parse(data); 
								alert(data); 
							} 
						} 
					});
				});
			});
	
		</aui:script>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-alert">Numero documento non valido</div>
	</c:otherwise>
</c:choose>
