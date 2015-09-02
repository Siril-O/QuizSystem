<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
<title>Edit Subject</title>
</head>
<body>
	<div class="container">
		<h1>Edit Subject</h1>
		<form action="/QuizSystem/jsp/subject/update"
			class="form-horizontal" method="post">
			Name:<input type="text" name="name"  value="${subject.name}"/>
			<input type="hidden" name="id" value="${subject.id}"/>
			<input type="submit"
				value="Edit Subject" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>