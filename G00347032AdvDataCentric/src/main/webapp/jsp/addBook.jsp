<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/errors.css">
<meta charset="UTF-8">
<title>ADCWA Project - Add a Book</title>
</head>
<body>
	<h1>Add New Book</h1>
<body>
	<form:form modelAttribute="books">
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /> <form:errors path="title"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author" /> <form:errors path="author"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
			<tr>

			</tr>
		</table>
	</form:form>
	<a href="/">Home</a>
	<a href="/addBook">Add Book</a>
	<a href="/addCustomer">Add Customers</a>
	<a href="/newLoan">New Loan</a>
</body>
</body>
</html>