<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.WKTestataDocumento"%>
<%@page import="it.bysoftware.ct.model.WKRigoDocumento"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.its.ct.gestionaleOP.pojos.Documento"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@include file="../init.jsp" %>

<%
	List<Documento> docsReady = (List<Documento>) renderRequest.getAttribute("docsReady");;
// 	if(docsReady == null)
// 		docsReady = new ArrayList<Documento>();

	List<Documento> docsToCheck  = (List<Documento>) renderRequest.getAttribute("docsToCheck");
// 	if(docsToCheck == null)
// 		docsToCheck = new ArrayList<Documento>();

	boolean viewImport = true;
	if(docsReady != null || docsToCheck != null){
		viewImport = false;
	} else { // vedo se ci sono importazioni in sospeso
		docsReady = new ArrayList<Documento>();
		docsToCheck = new ArrayList<Documento>();
		Associato a = AssociatoLocalServiceUtil.findByLiferayId(Long.parseLong(renderRequest.getRemoteUser()));
		List<WKTestataDocumento> testateDocumentoReady = WKTestataDocumentoLocalServiceUtil.getReady(Calendar.getInstance().get(Calendar.YEAR), a.getId());
		List<WKTestataDocumento> testateDocumentoToCheck = WKTestataDocumentoLocalServiceUtil.getToCheck(Calendar.getInstance().get(Calendar.YEAR), a.getId());
		if(!testateDocumentoReady.isEmpty() || !testateDocumentoToCheck.isEmpty()){
			viewImport = false;
			for(WKTestataDocumento t : testateDocumentoReady){
				Documento d = new Documento();
				d.setTestata(t);
				List<WKRigoDocumento> righe = WKRigoDocumentoLocalServiceUtil.getByNumeroOrdineAnnoAssociatoTipoDocumento(t.getNumeroOrdine(), t.getAnno(), t.getIdAssociato(), t.getTipoDocumento());
				if(righe != null){
					boolean addReady = true;
					d.setRighe(righe);
					for(WKRigoDocumento r : righe)
						if(!r.getVerificato()){
							addReady = false;
							break;
						}
					if(addReady)
						docsReady.add(d);
					else
						docsToCheck.add(d);
				}
			}
			for(WKTestataDocumento t : testateDocumentoToCheck){
				Documento d = new Documento();
				d.setTestata(t);
				d.setRighe(WKRigoDocumentoLocalServiceUtil.getByNumeroOrdineAnnoAssociatoTipoDocumento(t.getNumeroOrdine(), t.getAnno(), t.getIdAssociato(), t.getTipoDocumento()));
				docsToCheck.add(d);
			}
		}	
	} 
		
%>
<c:choose>
<c:when test="<%=viewImport %>">
	<liferay-portlet:actionURL name="upload" var="uploadFileURL">
		<liferay-portlet:param name="idAssociato" value="<%= renderRequest.getRemoteUser()%>"  />
	</liferay-portlet:actionURL>

	<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post" >
		<aui:fieldset label="Carica File">
			<liferay-ui:error key="empty-file" message="Hai importato un file vuoto"/>
 			<liferay-ui:error key="disk-space" message="Spazio disco insufficente."/>
			<aui:layout>
    			<aui:column columnWidth="100" first="true">
	        		<aui:input type="file" name="fileupload" inlineField="true" label="File">
						<aui:validator name="required" />
					</aui:input>
					<aui:button name="Save" value="Importa" type="submit" />
      			</aui:column>
  			</aui:layout>
		</aui:fieldset>
	</aui:form>
</c:when>
<c:otherwise>
<aui:layout>
	<liferay-portlet:actionURL name="saveImported" var="saveImportedURL">
		<liferay-portlet:param name="idAssociato" value="<%= renderRequest.getRemoteUser()%>"  />
	</liferay-portlet:actionURL>
    <aui:column columnWidth="50" first="true" >
		<aui:fieldset label="Documenti da importare">
		<aui:field-wrapper >
		    <div class="btn-toolbar">
        		<div class="btn-group">
            		<button id="btnSave" class="btn" ><i class="icon-hdd"></i>Salva</button>
				</div>
			</div>
		</aui:field-wrapper>
			<aui:form method="post" name="fm" action="<%= saveImportedURL %>">
				<liferay-ui:search-container delta="20" emptyResultsMessage="Nessun documento pronto per l'importazione" >
    				<liferay-ui:search-container-results>
     				<% 
	            		results = ListUtil.subList(docsReady, searchContainer.getStart(), searchContainer.getEnd());
        	    		total = docsReady.size();
	    	        	pageContext.setAttribute("results", results);
	            		pageContext.setAttribute("total", total);
	        		%>
    				</liferay-ui:search-container-results>
    				<liferay-ui:search-container-row className="it.its.ct.gestionaleOP.pojos.Documento" modelVar="d">
        				<liferay-ui:search-container-column-text value="<%= d.getTestata().getTipoDocumento() %>" name="Tipo Documento" />
						<liferay-ui:search-container-column-text value="<%= String.valueOf(d.getTestata().getNumeroOrdine()) %>" name="Numero Documento" />
        				<liferay-ui:search-container-column-text value="<%= d.getTestata().getCodiceSoggetto() %>" name="Codice Soggetto" />
        				<liferay-ui:search-container-column-text value="<%= d.getTestata().getRagioneSociale() %>" name="Rag. Sociale" />
    				</liferay-ui:search-container-row>

    				<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="true"/>
				</liferay-ui:search-container>
			</aui:form>
		</aui:fieldset>
	</aui:column>
	<aui:column columnWidth="50" last="true" >
	<aui:fieldset label="Documenti da verificare">
			<liferay-ui:search-container delta="20" emptyResultsMessage="Nessun documento da verificare" >
    		<liferay-ui:search-container-results>
     		<% 
            	results = ListUtil.subList(docsToCheck, searchContainer.getStart(), searchContainer.getEnd());
            	total = docsToCheck.size();
            	pageContext.setAttribute("results", results);
            	pageContext.setAttribute("total", total);
        	%>
    		</liferay-ui:search-container-results>
    			<liferay-ui:search-container-row className="it.its.ct.gestionaleOP.pojos.Documento" modelVar="d">
        			<liferay-ui:search-container-column-text value="<%= d.getTestata().getTipoDocumento() %>" name="Tipo Documento" />
					<liferay-ui:search-container-column-text value="<%= String.valueOf(d.getTestata().getNumeroOrdine()) %>" name="Numero Documento" />
        			<liferay-ui:search-container-column-text value="<%= d.getTestata().getCodiceSoggetto() %>" name="Codice Soggetto" />
        			<liferay-ui:search-container-column-text value="<%= d.getTestata().getRagioneSociale() %>" name="Rag. Sociale" />
					<liferay-ui:search-container-column-jsp align="right" path="/jsps/action-check-docs.jsp" />
    			</liferay-ui:search-container-row>

    			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="true"/>
			</liferay-ui:search-container>
		</aui:fieldset>		
	</aui:column>
</aui:layout>	
</c:otherwise>
</c:choose>

<script type="text/javascript">
	YUI().use("liferay-util-list-fields", function (Y) {

        Y.one('#btnSave').on('click', function (event) {
            submitForm(document.<portlet:namespace/>fm);
        });
    });
</script>