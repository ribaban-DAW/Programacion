package config;

import java.util.Properties;
import java.io.InputStream;

public class Env {
	private String DBUsuario;
	private String DBContraseña;
	
	public Env() {
		Properties props = new Properties();
		try (InputStream input = Env.class.getClassLoader().getResourceAsStream(".env")) {
			props.load(input);
			setDBUsuario(props.getProperty("DB_USERNAME"));
			setDBContraseña(props.getProperty("DB_PASSWORD"));
		}
		catch (Exception e) {
			System.err.println("Env: No se ha podido cargar el archivo: " + e.getMessage());
		}
	}

	public String getDBUsuario() {
		return DBUsuario;
	}

	public void setDBUsuario(String dBUsuario) {
		DBUsuario = dBUsuario;
	}

	public String getDBContraseña() {
		return DBContraseña;
	}

	public void setDBContraseña(String dBContraseña) {
		DBContraseña = dBContraseña;
	}
}
