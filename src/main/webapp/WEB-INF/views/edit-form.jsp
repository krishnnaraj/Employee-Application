<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${employee.getClass().getSimpleName().equals(\"string\") }">
		<h2>${employee }</h2>
		</c:when>
		<c:when test="${employee.getClass().getSimpleName().equals(\"EmployeeDto\") }">
			<div class="container">
				<form action="/employee-app/update-employee" method="post">
					
					<label>Employee Id</label>
					<input type="text" name="empId" value="${employee.empId}" readonly="readonly">
					<br><br>
					
					<label>Employee Name</label>
					<input type="text" name="empName" value="${employee.empName}">
					<br><br>
			
					<label>Email Id</label>
					<input type="email" name="emailId" value="${employee.emailId}">
					<br><br>
			
					<label>Date Of Birth</label>
					<input type="date" name="dateOfBirth" value="${employee.dateOfBirth}">
					<br><br>
			
					<label>Salary</label>
					<input type="text" name="salary" value="${employee.salary}">
					<br><br>
			
					<label>Employee Status :</label>
					<c:choose>
						<c:when test="${employee.empStatus.equals(\"Active\")}">
							<label for="Active">Active</label>
							<input type="radio" name="empStatus" value="Active" id="Active" checked="checked">
							<label for="Inactive">Inactive</label>
							<input type="radio" name="empStatus" value="Inactive" id="Inactive" checked="checked">
						</c:when>
						<c:when test="${employee.empStatus.equals(\"Inactive\")}">
							<label for="Active">Active</label>
							<input type="radio" name="empStatus" value="Active" id="Active" checked="checked">
							<label for="Inactive">Inactive</label>
							<input type="radio" name="empStatus" value="Inactive" id="Inactive" checked="checked">
						</c:when>
					<c:otherwise>
						<label for="Active">Active</label>
						<input type="radio" name="empStatus" value="Active" id="Active" checked="checked">
						<label for="Inactive">Inactive</label>
						<input type="radio" name="empStatus" value="Inactive" id="Inactive" checked="checked">
					</c:otherwise>
					</c:choose>
					<br><br>
					<input type="submit" value="Update">
		</form>
			</div>
		</c:when>
	</c:choose>
</body>
</html>