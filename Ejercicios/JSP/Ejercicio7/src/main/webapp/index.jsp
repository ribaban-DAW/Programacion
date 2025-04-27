<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conversor de dinero</title>
<link href="styles.css" rel="stylesheet">
</head>
<body>
	<h1>Conversor de dinero</h1>
	<form method="post">
		<input name="cantidad" type="number" value="0" step="0.01" min="0" placeholder="Introduce la cantidad" />
		<select name="tipo">
			<option value="pesetas">€ -> ₧</option>
			<option value="euros">₧ -> €</option>
		</select>
		<button type="submit">Convertir</button>
	</form>
	<div>
		<p style="visibility: hidden;">a</p>
	</div>
	<img src="nami-berry-eyes.gif"></img>

	<script>
	const form = document.getElementsByTagName('form')[0]
	form.addEventListener('submit', (event) => {
		event.preventDefault()
		enviarFormulario()
	})

	function enviarFormulario() {
		const formData = new URLSearchParams(new FormData(form))
		
	    fetch('ConversorServlet', {
	        method: 'POST',
	        body: formData
	    })
	    .then(response => response.text())
	    .then(data => {
	    	const div = document.getElementsByTagName('div')[0]
	    	div.innerHTML = '<p>' + data + '</p>'
	    })
	    .catch(error => {
	        console.error(error)
	    })
	}
   </script>
</body>
</html>