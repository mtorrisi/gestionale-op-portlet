<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="../../init.jsp" %>

<%
//String cliente = ParamUtil.getString(request, "codiceCliente", null);

    String keywords = ParamUtil.getString(request, "keywords", null);

    List<User> utenti;

//    if(keywords != null){
//        int end = UserLocalServiceUtil.UserLocalServiceUtil.getUsersCount();
//        articoli = ArticoliLocalServiceUtil.searchArticoli(keywords, true, 0, end, null);
//    } else {
    utenti = UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
//    }

    PortletURL renderURL = renderResponse.createRenderURL();
    renderURL.setWindowState(LiferayWindowState.NORMAL);
    renderURL.setParameter("jspPage", "/jsps/op/view.jsp"); //current page path
//    renderURL.setParameter("files",tmp);
%>
<portlet:resourceURL var="download" id="download" />
<liferay-ui:search-container delta="10" emptyResultsMessage="Nessuna utente trovato." iteratorURL="<%= renderURL%>">

    <liferay-ui:search-container-results >
        <%
            results = ListUtil.subList(utenti, searchContainer.getStart(), searchContainer.getEnd());
            total = UserLocalServiceUtil.getUsersCount();
            pageContext.setAttribute("results", results);
            pageContext.setAttribute("total", total);
        %>
    </liferay-ui:search-container-results>
    <div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />utenti">
        <liferay-ui:search-container-row className="com.liferay.portal.model.User" modelVar="user">
            <liferay-ui:search-container-column-text   property="userId"    name="Codice"/>
            <liferay-ui:search-container-column-text   property="firstName" name="Ragione Sociale" />
            <liferay-ui:search-container-column-button href="scarica('${user.userId}')" name="Scarica tracciato" align="center" />

        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator searchContainer="<%= searchContainer%>" paginate="true"/>
        <%--<c:if test="<%= results.size() > 0 %>">
            <liferay-ui:search-paginator searchContainer="<%= searchContainer %>"  type="article"  />
        </c:if>--%>
    </div>
</liferay-ui:search-container>

<script type="text/javascript">


    function scarica(userID) {
        var queryString = "&<portlet:namespace/>userId=" + userID;

        var win = window.open('${download}' + queryString, '_blank');
        win.focus();
//        YUI().use('aui-io-request', 'node', function (Y) {
//            Y.io.request(
//                    '${download}' + queryString
//            );
//
//        });

    }
</script>