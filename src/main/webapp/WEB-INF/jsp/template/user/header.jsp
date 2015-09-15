<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Quiz System</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/QuizSystem/jsp/quiz/avaliable">Quizes</a></li>
				<li><a href="/QuizSystem/jsp/user/results">Results</a></li>
				<li><a href="/QuizSystem/jsp/user/info">Personal</a></li>
			</ul>
			<c:url var="logOutUrl" value="/logout" />
			<form action="${logOutUrl}" method="post"
				class="navbar-form navbar-right">
				<div class="form-group">
					<a href="/QuizSystem/jsp/user/info">${user.name}, ${user.surname}</a>
					<input class="btn btn-primary" type="submit" value="Log Out" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</form>
		</div>
	</div>
</nav>
