package pedido;

import java.util.List;
import java.util.ArrayList;

public class Pedido {
	private List<Producto> productos;
	
	public Pedido() {
		productos = new ArrayList<>();
		int id = 1;
		productos.add(new Producto(id++, "Quinoa con verdura", 6.95, "quinoa-con-verdura.jpeg"));
		productos.add(new Producto(id++, "Pizza caprese", 5.50, "pizza-caprese.webp"));
		productos.add(new Producto(id++, "Pasta al pesto", 4.90, "pasta-al-pesto.jpg"));
		productos.add(new Producto(id++, "Hamburguesa vegetariana", 6.20, "hamburguesa-vegetariana.jpg"));
		productos.add(new Producto(id++, "Agua", 1, "agua.jpg"));
		productos.add(new Producto(id++, "Cerveza", 1.50, "cerveza.jpeg"));
		productos.add(new Producto(id++, "Refresco", 1.40, "refresco.webp"));
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public Producto getProducto(int id) {
		return productos.get(id - 1);
	}
}
