<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Numar Vocale</title>
	</head>
	<body> 
		<%
		String str = request.getParameter("text");
		int contor = 0;
		for (int i=0;i<str.length();i++){
			if (str.charAt(i)== 'a'  || str.charAt(i) == 'e'  || str.charAt(i)=='i'  || str.charAt(i)=='o'  || str.charAt(i)=='u')
				contor++;
		}

		%>
		<div>
			Result: <b> <%= contor %> </b>
		</div>
	</body>
</html>