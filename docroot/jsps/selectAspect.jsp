<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="it.bysoftware.ct.model.AspettoEsterioreBeni" %>
<%@ page import="it.bysoftware.ct.service.AspettoEsterioreBeniLocalServiceUtil" %>

<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	String keywords = ParamUtil.getString(request, "keywords", null);

	List<AspettoEsterioreBeni> listAspettoEsterioreBeni;

	int end = AspettoEsterioreBeniLocalServiceUtil.getAspettoEsterioreBenisCount();

	//if (keywords != null) {
	//    imballaggi = VettoriLocalServiceUtil.searchImballaggi(keywords, true, 0, end, null);
	//} else {
		listAspettoEsterioreBeni = AspettoEsterioreBeniLocalServiceUtil.getAspettoEsterioreBenis(0, end);
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
			results = ListUtil.subList(listAspettoEsterioreBeni, searchContainer.getStart(), searchContainer.getEnd());
			total = listAspettoEsterioreBeni.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>

	</liferay-ui:search-container-results>
	<div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />aspettoEsteriore">
		<liferay-ui:search-container-row className="it.bysoftware.ct.model.AspettoEsterioreBeni" modelVar="aspettoEsterioreBeni">
			<liferay-ui:search-container-column-text   property="codiceAspettoEsteriore"  name="Codice" />
			<liferay-ui:search-container-column-text name="Descrizione" property="descrizione" />
			<liferay-ui:search-container-column-button align="center" href="set('${aspettoEsterioreBeni.codiceAspettoEsteriore}|${aspettoEsterioreBeni.descrizione}')" name="Seleziona" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator paginate="true" searchContainer="<%= searchContainer %>" />
		<%--<c:if test="<%= results.size() > 0 %>">
			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>"  type="article"  />
		</c:if>--%>
	</div>
</liferay-ui:search-container>

<script type="text/javascript">

	function set(codice) {

		console.log("Codice aspetto: " + codice);
		Liferay.Util.getOpener().closePopup(codice, "<portlet:namespace/>aspettoEsteriore");
	}
</script>