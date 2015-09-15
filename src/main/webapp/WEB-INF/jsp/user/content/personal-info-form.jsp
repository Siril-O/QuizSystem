<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Personal Information</h3>
<form>
	<table class="table table-hover">
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="name" value="${user.name}"
					class="form-control" readonly></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="surname" value="${user.surname}"
					class="form-control" readonly></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email" value="${user.email}"
					class="form-control" readonly></td>
		</tr>
		<tr>
			<td>Role:</td>
			<td><input type="text" name="role" value="${user.role}"
					class="form-control" readonly></td>
		</tr>
	</table>
</form>