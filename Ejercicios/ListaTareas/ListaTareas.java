package ListaTareas;

import java.util.*;

public class ListaTareas {
	private ArrayList<String> tareas;
	
	public ListaTareas() {
		tareas = new ArrayList<String>();
	}
	
	void agregarTarea(String tarea) {
		for (String tareaActual : tareas) {
			if (tareaActual.equals(tarea)) {
				System.err.printf("La tarea '%s' ya existe en la lista.%n", tarea);
				return;
			}
		}
		tareas.add(tarea);
		System.out.printf("Tarea agregada: %s%n", tarea);
	}
	
	void mostrarTareas() {
		if (tareas.size() == 0) {
			System.out.println("La lista de tareas está vacía");
			return;
		}
		System.out.println("Lista de tareas:");
		for (String tarea : tareas) {
			System.out.println("- " + tarea);
		}
	}
	
	void eliminarTarea(String tarea) {
		Iterator<String> it = tareas.iterator();
		
		while (it.hasNext()) {
			String tareaActual = it.next();
			if (tareaActual.equalsIgnoreCase(tarea)) {
				it.remove();
				System.out.printf("Tarea eliminada: %s%n", tarea);
				return;
			}
		}
		System.err.printf("La tarea '%s' no existe en la lista de tareas%n", tarea);
	}
	
	void eliminarTareasQueContienen(String palabraClave) {
		int contadorEliminados = 0;
		Iterator<String> it = tareas.iterator();
		while (it.hasNext()) {
			String tareaActual = it.next();
			if (tareaActual.toLowerCase().contains(palabraClave.toLowerCase())) {
				it.remove();
				++contadorEliminados;
			}
		}
		System.out.printf("Se eliminaron %d tarea(s) que contenían la palabra '%s'%n", contadorEliminados, palabraClave);
	}
}
