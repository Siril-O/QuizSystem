<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
	Assign Quiz to User ID:
	<c:out value="${user.id}" />
</h1>
<form action="/QuizSystem/jsp/user/assignQuiz" class="form-horizontal"
	method="get">
	<c:forEach var="quiz" items="${quizList}">
		<input type="radio" name="quizId" value="${quiz.id}" />
		<c:out value="${quiz.name}"></c:out>
		<br>
	</c:forEach>
	<input type="hidden" value="${user.id}" name="userId" />
	<input type="submit" value="Assign Quiz" class="btn btn-primary" />
</form>