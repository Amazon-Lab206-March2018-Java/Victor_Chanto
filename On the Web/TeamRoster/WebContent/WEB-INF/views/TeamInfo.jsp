<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Players</h2> 
<a href = "Players">New Player</a>

<table>
	<thead>
		<tr>
			<th>First name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<c:forEach var="player" items="${team_Players}">
			<tr>
		    	<td><c:out value="${player.getFirstName()}"/></td>
		    	<td><c:out value="${player.getLastName()}"/></td>
		    	<td><c:out value="${player.getAge()}"/></td>
		    	<td><a href="/TeamRoster/DeletePlayer?id=<c:out value="${teams_saved.indexOf(team)}"/>">Delete</a></td>
	    	</tr>
		</c:forEach>
		</tr>
	</tbody>
</table>
</body>
</html>