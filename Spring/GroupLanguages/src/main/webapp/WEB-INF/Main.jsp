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
<title>Languages</title>
</head>
<body>
<div id="wrapper">
	<table id="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${languages }" var = "language">
				<tr>
					<td><a href = "/languages/<c:out value = '${ languages.indexOf(language) }'/>"> <c:out value= "${ language.name }" /></a></td>
					<td><c:out value = "${ language.creator }"/></td>
					<td><c:out value = "${ language.version }"/></td>
					<td><a href ="/languages/delete/<c:out value = '${ languages.indexOf(language) }'/>">Delete</a> <a href ="/languages/edit/<c:out value = '${ languages.indexOf(language) }'/>">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table><br>
	<form:form method="POST" action="/languages/add" modelAttribute="language">
		<form:label path="name">Name
	    <form:input path="name"/></form:label>
	    <form:errors path="name"/>
	    
	    <form:label path="creator">Creator
	    <form:input path="creator"/></form:label>
	    <form:errors path="creator"/>
	    
	    <form:label path="version">Version
	    <form:input type= "number" path="version"/></form:label>
	    <form:errors path="version"/><br>
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>