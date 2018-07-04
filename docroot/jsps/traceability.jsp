<%@ page import="it.bysoftware.ct.model.Anagrafica" %>
<%@ page import="it.bysoftware.ct.model.Associato" %>
<%@ page import="it.bysoftware.ct.model.RigoDocumento" %>
<%@ page import="it.bysoftware.ct.model.TestataDocumento" %>
<%@ page import="it.bysoftware.ct.model.TracciabilitaGrezzi" %>
<%@ page import="it.bysoftware.ct.model.TracciabilitaScheda" %>
<%@ page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.TracciabilitaGrezziLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.TracciabilitaSchedaLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.persistence.TestataDocumentoPK" %>

<%@ page import="it.its.ct.gestionaleOP.utils.DocumentType" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ include file="../init.jsp" %>

<%
	int anno = Calendar.getInstance().get(Calendar.YEAR);
	long idAssociato = Long.parseLong(ParamUtil.getString(renderRequest, "idAssociato"));
	long numeroDocumento = Long.parseLong(ParamUtil.getString(renderRequest, "numeroDocumento"));

	Associato a = AssociatoLocalServiceUtil.fetchAssociato(idAssociato);
	TestataDocumento testata = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(anno, numeroDocumento, DocumentType.DDT.name(), idAssociato));
	List<RigoDocumento> prodotti = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(numeroDocumento, anno, idAssociato);
	List<RigoDocumento> tmpProdotti = new ArrayList<RigoDocumento>();
	List<TracciabilitaScheda> schede = new ArrayList<TracciabilitaScheda>();
	for (RigoDocumento r : prodotti) {
		if (!r.getCodiceArticolo().equals("")) {
			tmpProdotti.add(r);
			TracciabilitaScheda scheda = TracciabilitaSchedaLocalServiceUtil.getByAnnoIdAssociatoCodiceProdotto(anno, numeroDocumento, a.getId(), r.getCodiceArticolo());
			if (scheda != null)
				schede.add(scheda);
		}
	}
	prodotti = tmpProdotti;
	Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(testata.getCodiceSoggetto());
	int index = 0;
	Map<String, List<TracciabilitaGrezzi>> grezzi = new HashMap<String, List<TracciabilitaGrezzi>>();
	if (schede.size() > 0) {
		for (TracciabilitaScheda s : schede) {
			List<TracciabilitaGrezzi> listGrezzi = TracciabilitaGrezziLocalServiceUtil.getIdSchedaTracciabilita(s.getId());
			if (!grezzi.containsKey(s.getCodiceProdotto())) {
				grezzi.put(s.getCodiceProdotto(), listGrezzi);
			}
		}
	}
%>

<portlet:resourceURL id="saveTrace"  var="saveScheda"  />
<portlet:resourceURL id="printTrace" var="printScheda" />
<div id="contentview">
	<aui:field-wrapper >
		<div class="btn-toolbar">
			<div class="btn-group">
				<button class="btn"    id="btnSave"><i class="icon-hdd"></i>Salva</button>
				<button class="btn"   disabled="true" id="btnPrint"><i class="icon-print"></i>Stampa</button>
			</div>
		</div>
	</aui:field-wrapper>

	<fieldset>
		<legend>Allegato tracciabilita'</legend>
		<aui:form action="" method="post" name="fm2">
			<aui:input cssClass="input-small" disabled="true" id="nDoc" inlineField="true" label="N. doc." name="nDoc" type="text" value="<%= numeroDocumento %>" />
			<aui:input cssClass="input-large" disabled="true" id="dataDoc" inlineField="true" label="Data documento" name="dataDoc" type="text" value="<%= testata.getDataOrdine() %>" />
			<aui:input cssClass="input-xxlarge" disabled="true" id="cliente" inlineField="true" label="Cliente" name="cliete" type="text" value="<%= cliente.getRagioneSociale() %>" />

			<c:forEach begin="1" end="<%= prodotti.size() %>" var="i">
				<% String collapsed = "collapsed"; %>
				<c:if test="${i eq 1}">
					<% collapsed = "open"; %>
				</c:if>
				<liferay-ui:panel-container extended="true">
					<liferay-ui:panel collapsible="true" cssClass="" defaultState="" id="panel_${i}" title="<%= prodotti.get(index).getDescrizione() %>">
						<aui:input cssClass="" id="idScheda_${i}" inlineField="true" label="" name="idScheda_${i}" style="display: none" type="text" value="<%= (schede.size() > 0 && index < schede.size()) ? schede.get(index).getId() : -1 %>" />
						<aui:input cssClass="" id="rigoOrdine_${i}" inlineField="true" label="" name="rigoOrdine_${i}" style="display: none"  type="text" value="<%= prodotti.get(index).getRigoOrdine() %>" />
						<aui:input cssClass="" id="codiceProdotto_${i}" inlineField="true" label="" name="codiceProdotto_${i}" style="display: none"  type="text" value="<%= prodotti.get(index).getCodiceArticolo() %>" />
						<aui:input cssClass="input-xlarge" disabled="true" id="prodottoVenduto_${i}" inlineField="true" label="Prodotto Venduto" name="prodottoVenduto_${i}" type="text" value="<%= prodotti.get(index).getDescrizione() %>" />
						<aui:input cssClass="input-small" disabled="true" id="lottoVenduto_${i}" inlineField="true" label="Lotto vendita" name="lottoVenduto_${i}" type="text" value="<%= prodotti.get(index).getLotto() %>" />
						<aui:input cssClass="input-large" disabled="true" id="kgVenduti_${i}" inlineField="true" label="Kg venduti" name="kgVenduti_${i}" type="text" value="<%= prodotti.get(index).getPesoNetto() %>" />
						<fieldset title="Prodotto venduto ${i}">

							<%
								List<TracciabilitaGrezzi> listGrezzi = grezzi.get(prodotti.get(index).getCodiceArticolo());
//                                boolean flag = listGrezzi.size() > 0;
								int size = 0;
								if (listGrezzi != null) {
									size=listGrezzi.size();
// 								} else {
// 									System.out.println("*** SONO IN ELSE PER: INDEX=" + index + " CODICE Art: " + prodotti.get(index).getCodiceArticolo());
								}
								int x = 0;
							%>

							<c:forEach begin="1" end="3" var="j">
								<div style="padding-left: 5%">
									<aui:input cssClass="input-large"    id="idGrezzo_${i}_${j}" inlineField="true" label="" name="idGrezzo_${i}_${j}" style="display: none" type="text" value="<%= (x < size) ? listGrezzi.get(x).getId() : -1  %>" />
									<aui:input cssClass="input-large"    id="lottoGrezzo_${i}_${j}" inlineField="true" label="Lotto grezzo" name="lottoGrezzo_${i}_${j}" type="text" value='<%= (x < size) ? listGrezzi.get(x).getLottoGrezzo() : ""  %>' >
										<aui:validator name="maxLength">15</aui:validator>
									</aui:input>
									<aui:input cssClass="input-xxlarge" id="prodotto_${i}_${j}" inlineField="true" label="Prodotto utilizzato" name="prodotto_${i}_${j}" type="text" value='<%= (x < size) ? listGrezzi.get(x).getProdotto() : ""  %>' />
									<aui:input cssClass="input-small" id="kg_${i}_${j}" inlineField="true" label="Kg utilizzati" name="kg_${i}_${j}" type="text" value="<%= (x < size) ? listGrezzi.get(x).getKg() : 0.0 %>">
										<aui:validator name="required"></aui:validator>
										<aui:validator name="number"></aui:validator>
									</aui:input>
									<aui:input cssClass="input-xxlarge" id="produttore_${i}_${j}" inlineField="true" label="Produttore" name="produttore_${i}_${j}" type="text" value='<%= (x < size) ? listGrezzi.get(x).getProduttore() : ""  %>'/>
									<aui:input cssClass="input-small" id="foglio_${i}_${j}" inlineField="true" label="Foglio" name="foglio_${i}_${j}" type="text" value="<%= (x < size) ? listGrezzi.get(x).getFoglio() : 0 %>">
										<aui:validator name="number"></aui:validator>
									</aui:input>
									<aui:input cssClass="input-small" id="particella_${i}_${j}" inlineField="true" label="Particella" name="particella_${i}_${j}" type="text" value="<%= (x < size) ? listGrezzi.get(x).getParticella(): 0 %>">
										<aui:validator name="number"></aui:validator>
									</aui:input>
									<aui:input cssClass="input-xxlarge" id="note_${i}_${j}" inlineField="true" label="Note" name="note_${i}_${j}" type="textarea" value='<%= (x < size) ? listGrezzi.get(x).getNote() : ""  %>' />
									<aui:input cssClass="input-small" id="colli_${i}_${j}" inlineField="true" label="N. colli" name="colli_${i}_${j}" type="text" value="<%= (x < size) ? listGrezzi.get(x).getNumeroColli() : 0 %>">
										<aui:validator name="number"></aui:validator>
									</aui:input>
									<aui:input cssClass="input-small" id="kg_scarto_${i}_${j}" inlineField="true" label="Kg scarto" name="kg_scarto_${i}_${j}" type="text" value="<%= (x < size) ? listGrezzi.get(x).getKgScarto() : 0 %>">
										<aui:validator name="number"></aui:validator>
									</aui:input>
								</div>
								<hr/>
								<% x++; %>
							</c:forEach>
						</fieldset>
					</liferay-ui:panel>
				</liferay-ui:panel-container>
				<% index++; %>
			</c:forEach>
		</aui:form>
	</fieldset>
</div>
<script type="text/javascript">

	var index = <%= index %>;

	YUI().use('node', function(Y) {
		Y.one('#btnSave').on('click', function() {
			var scheda = '{"scheda":[';
			for (var i = 1; i <= index; i++) {
				scheda += '{"idScheda"      : "' + Y.one("#<portlet:namespace/>idScheda_" + i).get('value') + '",' +
						'"codiceProdotto"   : "' + Y.one("#<portlet:namespace/>codiceProdotto_" + i).get('value') + '",' +
						'"prodottoVenduto"  : "' + Y.one("#<portlet:namespace/>prodottoVenduto_" + i).get('value') + '",' +
						'"numeroDocumento"  : "' + Y.one("#<portlet:namespace/>nDoc").get('value') + '",' +
						'"rigoOrdine"       : "' + Y.one("#<portlet:namespace/>rigoOrdine_" + i).get('value') + '",' +
						'"lottoVendita"     : "' + Y.one("#<portlet:namespace/>lottoVenduto_" + i).get('value') + '",' +
						'"kgVenduti"        : "' + Y.one("#<portlet:namespace/>kgVenduti_" + i).get('value') + '",' +
						'"grezzi"           : [';
				var sum = 0;
				var descrizione = Y.one("#<portlet:namespace/>prodottoVenduto_" + i).get('value');
				for (var j = 1; j <= 3; j++) {
					var field = Y.one("#<portlet:namespace/>kg_" + i + "_" + j).get('value');
					if (field !== "0.0") {
						sum += parseFloat(field);
						scheda += (j === 1) ? '' : ',';
						scheda += '{"idGrezzo" : "' + Y.one("#<portlet:namespace/>idGrezzo_" + i + "_" + j).get('value') + '",' +
								'"lottoGrezzo" : "' + Y.one("#<portlet:namespace/>lottoGrezzo_" + i + "_" + j).get('value') + '",' +
								'"prodotto"    :   "' + Y.one("#<portlet:namespace/>prodotto_" + i + "_" + j).get('value') + '",' +
								'"kg"          :   "' + Y.one("#<portlet:namespace/>kg_" + i + "_" + j).get('value') + '",' +
								'"produttore"  :   "' + Y.one("#<portlet:namespace/>produttore_" + i + "_" + j).get('value') + '",' +
								'"foglio"      :   "' + Y.one("#<portlet:namespace/>foglio_" + i + "_" + j).get('value') + '",' +
								'"particella"  :   "' + Y.one("#<portlet:namespace/>particella_" + i + "_" + j).get('value') + '",' +
								'"note"     :   "' + Y.one("#<portlet:namespace/>note_" + i + "_" + j).get('value') + '",' +
								'"colli"     :   "' + Y.one("#<portlet:namespace/>colli_" + i + "_" + j).get('value') + '",' +
								'"kg_scarto"   :   "' + Y.one("#<portlet:namespace/>kg_scarto_" + i + "_" + j).get('value') + '"}';

					}
				}
				if (sum !== parseFloat(Y.one("#<portlet:namespace/>kgVenduti_" + i).get('value'))) {
					console.log("i: " + i + " descrizione: " + descrizione);
					console.log("sum: " + sum + " kgVenduti: " + parseFloat(Y.one("#<portlet:namespace/>kgVenduti_" + i).get('value')));
					alert("Verificare le quantita' di prodotto grezzo inserite per il prodotto: '" + descrizione + "'");
					return;
				}
				scheda += ']}';
				scheda += (i === index) ? '' : ',';
			}

			scheda += ']}';
			var JSONscheda = JSON.parse(scheda);
			console.log(JSONscheda);

			salvaScheda(JSONscheda);
		});
	});

	YUI().use('aui-io-request', 'node', function(Y) {
		Y.one('#btnPrint').on('click', function() {
			var nDoc = Y.one('#<portlet:namespace/>nDoc').val();
			var win = window.open('${printScheda}' + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />send=' + true, '_blank'); // + '&<portlet:namespace />update=' + false + + '&<portlet:namespace />send=' + true, '_blank');
			win.focus();
//                alert("PRINTING SCHEDA");
		});
	});

	function salvaScheda(data) {
		YUI().use('aui-io-request', 'node', function(Y) {
			var nDoc = Y.one('#<portlet:namespace/>nDoc').val();
			Y.io.request('${saveScheda}', {
				method: 'POST',
                data: {
                    <portlet:namespace />nDoc: nDoc,
                    <portlet:namespace />data: window.btoa(JSON.stringify(data))
                },
				on: {
					success: function() {
						var data = JSON.parse(this.get('responseData'));
						console.log(data);
						if (data.code === 0) {
							alert("Salvataggio effettuato con successo.");
							document.getElementById("btnPrint").disabled = false;
							document.getElementById("btnSave").disabled = true;
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
									alert("Attenzione, non e' stato possibile invare la mail di notifica.\n");
									break;
								case 5:
									alert("Attenzione, il numero di protocollo: " + data.id + " e' gia' presente in archivio.\n");
									break;
								case 6:
									alert("Attenzione, esiste almeno un numero di protocollo maggiore di " + data.id + " con una data precedente a: " + orderDate + ".");
									break;
							}
						}
					}
				}
			});
		});
	}

</script>