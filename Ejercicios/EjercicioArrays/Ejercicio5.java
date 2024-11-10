package EjercicioArrays;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] numbers = new double[20];
		
		for (int i = 0; i < numbers.length; ++i) {
			try {
				System.out.printf("Introduzca el número %d: ", i + 1);
				numbers[i] = sc.nextDouble();
			}
			catch (Exception e) {
				System.err.println("No ha introducido un número correcto");
				--i; // Para que siga pidiendo el mismo número
			}
		}
		double average = 0;
		for (int i = 0; i < numbers.length; ++i) {
			average += numbers[i];
		}
		average /= numbers.length;
		System.out.printf("La suma de los positivos es: %f%n", average);
		sc.close();
	}
}
