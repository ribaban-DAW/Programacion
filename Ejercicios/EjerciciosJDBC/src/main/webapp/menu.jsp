<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú</title>
</head>
<body>
<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("403.jsp");
		return;
	}
%>
<h1>Menú</h1>
</body>
</html>