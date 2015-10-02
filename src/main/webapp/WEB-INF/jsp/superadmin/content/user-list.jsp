<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3>
	<spring:message code="label.userList" />
</h3>
<form action="/QuizSystem/jsp/user/registerForm" method="post">
	<input type="submit"
		value="<spring:message	code="label.userList.registerUser"  />"
		class="btn btn-primary" />
</form>
<table class="table table-hover">
	<tr>
		<td><spring:message code="label.userList.name" /></td>
		<td><spring:message code="label.userList.surname" /></td>
		<td><spring:message code="label.userList.email" /></td>
		<td><spring:message code="label.userList.role" /></td>
		<td></td>
		<td></td>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.surname}" /></td>
			<td><c:out value="${user.email}" /></td>
			<td><c:out value="${user.role}" /></td>
			<td><form action="/QuizSystem/jsp/user/edit">
					<input type="submit"
						value="<spring:message code="label.userList.edit" />"
						class="btn btn-primary" />
					<input type="hidden" name="userId" value="${user.id}" required>
				</form></td>
		</tr>
	</c:forEach>
</table>
<ul class="pagination">
	<c:forEach begin="1" end="${pagesNumber}" var="i">
		<c:set var="pageOffset" value="${(i-1)*maxResults}" />
		<li <c:if test="${offset==(pageOffset)}">class="active"</c:if>>
			<a href="/QuizSystem/jsp/user/all?offset=${pageOffset}">${i} </a>
		</li>
	</c:forEach>
</ul>
