<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="scripts/enviarFormulario.js"></script>
</head>
<body>
	<div></div>
	<form method="post">
		<section>
			<label>Usuario</label>
			<input name="username" type="text" required/>
		</section>
		<section>
			<label>Contraseña</label>
			<input name="password" type="password" required/>
		</section>
		<button type="submit">Iniciar sesión</button>
	</form>
	
	<script>
		const form = document.getElementsByTagName('form')[0]
		form.addEventListener('submit', (event) => {
			event.preventDefault()
			enviarFormulario("LoginServlet")
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