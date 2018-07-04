<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.util.ContentUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page
	import="it.bysoftware.ct.service.CessioneCreditoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.CessioneCredito"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="../init.jsp"%>

<%
    int anno = Calendar.getInstance().get(Calendar.YEAR);
    int numeroFattura = ParamUtil.getInteger(renderRequest, "nDoc", -1);
    long idAssociato = ParamUtil.getLong(renderRequest, "idAssociato",
            -1);
    Associato a = AssociatoLocalServiceUtil.getAssociato(idAssociato);
    String codiceCliente = ParamUtil.getString(renderRequest,
            "codiceCliente");
    Anagrafica cliente = AnagraficaLocalServiceUtil
            .getAnagrafica(codiceCliente);
    String indirizzoCompleto = cliente.getIndirizzo() + " - "
            + cliente.getCap() + ", " + cliente.getComune() + " ("
            + cliente.getProvincia() + ") - " + cliente.getStato();
    String dataFattura = ParamUtil.getString(renderRequest,
            "dataFattura");
    double totale = ParamUtil.getDouble(renderRequest, "totaleFattura");

    CessioneCredito cessioneCredito = null;

    if (numeroFattura != -1) {
        cessioneCredito = CessioneCreditoLocalServiceUtil
                .getByAnnoAssociatoNumeroFattura(anno, idAssociato,
                        numeroFattura);
        if (cessioneCredito == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            
            cessioneCredito = CessioneCreditoLocalServiceUtil
                    .createCessioneCredito(0);
            cessioneCredito.setCodiceSoggetto(codiceCliente);
            cessioneCredito.setIdAssociato(idAssociato);
            cessioneCredito.setAnno(anno);
            cessioneCredito.setNumeroFattura(numeroFattura);
            cessioneCredito.setTotale(totale);
            cessioneCredito.setData(formatter.parse(dataFattura));
        }
    }
    DecimalFormat df = new DecimalFormat("#.00");
    String body = ContentUtil
            .get("/content/credit-transfer.tmpl", true);
    body = StringUtil.replace(body, new String[] {
            "[$NUMERO_FATTURA$]", "[$CENTRO$]", "[$TOTALE$]" },
            new String[] { String.valueOf(numeroFattura),
                    a.getCentro(), df.format(totale) });
%>
<portlet:resourceURL var="saveCreditTransferURL" 
        id="saveCreditTransfer"/> 
<portlet:resourceURL var="printCreditTransferURL" 
        id="printCreditTransfer"/>       
<aui:fieldset label="Lettera di Cessione credito">
	<aui:field-wrapper>
		<div class="btn-toolbar">
			<div class="btn-group">
				<button id="btnPrint" class="btn">
					<i class="icon-print"></i>Stampa
				</button>
			</div>
		</div>
	</aui:field-wrapper>
	<aui:layout>
		<aui:column columnWidth="90"
			cssClass="detail-column detail-column-first">
			<aui:input id="ID" type="hidden" name="idCreditTransfer" label="ID"
				cssClass="input-small" disabled="true" inlineField="true"
				value="<%=cessioneCredito.getId()%>" />
			<aui:input id="codiceClienteTxt" type="hidden" name="codCliente"
				label="Codice Cliente" cssClass="input-small" disabled="true"
				inlineField="true" value="<%=cliente.getCodiceAnagrafica()%>" />
			<aui:input id="clienteTxt" type="text" name="cliente" label="Cliente"
				cssClass="input-xxlarge" inlineField="true" disabled="true"
				value="<%=cliente.getRagioneSociale()%>" />
			<aui:input id="destinazioneTxt" type="text" name="destinazione"
				label="Indirizzo" cssClass="input-xxlarge" disabled="true"
				value="<%=indirizzoCompleto%>" inlineField="true" />
			<aui:input id="dataFattura" type="text" name="dataFattura"
				disabled="true" label="Data Documento" inlineField="true"
				value="<%=dataFattura%>" />
		</aui:column>
		<aui:column columnWidth="100"
			cssClass="detail-column detail-column-first">
			<aui:input id="codiceClienteTxt" type="textarea" name="codCliente"
				label="Oggetto: " cssClass="input-xxlarge" disabled="true"
				inlineField="true"
				value="<%="CESSIONE DI CREDITO PRO SOLUTO DIRETTAMENTE AL SOCIO: "
                                + cliente.getCodiceAnagrafica()%>" />
		</aui:column>
		<aui:column columnWidth="50"
			cssClass="detail-column detail-column-first">
			<aui:field-wrapper label="Corpo: ">
				<liferay-ui:input-editor name="body" toolbarSet="simple"
					initMethod="initEditor" width="50%" height="10%" />
			</aui:field-wrapper>
		</aui:column>
		<aui:column columnWidth="50"
			cssClass="detail-column detail-column-last">
			<aui:input id="noteTxt" type="textarea" name="note" label="Note:"
				cssClass="input-xxlarge" inlineField="true"
				value="<%=cessioneCredito.getNote()%>" />
		</aui:column>
	</aui:layout>
</aui:fieldset>

<aui:script>
	function <portlet:namespace />initEditor() {
		return '<%= UnicodeFormatter.toString(body)%>';
	}
	
	AUI().use("aui-base", "aui-io-request", "aui-modal", function(A) {
        A.one('#btnPrint').on('click', function(event) {
            var creditTransferUrl;
            var data = {};
            if (A.one('#<portlet:namespace/>ID').val() !== "0"){
            	creditTransferUrl = '<%= printCreditTransferURL.toString() %>';
            	data = "&<portlet:namespace/>idLettera=" + A.one('#<portlet:namespace/>ID').val();
            } else {
            	document.getElementById("btnPrint").disabled = true;
            	creditTransferUrl = '<%= saveCreditTransferURL.toString() %>';
            	data = "?<portlet:namespace/>dataFattura=" + <%= dataFattura %> +
            			"&<portlet:namespace/>codiceSoggetto=" + <%= cessioneCredito.getCodiceSoggetto() %> +
            			"&<portlet:namespace/>idAssociato=" + <%= String.valueOf(cessioneCredito.getIdAssociato()) %> +
            			"&<portlet:namespace/>numeroFattura=" + <%= String.valueOf(cessioneCredito.getNumeroFattura()) %> +
            			"&<portlet:namespace/>totaleFattura=" + <%= String.valueOf(cessioneCredito.getTotale()) %>
            }
            data = data + "&<portlet:namespace/>note=" + A.one('#<portlet:namespace/>noteTxt').val() +
                "&<portlet:namespace/>body=" + window.<portlet:namespace />body.getHTML();
            console.log(creditTransferUrl);
            var win = window.open(creditTransferUrl + data, '_blank');
            win.focus();
        });
    });
</aui:script>