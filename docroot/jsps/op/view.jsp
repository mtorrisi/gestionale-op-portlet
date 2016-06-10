<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.TestataDocumentoLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.OrganizzazioneProduttori"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="../../init.jsp" %>

<%

    OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOP(Long.valueOf(renderRequest.getRemoteUser()));
    List<Associato> associati = AssociatoLocalServiceUtil.getAssociatiAttivi(op.getId());
        
    PortletURL renderURL = renderResponse.createRenderURL();
    renderURL.setWindowState(LiferayWindowState.NORMAL);
    renderURL.setParameter("jspPage", "/jsps/op/view.jsp"); //current page path

%>
<portlet:resourceURL var="download" id="download" />
<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna associato trovato." iteratorURL="<%= renderURL%>">

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
            <liferay-ui:search-container-column-text property="id"    name="Codice"/>
            <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
            <liferay-ui:search-container-column-jsp path="/jsps/op/document-action.jsp"/>
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator searchContainer="<%= searchContainer%>" paginate="true"/>
    </div>
</liferay-ui:search-container>
