<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Create Quiz</h1>
<form action="/QuizSystem/jsp/quiz/create" class="form-horizontal"
	method="post">
	Name:
	<input type="text" name="name" class="form-control" />
	<br> Subject:<select class="form-control" name="subjectId">
		<c:forEach var="subject" items="${subjects}">
			<option value="${subject.id}">${subject.name}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Create Quiz" class="btn btn-primary" />
</form>