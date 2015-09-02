<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
<title>Edit Question</title>
</head>
<body>
	<div class="container">
		<h1>Edit Question</h1>
		<form action="/QuizSystem/jsp/question/editQuestionDescr"
			method="post">
			<h3>Description:</h3>
			<input type="hidden" name="id" value="${question.id}" />

			<textarea rows="10" cols="60">${question.description}</textarea>
			<br> <input type="submit" value="Change Description"
				class="btn btn-primary" />
		</form>
		<hr>
		<h3>Variants</h3>
		<form action="/QuizSystem/jsp/question/addVariant">
			<input type="submit" value="Add Variant" class="btn btn-primary" />
			<input type="hidden" name="questionId" value="${question.id}">
		</form>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Description</td>
				<td></td>
			</tr>
			<c:forEach var="variant" items="${question.variants}">
				<tr>
					<td><c:out value="${variant.id}" /></td>
					<td><c:out value="${variant.description}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>