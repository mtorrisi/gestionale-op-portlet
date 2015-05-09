<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.AnagraficaLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.DestinatariDiversiLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.model.DestinatariDiversi"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="../init.jsp" %>

<%
    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
    //    request.setAttribute("destinazioni", destinazioni);
%>

<liferay-portlet:renderURL var="popupURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/destinations.jsp" />
    <liferay-portlet:param name="codiceCliente" value="<%= cliente.getCodiceAnagrafica() %>" />
</liferay-portlet:renderURL>
<portlet:resourceURL var="saveDDT"  id="saveDDT"  />
<portlet:resourceURL var="printDDT" id="printDDT" />
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <button id="btnSave" class="btn"><i class="icon-hdd"></i>Salva</button>
            <button id="btnPrint" class="btn"><i class="icon-print"></i>Stampa</button>
        </div>
    </div>  
</aui:field-wrapper>

<aui:fieldset label="Compila DDT">
    <aui:layout>
        <aui:column columnWidth="70" cssClass="detail-column detail-column-first">
            <aui:input type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
            <aui:input type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=cliente.getRagioneSociale()%>"/>
            <aui:input id="destinazioneTxt" type="text" name="destinazione" label="Destinazione diversa" cssClass="input-xxlarge" value="<%=cliente.getIndirizzo()%>" inlineField="true"/>
            <aui:input id="orderDate"    type="text" name="dataOrdine"   label="Data Ordine"     inlineField="true" />
            <aui:input id="deliveryDate" type="text" name="dataConsegna" label="Data Consegna"   inlineField="true" />

            <%--aui:input type="text" name="totPedane"    label="Tot. Pedane"     inlineField="true" cssClass="input-small"/>
            <aui:input type="text" name="Tot. Pesate"  label="Tot. Pesate"     inlineField="true" cssClass="input-small" /--%>
        </aui:column>
        <aui:column columnWidth="20" cssClass="test" last="true" >
            <aui:field-wrapper label="Ordine Finito"  >
                <aui:input type="radio" name="completoSi" label="Si" inlineLabel="true" checked="true" inlineField="true"/>
                <aui:input type="radio" name="completoNo" label="No" inlineLabel="true" inlineField="true"/>
            </aui:field-wrapper>
            <aui:input type="text" name="nDoc"    label="N. Documento" style="width: 90%" />
            <aui:input type="text" name="recProt" label="Rec Protocollo" style="width: 90%"/>
        </aui:column>
    </aui:layout>
</aui:fieldset>
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <aui:a id="btnAdd" cssClass="btn" href="#"><i class="icon-plus"></i>Aggiungi</aui:a>
            <aui:a id="btnRemove" cssClass="btn" href="#"><i class="icon-trash"></i>Rimuovi</aui:a>
            </div>
        </div>  
</aui:field-wrapper>

<aui:fieldset id="myDataTable" />

<script type="text/javascript">

    YUI({lang: 'it'}).use('aui-datepicker', 'aui-modal', function (Y) {
        var orderDate = new Y.DatePicker({
            trigger: '#<portlet:namespace />orderDate',
            mask: '%d/%m/%y',
            popover: {
                position: 'top',
                toolbars: {
                    header: [[
                            {
                                icon: 'icon-trash',
                                label: 'Clear',
                                on: {
                                    click: function () {
                                        orderDate.clearSelection();
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
        var deliveryDate = new Y.DatePicker({
            trigger: '#<portlet:namespace />deliveryDate',
            mask: '%d/%m/%y',
            popover: {
                position: 'top',
                toolbars: {
                    header: [[
                            {
                                icon: 'icon-trash',
                                label: 'Clear',
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

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#<portlet:namespace/>destinazioneTxt').on('click', function (event) {
//            console.log(event);
            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false,
                    height: '600px',
                    width: '800px'
                },
                id: '<portlet:namespace/>dialog',
                title: 'Seleziona Destinazione',
                uri: '<%=popupURL %>'
            });
        });
    });

    Liferay.provide(window, 'closePopup', function (data, dialogId) {
        // Closing the dialog
        var dialog = Liferay.Util.Window.getById(dialogId);
        console.log(dialog);
        dialog.hide();
        console.log(data);
        document.getElementById('<portlet:namespace/>destinazioneTxt').value = data;

    }, ['liferay-util-window']);


    YUI().use('aui-datatable', 'aui-datatype', 'datatable-sort', "datatable-mutable", function (Y) {

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

        var columns = [
            {
                editor: nameEditor,
                key: 'codiceArticolo',
                label: 'Codice'
            },
            {
                key: 'descrizione',
                label: 'Descrizione'
            },
            {
                key: 'lotto',
                label: 'Lotto'
            },
            {
                key: 'reti',
                label: 'Reti'
            },
            {
                key: 'pedane',
                label: 'Ped'
            },
            {
                key: 'imballo',
                label: 'Imballo'
            },
            {
                key: 'rtxCl',
                label: 'RtxCl'
            },
            {
                key: 'kgRete',
                label: 'KG Rete'
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
                key: 'tara',
                label: 'Tara'
            },
            {
                key: 'taraPedana',
                label: 'Tara P.'
            },
            {
                key: 'pesoNetto',
                label: 'P. Netto'
            }
        ];

        var data = [{codiceArticolo: '1236', descrizione: 'San Francisco', lotto: 'A1'}];

        var table = new Y.DataTable({
            columns: columns,
            data: data,
            editEvent: 'dblclick',
            plugins: [
                {
                    cfg: {
                        highlightRange: false
                    },
                    fn: Y.Plugin.DataTableHighlight
                }
            ]

        }).render('#<portlet:namespace />myDataTable');

        Y.one("#<portlet:namespace />btnAdd").on("click", function () {
            var new_data = {codiceArticolo: '1236', descrizione: 'San Francisco', lotto: 'A1'};
            table.addRow(new_data);
        });
        
    });
//    YUI().use("datatable-sort", "datatable-scroll", "datatable-mutable",
//            function (Y) {
//                var columns = [
//                    {
//                        key: 'name',
//                        label: 'Nome'
//                    },
//                    {
//                        key: 'address',
//                        label: 'Indirizzo'
//                    },
//                    {
//                        key: 'city',
//                        label: 'Città'
//                    },
//                    {
//                        key: 'state',
//                        label: 'Stato'
//                    }];
//                var data = [
//                    {address: '1236 Some Street', city: 'San Francisco', name: 'John A. Smith', state: 'CA'},
//                    {address: '3271 Another Ave', city: 'New York', name: 'Joan B. Jones', state: 'NY'},
//                    {address: '9996 Random Road', city: 'Los Angeles', name: 'Bob C. Uncle', state: 'CA'},
//                    {address: '1623 Some Street', city: 'San Francisco', name: 'John D. Smith', state: 'CA'},
//                    {address: '9899 Random Road', city: 'Los Angeles', name: 'Bob F. Uncle', state: 'CA'}
//                ];
//                var table = new Y.DataTable(
//                        {
//                            columnset: columns,
//                            recordset: data,
//                            scrollable: 'y',
//                            width: 'auto'
////                            height: '250px',
////                            sortable: ['name', 'city'],
//                        }
//                ).render('#<portlet:namespace />myDataTable');
//                Y.one("#<portlet:namespace />btnAdd").on("click", function () {
//                    alert("PIPPO");
//                    var new_data = {address: 'AAAAAAAAA', city: 'BBBBBBB', name: 'CCCCCCCCC', state: 'IT'};
//                    //     table.get('data').add(new_data);   // this works fine!
//                    table.addRow(new_data);
//                    //      table.syncUI();        // don't need this ... unless silent:true is set
//                });
//            }
//
//    ); //http://jsfiddle.net/emooney/jHnXD/1/


    YUI().use('aui-io-request', 'node', function (Y) {
        Y.one('#btnSave').on('click', function () {
            Y.io.request(
                    '${saveDDT}',
                    {
                        on: {
                            success: function () {
                                var data = this.get('responseData');
                                alert("SUCCESS: " + data);
                            }
                        }
                    }
            );
        });
        Y.one('#btnPrint').on('click', function () {
            Y.io.request(
                    '${printDDT}',
                    {
                        on: {
                            success: function () {
                                var data = this.get('responseData');
                                alert("SUCCESS: " + data);
                            }
                        }
                    }
            );
        });
    });


</script>

