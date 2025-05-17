<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioModelo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panel Admin</title>
</head>
<body>
	<h1>Panel Admin</h1>
	<%
		UsuarioModelo user = (UsuarioModelo)session.getAttribute("user");
		if (user != null) {			
			out.println("<h2>Hola " + user.getNombre() + "</h2>");
		}
		String error = (String)request.getAttribute("error");
		if (error != null) {
			out.println("<p>" + error + "</p>");
		}
	%>
	<h2>Usuarios</h2>
	<form method='post' action='UsuarioServlet'>
		<button name='action' value='create' type='submit'>Crear</button>
	</form>
	<h3>Filtros</h3>
	<form method='post' action='UsuarioServlet'>
		<section>
			<label for="id">Id</label>
			<input name='id' value='' type='text'/>
		</section>
		<section>
			<label for="name">Nombre</label>
			<input name='name' value='' type='text'/>
		</section>
		<section>
			<label for="role">Rol</label>
			<select name='role'>
				<option value='' selected></option>
				<option value='admin'>admin</option>
				<option value='normal'>normal</option>
			</select>
		</section>
		<button name='action' value='read' type='submit'>Filtrar</button>
	</form>
	<table>
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
				<td><%= usuario.getId().intValue() %></td>
				<td><%= usuario.getNombre() %></td>
				<td><%= usuario.getRol() %></td>
				<td>
					<form method='post' action='UsuarioServlet'>
						<input name='id' value='<%= usuario.getId().intValue() %>' type='hidden'/>
						<input name='name' value='<%= usuario.getNombre() %>' type='hidden'/>
						<input name='role' value='<%= usuario.getRol() %>' type='hidden'/>
						<button name='action' value='update' type='submit'>Editar</button>
						<button name='action' value='delete' type='submit'>Eliminar</button>
					</form>
				</td>
			</tr>
		<%
				}
			}
		%>
		</tbody>
	</table>
</body>
</html>