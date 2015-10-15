<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    TestataDocumento testata = (TestataDocumento) row.getObject();   
%>

<liferay-ui:icon-menu>
    <liferay-portlet:renderURL var="editInvoice">
        <liferay-portlet:param name="codiceCliente"  value="<%= testata.getCodiceSoggetto()%>"/>
        <%--<liferay-portlet:param name="numeroDocumento" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>--%>
        <liferay-portlet:param name="documentIds" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>
        <liferay-portlet:param name="anno" value="<%= String.valueOf(testata.getAnno())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit-invoice.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editInvoice}"
        label="true" message="Genera fattura"/>
</liferay-ui:icon-menu>
