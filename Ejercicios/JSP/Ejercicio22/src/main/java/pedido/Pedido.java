package pedido;

import java.util.List;
import java.util.ArrayList;

public class Pedido {
	private List<Producto> productos = new ArrayList<>();
	
	public void addProductos(Producto p) {
		productos.add(p);
	}
	
	public void addProductos(List<Producto> ps) {
		for (Producto p : ps) {
			addProductos(p);
		}
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
}
