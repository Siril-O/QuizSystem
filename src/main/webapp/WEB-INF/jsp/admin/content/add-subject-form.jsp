<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>
	<spring:message code="label.createSubject" />
</h1>
<form:form action="/QuizSystem/jsp/subject/create"
	class="form-horizontal" method="post" modelAttribute="subject">
	<spring:message code="label.createSubject.Name" />
	<form:input path="name" required="required" />
	<form:errors path="name" cssClass="error" />
	<input type="submit"
		value="<spring:message code="label.createSubject.submit" />"
		class="btn btn-primary" />
</form:form>