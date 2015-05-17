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
<liferay-portlet:renderURL var="itemURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectItem.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="packingURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectPack.jsp" />
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
            <aui:a href="#" onClick="restoreAdress()">Ripristina</aui:a><br/>
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
            <aui:a id="btnAdd" cssClass="btn" href="#a"><i class="icon-plus"></i>Aggiungi</aui:a>
            <aui:a id="btnRemove" cssClass="btn" href="#a"><i class="icon-trash"></i>Rimuovi</aui:a>
            </div>
        </div>  
        <div class="yui3-skin-sam">
        <aui:fieldset id="myDataTable" />
    </div>
</aui:field-wrapper>


<script type="text/javascript">

    var indirizzo;

    function restoreAdress() {
        if (indirizzo) {
            console.log(indirizzo);
            document.getElementById('<portlet:namespace/>destinazioneTxt').value = indirizzo;
        }
    }


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
        switch (dialogId) {
            case '<portlet:namespace/>dialog':
                if (!indirizzo)
                    indirizzo = document.getElementById('<portlet:namespace/>destinazioneTxt').value;
                document.getElementById('<portlet:namespace/>destinazioneTxt').value = data;
                break;
            case '<portlet:namespace/>itemDialog':
//                alert("PIPPO");  
                setItem(data);
                break;
            case '<portlet:namespace/>packDialog':
//                alert("PIPPO");
                setPack(data);
                break;
        }
    }, ['liferay-util-window']);

    var table;
    var recordSelected;
    YUI().use('aui-datatable', 'aui-datatype', 'datatable-sort', 'datatable-mutable', function (Y) {

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
                label: 'Descrizione'
            },
            {
                editor: nameEditor,
                key: 'lotto',
                label: 'Lotto'
            },
            {
                editor: retiCheckbox,
                key: 'reti',
                label: 'Reti'
            },
            {
                editor: numberEditor,
                key: 'pedane',
                label: 'Ped'
            },
            {
                allowHTML: true,
                key: 'imballo',
                label: 'Imballo',
                emptyCellValue: '<button id="selectPack"><i class="icon-hdd"></i>Seleziona</button>'
            },
            {
                editor: numberEditor,
                key: 'rtxCl',
                label: 'RtxCl'
            },
            {
                editor: numberEditor,
                key: 'kgRete',
                label: 'KG Rete'
            },
            {
                editor: numberEditor,
                key: 'colli',
                label: 'Colli'
            },
            {
                editor: numberEditor,
                key: 'pesoLordo',
                label: 'P. Lordo'
            },
            {
                editor: numberEditor,
                key: 'tara',
                label: 'Tara'
            },
            {
                editor: numberEditor,
                key: 'taraPedana',
                label: 'Tara P.'
            },
            {
                key: 'pesoNetto',
                label: 'P. Netto'
            },
            {
                key: 'prezzo',
                label: 'Prezzo'
            },
            {
                key: 'codArtFornitore',
                label: 'Art. For.'
            },
            {
                key: 'passaporto',
                label: 'Passaporto'
            },
            {
                key: 'progressivo',
                label: 'Progr.'
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
        table.delegate('dblclick', function (e) {
            console.log(e.currentTarget._node.cells[0].innerText);
            console.log(e.currentTarget);
            recordSelected = table.getRecord(e.currentTarget);
            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: true,
                    draggable: true,
                    height: '600px',
                    width: '1024px'
                },
                id: '<portlet:namespace/>itemDialog',
                title: 'Seleziona Articolo',
                uri: '<%=itemURL %>'
            });

        }, 'tr', table);

        table.delegate('click', function (e) {
            recordSelected = table.getRecord(e.currentTarget);
        }, 'tr', table);
        
        table.delegate('click', function (e) {
            recordSelected = table.getRecord(e.currentTarget);
            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: true,
                    draggable: true,
                    height: '600px',
                    width: '1024px'
                },
                id: '<portlet:namespace/>packDialog',
                title: 'Seleziona Imballaggio',
                uri: '<%=packingURL %>'
            });
        }, '#selectPack', table);

//        table.after('*:pedaneChange', function (e) {
//            console.log(e.newVal);
//        });
//        table.after('*:retiChange', function (e) {
//            console.log(e.newVal);
//        });

        table.after('*:rtxclChange', function (e) {
            calcola();
        });
//        table.after('*:kgReteChange', function (e) {
//            calcola();
//        });
        table.after('*:colliChange', function (e) {
            calcola();
        });
        table.after('*:pesoLordoChange', function (e) {
            calcola();
        });
        table.after('*:taraChange', function (e) {
            calcola();
        });
        table.after('*:taraPedanaChange', function (e) {
            calcola();
        });

        Y.one("#<portlet:namespace />btnAdd").on("click", function () {
            recordSelected = undefined;
            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: true,
                    draggable: true,
                    height: '600px',
                    width: '1024px'
                },
                id: '<portlet:namespace/>itemDialog',
                title: 'Seleziona Articolo',
                uri: '<%=itemURL %>'
            });
        });

        Y.one("#<portlet:namespace />btnRemove").on("click", process);



        function process() {

            var ml = table.data,
                    msg = '',
                    template = 'Record index = {index} Data = {codiceArticolo} : {descrizione}\n';

            ml.each(function (item, i) {
                var data = item.getAttrs(['select', 'codiceArticolo', 'descrizione']);

                if (data.select) {
                    data.index = i;
                    msg += Y.Lang.sub(template, data);
                }
            });

            console.log(msg || '(None)');
            //Y.one("#processed").setHTML(msg || '<li>(None)</li>');
        }
    });

    function setItem(data) {
        var tmp = data.split('|');

        console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({codiceArticolo: tmp[0], descrizione: tmp[1]});
            recordSelected = undefined;
        } else {
            table.addRow({codiceArticolo: tmp[0], descrizione: tmp[1]}, {sync: true});
        }
    }

    function setPack(data) {
        if (recordSelected) {
            recordSelected.setAttrs({imballo: data});
            recordSelected = undefined;
        }
    }
    
    function calcola(){
        var record = recordSelected.getAttrs();
        var colli;
        if(!record.reti || record.reti === 'no'){
            console.log("GESTIONE RETI NO");
            var pesoLordo= record.pesoLordo;
            colli = record.colli;
            var tara = record.tara;
            var taraPedana = record.taraPedana;
            var pesoNetto = pesoLordo-((tara * colli) + taraPedana);
            console.log(pesoNetto);
            recordSelected.setAttrs({pesoNetto: pesoNetto});
        }else if(record.reti === 'si'){
            console.log("GESTIONE RETI SI");
//            recordSelected.setAttrs({tara: 1.25, taraPedana: 0}, {sync: true});
            var rtxCl = record.rtxCl;
            var kgRete = record.kgRete;
            colli = record.colli;
            
            var pesoNetto = rtxCl * kgRete * colli;
            var pesoLordo = pesoNetto + (1.25 * colli);
            
            recordSelected.setAttrs({pesoNetto: pesoNetto, pesoLordo: pesoLordo, tara: 1.25, taraPedana: 0});
        }
    }

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

