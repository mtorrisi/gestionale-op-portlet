<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="it.bysoftware.ct.model.Articoli" %>
<%@ page import="it.bysoftware.ct.service.ArticoliLocalServiceUtil" %>

<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	String keywords = ParamUtil.getString(request, "keywords", null);

	List<Articoli> imballaggi;

	if (keywords != null) {
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

<aui:form action="<%= renderURL %>" method="post" name="searchForm">
	<aui:input inlineField="true" inlineLabel="true" label="Codice: " name="keywords" />
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
			<liferay-ui:search-container-column-text name="Codice" property="codiceArticolo" />
			<liferay-ui:search-container-column-text   property="descrizione"    name="Descrizione" />
			<%--<liferay-ui:search-container-column-text   property="CAP"       name="CAP" />--%>
			<%--<liferay-ui:search-container-column-text property="provincia" name="Provincia" />--%>
			<liferay-ui:search-container-column-button align="center" href="set('${imballaggio.codiceArticolo}')" name="Seleziona" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator paginate="true" searchContainer="<%= searchContainer %>" />
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