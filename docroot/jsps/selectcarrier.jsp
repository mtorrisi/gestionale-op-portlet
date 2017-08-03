<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="it.bysoftware.ct.model.Vettori" %>
<%@ page import="it.bysoftware.ct.service.VettoriLocalServiceUtil" %>

<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	String carrierId = ParamUtil.getString(request, "carrier", null);
	String keywords = ParamUtil.getString(request, "keywords", null);

	List<Vettori> vettori;

	int end = VettoriLocalServiceUtil.getVettorisCount();
	//if (keywords != null) {
	//    imballaggi = VettoriLocalServiceUtil.searchImballaggi(keywords, true, 0, end, null);
	//} else {
		vettori = VettoriLocalServiceUtil.getVettoris(0, end);
	//}

	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(LiferayWindowState.NORMAL);
	renderURL.setParameter("jspPage","/jsps/selectcarrier.jsp"); //current page path
//    renderURL.setParameter("files",tmp);
%>

<aui:form action="<%= renderURL %>" method="post" name="searchForm">
	<aui:input inlineField="true" inlineLabel="true" label="Codice: " name="keywords" />
	<aui:button type="submit" value="Search" />
</aui:form>

<liferay-ui:search-container delta="10" emptyResultsMessage="Nessun vettore trovato." iteratorURL="<%= renderURL %>">

	<liferay-ui:search-container-results >

		<%
			results = ListUtil.subList(vettori, searchContainer.getStart(), searchContainer.getEnd());
			total = vettori.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>

	</liferay-ui:search-container-results>
	<div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />vettore'<%= carrierId %>'">
		<liferay-ui:search-container-row className="it.bysoftware.ct.model.Vettori" modelVar="vettore">
			<liferay-ui:search-container-column-text   property="codiceVettore"  name="Codice" />
			<liferay-ui:search-container-column-text name="Ragione Sociale" property="ragioneSociale" />
			<liferay-ui:search-container-column-text   property="CAP"       name="CAP" />
			<liferay-ui:search-container-column-text   property="comune"    name="Comune" />
			<liferay-ui:search-container-column-text name="Provincia" property="provincia" />
			<liferay-ui:search-container-column-button align="center" href="set('${vettore.codiceVettore}|${vettore.ragioneSociale}')" name="Seleziona" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator paginate="true" searchContainer="<%= searchContainer %>" />
		<%--<c:if test="<%= results.size() > 0 %>">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>"  type="article"  />
		</c:if>--%>
	</div>
</liferay-ui:search-container>

<script type="text/javascript">

	function set(codice) {

		console.log("Codice Vettore: " + codice);
		Liferay.Util.getOpener().closePopup(codice, "<portlet:namespace/>vettore"+<%= carrierId %>);
	}
</script>