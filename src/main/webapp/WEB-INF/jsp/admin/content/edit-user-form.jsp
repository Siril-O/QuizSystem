<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Edit Student</h3>
		<form action="/QuizSystem/jsp/user/update" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label for="name">First Name:</label>
				<input type="text" value="${userToEdit.name}" name="name" class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="surname">Last Name:</label>
				<input type="text" value="${userToEdit.surname}" name="surname" class="form-control" id="surname">
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" value="${userToEdit.email}" name="email" class="form-control" id="email">
			</div>
			<input type="hidden" name="id" value="${userToEdit.id}">
			<input type="submit" value="Edit Student" class="btn btn-primary" />
		</form>