<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	
	
	<%-- <c:choose>
		<c:when test="${msg.getClass().getSimpleName().equals(\"String\") }">
		<h2>${ msg }</h2>
		</c:when> --%>
		 <table border="1" align ="center">
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Email-Id</th>
					<th>Date Of Birth</th>
					<th>Age</th>
					<th>Salary</th>
					<th>Status</th>
					<th colspan="2">Action</th>
				</tr>
				<c:forEach var="allEmployee" items="${msg}"> 
					<tr>
						<td>${allEmployee.empId}</td>
						<td>${allEmployee.empName}</td>
						<td>${allEmployee.emailId}</td>
						<td>${allEmployee.dateOfBirth}</td>
						<td>${allEmployee.age}</td>
						<td>${allEmployee.salary}</td>
						<td>${allEmployee.empStatus}</td>
						<td><a href='./edit?empId=${allEmployee.empId}'>Edit</a></td>
						<td><a href='./delete/${allEmployee.empId}'>Delete</a></td>
					</tr>
				</c:forEach>
		</table>
<%-- </c:choose> 
 --%>	
</body>
</html>