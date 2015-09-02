<%@include file="../init.jsp" %>
<aui:layout>
    <aui:column columnWidth="50" first="true" >
        <fieldset>

            <!-- Form Name -->
            <legend>Inserisci Descrizione</legend>

            <!-- Textarea -->
            <div class="control-group">
                <label class="control-label" for="descrizione">Descrizione:</label>
                <div class="controls">                     
                    <textarea class="form-control input-xxlarge" id="descrizione" name="<portlet:namespace />descrizione"></textarea>
                </div>
                <button id="btnSeleziona" class="btn" onclick="set()">Inserisci</button>
            </div>

        </fieldset>
    </aui:column>
    <aui:column columnWidth="50" last="true" >
        <fieldset>
            <legend>Seleziona Descrizione</legend>
        </fieldset>
    </aui:column>
</aui:layout>

<script type="text/javascript">

    function set(descrizione) {
        if (descrizione) {
            console.log("Descrizione2: " + descrizione);
            Liferay.Util.getOpener().closePopup(descrizione, '<portlet:namespace/>DescriptionDialog');
        } else {
            console.log("Descrizione1: " + document.getElementById('descrizione').value);
            Liferay.Util.getOpener().closePopup(document.getElementById('descrizione').value, '<portlet:namespace/>DescriptionDialog');
        }
    }

</script>