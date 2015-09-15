<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>${param.title}</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/template/admin/header.jsp" />
	<div class="container" style="margin-top: 50px; margin-bottom: 20px;"><jsp:include
			page="/WEB-INF/jsp/${param.content}.jsp" /></div>
	<jsp:include page="/WEB-INF/jsp/template/admin/footer.jsp" />
</body>
</html>