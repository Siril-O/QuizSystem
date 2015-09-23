<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1><spring:message code="label.editQuiz" /></h1>
<form action="/QuizSystem/jsp/quiz/changeName" method="post">
	<table class="table table-hover">
		<tr>
			<td><spring:message code="label.editQuiz.quizName" /></td>
			<td></td>
		</tr>
		<tr>
			<td><input type="hidden" name="quizId" value="${quiz.id}" required="required"/> <input
					type="text" name="name" value="${quiz.name}" required="required"/></td>
			<td><input type="submit" value="<spring:message code="label.editQuiz.changeName" />"
					class="btn btn-primary" /></td>
		</tr>
	</table>
</form>
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
			<td><input type="hidden" name="quizId" value="${quiz.id}" required="required"/> <input
					type="submit" value="<spring:message code="label.editQuiz.changeSubject" />" class="btn btn-primary" /></td>
		</tr>
	</table>
</form>
<hr>
<h3><spring:message code="label.editQuiz.editQuestions" /></h3>
<form action="/QuizSystem/jsp/question/add" method="post">
	<input type="hidden" name="quizId" value="${quiz.id}" required="required"/>
	<input type="submit" value="<spring:message code="label.editQuiz.addQuestion" />"
		class="btn btn-primary" />
</form>
<h3><spring:message code="label.editQuiz.questions" /></h3>
<ol>
	<c:forEach var="question" items="${quiz.questions}">
		<li class="question_list_item">
			<div class="removeBlock">
				<form action="/QuizSystem/jsp/question/remove" method="post">
					<input type="hidden" name="questionId" value="${question.id}" required="required">
					<input type="hidden" value="on" name="_confirm" />
					<input type="submit" value="<spring:message code="label.editQuiz.removeQuestion" />" class="btn btn-primary" />
					<spring:message code="label.editQuiz.confirmRemove" />
					<input type="checkbox" name="confirm" required="required">
				</form>
			</div>
			<form action="/QuizSystem/jsp/question/update" method="post">
				<textarea rows="10" cols="70" name="description" required="required"><c:out
						value="${question.description}" /></textarea>
				<br>
				<input type="hidden" name="questionId" value="${question.id}" required="required"/>
				<input type="submit" value="<spring:message code="label.editQuiz.changeDescription" />"
					class="btn btn-primary" />
			</form>
			<h4><spring:message code="label.editQuiz.variants" /></h4>
			<form action="/QuizSystem/jsp/variant/add">
				<input type="submit" value="<spring:message code="label.editQuiz.addVariantToQuestion" />"
					class="btn btn-primary" />
				<input type="hidden" name="questionId" value="${question.id}" required="required">
			</form>
			<table class="table table-hover">
				<tr>
					<td><spring:message code="label.editQuiz.description" /></td>
					<td><spring:message code="label.editQuiz.isRightAnswer" /></td>
					<td></td>
				</tr>
			</table> <c:forEach var="variant" items="${question.variants}">
				<form action="/QuizSystem/jsp/variant/edit" method="post">
					<table class="table table-hover">
						<tr>
							<td><input name="id" type="hidden" value="${variant.id}" required="required"/>
								<textarea  name="description" rows="3"
									cols="70" required="required">
									${variant.description}</textarea></td>
							<td><input type="hidden" value="on" name="_rightAnswer" />
								<c:choose>
									<c:when test="${variant.rightAnswer}">
										<input name="rightAnswer" type="checkbox" checked />
									</c:when>
									<c:otherwise>
										<input name="rightAnswer" type="checkbox" />
									</c:otherwise>
								</c:choose></td>
							<td><input type="submit" value="<spring:message code="label.editQuiz.changeVariant" />"
									class="btn btn-primary" /> <input type="hidden"
									name="questionId" value="${question.id}" required="required"/><a
								href="/QuizSystem/jsp/variant/remove?variantId=${variant.id}"
								class="btn btn-primary"><spring:message code="label.editQuiz.removeVariant" /></a></td>
						</tr>
					</table>
				</form>
			</c:forEach>
		</li>
	</c:forEach>
</ol>