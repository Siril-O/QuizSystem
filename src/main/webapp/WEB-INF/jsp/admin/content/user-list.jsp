<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3>
	<spring:message code="label.userList" />
</h3>
<form action="/QuizSystem/jsp/user/registerStudentForm" method="post">
	<input type="submit"
		value="<spring:message code="label.userList.registerStudent" />"
		class="btn btn-primary" />
	<a href="/QuizSystem/jsp/user/registerForm" class="btn btn-primary"><spring:message
			code="label.userList.registerUser"  /></a>
</form>
<table class="table table-hover">
	<tr>
		<td><spring:message code="label.userList.id" /></td>
		<td><spring:message code="label.userList.name" /></td>
		<td><spring:message code="label.userList.surname" /></td>
		<td><spring:message code="label.userList.email" /></td>
		<td><spring:message code="label.userList.role" /></td>
		<td></td>
		<td></td>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user.id}" /></td>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.surname}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.role}" /></td>
			<td><form action="/QuizSystem/jsp/user/edit">
					<input type="submit"
						value="<spring:message code="label.userList.edit" />"
						class="btn btn-primary" />
					<input type="hidden" name="userId" value="${user.id}" required>
				</form></td>
			<td><form action="/QuizSystem/jsp/user/assignQuizForm"
					method="post">
					<input type="submit"
						value="<spring:message code="label.userList.assignQuiz" />"
						class="btn btn-primary" />
					<input type="hidden" name="userId" value="${user.id}" required>
				</form></td>
		</tr>
		<tr>
			<td colspan="8"><ul>
					<c:forEach var="quiz" items="${user.avaliableQuizes}">
						<li><c:out value="${quiz.name}" />
							<form action="/QuizSystem/jsp/user/unassignQuiz" method="post">
								<input type="hidden" name="quizId" value="${quiz.id}" required />
								<input type="submit"
									value="<spring:message code="label.userList.unassignQuiz" />"
									class="btn btn-primary" />
								<input type="hidden" name="userId" value="${user.id}" required>
							</form></li>
					</c:forEach>
				</ul></td>
		</tr>
	</c:forEach>
</table>