<%@page import="java.net.URLEncoder"%>
<%@page import="it.bysoftware.ct.service.DescrizioniDocumentiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.DescrizioniDocumenti"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="../init.jsp" %>

<fieldset>

    <!-- Form Name -->
    <legend>Inserisci Descrizione</legend>

    <!-- Textarea -->
    <div class="control-group">
        <label class="control-label" for="descrizione">Descrizione:</label>
        <div class="controls">                     
            <textarea class="form-control input-xxlarge" id="descrizione" name="<portlet:namespace />descrizione"></textarea>
        </div>
        <button id="btnSeleziona" class="btn" onclick="set()">Inserisci</button>
    </div>

</fieldset>

<fieldset>
    <legend>Seleziona Descrizione</legend>
    <liferay-ui:search-container delta="20" >

        <liferay-ui:search-container-results results="<%= DescrizioniDocumentiLocalServiceUtil.getDescrizioniDocumentis(0, DescrizioniDocumentiLocalServiceUtil.getDescrizioniDocumentisCount())%>" 
        total="<%= DescrizioniDocumentiLocalServiceUtil.getDescrizioniDocumentisCount()%>"/>
        <liferay-ui:search-container-row className="DescrizioniDocumenti" modelVar="currentDescr">
            <liferay-ui:search-container-column-text property="descrizione" name="Descrizione" />
            <liferay-ui:search-container-column-button href="set('${currentDescr.descrizione}')" name="Seleziona" align="center" />
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