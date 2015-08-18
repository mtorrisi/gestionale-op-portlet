<%@page import="it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.ClientiDatiAgg"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="java.util.List"%>
<%
    /**
     * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
     *
     * This library is free software; you can redistribute it and/or modify it
     * under the terms of the GNU Lesser General Public License as published by
     * the Free Software Foundation; either version 2.1 of the License, or (at
     * your option) any later version.
     *
     * This library is distributed in the hope that it will be useful, but
     * WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
     * General Public License for more details.
     */
%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@include file="../init.jsp" %>


<%
    List<Anagrafica> clienti = AnagraficaLocalServiceUtil.getClienti();
    List<Anagrafica> clientiAssociato = new ArrayList<Anagrafica>();
    for (Anagrafica cliente : clienti) {
        ClientiDatiAgg datiAgg = ClientiDatiAggLocalServiceUtil.fetchClientiDatiAgg(cliente.getCodiceAnagrafica());
        String[] idAssociati = datiAgg.getAssociati().split(",");
        for (String idAssociato : idAssociati) {
            if (idAssociato.equals(renderRequest.getRemoteUser())) {
                clientiAssociato.add(cliente);
                break;
            }
        }
    }

%>

<liferay-ui:success key="success" message="Greeting saved successfully!"/>

<liferay-ui:search-container delta="20" >

    <liferay-ui:search-container-results results="<%= clientiAssociato%>" 
    total="<%= clientiAssociato.size()%>"/>
    <liferay-ui:search-container-row className="it.bysoftware.ct.model.Anagrafica" modelVar="cliente">
        <liferay-ui:search-container-column-text property="codiceAnagrafica" name="Codice" />        
        <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
        <liferay-ui:search-container-column-text property="indirizzo" name="Indirizzo"/>
        <liferay-ui:search-container-column-text property="comune" name="Comune" />
        <liferay-ui:search-container-column-text property="partitaIVA"  name="Parita IVA"/>
        <liferay-ui:search-container-column-jsp align="right" path="/jsps/action.jsp"/>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>