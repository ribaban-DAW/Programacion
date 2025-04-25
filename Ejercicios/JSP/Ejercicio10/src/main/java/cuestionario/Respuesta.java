package cuestionario;

public class Respuesta {
	private String titulo;
	private boolean esCorrecta;
	
	public Respuesta(String titulo, boolean esCorrecta) {
		setTitulo(titulo);
		setEsCorrecta(esCorrecta);
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public boolean getEsCorrecta() {
		return esCorrecta;
	}
}
