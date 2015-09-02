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
    TestataDocumento testata = TestataDocumentoLocalServiceUtil.getTestataDocumento(new TestataDocumentoPK(ParamUtil.getInteger(renderRequest, "anno"), ParamUtil.getLong(renderRequest, "numeroDocumento")));
    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(testata.getCodiceSoggetto());
    String indirizzoCompleto = cliente.getIndirizzo() + " - " + cliente.getCap() + ", " + cliente.getComune() + " (" + cliente.getProvincia() + ") - " + cliente.getStato();

    List<RigoDocumento> righe = RigoDocumentoLocalServiceUtil.getByNumeroOrdineAnno(testata.getNumeroOrdine(), testata.getAnno());

    JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
    for (RigoDocumento rigo : righe) {
        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("codiceArticolo", rigo.getCodiceArticolo());
        json.put("descrizione", rigo.getDescrizione());
        json.put("lotto", rigo.getLotto());
        json.put("unitaMisura", rigo.getUnitaMisura());
        json.put("colli", rigo.getColli());
        json.put("quantita", rigo.getPesoNetto());
        json.put("prezzo", rigo.getPrezzo());
        json.put("importo", rigo.getPrezzo() * rigo.getPesoNetto());

        jsonArr.put(json);
    }


%>

<portlet:resourceURL var="saveInvoice"  id="saveInvoice"  />
<portlet:resourceURL var="printInvoice" id="printInvoice" />
<liferay-portlet:renderURL var="descrURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectDescription.jsp" />
</liferay-portlet:renderURL>
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <button id="btnSave"    class="btn" onclick="SalvaDDT()" ><i class="icon-hdd"></i>Salva</button>
            <button id="btnPrint"   class="btn" disabled="true"><i class="icon-print"></i>Stampa</button>
            <button id="btnInvoice" class="btn" disabled="true"><i class="icon-list-alt"></i>Genera Fattura</button>
        </div>
    </div>  
</aui:field-wrapper>

<aui:fieldset label="Testata Fattura">
    <aui:input id="codiceClienteTxt" type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
    <aui:input id="clienteTxt" type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=cliente.getRagioneSociale()%>"/>
    <aui:input id="destinazioneTxt" type="text" name="destinazione" label="Destinazione diversa" cssClass="input-xxlarge" value="<%=indirizzoCompleto%>" inlineField="true"/>
    <aui:input id="documentDate"    type="text" name="documentDate"   label="Data Documento" inlineField="true" value="<%= testata.getDataOrdine()%>"/>
</aui:fieldset>

<aui:fieldset label="Corpo Fattura">
    <aui:field-wrapper >
        <div class="btn-toolbar">
            <div class="btn-group">
                <%--<aui:a id="btnAdd" cssClass="btn" href="#a"><i class="icon-plus"></i>Aggiungi</aui:a>--%>
                <aui:a id="btnAddDescription" cssClass="btn" href="#a"><i class="icon-plus"></i>Aggiungi Descrizione</aui:a>
                <%--<aui:a id="btnRemove" cssClass="btn" href="#a"><i class="icon-trash"></i>Rimuovi</aui:a>--%>
            </div>
        </div>  
    </aui:field-wrapper>
    <aui:fieldset id="myDataTable" />
</aui:fieldset>

<script type="text/javascript">
//        window.onbeforeunload = function () {
//            return "";
//        };

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
                key: 'quantita',
                label: 'Quantità'
            },
            {
//                editor: numberEditor,
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

        table.after('*:sconto1Change', function (e) {
            calcola(e);
        });
        table.after('*:sconto2Change', function (e) {
            calcola(e);
        });
        table.after('*:sconto3Change', function (e) {

            calcola(e);
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

    function calcola(e) {

        var record = recordSelected.getAttrs();
        var importo = record.importo;
        var sconto1 = record.sconto1;
        var sconto2 = record.sconto2;
        var sconto3 = record.sconto3;
        var importo1 = 0;
        var importo2 = 0;
        var importo3 = 0;

        if (!isNaN(sconto1) && sconto1 !== 0) {
            importo1 = importo - ((importo * sconto1) / 100);
        } else {
            importo = record.prezzo * record.quantita;
            recordSelected.setAttrs({importo: importo});
            return;
        }

        if (!isNaN(sconto2) && sconto2 !== 0) {
            importo2 = importo1 - ((importo1 * sconto2) / 100);
        } else {
            recordSelected.setAttrs({importo: importo1});
            return;
        }

        if (!isNaN(sconto3 && sconto3 !== 0)) {
            importo3 = importo2 - ((importo2 * sconto3) / 100);
        } else {
            recordSelected.setAttrs({importo: importo2});
            return;
        }

        recordSelected.setAttrs({importo: importo3});
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

</script>

