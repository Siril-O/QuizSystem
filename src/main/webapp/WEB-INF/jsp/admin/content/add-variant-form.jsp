<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>
	<spring:message code="label.addVariantToQuestion" />
	<spring:message code="label.addVariantToQuestion.targetQuiz" />
	<c:out value="${question.quiz.name}"></c:out>
</h1>
<form class="form-horizontal">
	<textarea rows="15" cols="70" readonly="readonly" class="form-control"><c:out
			value="${question.description}" /></textarea>
</form>
<form:form action="/QuizSystem/jsp/variant/create"
	class="form-horizontal" method="post" modelAttribute="variant">
	<spring:message code="label.addVariantToQuestion.description" />
	<form:textarea path="description" class="form-control"
		required="required" />
	<form:errors path="description" cssClass="error" />
	<br>
	<spring:message code="label.addVariantToQuestion.isRightAnswer" />
	<input type="hidden" value="on" name="_rightAnswer" />
	<input type="checkbox" name="rightAnswer" />
	<br>
	<input type="hidden" value="${question.id}" name="questionId" required />
	<input type="submit"
		value="<spring:message code="label.addVariantToQuestion.submit" />"
		class="btn btn-primary" />
</form:form>