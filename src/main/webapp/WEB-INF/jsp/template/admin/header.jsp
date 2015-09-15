<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Quiz System</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/QuizSystem/jsp/quiz/"><spring:message code="label.headerQuizes" /></a></li>
				<li><a href="/QuizSystem/jsp/subject/"><spring:message code="label.headerSubjects" /></a></li>
				<li><a href="/QuizSystem/jsp/user/"><spring:message code="label.headerUsers" /></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><c:url var="logOutUrl" value="/logout" />
					<form action="${logOutUrl}" method="post"
						class="navbar-form navbar-right">
						<div class="form-group">
							<a href="/QuizSystem/jsp/user/">${user.name}, ${user.surname}</a>
							<input class="btn btn-primary" type="submit" value="<spring:message code="label.headerLogOut" />" />
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
					</form></li>

				<li><p class="navbar-text"><spring:message code="label.headerLanguage" /></p></li>
				<li><a href="?language=en"><spring:message code="label.headerEnglishLanguage" /></a></li>
				<li><a href="?language=ru_RU"><spring:message code="label.headerRussianLanguage" /></a></li>
			</ul>
		</div>
	</div>
</nav>