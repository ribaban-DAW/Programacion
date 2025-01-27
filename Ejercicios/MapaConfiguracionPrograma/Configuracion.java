package MapaConfiguracionPrograma;

import java.util.*;

public class Configuracion {
	private HashMap<String, Object> parametros;
	
	public Configuracion() {
		parametros = new HashMap<>();
		parametros.put("tema", "claro");
		parametros.put("volumen", 70);
		parametros.put("idioma", "español");
	}
	
	public void mostrarConfiguracion() {
		System.out.println("Configuraciones actuales:");
		for (Map.Entry<String, Object> parametro : parametros.entrySet()) {
			System.out.println(parametro.getKey() + " = " + parametro.getValue());
		}
	}
	
	public void actualizarConfiguracion(String clave, Object valor) {
		if (clave.isEmpty()) {
			System.err.println("La clave no puede estar vacía");
			return;
		}
		if (!parametros.containsKey(clave)) {
			System.err.printf("La configuración '%s' no existe.%n", clave);
			return;
		}
		parametros.put(clave, valor);
		System.out.printf("Configuración '%s' actualizada a: ", clave);
		System.out.println(valor);
	}
	
	public void agregarConfiguracion(String clave, Object valor) {
		if (clave.isEmpty()) {
			System.err.println("La clave no puede estar vacía");
			return;
		}
		parametros.put(clave, valor);
		System.out.printf("Configuración agregada o ya existente: %s = ", clave);
		System.out.println(valor);
	}
	
	public void obtenerConfiguracion(String clave) {
		if (clave.isEmpty()) {
			System.err.println("La clave no puede estar vacía");
			return;
		}
		String clavePascalCase = clave.toUpperCase().charAt(0) + clave.substring(1);
		System.out.println(clavePascalCase + " actual" + ((parametros.get(clave) == null) ? "(por defecto si no existe)" : "") +  ": " + parametros.getOrDefault(clave, 50));
	}
}
