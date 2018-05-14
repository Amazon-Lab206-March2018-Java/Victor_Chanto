<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
       <%@include file="css/style.css" %>
       <%@include file="css/skeleton.css" %>
       <%@include file="css/normalize.css" %>
</style>
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<h1>New Product</h1>
	<a href ="/">Dashboard</a>
	<form:form method="POST" action="/products/new" modelAttribute="product">

		<form:label path="name">Name
	    <form:input path="name"/></form:label>
	    <form:errors path="name"/>
	    
	    <form:label path="description">Description
	    <form:input path="description"/></form:label>
	    <form:errors path="description"/>
	    
	    <form:label path="price">Price
	    <form:input path="price"/></form:label>
	    <form:errors path="price"/>	 
	    
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>