<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.its.ct.gestionaleOP.pojos.Documento"%>
<%@page import="java.util.List"%>
<%@include file="../init.jsp" %>

<%
// 	String docs = new String(Base64.decode(ParamUtil.getString(resourceRequest, "docs", null)));

%>

<c:choose>
    <c:when test='<%=SessionMessages.contains(renderRequest, "requestProcessed") %>'>
    <%
    	List<Documento> docs = (List<Documento>) renderRequest.getAttribute("docs");
    %>
    	<h1><%=(docs != null) ? docs.size() : "NULL"%></h1>    
    </c:when>
    <c:otherwise>
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
  	</c:otherwise>
</c:choose>
    