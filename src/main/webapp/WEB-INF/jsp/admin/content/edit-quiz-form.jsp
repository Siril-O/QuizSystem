<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h1>
	<spring:message code="label.editQuiz" />
</h1>
<form:form action="/QuizSystem/jsp/quiz/changeName"
	modelAttribute="quiz" method="post">
	<table class="table table-hover">
		<tr>
			<td><spring:message code="label.editQuiz.quizName" /></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="hidden" name="quizId" value="${quiz.id}"
					required="required" /> <form:input type="text" path="name"
					required="required" /> <form:errors path="name" cssClass="error" />
			</td>
			<td><input type="submit"
					value="<spring:message code="label.editQuiz.changeName" />"
					class="btn btn-primary" /></td>
		</tr>
	</table>
</form:form>
<form action="/QuizSystem/jsp/quiz/changeSubject" method="post">
	<table class="table table-hover">
		<tr>
			<td><spring:message code="label.editQuiz.currentSubject" /></td>
			<td><spring:message code="label.editQuiz.avaliableSubject" /></td>
			<td></td>
		</tr>
		<tr>
			<td><input name="subject" value="${quiz.subject.name}" readonly /></td>
			<td><select name="subjectId" required="required">
					<c:forEach var="subject" items="${subjects}">
						<option value="${subject.id}"
							${subject.id == quiz.subject.id ? 'selected="selected"' : ''}>
							${subject.name}</option>
					</c:forEach>
			</select></td>
			<td><input type="hidden" name="quizId" value="${quiz.id}"
					required="required" /> <input type="submit"
					value="<spring:message code="label.editQuiz.changeSubject" />"
					class="btn btn-primary" /></td>
		</tr>
	</table>
</form>
<hr>
<h3>
	<spring:message code="label.editQuiz.editQuestions" />
</h3>
<form action="/QuizSystem/jsp/question/add" method="post">
	<input type="hidden" name="quizId" value="${quiz.id}"
		required="required" />
	<input type="submit"
		value="<spring:message code="label.editQuiz.addQuestion" />"
		class="btn btn-primary" />
</form>
<h3>
	<spring:message code="label.editQuiz.questions" />
</h3>
<table class="table table-hover">
	<tr>
		<td><spring:message code="label.id" /></td>
		<td><spring:message code="label.Description" /></td>
		<td></td>
		<td></td>
	</tr>
	<c:forEach items="${quiz.questions}" var="question">
		<tr>
			<td><c:out value="${question.id}" /></td>
			<td><textarea rows="10" cols="60"><c:out
						value="${question.description}" /></textarea></td>
			<td>
				<form action="/QuizSystem/jsp/question/editForm" method="get">
					<input type="submit"
						value="<spring:message code="label.editQestion"/>"
						class="btn btn-primary" />
					<input type="hidden" name="questionId" value="${question.id}"
						required>
				</form>
			</td>
			<td>
				<form action="/QuizSystem/jsp/question/remove" method="post">
					<input type="hidden" name="questionId" value="${question.id}"
						required>
					<spring:message code="label.editQuiz.confirmRemove" />
					<input type="checkbox" name="confirm" required>
					<input type="submit"
						value="<spring:message code="label.editQuiz.removeQuestion" />"
						class="btn btn-primary" />
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
