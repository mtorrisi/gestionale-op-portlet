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
<portlet:resourceURL var="saveDDT"  id="save"  />
<portlet:resourceURL var="printDDT" id="print" />
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <button id="btnSave" class="btn" onclick="SalvaDDT()" ><i class="icon-hdd"></i>Salva</button>
            <button id="btnPrint" class="btn" ><i class="icon-print"></i>Stampa</button>
        </div>
    </div>  
</aui:field-wrapper>

<aui:fieldset label="Compila DDT">
    <aui:layout>
        <aui:column columnWidth="70" cssClass="detail-column detail-column-first">
            <aui:input id="codiceClienteTxt" type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
            <aui:input id="clienteTxt" type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=cliente.getRagioneSociale()%>"/>
            <aui:input id="destinazioneTxt" type="text" name="destinazione" label="Destinazione diversa" cssClass="input-xxlarge" value="<%=cliente.getIndirizzo()%>" inlineField="true"/>
            <aui:input id="codiceDestinazione" type="text" name="codiceDest" label="" inlineField="true" style="display: none"/>
            <aui:a href="#" onClick="restoreAdress()">Ripristina</aui:a><br/>
            <aui:input id="orderDate"    type="text" name="dataOrdine"   label="Data Ordine"     inlineField="true" />
            <aui:input id="deliveryDate" type="text" name="dataConsegna" label="Data Consegna"   inlineField="true" />

            <%--aui:input type="text" name="totPedane"    label="Tot. Pedane"     inlineField="true" cssClass="input-small"/>
            <aui:input type="text" name="Tot. Pesate"  label="Tot. Pesate"     inlineField="true" cssClass="input-small" /--%>
        </aui:column>
        <aui:column columnWidth="20" cssClass="test" last="true" >
            <%--aui:field-wrapper label="Ordine Finito"  >
                <aui:input type="radio" name="completoSi" label="Si" inlineLabel="true" checked="true" inlineField="true"/>
                <aui:input type="radio" name="completoNo" label="No" inlineLabel="true" inlineField="true"/>
            </aui:field-wrapper--%>
            <aui:input type="text" name="nDoc"    label="N. Documento" style="width: 90%" />
            <aui:input type="text" name="recProt" label="Rec Protocollo" style="width: 90%"/>
        </aui:column>
    </aui:layout>
</aui:fieldset>

<div id="myTab">

    <ul class="nav nav-tabs">
        <li class="active"><a href="#tab-1">Corpo Documento</a></li>
        <li><a href="#tab-2">Fine Corpo</a></li>
    </ul>

    <div class="tab-content">
        <div id="tab-1" class="tab-pane">
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
        </div>
        <div id="tab-2">
            <form class="form-horizontal">
                <div class="control-group">
                    <label for="vettore1" class="control-label">Vettore 1: </label>
                    <div class="controls">
                        <input id="vettore1" type="text" class="input-xxlarge" name="vettore1" placeholder="Seleziona vettore..."/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="vettore2" class="control-label">Vettore 2: </label>
                    <div class="controls">
                        <input id="vettore2" type="text" class="input-xxlarge" name="vettore2" placeholder="Seleziona vettore..."/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="autista" class="control-label">Autista: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-xxlarge" id="autista">
                        <label for="telefono">Telefono: </label>
                        <input type="text" class="input-small" id="telefono">
                    </div>
                </div>
                <div class="control-group">
                    <label for="trasporto" class="control-label">Trasporto a cura: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="trasporto" readonly="true" style="display: none;">
                        <input type="text" class="input-xxlarge" id="telefonoTXT" placeholder="Seleziona...">
                    </div>
                </div>
                <div class="control-group">
                    <label for="aspetto" class="control-label">Aspetto esteriore: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="aspetto" readonly="true" style="display: none;">
                        <input type="text" class="input-xxlarge" id="aspettoTXT" placeholder="Seleziona...">
                    </div>
                </div>                
                <div class="control-group">
                    <label for="causale" class="control-label">Causale trsaporto: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="causale" readonly="true" style="display: none;">
                        <input type="text" class="input-xxlarge" id="causaleTXT" placeholder="Seleziona...">
                    </div>
                </div>
                <div class="control-group">
                    <label for="porto" class="control-label">Porto: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="porto" readonly="true" style="display: none;">
                        <input type="text" class="input-xxlarge" id="portoTXT" placeholder="Seleziona...">
                    </div>
                </div>
                <div class="control-group">
                    <label for="origine" class="control-label">Origine: </label>
                    <div class="controls">
                        <input id="origine" type="text" class="input-xxlarge" name="origine" />
                    </div>
                </div>
                <div class="control-group">
                    <label for="rigo" class="control-label">Rigo descrittivo: </label>
                    <div class="controls">
                        <textarea class="form-control input-xxlarge" rows="3" id="rigo"></textarea>
                    </div>
                </div>
                <div class="control-group">
                    <label for="costo" class="control-label">Costo Trasorto: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="costo">
                        <label for="pedane-euro">N° Pedane Euro: </label>
                        <input type="text" class="input-small" id="pedane-euro"/>
                        <label for="pedane-normali">N° Pedane Normali: </label>
                        <input type="text" class="input-small" id="pedane-normali"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="motrice" class="control-label">Targa Motrice: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="motrice">
                        <label for="rimorchio">Targa rimorchio: </label>
                        <input type="text" class="input-small" id="rimorchio"/>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

<script type="text/javascript">

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

    var indirizzo;

    function restoreAdress() {
        if (indirizzo) {
            console.log(indirizzo);
            document.getElementById('<portlet:namespace/>destinazioneTxt').value = indirizzo;
            document.getElementById('<portlet:namespace/>codiceDestinazione').value = "";
        }
    }


    YUI({lang: 'it'}).use('aui-datepicker', 'aui-modal', function (Y) {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;
        var yyyy = today.getFullYear();
        var todayDateInMMDDYYYY = dd + '/' + mm + '/' + yyyy;

        var orderDate = new Y.DatePicker({
            trigger: '#<portlet:namespace />orderDate',
            calendar: {
                dates: [todayDateInMMDDYYYY],
                dateFormat: '%d/%m/%Y'
            },
            popover: {
                position: 'top',
                toolbars: {
                    header: [[
                            {
                                icon: 'icon-trash',
                                label: 'Cancella',
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

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#<portlet:namespace/>destinazioneTxt').on('click', function (event) {

            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false,
//                    height: '600px',
//                    width: '800px'
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
                var tmp = data.split('|');
                var dest = tmp[0];
                var codice = tmp[1];
                document.getElementById('<portlet:namespace/>destinazioneTxt').value = dest;
                document.getElementById('<portlet:namespace/>codiceDestinazione').value = codice;
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
                emptyCellValue: '<button id="selectPack">Seleziona Imballo</button>'
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
                editor: numberEditor,
                key: 'prezzo',
                label: 'Prezzo'
            },
            {
                editor: nameEditor,
                key: 'codArtFornitore',
                label: 'Art. For.'
            },
            {
                editor: nameEditor,
                key: 'passaporto',
                label: 'Passaporto'
            },
            {
                editor: numberEditor,
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
//                    height: '600px',
//                    width: '1024px'
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
//                    height: '600px',
//                    width: '1024px'
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

        table.after('*:colliChange', function (e) {
            calcola();
        });
//        table.after('*:pesoLordoChange', function (e) {
//            calcola();
//        });
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
                    draggable: true//,
//                    height: '600px',
//                    width: '1024px'
                },
                id: '<portlet:namespace/>itemDialog',
                title: 'Seleziona Articolo',
                uri: '<%=itemURL %>'
            });
        });

        Y.one("#<portlet:namespace />btnRemove").on("click", function () {
            console.log(recordSelected);
//            table.removeRow(recordSelected);
//            recordSelected = undefined;
        });



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
            recordSelected.setAttrs({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2]});
            recordSelected = undefined;
        } else {
            table.addRow({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2]}, {sync: true});
        }
    }

    function setPack(data) {
        if (recordSelected) {
            recordSelected.setAttrs({imballo: data});
            recordSelected = undefined;
        }
    }

    function calcola() {
        var record = recordSelected.getAttrs();
        var colli = colli = record.colli;
        var pesoLordo;
        var tara = record.tara;
        var taraPedana = record.taraPedana;
        var pedane = record.pedane;
        var pesoNetto;
        if (!record.reti || record.reti === 'no') {
            console.log("GESTIONE RETI NO");
            pesoLordo = record.pesoLordo;
            pesoNetto = pesoLordo - ((tara * colli) - (taraPedana * pedane));
            console.log(pesoNetto);
            recordSelected.setAttrs({pesoNetto: pesoNetto});
        } else if (record.reti === 'si') {
            console.log("GESTIONE RETI SI");
//            recordSelected.setAttrs({tara: 1.25, taraPedana: 0}, {sync: true});
            var rtxCl = record.rtxCl;
            var kgRete = record.kgRete;
//            var tara = record.tara;
//            var taraPedana = record.taraPedana;
            pesoNetto = rtxCl * kgRete * colli;
            pesoLordo = pesoNetto + (tara * colli) + (taraPedana * pedane);
            if (!isNaN(pesoLordo))
                recordSelected.setAttrs({pesoNetto: pesoNetto, pesoLordo: pesoLordo});
        }
    }

    function sendData(data) { //loadURL + "&" + portletNamespace + "file=" + file + ""
        //        console.log('${saveDDT}' + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(data)));
        YUI().use('aui-io-request', 'node', function (Y) {
            var codiceCliente = Y.one('#<portlet:namespace />codiceClienteTxt').val();
            var clienteTxt = Y.one('#<portlet:namespace />clienteTxt').val();
            var destinazioneTxt = Y.one('#<portlet:namespace />destinazioneTxt').val();
            var orderDate = Y.one('#<portlet:namespace />orderDate').val();
            var deliveryDate = Y.one('#<portlet:namespace />deliveryDate').val();
            var queryString = "&codiceCliente=" + codiceCliente +
                    "&clienteTxt=" + clienteTxt + "&destinazioneTxt=" + destinazioneTxt +
                    "&orderDate=" + orderDate + "&=deliveryDate" + deliveryDate;
            //        Y.one('#btnSave').on('click', function () {
            Y.io.request(
                    '${saveDDT}' + queryString + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(data)),
                    {
                        on: {
                            success: function () {
                                var data = this.get('responseData');
                                alert("SUCCESS: " + data);
                            }
                        }
                    }
            );
//        });
//        Y.one('#btnPrint').on('click', function () {
//            Y.io.request(
//                    '${printDDT}',
//                    {
//                        on: {
//                            success: function () {
//                                var data = this.get('responseData');
//                                alert("SUCCESS: " + data);
//                            }
//                        }
//                    }
//            );
//        });
        });
    }

    function SalvaDDT() {
        var rows = [];
        for (var i = 0; i < table.data.size(); i++) {
            rows[i] = table.data.item(i).toJSON();
        }
        console.log(rows);
        sendData(rows);
    }

    YUI().use('aui-io-request', 'node', function (Y) {
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

