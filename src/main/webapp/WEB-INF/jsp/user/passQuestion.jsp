<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question List</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
</head>
<body>
	<div class="container">
		<h3>Passing Quiz "${question.quiz.name}"</h3>
		<form action="/QuizSystem/jsp/quiz/answerQuestion" method="get">
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
	</div>
</body>
</html>