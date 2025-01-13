package AgendaArrayList;
import java.util.*;

public class Agenda {
	private List<Contacto> contactos;
	
	public Agenda() {
		contactos = new ArrayList<Contacto>();
	}
	
	public boolean existeContacto(String nombre) {
		return (buscarContacto(nombre) >= 0);
	}
	
	public boolean anadirContacto(Contacto contacto) {
		if (buscarContacto(contacto.getNombre()) != -1) {
			return (false);
		}
		return (contactos.add(contacto));
	}
	
	public int buscarContacto(String nombre) {
		Iterator<Contacto> it = contactos.iterator();
		for (int i = 0; it.hasNext(); ++i) {
			if (contactos.get(i).getNombre().equals(nombre)) {
				return (i);
			}
			it.next();
		}
		return (-1);
	}
	
	public boolean eliminarContacto(String nombre) {
		int index = buscarContacto(nombre);
		if (index < 0) {
			return (false);
		}
		contactos.remove(index);
		return (true);
	}
	
	public void listarContactos() {
		for (Contacto contacto : contactos) {
			System.out.println(contacto);
		}
	}
	
	public boolean modificarContacto(String nombre, String telefono) {
		int index = buscarContacto(nombre);
		if (index == -1) {
			return (false);
		}
		contactos.get(index).setTelefono(telefono);
		return (true);
	}
}
