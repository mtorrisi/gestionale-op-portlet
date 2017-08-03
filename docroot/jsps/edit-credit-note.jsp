<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.model.UserIdMapper" %>
<%@ page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil" %>

<%@ page import="it.bysoftware.ct.model.Anagrafica" %>
<%@ page import="it.bysoftware.ct.model.Articoli" %>
<%@ page import="it.bysoftware.ct.model.Associato" %>
<%@ page import="it.bysoftware.ct.model.ClientiDatiAgg" %>
<%@ page import="it.bysoftware.ct.model.DescrizioniDocumenti" %>
<%@ page import="it.bysoftware.ct.model.Progressivo" %>
<%@ page import="it.bysoftware.ct.model.RigoDocumento" %>
<%@ page import="it.bysoftware.ct.model.TestataDocumento" %>
<%@ page import="it.bysoftware.ct.model.VociIva" %>
<%@ page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.ArticoliLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.ProgressivoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.VociIvaLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.persistence.ClientiDatiAggPK" %>
<%@ page import="it.bysoftware.ct.service.persistence.TestataDocumentoPK" %>

<%@ page import="it.its.ct.gestionaleOP.utils.Constants" %>
<%@ page import="it.its.ct.gestionaleOP.utils.DocumentType" %>

<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
	String origDoc = ParamUtil.getString(renderRequest, "numeroDocumento", "");
	UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(Long.parseLong(renderRequest.getRemoteUser()), Constants.FUTURO_NET);
	Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper.getUserIdMapperId());
	Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
	ClientiDatiAgg datiAggCliente = ClientiDatiAggLocalServiceUtil.fetchClientiDatiAgg(new ClientiDatiAggPK(cliente.getCodiceAnagrafica(), false));
	String indirizzoCompleto = cliente.getIndirizzo() + " - " + cliente.getCap() + ", " + cliente.getComune() + " (" + cliente.getProvincia() + ") - " + cliente.getStato();
	TestataDocumento testata = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), ParamUtil.getLong(renderRequest, "numeroDocumento", -1), DocumentType.NAC.name(), a.getId()));
	double totale = 0.0;
	String codiceAliquotaIva = ""; //datiAggCliente.getCodiceAliquota();
	if (testata != null) {
		List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getNACByNumeroOrdineAnnoAssociato(testata.getNumeroOrdine(), testata.getAnno(), a.getId(), DocumentType.NAC.name());
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
	            if (rigo.getPesoNetto() != 0) {
	                if (!datiAggCliente.getCodiceAliquota().isEmpty()) {
	                    codiceAliquotaIva = datiAggCliente.getCodiceAliquota();
	                } else {
	                    Articoli articolo = ArticoliLocalServiceUtil.getArticoli(rigo.getCodiceArticolo());
	                    if (articolo != null) {
	                        codiceAliquotaIva = articolo.getCodiceIVA();
	                    } else {
	                        codiceAliquotaIva = "04";
	                    }
	                }
	            } else {
	                DescrizioniDocumenti descr = DescrizioniDocumentiLocalServiceUtil.fetchDescrizioniDocumenti(rigo.getCodiceArticolo());
	                if (descr != null) {
	                    codiceAliquotaIva = descr.getCodiceIVA();
	                }
	            }
	        }
	        json.put("codiceIva", codiceAliquotaIva);

	        double importo = 0;

	        double sconto1 = rigo.getSconto1();
	        double sconto2 = rigo.getSconto2();
	        double sconto3 = rigo.getSconto3();

	        double importo1, importo2 = 0;
	        double tmpImporto = 0;

	        if (rigo.getPesoNetto() != 0) {
	        	tmpImporto = rigo.getPrezzo() * rigo.getPesoNetto();
	        } else {
	        	tmpImporto = rigo.getPrezzo();
	        }

	        importo1 = tmpImporto - ((tmpImporto * sconto1) / 100);
	        importo2 = importo1 - ((importo1 * sconto2) / 100);
	        importo = importo2 - ((importo2 * sconto3) / 100);
	        importo = Math.round(importo * 100);
	        totale += importo;
	        json.put("importo", importo / 100);

	        jsonArr.put(json);
	    }
	}

	List<Progressivo> listProgressivo = ProgressivoLocalServiceUtil.getByAnnoIdAssociatoTipoDocumento(Calendar.getInstance().get(Calendar.YEAR), a.getId(), Constants.NOTE_ID);

	ArrayList<Integer> idToRecover = new ArrayList<Integer>();
	for (Progressivo p : listProgressivo) {
		idToRecover.add(p.getNumeroProgressivo());
	}

	Date date = Calendar.getInstance().getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	VociIva iva;
	if (!codiceAliquotaIva.equals("")) {
		iva = VociIvaLocalServiceUtil.fetchVociIva(codiceAliquotaIva);
	} else {
		iva = VociIvaLocalServiceUtil.fetchVociIva("04");
	}
%>

<liferay-portlet:resourceURL id="updateCreditNote"  var="updateCreditNote">
<%-- <liferay-portlet:param name="numeroDocumento" value="<%= origDoc%>" /> --%>
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="saveCreditNote"  var="saveCreditNote">
<%-- <liferay-portlet:param name="documentIds" value="<%= origDocs%>" /> --%>
</liferay-portlet:resourceURL>
<portlet:resourceURL id="printCreditNote" var="printCreditNote" />
<liferay-portlet:renderURL var="searchCreditNoteURL">
	<liferay-portlet:param name="codiceCliente"  value="<%= cliente.getCodiceAnagrafica() %>" />
	<liferay-portlet:param name="jspPage"  value="/jsps/search-creditNote.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="descrURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<liferay-portlet:param name="mvcPath" value="/jsps/selectDescription.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="itemURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<liferay-portlet:param name="mvcPath" value="/jsps/selectItem.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="packingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<liferay-portlet:param name="mvcPath" value="/jsps/selectPack.jsp" />
</liferay-portlet:renderURL>

<div class="yui3-skin-sam">
	<div id="modal"></div>
</div>

<aui:field-wrapper >
	<div class="btn-toolbar">
		<div class="btn-group">
			<button class="btn" id="btnSearch"><i class="icon-search"></i>Cerca</button>
			<c:choose>
				<c:when test='<%= origDoc.equals("") %>'>
<!-- <button id="btnCreditNote" class="btn" onclick="saveCreditNote()"><i class="icon-save"></i>Salva</button> -->
					<button class="btn" id="btnCreditNote"><i class="icon-save"></i>Salva</button>
				</c:when>
				<c:when test='<%= !origDoc.equals("") %>'>
<%-- <button id="btnCreditNote" class="btn" onclick="saveCreditNote(<%= origDoc%>)"><i class="icon-save"></i>Salva Modifiche</button> --%>
					<button class="btn" id="btnCreditNote"><i class="icon-save"></i>Salva Modifiche</button>
				</c:when>
			</c:choose>
			<button class="btn"   id="btnPrint" <%= origDoc.equals("") ? "disabled=\"true\"" : "" %>><i class="icon-print"></i>Stampa</button>
		</div>
	</div>
</aui:field-wrapper>

<aui:fieldset label="Testata Nota di Credito">
	<aui:layout>
		<aui:column columnWidth="80" cssClass="detail-column detail-column-first">
			<aui:input cssClass="input-small" disabled="true" id="codiceClienteTxt" inlineField="true" label="Codice Cliente" name="codCliente" type="text" value="<%= cliente.getCodiceAnagrafica() %>" />
			<aui:input cssClass="input-xxlarge" id="clienteTxt" inlineField="true" label="Cliente" name="cliente" type="text" value="<%= cliente.getRagioneSociale() %>" />
			<aui:input cssClass="input-xxlarge" id="destinazioneTxt" inlineField="true" label="Destinazione" name="destinazione" type="text" value="<%= indirizzoCompleto %>" />
			<aui:input id="codiceDestinazione" inlineField="true" label="" name="codiceDest" style="display: none" type="text" value='<%= (testata != null) ? testata.getCodiceDestinazione() : "" %>' />
			<aui:input id="documentDate" inlineField="true" label="Data Documento" name="documentDate" type="text" value='<%= origDoc.equals("") ? sdf.format(date) : (testata != null) ? testata.getDataOrdine() : "" %>'/>
		</aui:column>
		<aui:column columnWidth="20" cssClass="test">
			<aui:fieldset label="Nota di credito">
	            <aui:input type="text" name="nDoc" label="N. Documento" value="<%= origDoc %>">
	            	<aui:validator name="digits"></aui:validator>
	            </aui:input>
	            <aui:select label="Rec Protocollo" name="recProt" style="background-color: #FFFFCC;">
	                <c:forEach items="<%= idToRecover %>" var="id">
	                    <aui:option value="${id}">
	                        ${id}
	                    </aui:option>
	                </c:forEach>
	            </aui:select>
			</aui:fieldset>
		</aui:column>
	</aui:layout>
</aui:fieldset>
<div id="myTab">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab-1">Corpo Nota di Credito</a></li>
		<li><a href="#tab-2">Totali</a></li>
	</ul>

	<div class="tab-content">
		<div class="tab-pane" id="tab-1">
			<aui:fieldset label="Corpo Nota di credito">
				<aui:field-wrapper >
					<div class="btn-toolbar">
						<div class="btn-group">
							<aui:a cssClass="btn" href="#a" id="btnAdd"><i class="icon-plus"></i>Aggiungi Articolo</aui:a>
							<aui:a cssClass="btn" href="#a" id="btnAddDescription"><i class="icon-plus"></i>Aggiungi Descrizione</aui:a>
							<aui:a cssClass="btn" href="#a" id="btnRemove"><i class="icon-trash"></i>Rimuovi</aui:a>
							</div>
						</div>
				</aui:field-wrapper>
				<aui:fieldset id="myDataTable" />
			</aui:fieldset>
		</div>
		<div id="tab-2">
			<aui:fieldset label="Totali Nota di Credito">
				<aui:input disabled="true" id="totaleImponibileTxt" inlineField="true" label="Totale imponiible" name="totImponibile" type="text" />
				<aui:input disabled="true" id="aliquotaTxt" inlineField="true" label="Aliquota" name="aliquota" type="text" value='<%= String.valueOf(iva.getAliquota()) + "%" %>'/>
				<aui:input disabled="true" id="totaleIVATxt" inlineField="true" label="Totale IVA" name="totIVA" type="text" />
				<aui:input disabled="true" id="totaleDocumentoTxt" inlineField="true" label="Totale documento" name="totDocumento" type="text" value="<%= totale %>" />
			</aui:fieldset>
		</div>
	</div>
</div>

<script type="text/javascript">
//        window.onbeforeunload = function() {
//            return "";
//        };

	var origDoc = '<%= origDoc %>';
	var aliquotaIVA = <%= iva.getAliquota() %>;
	var codiceAliquota = <%= iva.getCodiceIva() %>;

	YUI().use(
			'aui-tabview',
			function(Y) {
				new Y.TabView(
						{
							srcNode: '#myTab'
						}
				).render();
			}
	);

	YUI({lang: 'it'}).use('aui-datepicker', 'aui-modal', function(Y) {

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
									click: function() {
										documentDate.clearSelection();
									}
								}
							}
						]]
				},
				zIndex: 1
			},
			on: {
				selectionChange: function(event) {
					console.log(event.newSelection);
				}
			}
		});

	});

	var recordSelected;
	var table;

	YUI({lang: 'it'}).use('aui-datatable', 'aui-datatype', 'datatable-sort', 'datatable-mutable', function(Y) {

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

		var data = <%= jsonArr %>;
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
			//                label: '<input type="checkbox" class="protocol-select-all" title="Seleziona tutti" />',
			//                formatter: '<input type="checkbox" checked/>',
			//                emptyCellValue: '<input type="checkbox" />'
			//            },
			{
				//                allowHTML: true,
				key: 'codiceArticolo',
				label: 'Codice',
				width: '30px'
						//                emptyCellValue: '<button class="selectArt"><i class="icon-hdd"></i>Seleziona</button>'
			},
			{
				editor: nameEditor,
				key: 'descrizione',
				label: 'Descrizione Articolo'
			},
			{
				key: 'codiceVariante',
				label: 'Cod. Var.'
			},
			{
				key: 'descrizioneVariante',
				label: 'Varieta\''
			},
			{
				allowHTML: true,
				key: 'imballo',
				label: 'Imballo',
				emptyCellValue: '<button id="selectPack">Seleziona Imballo</button>'
			},
			{
			   	editor: nameEditor,
				key: 'lotto',
				label: 'Lotto'
			},
			{
				key: 'unitaMisura',
				label: 'U.M.'
			},
			{
				editor: numberEditor,
				key: 'colli',
				label: 'Colli'
			},
			{
				editor: numberEditor,
				key: 'pesoLordo',
				label: 'Peso Lordo'
			},
			{
				editor: numberEditor,
				key: 'pesoNetto',
				label: 'Quantita\''
			},
			{
				editor: numberEditor,
				key: 'prezzo',
				label: 'Prezzo'
			},
			{
				editor: numberEditor,
				key: 'sconto1',
				label: 'Sconto1'
			},
			{
				editor: numberEditor,
				key: 'sconto2',
				label: 'Sconto2'
			},
			{
				editor: numberEditor,
				key: 'sconto3',
				label: 'Sconto3'
			},
			{
//                editor: numberEditor,
				key: 'importo',
				label: 'Importo'
			},
			{
//                editor: numberEditor,
				key: 'codiceIva',
				label: 'C.I.'
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

		calcolaImporti();
		//
		//        // To avoid checkbox click causing harmless error in sorting
		//        // Workaround for bug #2532244
		//        table.detach('*:change');
		//
		//        //----------------
		//        //   "checkbox" Click listeners ...
		//        //----------------
		//
		//        // Define a listener on the DT first column for each record's "checkbox",
		//        //   to set the value of `select` to the checkbox setting
		//        table.delegate("click", function(e) {
		//            console.log("1");
		//            // undefined to trigger the emptyCellValue
		//            var checked = e.target.get('checked') || undefined;
		//
		//            // Don't pass `{silent:true}` if there are other objects in your app
		//            // that need to be notified of the checkbox change.
		//            this.getRecord(e.target).set('select', checked, {silent: true});
		//
		//            // Uncheck the header checkbox
		//            this.get('contentBox')
		//                    .one('.protocol-select-all').set('checked', false);
		//        }, ".yui3-datatable-data .yui3-datatable-col-select input", table);
		//
		//
		//        // Also define a listener on the single TH "checkbox" to
		//        //   toggle all of the checkboxes
		//        table.delegate('click', function(e) {
		//            console.log("2");
		//            // undefined to trigger the emptyCellValue
		//            var checked = e.target.get('checked') || undefined;
		//            console.log(e);
		//            // Set the selected attribute in all records in the ModelList silently
		//            // to avoid each update triggering a table update
		//            this.data.invoke('set', 'select', checked, {silent: true});
		//
		//            // Update the table now that all records have been updated
		//            this.syncUI();
		//        }, '.protocol-select-all', table);

		table.addAttr("selectedRow", {value: null});

		table.delegate('click', function(e) {
			recordSelected = table.getRecord(e.currentTarget);
		}, 'tr', table);
		table.after('render', function(e) {
	   		for (var i = 0; i < data.length; i++) {
					recordSelected = table.getRecord(i);
					calcolaSconto();
	   		}
		});
		table.delegate('click', function(e) {
			recordSelected = table.getRecord(e.currentTarget);
			Liferay.Util.openWindow({
				dialog: {
					centered: true,
					modal: true,
					resizable: true,
					draggable: true,
					//                    height: '600px',
					//                    width: '1024px'
				},
				id: '<portlet:namespace/>packDialog',
				title: 'Seleziona Imballaggio',
				uri: '<%= packingURL %>'
			});
		}, '#selectPack', table);
		table.after('*:pesoNettoChange', function(e) {
			calcolaSconto();
		});
		table.after('*:prezzoChange', function(e) {
			calcolaSconto();
		});
		table.after('*:sconto1Change', function(e) {
			calcolaSconto();
		});
		table.after('*:sconto2Change', function(e) {
			calcolaSconto();
		});
		table.after('*:sconto3Change', function(e) {
			calcolaSconto();
		});

		table.after('*:importoChange', function(e) {
			calcolaImporti();
		});

		Y.one("#<portlet:namespace />btnAddDescription").on("click", function() {
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
				uri: '<%= descrURL %>'
			});
		});

		Y.one("#<portlet:namespace />btnRemove").on("click", function() {
			console.log(recordSelected);
			var row = recordSelected.getAttrs();
			if (!row.codiceArticolo)
				table.removeRow(recordSelected);
			else if (row.prezzo !== 0)
				table.removeRow(recordSelected);
			else
				alert("Attenzione non e' possibile rimuovere un rigo con un prodotto.");
			recordSelected = "";
		});

		Y.one("#<portlet:namespace />btnAdd").on("click", function() {
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
				uri: '<%= itemURL %>'
			});
		});
	});

	Liferay.provide(window, 'closePopup', function(data, dialogId) {
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
			case '<portlet:namespace/>packDialog':
				setPack(data);
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
		var tmpImporto;
		if (!isNaN(record.pesoNetto) && record.pesoNetto !== 0)
			tmpImporto = record.prezzo * record.pesoNetto;
		else
			tmpImporto = record.prezzo

		importo1 = tmpImporto - ((tmpImporto * sconto1) / 100);
		importo2 = importo1 - ((importo1 * sconto2) / 100);
		importo = importo2 - ((importo2 * sconto3) / 100);

		recordSelected.setAttrs({importo: importo.toFixed(2)});

	}

	function calcolaImporti() {
		var imponibile = 0;
		var iva = 0;
		var totaledocumento = 0;

		for (var i = 0; i < table.data.size(); i++) {
			var importo = table.getRecord(i).getAttrs().importo;
			if (!isNaN(importo))
				imponibile += parseFloat(table.getRecord(i).getAttrs().importo);
			console.log(imponibile);
		}
		iva = imponibile * aliquotaIVA / 100;
		totaledocumento = imponibile + iva;

		document.getElementById('<portlet:namespace />totaleImponibileTxt').value = imponibile.toFixed(2);
		document.getElementById('<portlet:namespace />totaleIVATxt').value = iva.toFixed(2);
		document.getElementById('<portlet:namespace />totaleDocumentoTxt').value = totaledocumento.toFixed(2);
	}

	function setDescription(data) {

		console.log(recordSelected);
		var tmp = data.split('|');
		if (recordSelected) {
			recordSelected.setAttrs({descrizione: tmp[0], codiceArticolo: tmp[1], codiceIva: tmp[2]});
			recordSelected = undefined;
		} else {
			table.addRow({descrizione: tmp[0], codiceArticolo: tmp[1], codiceIva: tmp[2]}, {sync: true});
		}
	}

	function setItem(data) {
		var tmp = data.split('|');

		console.log(recordSelected);
		if (recordSelected) {
			recordSelected.setAttrs({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2]});
			recordSelected = undefined;
		} else {
			table.addRow({codiceArticolo: tmp[0], descrizione: tmp[1], unitaMisura: "Kg"}, {sync: true});
//            console.log("####: " + tmp[0] + " " + tmp[1] + " " + tmp[2]);
		}
	}

	function setPack(data) {
		if (recordSelected) {
			recordSelected.setAttrs({imballo: data});
			recordSelected = undefined;
		}
	}

	var modal;
	YUI().use("liferay-util-list-fields", function(Y) {

		Y.one('#btnCreditNote').on('click', function(event) {
			YUI().use('aui-modal', function(Y) {
				 	modal = new Y.Modal({
					id: 'loadingMask',
					bodyContent : '<div class="loading-animation" />',
					centered : true,
					headerContent : '<h3>Loading...</h3>',
					modal : true,
					render : '#modal',
					close: false,
					width : 450
				}).render();

				modal.after("render", function() {
					saveCreditNote(origDoc);
				})
			});

		});
	});

	function saveCreditNote(origDoc) {
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
		if (rows.length !== 0 && ok)
			sendData(rows, origDoc);
		else
			alert("Attenzione non e' possibile generare la nota di credito.\nVerificare di aver inserito i prezzi per tutti gli articoli.");

	}

	function sendData(rows, origDoc) {
		YUI().use('aui-io-request', 'node', function(Y) {

			/******CAMPI TESTATA******/
			var codiceCliente = Y.one('#<portlet:namespace />codiceClienteTxt').val();
			var clienteTxt = Y.one('#<portlet:namespace />clienteTxt').val();
			var destinazioneTxt = Y.one('#<portlet:namespace />destinazioneTxt').val();
			var codiceDestinazione = Y.one('#<portlet:namespace />codiceDestinazione').val();
			var documentDate = Y.one('#<portlet:namespace />documentDate').val();
			var numeroNota = Y.one('#<portlet:namespace/>recProt').val();
			var avanzaProtocollo = Y.one('#<portlet:namespace/>nDoc').val();

			var queryString = "&<portlet:namespace/>codiceCliente=" + codiceCliente +
					"&<portlet:namespace/>clienteTxt=" + clienteTxt + "&<portlet:namespace/>destinazioneTxt=" + destinazioneTxt +
					"&<portlet:namespace/>codiceDestinazione=" + codiceDestinazione + "&<portlet:namespace/>documentDate=" + documentDate +
					"&<portlet:namespace/>numeroNota=" + numeroNota + "&<portlet:namespace/>avanzaProtocollo=" + avanzaProtocollo;
			//        Y.one('#btnSave').on('click', function() {
			Y.io.request(((origDoc) ? '${updateCreditNote}' : '${saveCreditNote}') + queryString + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(rows)), {
				on: {
					success: function() {
						var data = JSON.parse(this.get('responseData'));
						if (data.code === 0) {
							alert("Salvataggio effettuato con successo.");
							Y.one('#<portlet:namespace/>nDoc').set('value', data.id);
							document.getElementById("btnPrint").disabled = false;
							document.getElementById("btnCreditNote").disabled = true;
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
									document.getElementById("btnCreditNote").disabled = true;
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
							}
						}
						if (modal)
							modal.hide();
					}
				}
			});

		});
	}

	YUI().use('aui-io-request', 'node', function(Y) {
		Y.one('#btnPrint').on('click', function() {
			var nDoc = Y.one('#<portlet:namespace/>nDoc').val();
			var codiceCliente = Y.one('#<portlet:namespace/>codiceClienteTxt').val();

			var win = window.open('${printCreditNote}' + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />codiceCliente=' + codiceCliente + '&<portlet:namespace />update=' + false + '&<portlet:namespace />send=' + true, '_blank');
			win.focus();

		});
	});

	var searchCreditNoteURL = "<%= searchCreditNoteURL %>";

	YUI().use('node', function(Y) {
		Y.one('#btnSearch').on('click', function() {
			window.location.href = searchCreditNoteURL;
		});
	});
</script>