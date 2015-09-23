<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="label.editSubject" />
</h1>
<form action="/QuizSystem/jsp/subject/update" class="form-horizontal"
	method="post">
	<spring:message code="label.editSubject.name" />
	<input type="text" name="name" value="${subject.name}" required/>
	<input type="hidden" name="id" value="${subject.id}" required/>
	<input type="submit"
		value="<spring:message code="label.editSubject.submit" />"
		class="btn btn-primary" />
</form>