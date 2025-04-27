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
		preguntas.add(
			new Pregunta(
				id++,
				"¿Cuántas asignaturas hay en el Grado Superior de Desarrollo de Aplicaciones Web 2024/2025?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("1", false),
						new Respuesta("2", false),
						new Respuesta("3", false),
						new Respuesta("Al menos 1", true),
						new Respuesta("Ninguna de las anteriores", false),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Qué tipo de lenguaje es HTML?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("De programación", false),
						new Respuesta("De marcas", true),
						new Respuesta("Corporal", false),
						new Respuesta("No es un lenguaje", false),
						new Respuesta("Ninguna es correcta", false),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Cuánto es 0b101010 en decimal?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("101010", false),
						new Respuesta("25", false),
						new Respuesta("42", true),
						new Respuesta("10", false),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Es esta sintaxis correcta en Java? int x = 25",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("Sí", false),
						new Respuesta("No", true),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Qué expresión regular valida todas estas palabras? [cascada, cascarón, cascarrabias, casco]",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("^.[a-z].c.*$", true),
						new Respuesta("^.+a$", false),
						new Respuesta("^.....$", false),
						new Respuesta("^[a-z]*o$", false),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Qué dirección de host es válida?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("127.0.0.0", false),
						new Respuesta("256.0.0.1", false),
						new Respuesta("255.255.255.255", false),
						new Respuesta("192.168.0.1", true),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Qué es un IDE?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("Ideas Demasiado Exageradas", false),
						new Respuesta("Integrated Development Envelopment", false),
						new Respuesta("Entorno de Desarrollo Integrado", true),
						new Respuesta("Entorno de Desarrollo Interactivo", false),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Qué significa FOGASA?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("Fondo de Garantía Social", false),
						new Respuesta("Fondo de Garantía Salarial", true),
						new Respuesta("Fondo para Gastos de Salud", false),
						new Respuesta("Fondo de Garantía Sanitario", false),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Qué sector es el que más agua usa?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("Sector primario", true),
						new Respuesta("Sector secundario", false),
						new Respuesta("Sector terciario", false),
						new Respuesta("Sector cuaternario", false),
					}
				)
			)
		);
		preguntas.add(
			new Pregunta(
				id++,
				"¿Qué niveles forman la arquitectura ANSI-SPARC?",
				Arrays.asList(
					new Respuesta[] {
						new Respuesta("Nivel uno, Nivel dos, Nivel tres", false),
						new Respuesta("Externo, Conceptual, Interno", true),
						new Respuesta("Capa A, Capa B, Capa C, Capa D", false),
						new Respuesta("Extenso, Contextual, Intenso", false),
						new Respuesta("Global, Local", false),
					}
				)
			)
		);
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
				<div>
					%s
				</div>
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
