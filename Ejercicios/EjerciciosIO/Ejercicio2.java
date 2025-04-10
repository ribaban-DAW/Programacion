package EjerciciosIO;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicio2 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Uso: java Ejercicio2 <archivo>");
			return;
		}
		
		String nombrePrograma = args[0];
		try (BufferedReader br = new BufferedReader(new FileReader(nombrePrograma))) {
			String linea;
			
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
}
