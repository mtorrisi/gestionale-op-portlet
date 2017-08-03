<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>

<%@ page import="it.bysoftware.ct.model.Anagrafica" %>
<%@ page import="it.bysoftware.ct.model.Associato" %>
<%@ page import="it.bysoftware.ct.model.CMR" %>
<%@ page import="it.bysoftware.ct.model.Porto" %>
<%@ page import="it.bysoftware.ct.model.RigoDocumento" %>
<%@ page import="it.bysoftware.ct.model.Vettori" %>
<%@ page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.CMRLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.PortoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.VettoriLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.persistence.TestataDocumentoPK" %>

<%@ page import="it.its.ct.gestionaleOP.utils.DocumentType" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>

<%@page
	import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.model.TestataDocumento" %>
<%@ include file="../init.jsp" %>

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
	CMR cmr = null;
	if (tmp != null && !tmp.equals("null")) {
		nDoc = Long.parseLong(tmp);
		cliente = AnagraficaLocalServiceUtil.getAnagrafica(codiceCliente);
		testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(anno, nDoc, DocumentType.DDT.name(), idAssociato));
		vettore = VettoriLocalServiceUtil.fetchVettori(testata.getVettore());
		vettore2 = VettoriLocalServiceUtil.fetchVettori(testata.getVettore2());
		porto = PortoLocalServiceUtil.fetchPorto(testata.getPorto());
		List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(nDoc, anno, idAssociato);
		for (RigoDocumento rigo : righe) {
			if (!rigo.getCodiceArticolo().equals("")) {
				JSONObject rigoJson = JSONFactoryUtil.createJSONObject();
				rigoJson.put("numeroColli", rigo.getColli());
				rigoJson.put("denominazione", rigo.getDescrizione());
				rigoJson.put("pesoLordo", rigo.getPesoLordo());

				righeJson.put(rigoJson);
			}
		}
		cmr = CMRLocalServiceUtil.getCMRByAnnoAssociatoDDT(anno, idAssociato, nDoc);
	}
%>

<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="codiceCliente" value="<%= codiceCliente %>" />
	<liferay-portlet:param name="numeroDocumento"
		value="<%= String.valueOf(nDoc) %>" />
	<liferay-portlet:param name="tipoDocumento" value="<%= DocumentType.DDT.name() %>" />
	<liferay-portlet:param name="jspPage" value="/jsps/edit-ddt.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:header backLabel="Back" title="Indietro"
	backURL="<%= backURL %>" />
<portlet:resourceURL id="printCMR" var="printCMR">
	<portlet:param name="nDoc" value="<%= String.valueOf(nDoc) %>" />
</portlet:resourceURL>
<portlet:resourceURL id="saveCMR" var="saveCMR">
	<portlet:param name="nDoc" value="<%= String.valueOf(nDoc) %>" />
</portlet:resourceURL>

<c:choose>
	<c:when test="<%= nDoc != -1 %>">
		<aui:field-wrapper>
			<div class="btn-toolbar">
				<div class="btn-group">
					<button class="btn" id="btnSave">
						<i class="icon-hdd"></i>&nbsp;Salva
					</button>
					<button class="btn" id="printCMR" <%= cmr == null ? "disabled=\"true\"" : "" %>>
						<i class="icon-print"></i>&nbsp;Stampa
					</button>
				</div>
			</div>
		</aui:field-wrapper>

		<aui:fieldset label="Compila CMR">
			<aui:form id="form" method="post" name="aform">
				<aui:row id="row_0">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel id="panel_1" state="open" title="1 - Mittente">
							<aui:input name="mittente" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value='<%= a.getRagioneSociale() + "\n" + a.getIndirizzo() %>' />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel title="Lettera di vettura internazionale"
							id="panel_0" state="open">
							<aui:input name="numero" label=""
								cssClass="input-xxlarge" value='<%= (cmr != null) ? cmr.getNumeroCMR() : "" %>'/>
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_1">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel title="2 - Destinatario" id="panel_2"
							state="open">
							<aui:input name="destinatario" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value='<%= cliente.getRagioneSociale() + "\n" + cliente.getIndirizzo() %>' />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel title="16 - Trasportatore" id="panel_16"
							state="open">
							<aui:input name="vettore" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%= vettore != null ? vettore.getRagioneSociale() + "\n" + vettore.getIndirizzo() +
							" - " + vettore.getCAP() + vettore.getComune() + " (" + vettore.getProvincia() + ") " + vettore.getStato() : "" %>" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_2">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel
							title="3 - Luogo di presa in consegna delle merce" id="panel_3"
							state="open">
							<aui:input name="luogo-consegna" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%= a.getIndirizzo() %>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel title="17 - Trasportatori successivi"
							id="panel_17" state="open">
							<aui:input name="vettore2" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%= vettore2 != null ? vettore2.getRagioneSociale() + "\n" + vettore2.getIndirizzo() +
							" - " + vettore2.getCAP() + vettore2.getComune() + " (" + vettore2.getProvincia() + ") " + vettore2.getStato() : "" %>" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_3">
					<aui:col id="col_0" width="50">
						<liferay-ui:panel title="4 - Luogo di destinazione della merce"
							id="panel_4" state="open">
							<aui:input name="luogo-presa" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value="<%= cliente.getIndirizzo() %>" />
						</liferay-ui:panel>
					</aui:col>
					<aui:col id="col_1" width="50">
						<liferay-ui:panel
							title="18 - Riserve ed osservazioni del trasportatore"
							id="panel_18" state="open">
							<aui:input name="riserve-vettore" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" value='<%= (cmr != null) ? cmr.getRiserve() : "" %>'/>
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_4">
					<aui:col width="100">
						<liferay-ui:panel title="5 - Documenti allegati" id="panel_5"
							state="open">
							<aui:input cssClass="input-xxlarge" label="" name="allegati" value='<%= (cmr != null) ? cmr.getAllegati() : "" %>' />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<br />
				<aui:row id="row_5">
					<%-- <aui:field-wrapper label="Corpo del documento"> --%>
					<aui:col width="100">
						<div id="myDataTable"></div>
					</aui:col>
					<%-- </aui:field-wrapper> --%>
				</aui:row>
				<aui:row id="row_6">
					<aui:col width="25">
						<aui:input label="Classe " name="classe" inlineLabel="true"
							cssClass="input-small" value='<%= (cmr != null) ? cmr.getClasse() : "" %>' />
					</aui:col>
					<aui:col width="25">
						<aui:input label="Cifra " name="cifra" inlineLabel="true"
							cssClass="input-small" value='<%= (cmr != null) ? cmr.getCifra() : "" %>'/>
					</aui:col>
					<aui:col width="25">
						<aui:input label="Lettera " name="lettera" inlineLabel="true"
							cssClass="input-small" value='<%= (cmr != null) ? cmr.getLettera() : "" %>'/>
					</aui:col>
					<aui:col width="25">
						<aui:input label="(ADR) " name="adr" inlineLabel="true"
							cssClass="input-small" value='<%= (cmr != null) ? cmr.getAdr() : "" %>' />
					</aui:col>
				</aui:row>
				<aui:row id="row_7">
					<aui:col width="50">
						<liferay-ui:panel title="13 - Istruzioni del mittente"
							id="panel_6" state="open">
							<aui:input name="istruzioni" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" value='<%= (cmr != null) ? cmr.getIstruzioni() : "" %>'/>
						</liferay-ui:panel>
					</aui:col>
					<aui:col width="50">
						<liferay-ui:panel title="19 - Convenzioni particolari"
							id="panel_7" state="open">
							<aui:input name="convenzioni" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" value='<%= (cmr != null) ? cmr.getConvenzioni() : "" %>' />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_8">
					<aui:col width="50">
						<liferay-ui:panel
							title="14 - Istruzioni per il pagamento del nolo" id="panel_8"
							state="open">
							<aui:input name="istruzioni-pagamento" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" disabled="true"
								value='<%= (porto != null) ? (porto.getDescrizione()) : "" %>' />
						</liferay-ui:panel>
					</aui:col>
					<aui:col width="50">
						<liferay-ui:panel id="panel_9" state="open" title="15 - Rimborso">
							<aui:input name="rimborso" type="textarea" label=""
								cssClass="input-xxlarge" resizable="false" value='<%= (cmr != null) ? cmr.getRimborso() : "" %>' />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_9">
					<aui:col width="100">
						<liferay-ui:panel title="21 - Dati compilazione" id="panel_10"
							state="open">
							<aui:input name="compilato-a" label="Compilato a "
								inlineField="true" cssClass="input-large" resizable="false"
								disabled="true" value="<%= a.getComune() %>" />
							<aui:input name="data-compilazione" label="il "
								inlineField="true" cssClass="input-large" resizable="false"
								disabled="true" value="<%= testata.getDataOrdine() %>" />
						</liferay-ui:panel>
					</aui:col>
				</aui:row>
				<aui:row id="row_10">
					<aui:col width="50">
						<liferay-ui:panel title="22 - Firma e timbro del mittente"
							id="panel_10" state="open">
							<aui:input name="mittente" type="textarea" label=""
								cssClass="input-large" resizable="false" disabled="true"
								value='<%= a.getRagioneSociale() + "\n" + a.getIndirizzo() %>' />
						</liferay-ui:panel>
					</aui:col>
					<aui:col width="50">
						<liferay-ui:panel title="23 - Firma e timbro del trasportatore"
							id="panel_11" state="open">
							<aui:input label="Motrice " name="motrice" cssClass="input-large"
								value="<%= testata.getTargaCamion() %>" disabled="true" />
							<aui:input name="rimorchio" label="Rimorchio "
								value="<%= testata.getTargaRimorchio() %>" cssClass=" input-large"
								disabled="true" />
						</liferay-ui:panel>
					</aui:col>
					<%-- <aui:col width="34"> --%>
					<%-- <liferay-ui:panel title="24 - Merce ricevuta" id="panel_12" --%>
					<%-- state="open"> --%>
					<%-- <aui:input name="merce-ricevuta" label="Luogo " --%>
					<%-- cssClass="input-large" resizable="false" /> --%>
					<%-- <aui:input name="data-ricevuta" label="Data " --%>
					<%-- cssClass="input-large" resizable="false" /> --%>
					<%-- </liferay-ui:panel> --%>
					<%-- </aui:col> --%>
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
				Y.one('#btnSave').on('click', function() {
					/******CAMPI CMR******/
					var numeroCMR = Y.one('#<portlet:namespace />numero').val();
	                var riserve = Y.one('#<portlet:namespace />riserve-vettore').val();
	                var allegati = Y.one('#<portlet:namespace />allegati').val();
	                var classe = Y.one('#<portlet:namespace />classe').val();
	                var cifra = Y.one('#<portlet:namespace />cifra').val();
	                var lettera = Y.one('#<portlet:namespace />lettera').val();
	                var adr = Y.one('#<portlet:namespace />adr').val();
	                var istruzioni = Y.one('#<portlet:namespace />istruzioni').val();
	                var convenzioni = Y.one('#<portlet:namespace/>convenzioni').val();
	                var rimborso = Y.one('#<portlet:namespace/>rimborso').val();

	                var queryString = "&<portlet:namespace/>numeroCMR=" + (numeroCMR !== '' ? numeroCMR : "0") +
	                	"&<portlet:namespace/>riserve=" + riserve +
	                	"&<portlet:namespace/>allegati=" + allegati +
	                	"&<portlet:namespace/>classe=" + classe +
	                	"&<portlet:namespace/>cifra=" + cifra +
	                	"&<portlet:namespace/>lettera=" + lettera +
	                	"&<portlet:namespace/>adr=" + adr +
	                	"&<portlet:namespace/>istruzioni=" + istruzioni +
	                	"&<portlet:namespace/>convenzioni=" + convenzioni +
	                	"&<portlet:namespace/>rimborso=" + rimborso;

					Y.io.request('${saveCMR}' + queryString, {
						on: {
							success: function() {
								var data = JSON.parse(this.get('responseData'));
								if (data.code === 0) {
									alert("Salvataggio effettuato con successo.");
									Y.one('#<portlet:namespace/>numero').set('value', data.id);
									document.getElementById("printCMR").disabled = false;
									document.getElementById("btnSave").disabled = true;
								} else {
									alert("Errore durante il salvataggio dei dati.\n" + JSON.stringify(data));
								}
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