<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz List</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
</head>
<body>
	<div class="container">
		<h3>User: ${user.name} Result</h3>
		<table class="table table-hover">
			<tr>
				<td>Quiz Name</td>
				<td>Start Time</td>
				<td>Finish Time</td>
				<td>Right Answers</td>
				<td>Wrong Answers</td>
				<td>Percent</td>
			</tr>
			<tr>
				<td><c:out value="${result.quiz.name}" /></td>
				<td><c:out value="${result.startTime}" /></td>
				<td><c:out value="${result.endTime}" /></td>
				<td><c:out value="${result.rightAnswers}" /></td>
				<td><c:out value="${result.wrongAnswers}" /></td>
				<td>${result.rightAnswers/(result.rightAnswers+result.wrongAnswers)*100}%</td>
			</tr>
		</table>
		<h3>Questions</h3>
		<ol>
			<c:forEach var="entry" items="${resultMap}"><hr>
				<li><br><textarea rows="13" cols="70" name="description"
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
	</div>
</body>
</html>