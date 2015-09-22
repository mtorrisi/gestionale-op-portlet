<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@include file="../init.jsp" %>

<%
    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
    String codiceOperatore = renderRequest.getRemoteUser();
    List<TestataDocumento> listDDT = TestataDocumentoLocalServiceUtil.getByCodiceSoggettoCodiceOperatore(cliente.getCodiceAnagrafica(), codiceOperatore);
    List<TestataDocumento> completed = new ArrayList<TestataDocumento>();
    List<TestataDocumento> invoiced = new ArrayList<TestataDocumento>();

    for (TestataDocumento testata : listDDT) {
        if (testata.getCompleto().equals("fatturato")) {
            invoiced.add(testata);
        } else {
            completed.add(testata);
        }
    }

    boolean updateMode = ParamUtil.getBoolean(renderRequest, "update");
%>
<liferay-ui:error key="error-delete" message="Non è stato possibile rimuovere il documento." />
<liferay-portlet:actionURL name="generateInvoice" var="generateInvoice"/>
<aui:fieldset label="Elenco DDT">
    <aui:field-wrapper>
        <div class="btn-toolbar">
            <div class="btn-group">
                <!--<button id="btnSearch"  class="btn" ><i class="icon-search"></i>Cerca</button>-->
                <!--<button id="btnSave"    class="btn" onclick="SalvaDDT()" ><i class="icon-hdd"></i>Salva</button>-->
                <button id="btnPrint"   class="btn" ><i class="icon-print"></i>Stampa</button>
                <button id="btnInvoice" class="btn" ><i class="icon-list-alt"></i>Genera Fattura</button>
            </div>
        </div>  
    </aui:field-wrapper>

    <aui:form method="post" name="fm" action="${generateInvoice}">
        <aui:input name="documentIds" type="hidden"/>
        <aui:input name="clientId" type="hidden" value="<%=cliente.getCodiceAnagrafica()%>"/>
        <liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." rowChecker="<%= new RowChecker(renderResponse)%>">

            <liferay-ui:search-container-results results="<%= completed%>" 
            total="<%= completed.size()%>"/>
            <liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" modelVar="testataDDT" keyProperty="numeroOrdine">
                <liferay-ui:search-container-column-text property="numeroOrdine" name="N°"/>
                <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
                <liferay-ui:search-container-column-text property="dataOrdine" name="Data Documeto"/>
                <liferay-ui:search-container-column-text property="completo" name="Stato"/>
                <c:choose>
                    <c:when test="<%= updateMode%>">
                        <liferay-ui:search-container-column-jsp align="right" valign="middle" path="/jsps/ddt-action.jsp"/>                        
                    </c:when>
                    <c:otherwise>
                        <liferay-ui:search-container-column-jsp align="right" valign="middle" path="/jsps/invoice-action.jsp"/>
                    </c:otherwise>
                </c:choose>
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator/>
        </liferay-ui:search-container>
    </aui:form>
</aui:fieldset>
<%--liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." rowChecker="<%= new RowChecker(renderResponse)%>">

            <liferay-ui:search-container-results results="<%= invoiced %>" 
            total="<%= invoiced.size()%>"/>
            <liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" modelVar="testataDDT" keyProperty="numeroOrdine">
                <liferay-ui:search-container-column-text property="numeroOrdine" name="N°"/>
                <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
                <liferay-ui:search-container-column-text property="dataOrdine" name="Data Documeto"/>
                <liferay-ui:search-container-column-text property="completo" name="Stato"/>
                <c:choose>
                    <c:when test="<%= updateMode%>">
                        <liferay-ui:search-container-column-jsp align="right" valign="middle" path="/jsps/ddt-action.jsp"/>                        
                    </c:when>
                    <c:otherwise>
                        <liferay-ui:search-container-column-jsp align="right" valign="middle" path="/jsps/invoice-action.jsp"/>
                    </c:otherwise>
                </c:choose>
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator/>
        </liferay-ui:search-container--%>

<script type="text/javascript">

    YUI().use('liferay-util-list-fields', function (Y) {
        Y.one('#btnInvoice').on('click', function (event) {
            var checkBoxValue = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
            if (checkBoxValue == "" || checkBoxValue == null) {
                alert("Seleziona almeno un documento");
                return false;
            }
            if (confirm("Procedere alla generazione della fattura per i documenti selezionati?")) {
                document.<portlet:namespace />fm.<portlet:namespace />documentIds.value = checkBoxValue;
                submitForm(document.<portlet:namespace />fm, "<%=generateInvoice.toString()%>");
            }

        });
    });

</script>