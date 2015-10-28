<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@include file="../init.jsp" %>

<%
    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(renderRequest.getRemoteUser()));
    String codiceOperatore = renderRequest.getRemoteUser();
    List<TestataDocumento> listInvoice = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), "FAV", a.getId());


%>
<aui:fieldset label="Elenco Fatture">
    <aui:form method="post" name="fm" action="${generateInvoice}">
        <aui:input name="documentIds" />
        <%--<aui:input name="clientId" value="<%= //cliente.getCodiceAnagrafica()%>"/>--%>
        <liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." rowChecker="<%= new RowChecker(renderResponse)%>">

            <liferay-ui:search-container-results results="<%= listInvoice%>" 
            total="<%= listInvoice.size()%>"/>
            <liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" modelVar="testataFAV" keyProperty="numeroOrdine">
                <liferay-ui:search-container-column-text property="numeroOrdine" name="N°"/>
                <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
                <liferay-ui:search-container-column-text property="dataOrdine" name="Data Documento"/>
                <%--<liferay-ui:search-container-column-text property="completo" name="Stato"/>--%>
                <c:choose>
                    <c:when test="${testataFAV.inviato == 1}">
                        <liferay-ui:search-container-column-text name="Stato" value="acquisito"/>
                    </c:when>
                    <c:otherwise>
                        <liferay-ui:search-container-column-text name="Stato" value="da acquisire"/>
                    </c:otherwise>
                </c:choose>
                <liferay-ui:search-container-column-jsp align="right" valign="middle" path="/jsps/search-invoice-action.jsp"/>
            </liferay-ui:search-container-row>

            <liferay-ui:search-iterator/>
        </liferay-ui:search-container>
    </aui:form>
</aui:fieldset>

