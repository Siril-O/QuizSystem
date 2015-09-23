<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3><spring:message code="label.passQuestion" />${question.quiz.name}</h3>
<form action="/QuizSystem/jsp/pass/question" method="post">
	<textarea rows="10" cols="60" readonly>${question.description}</textarea>
	<table class="table table-hover">
		<c:forEach var="variant" items="${question.variants}">
			<tr>
				<td width="30px"><input type="checkbox" name="choosedVariants"
						value="${variant.id}"/></td>
				<td><c:out value="${variant.description}" /></td>
			</tr>
		</c:forEach>
	</table>
	<input type="hidden" name="questionId" value="${question.id}" required>
	<input type="submit" value="<spring:message code="label.passQuestion.answer" />" class="btn btn-primary" />
</form>