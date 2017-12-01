<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri'].toString()}"/>
<c:choose>
<c:when test="${fn:contains(url,'update')}">
<title>Update User</title>
<H1>Update User</H1>
</c:when>
<c:otherwise>
<title>Add a User</title>
<H1>Add a User</H1>
</c:otherwise>
</c:choose>

<form:form method="post" modelAttribute="user">
<form:errors path="*" cssClass="has-error" element="div"/>
<fieldset class=form-group>
<c:choose>
<c:when test="${fn:contains(url,'update')}">
<form:label path="username">Username</form:label>
<form:input disabled="true" path="username" type="text" class="form-control"></form:input>
</c:when>
<c:otherwise>
<form:label path="username">Username</form:label>
<form:input path="username" type="text" value="" class="form-control"></form:input>
<form:label path="password">Password</form:label>
<form:input path="password" type="password" value="" class="form-control"></form:input>
</c:otherwise>
</c:choose>
<form:label path="firstName">First name</form:label>
<form:input path="firstName" type="text" value="" class="form-control"></form:input>
<form:label path="lastName">Surname</form:label>
<form:input path="lastName" type="text" value="" class="form-control"></form:input>

<form:label path="emailAddress">Email-address</form:label>
<form:input path="emailAddress" type="text" value="" class="form-control"></form:input>

<form:label path="DOB">Date of birth</form:label>
<form:input path="DOB" type="date" value="" class="form-control"></form:input>
</fieldset>

<c:choose>
<c:when test="${fn:contains(url,'update')}">
<input class="btn btn-success" type="Submit" value="UPDATE"></input>
</c:when>
<c:otherwise>
<input class="btn btn-success" type="Submit" value="CREATE USER"></input>
</c:otherwise>
</c:choose>
</form:form>
</div>
<%@ include file="common/footer.jsp" %>