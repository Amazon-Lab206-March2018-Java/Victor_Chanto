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
	<h1>Top Ten Songs : </h1>
	<a href = "/dashboard"> Dashboard </a>
	<table id="table">
		<tbody>
		
			<c:forEach items = "${ songs }" var = "song" varStatus="loop">
				<tr>
					<td><c:out value = "${ loop.index+1 }"/></td>
					<td><a href = "/songs/<c:out value = '${ song.id }'/>"><c:out value = "${ song.title }"/></a></td>
					<td><a href = "/songs/<c:out value = '${ song.id }'/>"><c:out value = "${ song.artist }"/></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
</body>
</html>