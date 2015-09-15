<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1><spring:message code="label.createSubject" /></h1>
<form action="/QuizSystem/jsp/subject/create" class="form-horizontal"
	method="post">
	<spring:message code="label.createSubject.Name" />
	<input type="text" name="name" />
	<input type="submit" value="<spring:message code="label.createSubject.submit" />" class="btn btn-primary" />
</form>