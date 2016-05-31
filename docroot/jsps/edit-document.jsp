<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.WKRigoDocumento"%>
<%@page import="it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.WKTestataDocumento"%>
<%@page import="it.bysoftware.ct.service.persistence.WKTestataDocumentoPK"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@include file="../init.jsp" %>

<%
	String JSON = renderRequest.getParameter("WKTestataDocumentoPK"); 
	WKTestataDocumentoPK testataDocumentoPK = JSONFactoryUtil.looseDeserializeSafe(JSON, WKTestataDocumentoPK.class);
	WKTestataDocumento testataDocumento = null;
	String label = "";
	List<WKRigoDocumento> rows = null;
	if(testataDocumentoPK != null){
		testataDocumento = WKTestataDocumentoLocalServiceUtil.getWKTestataDocumento(testataDocumentoPK);
		if(testataDocumento.getTipoDocumento().equals("DDT")){
			label = "Documento di Trasporto";
		} else if(testataDocumento.getTipoDocumento().equals("FAV")) {
			label = "Fattura di Vendita";
		} else if(testataDocumento.getTipoDocumento().equals("NAC"))
			testataDocumento.getTipoDocumento().equals("NAC");
		rows = WKRigoDocumentoLocalServiceUtil.getByNumeroOrdineAnnoAssociatoTipoDocumento(testataDocumento.getNumeroOrdine(), testataDocumento.getAnno(), testataDocumento.getIdAssociato(), testataDocumento.getTipoDocumento());
	}
	
%>

<liferay-portlet:renderURL var="popupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
   	<liferay-portlet:param name="mvcPath" value="/jsps/select-customer.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="jspPage" value="/jsps/validate.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:header backLabel="Back" title="Indietro" backURL="<%=backURL%>" />
	
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <button id="btnSave" class="btn" ><i class="icon-hdd"></i>Salva</button>
        </div>
    </div>  
</aui:field-wrapper>

<c:if test="<%= testataDocumento != null %>">
	<aui:fieldset label="<%=label %>">
	    <aui:layout>
	        <aui:column columnWidth="70" cssClass="detail-column detail-column-first">
	            <aui:input id="codiceClienteTxt" type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true" value="<%=testataDocumento.getCodiceSoggetto()%>" />
	            <aui:input id="clienteTxt" type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true" value="<%=testataDocumento.getRagioneSociale()%>"/>
	            <aui:input id="orderDate"    type="text" name="dataOrdine"   label="Data Documento" inlineField="true" value="<%= testataDocumento.getDataOrdine()%>"/>
	            <aui:input id="deliveryDate" type="text" name="dataConsegna" label="Data Trasporto" inlineField="true" value="<%= testataDocumento.getDataOrdine()%>"/>
	            <aui:input id="lottoTestata" type="text" name="lottoTestata" label="Lotto" cssClass="input-small" inlineField="true" value="<%= rows.get(0).getLotto() %>"/>
	        </aui:column>
	        <aui:column columnWidth="20" cssClass="test" last="true" >
	            <aui:input type="text" name="nDoc" label="N. Documento" disabled="true" style="width: 90%" value="<%=testataDocumento.getNumeroOrdine() %>"/>
	        </aui:column>
	    </aui:layout>
	</aui:fieldset>
	
	<aui:fieldset label="Corpo Documento">
		<liferay-ui:search-container delta="20" emptyResultsMessage="Nessun rigo da verificare" >
    	<liferay-ui:search-container-results>
     	<% 
            results = ListUtil.subList(rows, searchContainer.getStart(), searchContainer.getEnd());
            total = rows.size();
            pageContext.setAttribute("results", results);
            pageContext.setAttribute("total", total);
        %>
    	</liferay-ui:search-container-results>
    		<liferay-ui:search-container-row className="it.bysoftware.ct.model.WKRigoDocumento" modelVar="r">
        		<c:if test="<%= !r.getCodiceArticolo().equals("") %>">
        			<liferay-ui:search-container-column-text property="codiceArticolo" name="Codice"/>
					<liferay-ui:search-container-column-text property="descrizione" name="Descrizone" />
					<liferay-ui:search-container-column-text value="<%= r.getPrezzo() != 0 ? String.valueOf(r.getPrezzo()) : "" %>" name="Prezzo"/>
        			<c:choose>
        				<c:when test="<%= !r.getVerificato() %>">
							<liferay-ui:search-container-column-jsp align="right" path="/jsps/action-check-row.jsp" name="Verifica"/>
						</c:when>
						<c:otherwise>
							<liferay-ui:search-container-column-text value="" name="Verifica"/>
						</c:otherwise>
					</c:choose>
				</c:if>
    		</liferay-ui:search-container-row>

    		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="true"/>
		</liferay-ui:search-container>
	</aui:fieldset>
</c:if>


<script type="text/javascript">
	YUI().use('liferay-util-window', function (Y) {
    	Y.one('#<portlet:namespace/>clienteTxt').on('click', function (event) {

        	Liferay.Util.openWindow({
            	dialog: {
                	centered: true,
                	modal: true,
                	resizable: false
            	},
            	id: '<portlet:namespace/>dialog',
            	title: 'Seleziona Cliente',
            	uri: '<%=popupURL%>'
        	});
    	});
	});
	
	Liferay.provide(window, 'closePopup', function (data, dialogId) {
        // Closing the dialog
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.hide();
        console.log(data);
        switch (dialogId) {
            case '<portlet:namespace/>dialog':
                var tmp = data.split('|');
                var ragioneSociale = tmp[0];
                var codice = tmp[1];
                document.getElementById('<portlet:namespace/>clienteTxt').value = ragioneSociale;
                document.getElementById('<portlet:namespace/>codiceClienteTxt').value = codice;
                break;
        }
    }, ['liferay-util-window']);
</script>