package ClaseEmpleadoNueva;

import java.util.*;

public class Empresa {
	private List<Persona> personas;
	
	public Empresa() {
		personas = new ArrayList<>();
	}
	
	public void agregarPersona(Persona persona) {
		personas.add(persona);
	}
	
	public void mostrarInformacion() {
		for (Persona persona : personas) {
			if (persona != null) {				
				persona.mostrarDatos();
			}
		}
	}
}
