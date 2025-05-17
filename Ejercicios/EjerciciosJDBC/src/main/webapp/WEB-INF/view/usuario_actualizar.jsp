<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioModelo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar Usuario</title>
<script src="scripts/enviarFormulario.js"></script>
</head>
<body>
	<h1>Actualizar Usuario</h1>
	<form method='post'>
	<%
		UsuarioModelo usuario = (UsuarioModelo)request.getAttribute("user");
	%>
		<div></div>
		<table>
			<tbody>
				<tr>
					<th scope='row'>Id</th>
					<td><input name='id' value='<%= usuario.getId() %>' type='text' readonly /></td>
				</tr>
				<tr>
					<th scope='row'>Nombre</th>
					<td><input name='name' value='<%= usuario.getNombre() %>' type='text' required /></td>
				</tr>
				<tr>
					<th scope='row'>Contraseña</th>
					<td><input name='old-pass' value='' type='password'/></td>
				</tr>
				<tr>
					<th scope='row'>Contraseña nueva</th>
					<td><input name='new-pass' value='' type='password'/></td>
				</tr>
				<tr>
					<th scope='row'>Rol</th>
					<td>
						<select name='role'>
						<%
							if (usuario.getRol().equals("admin")) {
								out.println("<option value='admin' selected>admin</option>");
								out.println("<option value='normal'>normal</option>");
							}
							else {
								out.println("<option value='admin'>admin</option>");
								out.println("<option value='normal' selected>normal</option>");
							}
						%>
						</select>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan=2>
						<button type='submit'>Actualizar</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
		<script>
		const form = document.getElementsByTagName('form')[0]
		form.addEventListener('submit', (event) => {
			event.preventDefault()
			enviarFormulario("UsuarioActualizarServlet")
			.then(data => {
				if (data.status == 400) {
					const div = document.getElementsByTagName('div')[0]
					div.innerHTML = "<p>" + data.message + "</p>"
				}
			})
			.catch(error => {
				console.log(error)
			})
		})
   </script>
</body>
</html>