<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@ page import="it.bysoftware.ct.model.TestataDocumento" %>

<%@ include file="../init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	TestataDocumento testata = (TestataDocumento) row.getObject();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="editCreditNote">
		<liferay-portlet:param name="codiceCliente"  value="<%= testata.getCodiceSoggetto() %>" />
		<liferay-portlet:param name="numeroDocumento" value="<%= String.valueOf(testata.getNumeroOrdine()) %>" />
		<liferay-portlet:param name="anno" value="<%= String.valueOf(testata.getAnno()) %>" />
		<liferay-portlet:param name="jspPage"  value="/jsps/edit-credit-note.jsp" />
	</liferay-portlet:renderURL>
	<liferay-ui:icon
		image="edit"
		url="${editCreditNote}"
		label="true" />
	<c:if test="<%= testata.getInviato()== 0 %>">
		<liferay-portlet:actionURL name="deleteCreditNote" var="deleteCreditNote">
			<liferay-portlet:param name="anno"  value="<%= String.valueOf(testata.getAnno()) %>" />
			<liferay-portlet:param name="numeroOrdine" value="<%= String.valueOf(testata.getNumeroOrdine()) %>" />
			<liferay-portlet:param name="tipoDocumento" value="<%= String.valueOf(testata.getTipoDocumento()) %>" />
			<liferay-portlet:param name="idAssociato" value="<%= String.valueOf(testata.getIdAssociato()) %>" />
			<liferay-portlet:param name="codiceCliente"  value="<%= testata.getCodiceSoggetto() %>" />
			<%--<liferay-portlet:param name="jspPage"  value="/jsps/edit.jsp" />--%>
		</liferay-portlet:actionURL>
		<liferay-ui:icon
			image="delete"
			useDialog="Sei sicuro di voler eliminare la nota di credito N: <%= String.valueOf(testata.getNumeroOrdine()) %> del <%= testata.getDataOrdine() %>.\nL'operazione non puo' essere annulata."
			url="${deleteCreditNote}" />
	</c:if>
</liferay-ui:icon-menu>