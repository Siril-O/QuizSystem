<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Result</h3>
<table class="table table-hover">
	<tr>
		<td>Quiz Name</td>
		<td><c:out value="${result.quiz.name}" /></td>
	</tr>
	<tr>
		<td>Start Time</td>
		<td><c:out value="${result.startTime}" /></td>
	</tr>
	<tr>
		<td>Finish Time</td>
		<td><c:out value="${result.endTime}" /></td>
	</tr>
	<tr>
		<td>Right Answers</td>
		<td><c:out value="${result.rightAnswers}" /></td>
	</tr>
	<tr>
		<td>Wrong Answers</td>
		<td><c:out value="${result.wrongAnswers}" /></td>
	</tr>
	<tr>
		<td>Percent</td>
		<td>${result.rightAnswers/(result.rightAnswers+result.wrongAnswers)*100}%</td>
	</tr>
</table>
<h3>Questions</h3>
<ol>
	<c:forEach var="entry" items="${resultMap}">
		<hr>
		<li><br> <textarea rows="13" cols="70" name="description"
				readonly="readonly"><c:out
					value="${entry.key.description}" /></textarea> <br>
			<table class="table table-hover">
				<tr>
					<td>Variants</td>
					<td>Right Answer</td>
					<td>Your Answer</td>
				</tr>
				<c:forEach var="variantEntry" items="${entry.value}">
					<tr>
						<td><c:out value="${variantEntry.key.description}" /></td>
						<td><c:choose>
								<c:when test="${variantEntry.key.rightAnswer}">
									<input name="rightAnswer" type="checkbox" checked readonly />
								</c:when>
								<c:otherwise>
									<input name="rightAnswer" type="checkbox" readonly />
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${variantEntry.value}">
									<input name="rightAnswer" type="checkbox" checked readonly />
								</c:when>
								<c:otherwise>
									<input name="rightAnswer" type="checkbox" readonly />
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table></li>
	</c:forEach>
</ol>