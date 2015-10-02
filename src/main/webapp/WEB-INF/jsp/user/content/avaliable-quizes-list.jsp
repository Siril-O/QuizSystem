<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="label.avaliableQuizes" />
</h1>
<table class="table table-hover">
	<tr>
		<td><spring:message code="label.avaliableQuizes.name" /></td>
		<td><spring:message code="label.avaliableQuizes.subject" /></td>
		<td></td>
	</tr>
	<c:forEach var="quiz" items="${user.avaliableQuizes}">
		<tr>
			<td><c:out value="${quiz.name}" /></td>
			<td><c:out value="${quiz.subject.name}" /></td>
			<td><form action="/QuizSystem/jsp/pass/quiz" method="post">
					<input type="submit"
						value="<spring:message code="label.avaliableQuizes.startPassing" />"
						class="btn btn-primary" />
					<input type="hidden" name="quizId" value="${quiz.id}" required>
				</form></td>
		</tr>
	</c:forEach>
</table>