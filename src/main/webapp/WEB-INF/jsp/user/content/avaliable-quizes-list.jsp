<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Avaliable for passing Quizes</h1>
<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Subject</td>
				<td></td>
			</tr>
			<c:forEach var="quiz" items="${user.avaliableQuizes}">
				<tr>
					<td><c:out value="${quiz.id}" /></td>
					<td><c:out value="${quiz.name}" /></td>
					<td><c:out value="${quiz.subject.name}" /></td>
					<td><form action="/QuizSystem/jsp/pass/quiz" method="post">
							<input type="submit" value="Start passing" class="btn btn-primary" /> <input
								type="hidden" name="quizId" value="${quiz.id}">
						</form></td>
				</tr>
			</c:forEach>
		</table>