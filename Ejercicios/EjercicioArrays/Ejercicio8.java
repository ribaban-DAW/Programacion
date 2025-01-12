package EjercicioArrays;
import java.util.Scanner;

/**
 * 8. Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0, utilizando Math.random(),
 * y luego le pida al usuario un valor real R (entre 0,0 y 1,0 ).
 * Por último, mostrará cuántos valores del array son igual o superiores a R.
 */

public class Ejercicio8 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		double[] randomNumbers = new double[100];
		
		// Rellena el array
		for (int i = 0; i < randomNumbers.length; ++i) {
			randomNumbers[i] = Math.random();
		}

		System.out.print("Introduce un número entre el 0,0 y 1,0: ");
		double r = sc.nextDouble();

		int count = 0;
		// Cuenta cuántos números aleatorios hay por encima de R
		for (double number : randomNumbers) {
			if (number >= r) {
				++count;
			}
		}

		System.out.printf("Hay %d valores mayores que %f", count, r);
		sc.close();
	}
}
