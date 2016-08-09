<%-- 
    Document   : document-action
    Created on : 5-mar-2016, 10.05.32
    Author     : Aliseo-G
--%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../../init.jsp" %>
<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Associato associato = (Associato) row.getObject();
        
    int c = TestataDocumentoLocalServiceUtil.countDocumnetByCodiceOperatore(String.valueOf(associato.getIdLiferay()), "completo", 0);
%>

<liferay-ui:icon-menu>
    <liferay-portlet:resourceURL var="download" id="download" >
        <liferay-portlet:param name="userId" value="<%=String.valueOf(associato.getId()) %>"/>
    </liferay-portlet:resourceURL>
    <liferay-portlet:renderURL var="rivediDocumentiUrl" windowState="normal" >
        <liferay-portlet:param name="mvcPath" value="/jsps/op/view-downloaded.jsp"/>
        <liferay-portlet:param name="associato" value="<%=String.valueOf(associato.getId()) %>"/>
    </liferay-portlet:renderURL>
    <c:if test="<%= c > 0%>">
        <liferay-ui:icon
            image="download"
            label="Scarica documento"
            url="${download}"
            />
    </c:if>
    <c:if test="<%= c == 0%>">
        <liferay-ui:icon
            image="edit"
            message="Rivedi"
            url="${rivediDocumentiUrl}"
            />
    </c:if>

</liferay-ui:icon-menu>

