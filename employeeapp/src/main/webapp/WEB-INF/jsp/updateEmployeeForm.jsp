<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body bgcolor="cyan">

<form:form action="/employeeapp/updateEmployee" method="post" modelAttribute="employee">
	<form:label path="employeeId">Employee Id:</form:label>
	<form:input path="employeeId" readonly="readonly"/><br>
	
	<form:label path="employeeName">Employee Name:</form:label>
	<form:input path="employeeName"/><br>
	
	<form:label path="employeeDepartment">Employee Department:</form:label>
	<form:input path="employeeDepartment"/><br>
	
	<form:label path="employeeSalary">Employee Salary:</form:label>
	<form:input path="employeeSalary"/><br>
	
	<input type="submit" value="Update Employee"/>
</form:form>

</body>
</html>