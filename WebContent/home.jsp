<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<div align="center">
<h1>Students Data</h1>
<h3>
            <a href="new">ADD NEW STUDENT</a>
            
        </h3>



<table border="1">
	
	<th>First name</th>
	<th>Last name</th>
	<th>Year level</th>
	<th>Marks</th>
	<th>Action</th>
	
	<c:forEach items="${studentList}" var="student">
		<tr>
			
			<td>${student.firstname}</td>
			<td>${student.lastname}</td>
			<td>${student.yearLevel}</td>
			<td>${student.marks}</td>
			<td><a href="edit?studentid=${student.studentId}">Edit</a>
                             
                       <a 
                       href="delete?studentid=${student.studentId}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>