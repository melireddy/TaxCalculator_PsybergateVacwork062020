<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Customer Information - Psybergate Pty. Ltd.</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
	<h1>Customer Information: ${name}</h1>
	<hr />
	<h4><a href="/taxcalc/">Back to home</a></h4>
	<hr />
	<ul>
		<li>Tax Number: ${taxNumber}</li>
		<li>Name: ${name}</li>
		<li>Surname: ${surname} </li>
		<li>Date Of Birth: ${dateOfBirth} </li>
	</ul>
</body>
</html>