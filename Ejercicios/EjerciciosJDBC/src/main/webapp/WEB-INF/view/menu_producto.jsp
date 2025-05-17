<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ProductoModelo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú Producto</title>
</head>
<body>
	<h1>Menú</h1>
	<%
		String error = (String)request.getParameter("error");
		if (error != null) {
			out.println("<p>" + error + "</p>");
		}
	%>
	<form method='post' action='PedidoServlet'>
		<section>
		<%
			List<ProductoModelo> productos = (List<ProductoModelo>)request.getAttribute("productos");
			if (productos != null) {
				for (ProductoModelo producto : productos) {
		%>
			<article>
				<img src='<%= producto.getImagenURL() %>'></img>
				<p><%= producto.getNombre() %></p>
				<p><%= String.format("%.2f", producto.getPrecio()) %></p>
				<input name='name-<%= producto.getId().intValue() %>' value='<%= producto.getNombre() %>' type='hidden'/>
				<input name='price-<%= producto.getId().intValue() %>' value='<%= producto.getPrecio() %>' type='hidden'/>
				<input name='id-<%= producto.getId().intValue() %>' value='0' min='0' type='number'/>
			</article>
		<%
				}
			}
		%>
		</section>
		<button type="submit">Confirmar pedido</button>
	</form>
</body>
</html>