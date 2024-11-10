package EjercicioArrays2;

import java.util.Scanner;

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
		double minAltura = Double.MAX_VALUE;
		double maxAltura = Double.MIN_VALUE;
		double mediaAltura = 0;
		for (int i = 0; i < alturas.length; ++i) {
			if (alturas[i] < minAltura) {
				minAltura = alturas[i];
			}
			if (alturas[i] > maxAltura) {
				maxAltura = alturas[i];
			}
			mediaAltura += alturas[i];
		}
		mediaAltura /= alturas.length;
		System.out.printf("La altura media es: %.2f%n", mediaAltura);
		System.out.printf("La altura máxima es: %.2f%n", maxAltura);
		System.out.printf("La altura mínima es: %.2f%n", minAltura);
		sc.close();
	}

}
