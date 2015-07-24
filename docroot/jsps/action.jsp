<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="../init.jsp" %>
<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Anagrafica cliente = (Anagrafica) row.getObject();
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
    </c:if>
    
    <liferay-portlet:actionURL var="deleteApp" name="deleteApp">
        <liferay-portlet:param name="appId" value="<%= String.valueOf(app.getAppId())%>"/>
    </liferay-portlet:actionURL>
    <liferay-ui:icon
        image="delete"
        url="${deleteApp}"
        /--%>
    <liferay-portlet:renderURL var="editDDT">
        <liferay-portlet:param name="codiceCliente"  value="<%= String.valueOf(cliente.getCodiceAnagrafica())%>"/>
        <liferay-portlet:param name="jspPage"  value="/jsps/edit.jsp"/>
    </liferay-portlet:renderURL>
    <liferay-ui:icon 
        image="edit" 
        url="${editDDT}"
        label="true" message="Seleziona"/>

</liferay-ui:icon-menu>