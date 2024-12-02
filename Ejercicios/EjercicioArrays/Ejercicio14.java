package EjercicioArrays;

public class Ejercicio14 {

	public static void main(String[] args) {
		int cantidad = 0;
		
		// Calcular la cantidad
		for (int i = 1; i <= 10; ++i) {
			for (int j = 0; j < i; ++j) {
				++cantidad;
			}
		}
		
		// Almacenar n, n veces
		int[] arr = new int[cantidad + 1];
		int k = 0;
		for (int i = 1; i <= 10; ++i) {
			for (int j = 0; j < i; ++j) {
				arr[k] = i;
				++k;
			}
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
