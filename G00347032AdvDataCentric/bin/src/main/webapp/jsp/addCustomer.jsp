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
<h1>Add New Customer</h1>
<body>
 <form:form modelAttribute="customers">
  <table>
    <tr>
      <td>Cust Name:</td>
      <td>
      <form:input path="cName"/>
      <form:errors path="cName"/>
      </td>
    </tr>
    <tr>
      <td>Loan Period(days):</td>
      <td>
      <form:input path="loanPeriod"/>
       <form:errors path="loanPeriod"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add"/>
      </td>
    </tr>
  </table>
</form:form>
<tr>
	    <td><a href="/">Home</a></td>
	    <td><a href="/addBook">Add Book</a></td>
	    <td><a href="/addCustomer">Add Customers</a></td>
	    <td><a href="/newLoan">New Loan</a></td>
	  </tr>
</body>
</body>
</html>