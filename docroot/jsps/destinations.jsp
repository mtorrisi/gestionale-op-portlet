<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.DestinatariDiversiLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.DestinatariDiversiLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.model.DestinatariDiversi"%>
<%@include file="../init.jsp" %>

<%
String cliente = ParamUtil.getString(request, "codiceCliente", null);
   
List<DestinatariDiversi> destinazioni = DestinatariDiversiLocalServiceUtil.getDestinazioni(cliente);
%>

<liferay-ui:success key="success" message="Greeting saved successfully!"/>


<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna destinaziona alternativa disponibile.">

    <liferay-ui:search-container-results results="<%= destinazioni %>" 
    total="<%= DestinatariDiversiLocalServiceUtil.countDestinazioniDiverse(cliente) %>"/>
    <liferay-ui:search-container-row className="it.bysoftware.ct.model.DestinatariDiversi" modelVar="destinazione">
        <liferay-ui:search-container-column-text   property="indirizzo" name="Indirizzo"/>
        <liferay-ui:search-container-column-text   property="comune"    name="Comune" />
        <liferay-ui:search-container-column-text   property="CAP"       name="CAP"/>
        <liferay-ui:search-container-column-text   property="provincia" name="Provincia"/>
        <liferay-ui:search-container-column-button href="set('${destinazione.indirizzo}|${destinazione.CAP}|${destinazione.comune}|${destinazione.provincia}')" name="Seleziona" align="center" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<script type="text/javascript">

    function set(destinazione) {
        
        var tmp = destinazione.split('|');
        var dest = tmp[0] + " - " + tmp[1] + " " + tmp[2] + " (" + tmp[3] + ")";

        Liferay.Util.getOpener().closePopup(dest, '<portlet:namespace/>dialog');

    }
</script>