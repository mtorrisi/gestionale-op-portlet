<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@include file="../init.jsp" %>

<liferay-ui:success key="success" message="Greeting saved successfully!"/>

                    
<liferay-ui:search-container delta="20" >

    <liferay-ui:search-container-results results="<%= AnagraficaLocalServiceUtil.getClienti() %>" 
        total="<%= AnagraficaLocalServiceUtil.countClienti() %>"/>
    <liferay-ui:search-container-row className="it.bysoftware.ct.model.Anagrafica" modelVar="clienti">
        <liferay-ui:search-container-column-text name="ragioneSociale" />
        <liferay-ui:search-container-column-text name="indirizzo" />
        <liferay-ui:search-container-column-text name="comune" />
        <liferay-ui:search-container-column-text name="partitaIVA" />
        <liferay-ui:search-container-column-jsp align="right" path="/jsps/action.jsp"/>
    </liferay-ui:search-container-row>
    
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>