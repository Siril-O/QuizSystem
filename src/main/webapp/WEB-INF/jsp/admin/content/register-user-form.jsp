<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3><spring:message code="label.registerUser" /></h3>
		<form action="/QuizSystem/jsp/user/register" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label for="name"><spring:message code="label.registerUser.name" /></label>
				<input type="text" name="name" class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="surname"><spring:message code="label.registerUser.surname" /></label>
				<input type="text" name="surname" class="form-control" id="surname">
			</div>
			<div class="form-group">
				<label for="email"><spring:message code="label.registerUser.email" /></label>
				<input type="text" name="email" class="form-control" id="email">
			</div>
			<div class="form-group">
				<label for="password"><spring:message code="label.registerUser.password" /></label>
				<input type="password" name="password" class="form-control"
					id="password">
			</div>
			<div class="form-group">
				<label for="confirmPassword"><spring:message code="label.registerUser.confirmPassword" /></label>
				<input type="password" name="confirmPassword" class="form-control"
					id="confirmPassword">
			</div>
			<input type="submit" value="<spring:message code="label.registerUser.submit" />" class="btn btn-primary" />
		</form>