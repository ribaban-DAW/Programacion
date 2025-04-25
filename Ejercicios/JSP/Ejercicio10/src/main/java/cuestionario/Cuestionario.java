package cuestionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cuestionario {
	public List<Pregunta> preguntas;
	
	public Cuestionario() {
		preguntas = new ArrayList<>();

		int id = 1;
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", true),
					new Respuesta("respuesta 2", false),
					new Respuesta("respuesta 3", false),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 1", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", false),
					new Respuesta("respuesta 2", false),
					new Respuesta("respuesta 3", true),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 2", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", false),
					new Respuesta("respuesta 2", true),
					new Respuesta("respuesta 3", false),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 3", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", true),
					new Respuesta("respuesta 2", false),
					new Respuesta("respuesta 3", false),
					new Respuesta("respuesta 4", false),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 4", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", true),
					new Respuesta("respuesta 2", false),
					new Respuesta("respuesta 3", false),
					new Respuesta("respuesta 4", false),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 5", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", false),
					new Respuesta("respuesta 2", true),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 6", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", false),
					new Respuesta("respuesta 2", true),
					new Respuesta("respuesta 3", false),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 7", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", false),
					new Respuesta("respuesta 2", false),
					new Respuesta("respuesta 3", true),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 8", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", false),
					new Respuesta("respuesta 2", true),
					new Respuesta("respuesta 3", false),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 9", Arrays.asList(respuestas)));
		}
		{			
			Respuesta[] respuestas = {
					new Respuesta("respuesta 1", false),
					new Respuesta("respuesta 2", false),
					new Respuesta("respuesta 3", false),
					new Respuesta("respuesta 4", true),
			};

			preguntas.add(new Pregunta(id++, "Pregunta 10", Arrays.asList(respuestas)));
		}
	}
	
	public Cuestionario(List<Pregunta> preguntas, List<String> respuestasCorrectas) {
		setPreguntas(preguntas);
	}
	
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	private String formatPregunta(Pregunta pregunta) {
		// NOTE: Quizá cree un id para la respuesta, que se guarde en el 'value' del input
		// para tener un mapa de preguntas las respuestas correctas y así evitar hacer trampas
		// al mirar el código de la página (tiene el método que se enseñó en clase)
		String format = String.format("<label><input type='radio' name='%d' value='%%2$d' required>%%1$s</label><br>", pregunta.getId());
		return String.format("""
				<fieldset>
				<legend>%s</legend>
				%s
				</fieldset>
				""", pregunta.getTitulo(), pregunta.formatRespuestas(format));
	}
	
	@Override
	public String toString() {
		return String.format("""
				%s
				<button submit="type">Comprobar</button>
				""", preguntas.stream()
								.map(this::formatPregunta)
								.collect(Collectors.joining("\n")));
	}
}
