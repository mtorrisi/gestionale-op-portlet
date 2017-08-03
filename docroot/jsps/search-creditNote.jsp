<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.model.UserIdMapper" %>
<%@ page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil" %>

<%@ page import="it.bysoftware.ct.model.Anagrafica" %>
<%@ page import="it.bysoftware.ct.model.Associato" %>
<%@ page import="it.bysoftware.ct.model.TestataDocumento" %>
<%@ page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil" %>

<%@ page import="it.its.ct.gestionaleOP.utils.Constants" %>
<%@ page import="it.its.ct.gestionaleOP.utils.DocumentType" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>

<%@ include file="../init.jsp" %>

<%
	Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
	UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(Long.parseLong(renderRequest.getRemoteUser()), Constants.FUTURO_NET);
	Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper.getUserIdMapperId());
	String codiceOperatore = renderRequest.getRemoteUser();
	List<TestataDocumento> listCreditNote = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DocumentType.NAC.name(), a.getId());
%>

<aui:fieldset label="Elenco Fatture">
	<aui:form action="${generateInvoice}" method="post" name="fm">
		<%--<aui:input name="documentIds" />--%>
		<%--<aui:input name="clientId" value="<%= //cliente.getCodiceAnagrafica() %>" />--%>
		<%--<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." rowChecker="<%= new RowChecker(renderResponse) %>">--%>
		<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna nota di credito trovata.">
			<liferay-ui:search-container-results results="<%= listCreditNote %>"
			total="<%= listCreditNote.size() %>" />
			<liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" keyProperty="numeroOrdine" modelVar="testataNAC">
				<liferay-ui:search-container-column-text name="N." property="numeroOrdine" />
				<liferay-ui:search-container-column-text name="Ragione Sociale" property="ragioneSociale" />
				<liferay-ui:search-container-column-text name="Data Documento" property="dataOrdine" />
				<%--<liferay-ui:search-container-column-text property="completo" name="Stato" />--%>
				<c:choose>
					<c:when test="${testataNAC.inviato == 1}">
						<liferay-ui:search-container-column-text name="Stato" value="acquisito" />
					</c:when>
					<c:otherwise>
						<liferay-ui:search-container-column-text name="Stato" value="da acquisire" />
					</c:otherwise>
				</c:choose>
				<liferay-ui:search-container-column-jsp align="right" path="/jsps/search-creditNote-action.jsp" valign="middle" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator/>
		</liferay-ui:search-container>
	</aui:form>
</aui:fieldset>