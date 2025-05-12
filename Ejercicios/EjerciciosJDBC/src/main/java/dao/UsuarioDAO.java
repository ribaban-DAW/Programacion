package dao;

import java.sql.Connection;
import model.UsuarioModelo;

public class UsuarioDAO {
	private Connection conexion;
	
	public UsuarioDAO(Connection conexion) {
		setConexion(conexion);
	}
	
	public void crear(UsuarioModelo usuario) {
	}
	
	public void buscar(int id) {
	}
	
	public void actualizar(int id, UsuarioModelo usuario) {
	}
	
	public void eliminar(int id) {
	}
	
	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
