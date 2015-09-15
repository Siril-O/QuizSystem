<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Passing Quiz "${question.quiz.name}"</h3>
<form action="/QuizSystem/jsp/pass/question" method="post">
	<textarea rows="10" cols="60">${question.description}</textarea>
	<table class="table table-hover">
		<c:forEach var="variant" items="${question.variants}"
			varStatus="status">
			<tr>
				<td width="30px"><input type="checkbox" name="choosedVariants"
						value="${variant.id}" /></td>
				<td><c:out value="${variant.description}" /></td>
			</tr>
		</c:forEach>
	</table>
	<input type="hidden" name="questionId" value="${question.id}">
	<input type="submit" value="Answer" class="btn btn-primary" />
</form>