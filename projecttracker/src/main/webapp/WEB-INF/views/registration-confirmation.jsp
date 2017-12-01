<%@ include file="common/header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Projecttracker - Registration confirmation</title>
<!--Start of container-->
<div id="container">
<div id="confirmationtext">
<h1>Registration successful!</h1>
<p>Great! You have successfully created your account. As soon as the administrator approves your email, you wil receive an email with the subject heading "REGISTRATION CONFIRMATION". Once you have received that email, please click on the login button found within the email, or you can click on the button below.</p>
</div>
<div id="login"><a type="submit" class="btn btn-default" href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></div>
</div>
<!--End of container-->
<%@ include file="common/footer.jsp" %>