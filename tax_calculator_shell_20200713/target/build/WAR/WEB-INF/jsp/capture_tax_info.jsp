<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>Tax Information - Psybergate Pty Ltd</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
	.input {
		border-radius: 6px;
		background-color: black;
		color: white;
		padding : 5px;
		width : 15%;
	}

	.button{
		color: white;
		background-color: green;
		border-radius: 5px;
		width : 10%;
		padding: 5px;

	}
</style>
	</head>

	<body>
	<% String taxNumber = request.getParameter("taxNumber");%>
		<h1>Enter Your Tax Information Below</h1>
		<br>
        <label>Tax Number: <%=taxNumber%> </label>
        <br/>
		<hr/>
		<form action="calculate" method="post">
            <input type="hidden" name="taxNumber" value=<%=taxNumber%>/>
            <br/>
			<label>Tax Year: </label>
			<input type="number" name="taxyear" autofocus="autofocus" required="required" placeholder="2020" class="input"/>
			<br/>
			<br/>
			<label>Annual Salary: </label>
			<input type="number" name="salary" required="required" placeholder="0.00" class="input"/>
			<br/>
			<br/>
			<label>Retirement Contributions (Total): </label>
			<input type="number" name="retirement" required="required" placeholder="0.00" class="input"/>
			<br/>
			<br/>
			<label>Interest Income: </label>
			<input type="number" name="interest" required="required" placeholder="0.00" class="input"/>
			<br/>
			<br/>
			<label>Travel Allowance: </label>
			<input type="number" name="allowance" required="required" placeholder="0.00" class="input"/>
			<br/>
			<br/>

			<hr/>
			<input type="submit" value="Calculate Tax" class="button"/>
		</form>
	</body>
</html>