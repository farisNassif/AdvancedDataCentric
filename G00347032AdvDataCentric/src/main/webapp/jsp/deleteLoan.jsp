<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADCWA Project - Delete a Loan</title>
</head>
<body>
	<h1>Delete Loan</h1>
<body>
	<form:form modelAttribute="loans">
		<table>
			<tr>
				<td>Loan ID:</td>
				<td><form:input path="lid" /> <form:errors path="lid" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/">Home</a>
	<a href="/unloanedBooks">Unloaned Books</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/deleteLoan">Delete Loan</a>
	<a href="/logout">Logout</a>
</body>
</html>