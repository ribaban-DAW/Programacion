async function enviarFormulario(resource) {
	const formData = new URLSearchParams(new FormData(form));
	return fetch(resource, {
        method: 'POST',
        body: formData,
    })
    .then(response => response.json())
    .then(data => {
    	if (data.status == 200 || data.status == 500) {
    		window.location.href = data.redirect
    	}
		return data
    });
}