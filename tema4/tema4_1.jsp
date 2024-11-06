<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<title>Suma</title>
	</head>
	<body> 
		
		<div>
			Result: <b> <%= Integer.valueOf(request.getParameter("nr1")) + Integer.valueOf(request.getParameter("nr2"))%> </b>
		</div>
	</body>
</html>