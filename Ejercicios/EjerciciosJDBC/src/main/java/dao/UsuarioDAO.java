package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public UsuarioModelo autenticar(String nombre, String contraseña) {
		final String QUERY = """
				SELECT *
				FROM Usuario
				WHERE Nombre = ?
				AND Contraseña = ?
				""";
		try (PreparedStatement ps = conexion.prepareStatement(QUERY)) {
			ps.setString(1, nombre);
			ps.setString(2, contraseña);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					int id = Integer.parseInt(rs.getString("PK_ID"));
					String rol = rs.getString("Rol");
					return new UsuarioModelo(id, nombre, rol);
				}
				System.err.println("Usuario o contraseña incorrectos");
			}
			catch (Exception e) {
				System.err.println("No se ha podido realizar la consulta");
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			System.err.println("No se ha podido crear la consulta");
			e.printStackTrace();
		}

		return null;
	}
	
	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
