<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3>
	<spring:message code="label.userList" />
</h3>
<form action="/QuizSystem/jsp/user/registerStudentForm" method="post">
	<input type="submit"
		value="<spring:message code="label.userList.registerStudent" />"
		class="btn btn-primary" />
</form>
<table class="table table-hover">
	<tr>
		<td><b><spring:message code="label.userList.name" /></b></td>
		<td><b><spring:message code="label.userList.surname" /></b></td>
		<td><b><spring:message code="label.userList.email" /></b></td>
		<td><b><spring:message code="label.userList.role" /></b></td>
		<td></td>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.surname}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.role}" /></td>
			<td><a href="/QuizSystem/jsp/user/edit?userId=${user.id}"
				class="btn btn-primary"><spring:message
						code="label.userList.edit" /></a> <a
				href="/QuizSystem/jsp/user/assignQuizForm?userId=${user.id}"
				class="btn btn-primary"><spring:message
						code="label.userList.assignQuiz" /></a> <a
				href="/QuizSystem/jsp/user/resultsForTutor?userId=${user.id}"
				class="btn btn-primary"><spring:message
						code="label.userList.passingResults" /></a>
		</tr>
		<tr>
			<c:forEach var="quiz" items="${user.avaliableQuizes}">
				<tr>
					<td colspan="3"></td>
					<td>${quiz.name}</td>
					<td>
						<form action="/QuizSystem/jsp/user/unassignQuiz" method="post">
							<input type="hidden" name="quizId" value="${quiz.id}" required />
							<input type="submit"
								value="<spring:message code="label.userList.unassignQuiz" />"
								class="btn btn-default" />
							<input type="hidden" name="userId" value="${user.id}" required>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</c:forEach>
</table>
<ul class="pagination">
	<c:forEach begin="1" end="${pagesNumber}" var="i">
		<c:set var="pageOffset" value="${(i-1)*maxResults}" />
		<li <c:if test="${offset==(pageOffset)}">class="active"</c:if>><a
			href="/QuizSystem/jsp/user/?offset=${pageOffset}">${i} </a></li>
	</c:forEach>
</ul>