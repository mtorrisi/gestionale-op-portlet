<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@include file="../../init.jsp" %>

<liferay-portlet:actionURL name="editAssociato" var="editAssociato"/>

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

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="ragioneSociale">Ragione sociale: </label>  
                    <div class="controls">
                        <input id="ragioneSociale" name="<portlet:namespace />ragioneSociale" type="text" placeholder="" class="form-control input-md input-xlarge" required="" value="<%= a.getRagioneSociale()%>"/>

                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="centro">Centro: </label>  
                    <div class="controls">
                        <input id="centro" name="<portlet:namespace />centro" type="text" placeholder="" class="form-control input-md input-xlarge" required=""  value="<%= a.getCentro()%>"/>

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
                    <label class="control-label" for="indirizzo">Indirizzo: </label>  
                    <div class="controls">
                        <!--<input id="indirizzo" name="<portlet:namespace />indirizzo" type="text" placeholder="" class="form-control input-md" required=""/>-->
                        <textarea id="indirizzo" name="<portlet:namespace />indirizzo" class="form-control" required=""><%= a.getIndirizzo()%></textarea>
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
                    <label class="control-label" for="email">Email: </label>  
                    <div class="controls">
                        <input id="email" name="<portlet:namespace />email" type="text" placeholder="" class="form-control input-md input-xlarge" required=""  value="<%= a.getEmail()%>"/>

                    </div>
                </div>

                <!-- Password input-->
                <!--<input id="password" name="<portlet:namespace />password" type="password" placeholder="" class="form-control input-md" value="<%= a.getPassword()%>"/>-->
            </aui:column>
        </aui:layout>

    </fieldset>
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
                            required: true,
                            rangeLength: [4, 8]
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

</script>