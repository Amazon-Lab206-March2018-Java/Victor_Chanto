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
	<a href ="/">Dashboard</a>
	<h1><c:out value = "${ category.getName() }"/></h1>
	<h2>Products</h2>
	<ul>
		<c:forEach var="product" items="${products}">
	       <option value="${product.id}">${ product.name }</option>   
	   </c:forEach>
	</ul>
	<form method="POST" action="/categories/<c:out value = "${ category.getId() }"/>/add">
		Add Category:
		<select name="product">  
		   <c:forEach var="product" items="${Notproducts}">
		       <option value="${product.id}">${ product.name }</option>   
		   </c:forEach>
		</select>
	    <input type="submit" value="Add"/>
	</form>
</div>
</body>
</html>