<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checker Board</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<% int width;%>
<% int height;%>
<% if(request.getParameter("width") == null){
		width=1;
            }
   else{   
		width = Integer.parseInt(request.getParameter("width"));
   }%>
   
<% if(request.getParameter("height") == null){
		height =1;
	}
	else{   
		height = Integer.parseInt(request.getParameter("height"));
	}%>
<h1>Checkerboard: <%=width%>w X <%=height%>w</h1>
<% String block= "first";%>
<% for(int index = 0; index < height; index++) { %>
	<%if(block=="first"){
			block="second";
            }
            else{
            	block="first";
            }%> 
	<%for(int side = 0; side < width; side++) {
		if(block=="first"){
			block="second";
            }
            else{
            	block="first";
            }%>   
		<div class="<%=block%>"></div>
	<% } %>
       <br>
<% } %>
</body>
</html>