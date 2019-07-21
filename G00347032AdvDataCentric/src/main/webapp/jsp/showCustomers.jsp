<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<meta charset="UTF-8">
<title>ADCWA Project - Show Customers</title>
</head>
<body>
	<h1>List of Customers</h1>

	<c:forEach items="${customers}" var="customer">

		<h3>
			<strong>${customer.cId}</strong>
			<strong>${customer.cName}</strong>
		</h3>

		<p>Loan Period = ${customer.loanPeriod} days</p>

		<p>
			<strong>${customer.cName}'s Loans</strong>
		</p>

		<table>
			<tr>
				<th>Loan ID</th>
				<th>Book ID</th>
				<th>Title</th>
				<th>Author</th>
			</tr>

			<tr>
				<c:forEach items="${customer.loans}" var="loan">
					<tr>
						<td>${loan.lid}</td>
						<td>${loan.book.bid}</td>
						<td>${loan.book.title}</td>
						<td>${loan.book.author}</td>

					</tr>
				</c:forEach>
			</tr>
		</table>
	</c:forEach>


	<a href="/">Home</a>
	<a href="/addBook">Add Book</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showLoans">List Loans</a>
	<a href="/logout">Logout</a>
</body>
</html>