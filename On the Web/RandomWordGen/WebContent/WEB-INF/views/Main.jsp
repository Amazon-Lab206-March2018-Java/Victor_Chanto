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
<form action="" method="post">
	<h2>You have generated a word <c:out value="${count}"/> times</h2>
	<input type="text" name = "word" value='<c:out value="${word}"/>' readonly><br>
	<input type="submit" name="count" value="Click Me">
	<h2>The last time you generated a word was</h2>
	<input type="text" name = "time" value='<c:out value="${time}"/>' readonly>
</form>
</body>
</html>