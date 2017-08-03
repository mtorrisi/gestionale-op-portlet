<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="it.bysoftware.ct.model.CausaleTrasporto" %>
<%@ page import="it.bysoftware.ct.service.CausaleTrasportoLocalServiceUtil" %>

<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	String keywords = ParamUtil.getString(request, "keywords", null);

	List<CausaleTrasporto> listCausaleTrasporto;

	int end = CausaleTrasportoLocalServiceUtil.getCausaleTrasportosCount();

	//if (keywords != null) {
	//    imballaggi = VettoriLocalServiceUtil.searchImballaggi(keywords, true, 0, end, null);
	//} else {
		listCausaleTrasporto = CausaleTrasportoLocalServiceUtil.getCausaleTrasportos(0, end);
	//}

	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(LiferayWindowState.NORMAL);
	renderURL.setParameter("jspPage","/jsps/selectTrasportCare.jsp"); //current page path
//    renderURL.setParameter("files",tmp);
%>

<%--<aui:form name="searchForm" action="<%= renderURL %>" method="post">
	<aui:input inlineField="true" inlineLabel="true" label="Codice: " name="keywords" />
	<aui:button type="submit" value="Search" />
</aui:form>--%>

<liferay-ui:search-container delta="20" emptyResultsMessage="Nessun vettore trovato." iteratorURL="<%= renderURL %>">

	<liferay-ui:search-container-results >

		<%
			results = ListUtil.subList(listCausaleTrasporto, searchContainer.getStart(), searchContainer.getEnd());
			total = listCausaleTrasporto.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>

	</liferay-ui:search-container-results>
	<div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />causaleTrasporto">
		<liferay-ui:search-container-row className="it.bysoftware.ct.model.CausaleTrasporto" modelVar="causaleTrasporto">
			<liferay-ui:search-container-column-text   property="codiceCausaleTrasporto"  name="Codice" />
			<liferay-ui:search-container-column-text name="Descrizione" property="descrizione" />
			<liferay-ui:search-container-column-button align="center" href="set('${causaleTrasporto.codiceCausaleTrasporto}|${causaleTrasporto.descrizione}')" name="Seleziona" />

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
		Liferay.Util.getOpener().closePopup(codice, "<portlet:namespace/>causaleTrasporto");
	}
</script>