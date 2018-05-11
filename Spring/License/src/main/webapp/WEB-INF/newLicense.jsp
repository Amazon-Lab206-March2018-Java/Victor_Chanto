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
	<h1>New License</h1>
	<a href ="/">Dashboard</a>
	<form:form method="POST" action="/licenses/new" modelAttribute="license">
		<form:select type="person"  path="person">  
		   <c:forEach var="person" items="${listPeople}">
		       <option value="${person.id}">${ person.firstName } ${ person.lastName }</option>   
		   </c:forEach>
		</form:select>
	    
	    <form:label path="state">State
	    <form:input path="state"/></form:label>
	    <form:errors path="state"/>
	    
	    <form:label path="expiration_date">Date
	    <form:input type="date" path="expiration_date"/></form:label>
	    <form:errors path="expiration_date"/>
	    
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>
