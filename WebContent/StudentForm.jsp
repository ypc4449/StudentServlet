<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Student Application</title>
</head>
<body>
	<center>
		<h1>Student Management</h1>
        <h2>
        	<a href="new">Add New Student</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="home">List All Students</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${student != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${student == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${student != null}">
            			Edit Book
            		</c:if>
            		<c:if test="${student == null}">
            			Add New Book
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${book != null}">
        			<input type="hidden" name="studentid" value="<c:out value='${student.studentId}' />" />
        		</c:if>            
            <tr>
                <th>FirstName: </th>
                <td>
                	<input type="text" name="firstname" size="45"
                			value="<c:out value='${student.firstname}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>LastName: </th>
                <td>
                	<input type="text" name="lastname" size="45"
                			value="<c:out value='${student.lastname}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>yearLevel: </th>
                <td>
                	<input type="text" name="yearLevel" size="5"
                			value="<c:out value='${student.yearLevel}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>marks: </th>
                <td>
                	<input type="text" name="marks" size="5"
                			value="<c:out value='${student.marks}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
