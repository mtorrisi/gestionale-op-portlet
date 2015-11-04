<%@include file="../init.jsp" %>

<div class="form-inline">
    <fieldset>

        <!-- Form Name -->
        <legend>Allegato tracciabilità</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="nDoc">DDT di vendita N°</label>  
            <div class="col-md-2">
                <input id="nDoc" name="nDoc" type="text" placeholder="" class="form-control input-md" required="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="dataDocumento">del</label>  
            <div class="col-md-4">
                <input id="dataDocumento" name="dataDocumento" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="cliente">Cliente destinatario</label>  
            <div class="col-md-6">
                <input id="cliente" name="cliente" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

    </fieldset>
</div>