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
	<h1>What is your question?</h1>
	<form:form method="POST" action="/questions/new" modelAttribute="newquestion">
		<form:label path="question"> Question<br>
	    <form:input path="question"/></form:label>
	    <form:errors path="question"/><br>
	    
   		<form:label path="tags"> Tags<br>
	    <form:input path="tags"/></form:label>
	    <form:errors path="tags"/><br>
	    
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>