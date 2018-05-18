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
	<h1><c:out value="${ques.question}"/></h1>
	<h4>Tags: </h4>
	<c:forEach items = "${ tags }" var = "tag">
		<td><p id="p"><c:out value="${tag.subject}"/></p></td>
	</c:forEach>
		<table id="table">
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="answer" items="${ques.getAnswers()}">
				<tr>
					<td><c:out value="${answer.getAnswer()}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add your answer</h2>
	<form:form method="POST" action="/answer/add/${ ques.id }" modelAttribute="Answer">
	
		<form:label path="answer">Answer:
	    <form:input path="answer"/></form:label>
	    <form:errors path="answer"/><br>
	  
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>