package GestionCatalogoProducto;

import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {		
		Catalogo c = new Catalogo();
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		while (opcion != c.MAX_OPERACIONES) {
			c.mostrarMenu();
			System.out.println("Introduce una opción");
			String opcionCadena = sc.nextLine();
			try {
				opcion = Integer.parseInt(opcionCadena);
				if (opcion < 1 || opcion > c.MAX_OPERACIONES) {
					throw new Exception();
				}
			}
			catch (Exception e) {
				System.err.println("La opción no es correcta");
				continue;
			}
			switch (opcion) {
			case 1: // Agregar producto
			{
				System.out.println("Introduce el id del producto");
				String idCadena = sc.nextLine();
				int id = 0;
				try {
					id = Integer.parseInt(idCadena);
					if (id < 0) {
						throw new Exception();
					}
				}
				catch (Exception e) {
					System.err.println("El id no es válido");
					continue;
				}

				System.out.println("Introduce el nombre del producto");
				String nombre = sc.nextLine();
				
				System.out.println("Introduce el precio del producto");
				String precioCadena = sc.nextLine();
				int precio;
				try {
					precio = Integer.parseInt(precioCadena);
					if (precio < 0) {
						throw new Exception();
					}
				}
				catch (Exception e) {
					System.err.println("El precio no es válido");
					continue;
				}
				c.agregarProducto(id, new Producto(id, nombre, precio));
				break;
			}
			case 2: // Eliminar producto
			{
				System.out.println("Introduce el id del producto");
				String idCadena = sc.nextLine();
				int id = 0;
				try {
					id = Integer.parseInt(idCadena);
					if (id < 0) {
						throw new Exception();
					}
				}
				catch (Exception e) {
					System.err.println("El id no es válido");
					continue;
				}
				c.eliminarProducto(id);
				break;
			}
			case 3: // Actualizar producto
			{
				System.out.println("Introduce el id del producto");
				String idCadena = sc.nextLine();
				int id = 0;
				try {
					id = Integer.parseInt(idCadena);
					if (id < 0) {
						throw new Exception();
					}
				}
				catch (Exception e) {
					System.err.println("El id no es válido");
					continue;
				}
				System.out.println("Introduce el precio del producto");
				String precioCadena = sc.nextLine();
				int precio;
				try {
					precio = Integer.parseInt(precioCadena);
					if (precio < 0) {
						throw new Exception();
					}
				}
				catch (Exception e) {
					System.err.println("El precio no es válido");
					continue;
				}
				c.actualizarProducto(id, precio);
				break;
			}
			case 4: // Consultar producto
			{
				System.out.println("Introduce el id del producto");
				String idCadena = sc.nextLine();
				int id = 0;
				try {
					id = Integer.parseInt(idCadena);
					if (id < 0) {
						throw new Exception();
					}
				}
				catch (Exception e) {
					System.err.println("El id no es válido");
					continue;
				}
				Producto p = c.consultarProducto(id);
				if (p != null) {
					System.out.println(p);
				}
				else {
					System.out.println("El producto no existe");
				}
				break;
			}
			case 5: // Mostrar productos
			{
				c.mostrarProductos();
			}
			case 6: // Verificar producto
			{
				System.out.println("Introduce el id del producto");
				String idCadena = sc.nextLine();
				int id = 0;
				try {
					id = Integer.parseInt(idCadena);
					if (id < 0) {
						throw new Exception();
					}
				}
				catch (Exception e) {
					System.err.println("El id no es válido");
					continue;
				}
				if (c.verificarProducto(id)) {
					System.out.println("El producto existe");
				}
				else {
					System.err.println("El producto no existe");
				}
				break;
			}
			case 7: // Vaciar catálogo
				c.vaciarCatalogo();
			case 8: // Salir
				System.out.println("Cerrando el catálogo");
				break;
			default:
				System.err.println("Esa opción no está disponible");
			}
		}
	}
}
