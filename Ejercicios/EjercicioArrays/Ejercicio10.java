package EjercicioArrays;

import java.util.Scanner;

/**
 * 10. Crea un programa para realizar cálculos relacionados con la altura (en metros) de personas.
 * Pedirá un valor N y luego almacenará en un array N alturas introducidas por teclado.
 * Luego mostrará la altura media, máxima y mínima así como cuántas personas miden por encima y por debajo de la media.
 */
public class Ejercicio10 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce cuántas alturas quieres almacenar: ");
		int numAlturas = sc.nextInt();
		double[] alturas = new double[numAlturas];
		
		// Pedir datos
		for (int i = 0; i < alturas.length; ++i) {
			System.out.printf("Introduce la altura %d: ", i + 1);
			alturas[i] = sc.nextDouble();
		}
		
		// Calcular altura máxima y mínima
		double alturaMin = Double.MAX_VALUE;
		double alturaMax = Double.MIN_VALUE;
		double alturaMedia = 0;
		int countMax = 0;
		int countMin = 0;
		for (int i = 0; i < alturas.length; ++i) {
			if (alturas[i] < alturaMin) {
				alturaMin = alturas[i];
			}
			else if (alturas[i] > alturaMax) {
				alturaMax = alturas[i];
			}
			alturaMedia += alturas[i];
		}
		alturaMedia /= alturas.length;

		// Contar personas por encima y por debajo de la media
		for (double altura : alturas) {
			if (altura > alturaMedia) {
				++countMax;
			}
			else if (altura < alturaMedia) {
				++countMin;
			}
		}

		System.out.printf("La altura media es: %.2f%n", alturaMedia);
		System.out.printf("La altura máxima es: %.2f%n", alturaMax);
		System.out.printf("La altura mínima es: %.2f%n", alturaMin);
		System.out.printf("%d personas miden por encima de la media%n", countMax);
		System.out.printf("%d personas miden por debajo de la media%n", countMin);
		sc.close();
	}

}
