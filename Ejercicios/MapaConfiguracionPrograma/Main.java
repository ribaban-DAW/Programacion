package MapaConfiguracionPrograma;

import java.util.*;

public class Main {
	
	public static void testEnunciado() {
		Configuracion c = new Configuracion();
		c.mostrarConfiguracion();
		c.actualizarConfiguracion("volumen", 85);
		c.actualizarConfiguracion("resolucion", "1080p");
		c.agregarConfiguracion("resolución", "1080p");
		c.mostrarConfiguracion();
		
		c.obtenerConfiguracion("tema");
		c.obtenerConfiguracion("brillo");
	}
	
	private static void mostrarMenu() {
		System.out.println("""
				1. Mostrar todas las configuraciones actuales.
				2. Cambiar el valor de una configuración existente.
				3. Agregar una configuración nueva si no existe.
				4. Obtener el valor de una configuración específica
				5. Salir""");
	}
	
	public static void testConMenu() {
		Scanner sc = new Scanner(System.in);
		Configuracion c = new Configuracion();
		int opcion = 0;
		String temp;
		
		do {
			mostrarMenu();
			System.out.print("Elige una opción: ");
			temp = sc.nextLine();
			try {
				opcion = Integer.parseInt(temp);
				if (opcion < 1 || opcion > 5) {
					throw new Exception();
				}
			}
			catch (Exception e) {
				System.err.println("Opción inválida");
				continue;
			}
			
			switch (opcion) {
			case 1:
				c.mostrarConfiguracion();
				break;
			case 2:
			{				
				System.out.print("Introduce la clave a actualizar: ");
				String clave  = sc.nextLine();
				System.out.print("Introduce el valor nuevo: ");
				String valor = sc.nextLine();
				try {					
					c.actualizarConfiguracion(clave, Integer.parseInt(valor));
				}
				catch (Exception e) {
					c.actualizarConfiguracion(clave, valor);
				}
				break;
			}
			case 3:
			{				
				System.out.print("Introduce la clave a agregar: ");
				String clave  = sc.nextLine();
				System.out.print("Introduce el valor nuevo: ");
				String valor = sc.nextLine();
				try {					
					c.agregarConfiguracion(clave, Integer.parseInt(valor));
				}
				catch (Exception e) {
					c.agregarConfiguracion(clave, valor);
				}
				break;
			}
			case 4:
			{				
				System.out.print("Introduce la clave a agregar: ");
				String clave  = sc.nextLine();
				c.obtenerConfiguracion(clave);
				break;
			}
			case 5:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.err.println("Opción no implementada");
			}
		} while (opcion != 5);
		sc.close();
	}
	
	public static void main(String[] args) {
		testEnunciado();
		testConMenu();
	}
}
