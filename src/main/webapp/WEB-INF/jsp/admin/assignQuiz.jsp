<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
<title>Assign Quiz</title>
</head>
<body>
	<div class="container">
		<h1>
			Assign Quiz to User ID:
			<c:out value="${user.id}" />
		</h1>
		<form action="/QuizSystem/jsp/user/assignQuiz" class="form-horizontal"
			method="get">
			<c:forEach var="quiz" items="${quizList}">
				<input type="radio" name="quizId" value="${quiz.id}" />
				<c:out value="${quiz.name}"></c:out><br>
			</c:forEach>
			<input type="hidden" value="${user.id}" name="userId" /> <input
				type="submit" value="Assign Quiz" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>