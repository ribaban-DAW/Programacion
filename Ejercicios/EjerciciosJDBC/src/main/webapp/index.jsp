<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method="post">
		<section>
			<label>Usuario</label>
			<input name="username" type="text" required/>
		</section>
		<section>
			<label>Contraseña</label>
			<input name="password" type="password" required/>
		</section>
		<div></div>
		<button type="submit">Iniciar sesión</button>
	</form>
	
	<script>
	const form = document.getElementsByTagName('form')[0]
	form.addEventListener('submit', (event) => {
		event.preventDefault()
		enviarFormulario()
	})

	function enviarFormulario() {
		const formData = new URLSearchParams(new FormData(form))
		
	    fetch('LoginServlet', {
	        method: 'POST',
	        body: formData
	    })
	    .then(response => response.json())
	    .then(data => {
	    	if (data.status == 200) {
	    		window.location.href = data.redirect
	    	}
	    	else {	    		
		    	const div = document.getElementsByTagName('div')[0]
		    	div.innerHTML = "<p>" + data.message + "</p>"
	    	}
	    })
	    .catch(error => {
	        console.error(error)
	    })
	}
   </script>
</body>
</html>