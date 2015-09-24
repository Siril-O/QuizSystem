<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="label.assignQuiztoUser" />
	<c:out value="${user.name}" />	<c:out value="${user.surname}" />
</h1>
<form action="/QuizSystem/jsp/user/assignQuiz" class="form-horizontal"
	method="get">
	<c:forEach var="quiz" items="${quizList}">
		<input type="radio" required name="quizId" value="${quiz.id}" />
		<c:out value="${quiz.name}"></c:out>
		<br>
	</c:forEach>
	<input type="hidden" value="${user.id}" name="userId"  required/>
	<input type="submit" value="<spring:message code="label.assignQuiztoUser.submit" />" class="btn btn-primary" />
</form>