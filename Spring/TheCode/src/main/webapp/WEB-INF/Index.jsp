<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
       <%@include file="css/skeleton.css" %>
       <%@include file="css/normalize.css" %>
       <%@include file="css/style.css" %>
</style>
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<p id="error"><c:out value = "${ errors }"/></p>
	<p>What is the code?</p>
	<form action="/errors">
		<input type="text" name="Code"><br>
		<input type="submit" value="Submit">
	</form>
</div>
</body>
</html>