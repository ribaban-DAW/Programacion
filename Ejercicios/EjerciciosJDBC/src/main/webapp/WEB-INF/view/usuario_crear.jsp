<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioModelo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Usuario</title>
<script src="scripts/enviarFormulario.js"></script>
</head>
<body>
	<h1>Crear usuario</h1>
	<form method='post'>
		<div></div>
		<table>
			<tbody>
				<tr>
					<th scope='row'>Nombre</th>
					<td><input name='name' value='' type='text' required /></td>
				</tr>
				<tr>
					<th scope='row'>Contraseña</th>
					<td><input name='pass' value='' type='password' required /></td>
				</tr>
				<tr>
					<th scope='row'>Rol</th>
					<td>
						<select name='role'>
						<%
							out.println("<option value='admin'>admin</option>");
							out.println("<option value='normal' selected>normal</option>");
						%>
						</select>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan=2>
						<button type='submit'>Crear</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
		<script>
		const form = document.getElementsByTagName('form')[0]
		form.addEventListener('submit', (event) => {
			event.preventDefault()
			enviarFormulario("UsuarioCrearServlet")
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