package EjercicioArrays;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 19. Necesitamos crear un programa para mostrar el ranking de puntuaciones de un torneo de ajedrez con 8 jugadores.
 * Se le pedirá al usuario que introduzca las puntuaciones de todos los jugadores (habitualmente valores entre 1000 y 2800, de tipo entero)
 * y luego muestre las puntuaciones en orden descendente (de la más alta a la más baja).
 */

public class Ejercicio19 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] puntuaciones = new int[8];
		
		// Para tener una especie de hashmap y asociar las puntuaciones con un índice específico
		// Se desperdicia un poco de memoria, pero no pasa nada porque es un programa pequeñito
		// Creo un array de 2147483647 (MAX_INT) posiciones para asegurarme que la puntuación del jugador
		// vaya a caber sí o sí dentro del array, y así obtener el índice de manera más sencilla
		int[] indiceJugador = new int[Integer.MAX_VALUE]; 
		
		for (int i = 0; i < puntuaciones.length; ++i) {
			System.out.printf("Introduzca la puntuación del jugador %d: ", i + 1);
			puntuaciones[i] = sc.nextInt();
			if (puntuaciones[i] < 0) {
				System.err.println("Error, la puntuación no puede ser negativa");
				--i;
				continue;
			}
			indiceJugador[puntuaciones[i]] = i + 1;
		}
		
		Arrays.sort(puntuaciones);

		System.out.println("Jugadores ordenados por puntuación de mayor a menor");
		for (int i = puntuaciones.length - 1; i >= 0; --i) {
			System.out.printf("Puntuación del jugador %d: %d%n", indiceJugador[puntuaciones[i]], puntuaciones[i]);
		}
		sc.close();
	}
}
