<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz List</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
</head>
<body>
	<div class="container">
		<h3>All Users</h3>
		<form action="/QuizSystem/jsp/user/registerfdd" method="post">
			<input type="submit" value="Dont push" class="btn btn-primary" />
		</form>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Subject</td>
				<td></td>
			</tr>
			<c:forEach var="quiz" items="${user.avaliableQuizes}">
				<tr>
					<td><c:out value="${quiz.id}" /></td>
					<td><c:out value="${quiz.name}" /></td>
					<td><c:out value="${quiz.subject.name}" /></td>
					<td><form action="/QuizSystem/jsp/quiz/passQuiz" method="get">
							<input type="submit" value="Start passing" class="btn btn-primary" /> <input
								type="hidden" name="quizId" value="${quiz.id}">
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>