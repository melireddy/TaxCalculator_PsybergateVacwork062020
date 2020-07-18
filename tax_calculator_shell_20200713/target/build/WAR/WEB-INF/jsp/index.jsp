<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
	<title>Tax Calculator - Psybergate Pty Ltd</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
	<h1>Welcome: Tax Calculator</h1>
	<hr/>
	<h3>Brought to you by: Psybergate Vacation Work June 2020</h3>
	<hr/>
	<ul>
	<li><a href="person/register">Click here</a> to enter your details.</li>
	</ul>
	
	<table>
		<tr>
			<th>Tax Number</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Date Of Birth</th>
		</tr>
		<c:forEach var="person" items="${people}">
			<tr>
				<td>${person.taxNumber}</td>
				<td>${person.name}</td>
				<td>${person.surname}</td>
				<td>${person.dateOfBirth}</td>
				<td><a href="tax/view?taxNumber=${person.taxNumber}">Capture Tax Return</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>