<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.PedidoModelo" %>
<%@ page import="model.PedidoProductoModelo" %>
<%@ page import="model.UsuarioModelo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú Pedido</title>
</head>
<body>
	<%
		PedidoModelo pedido = (PedidoModelo)request.getAttribute("pedido");
		double precioTotal = 0;
		if (pedido != null) {
			UsuarioModelo usuario = pedido.getUsuario();
	%>
	<h1>Pedido de <%= usuario.getNombre() %></h1>
	<table>
		<thead>
			<tr>
				<th scope='col'>Nombre</th>
				<th scope='col'>Precio</th>
				<th scope='col'>Cantidad</th>
				<th scope='col'>Subtotal</th>
			</tr>
		</thead>
		<tbody>
		<%
			for (int i = 0; i < pedido.getPedidoProductos().size(); ++i) {
				PedidoProductoModelo pedidoProducto = pedido.getPedidoProductos().get(i);
				if (pedidoProducto.getCantidad() == 0) {
					continue;
				}
				precioTotal += pedidoProducto.calcularSubtotal();
		%>
			<tr>
				<td><%= pedidoProducto.getProducto().getNombre() %></td>
				<td><%= String.format("%.2f", pedidoProducto.getProducto().getPrecio()) %> €</td>
				<td><%= pedidoProducto.getCantidad() %></td>
				<td><%= String.format("%.2f", pedidoProducto.calcularSubtotal()) %> €</td>
			</tr>
		<%
				}
			}
		%>
		</tbody>
		<tfoot>
			<tr>
				<th scope='row' colspan='3'>Total</th>
				<td><%= String.format("%.2f", precioTotal) %> €</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>