package EjercicioArrays;
import java.util.Scanner;

/**
 * 6. Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño N,
 * escriba M en todas sus posiciones y lo muestre por pantalla.
 */

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int m;

		// NOTA: Las validaciones no hacen falta, pero bueno, lo hecho, hecho está
		try {
			System.out.print("Introduce un número: ");
			n = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}
		try {
			System.out.print("Introduce otro número: ");
			m = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}

		int[] numbers = new int[n];
		// Rellena el array
		for (int i = 0; i < numbers.length; ++i) {
			numbers[i] = m;
		}

		// Imprime los números
		for (int i = 0; i < numbers.length; ++i) {
			System.out.printf("Posición %d: %d", i + 1, numbers[i]);
		}
		sc.close();
	}
}
