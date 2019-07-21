<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/errors.css">
<meta charset="UTF-8">
<title>ADCWA Project - New Loan</title>
</head>
<body>
	<h1>New Loan</h1>
	<form:form modelAttribute="loans">
		<table>
			<tr>
				<td>Customer ID:</td>
				<td><form:input path="cust.cId" /> <form:errors
						path="cust.cId" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book ID:</td>
				<td><form:input path="book.bid" /> <form:errors
						path="book.bid" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Loan Book!" /></td>
			</tr>
		</table>
	</form:form>

	<a href="/">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>

</body>
</html>