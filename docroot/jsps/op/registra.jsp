<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.bysoftware.ct.service.ArticoliLocalServiceUtil"%>
<%@page import="it.bysoftware.ct.service.impl.ArticoliLocalServiceImpl"%>
<%@page import="it.bysoftware.ct.model.Articoli"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@include file="../../init.jsp" %>

<form id="registra-associato" class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Registra Associato</legend>

        <!-- Text input-->
        <div class="control-group">
            <label class="control-label" for="ragioneSociale">Ragione sociale: </label>  
            <div class="controls">
                <input id="ragioneSociale" name="ragioneSociale" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <label class="control-label" for="centro">Centro: </label>  
            <div class="controls">
                <input id="centro" name="centro" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <label class="control-label" for="pIVA">Partita IVA: </label>  
            <div class="controls">
                <input id="pIVA" name="pIVA" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <label class="control-label" for="indirizzo">Indirizzo: </label>  
            <div class="controls">
                <input id="indirizzo" name="indirizzo" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <label class="control-label" for="telefono">Telefono: </label>  
            <div class="controls">
                <input id="telefono" name="telefono" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <label class="control-label" for="fax">Fax: </label>  
            <div class="controls">
                <input id="fax" name="fax" type="text" placeholder="" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="control-group">
            <label class="control-label" for="email">Email: </label>  
            <div class="controls">
                <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="control-group">
            <label class="control-label" for="password">Password: </label>
            <div class="controls">
                <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Button (Double) -->
        <div class="control-group">
            <label class="control-label" for="salva"></label>
            <div class="btn-group">
                <button id="btnSave" class="btn" ><i class="icon-save"></i>Salva</button>
                <button id="btnReset" class="btn" ><i class="icon-remove"></i>Reset</button>
            </div>
        </div>
    </fieldset>
</form>

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
                    email: {
                        email: true,
                        required: true
                    },
                    password: {
                        required: true,
                        rangeLength: [4,8]
                    }
                };

                var fieldStrings = {
                    email: {
                        required:   'Campo obbligatorio.',
                        email:      'Specifcare un indirizzo email valido.'
                    },
                    ragioneSociale: {
                        required:   'Campo obbligatorio.'
                    },
                    indirizzo: {
                        required:   'Campo obbligatorio.'
                    },
                    centro: {
                        required:   'Campo obbligatorio.',
                        maxLength:  'Specificare al massimo tre caratteri per il centro.'
                    },
                    pIVA:{
                        digits:     'Inserire solo caratteri numerici.',
                        required:   "Campo obbligatorio.",
                        maxLength:  'Partita IVA non valida (11 cifre).',
                        minLength:  'Partita IVA non valida (11 cifre).'
                    },
                    password: {
                        required:       'Campo obbligatorio.',
                        rangeLength:    'La password deve essere compresa tra 4 e 8 caratteri.'
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