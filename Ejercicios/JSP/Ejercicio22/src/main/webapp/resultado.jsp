<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pedido.Pedido"%>
<%@ page import="pedido.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="styles.css" rel="stylesheet">
</head>
<body>
	<h1>Aquí tiene su pedido</h1>
	<table>
		<thead>
			<tr>
				<th scope="col">Producto</th>
				<th scope="col">PVP</th>
				<th scope="col">Cantidad</th>
				<th scope="col">Subtotal</th>
			</tr>
		</thead>
		<tbody>
			<%
				Pedido pedido = new Pedido();
				double precioTotal = 0;
				for (int id = 1; ; ++id) {
					String cantidadString = request.getParameter("producto-" + id);
					if (cantidadString == null) {
						break;
					}
					int cantidad = Integer.parseInt(cantidadString);
					Producto producto = pedido.getProducto(id);
					double subtotal = producto.getPrecio() * cantidad;
					precioTotal += subtotal;
					
					out.println("<tr>");
					out.println("<td scope='row'>" + producto.getNombre() + "</td>");
					out.println("<td scope='row'>" + String.format("%.2f €", producto.getPrecio()) + "</td>");
					out.println("<td scope='row'>" + cantidad + "</td>");
					out.println("<td scope='row'>" + String.format("%.2f €", subtotal) + "</td>");
					out.println("</tr>");
				}
			%>
		</tbody>
		<tfoot>
			<tr>
			<%
				out.println("<th scope='row'>Total " + String.format("%.2f €", precioTotal) + "</td>");
			%>
			</tr>
		</tfoot>
	</table>
	<p><a href="index.jsp">Hacer otro pedido</a></p>
</body>
</html>