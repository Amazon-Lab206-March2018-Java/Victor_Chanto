<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        
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
<div class="container">
	<div class="row" id="center_t">
	    <h1>Welcome Page <c:out value="${currentUser.firstName}"></c:out></h1>
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
	    <c:choose>
		    <c:when test = "${currentUser.getRoles().contains(admin_role)}">
	     		<a href ='/admin'>Admin link</a>
	     	</c:when>
     	</c:choose>
    </div>
    <div class="row" id="center_border">
    	<p>First Name : ${currentUser.firstName} </p>
    	<p>Last Name : ${currentUser.lastName} </p>
    	<p>Email : ${currentUser.email} </p>
    	<p>Sign up Date : <fmt:formatDate pattern="MM/dd/yyyy" value="${currentUser.createdAt}"/></p>
    	<p>Last Sign in : <fmt:formatDate pattern="MM/dd/yyyy" value="${currentUser.last_Login}"/></p>
    </div>
</div>
</body>
</html>