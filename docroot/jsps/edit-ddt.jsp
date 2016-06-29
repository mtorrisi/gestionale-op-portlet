<%@page import="it.bysoftware.ct.service.DescrizioniVariantiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DescrizioniVarianti"%>
<%@page import="it.bysoftware.ct.service.TracciabilitaSchedaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="it.bysoftware.ct.service.VettoriLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Vettori"%>
<%@page import="it.bysoftware.ct.service.CuraTrasportoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.PortoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Porto"%>
<%@page import="it.bysoftware.ct.model.Porto"%>
<%@page import="it.bysoftware.ct.service.CausaleTrasportoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.CausaleTrasporto"%>
<%@page import="it.bysoftware.ct.model.CausaleTrasporto"%>
<%@page import="it.bysoftware.ct.service.AspettoEsterioreBeniLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.AspettoEsterioreBeniLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.AspettoEsterioreBeni"%>
<%@page import="it.bysoftware.ct.model.AspettoEsterioreBeni"%>
<%@page import="it.bysoftware.ct.model.CuraTrasporto"%>
<%@page import="it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DestinatariDiversi"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.RigoDocumento"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.persistence.TestataDocumentoPK"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@include file="../init.jsp" %>

<%
    int anno = Calendar.getInstance().get(Calendar.YEAR);
    long numeroDocumento = ParamUtil.getLong(renderRequest, "numeroDocumento");
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(renderRequest.getRemoteUser()));
    TestataDocumento testata = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(anno, numeroDocumento, "DDT", a.getId()));

    CuraTrasporto curaTrasporto = CuraTrasportoLocalServiceUtil.getCuraTrasporto(testata.getCuraTrasporto());
    AspettoEsterioreBeni aspetto = AspettoEsterioreBeniLocalServiceUtil.getAspettoEsterioreBeni(testata.getAspettoEsteriore());
    CausaleTrasporto causale = CausaleTrasportoLocalServiceUtil.getCausaleTrasporto(testata.getCausaleTrasporto());
    Porto porto = PortoLocalServiceUtil.getPorto(testata.getPorto());
    Vettori v1 = (!testata.getVettore().equals("")) ? VettoriLocalServiceUtil.getVettori(testata.getVettore()) : null;
    Vettori v2 = (!testata.getVettore2().equals("")) ? VettoriLocalServiceUtil.getVettori(testata.getVettore2()) : null;

    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(testata.getCodiceSoggetto());
    String indirizzo = "";
    if (!testata.getCodiceDestinazione().equals("")) {
        DestinatariDiversi destinazione = DestinatariDiversiLocalServiceUtil.getDestinatariDiversi(testata.getCodiceDestinazione());
        indirizzo = destinazione.getIndirizzo() + ", " + destinazione.getCAP() + " " + destinazione.getComune() + " (" + destinazione.getProvincia() + ")";
    } else {
        indirizzo = cliente.getIndirizzo() + ", " + cliente.getCap() + " " + cliente.getComune() + " (" + cliente.getProvincia() + ") ";
    }

    JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
    List<RigoDocumento> listRigo = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(numeroDocumento, anno, a.getId());

    for (RigoDocumento rigo : listRigo) {

        double taraPedana = (rigo.getPesoLordo() - (rigo.getTara() * rigo.getColli()) - rigo.getPesoNetto()) / rigo.getPedane();
        String gestioneReti = rigo.getGestioneReti() ? "si" : "no";

        JSONObject json = JSONFactoryUtil.createJSONObject();
        json.put("codiceArticolo", rigo.getCodiceArticolo());
        json.put("descrizione", rigo.getDescrizione());
        json.put("descrizioneVariante", rigo.getDescrizioneVariante());
        json.put("lotto", rigo.getLotto());
        json.put("descrizione", rigo.getDescrizione());
        json.put("reti", gestioneReti);
        json.put("pedane", rigo.getPedane());
        json.put("imballo", rigo.getImballo());
        json.put("rtxCl", rigo.getRtxCl());
        json.put("reti", rigo.getGestioneReti());
        json.put("kgRete", rigo.getKgRete());
        json.put("unitaMisura", rigo.getUnitaMisura());
        json.put("colli", rigo.getColli());
        json.put("pesoLordo", rigo.getPesoLordo());
        json.put("tara", rigo.getTara());
        json.put("taraPedana", taraPedana);
        json.put("pesoNetto", rigo.getPesoNetto());
        json.put("prezzo", rigo.getPrezzo());
        json.put("passaporto", rigo.getPassaporto());
        json.put("progressivo", rigo.getProgressivo());

        jsonArr.put(json);
    }   
    
//    int c = TracciabilitaSchedaLocalServiceUtil.getByAnnoIdAssociato(anno, numeroDocumento, a.getId()).size();
//
//    String disableTraceBTN = (c != 0) ? "" : "disabled";
    
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

<liferay-portlet:renderURL var="popupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/destinations.jsp" />
    <liferay-portlet:param name="codiceCliente" value="<%= cliente.getCodiceAnagrafica()%>" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="itemURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectItem.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="descrURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectDescription.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="packingURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectPack.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="carrier1URL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectcarrier.jsp" />
    <liferay-portlet:param name="carrier" value="1" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="carrier2URL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectcarrier.jsp"  />
    <liferay-portlet:param name="carrier" value="2" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="transportURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectTrasportCare.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="aspectURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectAspect.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="causalURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectCausal.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="portURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectPort.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="traceabilityURL">
    <liferay-portlet:param name="idAssociato"  value="<%= String.valueOf(a.getId())%>"/>
    <liferay-portlet:param name="jspPage"  value="/jsps/traceability.jsp"/>
</liferay-portlet:renderURL>
<portlet:resourceURL var="saveDDT"  id="modify"  />
<portlet:resourceURL var="printDDT" id="print" />
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <!--<button id="btnSearch"  class="btn" ><i class="icon-search"></i>Cerca</button>-->
            <button id="btnSave"    class="btn" onclick="SalvaDDT()" ><i class="icon-hdd"></i>Salva</button>
            <button id="btnPrint"   class="btn" ><i class="icon-print"></i>Stampa</button>
            <button id="btnTrace"   class="btn" <%--= disableTraceBTN --%>><i class="icon-list-alt" ></i>Scheda TracciabilitÃ Â </button>
            <!--<button id="btnInvoice" class="btn" disabled="true"><i class="icon-list-alt"></i>Genera Fattura</button>-->
        </div>
    </div>  
</aui:field-wrapper>

<aui:fieldset label="Testata Documento">
    <aui:layout>
        <aui:column columnWidth="70" cssClass="detail-column detail-column-first">
            <aui:input id="codiceClienteTxt" type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
            <aui:input id="clienteTxt" type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=cliente.getRagioneSociale()%>"/>
            <aui:input id="destinazioneTxt" type="text" name="destinazione" label="Destinazione diversa" cssClass="input-xxlarge" value="<%=indirizzo%>" inlineField="true"/>
            <aui:input id="codiceDestinazione" type="text" name="codiceDest" label="" inlineField="true" style="display: none" value="<%=testata.getCodiceDestinazione()%>"/>
            <aui:a href="#" onClick="restoreAdress()">Ripristina</aui:a><br/>
            <aui:input id="orderDate"    disabled="true" type="text" name="dataOrdine"   label="Data Documento" inlineField="true" value="<%= testata.getDataOrdine()%>"/>
            <aui:input id="deliveryDate" disabled="true" type="text" name="dataConsegna" label="Data Trasporto" inlineField="true" value="<%= testata.getDataConsegna()%>"/>
            <aui:input id="lottoTestata" disabled="true" type="text" name="lottoTestata" label="Lotto" cssClass="input-small" inlineField="true" value="<%= testata.getLotto()%>"/>

            <%--aui:input type="text" name="totPedane"    label="Tot. Pedane"     inlineField="true" cssClass="input-small"/>
            <aui:input type="text" name="Tot. Pesate"  label="Tot. Pesate"     inlineField="true" cssClass="input-small" /--%>
        </aui:column>
        <aui:column columnWidth="20" cssClass="test" last="true" >
            <%--aui:field-wrapper label="Ordine Finito"  >
                <aui:input type="radio" name="completoSi" label="Si" inlineLabel="true" checked="true" inlineField="true"/>
                <aui:input type="radio" name="completoNo" label="No" inlineLabel="true" inlineField="true"/>
            </aui:field-wrapper--%>

            <aui:input type="text" name="nDoc" label="N. Documento" style="width: 90%" value="<%= testata.getNumeroOrdine()%>" disabled="true"/>
            <%--aui:select label="Rec Protocollo" name="recProt" style="width: 90%; background-color: #FFFFCC;"> 
                <c:forEach items="<%= idToRecover%>" var="id">
                    <aui:option value="${id}">
                        ${id}
                    </aui:option>
                </c:forEach>
            </aui:select--%>
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
                        <aui:a id="btnAddDescription" cssClass="btn" href="#a"><i class="icon-plus"></i>Aggiungi Descrizione</aui:a>
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
                        <input type="text" class="input-small" id="codiceVettore1" readonly="true" style="display: none;" value="<%= (v1 != null) ? v1.getCodiceVettore() : ""%>"/>
                        <input id="vettore1" type="text" class="input-xxlarge" name="vettore1" placeholder="Seleziona vettore..." value="<%= (v1 != null) ? v1.getRagioneSociale() : ""%>"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="vettore2" class="control-label">Vettore 2: </label>
                    <div class="controls">
                        <input type="text" class="input-small" id="codiceVettore2" readonly="true" style="display: none;" value="<%= (v2 != null) ? v2.getCodiceVettore() : ""%>"/>
                        <input id="vettore2" type="text" class="input-xxlarge" name="vettore2" placeholder="Seleziona vettore..." value="<%= (v2 != null) ? v2.getRagioneSociale() : ""%>" />
                    </div>
                </div>
                <div class="control-group">
                    <label for="autista" class="control-label">Autista: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-xxlarge" id="autista" value="<%= testata.getAutista()%>"/>
                        <label for="telefono">Telefono: </label>
                        <input type="text" class="input-small" id="telefono" value="<%= testata.getTelefono()%>"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="trasporto" class="control-label">Trasporto a cura: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="trasporto" readonly="true" value="<%= curaTrasporto.getCodiceCuraTrasporto()%>"/>
                        <input type="text" class="input-xxlarge" id="trasportoTXT" placeholder="Seleziona..." value="<%= curaTrasporto.getDescrizione()%>" />
                        <aui:a href="#trasporto" onClick="restore('cura')">Ripristina</aui:a><br/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="aspetto" class="control-label">Aspetto esteriore: </label>
                        <div class="controls form-inline">
                            <input type="text" class="input-small" id="aspetto" readonly="true" value="<%= aspetto.getCodiceAspettoEsteriore()%>"/>
                        <input type="text" class="input-xxlarge" id="aspettoTXT" placeholder="Seleziona..." value="<%= aspetto.getDescrizione()%>" />
                        <aui:a href="#aspetto" onClick="restore('aspetto')">Ripristina</aui:a><br/>
                        </div>
                    </div>                
                    <div class="control-group">
                        <label for="causale" class="control-label">Causale trasporto: </label>
                        <div class="controls form-inline">
                            <input type="text" class="input-small" id="causale" readonly="true" value="<%= causale.getCodiceCausaleTrasporto()%>"/>
                        <input type="text" class="input-xxlarge" id="causaleTXT" placeholder="Seleziona..." value="<%= causale.getDescrizione()%>" />
                        <aui:a href="#causale" onClick="restore('causale')">Ripristina</aui:a><br/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="porto" class="control-label">Porto: </label>
                        <div class="controls form-inline">
                            <input type="text" class="input-small" id="porto" readonly="true" value="<%= porto.getCodicePorto()%>" />
                        <input type="text" class="input-xxlarge" id="portoTXT" placeholder="Seleziona..." value="<%= porto.getDescrizione()%>"/>
                        <aui:a href="#porto" onClick="restore('porto')">Ripristina</aui:a><br/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label for="origine" class="control-label">Origine: </label>
                        <div class="controls">
                            <input id="origine" type="text" class="input-xxlarge" name="origine" value="<%= testata.getOrigine()%>"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="rigo" class="control-label">Rigo descrittivo: </label>
                    <div class="controls">
                        <textarea class="form-control input-xxlarge" rows="3" id="rigo"><%= testata.getRigoDescrittivo()%></textarea>
                    </div>
                </div>
                <div class="control-group">
                    <label for="costo" class="control-label">Costo Trasporto: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="costo" value="<%= testata.getCostoTrasporto()%>">
                        <label for="pedane-euro">NÃÂ° Pedane Euro: </label>
                        <input type="text" class="input-small" id="pedane-euro" value="<%= testata.getNumeroPedaneEuro()%>"/>
                        <label for="pedane-normali">NÃÂ° Pedane Normali: </label>
                        <input type="text" class="input-small" id="pedane-normali" value="<%= testata.getNumeroPedaneNormali()%>"/>
                    </div>
                </div>
                <div class="control-group">
                    <label for="motrice" class="control-label">Targa Motrice: </label>
                    <div class="controls form-inline">
                        <input type="text" class="input-small" id="motrice" value="<%= testata.getTargaCamion()%>">
                        <label for="rimorchio">Targa rimorchio: </label>
                        <input type="text" class="input-small" id="rimorchio" value="<%= testata.getTargaRimorchio()%>"/>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

<script type="text/javascript">

    var variety = "<%= stringVarianti%>";

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
    YUI().use('node', function (Y) {
        Y.one('#<portlet:namespace/>clienteTxt').on('click', function () {
            document.getElementById('<portlet:namespace/>clienteTxt').blur();
        });
    });

    var indirizzo;

    function restoreAdress() {
        if (indirizzo) {
            console.log(indirizzo);
            document.getElementById('<portlet:namespace/>destinazioneTxt').value = indirizzo;
            document.getElementById('<portlet:namespace/>codiceDestinazione').value = "";
        }
    }

    function restore(field) {
        switch (field) {
            case 'cura':
                document.getElementById('trasporto').value = "<%= curaTrasporto.getCodiceCuraTrasporto()%>";
                document.getElementById('trasportoTXT').value = "<%= curaTrasporto.getDescrizione()%>";
                break;
            case 'aspetto':
                document.getElementById('aspetto').value = "<%= aspetto.getCodiceAspettoEsteriore()%>";
                document.getElementById('aspettoTXT').value = "<%= aspetto.getDescrizione()%>";
                break;
            case 'causale':
                document.getElementById('causale').value = "<%= causale.getCodiceCausaleTrasporto()%>";
                document.getElementById('causaleTXT').value = "<%= causale.getDescrizione()%>";
                break;
            case 'porto':
                document.getElementById('porto').value = "<%= porto.getCodicePorto()%>";
                document.getElementById('portoTXT').value = "<%= porto.getDescrizione()%>";
                break;
        }
    }

    YUI({lang: 'it'}).use('aui-datepicker', 'aui-modal', function (Y) {

        var orderDate = new Y.DatePicker({
            trigger: '#<portlet:namespace />orderDate',
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
//                    console.log(event.newSelection);
                }
            }
        });
        var deliveryDate = new Y.DatePicker({
            trigger: '#<portlet:namespace />deliveryDate',
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
//                    console.log(event.newSelection);
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
                    resizable: false
                            //                    height: '600px',
                            //                    width: '800px'
                },
                id: '<portlet:namespace/>dialog',
                title: 'Seleziona Destinazione',
                uri: '<%=popupURL%>'
            });
        });
    });

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#vettore1').on('click', function (event) {

            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false
                            //                    height: '600px',
                            //                    width: '800px'
                },
                id: '<portlet:namespace/>vettore1',
                title: 'Seleziona Vettore',
                uri: '<%=carrier1URL%>'
            });
        });
    });

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#vettore2').on('click', function (event) {

            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false
                            //                    height: '600px',
                            //                    width: '800px'
                },
                id: '<portlet:namespace/>vettore2',
                title: 'Seleziona Vettore',
                uri: '<%=carrier2URL%>'
            });
        });
    });

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#trasportoTXT').on('click', function (event) {

            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false
                            //                    height: '600px',
                            //                    width: '800px'
                },
                id: '<portlet:namespace/>curaTrasporto',
                title: 'Seleziona Trasporto',
                uri: '<%=transportURL%>'
            });
        });
    });

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#aspettoTXT').on('click', function (event) {

            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false
                            //                    height: '600px',
                            //                    width: '800px'
                },
                id: '<portlet:namespace/>aspettoEsteriore',
                title: 'Seleziona Apetto Beni',
                uri: '<%=aspectURL%>'
            });
        });
    });

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#causaleTXT').on('click', function (event) {

            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false
                            //                    height: '600px',
                            //                    width: '800px'
                },
                id: '<portlet:namespace/>causaleTrasporto',
                title: 'Seleziona Causale Trasporto',
                uri: '<%=causalURL%>'
            });
        });
    });

    YUI().use('liferay-util-window', function (Y) {
        Y.one('#portoTXT').on('click', function (event) {

            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    modal: true,
                    resizable: false
                            //                    height: '600px',
                            //                    width: '800px'
                },
                id: '<portlet:namespace/>porto',
                title: 'Seleziona Tipologia Porto',
                uri: '<%=portURL%>'
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
            case '<portlet:namespace/>itemDialog':
                setItem(data);
                break;
            case '<portlet:namespace/>DescriptionDialog':
                setDescription(data);
                break;
            case '<portlet:namespace/>packDialog':
                setPack(data);
                break;
            case '<portlet:namespace/>vettore1':
                setCarrier(1, data);
                break;
            case '<portlet:namespace/>vettore2':
                setCarrier(2, data);
                break;
            case '<portlet:namespace/>curaTrasporto':
                setTrasportCare(data);
                break;
            case '<portlet:namespace/>aspettoEsteriore':
                setAspect(data);
                break;
            case '<portlet:namespace/>causaleTrasporto':
                setCausal(data);
                break;
            case '<portlet:namespace/>porto':
                setPorto(data);
                break;
        }
    }, ['liferay-util-window']);

    var table;
    var recordSelected;
    var totale = 0;
    var pedaneNormali = 0;
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
                label: 'Descrizione'
            },
            {
                editor: new Y.DropDownCellEditor({
//                                editable: true,
                        options: variety.split("|")
                    }),
                key: 'descrizioneVariante',
                label: 'Varietà'
            },
            {
//                editor: nameEditor,
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
                editor: nameEditor,
                key: 'unitaMisura',
                label: 'Un.Mis.'
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
            }
//                {
//                    editor: nameEditor,
//                    key: 'codArtFornitore',
//                    label: 'Art. For.'
//                },
//            {
//                editor: nameEditor,
//                key: 'passaporto',
//                label: 'Passaporto'
//            },
//            {
//                editor: numberEditor,
//                key: 'progressivo',
//                label: 'Progr.'
//            }
        ];

        var data = <%= jsonArr%>;
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
                title: 'Seleziona Prodotto',
                uri: '<%=itemURL%>'
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
                uri: '<%=packingURL%>'
            });
        }, '#selectPack', table);

        //        table.after('*:pedaneChange', function (e) {
        //            console.log(e.newVal);
        //        });
        //        table.after('*:retiChange', function (e) {
        //            console.log(e.newVal);
        //        });

        table.after('*:pedaneChange', function (e) {
            calcola();
        });

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

//            table.before('*:prezzoChange', function (e) {
//                var record = recordSelected.getAttrs();
//                var prezzo = record.prezzo;
//                var tmp = totale - prezzo;
//                if (!isNaN(tmp))
//                    totale = tmp;
//                document.getElementById('costo').value = totale;
//            });
//            table.after('*:prezzoChange', function (e) {
//                var record = recordSelected.getAttrs();
//                var prezzo = record.prezzo;
//                totale = totale + prezzo;
//
//                document.getElementById('costo').value = totale;
//            });
//
//            table.before('*:pedaneChange', function (e) {
//                var record = recordSelected.getAttrs();
//                var pedane = record.pedane;
//                var tmp = pedaneNormali - pedane;
//                if (!isNaN(tmp))
//                    pedaneNormali = tmp;
//                document.getElementById('pedane-normali').value = pedaneNormali;
//            });
//            table.after('*:pedaneChange', function (e) {
//                var record = recordSelected.getAttrs();
//                var pedane = record.pedane;
//                pedaneNormali = pedaneNormali + pedane;
//
//                document.getElementById('pedane-normali').value = pedaneNormali;
//            });

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
//                recordSelected = undefined;
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
        } else if (record.reti || record.reti === 'si') {
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

            /******CAMPI TESTATA******/
            var codiceCliente = Y.one('#<portlet:namespace />codiceClienteTxt').val();
            var clienteTxt = Y.one('#<portlet:namespace />clienteTxt').val();
            var destinazioneTxt = Y.one('#<portlet:namespace />destinazioneTxt').val();
            var codiceDestinazione = Y.one('#<portlet:namespace />codiceDestinazione').val();
            var orderDate = Y.one('#<portlet:namespace />orderDate').val();
            var deliveryDate = Y.one('#<portlet:namespace />deliveryDate').val();
            var lottoTestata = Y.one('#<portlet:namespace />lottoTestata').val();

            /******CAMPI FINE CORPO******/
            var vettore1 = Y.one('#codiceVettore1').val();
            var vettore2 = Y.one('#codiceVettore1').val();
            var autista = Y.one('#autista').val();
            var telefono = Y.one('#telefono').val();
            var trasporto = Y.one('#trasporto').val();
            var aspetto = Y.one('#aspetto').val();
            var causale = Y.one('#causale').val();
            var porto = Y.one('#porto').val();
            var origine = Y.one('#origine').val();
            var rigo = Y.one('#rigo').val();
            var costo = Y.one('#costo').val();
            var pedane_euro = Y.one('#pedane-euro').val();
            var pedane_normali = Y.one('#pedane-normali').val();
            var motrice = Y.one('#motrice').val();
            var rimorchio = Y.one('#rimorchio').val();
            var numeroOrdine = Y.one('#<portlet:namespace/>nDoc').val();

            var queryString = "&<portlet:namespace/>codiceCliente=" + codiceCliente +
                    "&<portlet:namespace/>clienteTxt=" + clienteTxt + "&<portlet:namespace/>destinazioneTxt=" + destinazioneTxt +
                    "&<portlet:namespace/>codiceDestinazione=" + codiceDestinazione + "&<portlet:namespace/>orderDate=" + orderDate +
                    "&<portlet:namespace/>deliveryDate=" + deliveryDate + "&<portlet:namespace/>lottoTestata=" + lottoTestata +
                    "&<portlet:namespace/>vettore1=" + vettore1 + "&<portlet:namespace/>vettore2=" + vettore2 +
                    "&<portlet:namespace/>autista=" + autista + "&<portlet:namespace/>telefono=" + telefono +
                    "&<portlet:namespace/>trasporto=" + trasporto + "&<portlet:namespace/>aspetto=" + aspetto +
                    "&<portlet:namespace/>causale=" + causale + "&<portlet:namespace/>porto=" + porto +
                    "&<portlet:namespace/>origine=" + origine + "&<portlet:namespace/>rigo=" + rigo +
                    "&<portlet:namespace/>costo=" + costo + "&<portlet:namespace/>pedane-euro=" + pedane_euro +
                    "&<portlet:namespace/>pedane-normali=" + pedane_normali + "&<portlet:namespace/>motrice=" + motrice +
                    "&<portlet:namespace/>rimorchio=" + rimorchio + "&<portlet:namespace/>numeroOrdine=" + numeroOrdine;
            //        Y.one('#btnSave').on('click', function () {
            Y.io.request(
                    '${saveDDT}' + queryString + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(data)),
                    {
                        on: {
                            success: function () {
                                var data = JSON.parse(this.get('responseData'));
                                if (data.code === 0) {
                                    alert("Salvataggio effettuato con successo.");
                                    document.getElementById("btnPrint").disabled = false;
                                    document.getElementById("btnSave").disabled = true;
                                    document.getElementById("btnTrace").disabled = false;
                                    console.log("1: " + Y.one('#<portlet:namespace/>recProt').val());
                                } else {
                                    console.log(data)
                                    switch (data.code) {
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 7:
                                            alert("Errore durante il salvataggio dei dati.\n" + JSON.stringify(data));
                                            break;
                                        case 4:
                                            alert("Salvataggio effettuato con successo.");
                                            document.getElementById("btnPrint").disabled = false;
                                            document.getElementById("btnSave").disabled = true;
                                            document.getElementById("btnTrace").disabled = false;
                                            console.log("1: " + Y.one('#<portlet:namespace/>recProt').val());
                                            alert("Attenzione, non ÃÂ¨ stato possibile invare la mail di notifica.\n");
                                            break;
                                        case 5:
                                            alert("Attenzione, il numero di protocollo: " + data.id + " ÃÂ¨ giÃÂ  presente in archivio.\n");
                                            break;
                                        case 6:
                                            alert("Attenzione, esiste almeno un numero di protocollo maggiore di " + data.id + " con una data precedente a: " + orderDate + ".");
                                            break;
                                    }
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

            var win = window.open('${printDDT}' + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />update=' + true + '&<portlet:namespace />send=' + true, '_blank');
            win.focus();

        });
    });

    function SalvaDDT() {
        var stringOrderDate = document.getElementById('<portlet:namespace/>orderDate').value;
        var orderDateSplitted = stringOrderDate.split("/");
        var orderDate = new Date(orderDateSplitted[2], orderDateSplitted[1], orderDateSplitted[0]);

        var stringDeliveryDate = document.getElementById('<portlet:namespace/>deliveryDate').value;
        var deliveryDateSplitted = stringDeliveryDate.split("/");
        var deliveryDate = new Date(deliveryDateSplitted[2], deliveryDateSplitted[1], deliveryDateSplitted[0]);


        if (deliveryDate >= orderDate) {
            var rows = [];
            for (var i = 0; i < table.data.size(); i++) {
                rows[i] = table.data.item(i).toJSON();
            }
            console.log(rows);

            if (rows.length !== 0)
                sendData(rows);
            else
                alert("Attenzione inserire almeno un rigo nel documento.");
        } else {
            alert("Attenzione inserire una data di trasporto almeno uguale alla data del documento.");
        }
    }

    function setItem(data) {
        var tmp = data.split('|');

        console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2]});
            recordSelected = undefined;
        } else {
            table.addRow({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2], lotto: document.getElementById('<portlet:namespace/>lottoTestata').value, pedane: 1, unitaMisura: tmp[3]}, {sync: true});
        }
    }

    function setDescription(data) {
//            console.log(recordSelected);
        if (recordSelected) {
            recordSelected.setAttrs({descrizione: data, imballo: " "});
            recordSelected = undefined;
        } else {
            table.addRow({descrizione: data, imballo: " "}, {sync: true});
        }
    }

    function setPack(data) {
        if (recordSelected) {
            recordSelected.setAttrs({imballo: data});
            recordSelected = undefined;
        }
    }
    function setCarrier(i, data) {
        var tmp = data.split('|');

        if (i === 1) {
            document.getElementById('codiceVettore1').value = tmp[0];
            document.getElementById('vettore1').value = tmp[1];
        } else if (i === 2) {
            document.getElementById('codiceVettore2').value = tmp[0];
            document.getElementById('vettore2').value = tmp[1];
        }
    }

    function setTrasportCare(data) {
        var tmp = data.split('|');

        document.getElementById('trasporto').value = tmp[0];
        document.getElementById('trasportoTXT').value = tmp[1];
    }

    function setAspect(data) {
        var tmp = data.split('|');

        document.getElementById('aspetto').value = tmp[0];
        document.getElementById('aspettoTXT').value = tmp[1];
    }

    function setCausal(data) {
        var tmp = data.split('|');

        document.getElementById('causale').value = tmp[0];
        document.getElementById('causaleTXT').value = tmp[1];
    }

    function setPorto(data) {
        var tmp = data.split('|');

        document.getElementById('porto').value = tmp[0];
        document.getElementById('portoTXT').value = tmp[1];
    }

    function calcolaLotto() {
        var d;
        if (date)
            d = new Date(Date.parse(date));
        else
            d = new Date();
        var anno = d.getFullYear().toString().substr(2, 2);
        var juldate = String(d.getDOY());

        return "L-" + anno + juldate;
    }

    Date.prototype.getDOY = function () {
        var onejan = new Date(this.getFullYear(), 0, 1);
        return Math.ceil((this - onejan) / 86400000);
    };

    YUI().use('node', function (Y) {
        Y.one('#btnTrace').on('click', function () {
            window.location.href = '<%=traceabilityURL%>'.toString() + '&<portlet:namespace/>numeroDocumento=' + document.getElementById('<portlet:namespace/>nDoc').value;
        });
    });
</script>