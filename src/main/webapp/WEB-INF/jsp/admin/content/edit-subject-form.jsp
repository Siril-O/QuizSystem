<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>
	<spring:message code="label.editSubject" />
</h1>
<form:form action="/QuizSystem/jsp/subject/update" class="form-horizontal"
	modelAttribute="subject"
	method="post">
	<spring:message code="label.editSubject.name" />
	<form:input path="name" value="${subject.name}" required="required"/>
	<form:errors path="name" cssClass="error" />
	<form:hidden path="id" value="${subject.id}" required="required"/>
	<input type="submit"
		value="<spring:message code="label.editSubject.submit" />"
		class="btn btn-primary" />
</form:form>