<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subjects</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
</head>
<body>
	<div class="container">
		<h3>All Subjects</h3>
		<form action="/QuizSystem/jsp/subject/add" method="post">
			<input type="submit" value="Add Subject" class="btn btn-primary" />
		</form>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td></td>
			</tr>
			<c:forEach var="subject" items="${subjectList}">
				<tr>
					<td><c:out value="${subject.id}" /></td>
					<td><c:out value="${subject.name}" /></td>
					<td><form action="/QuizSystem/jsp/subject/edit">
							<input type="submit" value="Edit" class="btn btn-primary" /> <input
								type="hidden" name="subjectId" value="${subject.id}">
						</form></td>
					<td><form action="/QuizSystem/jsp/subject/remove" method="post">
							<input type="submit" value="Remove" class="btn btn-primary" /> <input
								type="hidden" name="subjectId" value="${subject.id}">
						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>