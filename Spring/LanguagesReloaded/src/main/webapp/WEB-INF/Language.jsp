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
<title>Language</title>
</head>
<body>
<div id="wrapper">
	<a href = "/">Dashboard</a>
	<h2><c:out value = "${ language.name }"/></h2>
	<h2><c:out value = "${ language.creator }"/></h2>
	<h2><c:out value = "${ language.version }"/></h2>
	<a href ="/languages/edit/<c:out value = '${ language.id }'/>">Edit</a><br>
	<a href ="/languages/delete/<c:out value = '${ language.id }'/>">Delete</a>
</div>
</body>
</html>