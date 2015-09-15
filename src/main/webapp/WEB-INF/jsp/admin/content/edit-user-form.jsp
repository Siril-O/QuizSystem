<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3><spring:message code="label.editUser" /></h3>
		<form action="/QuizSystem/jsp/user/update" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label for="name"><spring:message code="label.editUser.name" /></label>
				<input type="text" value="${userToEdit.name}" name="name" class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="surname"><spring:message code="label.editUser.surname" /></label>
				<input type="text" value="${userToEdit.surname}" name="surname" class="form-control" id="surname">
			</div>
			<div class="form-group">
				<label for="email"><spring:message code="label.editUser.email" /></label>
				<input type="text" value="${userToEdit.email}" name="email" class="form-control" id="email">
			</div>
			<input type="hidden" name="id" value="${userToEdit.id}">
			<input type="submit" value="<spring:message code="label.editUser.submit" />" class="btn btn-primary" />
		</form>