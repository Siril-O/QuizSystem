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
		<h3>User Results of Quizes</h3>
		User: ${user.name}
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Quiz Name</td>
				<td>Start Time</td>
				<td>Finish Time</td>
				<td>Right Answers</td>
				<td>Wrong Answers</td>
				<td>Percent</td>
			</tr>
			<c:forEach var="result" items="${quizResultList}">
				<tr>
					<td><c:out value="${result.id}" /></td>
					<td><c:out value="${result.quiz.name}" /></td>
					<td><c:out value="${result.startTime}" /></td>
					<td><c:out value="${result.endTime}" /></td>
					<td><c:out value="${result.rightAnswers}" /></td>
					<td><c:out value="${result.wrongAnswers}" /></td>
					<td>${result.rightAnswers/(result.rightAnswers+result.wrongAnswers)*100}%</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>