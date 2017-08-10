<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>

<%@ page import="it.bysoftware.ct.model.RigoDocumento" %>
<%@ page import="it.bysoftware.ct.model.WKTestataDocumento" %>

<%@ page import="it.its.ct.gestionaleOP.pojos.Documento" %>

<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Documento documento = (Documento) row.getObject();
	WKTestataDocumento t = documento.getTestata();
//     List<RigoDocumento> r = documento.getRighe();
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="editDocument">
		<liferay-portlet:param name="WKTestataDocumentoPK"  value="<%= JSONFactoryUtil.looseSerialize(t.getPrimaryKey()) %>" />
		<liferay-portlet:param name="jspPage"  value="/jsps/edit-document.jsp" />
	</liferay-portlet:renderURL>
	<liferay-ui:icon
		image="view_tasks"
		url="${editDocument}"
		label="true" message="Verifica" />
</liferay-ui:icon-menu>