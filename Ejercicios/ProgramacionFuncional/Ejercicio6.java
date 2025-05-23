package ProgramacionFuncional;

// Ejercicio 6: Implementación de una Interfaz Funcional Mediante una Clase Anónima
interface Operacion {
    int calcular(int a, int b);
}

public class Ejercicio6 {
    public static void main(String[] args) {
        // Implementar la interfaz Operacion usando una clase anónima para realizar una suma
		Operacion suma = new Operacion() {
			@Override
			public int calcular(int a, int b) {
				return (a + b);
			}
		};

		System.out.println(suma.calcular(1, 1));
		System.out.println(suma.calcular(9, 1));
		System.out.println(suma.calcular(2, 1));
    }
}
