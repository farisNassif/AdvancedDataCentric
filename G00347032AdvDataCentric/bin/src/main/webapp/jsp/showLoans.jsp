<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final Project</title>
</head>
<link rel="stylesheet" href="css/styles.css">
<body>
	<h1>List of Loans</h1>
	<table>
		<tr>
			<th>Loan ID</th>
			<th>Customer ID</th>
			<th>Customer Name</th>
			<th>Book Title</th>
			<th>Author</th>
			<th>Due Date</th>
		</tr>
		<tr>
			<c:forEach items="${loans}" var="loan">
				<tr>
					<td>${loan.lid}</td>
					<td>${loan.cust.cId}</td>
					<td>${loan.cust.cName}</td>
					<td>${loan.book.title}</td>
					<td>${loan.book.author}</td>
					<td>${loan.dueDate}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="/">Home</a>
	<a href="/showBooks">List Books</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/deleteLoan">Delete Loan</a>
	<a href="/logout">Logout</a>
</body>
</html>