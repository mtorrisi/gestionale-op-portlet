<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="it.its.ct.gestionaleOP.pojos.Documento"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@include file="../init.jsp" %>
<portlet:defineObjects />

<c:choose>
    <c:when test='<%=SessionMessages.contains(renderRequest, "requestProcessed") %>'>
    <%
    	List<Documento> docs = (List<Documento>) renderRequest.getAttribute("docs");
    	String json = JSONFactoryUtil.looseSerialize(docs, "righe");
    %>
    
        <aui:script>
            // If needed
            Liferay.Util.getOpener().closePopup(<%=json %>, '<portlet:namespace/>upload');
        </aui:script>
    </c:when>
    <c:otherwise>
 
		<liferay-portlet:actionURL name="upload" var="uploadFileURL">
    		<liferay-portlet:param name="idAssociato" value="<%= renderRequest.getRemoteUser()%>"  />
		</liferay-portlet:actionURL>
 
		<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">
 
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
 
		</aui:form>
	</c:otherwise>
</c:choose>