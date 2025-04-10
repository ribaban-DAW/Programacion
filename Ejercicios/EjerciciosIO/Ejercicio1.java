package EjerciciosIO;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Ejercicio1 {
	public static void main(String[] args) {
		int limit = 500;
		// Obtener el directorio actual: https://stackoverflow.com/questions/4871051/how-to-get-the-current-working-directory-in-java
		String nombreArchivo = System.getProperty("user.dir") + "/primos.dat";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
			for (int i = 1; i < limit; ++i) {
				if (esPrimo(i)) {
					String numStr = "" + i + "\n";
					bw.write(numStr);
				}
			}
			System.out.println("Primos escritos correctamente");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static boolean esPrimo(int n) {
		int ndiv = 0;
		for (int i = 1; i < n; ++i) {
			if (n % i == 0) {
				++ndiv;
			}
			if (ndiv >= 2) {
				return false;
			}
		}
		return true;
	}
}
