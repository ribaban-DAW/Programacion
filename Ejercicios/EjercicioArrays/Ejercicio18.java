package EjercicioArrays2;

public class Ejercicio18 {

	public static void main(String[] args) {
		int[] arr = new int[30];
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = (int)(Math.random() * 10);
		}
		for (int i = 0; i < arr.length; ++i) {
			System.out.printf("Posición %d: %d%n", i, arr[i]);
		}
	}

}
