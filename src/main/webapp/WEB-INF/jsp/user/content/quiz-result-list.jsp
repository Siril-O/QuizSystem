<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>User Results of Quizes</h3>
		User: ${user.name}
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>Quiz Name</td>
				<td>Start Time</td>
				<td>Finish Time</td>
				<td>Right Answers</td>
				<td>Wrong Answers</td>
				<td>Percent</td>
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