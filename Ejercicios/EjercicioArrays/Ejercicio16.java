package EjercicioArrays;
import java.util.Arrays;

/**
 * 16. Crea un programa que cree un array de enteros e introduzca la siguiente secuencia de valores:
 *
 *      1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc.
 *
 * hasta introducir 10 diez veces, y luego la muestre por pantalla. En esta ocasión has de utilizar Arrays.fill()
 */

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
		
		// Imprimir los números
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
