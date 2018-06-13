<%@page import="it.bysoftware.ct.service.DescrizioniVariantiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DescrizioniVarianti"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DescrizioniDocumenti"%>
<%@page import="it.bysoftware.ct.service.ArticoliLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Articoli"%>
<%@page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserIdMapper"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="it.bysoftware.ct.NoSuchOrganizzazioneProduttoriException"%>
<%@page import="it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.OrganizzazioneProduttori"%>
<%@page import="it.its.ct.gestionaleOP.utils.Constants"%>
<%@page import="it.its.ct.gestionaleOP.utils.DocumentType"%>
<%@page import="it.bysoftware.ct.service.persistence.ClientiDatiAggPK"%>
<%@page import="it.bysoftware.ct.service.IvaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Iva"%>
<%@page import="it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.ClientiDatiAgg"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
    String codiceAliquotaCliente = "";
    String indirizzoCompleto = "";
    UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(Long.parseLong(renderRequest.getRemoteUser()), Constants.FUTURO_NET);
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper.getUserIdMapperId());
    String cod = ParamUtil.getString(renderRequest, "codiceCliente", null);
    Anagrafica cliente = null;
    ClientiDatiAgg datiAggCliente = null;
    if (cod != null && !cod.isEmpty()){
        cliente = AnagraficaLocalServiceUtil.getAnagrafica(cod);
        datiAggCliente = ClientiDatiAggLocalServiceUtil.getDatiAggByCodiceAnagrafica(cod);
        indirizzoCompleto = cliente.getIndirizzo() + " - " + cliente.getCap() + ", " + cliente.getComune() + " (" + cliente.getProvincia() + ") - " + cliente.getStato();
        codiceAliquotaCliente = datiAggCliente.getCodiceAliquota();
    }
    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<Integer> idToRecover = new ArrayList<Integer>();
    List<Progressivo> listProgressivo = ProgressivoLocalServiceUtil.getByAnnoIdAssociatoTipoDocumento(Calendar.getInstance().get(Calendar.YEAR), a.getId(), Constants.INVOICE_ID);
    for (Progressivo p : listProgressivo) {
        idToRecover.add(p.getNumeroProgressivo());
    }
    double iva = 0.0;
    if (!codiceAliquotaCliente.equals("")) {
        Iva vociIva = IvaLocalServiceUtil.fetchIva(codiceAliquotaCliente);
        if (vociIva != null) {
            iva = vociIva.getAliquota(); 
        }
    }
    
    List<Iva> vats = IvaLocalServiceUtil.getIvas(0,
            IvaLocalServiceUtil.getIvasCount());
    String vatCodes = "";
    for (Iva vat : vats) {
        vatCodes += "|" + vat.getCodiceIva() + " --> " + vat.getDescrizione() + " --> " + (int)vat.getAliquota();
    }
    
    List<DescrizioniVarianti> varianti = DescrizioniVariantiLocalServiceUtil.getVarianti();
    String stringVarianti = "";
    for (int i = 0; i < varianti.size(); i++) {
        if (i == varianti.size() - 1) {
            stringVarianti += varianti.get(i).getCodiceVariante() + " - " + varianti.get(i).getDescrizioneVariante();
        } else {
            stringVarianti += varianti.get(i).getCodiceVariante() + " - " + varianti.get(i).getDescrizioneVariante() + "|";
        }
    }
%>

<liferay-portlet:resourceURL var="saveInvoice"  id="generateInvoice" />
<portlet:resourceURL var="printInvoice" id="printInvoice" />
<liferay-portlet:renderURL var="descrURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectDescription.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="itemURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectItem.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="packingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectPack.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="popupURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/destinations.jsp" />
    <liferay-portlet:param name="codiceCliente" value="<%= cliente.getCodiceAnagrafica() %>" />
</liferay-portlet:renderURL>
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <button id="btnInvoice" class="btn" onclick="saveInvoice()"><i class="icon-list-alt"></i> Genera Fattura</button>
            <button id="btnPrint"   class="btn" disabled="true"><i class="icon-print"></i> Stampa</button>
            <button id="btnPrintCessione" class="btn" disabled="true"><i class="icon-envelope"></i> Cessione Credito</button>
        </div>
    </div>  
</aui:field-wrapper>

<aui:fieldset label="Testata Fattura">
    <aui:layout>
        <aui:column columnWidth="80" cssClass="detail-column detail-column-first">
            <aui:input id="codiceClienteTxt" type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
            <aui:input id="clienteTxt" type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=cliente.getRagioneSociale()%>"/>
            <aui:input id="destinazioneTxt" type="text" name="destinazione" label="Destinazione diversa" cssClass="input-xxlarge" value="<%=indirizzoCompleto%>" inlineField="true"/>
            <aui:input id="codiceDestinazione" type="text" name="codiceDest" label="" inlineField="true" style="display: none"/>    
            <aui:a href="#" onClick="restoreAdress()">Ripristina</aui:a><br />
            <aui:input id="documentDate" type="text" name="documentDate" label="Data Documento" inlineField="true" value="<%= sdf.format(date)%>"/>
            <aui:input cssClass="input-small" id="lottoTestata" inlineField="true" label="Lotto" name="lottoTestata" type="text" />
        </aui:column>
        <aui:column columnWidth="20" cssClass="test" >
       	<aui:fieldset label="Fattura vendita">
            <aui:input type="text" name="nDoc" label="N. Documento">
            	<aui:validator name="digits"></aui:validator>
            </aui:input>
            <aui:select label="Rec Protocollo" name="recProt" style="background-color: #FFFFCC;" > 
                <c:forEach items="<%= idToRecover%>" var="id">
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
        <li class="active"><a href="#tab-1">Corpo Fattura</a></li>
        <li><a href="#tab-2">Totali</a></li>
    </ul>

    <div class="tab-content">
        <div id="tab-1" class="tab-pane">
            <aui:fieldset label="Corpo Fattura">
                <aui:field-wrapper >
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <aui:a id="btnAdd" cssClass="btn" href="#a"><i class="icon-plus"></i>Aggiungi Articolo</aui:a>
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
                <aui:fieldset id="tabellaTotali" />
<%--                 <aui:input id="totaleImponibileTxt" type="text" name="totImponibile" label="Totale imponiible" disabled="true" inlineField="true"/> --%>
<%--                 <aui:input id="aliquotaTxt" type="text" name="aliquota" label="Aliquota" disabled="true" inlineField="true" value="<%= String.valueOf(iva.getAliquota()) + "%"%>"/> --%>
<%--                 <aui:input id="totaleIVATxt" type="text" name="totIVA" label="Totale IVA" disabled="true" inlineField="true"/> --%>
                <aui:input id="totaleDocumentoTxt" type="text" name="totDocumento" label="Totale documento" disabled="true" inlineField="true"/>
                
            </aui:fieldset>
        </div>
    </div>
</div>


<script type="text/javascript">
//        window.onbeforeunload = function () {
//            return "";
//        };
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var todayDateInDDMMYYYY = dd + '/' + mm + '/' + yyyy;

    var variety = "<%= stringVarianti %>";
    var aliquotaIVA     = <%= iva%>;
    var codiceAliquota  = '<%= codiceAliquotaCliente%>';
    
    var vatCodes = '<%= vatCodes%>';
    
    YUI().use('node', function(Y) {
        Y.one('#<portlet:namespace/>lottoTestata').set('value', calcolaLotto(today));
    });
    
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
                                    	documentDate.clearSelection();
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
                    document.getElementById('<portlet:namespace/>lottoTestata').value = calcolaLotto(event.newSelection[0]);
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

        var data = [];
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
        var retiCheckbox = new Y.RadioCellEditor({
            options: {
                si: 'Si',
                no: 'No'
            }
        });

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
            	editor: nameEditor,
                key: 'descrizione',
                label: 'Descrizione Articolo'
            },
//             {
//             	key: 'codiceVariante',
//                 label: 'Cod. Var.'
//             },
            {
                editor: new Y.DropDownCellEditor({
                    options: variety.split("|")
                }),
                key: 'descrizioneVariante',
                label: 'Var.'
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
                editor: retiCheckbox,
                key: 'reti',
                label: 'Reti'
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
                key: 'pedane',
                label: 'Ped'
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
                editor: nameEditor,
                key: 'pesoNetto',
                label: 'Quant.'
            },
            {
                editor: numberEditor,
                key: 'prezzo',
                label: 'Prezzo'
            },
            {
                editor: numberEditor,
                key: 'sconto1',
                label: 'Sc. 1'
            },
            {
            	editor: numberEditor,
                key: 'sconto2',
                label: 'Sc. 2',
                className: 'hide'
            },
            {
                editor: numberEditor,
                key: 'sconto3',
                label: 'Sc. 3',
                className: 'hide'
            },
            {
                key: 'importo',
                label: 'Importo'
            },
            {
                editor: new Y.DropDownCellEditor({
                    centered: 'Node',
                    options: vatCodes.split('|'), 
                }),
                key: 'codiceIva',
                label: 'C.I.' 
            },
            {
              key: 'aliquotaIva',
              label: '%',
              className: 'hide'
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

        table.addAttr("selectedRow", {value: null});

        table.delegate('click', function (e) {
            recordSelected = table.getRecord(e.currentTarget);
        }, 'tr', table);
        
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
        
        table.after('*:pedaneChange', function(e) {
            calcola();
        });

        table.after('*:rtxclChange', function(e) {
            calcola();
        });

        table.after('*:colliChange', function(e) {
            calcola();
        });
        table.after('*:pesoLordoChange', function(e) {
            calcola();
        });
        table.after('*:taraChange', function(e) {
            calcola();
        });
        table.after('*:taraPedanaChange', function(e) {
            calcola();
        });
        
        table.after('*:pesoNettoChange', function (e) {
            calcolaSconto();
        });
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
        
        table.after('*:codiceIvaChange', function (e) {
            setCodiceIva();
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
            var row = table.getActiveRecord();
            if (row.getAttrs().codiceArticolo === '' || row.getAttrs().codiceArticolo === "PR"){
                table.removeRow(row);
                calcolaImporti();
            }
//             else if(row.getAttrs().prezzo === '' || row.getAttrs().prezzo === 0)
	        else if(!row.getAttrs().colli || row.getAttrs().colli === '') {
                table.removeRow(row);
                calcolaImporti();
            }
            else
                alert("Attenzione non e' possibile rimuovere un rigo con un prodotto.");
            recordSelected = "";
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
                title: 'Seleziona Prodotto',
                uri: '<%=itemURL%>'
            });
        });
        
        YUI().use('liferay-util-window', function(Y) {
            Y.one('#<portlet:namespace/>destinazioneTxt').on('click', function(event) {

                Liferay.Util.openWindow({
                    dialog: {
                        centered: true,
                        modal: true,
                        resizable: false
                                //                    height: '600px',
                                //                    width: '800px'
                    },
                    id: '<portlet:namespace/>dialog',
                    title: 'Seleziona Destinazione',
                    uri: '<%= popupURL %>'
                });
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
            case '<portlet:namespace/>dialog':
                if (!indirizzo)
                    indirizzo = document.getElementById('<portlet:namespace/>destinazioneTxt').value;
                var tmp = data.split('|');
                var dest = tmp[0];
                var codice = tmp[1];
                document.getElementById('<portlet:namespace/>destinazioneTxt').value = dest;
                document.getElementById('<portlet:namespace/>codiceDestinazione').value = codice;
                break;
            case '<portlet:namespace/>DescriptionDialog':
                setDescription(data);
                break;
            case '<portlet:namespace/>packDialog':
                setPack(data);
                break;
            case '<portlet:namespace/>itemDialog':
                setItem(data);
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

    function setPack(data) {
        if (recordSelected) {
            recordSelected.setAttrs({imballo: data});
            recordSelected = undefined;
        }
    }
    
    function setDescription(data) {
    	var tmp = data.split('|');
        console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({descrizione: tmp[0], codiceArticolo: tmp[1], codiceIva: (codiceAliquota === "" ? tmp[2] : codiceAliquota), aliquotaIva: (codiceAliquota === "" ? tmp[3] : aliquotaIVA)});
            //recordSelected = undefined;
        } else {
            table.addRow({descrizione: tmp[0], codiceArticolo: tmp[1], codiceIva: (codiceAliquota === "" ? tmp[2] : codiceAliquota), aliquotaIva: (codiceAliquota === "" ? tmp[3] : aliquotaIVA)}, {sync: true});
        }
    }
    
    function calcolaLotto(date) {
        var d;
        if (date)
            d = new Date(Date.parse(date));
        else
            d = new Date();
        var anno = d.getFullYear().toString().substr(2, 2);
        var onejan = new Date(d.getFullYear(), 0, 1);
        var juldate = Math.ceil((d - onejan) / 86400000);

        return "L-" + anno + juldate;
    }
    
    function setItem(data) {
        var tmp = data.split('|');

        console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2]});
            recordSelected = undefined;
        } else {
            table.addRow({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2], lotto: document.getElementById('<portlet:namespace/>lottoTestata').value, pedane: 1, unitaMisura: tmp[3], taraPedana: 0.0, codiceIva: (codiceAliquota === "" ? tmp[4] : codiceAliquota), aliquotaIva: (codiceAliquota === "" ? tmp[5] : aliquotaIVA)}, {sync: true});
            console.log(tmp[0] + "|" + tmp[1] + "|" + tmp[2] + "|" + tmp[3] + "|" + tmp[4] + "|" + tmp[5]);
//            console.log("####: " + tmp[0] + " " + tmp[1] + " " + tmp[2]);
        }
    }

    function saveInvoice(origDoc) {
        var rows = [];
        var ok = true;
        for (var i = 0; i < table.data.size(); i++) {
            if ('pesoLordo' in table.data.item(i).toJSON())
                if (isNaN(table.data.item(i).toJSON().importo) || table.data.item(i).toJSON().importo === 0 ||
                		table.data.item(i).toJSON().importo === "0.00") {
                    ok = false;
                    break;
                }
            rows[i] = table.data.item(i).toJSON();
        }
        console.log(rows);
        if (rows.length !== 0 && ok) {
           	sendData(rows, origDoc);
        } else {
        	alert("Attenzione non e' possibile generare la fattura.\nVerificare di aver inserito i prezzi per tutti gli articoli.");
        }

    }
        
    function calcola() {
        var record = recordSelected.getAttrs();
        var colli = record.colli;
        var pesoLordo;
        var tara = record.tara;
        var taraPedana = record.taraPedana;
        var pedane = record.pedane;
        var pesoNetto;
        if (!record.reti || record.reti === 'no') {
            console.log("GESTIONE RETI NO");
            pesoLordo = record.pesoLordo;
            pesoNetto = pesoLordo - (tara * colli) - (taraPedana * pedane);
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
    
    function sendData(rows, origDoc) {
<%--     	var document2op = <%= document2op %>; --%>
        YUI().use('aui-io-request', 'node', function (Y) {

            /******CAMPI TESTATA******/
            var codiceCliente = Y.one('#<portlet:namespace />codiceClienteTxt').val();
            var clienteTxt = Y.one('#<portlet:namespace />clienteTxt').val();
            var destinazioneTxt = Y.one('#<portlet:namespace />destinazioneTxt').val();
            var codiceDestinazione = Y.one('#<portlet:namespace />codiceDestinazione').val();
            var documentDate = Y.one('#<portlet:namespace />documentDate').val();
            var numeroFattura = Y.one('#<portlet:namespace/>recProt').val();
            var avanzaProtocollo = Y.one('#<portlet:namespace/>recProt').val();
            
            var queryString = "&<portlet:namespace/>codCli=" + codiceCliente +
                    "&<portlet:namespace/>clienteTxt=" + clienteTxt + "&<portlet:namespace/>destinazioneTxt=" + destinazioneTxt +
                    "&<portlet:namespace/>codiceDestinazione=" + codiceDestinazione + "&<portlet:namespace/>documentDate=" + documentDate +
                    "&<portlet:namespace/>numeroFattura=" + numeroFattura + "&<portlet:namespace/>avanzaProtocollo=" + avanzaProtocollo;
            //        Y.one('#btnSave').on('click', function () {
            Y.io.request(((origDoc) ? '${updateInvoice}' : '${saveInvoice}') + queryString + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(rows)), {
                on: {
                    success: function () {
                        var data = JSON.parse(this.get('responseData'));
                        if (data.code === 0) {
                            alert("Salvataggio effettuato con successo.");
                            if (Y.one('#<portlet:namespace/>nDoc').get('value') === '' ) {
								Y.one('#<portlet:namespace/>nDoc').set('value', data.id);
							}
                            document.getElementById("btnPrint").disabled = false;
                            document.getElementById("btnPrintCessione").disabled = false;
                            document.getElementById("btnInvoice").disabled = true;
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
                                    document.getElementById("btnInvoice").disabled = true;
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
                                case 9:
                                    alert("Attenzione, non e' stato possibile salvare la fattura, e' necessario specificare il numero di protocollo da assegnare.");
                                    break;
                                case 10:
                                    alert("Attenzione, non e' stato possibile salvare la fattura, esiste almeno una fattura con protocollo minore di: " + data.id + " e data maggiore di: " + documentDate);
                                    break;
                            }
                        }
                    }
                }
            });

        });
    }

    YUI().use('aui-io-request', 'node', function (Y) {
<%--     	var document2op = <%= document2op %>; --%>
        Y.one('#btnPrint').on('click', function () {
            var nDoc =Y.one('#<portlet:namespace/>nDoc').val();
            var codiceCliente = Y.one('#<portlet:namespace/>codiceClienteTxt').val();
            var win = window.open('${printInvoice}' + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />codiceCliente=' + codiceCliente + '&<portlet:namespace />update=' + false + '&<portlet:namespace />send=' + true, '_blank');
            win.focus();

        });
    });

    var t1;
    YUI().use('aui-datatable', 'aui-datatype', 'datatable-sort', 'datatable-mutable', function(Y) {

    	var data = calcolaImporti();
    	
    	var columns = [{
    		key: 'imponibile',
    		label: 'Imponibile'
    	},
    	{
    		label: 'Aliquota',
    		key: 'aliquota'
    	},
    	{
    		key: 'IVA',
    		label: 'Totale IVA'
    	},
    	{
            key: 'totale',
            label: 'Totale'
        }];
    	
    	t1 = new Y.DataTable(
    			{
    				columns: columns,
    		        data: data
   		        }
    		    
    	).render('#<portlet:namespace />tabellaTotali');
   	});
    function setCodiceIva() {
        var record = recordSelected.getAttrs();
        var codice = record.codiceIva.split(" --> ")[0];
        var aliquota = record.codiceIva.split(" --> ")[2];
        recordSelected.setAttrs({codiceIva: codice, aliquotaIva: aliquota});
        calcolaImporti();
    }
    function calcolaImporti(){
        var data = [];
        var i = 0;
        var somma = 0.0;
        var jsonTotali = {};
        
        for (var k = 0; k < table.data.size(); k++) {
            var rigo = table.getRecord(k).getAttrs();
            if(rigo.codiceIva){         
                var codiceIva = rigo.codiceIva;
                if(!jsonTotali[codiceIva]) {
                    jsonTotali[codiceIva]={};
                    jsonTotali[codiceIva].aliquota = Number(rigo.aliquotaIva);
                    jsonTotali[codiceIva].imponibili=[]; 
                }
                jsonTotali[codiceIva].imponibili.push(Number(rigo.importo));
            }
        }
        console.log("OLELLEL " + JSON.stringify(jsonTotali));
        
        for (var key in jsonTotali) {
            var totale = jsonTotali[key];
            var sommaImponibili = 0.0;
            for (var j = 0; j < totale.imponibili.length; j++) {
                sommaImponibili += totale.imponibili[j];
            }
            var x = sommaImponibili * (totale.aliquota / 100);
            var y = sommaImponibili * (1 + totale.aliquota / 100);
            somma += y;
            data[i] = {
                    imponibile: sommaImponibili.toFixed(2),
                    aliquota: totale.aliquota + '%',
                    IVA: x.toFixed(2),
                    totale: y.toFixed(2)
            }
            i++;
            console.log(JSON.stringify(data));
        }
        
        document.getElementById('<portlet:namespace />totaleDocumentoTxt').value = somma.toFixed(2);
        data.sort(function(a, b) {
            return parseFloat(a.aliquota.replace("%","")) - parseFloat(b.aliquota.replace("%",""));
        });
        if(t1) {
            t1.set('data', eval(data)); 
        }
        return data;
    }
    
    var indirizzo;

    function restoreAdress() {
        if (indirizzo) {
            console.log(indirizzo);
            document.getElementById('<portlet:namespace/>destinazioneTxt').value = indirizzo;
            document.getElementById('<portlet:namespace/>codiceDestinazione').value = "";
        }
    }
</script>

