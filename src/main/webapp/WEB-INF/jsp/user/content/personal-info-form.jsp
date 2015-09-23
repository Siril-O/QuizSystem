<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3>
	<spring:message code="label.personalInfo" />
</h3>
<ul class="nav navbar-nav navbar-right">

	<li><p class="navbar-text">
			<spring:message code="label.headerLanguage" />
		</p></li>
	<li><a href="?language=en"><spring:message
				code="label.headerEnglishLanguage" /></a></li>
	<li><a href="?language=ru_RU"><spring:message
				code="label.headerRussianLanguage" /></a></li>
</ul>
<form>
	<table class="table table-hover">
		<tr>
			<td><spring:message code="label.personalInfo.name" /></td>
			<td><input type="text" name="name" value="${user.name}"
					class="form-control" readonly></td>
		</tr>
		<tr>
			<td><spring:message code="label.personalInfo.surname" /></td>
			<td><input type="text" name="surname" value="${user.surname}"
					class="form-control" readonly></td>
		</tr>
		<tr>
			<td><spring:message code="label.personalInfo.email" /></td>
			<td><input type="text" name="email" value="${user.email}"
					class="form-control" readonly></td>
		</tr>
		<tr>
			<td><spring:message code="label.personalInfo.role" /></td>
			<td><input type="text" name="role" value="${user.role}"
					class="form-control" readonly></td>
		</tr>
	</table>
</form>