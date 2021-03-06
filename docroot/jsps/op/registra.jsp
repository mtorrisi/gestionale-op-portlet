<%@ page import="it.bysoftware.ct.model.Associato" %>
<%@ page import="it.bysoftware.ct.model.OrganizzazioneProduttori" %>
<%@ page import="it.bysoftware.ct.service.AssociatoLocalServiceUtil" %>
<%@ page import="it.bysoftware.ct.service.OrganizzazioneProduttoriLocalServiceUtil" %>

<%@ include file="../../init.jsp" %>

<%
	String message = renderRequest.getParameter("message");
	OrganizzazioneProduttori op = OrganizzazioneProduttoriLocalServiceUtil.getOP(Long.valueOf(renderRequest.getRemoteUser()));
%>

<liferay-ui:error key="deleteAssociato" message="delete-associato" />
<c:if test="<%= message != null %>">
		<span class="portlet-msg-info"><%= message %></span>
	</c:if>
<liferay-portlet:actionURL name="addAssociato" var="addAssociato" />
<form action="${addAssociato}" class="form-horizontal" id="registra-associato" method="post">
	<fieldset>
		<aui:field-wrapper >
			<div class="btn-toolbar">
				<div class="btn-group">
					<button class="btn" id="btnSave"><i class="icon-save"></i>Salva</button>
					<button class="btn" id="btnReset" onclick="this.form.reset()"><i class="icon-remove"></i>Reset</button>
				</div>
			</div>
		</aui:field-wrapper>

		<!-- Form Name -->
		<legend>Registra Associato</legend>

		<aui:layout>
			<aui:column columnWidth="50" first="true">

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="codSoggetto">Codice Soggetto: </label>
					<div class="controls">
						<input class="form-control input-md" id="codSoggetto" name="<portlet:namespace />codSoggetto" placeholder="" required="" type="text" />
<%-- <input id="ragioneSociale" name="<portlet:namespace />ragioneSociale" type="text" placeholder="" class="form-control input-md" required="" /> --%>
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="ragioneSociale">Ragione sociale: </label>
					<div class="controls">
						<input class="form-control input-md" id="ragioneSociale" name="<portlet:namespace />ragioneSociale" placeholder="" required="" type="text" />
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="centro">Sezionale IVA (Assegnato dalla OP): </label>
					<div class="controls">
						<input class="form-control input-md" id="centro" name="<portlet:namespace />centro" placeholder="" required="" type="text" />
						<liferay-ui:icon-help message="help-sezionale-associato" />
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="pIVA">Partita IVA: </label>
					<div class="controls">
						<input class="form-control input-md" id="pIVA" name="<portlet:namespace />pIVA" placeholder="" required="" type="text" />
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="indirizzo">Sede legale: </label>
					<div class="controls">
						<!--<input id="indirizzo" name="<portlet:namespace />indirizzo" type="text" placeholder="" class="form-control input-md" required="" />-->
						<textarea class="form-control" id="indirizzo" name="<portlet:namespace />indirizzo" required=""></textarea>
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="indirizzo">Comune: </label>
					<div class="controls">
						<input class="form-control input-md" id="comune" name="<portlet:namespace />comune" placeholder="" required="" type="text" />
						<liferay-ui:icon-help message="help-comune" />
					</div>
				</div>

			</aui:column>
			<aui:column columnWidth="50" last="true">
				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="telefono">Telefono: </label>
					<div class="controls">
						<input class="form-control input-md" id="telefono" name="<portlet:namespace />telefono" placeholder="" type="text" />
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="fax">Fax: </label>
					<div class="controls">
						<input class="form-control input-md" id="fax" name="<portlet:namespace />fax" placeholder="" type="text" />
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="sezionale_op">Sezionale IVA: (Assegnato alla OP) </label>
					<div class="controls">
						<input class="form-control input-md" id="sezionale_op" name="<portlet:namespace />sezionale_op" type="text" value="FIN" />
						<liferay-ui:icon-help message="help-sezionale-op" />
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="nome">Nome cartella: </label>
					<div class="controls">
						<input class="form-control input-md" id="nome" name="<portlet:namespace />nome" placeholder="" required="" type="text" />
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="email">Email: </label>
					<div class="controls">
						<input class="form-control input-md" id="email" name="<portlet:namespace />email" placeholder="" required="" type="text" />
					</div>
				</div>

				<!-- Password input-->
				<div class="control-group">
					<label class="control-label" for="password">Password: </label>
					<div class="controls">
						<input class="form-control input-md" id="password" name="<portlet:namespace />password" placeholder="" required="" type="password" />
					</div>
				</div>
			</aui:column>
		</aui:layout>

	</fieldset>
</form>

<fieldset>

	<!-- Form Name -->
	<legend>Elenco Associati</legend>
	<div id="myTab">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tab-1">Attivi</a></li>
			<li><a href="#tab-2">Disattivati</a></li>
		</ul>

		<div class="tab-content">
			<div class="tab-pane" id="tab-1">
				<liferay-ui:search-container delta="20">

					<liferay-ui:search-container-results results="<%= AssociatoLocalServiceUtil.getAssociatiAttivi(op.getId()) %>"
					total="<%= AssociatoLocalServiceUtil.countAssociatiAttivi(op.getId()) %>" />
					<liferay-ui:search-container-row className="Associato" modelVar="associati">
						<liferay-ui:search-container-column-text name="Codice" property="idLiferay" />
						<liferay-ui:search-container-column-text name="Ragione Sociale" property="ragioneSociale" />
						<liferay-ui:search-container-column-text name="Indirizzo" property="indirizzo" />
						<%--<liferay-ui:search-container-column-text property="partitaIVA"  name="Partita IVA" />--%>
						<liferay-ui:search-container-column-text name="Telefono"  property="telefono" />
						<liferay-ui:search-container-column-text name="FAX"  property="fax" />
						<%--<liferay-ui:search-container-column-text property="email"  name="Email" />--%>
						<liferay-ui:search-container-column-jsp align="right" path="/jsps/op/action.jsp" valign="middle" />
					</liferay-ui:search-container-row>

					<liferay-ui:search-iterator/>
				</liferay-ui:search-container>
			</div>
			<div id="tab-2">
				<liferay-ui:search-container delta="20">

					<liferay-ui:search-container-results results="<%= AssociatoLocalServiceUtil.getAssociatiDisattivati(op.getId()) %>"
					total="<%= AssociatoLocalServiceUtil.countAssociatiDisattivati(op.getId()) %>" />
					<liferay-ui:search-container-row className="Associato" modelVar="associati">
						<liferay-ui:search-container-column-text name="Codice" property="idLiferay" />
						<liferay-ui:search-container-column-text name="Ragione Sociale" property="ragioneSociale" />
						<liferay-ui:search-container-column-text name="Indirizzo" property="indirizzo" />
						<%--<liferay-ui:search-container-column-text property="partitaIVA"  name="Partita IVA" />--%>
						<liferay-ui:search-container-column-text name="Telefono"  property="telefono" />
						<liferay-ui:search-container-column-text name="FAX"  property="fax" />
						<%--<liferay-ui:search-container-column-text property="email"  name="Email" />--%>
						<liferay-ui:search-container-column-jsp align="right" path="/jsps/op/action1.jsp" valign="middle" />
					</liferay-ui:search-container-row>

					<liferay-ui:search-iterator/>
				</liferay-ui:search-container>
			</div>
		</div>

	</div>
</fieldset>
<script type="text/javascript">

	YUI().use(
			'aui-form-validator',
			function(Y) {
				var rules = {
	<portlet:namespace />codSoggetto: {
							digits: true,
							minLength: 5,
							maxLength: 5
						},
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
	<portlet:namespace />nome: {
							required: true,
							maxLength: 15
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
							rangeLength: [4, 16]
						},
	<portlet:namespace />sezionale_op: {
							maxLength: 3
						}
					};

					var fieldStrings = {
	<portlet:namespace />codSoggetto: {
							required: "Campo obbligatorio.",
		                    digits: 'Inserire solo caratteri numerici.',
							maxLength: 'Il Codice associato deve essere di 5 cifre.',
							minLength: 'Il Codice associato deve essere di 5 cifre.'
						},
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
							rangeLength: 'La password deve essere compresa tra 4 e 16 caratteri.'
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

		YUI().use(
				'aui-tabview',
				function(Y) {
					new Y.TabView(
							{
								srcNode: '#myTab'
							}
					).render();
				}
		);
</script>