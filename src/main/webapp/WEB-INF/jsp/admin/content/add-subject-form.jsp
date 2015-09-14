<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Create Subject</h1>
<form action="/QuizSystem/jsp/subject/create" class="form-horizontal"
	method="post">
	Name:
	<input type="text" name="name" />
	<input type="submit" value="Create Subject" class="btn btn-primary" />
</form>