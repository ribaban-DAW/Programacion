package Agenda;

public class Agenda {
	private Contacto[] contactos;
	private final int MAX_SIZE = 10;
	private int index;
	
	public Agenda() {
		contactos = new Contacto[MAX_SIZE];
		index = 0;
	}
	
	public boolean existeContacto(String nombre) {
		return (buscarContacto(nombre) >= 0);
	}
	
	public boolean anadirContacto(Contacto contacto) {
		if (existeContacto(contacto.nombre)) {
			return (false);
		}
		if (index < contactos.length) {			
			contactos[index] = contacto;
			++index;
			return (true);
		}
		for (int i = 0; i < contactos.length; ++i) {
			if (contactos[i] == null) {
				contactos[i] = contacto;
				return (true);
			}
		}
		return (false);
	}
	
	public int buscarContacto(String nombre) {
		for (int i = 0; i < index; ++i) {
			if (contactos[i] != null && contactos[i].nombre.equals(nombre)) {				
				return (i);
			}
		}
		return (-1);
	}
	
	public boolean eliminarContacto(String nombre) {
		int index = buscarContacto(nombre);
		if (index < 0) {
			return (false);
		}
		contactos[index] = null;
		return (true);
	}
	
	public void listarContactos() {
		for (Contacto contacto : contactos) {
			System.out.println(contacto);
		}
	}
}