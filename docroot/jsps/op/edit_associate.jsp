<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@include file="../../init.jsp" %>

<liferay-portlet:actionURL name="editAssociato" var="editAssociato"/>

<%
    Associato a = AssociatoLocalServiceUtil.getAssociato(ParamUtil.getLong(renderRequest, "id"));
%>

<aui:form action="${editAssociato}" method="post" cssClass="form-horizontal"> 
<!--<form id="registra-associato" class="form-horizontal" action="${editAssociato}" method="post">-->
    <fieldset>
        <aui:field-wrapper >
            <div class="btn-toolbar">
                <div class="btn-group">
                    <button id="btnSave" class="btn" ><i class="icon-save"></i>Salva</button>
                    <button id="btnReset" class="btn" ><i class="icon-remove"></i>Reset</button>
                </div>
            </div>
        </aui:field-wrapper>

        <!-- Form Name -->
        <legend>Modifica Associato</legend>

        <aui:layout>
            <aui:column columnWidth="50" first="true" >
                <input id="id" name="<portlet:namespace />id" type="text" placeholder="" class="form-control input-md input-xlarge"  style="display: none"/>

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
                        <input id="indirizzo" name="<portlet:namespace />indirizzo" type="text" placeholder="" class="form-control input-md input-xlarge" required=""  value="<%= a.getIndirizzo()%>"/>

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
                <!--                <div class="control-group" style="display: none;">
                                    <label class="control-label" for="password">Password: </label>
                                    <div class="controls">
                                        <input id="password" name="<portlet:namespace />password" type="password" placeholder="" class="form-control input-md" required="" />
                
                                    </div>
                                </div>-->
            </aui:column>
        </aui:layout>

        <!-- Button (Double) -->
        <!--        <div class="control-group">
                    <label class="control-label" for="salva"></label>
                    <div class="btn-group">
                        <button id="btnSave" class="btn" ><i class="icon-save"></i>Salva</button>
                        <button id="btnReset" class="btn" ><i class="icon-remove"></i>Reset</button>
                    </div>
                </div>-->
    </fieldset>
</aui:form>
<!--</form>-->

<script type="text/javascript">

    YUI().use(
            'aui-form-validator',
            function (Y) {
                var rules = {
                    ragioneSociale: {
                        required: true
                    },
                    centro: {
                        required: true,
                        maxLength: 3
                    },
                    pIVA: {
                        required: true,
                        digits: true,
                        minLength: 11,
                        maxLength: 11
                    },
                    indirizzo: {
                        required: true
                    },
                    telefono: {
                        digits: true
                    },
                    fax: {
                        digits: true
                    },
                    email: {
                        email: true,
                        required: true
                    },
                    password: {
                        required: true,
                        rangeLength: [4, 8]
                    }
                };

                var fieldStrings = {
                    ragioneSociale: {
                        required: 'Campo obbligatorio.'
                    },
                    indirizzo: {
                        required: 'Campo obbligatorio.'
                    },
                    centro: {
                        required: 'Campo obbligatorio.',
                        maxLength: 'Specificare al massimo tre caratteri per il centro.'
                    },
                    pIVA: {
                        digits: 'Inserire solo caratteri numerici.',
                        required: "Campo obbligatorio.",
                        maxLength: 'Partita IVA non valida (11 cifre).',
                        minLength: 'Partita IVA non valida (11 cifre).'
                    },
                    email: {
                        required: 'Campo obbligatorio.',
                        email: 'Specificare un indirizzo email valido.'
                    },
                    telefono: {
                        digits: 'Inserire solo caratteri numerici.'
                    },
                    fax: {
                        digits: 'Inserire solo caratteri numerici.'
                    },
                    password: {
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