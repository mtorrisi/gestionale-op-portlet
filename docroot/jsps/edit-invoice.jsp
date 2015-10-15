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
    String indirizzoCompleto;
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(renderRequest.getRemoteUser()));
    String origDoc  = ParamUtil.getString(renderRequest, "numeroDocumento", "");
    String origDocs = ParamUtil.getString(renderRequest, "documentIds", "");

    if (ParamUtil.getLong(renderRequest, "numeroDocumento", -1) != -1) {

        testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), ParamUtil.getLong(renderRequest, "numeroDocumento", -1), "DDT", a.getId()));
        cliente = AnagraficaLocalServiceUtil.getAnagrafica(testata.getCodiceSoggetto());
        indirizzoCompleto = cliente.getIndirizzo() + " - " + cliente.getCap() + ", " + cliente.getComune() + " (" + cliente.getProvincia() + ") - " + cliente.getStato();

        List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(testata.getNumeroOrdine(), testata.getAnno(), a.getId());

        for (RigoDocumento rigo : righe) {
            JSONObject json = JSONFactoryUtil.createJSONObject();
            json.put("codiceArticolo", rigo.getCodiceArticolo());
            json.put("descrizione", rigo.getDescrizione());
            json.put("descrizioneVariante", rigo.getDescrizioneVariante());
            json.put("imballo", rigo.getImballo());
            json.put("lotto", rigo.getLotto());
            json.put("unitaMisura", rigo.getUnitaMisura());
            json.put("colli", rigo.getColli());
            json.put("pesoLordo", rigo.getPesoLordo());
            json.put("pesoNetto", rigo.getPesoNetto());
            json.put("prezzo", rigo.getPrezzo());
            json.put("importo", rigo.getPrezzo() * rigo.getPesoNetto());

            jsonArr.put(json);
        }
    } else {
        String[] ids = StringUtil.split(ParamUtil.getString(renderRequest, "documentIds"));

        testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), Long.parseLong(ids[0]), "DDT", a.getId()));
        for (int i = 0; i < ids.length; i++) {
            listTestata.add(TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), Long.parseLong(ids[i]), "DDT", a.getId())));
        }

        cliente = AnagraficaLocalServiceUtil.getAnagrafica(listTestata.get(0).getCodiceSoggetto());
        indirizzoCompleto = cliente.getIndirizzo() + " - " + cliente.getCap() + ", " + cliente.getComune() + " (" + cliente.getProvincia() + ") - " + cliente.getStato();
        List<RigoDocumento> righeDocumenti = new ArrayList<RigoDocumento>();
        for (String id : ids) {
            List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(Long.parseLong(id), ParamUtil.getInteger(renderRequest, "anno"), a.getId());
            righeDocumenti.addAll(righe);
        }

        long oldDocument = -1;
        for (RigoDocumento rigo : righeDocumenti) {
            int i = 0;
            JSONObject json = JSONFactoryUtil.createJSONObject();
            if (oldDocument != rigo.getNumeroOrdine()) {
                json.put("descrizione", "Documento di trasporto N. " + rigo.getNumeroOrdine() + "/" + a.getCentro() + " del " + listTestata.get(i).getDataOrdine());
                jsonArr.put(json);
                json = json = JSONFactoryUtil.createJSONObject();
                oldDocument = rigo.getNumeroOrdine();
            }
            json.put("codiceArticolo", rigo.getCodiceArticolo());
            json.put("descrizione", rigo.getDescrizione());
            json.put("descrizioneVariante", rigo.getDescrizioneVariante());
            json.put("imballo", rigo.getImballo());
            json.put("lotto", rigo.getLotto());
            json.put("unitaMisura", rigo.getUnitaMisura());
            json.put("colli", rigo.getColli());
            json.put("pesoLordo", rigo.getPesoLordo());
            json.put("pesoNetto", rigo.getPesoNetto());
            json.put("prezzo", rigo.getPrezzo());
            json.put("importo", rigo.getPrezzo() * rigo.getPesoNetto());

            jsonArr.put(json);
            i++;
        }

    }

    List<Progressivo> listProgressivo = ProgressivoLocalServiceUtil.getByAnnoIdAssociatoTipoDocumento(Calendar.getInstance().get(Calendar.YEAR), a.getId(), 2);

    ArrayList<Integer> idToRecover = new ArrayList<Integer>();

    for (Progressivo p : listProgressivo) {
        idToRecover.add(p.getNumeroProgressivo());
    }
%>

<liferay-portlet:resourceURL var="saveInvoice"  id="generateInvoice" >
    <liferay-portlet:param name="numeroDocumento" value="<%= origDoc%>" />
    <liferay-portlet:param name="documentIds" value="<%= origDocs%>" />
</liferay-portlet:resourceURL>
<portlet:resourceURL var="printInvoice" id="printInvoice" />
<liferay-portlet:renderURL var="descrURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectDescription.jsp" />
</liferay-portlet:renderURL>
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <button id="btnInvoice" class="btn" onclick="saveInvoice()"><i class="icon-list-alt"></i>Genera Fattura</button>
            <button id="btnPrint"   class="btn" disabled="true"><i class="icon-print"></i>Stampa</button>
        </div>
    </div>  
</aui:field-wrapper>

<aui:fieldset label="Testata Fattura">
    <aui:layout>
        <aui:column columnWidth="70" cssClass="detail-column detail-column-first">
            <aui:input id="codiceClienteTxt" type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
            <aui:input id="clienteTxt" type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=cliente.getRagioneSociale()%>"/>
            <aui:input id="destinazioneTxt" type="text" name="destinazione" label="Destinazione diversa" cssClass="input-xxlarge" value="<%=indirizzoCompleto%>" inlineField="true"/>
            <aui:input id="codiceDestinazione" type="text" name="codiceDest" label="" inlineField="true" style="display: none" value="<%= testata.getCodiceDestinazione()%>" />    
            <aui:input id="documentDate"    type="text" name="documentDate"   label="Data Documento" inlineField="true" value="<%= testata.getDataOrdine()%>"/>
        </aui:column>
        <aui:column columnWidth="20" cssClass="test" last="true" >
            <%--aui:field-wrapper label="Ordine Finito"  >
                <aui:input type="radio" name="completoSi" label="Si" inlineLabel="true" checked="true" inlineField="true"/>
                <aui:input type="radio" name="completoNo" label="No" inlineLabel="true" inlineField="true"/>
            </aui:field-wrapper--%>

            <aui:input type="text" name="nDoc" label="N. Documento" style="width: 90%" />
            <aui:select label="Rec Protocollo" name="recProt" style="width: 90%; background-color: #FFFFCC;"> 
                <c:forEach items="<%= idToRecover%>" var="id">
                    <aui:option value="${id}">
                        ${id}
                    </aui:option>
                </c:forEach>
            </aui:select>
        </aui:column>
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
                <aui:input id="totaleImponibileTxt" type="text" name="totImponibile" label="Totale imponiible" disabled="true" inlineField="true"/>
                <aui:input id="totaleIVATxt" type="text" name="totIVA" label="Totale IVA" disabled="true" inlineField="true"/>
                <aui:input id="totaleDocumentoTxt" type="text" name="totDocumento" label="Totale documento" disabled="true" inlineField="true"/>
            </aui:fieldset>
        </div>
    </div>
</div>


<script type="text/javascript">
//        window.onbeforeunload = function () {
//            return "";
//        };

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
                                        deliveryDate.clearSelection();
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
                key: 'descrizioneVariante',
                label: 'Variante'
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
                label: 'Peso Lordo'
            },
            {
                key: 'pesoNetto',
                label: 'Quantità'
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
        //        table.delegate("click", function (e) {
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
        //        table.delegate('click', function (e) {
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

        table.delegate('click', function (e) {
            recordSelected = table.getRecord(e.currentTarget);
        }, 'tr', table);
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
            console.log(recordSelected);
            table.removeRow(recordSelected);
            recordSelected = "";
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
        iva = imponibile * 0.04;
        totaledocumento = imponibile + iva;

        document.getElementById('<portlet:namespace />totaleImponibileTxt').value = imponibile.toFixed(2);
        document.getElementById('<portlet:namespace />totaleIVATxt').value = iva.toFixed(2);
        document.getElementById('<portlet:namespace />totaleDocumentoTxt').value = totaledocumento.toFixed(2);
    }

    function setDescription(data) {

        console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({descrizione: data});
            recordSelected = undefined;
        } else {
            table.addRow({descrizione: data}, {sync: true});
        }
    }

    function saveInvoice() {
        var rows = [];
        var ok = true;
        for (var i = 0; i < table.data.size(); i++) {
            if (table.data.item(i).toJSON().pesoLordo !== 0)
                if (table.data.item(i).toJSON().importo === 0) {
                    ok = false;
                    break;
                }
            rows[i] = table.data.item(i).toJSON();
        }
        console.log(rows);
        if (rows.length !== 0 && ok)
            sendData(rows);
        else
            alert("Attenzione non è possibile generare la fattura.\nVerificare di aver inserito i prezzi per tutti gli articoli.");
    }

    function sendData(rows) {
        YUI().use('aui-io-request', 'node', function (Y) {

            /******CAMPI TESTATA******/
            var codiceCliente = Y.one('#<portlet:namespace />codiceClienteTxt').val();
            var clienteTxt = Y.one('#<portlet:namespace />clienteTxt').val();
            var destinazioneTxt = Y.one('#<portlet:namespace />destinazioneTxt').val();
            var codiceDestinazione = Y.one('#<portlet:namespace />codiceDestinazione').val();
            var documentDate = Y.one('#<portlet:namespace />documentDate').val();
            var numeroFattura = Y.one('#<portlet:namespace/>recProt').val();

            /******CAMPI FINE CORPO******/
//            var vettore1 = Y.one('#codiceVettore1').val();
//            var vettore2 = Y.one('#codiceVettore1').val();
//            var autista = Y.one('#autista').val();
//            var telefono = Y.one('#telefono').val();
//            var trasporto = Y.one('#trasporto').val();
//            var aspetto = Y.one('#aspetto').val();
//            var causale = Y.one('#causale').val();
//            var porto = Y.one('#porto').val();
//            var origine = Y.one('#origine').val();
//            var rigo = Y.one('#rigo').val();
//            var costo = Y.one('#costo').val();
//            var pedane_euro = Y.one('#pedane-euro').val();
//            var pedane_normali = Y.one('#pedane-normali').val();
//            var motrice = Y.one('#motrice').val();
//            var rimorchio = Y.one('#rimorchio').val();
//            var numeroOrdine = Y.one('#<portlet:namespace/>recProt').val();

            var queryString = "&<portlet:namespace/>codiceCliente=" + codiceCliente +
                    "&<portlet:namespace/>clienteTxt=" + clienteTxt + "&<portlet:namespace/>destinazioneTxt=" + destinazioneTxt +
                    "&<portlet:namespace/>codiceDestinazione=" + codiceDestinazione + "&<portlet:namespace/>documentDate=" + documentDate +
                    "&<portlet:namespace/>numeroFattura=" + numeroFattura;
            //        Y.one('#btnSave').on('click', function () {
            Y.io.request(
                    '${saveInvoice}' + queryString + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(rows)),
                    {
                        on: {
                            success: function () {
                                var data = JSON.parse(this.get('responseData'));
                                if (data.code === 0) {
                                    alert("Salvataggio effettuato con successo.");
                                    Y.one('#<portlet:namespace/>nDoc').set('value', data.id);
                                    document.getElementById("btnPrint").disabled = false;
                                    document.getElementById("btnInvoice").disabled = true;
                                    if (Y.one('#<portlet:namespace/>recProt').val() !== "") {
//                                            console.log("1: " + Y.one('#<portlet:namespace/>recProt').val());
                                        document.getElementById('<portlet:namespace/>recProt').value = "";
                                    }
                                } else {
                                    alert("Errore durante il salvataggio dei dati: " + data);
                                }
                            }
                        }
                    }
            );

        });
    }
    
    YUI().use('aui-io-request', 'node', function (Y) {
            Y.one('#btnPrint').on('click', function () {
                var nDoc = Y.one('#<portlet:namespace/>nDoc').val();

                var win = window.open('${printInvoice}' + '&<portlet:namespace />nDoc=' + nDoc, '_blank');
                win.focus();

            });
        });

</script>

