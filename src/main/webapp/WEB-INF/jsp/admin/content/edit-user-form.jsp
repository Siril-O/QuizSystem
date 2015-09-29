<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>
	<spring:message code="label.editUser" />
</h3>
<form:form action="/QuizSystem/jsp/user/update" method="post"
	class="form-horizontal" modelAttribute="userToEdit">
	<div class="form-group">
		<label for="name"><spring:message code="label.editUser.name" /></label>
		<form:input path="name" class="form-control" id="name"
			required="required" />
		<form:errors path="name" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="surname"><spring:message
				code="label.editUser.surname" /></label>
		<form:input path="surname" class="form-control" id="surname"
			required="required" />
		<form:errors path="surname" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="email"><spring:message code="label.editUser.email" /></label>
		<form:input path="email" class="form-control" id="email"
			required="required" />
		<form:errors path="email" cssClass="error" />
	</div>
	<form:hidden path="id" required="required" />
	<input type="submit"
		value="<spring:message code="label.editUser.submit" />"
		class="btn btn-primary" />
</form:form>