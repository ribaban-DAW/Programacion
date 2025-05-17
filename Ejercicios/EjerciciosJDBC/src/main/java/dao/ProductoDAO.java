package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import model.ProductoModelo;


public class ProductoDAO {
	private Connection conexion;
	
	public ProductoDAO(Connection conexion) {
		setConexion(conexion);
	}
	
	public void crear(ProductoModelo producto) {
	}
	
	public List<ProductoModelo> buscar(Integer id, String nombre, Double precio) {
		List<ProductoModelo> productos = new ArrayList<>();
		
		String query = """
				SELECT *
				FROM Producto
				WHERE 1 = 1
				""";
		if (id != null) {
			query += "\nAND PK_ID = ?";
		}
		if (nombre != null && !nombre.isBlank()) {
			query += "\nAND Nombre LIKE ?";
		}
		if (precio != null) {
			query += "\nAND Precio = ?";
		}
		try (PreparedStatement ps = conexion.prepareStatement(query)) {
			int index = 1;
			if (id != null) {
				ps.setInt(index++, id);
			}
			if (nombre != null) {
				ps.setString(index++, nombre);
			}
			if (precio != null) {
				ps.setDouble(index++, precio);
			}
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					do {
						productos.add(
								new ProductoModelo(
										Integer.parseInt(rs.getString("PK_ID")),
										rs.getString("Nombre"),
										rs.getDouble("Precio"),
										rs.getString("ImagenURL")));
					} while (rs.next());
				}
			}
			catch (Exception e) {
				System.err.println("ProductoDAO.buscar: No se ha podido realizar la consulta: " + e.getMessage());
			}
		}
		catch (Exception e) {
			System.err.println("ProductoDAO.buscar: No se ha podido crear la consulta: " + e.getMessage());
		}
		return productos;
	}
	
	public List<ProductoModelo> buscar() {
		return buscar(null, null, null);
	}
	
	public int obtenerCantidad() {
		int cantidad = 0;
		final String QUERY = """
				SELECT COUNT(*)
				FROM Producto
				""";
		try (PreparedStatement ps = conexion.prepareStatement(QUERY)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					cantidad = rs.getInt(1);
				}
			}
			catch (Exception e) {
				System.err.println("ProductoDAO.obtenerCantidad: No se ha podido realizar la consulta: " + e.getMessage());
			}
		}
		catch (Exception e) {
			System.err.println("ProductoDAO.obtenerCantidad: No se ha podido crear la consulta: " + e.getMessage());
		}
		return cantidad;
	}
	
	public void actualizar(int id, ProductoModelo producto) {
	}
	
	public void eliminar(int id) {
	}
	
	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
