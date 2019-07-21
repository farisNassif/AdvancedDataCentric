<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final Project</title>
</head>
<body>
	<h1>New Loan</h1>
	<form:form modelAttribute="loans">
		<table>
			<tr>
				<td>Cust ID:</td>
				<td><form:input path="cust.cId" /> <form:errors
						path="cust.cId" /></td>
			</tr>
			<tr>
				<td>Book id:</td>
				<td><form:input path="book.bid" /> <form:errors
						path="book.bid" /></td>
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