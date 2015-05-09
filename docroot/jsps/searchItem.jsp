<%@include file="../init.jsp" %>
<%
    SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
    DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle
    buttonLabel="Student Search"
displayTerms="<%= displayTerms %>"
    id="toggle_id_student_search">
    <aui:input label="First Name" name="firstName" value="<%=firstName %>" />
    <aui:input label="Last Name" name="lastName" value="<%=lastName %>" />
    <aui:input label="studentAge" name="studentAge" value="<%= studentAge %>" />
    <aui:select name="studentGender">
        <aui:option label="Male" value="1"></aui:option>
        <aui:option label="Female" value="0"></aui:option>
    </aui:select>
    <aui:input label="studentAddress" name="studentAddress" value="<%= studentAddress %>" />
</liferay-ui:search-toggle>