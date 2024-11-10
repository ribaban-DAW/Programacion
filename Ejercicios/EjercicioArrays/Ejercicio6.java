package EjercicioArrays;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int m;
		try {
			System.out.println("Introduce un número: ");
			n = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}
		try {
			System.out.println("Introduce otro número: ");
			m = sc.nextInt();
		}
		catch (Exception e) {
			System.err.println("No es un número válido");
			sc.close();
			return;
		}
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; ++i) {
			numbers[i] = m;
		}
		for (int i = 0; i < numbers.length; ++i) {
			System.out.printf("Posición %d: %d", i + 1, numbers[i]);
		}
		sc.close();
	}
}
