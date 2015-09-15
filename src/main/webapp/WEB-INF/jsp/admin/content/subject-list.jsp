<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3><spring:message code="label.subjectList" /></h3>
		<form action="/QuizSystem/jsp/subject/add" method="post">
			<input type="submit" value="<spring:message code="label.subjectList.addSubject" />" class="btn btn-primary" />
		</form>
		<table class="table table-hover">
			<tr>
				<td><spring:message code="label.subjectList.id" /></td>
				<td><spring:message code="label.subjectList.name" /></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach var="subject" items="${subjectList}">
				<tr>
					<td><c:out value="${subject.id}" /></td>
					<td><c:out value="${subject.name}" /></td>
					<td><form action="/QuizSystem/jsp/subject/edit">
							<input type="submit" value="<spring:message code="label.subjectList.edit" />" class="btn btn-primary" /> <input
								type="hidden" name="subjectId" value="${subject.id}">
						</form></td>
					<td><form action="/QuizSystem/jsp/subject/remove" method="post">
							<input type="submit" value="<spring:message code="label.subjectList.remove" />" class="btn btn-primary" /> <input
								type="hidden" name="subjectId" value="${subject.id}">
						</form></td>
				</tr>
			</c:forEach>
		</table>