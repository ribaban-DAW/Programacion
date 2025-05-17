package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import model.UsuarioModelo;

public class UsuarioDAO {
	private Connection conexion;
	
	public UsuarioDAO(Connection conexion) {
		setConexion(conexion);
	}
	
	public void crear(UsuarioModelo usuario, String contraseña) {
		String query = """
				INSERT INTO Usuario(Nombre, Contraseña, Rol)
				VALUES
				(?, ?, ?)
				""";
		try (PreparedStatement ps = conexion.prepareStatement(query)) {
			int index = 1;
			ps.setString(index++, usuario.getNombre());
			ps.setString(index++, contraseña);
			ps.setString(index++, usuario.getRol());
			ps.execute();
		}
		catch (Exception e) {
			System.err.println("UsuarioDAO.crear: No se ha podido crear la consulta: " + e.getMessage());
		}
	}
	
	public List<UsuarioModelo> buscar(Integer id, String nombre, String rol) {
		List<UsuarioModelo> usuarios = new ArrayList<>();
		String query = """
				SELECT *
				FROM Usuario
				WHERE 1 = 1
				""";
		List<String> params = new ArrayList<>();
		if (id != null) {
			query += "\nAND PK_ID = ?";
		}
		if (nombre != null && !nombre.isBlank()) {
			query += "\nAND Nombre LIKE ?";
			params.add("%" + nombre + "%");
		}
		if (rol != null && !rol.isBlank()) {
			query += "\nAND Rol = ?";
			params.add(rol);
		}
		try (PreparedStatement ps = conexion.prepareStatement(query)) {
			int index = 1;
			if (id != null) {
				ps.setInt(index++, id);
			}
			for (String param : params) {
				ps.setString(index++, param);
			}
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					do {
						usuarios.add(
								new UsuarioModelo(
										Integer.parseInt(rs.getString("PK_ID")),
										rs.getString("Nombre"),
										rs.getString("Rol")));
					} while (rs.next());
				}
			}
			catch (Exception e) {
				System.err.println("UsuarioDAO.buscar: No se ha podido realizar la consulta: " + e.getMessage());
			}
		}
		catch (Exception e) {
			System.err.println("UsuarioDAO.buscar: No se ha podido crear la consulta: " + e.getMessage());
		}
		return usuarios;
	}
	
	public List<UsuarioModelo> buscar() {
		return buscar(null, null, null);
	}
	
	public UsuarioModelo buscar(Integer id) {
		List<UsuarioModelo> usuario = buscar(id, null, null);
		System.out.println(usuario.getFirst().getId());
		return (usuario.size() == 0) ? null : usuario.getFirst();
	}
	
	public UsuarioModelo buscarExacto(String nombre) {
		final String QUERY = """
				SELECT *
				FROM Usuario
				WHERE Nombre = ?
				""";
		try (PreparedStatement ps = conexion.prepareStatement(QUERY)) {
			ps.setString(1, nombre);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Integer id = Integer.parseInt(rs.getString("PK_ID"));
					String rol = rs.getString("Rol");
					return new UsuarioModelo(id, nombre, rol);
				}
			}
			catch (Exception e) {
				System.err.println("UsuarioDAO.buscar: No se ha podido realizar la consulta: " + e.getMessage());
			}
		}
		catch (Exception e) {
			System.err.println("UsuarioDAO.buscar: No se ha podido crear la consulta: " + e.getMessage());
		}
		return null;
	}
	
	public void actualizar(UsuarioModelo usuario, String contraseña) {
		final String QUERY = """
				UPDATE Usuario
				SET Nombre = ?,
					Rol = ?,
					Contraseña = ?
				WHERE PK_ID = ?""";
		try (PreparedStatement ps = conexion.prepareStatement(QUERY)) {
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getRol());
			ps.setString(3, contraseña);
			ps.setInt(4, usuario.getId().intValue());
			ps.execute();
		}
		catch (Exception e) {
			System.err.println("UsuarioDAO.actualizar: No se ha podido crear la consulta: " + e.getMessage());
		}
	}
	
	public void actualizar(UsuarioModelo usuario) {
		final String QUERY = """
				UPDATE Usuario
				SET Nombre = ?,
					Rol = ?
				WHERE PK_ID = ?""";
		try (PreparedStatement ps = conexion.prepareStatement(QUERY)) {
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getRol());
			ps.setInt(3, usuario.getId().intValue());
			ps.execute();
		}
		catch (Exception e) {
			System.err.println("UsuarioDAO.actualizar: No se ha podido crear la consulta: " + e.getMessage());
		}
	}
	
	public void eliminar(Integer id) {
		final String QUERY = """
				DELETE FROM Usuario
				WHERE PK_ID = ?""";
		try (PreparedStatement ps = conexion.prepareStatement(QUERY)) {
			ps.setInt(1, id.intValue());
			ps.execute();
		}
		catch (Exception e) {
			System.err.println("UsuarioDAO.eliminar: No se ha podido crear la consulta: " + e.getMessage());
		}
	}
	
	public UsuarioModelo autenticar(String nombre, String contraseña) {
		final String QUERY = """
				SELECT *
				FROM Usuario
				WHERE Nombre = ?
				AND Contraseña = ?""";
		try (PreparedStatement ps = conexion.prepareStatement(QUERY)) {
			ps.setString(1, nombre);
			ps.setString(2, contraseña);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					int id = Integer.parseInt(rs.getString("PK_ID"));
					String rol = rs.getString("Rol");
					return new UsuarioModelo(id, nombre, rol);
				}
			}
			catch (Exception e) {
				System.err.println("UsuarioDAO.autenticar: No se ha podido realizar la consulta: " + e.getMessage());
			}
		}
		catch (Exception e) {
			System.err.println("UsuarioDAO.autenticar: No se ha podido crear la consulta: " + e.getMessage());
		}

		return null;
	}
	
	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
