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
	<div class="container">
		<h1>Log in to System</h1>
		<c:url value="/login" var="loginUrl" />
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error != null}">
				<div class="alert alert-error">
					Failed to login.
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.
message}" />
					</c:if>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">You have been logged out.</div>
			</c:if>
			<div class="form-group">
				<label class="control-label" for="email">E-mail(login)</label><br />
				<input type="text" name='username' id="email" class="form-control" />
			</div>

			<div class="form-group">
				<label class="control-label" for="password">Password:</label><br />
				<input type='password' name='password' id="password"
					class="form-control" />
			</div>
			<input type="submit" value="submit" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>