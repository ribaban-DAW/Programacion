<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioModelo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Panel Admin</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
	
	<link href="css/extend.css" rel="stylesheet">
</head>
<body>
	<main class="container mt-5 w-50 d-block mx-auto">
		<section class="d-flex flex-direction-row align-items-center justify-content-between mb-3">
			<h1>Panel Admin</h1>
			<a href="LogoutServlet" class="btn btn-danger">Cerrar Sesión</a>
		</section>
		<%
			UsuarioModelo user = (UsuarioModelo)session.getAttribute("user");
			if (user != null) {			
				out.println("<h2 class='mb-4'>👋 Hola " + user.getNombre() + " 👋</h2>");
			}
			String error = (String)request.getAttribute("error");
			if (error != null) {
				out.println("<div class='alert alert-danger text-center'>" + error + "</div>");
			}
		%>
		<section>
			<h2>Usuarios</h2>
			<form method='post' action='UsuarioServlet'>
				<button class="btn btn-primary w-100 mb-3" name='action' value='create' type='submit'>Crear Usuario</button>
			</form>
			<h3>Filtros</h3>
			<form class="d-flex justify-content-between align-items-center mb-3" method='post' action='UsuarioServlet'>
				<section class="form-floating mb-3 mx-0 w-25">
					<input class="form-control w-100" id='id' name='id' placeholder='' value='' type='text'/>
					<label for="id">Id</label>
				</section>
				<section class="form-floating mb-3 mx-2 w-50">
					<input class="form-control w-100" id='name' name='name' placeholder='' value='' type='text'/>
					<label for="name">Nombre</label>
				</section>
				<section class="form-floating mb-3 mx-2 w-auto">
					<select class="form-select w-100" id='role' name='role'>
						<option value='' selected></option>
						<option value='admin'>admin</option>
						<option value='normal'>normal</option>
					</select>
					<label for="role">Rol</label>
				</section>
				<button class="btn btn-info" name='action' value='read' type='submit'>Filtrar</button>
			</form>
			<h3>Lista</h3>
			<table class="table table-stripped">
				<thead>
					<tr>
						<th scope='col'>ID</th>
						<th scope='col'>Nombre</th>
						<th scope='col'>Rol</th>
						<th scope='col'>Acciones</th>
					</tr>
				</thead>
				<tbody>
				<%
					List<UsuarioModelo> usuarios = (List<UsuarioModelo>)request.getAttribute("usuarios");
					if (usuarios != null) {					
						for (UsuarioModelo usuario : usuarios) {
				%>
					<tr>
						<th scope="row"><%= usuario.getId().intValue() %></th>
						<td><%= usuario.getNombre() %></td>
						<td><%= usuario.getRol() %></td>
						<td>
							<form method='post' action='UsuarioServlet'>
								<input name='id' value='<%= usuario.getId().intValue() %>' type='hidden'/>
								<input name='name' value='<%= usuario.getNombre() %>' type='hidden'/>
								<input name='role' value='<%= usuario.getRol() %>' type='hidden'/>
								<section class="d-flex justify-content-space-between gap-2">
									<button class="btn btn-warning" name='action' value='update' type='submit'>Editar</button>
									<button class="btn btn-danger" name='action' value='delete' type='submit'>Eliminar</button>
								</section>
							</form>
						</td>
					</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
		</section>
	</main>
</body>
</html>