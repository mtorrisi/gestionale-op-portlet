<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../init.jsp" %>
<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Anagrafica cliente = (Anagrafica) row.getObject();
%>


<liferay-ui:icon-menu>
    <liferay-portlet:renderURL var="editDDT">
        <liferay-portlet:param name="codiceCliente"  value="<%= String.valueOf(cliente.getCodiceAnagrafica())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editDDT}"
        label="true" message="DDT"/>
    <liferay-portlet:renderURL var="editInvoice">
        <liferay-portlet:param name="codiceCliente"  value="<%= String.valueOf(cliente.getCodiceAnagrafica())%>"/>
        <liferay-portlet:param name="update" value="false"/>
        <liferay-portlet:param name="filter" value="true" />
        <liferay-portlet:param name="jspPage" value="/jsps/search-ddt.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editInvoice}"
        label="true" message="Fattura"/>
    <liferay-portlet:renderURL var="editCreditNote">
        <liferay-portlet:param name="codiceCliente"  value="<%= String.valueOf(cliente.getCodiceAnagrafica())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit-credit-note.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editCreditNote}"
        label="true" message="Nota di credito"/>
</liferay-ui:icon-menu>