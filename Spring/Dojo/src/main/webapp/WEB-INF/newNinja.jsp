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
	<h1>New Ninja</h1>
	<a href ="/">Dashboard</a>
	<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
		<form:select type="Dojo"  path="Dojo">  
		   <c:forEach var="dojo" items="${listDojos}">
		       <option value="${dojo.id}">${ dojo.name }</option>   
		   </c:forEach>
		</form:select>
	    
	    <form:label path="firstName">First Name
	    <form:input path="firstName"/></form:label>
	    <form:errors path="firstName"/>
	    
	    <form:label path="lastName">Last Name
	    <form:input path="lastName"/></form:label>
	    <form:errors path="lastName"/>
	    
	    <form:label path="age">Age
	    <form:input type = "number" path="age"/></form:label>
	    <form:errors path="age"/>	    
	    
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>
