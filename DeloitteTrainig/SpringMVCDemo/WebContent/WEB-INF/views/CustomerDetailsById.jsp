<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<h1>Search Customer</h1>
	<f:form action = "addCustomer.do">
	CustomerId : <f:input path = "customerId" type = "text" name = "customerId" id = "customerId"></f:input><br>
	CustomerName : <f:input path = "customerName" type = "text" name = "customerName" id = "customerName"></f:input><br>
	CustomerAddress : <f:input path = "customerAddress" type = "text" name = "customerAddress" id = "customerAddress"></f:input><br>
	BillAmount : <f:input path = "billAmount" type = "text" name = "billAmount" id = "billAmount"></f:input>
	<input type = "submit" value = "Press enter">
	</f:form>
</body>
</html>