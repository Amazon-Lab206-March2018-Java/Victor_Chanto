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
	<h1>Question goes here</h1>
	<h2>Tags go here</h2>
		<table id="table">
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Answers go here</td>
			</tr>
		</tbody>
	</table>
	<h2>Add your answer</h2>
	<form:form method="POST" action="" modelAttribute="">

		<form:label path="answser">Answer:
	    <form:input path="answser"/></form:label>
	    <form:errors path="answser"/>
	    
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>