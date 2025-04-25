package cuestionario;

import java.util.List;
import java.util.stream.Collectors;

public class Pregunta {
	private int id;
	private String titulo;
	private List<Respuesta> respuestas;
	
	public Pregunta(int id, String titulo, List<Respuesta> respuestas) {
		setId(id);
		setTitulo(titulo);
		setRespuestas(respuestas);
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}
	
	public int getId() {
		return id;
	}
	
	public String formatRespuestas(String format) {
		return respuestas.stream()
				.map(respuesta -> String.format(format, respuesta.getTitulo(), respuesta.getEsCorrecta() ? 1 : 0))
				.collect(Collectors.joining("\n"));
	}
}