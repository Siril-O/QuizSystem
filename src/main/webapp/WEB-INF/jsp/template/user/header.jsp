<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/QuizSystem/jsp/quiz/avaliable">Quiz System</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/QuizSystem/jsp/quiz/avaliable"><spring:message code="label.headerUserQuizes" /></a></li>
				<li><a href="/QuizSystem/jsp/user/results"><spring:message code="label.headerUserResults" /></a></li>
				<li><a href="/QuizSystem/jsp/user/info"><spring:message code="label.headerUserPersonal" /></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><c:url var="logOutUrl" value="/logout" />
					<form action="${logOutUrl}" method="post"
						class="navbar-form navbar-right">
						<div class="form-group">
							<a href="/QuizSystem/jsp/user/info">${user.name}, ${user.surname}</a>
							<input class="btn btn-primary" type="submit" value="<spring:message code="label.headerLogOut" />" />
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
					</form></li>
			</ul>
		</div>
	</div>
</nav>
