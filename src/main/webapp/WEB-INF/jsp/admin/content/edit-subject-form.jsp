<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Edit Subject</h1>
<form action="/QuizSystem/jsp/subject/update" class="form-horizontal"
	method="post">
	Name:
	<input type="text" name="name" value="${subject.name}" />
	<input type="hidden" name="id" value="${subject.id}" />
	<input type="submit" value="Edit Subject" class="btn btn-primary" />
</form>