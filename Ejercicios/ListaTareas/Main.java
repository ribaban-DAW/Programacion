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
			listaTareas.agregarTarea(tarea);
		}
		
		listaTareas.mostrarTareas();
		
		String tareaEliminada = "Hacer ejercicio";
		listaTareas.eliminarTarea(tareaEliminada);
		
		listaTareas.mostrarTareas();
		
		String palabraClave = "Java";
		listaTareas.eliminarTareasQueContienen(palabraClave);
		
		listaTareas.mostrarTareas();
	}
}
