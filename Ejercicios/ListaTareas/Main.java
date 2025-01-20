package ListaTareas;

public class Main {
	public static void main(String[] args) {
		ListaTareas listaTareas = new ListaTareas();
		String[] tareas = {
				"Comprar leche",
				"Hacer ejercicio",
				"Estudiar Java",
				"Llamar al banco",
				"Preparar la presentación",
				"Estudiar Java",
		};
		
		for (String tarea : tareas) {
			if (listaTareas.agregarTarea(tarea)) {
				System.out.printf("Tarea agregada: %s%n", tarea);
			}
			else {
				System.err.printf("La tarea '%s' ya existe en la lista.%n", tarea);
			}
		}
		
		listaTareas.mostrarTareas();
		
		String tareaEliminada = "Hacer ejercicio";
		if (listaTareas.eliminarTarea(tareaEliminada)) {
			System.out.println("Tarea eliminada: " + tareaEliminada);
		}
		else {
			System.err.printf("No se ha podido eliminar la tarea '%s' porque no existe en la lista%n", tareaEliminada);
		}
		
		listaTareas.mostrarTareas();
		
		String palabraClave = "Java";
		int contadorEliminados = listaTareas.eliminarTareasQueContienen(palabraClave);
		
		System.out.printf("Se eliminaron %d tarea(s) que contenían la palabra '%s'%n", contadorEliminados, palabraClave);
		
		listaTareas.mostrarTareas();
	}
}
