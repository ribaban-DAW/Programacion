package EjerciciosIO;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio3 {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Uso: java Ejercicio3 <archivo1> <archivo2> ... <archivon>");
			return;
		}
		List<String> nombresArchivos = new ArrayList<>();
		for (int i = 0; i < args.length; ++i) {
			nombresArchivos.add(args[i]);
		}
		
		String nombreArchivoConcatenado = "concat.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoConcatenado))) {
			for (String nombreArchivo : nombresArchivos) {
				try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
					String linea;
					
					while ((linea = br.readLine()) != null) {
						bw.write(linea + "\n");
					}
				}
				catch (Exception e) {
					System.err.println(e);
					return;
				}
			}
			System.out.println("Concatenado correctamente");
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
}
