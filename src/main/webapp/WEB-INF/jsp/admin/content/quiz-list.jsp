<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>All Quizes</h3>
<form action="/QuizSystem/jsp/quiz/add" method="post">
	<input type="submit" value="Create Quiz" class="btn btn-primary" />
</form>
<table class="table table-hover">
	<tr>
		<td>Id</td>
		<td>Name</td>
		<td>Subject</td>
		<td></td>
		<td></td>
	</tr>
	<c:forEach var="quiz" items="${quizList}">
		<tr>
			<td><c:out value="${quiz.id}" /></td>
			<td><c:out value="${quiz.name}" /></td>
			<td><c:out value="${quiz.subject.name}" /></td>
			<td><form action="/QuizSystem/jsp/quiz/edit" method="get">
					<input type="submit" value="Edit" class="btn btn-primary" />
					<input type="hidden" name="quizId" value="${quiz.id}">
				</form></td>
			<td>
				<form action="/QuizSystem/jsp/quiz/remove" method="post">
					<input type="hidden" name="quizId" value="${quiz.id}">
					<input type="submit" value="Remove" class="btn btn-primary" />
					Check to Confirm
					<input type="checkbox" name="confirm">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>