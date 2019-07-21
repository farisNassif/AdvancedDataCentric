<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADCWA Project - Loan Error</title>
</head>
<body>
	<h1>Could not create New Loan</h1>
<body>
	<h2>${error.message}</h2>
</body>

<a href="/">Home</a>
<a href="/showBooks">List Books</a>
<a href="/showCustomers">List Customers</a>
<a href="/showLoans">List Loans</a>
<a href="/newLoan">New Loan</a>

</body>
</html>