<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/bootstrap.min.css" />" />
<title>Edit Quiz</title>
</head>
<body>
	<div class="container">
		<h1>Edit Quiz</h1>
		<form action="/QuizSystem/jsp/quiz/changeName" method="post">
			<input type="hidden" name="quizId" value="${quiz.id}" />Quiz Name: <input
				type="text" name="name" value="${quiz.name}" /> <input
				type="submit" value="Change Name" class="btn btn-primary" /><br>Quiz
			Subject<input name="subject" value="${quiz.subject.name}"
				readonly="readonly">
		</form>
		<form action="/QuizSystem/jsp/quiz/changeSubject" method="get">
			<input type="hidden" name="quizId" value="${quiz.id}" /> Subjects<select
				name="subjectId">
				<c:forEach var="subject" items="${subjects}">
					<option value="${subject.id}"
						${subject.id == quiz.subject.id ? 'selected="selected"' : ''}>
						${subject.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Change Subject" class="btn btn-primary" />
		</form>
		<hr>
		<h3>Edit questions</h3>
		<form action="/QuizSystem/jsp/question/add" method="get">
			<input type="hidden" name="quizId" value="${quiz.id}" /> <input
				type="submit" value="Add Question To Quiz" class="btn btn-primary" />
		</form>
		<h3>Questions</h3>
		<ol>
			<c:forEach var="question" items="${quiz.questions}">
				<li>ID:<c:out value="${question.id}" /><br>
					<form action="/QuizSystem/jsp/question/remove" method="post">
						<input type="hidden" name="questionId" value="${question.id}">
						<input type="hidden" value="on" name="_confirm" />
						<input type="submit" value="Remove" class="btn btn-primary" />
						Confirm Remove<input type="checkbox" name="confirm">
					</form>
					<form action="/QuizSystem/jsp/question/update" method="post">
						<textarea rows="10" cols="70" name="description"><c:out
								value="${question.description}" /></textarea>
						<br> <input type="hidden" name="questionId"
							value="${question.id}" /> <input type="submit"
							value="Change Description" class="btn btn-primary" />
					</form>
					<h4>Variants:</h4>
					<form action="/QuizSystem/jsp/variant/add">
						<input type="submit" value="Add Variant to Question"
							class="btn btn-primary" /> <input type="hidden"
							name="questionId" value="${question.id}">
					</form>
					<table class="table table-hover">
						<tr>
							<td>Id</td>
							<td>Description</td>
							<td>Is Right Answer</td>
							<td></td>
						</tr>
					</table> <c:forEach var="variant" items="${question.variants}">
						<form action="/QuizSystem/jsp/variant/edit">
							<table class="table table-hover">
								<tr>
									<td><c:out value="${variant.id}" /></td>
									<td><input name="id" type="hidden" value="${variant.id}" />
										<textarea class="form-control" name="description" rows="2"
											cols="40"><c:out value="${variant.description}" /></textarea>
									</td>
									<td><input type="hidden" value="on" name="_rightAnswer" />
										<c:choose>
											<c:when test="${variant.rightAnswer}">
												<input name="rightAnswer" type="checkbox" checked />
											</c:when>
											<c:otherwise>
												<input name="rightAnswer" type="checkbox" />
											</c:otherwise>
										</c:choose></td>
									<td><input type="submit" value="Change"
										class="btn btn-primary" /> <input type="hidden"
										name="questionId" value="${question.id}" /> <a
										href="/QuizSystem/jsp/variant/remove?variantId=${variant.id}"
										class="btn btn-primary">Remove</a></td>

								</tr>
							</table>
						</form>
					</c:forEach>
				</li>
			</c:forEach>
		</ol>
	</div>
</body>
</html>