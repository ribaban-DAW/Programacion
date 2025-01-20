package ListaTareas;

import java.util.*;

public class ListaTareas {
	private ArrayList<String> tareas;
	
	public ListaTareas() {
		tareas = new ArrayList<String>();
	}
	
	
	
	boolean agregarTarea(String tarea) {
		for (String tareaActual : tareas) {
			if (tareaActual.equals(tarea)) {
				return (false);
			}
		}
		tareas.add(tarea);
		return (true);
	}
	
	void mostrarTareas() {
		System.out.println("Lista de tareas:");
		for (String tarea : tareas) {
			System.out.println("- " + tarea);
		}
	}
	
	boolean eliminarTarea(String tarea) {
		Iterator<String> it = tareas.iterator();
		
		while (it.hasNext()) {
			String tareaActual = it.next();
			if (tareaActual.equals(tarea)) {
				it.remove();
				return (true);
			}
		}
		return (false);
	}
	
	int eliminarTareasQueContienen(String palabraClave) {
		int contadorEliminados = 0;
		Iterator<String> it = tareas.iterator();
		
		while (it.hasNext()) {
			String tareaActual = it.next();
			if (tareaActual.contains(palabraClave)) {
				it.remove();
				++contadorEliminados;
			}
		}
		return (contadorEliminados);
	}
}
