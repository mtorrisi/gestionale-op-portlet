<%@page import="it.bysoftware.ct.service.VociIvaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.VociIva"%>
<%@ page import="it.bysoftware.ct.model.DescrizioniDocumenti" %>
<%@ page import="it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil" %>

<%@ include file="../init.jsp" %>

<fieldset>

	<!-- Form Name -->
	<legend>Inserisci Descrizione</legend>

	<!-- Textarea -->
	<div class="control-group">
		<label class="control-label" for="descrizione">Descrizione:</label>
		<div class="controls">
			<textarea class="form-control input-xxlarge" id="descrizione" name="<portlet:namespace />descrizione"></textarea>
		</div>
		<button class="btn" id="btnSeleziona" onclick="set()">Inserisci</button>
	</div>

</fieldset>

<fieldset>
	<legend>Seleziona Descrizione</legend>
	<liferay-ui:search-container delta="20">

		<liferay-ui:search-container-results results="<%= DescrizioniDocumentiLocalServiceUtil.getDescrizioniDocumentis(0, DescrizioniDocumentiLocalServiceUtil.getDescrizioniDocumentisCount()) %>"
		total="<%= DescrizioniDocumentiLocalServiceUtil.getDescrizioniDocumentisCount() %>" />
		<liferay-ui:search-container-row className="DescrizioniDocumenti" modelVar="currentDescr">
			<liferay-ui:search-container-column-text name="Descrizione" property="descrizione" />
			<%
			    VociIva iva = VociIvaLocalServiceUtil.fetchVociIva(currentDescr.getCodiceIVA());
			    double aliquota = 0.0;
			    if(iva != null)
			       currentDescr.setCodiceIVA(currentDescr.getCodiceIVA() + "|" + iva.getAliquota());
			%>
			<liferay-ui:search-container-column-button align="center" href="set('${currentDescr.descrizione}|${currentDescr.codiceDescrizione}|${currentDescr.codiceIVA}')" name="Seleziona" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</fieldset>

<script type="text/javascript">

	function set(descrizione) {
		console.log("1");
		console.log("Descrizione: " + descrizione);
		if (descrizione) {
			console.log("Descrizione2: " + descrizione);
			Liferay.Util.getOpener().closePopup(descrizione, '<portlet:namespace/>DescriptionDialog');
		} else {
			console.log("Descrizione1: " + document.getElementById('descrizione').value);
			Liferay.Util.getOpener().closePopup(document.getElementById('descrizione').value, '<portlet:namespace/>DescriptionDialog');
		}
	}

</script>