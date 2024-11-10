package EjercicioArrays;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p;
		int q;
		try {
			System.out.println("Introduce un número: ");
			p = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}
		try {
			System.out.println("Introduce otro número: ");
			q = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}
		int length = p - q;
		if (length < 0) {
			length *= -1;
		}
		length += 1;
		int[] numbers = new int[length];
		for (int i = 0; i < length; ++i) {
			if (p < q) {
				numbers[i] = p + i;
			}
			else {
				numbers[i] = p - i;
			}
		}
		for (int i = 0; i < numbers.length; ++i) {
			System.out.printf("Posición %d: %d%n", i + 1, numbers[i]);
		}
		sc.close();
	}
}
