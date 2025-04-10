package EjerciciosIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Ejercicio5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Uso: java Ejercicio5 <archivo original> <archivo nuevo>");
			return;
		}
		
		String nombreArchivoOriginal = args[0];
		String nombreArchivoNuevo = args[1];
		
		// Lectura
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoOriginal))) {			
			
			// Escritura
			try (BufferedWriter wr = new BufferedWriter(new FileWriter(nombreArchivoNuevo))) {
				String linea;
				boolean estaEnComentarioMultilinea = false;
				boolean estaEnCadena = false;
				boolean estaEnCadenaMultilinea = false;
				while ((linea = br.readLine()) != null) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < linea.length(); ++i) {
						// Cadena simple
						if (!estaEnCadenaMultilinea && !estaEnCadena && linea.charAt(i) == '\"') {
							estaEnCadena = true;
						}
						else if (!estaEnCadenaMultilinea && estaEnCadena && linea.charAt(i) == '\"') {
							estaEnCadena = false;
						}
						
						// Cadena multilínea
						if (!estaEnCadena && !estaEnCadenaMultilinea && i + 2 < linea.length() && linea.charAt(i) == '\'' && linea.charAt(i + 1) == '\'' && linea.charAt(i + 2) == '\'') {
							estaEnCadenaMultilinea = true;
						}
						else if (!estaEnCadena && estaEnCadenaMultilinea && i + 2 < linea.length() && linea.charAt(i) == '\'' && linea.charAt(i + 1) == '\'' && linea.charAt(i + 2) == '\'') {
							estaEnCadenaMultilinea = false;
						}
						
						if (!estaEnCadena && !estaEnCadenaMultilinea) {
							// Empieza comentario multilínea /*
							if (!estaEnComentarioMultilinea && i + 1 < linea.length() && linea.charAt(i) == '/' && linea.charAt(i + 1) == '*') {
								i += 2;
								estaEnComentarioMultilinea = true;
							}
							// Termina comentario multilínea */
							else if (estaEnComentarioMultilinea && i + 1 < linea.length() && linea.charAt(i) == '*' && linea.charAt(i + 1) == '/') {
								estaEnComentarioMultilinea = false;
								i += 2;
							}
							
							if (estaEnComentarioMultilinea) {
								continue;
							}
							
							// Comentario en línea
							if (i + 1 < linea.length() && linea.charAt(i) == '/' && linea.charAt(i + 1) == '/') {
								break;
							}
						}
						
						if (i < linea.length()) {							
							sb.append(linea.charAt(i));
						}
					}
					if (sb.length() > 0) {						
						wr.write(sb.toString() + "\n");
					}
				}
				System.out.println("Escrito correctamente");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
}