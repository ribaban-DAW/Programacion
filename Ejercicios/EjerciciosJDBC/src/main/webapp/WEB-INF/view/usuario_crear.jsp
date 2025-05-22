<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UsuarioModelo" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Crear Usuario</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
	
	<script src="scripts/enviarFormulario.js"></script>
</head>
<body>
	<main class="container mt-5 w-50 d-block mx-auto">
		<h1 class="text-center mb-3">Crear usuario</h1>
		<form class="my-3 w-50 d-block mx-auto" method='post'>
			<section class="form-floating mb-3 mx-auto">
				<input class="form-control" id="name" name='name' type='text' placeholder='' value='' required />
				<label for="name">Nombre</label>
			</section>
			<section class="form-floating mb-3 mx-auto">
				<input class="form-control" id="pass" name='pass' type='password' placeholder='' value='' required />
				<label for="pass">Contraseña</label>
			</section>
			<section class="form-floating mb-3 mx-auto">
				<select class="form-select" id="role" name='role'>
				<%
					out.println("<option value='admin'>admin</option>");
					out.println("<option value='normal' selected>normal</option>");
				%>
				</select>
				<label for="role">Rol</label>
			</section>
			<button class="btn btn-primary w-100 mb-3" type='submit'>Crear</button>
			<a href="PanelAdminServlet" class="btn btn-danger w-100">Cancelar</a>
			<div></div>
		</form>
	</main>
	<script>
		const form = document.getElementsByTagName('form')[0]
		form.addEventListener('submit', (event) => {
			event.preventDefault()
			enviarFormulario("UsuarioCrearServlet")
			.then(data => {
				if (data.status == 400) {
					const div = document.getElementsByTagName('div')[0]
					div.innerHTML = data.message
					div.className = "alert alert-danger text-center"
				}
			})
			.catch(error => {
				console.log(error)
			})
		})
   </script>
</body>
</html>