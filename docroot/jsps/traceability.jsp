<%@page import="java.util.ArrayList"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.service.persistence.TestataDocumentoPK"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.bysoftware.ct.service.RigoDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.RigoDocumento"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@include file="../init.jsp" %>


<%
    long idAssociato = Long.parseLong(ParamUtil.getString(renderRequest, "idAssociato"));
    long numeroDocumento = Long.parseLong(ParamUtil.getString(renderRequest, "numeroDocumento"));

    Associato a = AssociatoLocalServiceUtil.fetchAssociato(idAssociato);
    TestataDocumento testata = TestataDocumentoLocalServiceUtil.fetchTestataDocumento(new TestataDocumentoPK(Calendar.getInstance().get(Calendar.YEAR), numeroDocumento, "DDT", idAssociato));
    List<RigoDocumento> prodotti = RigoDocumentoLocalServiceUtil.getDDTByNumeroOrdineAnnoAssociato(numeroDocumento, Calendar.getInstance().get(Calendar.YEAR), idAssociato);
    List<RigoDocumento> tmpProdotti = new ArrayList<RigoDocumento>();
    for(RigoDocumento r : prodotti){
        if(r.getCodiceArticolo()!= "")
            tmpProdotti.add(r);
        else
            System.out.println("**** SUERPIPPO ****");
    }
    prodotti = tmpProdotti;
    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(testata.getCodiceSoggetto());
    int index = 0;
%>

<portlet:resourceURL var="saveScheda"  id="saveTrace"  />
<portlet:resourceURL var="printScheda" id="printTrace" />
<div id="contentview">
    <aui:field-wrapper >
        <div class="btn-toolbar">
            <div class="btn-group">
                <button id="btnSave"    class="btn" ><i class="icon-hdd"></i>Salva</button>
                <button id="btnPrint"   class="btn" disabled="true" ><i class="icon-print"></i>Stampa</button>
            </div>
        </div>  
    </aui:field-wrapper>

    <fieldset>
        <legend>Allegato tracciabilità</legend>
        <aui:form name="fm2" action="" method="post">
            <aui:input id="nDoc" type="text" name="nDoc" label="N° documento" cssClass="input-small" disabled="true" inlineField="true" value="<%= numeroDocumento%>"/>
            <aui:input id="dataDoc" type="text" name="dataDoc" label="Data documento" cssClass="input-large" disabled="true" inlineField="true" value="<%= testata.getDataOrdine()%>" />
            <aui:input id="cliente" type="text" name="cliete" label="Cliente" cssClass="input-xxlarge" disabled="true" inlineField="true" value="<%= cliente.getRagioneSociale()%>"/>

            <c:forEach var="i" begin="1" end="<%= prodotti.size()%>">
                <%  String collapsed = "collapsed";%> 
                <c:if test="${i eq 1}">
                    <% collapsed = "open";%>
                </c:if>
                <liferay-ui:panel-container extended="true" >
                    <liferay-ui:panel title="<%= prodotti.get(index).getDescrizione()%>" collapsible="true" id="panel_${i}" defaultState="" cssClass="">
                        <aui:input id="rigoOrdine_${i}" type="text" name="rigoOrdine_${i}" label="" cssClass="" inlineField="true"  style="display: none" value="<%= prodotti.get(index).getRigoOrdine()%>"/>
                        <aui:input id="codiceProdotto_${i}" type="text" name="codiceProdotto_${i}" label="" cssClass="" inlineField="true"  style="display: none" value="<%= prodotti.get(index).getCodiceArticolo()%>"/>
                        <aui:input id="prodottoVenduto_${i}" type="text" name="prodottoVenduto_${i}" label="Prodotto Venduto" cssClass="input-xlarge" inlineField="true" disabled="true" value="<%= prodotti.get(index).getDescrizione()%>"/>
                        <aui:input id="lottoVenduto_${i}" type="text" name="lottoVenduto_${i}" label="Lotto vendita" cssClass="input-small" inlineField="true" disabled="true" value="<%= prodotti.get(index).getLotto()%>"/>
                        <aui:input id="kgVenduti_${i}" type="text" name="kgVenduti_${i}" label="Kg venduti" cssClass="input-large" inlineField="true" disabled="true" value="<%= prodotti.get(index).getPesoNetto()%>"/>
                        <fieldset title="Prodotto venduto ${i}">
                            <c:forEach var="j" begin="1" end="3">
                                <div style="padding-left: 5%">
                                    <%--<aui:panel collapsible="true" id="TEST" label="TEST">--%>
                                    <aui:input id="lottoGrezzo_${i}_${j}"    type="text" name="lottoGrezzo_${i}_${j}" label="Lotto grezzo" cssClass="input-large" inlineField="true" />
                                    <aui:input id="prodotto_${i}_${j}" type="text" name="prodotto_${i}_${j}" label="Prodotto utilizzato" cssClass="input-xxlarge" inlineField="true" />
                                    <aui:input id="kg_${i}_${j}" type="text" name="kg_${i}_${j}" label="Kg utilizzati" cssClass="input-small" inlineField="true" value="0.0">
                                        <aui:validator name="number"></aui:validator>
                                    </aui:input>
                                    <aui:input id="produttore_${i}_${j}" type="text" name="produttore_${i}_${j}" label="Produttore" cssClass="input-xxlarge" inlineField="true" />
                                    <aui:input id="foglio_${i}_${j}" type="text" name="foglio_${i}_${j}" label="Foglio" cssClass="input-small" inlineField="true" value="0">
                                        <aui:validator name="number"></aui:validator>
                                    </aui:input>
                                    <aui:input id="particella_${i}_${j}" type="text" name="particella_${i}_${j}" label="Particella" cssClass="input-small" inlineField="true" value="0">
                                        <aui:validator name="number"></aui:validator>
                                    </aui:input>
                                </div>
                                <hr/>
                            </c:forEach>
                        </fieldset>
                    </liferay-ui:panel>
                </liferay-ui:panel-container>
                <% index++;%>
            </c:forEach>
        </aui:form>
    </fieldset>
</div>
<script type="text/javascript">

    var index = <%= index%>;

    YUI().use('node', function (Y) {
        Y.one('#btnSave').on('click', function () {
            var scheda = '{"scheda":[';
            for (var i = 1; i <= index; i++) {
                scheda += '{"codiceProdotto"    : "' + Y.one("#<portlet:namespace/>codiceProdotto_" + i).get('value') + '",' +
                        '"prodottoVenduto"  : "' + Y.one("#<portlet:namespace/>prodottoVenduto_" + i).get('value') + '",' +
                        '"numeroDocumento"  : "' + Y.one("#<portlet:namespace/>nDoc").get('value') + '",' +
                        '"rigoOrdine"       : "' + Y.one("#<portlet:namespace/>rigoOrdine_" + i).get('value') + '",' +
                        '"lottoVendita"     : "' + Y.one("#<portlet:namespace/>lottoVenduto_" + i).get('value') + '",' +
                        '"kgVenduti"        : "' + Y.one("#<portlet:namespace/>kgVenduti_" + i).get('value') + '",' +
                        '"grezzi"           : [';
                var sum = 0;
                var descrizione = Y.one("#<portlet:namespace/>prodottoVenduto_" + i).get('value');
                for (var j = 1; j <= 3; j++) {
                    var field = Y.one("#<portlet:namespace/>kg_" + i + "_" + j).get('value');
                    if (field !== "0.0") {
                        sum += parseFloat(field);
                        scheda += (j === 1) ? '' : ',';
                        scheda += '{"lottoGrezzo" :   "' + Y.one("#<portlet:namespace/>lottoGrezzo_" + i + "_" + j).get('value') + '",' +
                                '"prodotto"   :   "' + Y.one("#<portlet:namespace/>prodotto_" + i + "_" + j).get('value') + '",' +
                                '"kg"         :   "' + Y.one("#<portlet:namespace/>kg_" + i + "_" + j).get('value') + '",' +
                                '"produttore" :   "' + Y.one("#<portlet:namespace/>produttore_" + i + "_" + j).get('value') + '",' +
                                '"foglio"     :   "' + Y.one("#<portlet:namespace/>foglio_" + i + "_" + j).get('value') + '",' +
                                '"particella" :   "' + Y.one("#<portlet:namespace/>particella_" + i + "_" + j).get('value') + '"}';

                    }
                }
                if (sum !== parseFloat(Y.one("#<portlet:namespace/>kgVenduti_" + i).get('value'))) {
                    console.log("i: " + i + " descrizione: " + descrizione);
                    console.log("sum: " + sum + " kgVenduti: " + parseFloat(Y.one("#<portlet:namespace/>kgVenduti_" + i).get('value')));
                    alert("Verificare le quantità di prodotto grezzo inserite per il prodotto: '" + descrizione + "'");
                    return;
                }
                scheda += ']}';
                scheda += (i === index) ? '' : ',';
            }

            scheda += ']}';
            var JSONscheda = JSON.parse(scheda);
            console.log(JSONscheda);

            salvaScheda(JSONscheda);
        });
    });
    
    YUI().use('aui-io-request', 'node', function (Y) {
            Y.one('#btnPrint').on('click', function () {
                var nDoc = Y.one('#<portlet:namespace/>nDoc').val();
                var win = window.open('${printScheda}' + '&<portlet:namespace />nDoc=' + nDoc + '&<portlet:namespace />send=' + true, '_blank'); // + '&<portlet:namespace />update=' + false + + '&<portlet:namespace />send=' + true, '_blank');
                win.focus();
//                alert("PRINTING SCHEDA");
            });
        });

    function salvaScheda(data) {
        YUI().use('aui-io-request', 'node', function (Y) {

            Y.io.request(
                    '${saveScheda}' + '&<portlet:namespace />data=' + window.btoa(JSON.stringify(data)),
                    {
                        on: {
                            success: function () {
                                var data = JSON.parse(this.get('responseData'));
                                console.log(data);
                                if (data.code === 0) {
                                    alert("Salvataggio effettuato con successo.");
                                    document.getElementById("btnPrint").disabled = false;
                                    document.getElementById("btnSave").disabled = true;
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
//                                                Y.one('#<portlet:namespace/>nDoc').set('value', data.id);
//                                                document.getElementById("btnPrint").disabled = false;
//                                                document.getElementById("btnSave").disabled = true;
//                                                document.getElementById("btnTrace").disabled = false;
//                                                if (Y.one('#<portlet:namespace/>recProt').val() !== "") {
//                                                    console.log("1: " + Y.one('#<portlet:namespace/>recProt').val());
//                                                    document.getElementById('<portlet:namespace/>recProt').value = "";
//                                                }
                                            alert("Attenzione, non è stato possibile invare la mail di notifica.\n");
                                            break;
                                        case 5:
                                            alert("Attenzione, il numero di protocollo: " + data.id + " è già presente in archivio.\n");
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

</script>