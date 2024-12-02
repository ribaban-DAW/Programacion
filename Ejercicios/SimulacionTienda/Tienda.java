package SimulacionTienda;

public class Tienda {
	public static void main(String[] args) {
		Videojuego videojuego = new Videojuego(20, "Videojuego", 10, "Plataforma", "PC");
		Cliente cliente = new Cliente("12345678W", "Paco", 5);
		videojuego.mostrarInformacion();
		cliente.comprarProducto(videojuego);
	}
}
