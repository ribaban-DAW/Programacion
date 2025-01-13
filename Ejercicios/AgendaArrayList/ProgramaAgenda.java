package AgendaArrayList;

public class ProgramaAgenda {
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		ContactoPersona[] contactos = {
				new ContactoPersona("CP1", "1", "1/1/03"),
				new ContactoPersona("CP2", "2", "2/1/03"),
				new ContactoPersona("CP3", "3", "3/1/03"),
				new ContactoPersona("CP4", "4", "4/1/03"),
				new ContactoPersona("CP5", "5", "5/1/03"),
		};
		ContactoEmpresa[] contactos2 = {
				new ContactoEmpresa("CE1", "6", "www.empresa1.es"),
				new ContactoEmpresa("CE2", "7", "www.empresa2.es"),
				new ContactoEmpresa("CE3", "8", "www.empresa3.es"),
				new ContactoEmpresa("CE4", "9", "www.empresa4.es"),
				new ContactoEmpresa("CE5", "10", "www.empresa5.es"),
		};

		// Añado ContactosPersonas
		for (int i = 0; i < contactos.length; ++i) {
			if (!agenda.anadirContacto(contactos[i])) {
				System.err.printf("No se ha podido añadir %s a la agenda de contactos%n", contactos[i].getNombre());
			}
			else {
				System.out.printf("Se ha añadido %s a la agenda de contactos%n", contactos[i].getNombre());
			}
		}

		// Añado ContactosEmpresas
		for (int i = 0; i < contactos2.length; ++i) {
			if (!agenda.anadirContacto(contactos2[i])) {
				System.err.printf("No se ha podido añadir %s a la agenda de contactos%n", contactos2[i].getNombre());
			}
			else {
				System.out.printf("Se ha añadido %s a la agenda de contactos%n", contactos2[i].getNombre());
			}
		}

		agenda.listarContactos();
		
		if (agenda.buscarContacto("CE5") != -1) {
			System.out.println("Existe");
		}
		else {
			System.out.println("No existe");
		}
		
		if (agenda.eliminarContacto("CE5")) {
			System.out.println("Se ha eliminado el contacto");
		}
		
		
		if (agenda.modificarContacto("CE1", "82149821498124214")) {
			System.out.println("Se ha modificado el contacto");
		}
		agenda.listarContactos();
		
//		// Intento eliminar el contacto C1
//		String nombre = "C1";
//		if (!agenda.eliminarContacto(nombre)) {
//			System.err.printf("No se ha podido eliminar el contacto %s%n", nombre);
//		}
//		else {
//			System.out.printf("El contacto %s ha sido eliminado%n", nombre);
//		}
//
//		// Intento buscar el contacto C6
//		nombre = "C6";
//		int index = agenda.buscarContacto(nombre);
//		if (index < 0) {
//			System.err.printf("El contacto %s no existe%n", nombre);
//		}
//		else {
//			System.out.printf("El contacto %s tiene el índice %d%n", nombre, index);
//		}
//
//		// Intento buscar el contacto CE6, y si existe lo elimino
//		nombre = "CE2";
//		index = agenda.buscarContacto(nombre);
//		if (index < 0) {
//			System.err.printf("El contacto %s no existe%n", nombre);
//		}
//		else {
//			System.out.printf("El contacto %s tiene el índice %d%n", nombre, index);
//			if (!agenda.eliminarContacto(nombre)) {
//				System.err.printf("No se ha podido eliminar el contacto %s%n", nombre);
//			}
//			else {
//				System.out.printf("El contacto %s ha sido eliminado%n", nombre);
//			}
//		}
//		
//		// Intento añadir el contacto Foo
//		if (agenda.anadirContacto(new ContactoPersona("Foo", "33", "34"))) {
//			System.out.println("Se ha añadido a la agenda de contactos");
//		}
//		else {
//			System.err.println("No se ha podido añadir a la agenda de contactos");
//		}
//
//		// Intento añadir el contacto Bar
//		if (agenda.anadirContacto(new ContactoPersona("Bar", "33", "34"))) {
//			System.out.println("Se ha añadido a la agenda de contactos");
//		}
//		else {
//			System.err.println("No se ha podido añadir a la agenda de contactos");
//		}
//		// Intento añadir el contacto Barz
//		if (agenda.anadirContacto(new ContactoPersona("Barz", "33", "34"))) {
//			System.out.println("Se ha añadido a la agenda de contactos");
//		}
//		else {
//			System.err.println("No se ha podido añadir a la agenda de contactos");
//		}
//		agenda.listarContactos();
	}
}
