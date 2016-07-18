<%@page import="it.bysoftware.ct.model.WKRigoDocumento"%>
<%@page import="it.bysoftware.ct.model.WKTestataDocumento"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.model.RigoDocumento"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="it.its.ct.gestionaleOP.pojos.Documento"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../init.jsp" %>
<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	WKRigoDocumento r = (WKRigoDocumento) row.getObject();
%>


<liferay-ui:icon-menu>
    <liferay-portlet:renderURL var="editRow">
        <liferay-portlet:param name="WKRigoDocumentoPK"  value="<%= JSONFactoryUtil.looseSerialize(r.getPrimaryKey())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit-row.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="view_tasks" 
        url="${editRow}"
        label="true" message="Verifica"/>
</liferay-ui:icon-menu>