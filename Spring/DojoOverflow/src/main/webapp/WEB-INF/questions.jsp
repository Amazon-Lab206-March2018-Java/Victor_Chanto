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
	<h1>Questions Dashboard</h1>
	<table id="table">
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${ questions }" var = "question">
			<tr>
				<td><a href ="/questions/<c:out value = '${ question.id }'/>"><c:out value = '${ question.question }'/></a></td>
				<td><c:forEach items = "${ question.tags }" var = "tags">
					<c:out value="${tags.subject}"/>
				</c:forEach></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href ="/questions/new">New Question</a>
</div>
</body>
</html>