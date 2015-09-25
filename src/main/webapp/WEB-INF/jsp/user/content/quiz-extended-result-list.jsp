<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>
	<spring:message code="label.quizExtenderResult" />
</h3>
<table class="table table-hover">
	<tr>
		<td><spring:message code="label.quizExtenderResult.quizName" /></td>
		<td><c:out value="${result.quiz.name}" /></td>
	</tr>
	<tr>
		<td><spring:message code="label.quizExtenderResult.startTime" /></td>
		<td><fmt:formatDate type="both" dateStyle="short"
				timeStyle="short" value="${result.startTime}" /></td>
	</tr>
	<tr>
		<td><spring:message code="label.quizExtenderResult.finishTime" /></td>
		<td><fmt:formatDate type="both" dateStyle="short"
				timeStyle="short" value="${result.endTime}" /></td>
	</tr>
	<tr>
		<td><spring:message code="label.quizExtenderResult.rightAnswers" /></td>
		<td><c:out value="${result.rightAnswers}" /></td>
	</tr>
	<tr>
		<td><spring:message code="label.quizExtenderResult.wrongAnswers" /></td>
		<td><c:out value="${result.wrongAnswers}" /></td>
	</tr>
	<tr>
		<td><spring:message code="label.quizExtenderResult.percent" /></td>
		<td><fmt:formatNumber var="percent"
				value="${result.rightAnswers/(result.rightAnswers+result.wrongAnswers)*100}"
				maxFractionDigits="0" />${percent}%</td>
	</tr>
</table>
<h3>
	<spring:message code="label.quizExtenderResult.questions" />
</h3>
<ol>
	<c:forEach var="entry" items="${resultMap}">
		<hr>
		<li><br> <textarea rows="13" cols="70" name="description"
				readonly="readonly"><c:out
					value="${entry.key.description}" /></textarea> <br>
			<table class="table table-hover">
				<tr>
					<td><spring:message code="label.quizExtenderResult.variants" /></td>
					<td><spring:message
							code="label.quizExtenderResult.rightAnswer" /></td>
					<td><spring:message code="label.quizExtenderResult.yourAnswer" /></td>
				</tr>
				<c:forEach var="variantEntry" items="${entry.value}">
					<tr>
						<td><c:out value="${variantEntry.key.description}" /></td>
						<td><c:choose>
								<c:when test="${variantEntry.key.rightAnswer}">
									<input name="rightAnswer" type="checkbox" checked
										disabled="disabled" />
								</c:when>
								<c:otherwise>
									<input name="rightAnswer" type="checkbox" disabled="disabled" />
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${variantEntry.value}">
									<input name="rightAnswer" type="checkbox" checked
										disabled="disabled" />
								</c:when>
								<c:otherwise>
									<input name="rightAnswer" type="checkbox" disabled="disabled" />
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table></li>
	</c:forEach>
</ol>