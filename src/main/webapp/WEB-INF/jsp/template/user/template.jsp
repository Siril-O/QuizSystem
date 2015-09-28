<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>${param.title}</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/template/user/header.jsp" />
	<c:if test="${noticeMessage!=null}">
		<div class="container">
			<div class="notice-box alert message">
				<div class="msg">
					<spring:message code="${noticeMessage}" />
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${succesMessage!=null}">
		<div class="container">
			<div class="success-box alert message">
				<div class="msg">
					<spring:message code="${succesMessage}" />
				</div>
			</div>
		</div>
	</c:if>
	<div class="container" style="margin-top: 50px; margin-bottom: 20px;"><jsp:include
			page="/WEB-INF/jsp/${param.content}.jsp" /></div>
	<jsp:include page="/WEB-INF/jsp/template/user/footer.jsp" />
</body>
</html>