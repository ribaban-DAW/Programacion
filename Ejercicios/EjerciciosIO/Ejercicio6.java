package EjerciciosIO;

import java.io.BufferedReader;
import java.io.FileReader;


public class Ejercicio6 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Uso: java Ejercicio6 <palabra> <archivo.txt>");
			return;
		}
		
		String palabraBuscada = args[0];
		String nombreArchivo = args[1];
	
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {			
			String linea;
			
			int ocurrencias = 0;
			while ((linea = br.readLine()) != null) {
				ocurrencias += obtenerNumeroOcurencias(linea, palabraBuscada);
			}
			System.out.println(ocurrencias);
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static int obtenerNumeroOcurencias(String linea, String palabraBuscada) {
		String[] split = linea.split(" ");
		int ocurrencias = 0;
		for (String palabra : split) {
			if (palabra.equals(palabraBuscada)) {
				++ocurrencias;
			}
		}
		return ocurrencias;
	}
}
