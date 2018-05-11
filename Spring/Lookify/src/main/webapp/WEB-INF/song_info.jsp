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
	<a href = "/dashboard"> Dashboard </a>
	<h1>Title : <c:out value = "${ song.title }"/></h1>
	<h1>Artist : <c:out value = "${ song.artist }"/></h1>
	<h1>Rating (1-10) : <c:out value = "${ song.rating }"/></h1>
	<a href ="/songs/delete/<c:out value = '${ song.id }'/>">Delete</a>
</div>
</body>
</html>