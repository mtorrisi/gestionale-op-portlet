<%@page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserIdMapper"%>
<%@page import="it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.OrganizzazioneProduttori"%>
<%@page import="it.its.ct.gestionaleOP.utils.Constants"%>
<%@page import="it.bysoftware.ct.model.DescrizioniVarianti"%>
<%@page import="it.bysoftware.ct.service.DescrizioniVariantiLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.bysoftware.ct.service.ProgressivoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Progressivo"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DescrizioniDocumenti"%>
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
<%@page import="it.bysoftware.ct.service.AspettoEsterioreBeniLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.AspettoEsterioreBeniServiceUtil"%>
<%@page import="it.bysoftware.ct.service.CausaleTrasportoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.CuraTrasportoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.PortoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.AspettoEsterioreBeni"%>
<%@page import="it.bysoftware.ct.model.CausaleTrasporto"%>
<%@page import="it.bysoftware.ct.model.CuraTrasporto"%>
<%@page import="it.bysoftware.ct.model.Porto"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="../init.jsp" %>

<%
    List<DescrizioniVarianti> varianti = DescrizioniVariantiLocalServiceUtil.getVarianti();
    String stringVarianti = "";
    for (int i = 0; i < varianti.size(); i++) {
        if (i == varianti.size() - 1) {
            stringVarianti += varianti.get(i).getCodiceVariante() + " - " + varianti.get(i).getDescrizioneVariante();
        } else {
            stringVarianti += varianti.get(i).getCodiceVariante() + " - " + varianti.get(i).getDescrizioneVariante() + "|";
        }
    }

    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
    //    request.setAttribute("destinazioni", destinazioni);

    CuraTrasporto curaTrasportoDefault = CuraTrasportoLocalServiceUtil.getCuraTrasporto("VET");
    AspettoEsterioreBeni aspettoDefault = AspettoEsterioreBeniLocalServiceUtil.getAspettoEsterioreBeni("VIS");
    CausaleTrasporto causaleDefault = CausaleTrasportoLocalServiceUtil.getCausaleTrasporto("VEN");
    Porto portoDefault = PortoLocalServiceUtil.getPorto("001");
    UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(Long.parseLong(renderRequest.getRemoteUser()), Constants.FUTURO_NET);
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper.getUserIdMapperId());
    OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
    List<Progressivo> listProgressivo = ProgressivoLocalServiceUtil.getByAnnoIdAssociatoTipoDocumento(Calendar.getInstance().get(Calendar.YEAR), a.getId(), Constants.DDT_ID);

    ArrayList<Integer> idToRecover = new ArrayList<Integer>();

    for (Progressivo p : listProgressivo) {
        idToRecover.add(p.getNumeroProgressivo());
    }

    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>

<liferay-portlet:renderURL var="popupURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/destinations.jsp" />
    <liferay-portlet:param name="codiceCliente" value="<%= cliente.getCodiceAnagrafica() %>" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="itemURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectItem.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="descrURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectDescription.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="packingURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectPack.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="carrier1URL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectcarrier.jsp" />
    <liferay-portlet:param name="carrier" value="1" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="carrier2URL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectcarrier.jsp"  />
    <liferay-portlet:param name="carrier" value="2" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="transportURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectTrasportCare.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="aspectURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectAspect.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="causalURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectCausal.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="portURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
    <liferay-portlet:param name="mvcPath" value="/jsps/selectPort.jsp"  />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="searchDDTURL">
    <liferay-portlet:param name="filter" value="<%= String.valueOf(cliente.getCodiceAnagrafica().equals(String.valueOf(op.getIdLiferay()))) %>" />
    <liferay-portlet:param name="codiceCliente"  value="<%= cliente.getCodiceAnagrafica() %>" />
    <liferay-portlet:param name="update" value="true" />
    <liferay-portlet:param name="jspPage"  value="/jsps/search-ddt.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="traceabilityURL">
    <liferay-portlet:param name="idAssociato"  value="<%= String.valueOf(a.getId()) %>" />
    <liferay-portlet:param name="jspPage"  value="/jsps/traceability.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="cmrURL">
    <liferay-portlet:param name="codiceCliente"  value="<%= cliente.getCodiceAnagrafica() %>" />
    <liferay-portlet:param name="idAssociato"  value="<%= String.valueOf(a.getId()) %>" />
    <liferay-portlet:param name="jspPage"  value="/jsps/edit-cmr.jsp" />
</liferay-portlet:renderURL>
<portlet:resourceURL id="save"  var="saveDDT"  />
<portlet:resourceURL id="print" var="printDDT" />
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <button class="btn"  id="btnSearch"><i class="icon-search"></i>&nbsp;Cerca</button>
            <button class="btn"    id="btnSave" onclick="SalvaDDT()"><i class="icon-hdd"></i>&nbsp;Salva</button>
            <button class="btn"   disabled="true" id="btnPrint"><i class="icon-print"></i>&nbsp;Stampa</button>
            <button class="btn"   disabled="true" id="btnTrace"><i class="icon-list-alt"></i>&nbsp;Scheda Tracciabilit&agrave;</button>
            <button class="btn"     disabled="true" id="btnCMR"><i class="icon-list-alt"></i>&nbsp;CMR</button>
        </div>
    </div>
</aui:field-wrapper>

<aui:fieldset label="Compila DDT">
    <aui:layout>
        <aui:column columnWidth="70" cssClass="detail-column detail-column-first">
            <aui:input cssClass="input-small" disabled="true" id="codiceClienteTxt" inlineField="true" label="Codice Cliente" name="codCliente" type="text" value="<%= cliente.getCodiceAnagrafica() %>" />
            <aui:input cssClass="input-xxlarge" id="clienteTxt" inlineField="true" label="Cliente" name="cliente" type="text" value="<%= cliente.getRagioneSociale() %>" />
            <aui:input cssClass="input-xxlarge" id="destinazioneTxt" inlineField="true" label="Destinazione diversa" name="destinazione" type="text" value="<%= cliente.getIndirizzo() %>" />
            <aui:input id="codiceDestinazione" inlineField="true" label="" name="codiceDest" style="display: none" type="text" />
            <aui:a href="#" onClick="restoreAdress()">Ripristina</aui:a><br />
            <aui:input id="orderDate"    inlineField="true" label="Data Documento"   name="dataOrdine" type="text" value="<%= sdf.format(date) %>" />
            <aui:input id="deliveryDate" inlineField="true" label="Data Trasporto" name="dataConsegna" type="text" value="<%= sdf.format(date) %>" />
            <aui:input cssClass="input-small" id="lottoTestata" inlineField="true" label="Lotto" name="lottoTestata" type="text" />

            <%--aui:input type="text" name="totPedane"    label="Tot. Pedane"     inlineField="true" cssClass="input-small" />
            <aui:input cssClass="input-small" inlineField="true"  label="Tot. Pesate"     name="Tot. Pesate" type="text" /--%>
        </aui:column>
        <aui:column columnWidth="20" cssClass="test" last="true">
            <%--aui:field-wrapper label="Ordine Finito"  >
                <aui:input checked="true" inlineField="true" inlineLabel="true" label="Si" name="completoSi" type="radio" />
                <aui:input inlineField="true" inlineLabel="true" label="No" name="completoNo" type="radio" />
            </aui:field-wrapper--%>

            <aui:input label="N. Documento" name="nDoc" style="width: 90%" type="text" />
            <aui:select label="Rec Protocollo" name="recProt" style="width: 90%; background-color: #FFFFCC;">
                <c:forEach items="<%= idToRecover %>" var="id">
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
        <li class="active"><a href="#tab-1">Corpo Documento</a></li>
        <li><a href="#tab-2">Fine Corpo</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane" id="tab-1">
            <aui:field-wrapper >
                <div class="btn-toolbar">
                    <div class="btn-group">
                        <aui:a cssClass="btn" href="#a" id="btnAdd"><i class="icon-plus"></i>Aggiungi</aui:a>
                        <aui:a cssClass="btn" href="#a" id="btnAddDescription"><i class="icon-plus"></i>Aggiungi Descrizione</aui:a>
                        <aui:a cssClass="btn" href="#a" id="btnRemove"><i class="icon-trash"></i>Rimuovi</aui:a>
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
                    <label class="control-label" for="vettore1">Vettore 1: </label>
                    <div class="controls">
                        <input class="input-small" id="codiceVettore1" readonly="true" style="display: none;" type="text" />
                        <input class="input-xxlarge" id="vettore1" name="vettore1" placeholder="Seleziona vettore..." type="text" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="vettore2">Vettore 2: </label>
                    <div class="controls">
                        <input class="input-small" id="codiceVettore2" readonly="true" style="display: none;" type="text" />
                        <input class="input-xxlarge" id="vettore2" name="vettore2" placeholder="Seleziona vettore..." type="text" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="autista">Autista: </label>
                    <div class="controls form-inline">
                        <input class="input-xxlarge" id="autista" type="text" />
                        <label for="telefono">Telefono: </label>
                        <input class="input-small" id="telefono" type="text" />
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="trasporto">Trasporto a cura: </label>
                    <div class="controls form-inline">
                        <input class="input-small" id="trasporto" readonly="true" type="text" value="<%= curaTrasportoDefault.getCodiceCuraTrasporto() %>" />
                        <input class="input-xxlarge" id="trasportoTXT" placeholder="Seleziona..." type="text" value="<%= curaTrasportoDefault.getDescrizione() %>" />
                        <aui:a href="#trasporto" onClick="restore('cura')">Ripristina</aui:a><br />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="aspetto">Aspetto esteriore: </label>
                        <div class="controls form-inline">
                            <input class="input-small" id="aspetto" readonly="true" type="text" value="<%= aspettoDefault.getCodiceAspettoEsteriore() %>" />
                            <input class="input-xxlarge" id="aspettoTXT" placeholder="Seleziona..." type="text" value="<%= aspettoDefault.getDescrizione() %>" />
                            <aui:a href="#aspetto" onClick="restore('aspetto')">Ripristina</aui:a><br />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="causale">Causale trasporto: </label>
                           <div class="controls form-inline">
                            <input class="input-small" id="causale" readonly="true" type="text" value="<%= causaleDefault.getCodiceCausaleTrasporto() %>" />
                        <input class="input-xxlarge" id="causaleTXT" placeholder="Seleziona..." type="text" value="<%= causaleDefault.getDescrizione() %>" />
                        <aui:a href="#causale" onClick="restore('causale')">Ripristina</aui:a><br />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="porto">Porto: </label>
                        <div class="controls form-inline">
                            <input class="input-small" id="porto" readonly="true" type="text" value="<%= portoDefault.getCodicePorto() %>" />
                        <input class="input-xxlarge" id="portoTXT" placeholder="Seleziona..." type="text" value="<%= portoDefault.getDescrizione() %>" />
                        <aui:a href="#porto" onClick="restore('porto')">Ripristina</aui:a><br />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="origine">Origine: </label>
                        <div class="controls">
                            <input class="input-xxlarge" id="origine" name="origine" type="text" value="Italia - Calabria" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="rigo">Rigo descrittivo: </label>
                        <div class="controls">
                            <textarea class="form-control input-xxlarge" id="rigo" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="costo">Costo Trasporto: </label>
                        <div class="controls form-inline">
                            <input class="input-small" id="costo" type="text">
                            <label for="pedane_euro">N. Pedane Euro: </label>
                            <input class="input-small" id="pedane_euro" type="text" />
                            <label for="pedane_normali">N. Pedane Normali: </label>
                            <input class="input-small" id="pedane_normali" type="text" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="motrice">Targa Motrice: </label>
                        <div class="controls form-inline">
                            <input class="input-small" id="motrice" type="text">
                            <label for="rimorchio">Targa rimorchio: </label>
                            <input class="input-small" id="rimorchio" type="text" />
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>

    <script type="text/javascript">
//        window.onbeforeunload = function() {
//            return "";
//        };

        var ERRORS = ["OK", "GET_PRIMARY_KEY_ERROR", "INSERT_ERROR", "PARSING_JSON_ERROR", "SENDING_MAIL_ERROR", "ALREADY_EXISTS", "NOT_VALID", "DATE_FORMAT_ERROR"];

    	var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1;
		var yyyy = today.getFullYear();
		var todayDateInDDMMYYYY = dd + '/' + mm + '/' + yyyy;

		var variety = "<%= stringVarianti %>";
		YUI().use('node', function(Y) {
			Y.one('#<portlet:namespace/>lottoTestata').set('value', calcolaLotto(today));
		});

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
					document.getElementById('trasporto').value = "<%= curaTrasportoDefault.getCodiceCuraTrasporto() %>";
					document.getElementById('trasportoTXT').value = "<%= curaTrasportoDefault.getDescrizione() %>";
					break;
				case 'aspetto':
					document.getElementById('aspetto').value = "<%= aspettoDefault.getCodiceAspettoEsteriore() %>";
					document.getElementById('aspettoTXT').value = "<%= aspettoDefault.getDescrizione() %>";
					break;
				case 'causale':
					document.getElementById('causale').value = "<%= causaleDefault.getCodiceCausaleTrasporto() %>";
					document.getElementById('causaleTXT').value = "<%= causaleDefault.getDescrizione() %>";
					break;
				case 'porto':
					document.getElementById('porto').value = "<%= portoDefault.getCodicePorto() %>";
					document.getElementById('portoTXT').value = "<%= portoDefault.getDescrizione() %>";
					break;
			}
		}

		YUI({lang: 'it'}).use('aui-datepicker', 'aui-modal', function(Y) {

			var orderDate = new Y.DatePicker({
				trigger: '#<portlet:namespace />orderDate',
				mask: '%d/%m/%Y',
				calendar: {
					minDate: todayDateInDDMMYYYY
				},
				popover: {
					position: 'top',
					toolbars: {
						header: [[
								{
									icon: 'icon-trash',
									label: 'Cancella',
									on: {
										click: function() {
											orderDate.clearSelection();
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
						document.getElementById('<portlet:namespace/>lottoTestata').value = calcolaLotto(event.newSelection[0]);
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
										click: function() {
											deliveryDate.clearSelection();
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

		YUI().use('liferay-util-window', function(Y) {
			Y.one('#vettore1').on('click', function(event) {

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
					uri: '<%= carrier1URL %>'
				});
			});
		});

		YUI().use('liferay-util-window', function(Y) {
			Y.one('#vettore2').on('click', function(event) {

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
					uri: '<%= carrier2URL %>'
				});
			});
		});

		YUI().use('liferay-util-window', function(Y) {
			Y.one('#trasportoTXT').on('click', function(event) {

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
					uri: '<%= transportURL %>'
				});
			});
		});

		YUI().use('liferay-util-window', function(Y) {
			Y.one('#aspettoTXT').on('click', function(event) {

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
					uri: '<%= aspectURL %>'
				});
			});
		});

		YUI().use('liferay-util-window', function(Y) {
			Y.one('#causaleTXT').on('click', function(event) {

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
					uri: '<%= causalURL %>'
				});
			});
		});

		YUI().use('liferay-util-window', function(Y) {
			Y.one('#portoTXT').on('click', function(event) {

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
					uri: '<%= portURL %>'
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

//            var variety = '<%= stringVarianti %>';
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
					key: 'descrizione',
					editor: nameEditor,
					label: 'Descrizione'
				},
				{
					editor: new Y.DropDownCellEditor({
//                                editable: true,
						options: variety.split("|")
					}),
					key: 'descrizioneVariante',
					label: 'Varieta\''
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
					editor: nameEditor,
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
//                {
//                    editor: nameEditor,
//                    key: 'passaporto',
//                    label: 'Passaporto'
//                }
//                {
//                    visible: false,
//                    editor: numberEditor,
//                    key: 'progressivo',
//                    label: 'Progr.'
//                }
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
			table.delegate('dblclick', function(e) {
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
					uri: '<%= itemURL %>'
				});

			}, 'tr', table);

			table.delegate('click', function(e) {
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

			//        table.after('*:pedaneChange', function(e) {
			//            console.log(e.newVal);
			//        });
			//        table.after('*:retiChange', function(e) {
			//            console.log(e.newVal);
			//        });

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
			table.after('*:descrizioneVarianteChange', function(e) {
				console.log(e.newVal.split("-")[0].trim());
			});

//            table.before('*:prezzoChange', function(e) {
//                var record = recordSelected.getAttrs();
//                var prezzo = record.prezzo;
//                var tmp = totale - prezzo;
//                if (!isNaN(tmp))
//                    totale = tmp;
//                document.getElementById('costo').value = totale;
//            });
//            table.after('*:prezzoChange', function(e) {
//                var record = recordSelected.getAttrs();
//                var prezzo = record.prezzo;
//                totale = totale + prezzo;
//
//                document.getElementById('costo').value = totale;
//            });
//
//            table.before('*:pedaneChange', function(e) {
//                var record = recordSelected.getAttrs();
//                var pedane = record.pedane;
//                var tmp = pedaneNormali - pedane;
//                if (!isNaN(tmp))
//                    pedaneNormali = tmp;
//                document.getElementById('pedane-normali').value = pedaneNormali;
//            });
//            table.after('*:pedaneChange', function(e) {
//                var record = recordSelected.getAttrs();
//                var pedane = record.pedane;
//                pedaneNormali = pedaneNormali + pedane;
//
//                document.getElementById('pedane-normali').value = pedaneNormali;
//            });

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
				table.removeRow(recordSelected);
//                recordSelected = undefined;
			});


			function process() {

				var ml = table.data,
						msg = '',
						template = 'Record index = {index} Data = {codiceArticolo} : {descrizione}\n';

				ml.each(function(item, i) {
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
				table.addRow({codiceArticolo: tmp[0], descrizione: tmp[1], tara: tmp[2], lotto: document.getElementById('<portlet:namespace/>lottoTestata').value, pedane: 1, unitaMisura: tmp[3], taraPedana: 0.0}, {sync: true});
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

		function sendData(data) { //loadURL + "&" + portletNamespace + "file=" + file + ""
			//        console.log('${saveDDT}' + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(data)));
			YUI().use('aui-io-request', 'node', function(Y) {

				/******CAMPI TESTATA******/
				var codiceCliente = Y.one('#<portlet:namespace />codiceClienteTxt').val();
				var clienteTxt = Y.one('#<portlet:namespace />clienteTxt').val();
				var destinazioneTxt = Y.one('#<portlet:namespace />destinazioneTxt').val();
				var codiceDestinazione = Y.one('#<portlet:namespace />codiceDestinazione').val();
				var orderDate = Y.one('#<portlet:namespace />orderDate').val();
				var deliveryDate = Y.one('#<portlet:namespace />deliveryDate').val();
				var lottoTestata = Y.one('#<portlet:namespace />lottoTestata').val();
				var numeroOrdine = Y.one('#<portlet:namespace/>recProt').val();
				var avanzaProtocollo = Y.one('#<portlet:namespace/>nDoc').val();

				/******CAMPI FINE CORPO******/
				var vettore1 = Y.one('#codiceVettore1').val();
				var vettore2 = Y.one('#codiceVettore2').val();
				var autista = Y.one('#autista').val();
				var telefono = Y.one('#telefono').val();
				var trasporto = Y.one('#trasporto').val();
				var aspetto = Y.one('#aspetto').val();
				var causale = Y.one('#causale').val();
				var porto = Y.one('#porto').val();
				var origine = Y.one('#origine').val();
				var rigo = Y.one('#rigo').val();
				var costo = Y.one('#costo').val();
				var pedane_euro = Y.one('#pedane_euro').val();
				var pedane_normali = Y.one('#pedane_normali').val();
				var motrice = Y.one('#motrice').val();
				var rimorchio = Y.one('#rimorchio').val();

				Y.io.request('${saveDDT}', {
					method: 'POST',
	                data: {
	                    <portlet:namespace />codiceCliente: codiceCliente,
	                    <portlet:namespace />clienteTxt: clienteTxt,
	                    <portlet:namespace />destinazioneTxt: destinazioneTxt,
	                    <portlet:namespace />codiceDestinazione: codiceDestinazione,
	                    <portlet:namespace />orderDate: orderDate,
	                    <portlet:namespace />deliveryDate: deliveryDate,
	                    <portlet:namespace />lottoTestata: lottoTestata,
	                    <portlet:namespace />vettore1: vettore1,
	                    <portlet:namespace />vettore2: vettore2,
	                    <portlet:namespace />autista: autista,
	                    <portlet:namespace />telefono: telefono,
	                    <portlet:namespace />trasporto: trasporto,
	                    <portlet:namespace />aspetto: aspetto,
	                    <portlet:namespace />causale: causale,
	                    <portlet:namespace />porto: porto,
	                    <portlet:namespace />origine: origine,
	                    <portlet:namespace />rigo: rigo,
	                    <portlet:namespace />costo: costo,
	                    <portlet:namespace />pedane_euro: pedane_euro,
	                    <portlet:namespace />pedane_normali: pedane_normali,
	                    <portlet:namespace />motrice: motrice,
	                    <portlet:namespace />rimorchio: rimorchio,
	                    <portlet:namespace/>numeroOrdine: numeroOrdine,
	                    <portlet:namespace/>avanzaProtocollo: avanzaProtocollo,
	                    <portlet:namespace />data: window.btoa(JSON.stringify(data))
	                },
					on: {
						success: function() {
							var data = JSON.parse(this.get('responseData'));
							if (data.code === 0) {
								alert("Salvataggio effettuato con successo.");
								Y.one('#<portlet:namespace/>nDoc').set('value', data.id);
								document.getElementById("btnPrint").disabled = false;
								document.getElementById("btnSave").disabled = true;
								document.getElementById("btnTrace").disabled = false;
								document.getElementById("btnCMR").disabled = false;
								if (Y.one('#<portlet:namespace/>recProt').val() !== "") {
//                                            console.log("1: " + Y.one('#<portlet:namespace/>recProt').val());
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
										document.getElementById("btnSave").disabled = true;
										document.getElementById("btnTrace").disabled = false;
										document.getElementById("btnCMR").disabled = false;
										if (Y.one('#<portlet:namespace/>recProt').val() !== "") {
//                                            console.log("1: " + Y.one('#<portlet:namespace/>recProt').val());
											document.getElementById('<portlet:namespace/>recProt').value = "";
										}
										alert("Attenzione, non e' stato possibile invare la mail di notifica.\n");
										break;
									case 5:
										alert("Attenzione, il numero di protocollo: " + data.id + " e' presente in archivio.\n");
										break;
									case 6:
										alert("Attenzione, esiste almeno un numero di protocollo maggiore di " + data.id + " con una data precedente a: " + orderDate + ".");
										break;
									case 9:
										alert("Attenzione, non e' stato possibile salvare il DDT, e' necessario specificare il numero di protocollo da assegnare.");
										break;
									case 10:
										alert("Attenzione, non e' stato possibile salvare il DDT, esiste almeno un documento con protocollo minore di: " + data.id + " e data maggiore di: " + orderDate);
										break;
								}
							}
						},
						error: function() {
							alert("Errore durante il salvataggio dei dati.");
						}
					}
				});
			});
		}

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
					if (table.data.item(i).toJSON().codiceArticolo !== '' && table.data.item(i).toJSON().imballo === '') {
						console.log("Manca imballo alla riga: " + (i + 1));
						alert("Impossibile procedere al salvataggio.\nManca imballo alla riga: " + (i + 1));
						return;
					}
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

		YUI().use('aui-io-request', 'node', function(Y) {
			Y.one('#btnPrint').on('click', function() {
				var nDoc = Y.one('#<portlet:namespace/>nDoc').val();
				var orderDate = Y.one('#<portlet:namespace/>orderDate').val();
				var codiceCliente = Y.one('#<portlet:namespace/>codiceClienteTxt').val();
				var tmp = orderDate.split("/");
				var year;
				if (tmp.length == 3) {
					year = tmp[2];
				}
				var win = window.open('${printDDT}' + '&<portlet:namespace />year=' + year + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />codiceCliente=' + codiceCliente + '&<portlet:namespace />update=' + false + '&<portlet:namespace />send=' + false, '_blank');
				win.focus();
			});
		});

		YUI().use('node', function(Y) {
			Y.one('#btnSearch').on('click', function() {
				window.location.href = '<%= searchDDTURL %>'.toString();
			});
		});

		YUI().use('node', function(Y) {
			Y.one('#btnTrace').on('click', function() {
				window.location.href = '<%= traceabilityURL %>'.toString() + '&<portlet:namespace/>numeroDocumento=' + document.getElementById('<portlet:namespace/>nDoc').value;
			});
		});

		YUI().use('node', function(Y) {
			Y.one('#btnCMR').on('click', function() {
				window.location.href = '<%= cmrURL %>'.toString() + '&<portlet:namespace/>numeroDocumento=' + document.getElementById('<portlet:namespace/>nDoc').value;
			});
		});

</script>