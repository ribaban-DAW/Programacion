package EjercicioArrays;
import java.util.Scanner;

/**
 * 7. Crea un programa que pida dos valores enteros P y Q,
 * luego cree un array que contenga todos los valores desde P hasta Q, y lo muestre por pantalla.
 */

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p;
		int q;

		// NOTA: Las validaciones no hacen falta, pero bueno, lo hecho, hecho está
		try {
			System.out.print("Introduce un número: ");
			p = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}
		try {
			System.out.print("Introduce otro número: ");
			q = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}

		// Diferencia entre los números y si es negativa, la convierto en positiva
		int length = p - q;
		if (length < 0) {
			length *= -1;
		}

		// Le añado 1 para incluir Q
		//
		// Por ejemplo:
		//
		//     P = 5, Q = 5
		//     Diferencia = 0
		//     Longitud = 1
		//     [5]
		//
		//     P = 7, Q = 4
		//     Diferencia = 3
		//     Longitud = 4
		//     [7, 6, 5, 4]
		//
		//     P = 4, Q = 7
		//     Diferencia = -3 * -1 = 3
		//     Longitud = 4
		//     [4, 5, 6, 7]
		//
		++length;
		int[] numbers = new int[length];
		for (int i = 0; i < length; ++i) {
			// Si p es menor que q, entonces almaceno los números en orden creciente
			if (p < q) {
				numbers[i] = p + i;
			}
			// Y en caso contrario, en orden descendiente
			else {
				numbers[i] = p - i;
			}
		}

		// Imprime los números
		for (int i = 0; i < numbers.length; ++i) {
			System.out.printf("Posición %d: %d%n", i + 1, numbers[i]);
		}
		sc.close();
	}
}
