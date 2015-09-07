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
		<h3>All Students</h3>
		<form action="/QuizSystem/jsp/user/registerForm" method="post">
			<input type="submit" value="Register User" class="btn btn-primary" />
		</form>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Password</td>
				<td>Role</td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.surname}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.password}" /></td>
					<td><c:out value="${user.role}" /></td>
					<td><form action="/QuizSystem/jsp/user/edit">
							<input type="submit" value="Edit" class="btn btn-primary" />
							<input type="hidden" name="userId" value="${user.id}">
						</form></td>
					<td><form action="/QuizSystem/jsp/user/assignQuizForm"
							method="post">
							<input type="submit" value="Assign Quiz" class="btn btn-primary" />
							<input type="hidden" name="userId" value="${user.id}">
						</form></td>
				</tr>
				<tr>
					<td colspan="8"><ul>
							<c:forEach var="quiz" items="${user.avaliableQuizes}">
								<li><c:out value="${quiz.name}" />
									<form action="/QuizSystem/jsp/user/unassignQuiz" method="post">
										<input type="hidden" name="quizId" value="${quiz.id}" />
										<input type="submit" value="Unassign Quiz"
											class="btn btn-primary" />
										<input type="hidden" name="userId" value="${user.id}">
									</form></li>
							</c:forEach>
						</ul></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>