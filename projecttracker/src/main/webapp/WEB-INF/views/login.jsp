<%@ include file="common/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Projecttracker - Login</title>
<!--Start of container-->
<div id="container">

<form:form class="form-horizontal" method="post" modelAttribute="user">
<div id="errors"><form:errors path="*" cssClass="has-error"/></div>
<p class="logintext">Please enter your username and password below:</p>
<div class="form-group">
<form:label path="username" class="control-label col-sm-1">Username</form:label>
<div class="col-sm-4"><form:input path="username" type="text" value="${user.username}" class="form-control"></form:input></div>
</div>
<div class="form-group">
<form:label path="password" class="control-label col-sm-1">Password</form:label>
<div class="col-sm-4"><form:input path="password" type="password" class="form-control"></form:input></div>
</div>
<div class="form-group">        
      <div class="col-sm-4">
        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-log-in"></span> Login</button>
			<a id="registerbutton" class="btn btn-default" href="/register"><span class="glyphicon glyphicon-pencil"></span> Register</a>
      </div>
</div>
<div class="form-group">        
      <div class="col-sm-4">
	<a id="forgottenpassword" href="/forgot-password">Forgotten your password?</a></div>
</div>
</form:form>
</div>
<!--End of container-->
<%@ include file="common/footer.jsp" %>