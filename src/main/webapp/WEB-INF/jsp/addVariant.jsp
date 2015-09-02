<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
<title>Add Variant</title>
</head>
<body>
	<div class="container">
		<h1>
			Add Variant to Question ID:
			<c:out value="${question.id}" />
			From Quiz Id:
			<c:out value="${question.quiz.id}"></c:out>
		</h1>
		<form action="/QuizSystem/jsp/variant/create" class="form-horizontal"
			method="post">
			Description:
			<textarea name="description" class="form-control"></textarea>
			<br> Is Right Answer: <input type="hidden" value="on"
				name="_rightAnswer" /> <input type="checkbox" name="rightAnswer" /><br>
			<input type="hidden" value="${question.id}" name="questionId" /> <input
				type="submit" value="Add Variant" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>