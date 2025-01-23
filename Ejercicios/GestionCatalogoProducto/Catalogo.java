package GestionCatalogoProducto;

import java.util.*;

public class Catalogo {
	HashMap<Integer, Producto> productos;
	final int MAX_OPERACIONES;
	
	public Catalogo() {
		productos = new HashMap<>();
		MAX_OPERACIONES = 8;
	}
	
	void agregarProducto(Integer id, Producto nuevoProducto) {
		productos.put(id, nuevoProducto);
		System.out.println("Se ha añadido el producto al catálogo");
	}
	
	void eliminarProducto(Integer id) throws IllegalArgumentException {
		if (!verificarProducto(id)) {
			throw new IllegalArgumentException("El producto con ese id no existe");
		}
		productos.remove(id);
		System.out.println("Se ha eliminado el producto del catálogo");
	}
	
	void actualizarProducto(Integer id, double precio) throws IllegalArgumentException {
		if (precio < 0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		Producto p = productos.get(id);
		if (p == null) {
			throw new IllegalArgumentException("El producto con ese id no existe");
		}
		System.out.printf("El precio del producto %d se ha actualizado%n", id);
	}
	
	Producto consultarProducto(Integer id) {
		if (!verificarProducto(id)) {
			return (null);
		}
		return (productos.get(id));
	}
	
	void mostrarProductos() {
		System.out.println("Catálogo de productos");
		Iterator<Map.Entry<Integer, Producto>> it = productos.entrySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	boolean verificarProducto(Integer id) {
		return (productos.containsKey(id));
	}
	
	void vaciarCatalogo() {
		productos.clear();
		System.out.println("Se ha vaciado el catálogo");
	}
	
	void mostrarMenu() {
		System.out.println("""
				1. Agregar producto
				2. Eliminar producto
				3. Actualizar precio
				4. Consultar producto
				5. Mostrar productos
				6. Verificar producto
				7. Vaciar catálogo
				8. Salir
				""");
	}
}
