<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="it.bysoftware.ct.service.persistence.WKTestataDocumentoPK"%>
<%@page import="it.bysoftware.ct.service.WKTestataDocumentoLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.WKTestataDocumento"%>
<%@page import="it.bysoftware.ct.service.WKRigoDocumentoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="it.bysoftware.ct.service.persistence.WKRigoDocumentoPK"%>
<%@page import="it.bysoftware.ct.model.WKRigoDocumento"%>
<%@include file="../init.jsp" %>
<%
	String json = renderRequest.getParameter("WKRigoDocumentoPK");
	WKRigoDocumentoPK rigoDocumentoPK = JSONFactoryUtil.looseDeserializeSafe(json, WKRigoDocumentoPK.class);
	WKRigoDocumento r = WKRigoDocumentoLocalServiceUtil.getWKRigoDocumento(rigoDocumentoPK);
	
	WKTestataDocumentoPK tPK = new WKTestataDocumentoPK(r.getAnno(), r.getNumeroOrdine(), r.getTipoDocumento(), r.getIdAssociato());
%>
<liferay-portlet:renderURL var="popupURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
   	<liferay-portlet:param name="mvcPath" value="/jsps/selectItem.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="selectPackURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
   	<liferay-portlet:param name="mvcPath" value="/jsps/selectPack.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="backURL">
	<liferay-portlet:param name="jspPage" value="/jsps/edit-document.jsp" />
	<liferay-portlet:param name="WKTestataDocumentoPK" value="<%= JSONFactoryUtil.looseSerialize(tPK)%>"/>
</liferay-portlet:renderURL>
<liferay-ui:header backLabel="Back" title="Indietro" backURL="<%=backURL%>" />

<liferay-portlet:actionURL name="saveWKRigoDocumento" var="saveWKRigoDocumento">
	<liferay-portlet:param name="WKRigoDocumentoPK" value="<%= json %>" />
</liferay-portlet:actionURL>

<form id="registra-associato" class="form-horizontal" action="${saveWKRigoDocumento}" method="post">
   	<fieldset>
		<aui:field-wrapper >
   			<div class="btn-toolbar">
       			<div class="btn-group">
           			<button id="btnSave" class="btn" ><i class="icon-check"></i>Convalida</button>
       			</div>
   			</div>  
		</aui:field-wrapper>

			<!-- Form Name -->
       	<legend>Rigo Documento</legend>

		<liferay-ui:error key="no-valid-code" message="Codice articolo non valido" />
       	<aui:layout>
           	<aui:column columnWidth="50" first="true" >
                <input id="codiceAssociato" name="<portlet:namespace />codiceAssociato" type="text" placeholder="" class="form-control input-md"  style="display: none" value="<%= r.getCodiceArticolo() %>"/>

               	<!-- Text input-->
               	<div class="control-group">
                   	<label class="control-label" for="codice">Codice Articolo: </label>  
                   	<div class="controls">
                       	<input id="codice" name="<portlet:namespace />codice" type="text" placeholder="" class="form-control input-md" required=""/>
                   	</div>
               	</div>

               	<!-- Text input-->
               	<div class="control-group">
                   	<label class="control-label" for="descrizione">Descrizione: </label>  
                   	<div class="controls">
                       	<input id="descrizione" name="<portlet:namespace />descrizione" readonly="readonly" value="<%=r.getDescrizione() %>" type="text" placeholder="" class="form-control input-md" required=""/>
                    </div>
                </div>

   	            <!-- Text input-->
       	        <div class="control-group">
           	        <label class="control-label" for="variante">Codice Variante: </label>  
               	    <div class="controls">
                   	    <input id="variante" name="<portlet:namespace />variante" readonly="readonly" value="<%=r.getCodiceVariante() %>" type="text" placeholder="" class="form-control input-md" required=""/>
                   	</div>
               	</div>

               	<!-- Text input-->
               	<div class="control-group">
                   	<label class="control-label" for="quantita">Quantita': </label>  
                   	<div class="controls">
                       	<input id="quantita" name="<portlet:namespace />quantita" readonly="readonly" value="<%=r.getPesoNetto() %>" type="text" placeholder="" class="form-control input-md" required=""/>
                   	</div>
               	</div>

           	</aui:column>
           	<aui:column columnWidth="50" last="true" >
               	<!-- Text input-->
               	<div class="control-group">
                   	<label class="control-label" for="colli">Colli: </label>  
                   	<div class="controls">
                       	<input id="colli" name="<portlet:namespace />colli" readonly="readonly" value="<%= r.getColli() %>" type="text" placeholder="" class="form-control input-md"/>
                    </div>
   	            </div>

       	        <!-- Text input-->
           	    <div class="control-group">
               	    <label class="control-label" for="prezzo">Prezzo: </label>  
                   	<div class="controls">
                       	<input id="prezzo" name="<portlet:namespace />prezzo" readonly="readonly" value="<%=r.getPrezzo() %>" type="text" placeholder="" class="form-control input-md"/>
                    </div>
   	            </div>

       	        <!-- Text input-->
           	    <div class="control-group">
               	    <label class="control-label" for="pesoLordo">Peso Lordo: </label>  
                   	<div class="controls">
                       	<input id="pesoLordo" name="<portlet:namespace />pesoLordo" readonly="readonly" value="<%=r.getPesoLordo() %>" type="text" placeholder="" class="form-control input-md" required=""/>
                    </div>
   	            </div>

       	        <!-- Text input-->
           	    <div class="control-group">
               	    <label class="control-label" for="tara">Tara: </label>  
                   	<div class="controls">
                       	<input id="tara" name="<portlet:namespace />tara" readonly="readonly" value="<%=r.getTara() %>" type="text" placeholder="" class="form-control input-md" required=""/>
                    </div>
   	            </div>

       	        <!-- Text input-->
           	    <div class="control-group">
               	    <label class="control-label" for="lotto">Lotto: </label>  
                   	<div class="controls">
                       	<input id="lotto" name="<portlet:namespace />lotto" readonly="readonly" value="<%=r.getLotto() %>" type="text" placeholder="" class="form-control input-md" required=""/>
                    </div>
   	            </div>
       	    </aui:column>
       	</aui:layout>
	</fieldset>
</form>
        
<script type="text/javascript">
	YUI().use('liferay-util-window', function (Y) {
    	Y.one('#codice').on('click', function (event) {

    		var prezzo = document.getElementById('prezzo').value;
   			var pesoLordo = document.getElementById('pesoLordo').value;
    		var popupUrl = '<%= popupURL %>';
    		var dialogId = '<portlet:namespace/>itemDialog'
    		var title = ' articolo';
   			if(prezzo === "0.0" && pesoLordo === "0.0"){
   				dialogId = '<portlet:namespace/>packDialog'
   				popupUrl = '<%= selectPackURL %>'
   				title = ' imballaggio';
   			}
        	Liferay.Util.openWindow({
            	dialog: {
                	centered: true,
                	modal: true,
                	resizable: false
            	},
            	id: dialogId,
            	title: 'Seleziona' + title ,
            	uri: popupUrl 
        	});
    	});
	});
	
	Liferay.provide(window, 'closePopup', function (data, dialogId) {
        // Closing the dialog
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.hide();
        console.log(data);
//         switch (dialogId) {
//         	case '<portlet:namespace/>itemDialog':
//         	case '<portlet:namespace/>packDialog':
        		var tmp = data.split('|');
                var codice = tmp[0];
                var  descrizione = tmp[1];
                document.getElementById('codice').value = codice;
//                 document.getElementById('descrizione').value = descrizione;
//             break;
        	
//         }
    }, ['liferay-util-window']);
	
	YUI().use("liferay-util-list-fields", function (Y) {

        Y.one('#btnSave').on('click', function (event) {
            submitForm('#<portlet:namespace/>fm');
        });
    });
</script>