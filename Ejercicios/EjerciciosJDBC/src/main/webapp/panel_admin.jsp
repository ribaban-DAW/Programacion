<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioModelo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel Admin</title>
</head>
<body>
<%
	UsuarioModelo usuario = (UsuarioModelo)session.getAttribute("user");
	if (usuario == null || !usuario.getRol().equals("admin")) {
		response.sendRedirect("403.jsp");
		return;
	}
%>
<h1>Panel Admin</h1>
</body>
</html>