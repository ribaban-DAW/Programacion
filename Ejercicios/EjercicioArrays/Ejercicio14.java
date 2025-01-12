package EjercicioArrays;

/**
 * 14. Crea un programa que cree un array de enteros e introduzca la siguiente secuencia de valores:
 *
 *      1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc.
 *
 * hasta 10 diez veces, y luego la muestre por pantalla.
 */

// NOTA: Enlace para visualizar este código en Python Tutor, aunque cualquier debugger sirve:
// https://tinyurl.com/75p3wv4e
public class Ejercicio14 {

	public static void main(String[] args) {
		int cantidad = 0;
		
		// Calcular la cantidad
		// NOTA: Este método me resulta más intuitivo, pero es más sencillo iterar del 1 al 10 e ir sumando,
		// es decir:
		//
		// for (int i = 1; i <= 10; ++i) {
		//     cantidad += i;
		// }
		for (int i = 1; i <= 10; ++i) {
			for (int j = 0; j < i; ++j) {
				++cantidad;
			}
		}
		
		// Almacenar n, n veces
		int[] arr = new int[cantidad];
		int k = 0;
		for (int i = 1; i <= 10; ++i) {
			for (int j = 0; j < i; ++j) {
				arr[k] = i;
				++k;
			}
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
