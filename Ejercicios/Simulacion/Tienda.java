package Simulacion;

public class Tienda {
	public static void main(String[] args) {
		Videojuego videojuego = new Videojuego(20, "Videojuego", 1, "Acción", "PC");
		Producto productos[] = {
				new Producto(1, "Azúcar", 1.5),
				new Producto(2, "Arroz", 1.2),
				new Producto(3, "Cacao", 2),
				new Producto(4, "Café", 3),
		};
		Cliente cliente = new Cliente("12345678W", "Paco", 500);
		videojuego.mostrarInformacion();
		cliente.comprarProducto(videojuego);
		cliente.comprarProducto(videojuego, 10);
		cliente.comprarProducto(videojuego);

		// El cliente compra unos cuantos productos
		for (int i = 0; i < productos.length; ++i) {
			if (i > productos.length * 0.5) {
				cliente.comprarProducto(productos[i]);
			}
			else {
				cliente.comprarProducto(productos[i], i * 5 + 5);
			}
		}
	}
}
