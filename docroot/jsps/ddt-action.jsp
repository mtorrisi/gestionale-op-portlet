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
        <liferay-portlet:param name="idAssociato" value="<%= String.valueOf(testata.getIdAssociato())%>"/>
        <liferay-portlet:param name="numeroDocumento" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit-ddt.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editDDT}"
        label="true" message="Modifica documento"/>
    <portlet:resourceURL var="printDDT" id="print" />
    <liferay-portlet:resourceURL var="printDDT" id="print">
        <liferay-portlet:param name="nDoc" value="<%= String.valueOf(testata.getNumeroOrdine())%>" />
    </liferay-portlet:resourceURL>
    <liferay-ui:icon image="print" url="${printDDT}" />
    <%--liferay-portlet:renderURL var="editInvoice">
        <liferay-portlet:param name="codiceCliente"  value="<%= testata.getCodiceSoggetto()%>"/>
        <%--<liferay-portlet:param name="numeroDocumento" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>>
        <liferay-portlet:param name="documentIds" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>
        <liferay-portlet:param name="anno" value="<%= String.valueOf(testata.getAnno())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit-invoice.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="icon-list-alt" 
        url="${editInvoice}"
        label="true" message="Genera fattura"/--%>
    <liferay-portlet:actionURL var="deleteDDT" name="deleteDDT">
        <liferay-portlet:param name="anno"  value="<%= String.valueOf(testata.getAnno())%>"/>
        <liferay-portlet:param name="numeroOrdine" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>
        <liferay-portlet:param name="tipoDocumento" value="<%= String.valueOf(testata.getTipoDocumento())%>"/>
        <liferay-portlet:param name="idAssociato" value="<%= String.valueOf(testata.getIdAssociato())%>"/>
        <liferay-portlet:param name="codiceCliente"  value="<%= testata.getCodiceSoggetto()%>"/>
        <%--<liferay-portlet:param name="jspPage"  value="/jsps/edit.jsp"/>--%>
    </liferay-portlet:actionURL>
    <liferay-ui:icon-delete 
        url="${deleteDDT}" />
</liferay-ui:icon-menu>
