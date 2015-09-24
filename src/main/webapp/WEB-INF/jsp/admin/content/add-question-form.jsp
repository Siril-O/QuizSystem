<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1><spring:message code="label.addQuestionToQuiz.addQuestion" />
	<c:out value="${quiz.name}"></c:out>
</h1>
<form action="/QuizSystem/jsp/question/create" class="form-horizontal"
	method="post">
	<spring:message code="label.Description" />
	<textarea name="description" required class="form-control" rows="10"></textarea>
	<br>
	<input type="hidden" value="${quiz.id}" name="quizId" required/>
	<input type="submit" value="<spring:message code="label.addQuestionToQuiz.submitAddQuestion" />" class="btn btn-primary" />
</form>