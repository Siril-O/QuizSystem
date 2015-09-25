<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>
	<spring:message code="label.quizResult.result" />
</h3>
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
			<td><fmt:formatDate type="both" dateStyle="medium"
					timeStyle="short" value="${result.startTime}" /></td>
			<td><fmt:formatDate type="both" dateStyle="medium"
					timeStyle="short" value="${result.endTime}" /></td>
			<td><c:out value="${result.rightAnswers}" /></td>
			<td><c:out value="${result.wrongAnswers}" /></td>
			<td><fmt:formatNumber var="percent"
					value="${result.rightAnswers/(result.rightAnswers+result.wrongAnswers)*100}"
					maxFractionDigits="0" />${percent}%</td>
		</tr>
	</c:forEach>
</table>