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
	<h1><c:out value = '${ dojo.name }'/> Location Ninjas</h1>
	<table id="table">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${ ninjas }" var = "ninja">
			<tr>
				<td><c:out value = '${ ninja.firstName }'/></td>
				<td><c:out value = '${ ninja.lastName }'/></td>
				<td><c:out value = '${ ninja.age }'/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>

