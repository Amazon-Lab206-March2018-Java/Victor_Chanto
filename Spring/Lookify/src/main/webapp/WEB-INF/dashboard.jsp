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
	<a href = "/songs/new"> Add New </a><br>
	<a href = "/search/topTen"> Top Songs </a>	
	<form method = "POST" action="/search/">
	    <input type="text" name="artist">
	    <input type="submit" value="New Search"/>
	</form>
	<table id="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${ songs }" var = "song">
				<tr>
					<td><a href = "/songs/<c:out value = '${ song.id }'/>"><c:out value = "${ song.title }"/></a></td>
					<td><c:out value = "${ song.rating }"/></td>
					<td><a href ="/songs/delete/<c:out value = '${ song.id }'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>