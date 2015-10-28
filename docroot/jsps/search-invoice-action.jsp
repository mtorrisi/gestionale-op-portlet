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
        <liferay-portlet:param name="numeroDocumento" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>
        <%--<liferay-portlet:param name="documentIds" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>--%>
        <liferay-portlet:param name="anno" value="<%= String.valueOf(testata.getAnno())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit-invoice.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editInvoice}"
        label="true" message="Modifica fattura"/>
    <liferay-portlet:actionURL var="deleteInvoice" name="deleteInvoice">
        <liferay-portlet:param name="anno"  value="<%= String.valueOf(testata.getAnno())%>"/>
        <liferay-portlet:param name="numeroOrdine" value="<%= String.valueOf(testata.getNumeroOrdine())%>"/>
        <liferay-portlet:param name="tipoDocumento" value="<%= String.valueOf(testata.getTipoDocumento())%>"/>
        <liferay-portlet:param name="idAssociato" value="<%= String.valueOf(testata.getIdAssociato())%>"/>
        <liferay-portlet:param name="codiceCliente"  value="<%= testata.getCodiceSoggetto()%>"/>
        <%--<liferay-portlet:param name="jspPage"  value="/jsps/edit.jsp"/>--%>
    </liferay-portlet:actionURL>
    <liferay-ui:icon 
        image="delete"
        useDialog="Sei sicuro di voler eliminare la fattura N: <%= String.valueOf(testata.getNumeroOrdine())%> del <%= testata.getDataOrdine() %>.\nL'operazione non può essere annulata."
        url="${deleteInvoice}" />
</liferay-ui:icon-menu>
