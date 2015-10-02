<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/QuizSystem/jsp/user/all">Quiz
				System</a>
		</div>
	</div>
	</nav>
	<div class="container" style="margin-top: 60px;">
		<h1>Login</h1>
		<c:url value="/login" var="loginUrl" />
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error != null}">
				<div class="notice-box alert message">
					<div class="msg">Failed to login. Bag credentials</div>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You have been logged out.</div>
			</c:if>
			<div class="form-group">
				<label class="control-label" for="email">E-mail(login)</label><br />
				<input type="text" name='username'  id="email" class="form-control"  required="required"/>
			</div>
			<div class="form-group">
				<label class="control-label" for="password">Password:</label><br />
				<input type='password' name='password' id="password"
					class="form-control" required="required" />
			</div>
			<input type="submit" value="Login" class="btn btn-primary" />
		</form>
	</div>
	<div style="min-height: 60px;"></div>
	<div class="navbar-fixed-bottom row-fluid">
		<div class="navbar-inner">
			<footer class="footer"
				style="margin-top: 50px; background-color: #D8D8D8">
			<div class="container">
				<p>By Kovalchuk Kyrylo 2015</p>
			</div>
			</footer>
		</div>
	</div>
</body>
</html>