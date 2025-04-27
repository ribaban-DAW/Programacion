<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cuestionario.Cuestionario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cuestionario cuestionable</title>
<link href="styles.css" rel="stylesheet">
</head>
<body>
	<h1>Cuestionario cuestionable</h1>
	<form method="post" action="CuestionarioServlet">
		<%
			Cuestionario cuestionario = new Cuestionario();
			out.println(cuestionario);
		%>
	</form>
</body>
</html>