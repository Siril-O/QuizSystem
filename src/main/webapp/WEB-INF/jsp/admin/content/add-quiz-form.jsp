<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1><spring:message code="label.createQuiz" /></h1>
<form action="/QuizSystem/jsp/quiz/create" class="form-horizontal"
	method="post">
	<spring:message code="label.createQuiz.name" />
	<input type="text" required name="name" class="form-control" />
	<br> <spring:message code="label.createQuiz.subject" />
	<select class="form-control" name="subjectId">
		<c:forEach var="subject" items="${subjects}">
			<option value="${subject.id}">${subject.name}</option>
		</c:forEach>
	</select>
	<input type="submit" value="<spring:message code="label.createQuiz.submitCreateQuiz" />" class="btn btn-primary" />
</form>