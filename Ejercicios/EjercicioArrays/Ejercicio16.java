package EjercicioArrays2;

import java.util.Arrays;

public class Ejercicio16 {

	public static void main(String[] args) {
		int cantidad = 0;
		
		// Calcular la cantidad
		for (int i = 1; i <= 10; ++i) {
			cantidad += i;
		}
		
		// Almacenar n, n veces
		int[] arr = new int[cantidad + 1];
		int pos = 0;
		for (int i = 1; i <= 10; ++i) {
			Arrays.fill(arr, pos, pos + i, i); // Array, posición de inicio, posición final, valor que se rellena en ese intervalo
			pos += i;
		}
		
		// Imprimir el número
		for (int i = 0; i < cantidad; ++i) {
			if (i < cantidad - 1) {				
				System.out.printf("%d, ", arr[i]);
			}
			else {
				System.out.printf("%d%n", arr[i]);
			}
		}
	}

}
