<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="it.bysoftware.ct.model.Associato" %>
<%@ page import="it.bysoftware.ct.model.OrganizzazioneProduttori" %>
<%@ page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil" %>

<%@ page import="java.util.List" %>

<%@ include file="../../init.jsp" %>

<%
	OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOP(Long.valueOf(renderRequest.getRemoteUser()));
	List<Associato> associati = AssociatoLocalServiceUtil.getAssociatiAttivi(op.getId());

	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(LiferayWindowState.NORMAL);
	renderURL.setParameter("jspPage", "/jsps/op/view.jsp"); //current page path
%>

<portlet:resourceURL id="download" var="download" />
<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna associato trovato." iteratorURL="<%= renderURL %>">
	<liferay-ui:search-container-results >

			<%
	  			results = ListUtil.subList(associati, searchContainer.getStart(), searchContainer.getEnd());
	  			total = AssociatoLocalServiceUtil.countAssociatiAttivi(op.getId());
	  			pageContext.setAttribute("results", results);
		 		pageContext.setAttribute("total", total);
			%>

	</liferay-ui:search-container-results>
	<div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />associati">
			<liferay-ui:search-container-row className="it.bysoftware.ct.model.Associato" modelVar="associato">
	  			<liferay-ui:search-container-column-text property="idLiferay"    name="Codice" />
	  			<liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
	  			<liferay-ui:search-container-column-jsp path="/jsps/op/document-action.jsp" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="true" searchContainer="<%= searchContainer %>" />
	</div>
</liferay-ui:search-container>