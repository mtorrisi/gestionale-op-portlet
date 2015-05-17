<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.ArticoliLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.ArticoliLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.model.Articoli"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@include file="../init.jsp" %>

<%   
    String keywords = ParamUtil.getString(request, "keywords", null);

    List<Articoli> imballaggi;

    if(keywords != null){
        int end = ArticoliLocalServiceUtil.countImballaggi();
        imballaggi = ArticoliLocalServiceUtil.searchImballaggi(keywords, true, 0, end, null);
    } else {
        imballaggi = ArticoliLocalServiceUtil.getImballaggi();
    }

    PortletURL renderURL = renderResponse.createRenderURL();
    renderURL.setWindowState(LiferayWindowState.NORMAL);
    renderURL.setParameter("jspPage","/jsps/selectPack.jsp"); //current page path
//    renderURL.setParameter("files",tmp);
%>

<aui:form name="searchForm" action="<%=renderURL%>" method="post">
    <aui:input  name="keywords" label="Codice: " inlineField="true" inlineLabel="true"/> 
    <aui:button type="submit" value="Search" />
</aui:form>

<liferay-ui:search-container delta="10" emptyResultsMessage="Nessun imballaggio trovato." iteratorURL="<%= renderURL %>">

    <liferay-ui:search-container-results >
        <% 
            results = ListUtil.subList(imballaggi, searchContainer.getStart(), searchContainer.getEnd());
            total = imballaggi.size();
            pageContext.setAttribute("results", results);
            pageContext.setAttribute("total", total);
        %>
    </liferay-ui:search-container-results>
    <div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />sessioneFiles">
        <liferay-ui:search-container-row className="it.bysoftware.ct.model.Articoli" modelVar="imballaggio">
            <liferay-ui:search-container-column-text   property="codiceArticolo" name="Codice"/>
            <liferay-ui:search-container-column-text   property="descrizione"    name="Descrizione" />
            <%--<liferay-ui:search-container-column-text   property="CAP"       name="CAP"/>--%>
            <%--<liferay-ui:search-container-column-text   property="provincia" name="Provincia"/>--%>
            <liferay-ui:search-container-column-button href="set('${imballaggio.codiceArticolo}')" name="Seleziona" align="center" />

        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="true"/>
        <%--<c:if test="<%= results.size() > 0 %>">
            <liferay-ui:search-paginator searchContainer="<%= searchContainer %>"  type="article"  />
        </c:if>--%>
    </div>
</liferay-ui:search-container>

<script type="text/javascript">

    function set(codice) {

        console.log("Codice Articolo: " + codice);
        Liferay.Util.getOpener().closePopup(codice, '<portlet:namespace/>packDialog');
    }
</script>