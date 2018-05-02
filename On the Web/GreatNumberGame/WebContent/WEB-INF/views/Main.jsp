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
	<h1>Welcome to the Great Number Game!</h1>
	<h2>I am thinking of a number between 1 and 100</h2>
	<h2>Take a guess</h2>
	<c:choose>
         <c:when test = "${guess == -1}">
         	<h2>You have guessed too low</h2>
         	<form action="NumberGame" method="POST">
	            <input type="text" name = "number"><br>
				<input type="submit" value="Submit">
			</form>
         </c:when>
         
         <c:when test = "${guess == 1}">
         	<h2>You have guessed too high</h2>
         	<form action="NumberGame" method="POST">
	            <input type="text" name = "number"><br>
				<input type="submit" value="Submit">
			</form>
         </c:when>
         
         <c:when test = "${guess == 0}">
         	<h2>You have guessed, the number was <c:out value="${number}"/></h2>
         	<form action="PlayAgain" method="POST">
				<input type="submit" value="Try Again">
			</form>
         </c:when>
         
         <c:otherwise>
         	<form action="NumberGame" method="POST">
	            <input type="text" name = "number"><br>
				<input type="submit" value="Submit">
			</form>
         </c:otherwise>
      </c:choose>

</body>
</html>