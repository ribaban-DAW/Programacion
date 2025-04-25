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
	Hola
	<%
		Pedido p = new Pedido();
		int id = 1;
		p.addProductos(new Producto(id++, "Quinoa con verdura", 6.95));
		p.addProductos(new Producto(id++, "Pizza caprese", 5.50));
		p.addProductos(new Producto(id++, "Pasta al pesto", 4.90));
		p.addProductos(new Producto(id++, "Hamburguesa vegetariana", 6.20));
		p.addProductos(new Producto(id++, "Agua", 1));
		p.addProductos(new Producto(id++, "Cerveza", 1.50));
		p.addProductos(new Producto(id++, "Refresco", 1.40));
		out.println("<section>");
		for (Producto producto : p.getProductos()) {
			out.println("<article>");
			out.println("<p>" + producto.getNombre() + "</p>");
			out.println(String.format("<p>%.2f €</p>", producto.getPrecio()));
			out.println("<img src='" + producto.getImagenURL() + "'></img>");
			out.println("</article>");
		}
		out.println("</section>");
	%>
</body>
</html>
