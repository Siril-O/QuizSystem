<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
	Add Question to Quiz ID:
	<c:out value="${quiz.id}"></c:out>
</h1>
<form action="/QuizSystem/jsp/question/create" class="form-horizontal"
	method="post">
	Description:
	<textarea name="description" class="form-control"></textarea>
	<br>
	<input type="hidden" value="${quiz.id}" name="quizId" />
	<input type="submit" value="Add Question" class="btn btn-primary" />
</form>