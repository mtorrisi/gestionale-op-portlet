<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="it.bysoftware.ct.model.Anagrafica" %>
<%@ page import="it.bysoftware.ct.model.ClientiDatiAgg" %>
<%@ page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.persistence.ClientiDatiAggPK" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	List<Anagrafica> clienti = AnagraficaLocalServiceUtil.getClienti();
	List<Anagrafica> clientiAssociato = new ArrayList<Anagrafica>();
	for (Anagrafica cliente : clienti) {
		ClientiDatiAgg datiAgg = ClientiDatiAggLocalServiceUtil.fetchClientiDatiAgg(new ClientiDatiAggPK(cliente.getCodiceAnagrafica(), false));
	        if (datiAgg != null) {
	        String[] idAssociati = datiAgg.getAssociati().split(",");
	        for (String idAssociato : idAssociati) {
	            if (idAssociato.equals(renderRequest.getRemoteUser())) {
	                clientiAssociato.add(cliente);
	                break;
	            }
	        }
		}
	}

	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setWindowState(LiferayWindowState.NORMAL);
	renderURL.setParameter("jspPage","/jsps/select-customer.jsp");
%>

<liferay-ui:search-container delta="20" emptyResultsMessage="Nessun cliente e' stato ancora associato." iteratorURL="<%= renderURL %>">

	<liferay-ui:search-container-results>

		<%
			results = ListUtil.subList(clientiAssociato, searchContainer.getStart(), searchContainer.getEnd());
			total = clientiAssociato.size();
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="it.bysoftware.ct.model.Anagrafica" modelVar="cliente">
		<liferay-ui:search-container-column-text name="Codice" property="codiceAnagrafica" />
		<liferay-ui:search-container-column-text name="Ragione Sociale" property="ragioneSociale" />
		<liferay-ui:search-container-column-text name="Indirizzo" property="indirizzo" />
		<liferay-ui:search-container-column-text name="Comune" property="comune" />
		<liferay-ui:search-container-column-text name="Parita IVA"  property="partitaIVA" />
		<liferay-ui:search-container-column-button align="center" href="set('${cliente.codiceAnagrafica}|${cliente.ragioneSociale}')" name="Seleziona" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>

<script type="text/javascript">

	function set(valori) {
//         var tmp = valori.split('|');
//         var cliente = tmp[0] + " - " + tmp[1];
		Liferay.Util.getOpener().closePopup(valori, '<portlet:namespace/>dialog');

	}
</script>