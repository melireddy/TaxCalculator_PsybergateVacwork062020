<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.text.NumberFormat" %>
<%@page %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Tax Information - Psybergate Pty. Ltd.</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <% String taxNumber = request.getParameter("taxNumber");%>
    <%NumberFormat nf = NumberFormat.getCurrencyInstance(); %>
	<h1>Person Tax Information: </h1>
	<input type="hidden" name="taxNumber" value=<%=taxNumber%>/>
	<hr />
	<h4><a href="/taxcalc/">Back to home</a></h4>
	<fmt:formatNumber type="number" maxFractionDigits="2" value="${emp.salary}" />
	<hr />
	<ul>
		<li>Tax year: ${taxyear}</li>
		<li>Total Income: R${totalIncome}</li>
		<li>Total Expenses: R${totalExpenses} </li>
		<li>Taxable Income: R${taxableIncome} </li>
		<li>Tax Payable: R${taxPayable} </li>
	</ul>
</body>
</html>