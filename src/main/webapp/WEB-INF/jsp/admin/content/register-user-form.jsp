<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Register Student</h3>
		<form action="/QuizSystem/jsp/user/register" method="post"
			class="form-horizontal">
			<div class="form-group">
				<label for="name">First Name:</label>
				<input type="text" name="name" class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="surname">Last Name:</label>
				<input type="text" name="surname" class="form-control" id="surname">
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" name="email" class="form-control" id="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" name="password" class="form-control"
					id="password">
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password:</label>
				<input type="password" name="confirmPassword" class="form-control"
					id="confirmPassword">
			</div>
			<input type="submit" value="Register Student" class="btn btn-primary" />
		</form>