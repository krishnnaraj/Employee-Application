<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<hr>
	
	<div class="container">
		<form action="add-employee-details" method="post">
			<label>Employee Name</label>
			<input type="text" name="empName">
			<br><br>
			
			<label>Email Id</label>
			<input type="email" name="emailId">
			<br><br>
			
			<label>Date Of Birth</label>
			<input type="date" name="dateOfBirth">
			<br><br>
			
			<label>Salary</label>
			<input type="text" name="salary">
			<br><br>
			
			<label>Employee Status :</label>
				<label for="Active">Active</label>
				<input type="radio" name="empStatus" value="Active" id="Active">
				<label for="Inactive">Inactive</label>
				<input type="radio" name="empStatus" value="Inactive" id="Inactive">
			
			<input type="submit" value="Add-Employee">
		</form>
	</div>
</body>
</html>