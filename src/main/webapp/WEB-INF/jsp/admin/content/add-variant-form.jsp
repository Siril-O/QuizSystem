<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
	Add Variant to Question ID:
	<c:out value="${question.id}" />
	From Quiz Id:
	<c:out value="${question.quiz.id}"></c:out>
</h1>
<form action="/QuizSystem/jsp/variant/create" class="form-horizontal"
	method="post">
	Description:
	<textarea name="description" class="form-control"></textarea>
	<br> Is Right Answer:
	<input type="hidden" value="on" name="_rightAnswer" />
	<input type="checkbox" name="rightAnswer" />
	<br>
	<input type="hidden" value="${question.id}" name="questionId" />
	<input type="submit" value="Add Variant" class="btn btn-primary" />
</form>