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
<title>Edit</title>
</head>
<body>
<div id="wrapper">
	<form:form method="POST" action="/languages/edit/${ index }" modelAttribute="language">
		<form:label path="name">Name
	    <form:input path="name" value="${ language.name }"/>
	    <form:errors path="name"/></form:label>
	    
	    <form:label path="creator">Creator
	    <form:input path="creator" value="${ language.creator }" />
	    <form:errors path="creator"/></form:label>
	    
	    <form:label path="version">Version
	    <form:input type= "number" path="version" value="${ language.version }"/>
	    <form:errors path="version"/></form:label>
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>