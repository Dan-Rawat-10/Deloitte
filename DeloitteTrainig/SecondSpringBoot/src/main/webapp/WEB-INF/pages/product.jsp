<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Product Form</h2>
<form:form modelattribut = "product">
Product Id : <form:input path = "productId" name = "productId"/>
Product Name : <form:input path = "productName" name = "productName"/>
Product Quantity : <form:input path = "quantity" name = "quantity"/>
Product Price : <form:input path = "price" name = "price"/>
<input type = "submit" value = "Save">
</form:form>
</body>
</html>