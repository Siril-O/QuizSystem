<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>
	<spring:message code="label.createQuiz" />
</h1>
<form:form action="/QuizSystem/jsp/quiz/create" method="post"
	class="form-horizontal" modelAttribute="quiz">
	<spring:message code="label.createQuiz.name" />
	<form:input  required="required"  path="name" class="form-control" />
	<form:errors path="name" cssClass="error" />
	<br>
	<spring:message code="label.createQuiz.subject" />
	<select class="form-control" name="subjectId">
		<c:forEach var="subject" items="${subjects}">
			<option value="${subject.id}">${subject.name}</option>
		</c:forEach>
	</select>
	<input type="submit"
		value="<spring:message code="label.createQuiz.submitCreateQuiz" />"
		class="btn btn-primary" />
</form:form>