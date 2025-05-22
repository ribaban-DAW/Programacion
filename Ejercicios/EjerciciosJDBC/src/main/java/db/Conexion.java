package db;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import config.Env;

public class Conexion {
	private final String DEFAULT_PROTOCOL = "jdbc";
	private final String DEFAULT_SUBPROTOCOL = "mysql";
	private final String DEFAULT_HOST = "localhost";
	private final int DEFAULT_PORT = 3306;

	private String protocol;
	private String subprotocol;
	private String host;
	private int port;
	private String usuario;
	private String contraseña;
	
	public Conexion() {
		setProtocol(DEFAULT_PROTOCOL);
		setSubprotocol(DEFAULT_SUBPROTOCOL);
		setHost(DEFAULT_HOST);
		setPort(DEFAULT_PORT);
		
		Env env = new Env();
		setUsuario(env.getDBUsuario());
		setContraseña(env.getDBContraseña());
	}
	
	public Conexion(String usuario, String contraseña) {
		setProtocol(DEFAULT_PROTOCOL);
		setSubprotocol(DEFAULT_SUBPROTOCOL);
		setHost(DEFAULT_HOST);
		setPort(DEFAULT_PORT);
		setUsuario(usuario);
		setContraseña(contraseña);
	}
	
	public Conexion(String host, int port, String usuario, String contraseña) {
		setProtocol(DEFAULT_PROTOCOL);
		setSubprotocol(DEFAULT_SUBPROTOCOL);
		setHost(host);
		setPort(port);
		setUsuario(usuario);
		setContraseña(contraseña);
	}
	
	public Connection conectar(String nombreBaseDatos) throws SQLException {
		final String URL = String.format("%s:%s://%s:%d/%s", protocol, subprotocol, host, port, nombreBaseDatos);
		return DriverManager.getConnection(URL, usuario, contraseña);
	}
	
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setSubprotocol(String subprotocol) {
		this.subprotocol = subprotocol;
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
