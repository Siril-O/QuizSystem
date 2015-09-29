<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>
	<spring:message code="label.addQuestionToQuiz.addQuestion" />
	<c:out value="${quiz.name}"></c:out>
</h1>
<form:form action="/QuizSystem/jsp/question/create"
	class="form-horizontal" method="post" modelAttribute="question">
	<spring:message code="label.Description" />
	<form:textarea path="description" required="required"
		class="form-control" rows="10" />
	<form:errors path="description" cssClass="error" />
	<br>
	<input type="hidden" value="${quiz.id}" name="quizId"
		required="required" />
	<c:forEach var="variant" items="${question.variants}" varStatus="i">
		<table class="table table-hover">
			<tr>
				<td><form:hidden path="variants[${i.index}].id"
						required="required" /> <form:textarea
						path="variants[${i.index}].description" rows="3" cols="70"
						required="required" /></td>
				<td><spring:message code="label.editQuiz.isRightAnswer" /> <form:checkbox path="variants[${i.index}].rightAnswer" /></td>
			</tr>
			<tr>
				<form:errors path="variants[${i.index}].description"
					cssClass="error" />
			</tr>
		</table>
	</c:forEach>
	<input type="submit"
		value="<spring:message code="label.addQuestionToQuiz.submitAddQuestion" />"
		class="btn btn-primary" />
</form:form>