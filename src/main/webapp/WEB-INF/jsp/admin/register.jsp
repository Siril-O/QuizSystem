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
		<h3>Register Student</h3>
		<form action="/QuizSystem/jsp/user/register" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label for="name">First Name:</label>
				<input type="text" name="name" class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="surname">Last Name:</label>
				<input type="text" name="surname" class="form-control" id="surname">
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" name="email" class="form-control" id="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" name="password" class="form-control"
					id="password">
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password:</label>
				<input type="password" name="confirmPassword" class="form-control"
					id="confirmPassword">
			</div>
			<input type="submit" name="Register" class="btn btn-primary" />

		</form>
	</div>
</body>
</html>