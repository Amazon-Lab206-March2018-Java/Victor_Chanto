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
	<form:form method="POST" action="/songs/new" modelAttribute="song">
		<form:label path="title">Title
	    <form:input path="title"/></form:label>
	    <form:errors path="title"/>
	    
	    <form:label path="artist">Artist
	    <form:input path="artist"/></form:label>
	    <form:errors path="artist"/>
	    
	    <form:label path="rating">Rating
	    <form:input type= "number" path="rating"/></form:label>
	    <form:errors path="rating"/><br>
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>