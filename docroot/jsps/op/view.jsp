<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="../../init.jsp" %>

<%

    List<Associato> associati =AssociatoLocalServiceUtil.getAssociatiAttivi();
  
    PortletURL renderURL = renderResponse.createRenderURL();
    renderURL.setWindowState(LiferayWindowState.NORMAL);
    renderURL.setParameter("jspPage", "/jsps/op/view.jsp"); //current page path

%>
<portlet:resourceURL var="download" id="download" />
<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna utente trovato." iteratorURL="<%= renderURL%>">

    <liferay-ui:search-container-results >
        <%
            results = ListUtil.subList(associati, searchContainer.getStart(), searchContainer.getEnd());
            total = AssociatoLocalServiceUtil.countAssociatiAttivi();
            pageContext.setAttribute("results", results);
            pageContext.setAttribute("total", total);
        %>
    </liferay-ui:search-container-results>
    <div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />associati">
        <liferay-ui:search-container-row className="it.bysoftware.ct.model.Associato" modelVar="associato">
            <liferay-ui:search-container-column-text   property="id"    name="Codice"/>
            <liferay-ui:search-container-column-text   property="ragioneSociale" name="Ragione Sociale" />
            <liferay-ui:search-container-column-button href="scarica('${associato.id}')" name="Acquisisci documento" align="center" />

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
//                    '${download}' + queryString,
//                    {
//                        on: {
//                            success: function () {
//                                var data = this.get('responseData');
//                                if (data !== "-1") {
//                                    var win = window.open(data, '_blank');
//                                    win.focus();
//                                } else {
//                                    alert("ERRORE");
//                                }
//                            }
//
//                        }
//                    }
//            );
//
//        });

    }
</script>