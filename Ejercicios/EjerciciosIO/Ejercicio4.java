package EjerciciosIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Ejercicio4 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Uso: java Ejercicio4 <archivo.txt>");
			return;
		}
		
		String nombreOriginal = args[0];
		try {
			List<String> contenido = obtenerContenidoDelArchivo(nombreOriginal);
			
			ordenarContenido(contenido);
			
			String nombreArchivoNuevo = crearNombreArchivoNuevo(nombreOriginal);
			crearArchivoConContenidoOrdenado(contenido, nombreArchivoNuevo);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
	}
	
	public static List<String> obtenerContenidoDelArchivo(String nombreArchivo) throws FileNotFoundException, IOException {
		ArrayList<String> buffer = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {			
			String linea;
			
			while ((linea = br.readLine()) != null) {
				buffer.add(linea);
			}
		}
		catch (FileNotFoundException e) {
			throw e;
		}
		catch (IOException e) {
			throw e;
		}
		
		System.out.println("Contenido obtenido exitosamente");
		return buffer;
	}
	
	public static void ordenarContenido(List<String> contenido) {
		contenido.sort(null);
		System.out.println("Contenido ordenado correctamente");
	}
	
	public static String crearNombreArchivoNuevo(String nombreOriginal) {
		String nombreNuevo;
		
		nombreNuevo = nombreOriginal.substring(0, nombreOriginal.indexOf("."));
		nombreNuevo += "_sort";
		nombreNuevo += nombreOriginal.substring(nombreOriginal.indexOf("."), nombreOriginal.length());
		return nombreNuevo;
	}
	
	public static void crearArchivoConContenidoOrdenado(List<String> contenido, String nombreArchivoNuevo) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoNuevo))) {
			for (String linea : contenido) { 
				bw.write(linea + "\n");
			}
		}
		catch (IOException e) {
			throw e;
		}
		
		System.out.println("Contenido ordenado escrito en " + nombreArchivoNuevo);
	}
}
