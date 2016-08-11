<%@page import="it.its.ct.gestionaleOP.utils.DocumentType"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="it.bysoftware.ct.model.TestataDocumento"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.TestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@include file="../../init.jsp" %>

<%
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	String dateFrom = ParamUtil.getString(request, "dateFrom", "");
	String dateTo = ParamUtil.getString(request, "dateTo", "");
	System.out.println("date from: " + dateFrom + " to: " + dateTo);
	long id = ParamUtil.getLong(renderRequest, "associato", 0);
	Associato a = AssociatoLocalServiceUtil.getAssociato(id);
    List<TestataDocumento> testateFatture = TestataDocumentoLocalServiceUtil.getByCodiceOperatore(String.valueOf(a.getIdLiferay()), "completo", 1);
	List<TestataDocumento> testate = new ArrayList<TestataDocumento>();
	List<TestataDocumento> testateConferimento = new ArrayList<TestataDocumento>();
	List<TestataDocumento> testateNote = new ArrayList<TestataDocumento>();
	for(TestataDocumento t : testateFatture)
		if(t.getTipoDocumento().equals(DocumentType.FAV.name())){
			if(!dateFrom.equals("") && !dateTo.equals("")){
				Date d = formatter.parse(t.getDataOrdine());
// 				if(d.after(formatter.parse(dateFrom)) && d.before(formatter.parse(dateTo))){
				if(d.compareTo(formatter.parse(dateFrom)) >= 0 && d.compareTo(formatter.parse(dateTo)) <= 0){
					testate.add(t);
				}
			} else
				testate.add(t);
			
		} else if (t.getTipoDocumento().equals(DocumentType.FAC.name())){
			if(!dateFrom.equals("") && !dateTo.equals("")){
				Date d = formatter.parse(t.getDataOrdine());
// 				if(d.after(formatter.parse(dateFrom)) && d.before(formatter.parse(dateTo))){
				if(d.compareTo(formatter.parse(dateFrom)) >= 0 && d.compareTo(formatter.parse(dateTo)) <= 0){
					testateConferimento.add(t);
				}
			} else
				testateConferimento.add(t);
		} else if (t.getTipoDocumento().equals(DocumentType.NAC.name())){
			if(!dateFrom.equals("") && !dateTo.equals("")){
				Date d = formatter.parse(t.getDataOrdine());
// 				if(d.after(formatter.parse(dateFrom)) && d.before(formatter.parse(dateTo))){
				if(d.compareTo(formatter.parse(dateFrom)) >= 0 && d.compareTo(formatter.parse(dateTo)) <= 0){
					testateNote.add(t);
				}
			} else
				testateNote.add(t);
		}
	
	List<TestataDocumento> testateFattureConferimento = TestataDocumentoLocalServiceUtil.getByCodiceOperatore(String.valueOf(a.getIdLiferay()), "completo", 1);
	

	PortletURL renderURL = renderResponse.createRenderURL();
    renderURL.setWindowState(LiferayWindowState.NORMAL);
    renderURL.setParameter("associato", String.valueOf(id));
    renderURL.setParameter("jspPage", "/jsps/op/view-downloaded.jsp"); //current page path
%>
<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="jspPage" value="/jsps/op/view.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:header backLabel="Back" title="Indietro" backURL="<%=backURL%>" />
<aui:form name="searchForm" action="<%=renderURL%>" method="post">
				<aui:input id="dateFrom" type="text" name="dateFrom" label="Documenti dal:" inlineField="true" />
				<aui:input id="dateTo" 	 type="text" name="dateTo"   label="al:" 			inlineField="true" />
				<aui:button type="submit" value="Filtra" />
			</aui:form>
<div id="myTab">

       <ul class="nav nav-tabs">
           <li class="active"><a href="#tab-1">Fatture vendita</a></li>
           <li><a href="#tab-2">Fatture conferimento</a></li>
           <li><a href="#tab-3">Note di credito</a></li>
       </ul>
       <div class="tab-content">
           <div id="tab-1" class="tab-pane">
			<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." iteratorURL="<%= renderURL %>">
			
			    <liferay-ui:search-container-results >
			        <%
			            results = ListUtil.subList(testate, searchContainer.getStart(), searchContainer.getEnd());
			            total = testate.size();
			            pageContext.setAttribute("results", results);
			            pageContext.setAttribute("total", total);
			        %>
			    </liferay-ui:search-container-results>
			    <div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />documenti">
			        <liferay-ui:search-container-row className="TestataDocumento" modelVar="testata">
			            <liferay-ui:search-container-column-text property="anno" name="Anno"/>
			            <liferay-ui:search-container-column-text property="numeroOrdine" name="N. Documento" />
			            <liferay-ui:search-container-column-text property="dataOrdine" name="Data"/>
			            <liferay-ui:search-container-column-text property="ragioneSociale" name="Cliente"/>
			            <liferay-ui:search-container-column-jsp path="/jsps/op/download-action.jsp"/>
			        </liferay-ui:search-container-row>
			
			        <liferay-ui:search-iterator searchContainer="<%= searchContainer%>" paginate="true"/>
			    </div>
			</liferay-ui:search-container>
		</div>
		<div id="tab-2">
			<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." iteratorURL="<%= renderURL %>">
			
			    <liferay-ui:search-container-results >
			        <%
			            results = ListUtil.subList(testateConferimento, searchContainer.getStart(), searchContainer.getEnd());
			            total = testate.size();
			            pageContext.setAttribute("results", results);
			            pageContext.setAttribute("total", total);
			        %>
			    </liferay-ui:search-container-results>
			    <div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />documenti">
			        <liferay-ui:search-container-row className="TestataDocumento" modelVar="testata">
			            <liferay-ui:search-container-column-text property="anno" name="Anno"/>
			            <liferay-ui:search-container-column-text property="numeroOrdine" name="N. Documento" />
			            <liferay-ui:search-container-column-text property="dataOrdine" name="Data"/>
			            <liferay-ui:search-container-column-text property="ragioneSociale" name="Cliente"/>
			            <liferay-ui:search-container-column-jsp path="/jsps/op/download-action.jsp"/>
			        </liferay-ui:search-container-row>
			
			        <liferay-ui:search-iterator searchContainer="<%= searchContainer%>" paginate="true"/>
			    </div>
			</liferay-ui:search-container>
		</div>
		<div id="tab-3">
			<liferay-ui:search-container delta="20" emptyResultsMessage="Nessuna documento trovato." iteratorURL="<%= renderURL %>">
			
			    <liferay-ui:search-container-results >
			        <%
			            results = ListUtil.subList(testateNote, searchContainer.getStart(), searchContainer.getEnd());
			            total = testate.size();
			            pageContext.setAttribute("results", results);
			            pageContext.setAttribute("total", total);
			        %>
			    </liferay-ui:search-container-results>
			    <div class="taglib-search-iterator-page-iterator-bottom" id="<portlet:namespace />documenti">
			        <liferay-ui:search-container-row className="TestataDocumento" modelVar="testata">
			            <liferay-ui:search-container-column-text property="anno" name="Anno"/>
			            <liferay-ui:search-container-column-text property="numeroOrdine" name="N. Documento" />
			            <liferay-ui:search-container-column-text property="dataOrdine" name="Data"/>
			            <liferay-ui:search-container-column-text property="ragioneSociale" name="Cliente"/>
			            <liferay-ui:search-container-column-jsp path="/jsps/op/download-action.jsp"/>
			        </liferay-ui:search-container-row>
			
			        <liferay-ui:search-iterator searchContainer="<%= searchContainer%>" paginate="true"/>
			    </div>
			</liferay-ui:search-container>
		</div>
	</div>
</div>
<script type="text/javascript">

YUI({lang: 'it'}).use('aui-datepicker', 'aui-modal', function (Y) {

            var orderDate = new Y.DatePicker({
                trigger: '#<portlet:namespace />dateFrom',
                mask: '%d/%m/%Y',
                
                popover: {
                    position: 'top',
                    toolbars: {
                        header: [[
                                {
                                    icon: 'icon-trash',
                                    label: 'Cancella',
                                    on: {
                                        click: function () {
                                            orderDate.clearSelection();
                                        }
                                    }
                                }
                            ]]
                    },
                    zIndex: 1
                },
                on: {
                    selectionChange: function (event) {
                        console.log(event.newSelection);
                    }
                }
            });
            var deliveryDate = new Y.DatePicker({
                trigger: '#<portlet:namespace />dateTo',
                mask: '%d/%m/%Y',
                popover: {
                    position: 'top',
                    toolbars: {
                        header: [[
                                {
                                    icon: 'icon-trash',
                                    label: 'Cancella',
                                    on: {
                                        click: function () {
                                            deliveryDate.clearSelection();
                                        }
                                    }
                                }
                            ]]
                    },
                    zIndex: 1
                },
                on: {
                    selectionChange: function (event) {
                        console.log(event.newSelection);
                    }
                }
            });

        });
        
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