<%@page import="it.its.ct.gestionaleOP.utils.Constants"%>
<%@page import="com.liferay.portal.service.UserIdMapperLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.UserIdMapper"%>
<%@page import="it.its.ct.gestionaleOP.utils.DocumentType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@include file="../init.jsp" %>

<%
    Anagrafica cliente = AnagraficaLocalServiceUtil.getAnagrafica(ParamUtil.getString(renderRequest, "codiceCliente"));
    UserIdMapper userIdMapper = UserIdMapperLocalServiceUtil.getUserIdMapper(Long.parseLong(renderRequest.getRemoteUser()), Constants.FUTURO_NET);
    Associato a = AssociatoLocalServiceUtil.findByLiferayId(userIdMapper.getUserIdMapperId());
    String codiceOperatore = renderRequest.getRemoteUser();
    List<TestataDocumento> listInvoice = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DocumentType.FAV.name(), a.getId());
    LinkedList<TestataDocumento> listToDo = new LinkedList<TestataDocumento>();
    LinkedList<TestataDocumento> listDid = new LinkedList<TestataDocumento>();
    for(TestataDocumento t : listInvoice){
    	if(t.getNota2() != null && t.getNota2().isEmpty()){
    		listToDo.addLast(t);
    	} else {
    		listDid.addLast(t);
    	}
    }
    listInvoice = new ArrayList<TestataDocumento>(listToDo);
    listInvoice.addAll(listDid);
    
    List<TestataDocumento> listInvoice2op = TestataDocumentoLocalServiceUtil.getDocumentiSoggetto(Calendar.getInstance().get(Calendar.YEAR), DocumentType.FAC.name(), a.getId());
    List<TestataDocumento> listInvoiceDirect2op = new ArrayList<TestataDocumento>();
    for (TestataDocumento t : listInvoice2op) {
    	if(t.getNota2() != null && !t.getNota2().equals("") && t.getNumeroOrdine() == Integer.parseInt(t.getNota2()))
    		listInvoiceDirect2op.add(t);
    }
%>

<div id="myTab">
       <ul class="nav nav-tabs">
           <li class="active"><a href="#tab-1">Fatture di vendita</a></li>
           <li><a href="#tab-2">Fatture verso OP</a></li>
       </ul>
       <div class="tab-content">
           <div id="tab-1" class="tab-pane">
			<aui:fieldset label="Elenco Fatture">
			    <aui:form method="post" name="fm" action="${generateInvoice}">
			        <%--<aui:input name="documentIds" />--%>
			        <%--<aui:input name="clientId" value="<%= //cliente.getCodiceAnagrafica()%>"/>--%>
			        <%--<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." rowChecker="<%= new RowChecker(renderResponse)%>">--%>
			        <liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna fattura trovata.">
			            <liferay-ui:search-container-results results="<%= listInvoice%>" 
			            total="<%= listInvoice.size()%>"/>
			            <liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" modelVar="testataFAV" keyProperty="numeroOrdine">
			                <liferay-ui:search-container-column-text property="numeroOrdine" name="N."/>
			                <liferay-ui:search-container-column-text property="codiceSoggetto" name="Codice Cliente" />
			                <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
			                <liferay-ui:search-container-column-text property="dataOrdine" name="Data Documento"/>
			                <liferay-ui:search-container-column-text property="nota2" name="Fatt. conf."/>
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
		</div>
		<div id="tab-2">
			<aui:fieldset label="Elenco fatture dirette alla OP">
		        <liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna fattura trovata.">
		            <liferay-ui:search-container-results results="<%= listInvoiceDirect2op %>" 
		            total="<%= listInvoiceDirect2op.size()%>"/>
		            <liferay-ui:search-container-row className="it.bysoftware.ct.model.TestataDocumento" modelVar="testataFAC" keyProperty="numeroOrdine">
		                <liferay-ui:search-container-column-text property="numeroOrdine" name="N."/>
<%-- 		                <liferay-ui:search-container-column-text property="codiceSoggetto" name="Codice Cliente" /> --%>
		                <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
		                <liferay-ui:search-container-column-text property="dataOrdine" name="Data Documento"/>
		                <c:choose>
		                    <c:when test="${testataFAC.inviato == 1}">
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
			</aui:fieldset>
		</div>
	</div>
</div>

<script type="text/javascript">

    YUI().use(
            'aui-tabview',
            function (Y) {
                new Y.TabView(
                        {
                            srcNode: '#myTab'
                        }
                ).render();
            }
    );
</script>