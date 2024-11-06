<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<title>Par Impar</title>
	</head>
	<body> 
		<%
		String result;
		if(Integer.valueOf(request.getParameter("nr1"))%2==0)
			result = "par";
		else
			result = "impar";

		%>
		<div>
			Result: <b> <%= result %> </b>
		</div>
	</body>
</html>