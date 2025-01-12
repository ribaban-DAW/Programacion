package EjercicioArrays;

/**
 * 18. Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios entre 0 y 9 (utiliza un casting (int) (Math.random()*10)).
 * Luego ordena los valores del array y los mostrará por pantalla.
 */

public class Ejercicio18 {

	public static void main(String[] args) {
		int[] arr = new int[30];
		
		// Rellena el array con valores aleatorios
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = (int)(Math.random() * 10);
		}

		// Imprime los números
		for (int i = 0; i < arr.length; ++i) {
			System.out.printf("Posición %d: %d%n", i, arr[i]);
		}
	}

}
