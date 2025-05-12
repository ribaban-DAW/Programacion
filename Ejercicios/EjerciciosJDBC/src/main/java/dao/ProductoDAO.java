package dao;

import java.sql.Connection;
import model.ProductoModelo;

public class ProductoDAO {
	private Connection conexion;
	
	public ProductoDAO(Connection conexion) {
		setConexion(conexion);
	}
	
	public void crear(ProductoModelo producto) {
	}
	
	public void buscar(int id) {
	}
	
	public void actualizar(int id, ProductoModelo producto) {
	}
	
	public void eliminar(int id) {
	}
	
	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
