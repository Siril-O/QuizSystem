<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3>
	<spring:message code="label.allQuizes" />
</h3>
<form action="/QuizSystem/jsp/quiz/add" method="post">
	<input type="submit" value="<spring:message code="label.createQuiz" />" class="btn btn-primary" />
</form>
<table class="table table-hover">
	<tr>
		<td><spring:message code="label.name" /></td>
		<td><spring:message code="label.subject" /></td>
		<td></td>
		<td></td>
	</tr>
	<c:forEach var="quiz" items="${quizList}">
		<tr>
			<td><c:out value="${quiz.name}" /></td>
			<td><c:out value="${quiz.subject.name}" /></td>
			<td><form action="/QuizSystem/jsp/quiz/edit" method="get">
					<input type="submit" value="<spring:message code="label.editQuiz"/>" class="btn btn-primary" />
					<input type="hidden" name="quizId" value="${quiz.id}" required>
				</form></td>
			<td>
				<form action="/QuizSystem/jsp/quiz/remove" method="post">
					<input type="hidden" name="quizId" value="${quiz.id}" required>
					<input type="submit" value="<spring:message code="label.removeQuiz"/>" class="btn btn-primary" />
					<spring:message code="label.removeQuizConfirm"/>
					<input type="checkbox" name="confirm" required>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>