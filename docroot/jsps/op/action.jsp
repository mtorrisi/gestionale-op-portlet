<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../../init.jsp" %>
<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Associato associato = (Associato) row.getObject();
%>


<liferay-ui:icon-menu>

    <%--liferay-portlet:actionURL var="toggleApp" name="toggleApp">
        <liferay-portlet:param name="appId" value="<%= String.valueOf(app.getAppId())%>"/>
    </liferay-portlet:actionURL>
    <c:if test="<%= app.isEnabled()%>">
        <liferay-ui:icon
            image="deactivate"
            url="${toggleApp}"
            />

    </c:if>
    <c:if test="<%= !app.isEnabled()%>">
        <liferay-ui:icon
            image="activate"
            url="${toggleApp}"
            />
    </c:if--%>
    <liferay-portlet:renderURL var="editAssociato" >
        <liferay-portlet:param name="id"  value="<%= String.valueOf(associato.getId())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/op/edit_associate.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editAssociato}"
        label="true"/>    
    <liferay-portlet:actionURL var="deleteAssociato" name="deleteAssociato">
        <liferay-portlet:param name="id" value="<%= String.valueOf(associato.getId())%>"/>
    </liferay-portlet:actionURL>
    <liferay-ui:icon
        image="delete"
        url="${deleteAssociato}"
        />
    
</liferay-ui:icon-menu>