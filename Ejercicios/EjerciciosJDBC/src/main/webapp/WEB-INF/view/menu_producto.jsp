<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ProductoModelo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menú Producto</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</head>
<body>
	<main class="container mt-5 w-75 d-block mx-auto">
		<section class="d-flex justify-content-center">
			<div class="d-flex flex-direction-row align-items-center justify-content-between w-75">
				<h1 class="text-center">Menú</h1>
				<a href="LogoutServlet" class="btn btn-danger">Salir</a>
			</div>
		</section>
		<%
			String error = (String)request.getParameter("error");
			if (error != null) {
				out.println("<div class='alert alert-danger text-center'>" + error + "</div>");
			}
		%>
		<form method='post' action='PedidoServlet'>
			<section class="d-flex flex-wrap gap-3 justify-content-center mb-3">
			<%
				List<ProductoModelo> productos = (List<ProductoModelo>)request.getAttribute("productos");
				if (productos != null) {
					for (ProductoModelo producto : productos) {
			%>
				<article class="card p-3" style="width: 200px">
					<div class="d-flex flex-column justify-content-between card-body text-center">
						<img src='<%= producto.getImagenURL() %>' class="card-img-top img-fluid mb-1"></img>
						<input name='name-<%= producto.getId().intValue() %>' value='<%= producto.getNombre() %>' type='hidden'/>
						<input name='price-<%= producto.getId().intValue() %>' value='<%= producto.getPrecio() %>' type='hidden'/>
						<div>
							<p class="card-title fw-bold mb-1"><%= producto.getNombre() %></p>
							<p class="card-text text-muted mb-2"><%= String.format("%.2f €", producto.getPrecio()) %></p>
							<input class="form-control text-center" name='id-<%= producto.getId().intValue() %>' value='0' min='0' type='number'/>
						</div>
					</div>
				</article>
			<%
					}
				}
			%>
			</section>
			<div class="d-flex justify-content-center mb-3">
				<button class="btn btn-primary w-50" type="submit">Confirmar pedido</button>
			</div>
		</form>
	</main>
</body>
</html>