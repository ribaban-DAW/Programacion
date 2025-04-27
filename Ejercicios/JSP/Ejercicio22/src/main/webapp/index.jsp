<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pedido.Pedido"%>
<%@ page import="pedido.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedidos</title>
<link href="styles.css" rel="stylesheet">
</head>
<body>
	<h1>Pedidos</h1>
	<%
		Pedido p = new Pedido();
		out.println("<form method='post' action='resultado.jsp'>");
		out.println("<section>");
		for (Producto producto : p.getProductos()) {
			out.println("<article>");
			out.println("<img src='" + producto.getImagenURL() + "'></img>");
			out.println("<p>" + producto.getNombre() + "</p>");
			out.println(String.format("<p>%.2f €</p>", producto.getPrecio()));
			out.println("<input name='producto-" + producto.getId() + "' type='number' min=0 value='0'>");
			out.println("</article>");
		}
		out.println("</section>");
		out.println("<button type='submit'>Confirmar pedido</button>");
		out.println("</form>");
	%>
</body>
</html>
