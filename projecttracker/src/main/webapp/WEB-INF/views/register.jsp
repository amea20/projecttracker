<%@ include file="common/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Projecttracker - Register</title>
<!--Start of container-->
<div id="container">
<h2>User Registration</h2>
<p class="register">Please register your details in the following section below:</p>
<form:form class="form-horizontal" method="post" modelAttribute="user">
<div id="errors"><form:errors path="*" cssClass="has-error"/></div>
<div class="column1">
<div class="form-group">
<form:label path="firstName" class="control-label col-sm-2">First name:</form:label>
<div class="col-sm-3"><form:input type="text" path="firstName" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="lastName" class="control-label col-sm-2">Last name:</form:label>
<div class="col-sm-3"><form:input type="text" path="lastName" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="DOB" class="control-label col-sm-2">Date of birth:</form:label>
<div class="col-sm-3"><form:input id="datepicker" path="DOB" class="form-control" type="text"></form:input></div>
</div>
<div class="form-group">
<form:label path="emailAddress" class="control-label col-sm-2">Email address:</form:label>
<div class="col-sm-3"><form:input type="text" path="emailAddress" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="password" class="control-label col-sm-2">Password:</form:label>
<div class="col-sm-3"><form:input type="password" path="password" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="confirmPassword" class="control-label col-sm-2">Confirm password:</form:label>
<div class="col-sm-3"><form:input type="password" path="confirmPassword" class="form-control"></form:input></div>
</div>
</div>
<div class="form-group">
<form:label path="country" class="control-label col-sm-2">Country:</form:label>
<div class="col-sm-3">
<form:select path="country" id="countries" class="form-control" onchange="togglePostcode()">
	<form:option value="#">Select a country</form:option>
	<c:forEach var="country" items="${countries}">
	<form:option value="${country.value}">${country.key}</form:option>
	</c:forEach>
</form:select>
</div>
</div>
<div id="postcodelookup" class="form-group">
<div class="col-sm-offset-2 col-sm-3"><input type="text" name="addpostcode" class="form-control"></input></div>
<div id="col-sm-offset-1 col-sm-4"><button id="postcodelookupbutton" type="button" class="btn btn-default">Postcode Lookup</button></div>
</div>
<div id="addressblock" class="form-group">
<div class="col-sm-offset-2 col-sm-3"><select id="addressList" class="form-control">
	
</select></div>
</div>
<div class="form-group">
<form:label path="address1" class="control-label col-sm-2">Address 1:</form:label>
<div class="col-sm-3"><form:input type="text" path="address1" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="address2" class="control-label col-sm-2">Address 2:</form:label>
<div class="col-sm-3"><form:input type="text" path="address2" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="address3" class="control-label col-sm-2">Address 3:</form:label>
<div class="col-sm-3"><form:input type="text" path="address3" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="city" class="control-label col-sm-2">Town/City:</form:label>
<div class="col-sm-3"><form:input type="text" path="city" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="postcode" class="control-label col-sm-2">Postcode:</form:label>
<div class="col-sm-3"><form:input type="text" path="postcode" class="form-control"></form:input></div>
</div>
<div class="form-group"><button id="registrationbutton" class="btn btn-default" type="submit">Register</button></div>
</form:form>
</div>
<!--End of container-->
<%@ include file="common/footer.jsp" %>