<%@include file="../init.jsp" %>

<fieldset>
    <legend>Allegato tracciabilità</legend>
    <aui:input id="nDoc" type="text" name="nDOc" label="N° documento" cssClass="input-small" disabled="true" inlineField="true" />
    <aui:input id="dataDoc" type="text" name="dataDoc" label="Data documento" cssClass="input-large" disabled="true" inlineField="true"/>
    <aui:input id="cliente" type="text" name="cliete" label="Cliente" cssClass="input-xxlarge" disabled="true" inlineField="true"/>

    <c:forEach var="i" begin="1" end="2"> 
        <div style="padding-left: 5%; background: #ddd; width: 80%;">
            <fieldset title="Prodotto venduto ${i}">
                <aui:input id="prodotto_${i}" type="text" name="produtto_${i}" label="Produtto Venduto" cssClass="input-xlarge" inlineField="true" />
                <aui:input id="lottoVenduto_${i}"    type="text" name="lottoVenduto_${i}" label="Lotto vendita" cssClass="input-small" inlineField="true" />
                <aui:input id="kgVenduti_${j}" type="text" name="kgVenduti_${j}" label="Data documento" cssClass="input-large" inlineField="true"/>
                <c:forEach var="j" begin="1" end="3">
                    <div style="padding-left: 5%">
                        <aui:input id="lottoGrezzo_${j}"    type="text" name="lottoGrezzo_${j}" label="Lotto grezzo" cssClass="input-small" inlineField="true" />
                        <aui:input id="kg_${j}" type="text" name="kg_${j}" label="Data documento" cssClass="input-large" inlineField="true"/>
                        <aui:input id="produttore_${j}" type="text" name="produttore_${j}" label="Produttore" cssClass="input-xlarge" inlineField="true" />
                        <aui:input id="foglio_${j}" type="text" name="foglio_${j}" label="Foglio" cssClass="input-small" inlineField="true" />
                        <aui:input id="particella_${j}" type="text" name="particella_${j}" label="Particella" cssClass="input-small" inlineField="true"/>
                    </div>
                </c:forEach>
            </fieldset>
        </div>
        <hr/>
    </c:forEach>
</fieldset>