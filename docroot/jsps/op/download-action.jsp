<%-- 
    Document   : document-action
    Created on : 5-mar-2016, 10.05.32
    Author     : Aliseo-G
--%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../../init.jsp" %>
<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    TestataDocumento t = (TestataDocumento) row.getObject();
        
%>

<liferay-ui:icon-menu>

    <liferay-portlet:resourceURL var="download" id="download" >
        <liferay-portlet:param name="userId" value="<%=String.valueOf(t.getIdAssociato()) %>"/>
        <liferay-portlet:param name="inviato" value="1"/>
        <liferay-portlet:param name="testata" value="<%=JSONFactoryUtil.looseSerialize(t.getPrimaryKeyObj()) %>"/>
    </liferay-portlet:resourceURL>
        <liferay-ui:icon
            image="download"
            label="Scarica documento"
            url="${download}"
            />
</liferay-ui:icon-menu>

