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
%>

<portlet:resourceURL var="saveInvoice"  id="saveInvoice"  />
<portlet:resourceURL var="printInvoice" id="printInvoice" />
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
    <aui:input id="documentDate"    type="text" name="documentDate"   label="Data Documento" inlineField="true" />
</aui:fieldset>

<aui:fieldset label="Corpo Fattura">
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

            var retiCheckbox = new Y.RadioCellEditor({
                //                    editable: true,
                options: {
                    si: 'Si',
                    no: 'No'
                }
            });

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
                    editor: nameEditor,
                    key: 'lotto',
                    label: 'Lotto'
                },
                {
                    key: 'quantita',
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
                    editor: numberEditor,
                    key: 'importo',
                    label: 'Importo'
                }
            ];

            //        var data = [{}];
            table = new Y.DataTable({
                columns: columns,
                //            data: data,
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
        });
</script>

