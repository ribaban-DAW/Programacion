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
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</head>
<body>
	<%
		PedidoModelo pedido = (PedidoModelo)request.getAttribute("pedido");
		double precioTotal = 0;
		if (pedido != null) {
			UsuarioModelo usuario = pedido.getUsuario();
	%>
	<main class="container mt-5 w-50 d-block mx-auto">
		<h1 class="text-center">Pedido de <%= usuario.getNombre() %></h1>
		<table class="table">
			<thead>
				<tr>
					<th scope='col'>Nombre</th>
					<th class="text-end" scope='col'>Precio</th>
					<th class="text-end" scope='col'>Cantidad</th>
					<th class="text-end" scope='col'>Subtotal</th>
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
					<td class="text-end"><%= String.format("%.2f", pedidoProducto.getProducto().getPrecio()) %> €</td>
					<td class="text-end"><%= pedidoProducto.getCantidad() %></td>
					<td class="text-end"><%= String.format("%.2f", pedidoProducto.calcularSubtotal()) %> €</td>
				</tr>
			<%
					}
				}
			%>
			</tbody>
			<tfoot>
				<tr>
					<th scope='row' colspan='3'>Total</th>
					<td class="text-end fw-bold"><%= String.format("%.2f", precioTotal) %> €</td>
				</tr>
			</tfoot>
		</table>
		<div class="d-flex justify-content-center mb-3">
			<a href="MenuProductoServlet" class="btn btn-primary w-75">Volver a pedir</a>
		</div>
	</main>
</body>
</html>