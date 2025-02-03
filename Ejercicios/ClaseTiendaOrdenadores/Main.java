package ClaseTiendaOrdenadores;

public class Main {
	public static void main(String[] args) {
		Tienda t = new Tienda("El nombre", "El propietario", "El identificador tributario");
		
		t.agregarComputador(new Computador("La marca 1", 4, "El procesador 1", "El sistema operativo 1", 512.99));
		t.agregarComputador(new Computador("La marca 2", 8, "El procesador 2", "El sistema operativo 2", 700.99));
		t.agregarComputador(new Computador("La marca 3", 16, "El procesador 3", "El sistema operativo 3", 1024.90));
		
		t.mostrarDatos();
		t.eliminarComputador("La marca 2");
		
		t.mostrarDatos();
	}
}
