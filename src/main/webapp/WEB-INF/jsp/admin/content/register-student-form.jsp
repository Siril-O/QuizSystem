<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>
	<spring:message code="label.registerUser" />
</h3>
<form:form action="/QuizSystem/jsp/user/registerStudent" method="post"
	class="form-horizontal" modelAttribute="newUser">
	<div class="form-group">
		<label for="name"><spring:message
				code="label.registerUser.name" /></label>
		<form:input path="name" class="form-control" id="name"
			required="required" />
		<form:errors path="name" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="surname"><spring:message
				code="label.registerUser.surname" /></label>
		<form:input  path="surname" class="form-control"
			id="surname" required="required" />
			<form:errors path="surname" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="email"><spring:message
				code="label.registerUser.email" /></label>
		<form:input type="text" path="email" class="form-control" id="email"
			required="required" />
			<form:errors path="email" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="password"><spring:message
				code="label.registerUser.password" /></label>
		<form:input type="password" path="password" class="form-control"
			id="password" required="required" />
			<form:errors path="password" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="confirmPassword"><spring:message
				code="label.registerUser.confirmPassword" /></label>
		<input type="password" name="confirmPassword" class="form-control"
			id="confirmPassword" required="required" />	</div>
	<input type="hidden" name="role" value="ROLE_STUDENT"/>
	<input type="submit"
		value="<spring:message code="label.registerUser.submit" />"
		class="btn btn-primary" />
</form:form>