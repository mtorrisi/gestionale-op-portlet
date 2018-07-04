<%@page import="it.its.ct.gestionaleOP.utils.Constants"%>
<%@page import="com.liferay.portal.model.UserIdMapper"%>
<%@page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.OrganizzazioneProduttori"%>
<%@page import="it.its.ct.gestionaleOP.utils.DocumentType"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@include file="../init.jsp" %>

<%
    boolean filter = ParamUtil.getBoolean(renderRequest, "filter", false);
    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
    UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(Long.parseLong(renderRequest.getRemoteUser()), Constants.FUTURO_NET);
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper.getUserIdMapperId());
    OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOrganizzazioneProduttori(a.getIdOp());
    String codiceOperatore = renderRequest.getRemoteUser();
    List<TestataDocumento> listDDT;
    if (cliente.getCodiceAnagrafica().equals(String.valueOf(op.getIdLiferay()))) {
        listDDT = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DocumentType.DDA.name(), a.getId());
    } else {
        listDDT = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DocumentType.DDT.name(), a.getId());
    }
    List<TestataDocumento> completed = new ArrayList<TestataDocumento>();
    List<TestataDocumento> invoiced = new ArrayList<TestataDocumento>();

    for (TestataDocumento testata : listDDT) {
        if (filter) {
            if (testata.getCodiceSoggetto().equals(cliente.getCodiceAnagrafica())) {
                if (testata.getCompleto().equals("fatturato")) {
                    invoiced.add(testata);
                } else {
                    completed.add(testata);
                }
            }
        } else {
            if (testata.getCompleto().equals("fatturato")) {
                invoiced.add(testata);
            } else {
                completed.add(testata);
            }
        }
    }

    boolean updateMode = ParamUtil.getBoolean(renderRequest, "update");
    String label = updateMode ? "Elenco DDT" : "Elenco DDT da fatturare";
%>

<liferay-ui:error key="errorDelete" message="Non e\' stato possibile rimuovere il documento." />
<liferay-ui:error key="differentCustomers" message="Impossibile generare la fattura, i documenti selezionati appartengono a clienti differenti." />
<liferay-portlet:actionURL name="generateInvoice" var="generateInvoice" />
<liferay-portlet:renderURL var="searchInvoiceURL">
    <liferay-portlet:param name="codiceCliente"  value="<%= cliente.getCodiceAnagrafica() %>" />
    <liferay-portlet:param name="update"  value="<%= String.valueOf(updateMode) %>" />
    <liferay-portlet:param name="filter"  value="<%= String.valueOf(filter) %>" />
    <%--<liferay-portlet:param name="update" value="true" />--%>
    <liferay-portlet:param name="jspPage"  value="/jsps/search-invoice.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="instantInvoiceURL">
    <liferay-portlet:param name="immediate"  value="true" />
    <liferay-portlet:param name="codiceCliente"  value="<%= cliente.getCodiceAnagrafica() %>" />
    <liferay-portlet:param name="jspPage"  value="/jsps/edit-instant-invoice.jsp" />
</liferay-portlet:renderURL>
<aui:fieldset label="<%= label %>">
    <div id="myTab">

        <ul class="nav nav-tabs">
            <li class="active"><a href="#tab-1">Completi</a></li>
            <li><a href="#tab-2">Fatturati</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane" id="tab-1">
                <aui:field-wrapper>
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <button class="btn"  id="btnSearch" <%= ((updateMode) ? "style=\"display: none\"" : "") %>><i class="icon-search"></i> Cerca fattura</button>
                            <button class="btn" id="btnInvoice"><i class="icon-list-alt"></i> Genera Fattura</button>
                            <button class="btn hidden" id="btnInstantInvoice" ><i class="icon-list-alt"></i> Fattura Immediata</button>
                        </div>
                    </div>
                </aui:field-wrapper>

                <aui:form action="${generateInvoice}" method="post" name="fm">
                    <aui:input name="filter" type="hidden" value="<%= String.valueOf(filter) %>" />
                    <aui:input name="update" type="hidden" value="<%= String.valueOf(updateMode) %>" />
                    <aui:input name="documentIds" type="hidden" />
                    <aui:input name="clientId" type="hidden" value="<%= cliente.getCodiceAnagrafica() %>" />
                    <liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." rowChecker="<%= new RowChecker(renderResponse) %>">

                        <liferay-ui:search-container-results results="<%= completed %>"
                        total="<%= completed.size() %>" />
                        <liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" keyProperty="numeroOrdine" modelVar="testataDDT">
                            <liferay-ui:search-container-column-text name="N." property="numeroOrdine" />
                            <liferay-ui:search-container-column-text name="Ragione Sociale" property="ragioneSociale" />
                            <liferay-ui:search-container-column-text name="Data Documento" property="dataOrdine" />
                            <liferay-ui:search-container-column-text name="Stato" property="completo" />
                            <c:choose>
                                <c:when test="<%= updateMode %>">
                                    <liferay-ui:search-container-column-jsp align="right" path="/jsps/ddt-action.jsp" valign="middle" />
                                </c:when>
                                <c:otherwise>
                                    <liferay-ui:search-container-column-jsp align="right" path="/jsps/invoice-action.jsp" valign="middle" />
                                </c:otherwise>
                            </c:choose>
                        </liferay-ui:search-container-row>

                        <liferay-ui:search-iterator/>
                    </liferay-ui:search-container>
                </aui:form>
            </div>

            <div id="tab-2">
                <liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." rowChecker="<%= new RowChecker(renderResponse) %>">

                    <liferay-ui:search-container-results results="<%= invoiced %>"
                    total="<%= invoiced.size() %>" />
                    <liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" keyProperty="numeroOrdine" modelVar="testataDDT">
                        <liferay-ui:search-container-column-text name="N." property="numeroOrdine" />
                        <liferay-ui:search-container-column-text name="Ragione Sociale" property="ragioneSociale" />
                        <liferay-ui:search-container-column-text name="Data Documeto" property="dataOrdine" />
                        <liferay-ui:search-container-column-text name="Stato" property="completo" />
                        <%--c:choose>
                            <c:when test="<%= updateMode %>">
                                <liferay-ui:search-container-column-jsp align="right" path="/jsps/ddt-action.jsp" valign="middle" />
                            </c:when>
                            <c:otherwise>
                                <liferay-ui:search-container-column-jsp align="right" path="/jsps/invoice-action.jsp" valign="middle" />
                            </c:otherwise>
                        </c:choose--%>
                    </liferay-ui:search-container-row>

                    <liferay-ui:search-iterator/>
                </liferay-ui:search-container>
            </div>
        </div>
    </div>
</aui:fieldset>

<script type="text/javascript">

    var searchInvoiceURL = "<%= searchInvoiceURL %>";
    var instantInvoiceURL = "<%= instantInvoiceURL %>";

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

    YUI().use('liferay-util-list-fields', function(Y) {
        Y.one('#btnInvoice').on('click', function(event) {
            var checkBoxValue = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
            if (checkBoxValue == "" || checkBoxValue == null) {
                alert("Seleziona almeno un documento");
                return false;
            }
            if (confirm("Procedere alla generazione della fattura per i documenti selezionati?")) {
                document.<portlet:namespace />fm.<portlet:namespace />documentIds.value = checkBoxValue;
                submitForm(document.<portlet:namespace />fm, "<%= generateInvoice.toString() %>");
            }

        });
    });

    YUI().use('node', function(Y) {
        Y.one('#btnSearch').on('click', function() {
            window.location.href = searchInvoiceURL;
        });
    });
    YUI().use('node', function(Y) {
        Y.one('#btnInstantInvoice').on('click', function() {
            window.location.href = instantInvoiceURL;
        });
    });
</script>