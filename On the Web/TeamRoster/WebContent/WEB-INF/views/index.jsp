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
<h2>Prototype Roster</h2> 
<a href = "Teams">New Team</a>

<table>
	<thead>
		<tr>
			<th>Team</th>
			<th>Players</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<c:forEach var="team" items="${teams_saved}">
			<tr>
		    	<td><c:out value="${team.getName()}"/></td>
		    	<td><c:out value="${team.getPlayers().size()}"/></td>
		    	<td><a href="/TeamRoster/Teams?id=<c:out value="${teams_saved.indexOf(team)}"/>">Details</a>  <a href="/TeamRoster/DeleteTeam?id=<c:out value="${teams_saved.indexOf(team)}"/>">Delete</a></td>
	    	</tr>
		</c:forEach>
		</tr>
	</tbody>
</table>
</body>
</html>