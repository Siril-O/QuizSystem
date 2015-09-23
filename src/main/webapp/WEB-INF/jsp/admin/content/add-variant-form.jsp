<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>
	<spring:message code="label.addVariantToQuestion" />
	<c:out value="${question.id}" />
	<spring:message code="label.addVariantToQuestion.targetQuiz" />
	<c:out value="${question.quiz.id}"></c:out>
</h1>
<form action="/QuizSystem/jsp/variant/create" class="form-horizontal"
	method="post">
	<spring:message code="label.addVariantToQuestion.description" />
	<textarea name="description" class="form-control" required></textarea>
	<br><spring:message code="label.addVariantToQuestion.isRightAnswer" />
	<input type="hidden" value="on" name="_rightAnswer" />
	<input type="checkbox" name="rightAnswer" />
	<br>
	<input type="hidden" value="${question.id}" name="questionId" required/>
	<input type="submit" value="<spring:message code="label.addVariantToQuestion.submit" />" class="btn btn-primary" />
</form>