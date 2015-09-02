<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
<title>Create Quiz</title>
</head>
<body>
	<div class="container">
		<h1>Create Quiz</h1>
		<form action="/QuizSystem/jsp/quiz/create" class="form-horizontal"
			method="post">
			Name:<input type="text" name="name" class="form-control"/> <br> Subject:<select class="form-control"
				name="subjectId">
				<c:forEach var="subject" items="${subjects}">
					<option value="${subject.id}">${subject.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Create Quiz" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>