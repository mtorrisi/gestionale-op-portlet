<%@page import="it.bysoftware.ct.model.Associato"%>
<%@page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil"%>
<%@include file="../../init.jsp" %>

<liferay-portlet:actionURL name="editAssociato" var="editAssociato"/>
<form id="registra-associato" class="form-horizontal" action="${editAssociato}" method="post">
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
        <legend>Registra Associato</legend>

        <aui:layout>
            <aui:column columnWidth="50" first="true" >
                <input id="id" name="id" type="text" placeholder="" class="form-control input-md"  style="display: none"/>
                
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="ragioneSociale">Ragione sociale: </label>  
                    <div class="controls">
                        <input id="ragioneSociale" name="ragioneSociale" type="text" placeholder="" class="form-control input-md" required=""/>

                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="centro">Centro: </label>  
                    <div class="controls">
                        <input id="centro" name="centro" type="text" placeholder="" class="form-control input-md" required=""/>

                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="pIVA">Partita IVA: </label>  
                    <div class="controls">
                        <input id="pIVA" name="pIVA" type="text" placeholder="" class="form-control input-md" required=""/>

                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="indirizzo">Indirizzo: </label>  
                    <div class="controls">
                        <input id="indirizzo" name="indirizzo" type="text" placeholder="" class="form-control input-md" required=""/>
                        <!--<textarea id="indirizzo" name="indirizzo" rows="3" placeholder="" class="form-control input-md" required=""/>-->

                    </div>
                </div>

            </aui:column>
            <aui:column columnWidth="50" last="true" >
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="telefono">Telefono: </label>  
                    <div class="controls">
                        <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-md"/>

                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="fax">Fax: </label>  
                    <div class="controls">
                        <input id="fax" name="fax" type="text" placeholder="" class="form-control input-md"/>

                    </div>
                </div>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="email">Email: </label>  
                    <div class="controls">
                        <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""/>

                    </div>
                </div>

                <!-- Password input-->
                <div class="control-group">
                    <label class="control-label" for="password">Password: </label>
                    <div class="controls">
                        <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required=""/>

                    </div>
                </div>
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
</form>

<fieldset>

    <!-- Form Name -->
    <legend>Elenco Associati</legend>
    <liferay-ui:search-container delta="20" >

        <liferay-ui:search-container-results results="<%= AssociatoLocalServiceUtil.getAssociatos(0, AssociatoLocalServiceUtil.getAssociatosCount())%>" 
        total="<%= AssociatoLocalServiceUtil.getAssociatosCount()%>"/>
        <liferay-ui:search-container-row className="Associato" modelVar="clienti">
            <liferay-ui:search-container-column-text property="ragioneSociale" name="Ragione Sociale" />
            <liferay-ui:search-container-column-text property="indirizzo" name="Indirizzo"/>
            <%--<liferay-ui:search-container-column-text property="partitaIVA"  name="Partita IVA"/>--%>
            <liferay-ui:search-container-column-text property="telefono"  name="Telefono"/>
            <liferay-ui:search-container-column-text property="fax"  name="FAX"/>
            <%--<liferay-ui:search-container-column-text property="email"  name="Email"/>--%>
            <liferay-ui:search-container-column-jsp align="right" valign="middle" path="/jsps/op/action.jsp"/>
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator/>
    </liferay-ui:search-container>
</fieldset>
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