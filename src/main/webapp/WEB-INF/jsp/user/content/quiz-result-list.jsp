<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h3><spring:message code="label.quizResult.result" /></h3>
		<table class="table table-hover">
			<tr>
				<td><spring:message code="label.quizResult.id" /></td>
				<td><spring:message code="label.quizExtenderResult.quizName" /></td>
				<td><spring:message code="label.quizExtenderResult.startTime" /></td>
				<td><spring:message code="label.quizExtenderResult.finishTime" /></td>
				<td><spring:message code="label.quizExtenderResult.rightAnswers" /></td>
				<td><spring:message code="label.quizExtenderResult.wrongAnswers" /></td>
				<td><spring:message code="label.quizExtenderResult.percent" /></td>
			</tr>
			<c:forEach var="result" items="${quizResultList}">
				<tr>
					<td><c:out value="${result.id}" /></td>
					<td><c:out value="${result.quiz.name}" /></td>
					<td><c:out value="${result.startTime}" /></td>
					<td><c:out value="${result.endTime}" /></td>
					<td><c:out value="${result.rightAnswers}" /></td>
					<td><c:out value="${result.wrongAnswers}" /></td>
					<td>${result.rightAnswers/(result.rightAnswers+result.wrongAnswers)*100}%</td>
				</tr>
			</c:forEach>
		</table>