<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../init.jsp" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    TestataDocumento testata = (TestataDocumento) row.getObject();

%>

<liferay-ui:icon-menu>
    <liferay-portlet:renderURL var="editDDT">
        <liferay-portlet:param name="codiceCliente"  value="<%= testata.getCodiceSoggetto()%>"/>
        <liferay-portlet:param name="numeroDocumento" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editDDT}"
        label="true" message="Modifica documento"/>
</liferay-ui:icon-menu>