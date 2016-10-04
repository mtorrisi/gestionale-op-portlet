<%@page import="it.bysoftware.ct.service.persistence.ClientiDatiAggPK"%>
<%@page import="it.bysoftware.ct.service.ClientiDatiAggLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.ClientiDatiAgg"%>
<%@page import="it.bysoftware.ct.service.AnagraficaLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.model.Anagrafica"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@include file="../../init.jsp" %>

<%
    Associato a = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(renderRequest, "id"));
%>

<liferay-portlet:actionURL name="editAssociato" var="editAssociato"/>
<form id="registra-associato" class="form-horizontal" action="${editAssociato}" method="post">
    <fieldset>
        <aui:field-wrapper >
            <div class="btn-toolbar">
                <div class="btn-group">
                    <button id="btnSave" class="btn" ><i class="icon-save"></i>Salva</button>
                    <button id="btnReset" class="btn" onclick="this.form.reset()"><i class="icon-remove"></i>Reset</button>
                </div>
            </div>
        </aui:field-wrapper>

        <!-- Form Name -->
        <legend>Modifica Associato</legend>

        <aui:layout>
            <aui:column columnWidth="50" first="true" >
                <input id="id" name="<portlet:namespace />id" type="text" placeholder="" class="form-control input-md input-xlarge"  style="display: none" value="<%= a.getId()%>"/>
                <div class="control-group">
                    <label class="control-label" for="ragioneSociale">Codice Associato: </label>  
                    <div class="controls">
                        <input id="id" name="<portlet:namespace />id" type="text" placeholder="" class="form-control input-md input-small" disabled="true" value="<%= a.getIdLiferay()%>"/>
                    </div>
                </div>
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="ragioneSociale">Ragione sociale: </label>  
                    <div class="controls">
                        <input id="ragioneSociale" name="<portlet:namespace />ragioneSociale" type="text" placeholder="" class="form-control input-md input-xlarge" required="" value="<%= a.getRagioneSociale()%>"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="centro">Sezionale IVA: (Assegnato dalla OP) </label>  
                    <div class="controls">
                        <input id="centro" name="<portlet:namespace />centro" type="text" placeholder="" class="form-control input-md input-xlarge" required=""  value="<%= a.getCentro()%>"/>
                        <liferay-ui:icon-help message="help-sezionale-associato"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group" style="display: none;">
                    <label class="control-label" for="pIVA">Partita IVA: </label>  
                    <div class="controls">
                        <input id="pIVA" name="<portlet:namespace />pIVA" type="text" placeholder="" class="form-control input-md input-xlarge" required=""  value="<%= a.getPartitaIVA()%>"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="indirizzo">Sede legale: </label>  
                    <div class="controls">
                        <!--<input id="indirizzo" name="<portlet:namespace />indirizzo" type="text" placeholder="" class="form-control input-md" required=""/>-->
                        <textarea id="indirizzo" name="<portlet:namespace />indirizzo" class="form-control" required=""><%= a.getIndirizzo()%></textarea>
                    </div>
                </div>
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="comune">Comune: </label>  
                    <div class="controls">
                        <input id="comune" name="<portlet:namespace />comune" type="text" placeholder="" class="form-control input-md" required="" value="<%= a.getComune() %> " />
                    </div>
                </div>

            </aui:column>
            <aui:column columnWidth="50" last="true" >
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="telefono">Telefono: </label>  
                    <div class="controls">
                        <input id="telefono" name="<portlet:namespace />telefono" type="text" placeholder="" class="form-control input-md input-xlarge"  value="<%= a.getTelefono()%>"/>
                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="fax">Fax: </label>  
                    <div class="controls">
                        <input id="fax" name="<portlet:namespace />fax" type="text" placeholder="" class="form-control input-md input-xlarge"  value="<%= a.getFax()%>"/>

                    </div>
                </div>
                
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="sezionale_op">Sezionale IVA: (Assegnato alla OP) </label>  
                    <div class="controls">
                        <input id="sezionale_op" name="<portlet:namespace />sezionale_op" type="text" value="<%=a.getSezionaleOP() %>" class="form-control input-md"/>
                        <liferay-ui:icon-help message="help-sezionale-op"/>
                    </div>
                </div>
                
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="email">Email: </label>  
                    <div class="controls">
                        <input id="email" name="<portlet:namespace />email" type="text" placeholder="" class="form-control input-md input-xlarge" required=""  value="<%= a.getEmail()%>"/>
                    </div>
                </div>

                <!-- Password input-->
                 <div class="control-group">
                    <label class="control-label" for="password">Password: </label>  
                    <div class="controls">
                        <input id="password" name="<portlet:namespace />password" type="password" placeholder="" class="form-control input-md" value="<%= a.getPassword()%>"/>
                    </div>
                 </div>
            </aui:column>
        </aui:layout>

    </fieldset>

    <%

        List<Anagrafica> clienti = AnagraficaLocalServiceUtil.getClienti();

        List<KeyValuePair> clientiAssociato = new ArrayList<KeyValuePair>();
        List<KeyValuePair> noClientiAssociato = new ArrayList<KeyValuePair>();

        for (Anagrafica cliente : clienti) {
            boolean flag = false;
            ClientiDatiAgg datiAgg = ClientiDatiAggLocalServiceUtil.fetchClientiDatiAgg(new ClientiDatiAggPK(cliente.getCodiceAnagrafica(), false));
            if(datiAgg != null){
	            String[] idAssociati = datiAgg.getAssociati().split(",");
	            for (String idAssociato : idAssociati) {
	                if (idAssociato.equals(String.valueOf(a.getIdLiferay()))) {
	                    clientiAssociato.add(new KeyValuePair(cliente.getCodiceAnagrafica(), cliente.getRagioneSociale()));
	                    flag = true;
	                    break;
	                }
	            }
	            if (!flag) {
	                noClientiAssociato.add(new KeyValuePair(cliente.getCodiceAnagrafica(), cliente.getRagioneSociale()));
	            }
            }
        }

    %>

    <aui:input name="values" type="hidden" />
    <liferay-ui:input-move-boxes
        leftBoxName="selectedValues"
    leftList="<%=clientiAssociato%>"
        leftReorder="true"
        leftTitle="Selezionati"
        rightBoxName="availableValues"
    rightList="<%=noClientiAssociato%>"
        rightTitle="available"
        />

</form>

<script type="text/javascript">

    YUI().use(
            'aui-form-validator',
            function (Y) {
                var rules = {
    <portlet:namespace />ragioneSociale: {
                            required: true
                        },
    <portlet:namespace />centro: {
                            required: true,
                            maxLength: 3
                        },
    <portlet:namespace />pIVA: {
                            required: true,
                            digits: true,
                            minLength: 11,
                            maxLength: 11
                        },
    <portlet:namespace />indirizzo: {
                            required: true
                        },
    <portlet:namespace />telefono: {
                            digits: true
                        },
    <portlet:namespace />fax: {
                            digits: true
                        },
    <portlet:namespace />email: {
                            email: true,
                            required: true
                        },
    <portlet:namespace />password: {
                            required: true
//                            rangeLength: [4, 8]
                        },
	<portlet:namespace />sezionale_op: {
                            maxLength: 3
                        }
                    };

                    var fieldStrings = {
    <portlet:namespace />ragioneSociale: {
                            required: 'Campo obbligatorio.'
                        },
    <portlet:namespace />indirizzo: {
                            required: 'Campo obbligatorio.'
                        },
    <portlet:namespace />centro: {
                            required: 'Campo obbligatorio.',
                            maxLength: 'Specificare al massimo tre caratteri per il centro.'
                        },
    <portlet:namespace />pIVA: {
                            digits: 'Inserire solo caratteri numerici.',
                            required: "Campo obbligatorio.",
                            maxLength: 'Partita IVA non valida (11 cifre).',
                            minLength: 'Partita IVA non valida (11 cifre).'
                        },
    <portlet:namespace />email: {
                            required: 'Campo obbligatorio.',
                            email: 'Specificare un indirizzo email valido.'
                        },
    <portlet:namespace />telefono: {
                            digits: 'Inserire solo caratteri numerici.'
                        },
    <portlet:namespace />fax: {
                            digits: 'Inserire solo caratteri numerici.'
                        },
    <portlet:namespace />password: {
                            required: 'Campo obbligatorio.',
                            rangeLength: 'La password deve essere compresa tra 4 e 8 caratteri.'
                        }
                    };

                    new Y.FormValidator(
                            {
                                boundingBox: '#registra-associato',
                                fieldStrings: fieldStrings,
                                rules: rules
//                            showAllMessages: true
                            }
                    );
                }
        );

        YUI().use("liferay-util-list-fields", function (Y) {

            Y.one('#btnSave').on('click', function (event) {

                var selectedValues = Liferay.Util.listSelect('#<portlet:namespace/>selectedValues');
                Y.one('#<portlet:namespace/>values').val(selectedValues);
                submitForm('#<portlet:namespace/>fm');
            });
        });

</script>