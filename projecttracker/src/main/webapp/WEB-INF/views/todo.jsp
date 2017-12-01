<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri'].toString()}"/>
<c:choose>
<c:when test="${fn:contains(url,'update')}">
<H1>Update Todo</H1>
</c:when>
<c:otherwise>
<H1>Add a Todo</H1>
</c:otherwise>
</c:choose>
<form:form method="post" commandName="todo">

<form:hidden path="id"/>
<form:hidden path="user"/>
<fieldset class=form-group>
<form:label path="desc">Description</form:label>
<form:input path="desc" type="text" class="form-control" required="required"></form:input>
<form:errors path="desc" cssClass="text-warning"/>

<form:label path="targetDate">Target date</form:label>
<form:input path="targetDate" type="date" class="form-control" required="required"></form:input>
<form:errors path="targetDate" cssClass="text-warning"/>

<form:label path="done">Is Completed?</form:label>
<form:checkbox path="done" class="form-control"/>
</fieldset>

<c:choose>
<c:when test="${fn:contains(url,'update')}">
<input class="btn btn-success" type="Submit" value="UPDATE TODO"></input>
</c:when>
<c:otherwise>
<input class="btn btn-success" type="Submit" value="ADD TODO"></input>
</c:otherwise>
</c:choose>
</form:form>
</div>
<%@ include file="common/footer.jsp" %>