package BibliotecaArrayList;

import java.util.*;

public class SistemaBiblioteca {
	private static List<Libro> libros = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static List<String> historial = new ArrayList<>();
	
	public static void main(String[] args) {
		agregarLibro(new LibroDigital("L1", "A1", 2024, "1", 54000));
		agregarLibro(new LibroFisico("L2", "A2", 2023, "2", 10));
		agregarUsuario(new Estudiante("P1", "1"));
		agregarUsuario(new Estudiante("E1", "2"));
		listarLibros();
		listarUsuarios();
		listarHistorial();
		realizarPrestamo(usuarios.get(0), (LibroFisico)libros.get(1));
		realizarDescarga(usuarios.get(0), (LibroDigital)libros.get(0));
		realizarPrestamo(usuarios.get(0), (LibroFisico)libros.get(1));
		realizarPrestamo(usuarios.get(1), (LibroFisico)libros.get(1));
		realizarPrestamo(usuarios.get(0), (LibroFisico)libros.get(1));
		realizarPrestamo(usuarios.get(0), (LibroFisico)libros.get(1));
		realizarPrestamo(usuarios.get(0), (LibroFisico)libros.get(1));
		realizarPrestamo(usuarios.get(0), (LibroFisico)libros.get(1));
		realizarDescarga(usuarios.get(0), (LibroDigital)libros.get(0));
		realizarDescarga(usuarios.get(1), (LibroDigital)libros.get(0));
		listarLibros();
		listarUsuarios();
		listarHistorial();
	}
	
	public static void agregarLibro(Libro libro) {
		libros.add(libro);
		System.out.printf("Se ha añadido el usuario %s correctamente%n", libro.getTitulo());
	}
	
	public static void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
		System.out.printf("Se ha añadido el usuario %s correctamente%n", usuario.getNombre());
	}
	
	public static void realizarPrestamo(Usuario usuario, LibroFisico libro) {
		for (Libro l : libros) {
			if (l.getTitulo().equals(libro.getTitulo())) {
				if (usuario.prestarLibro(libro)) {					
					registrarHistorial(usuario.getNombre(), libro.getTitulo(), "Realizar préstamo");
					System.out.println("Se ha realizado el préstamo");
					return;
				}
			}
		}
		System.err.println("No se ha podido realizar el préstamo");
	}
	
	public static void realizarDescarga(Usuario usuario, LibroDigital libro) {
		for (Libro l: libros) {
			if (l.getTitulo().equals(libro.getTitulo())) {
				usuario.descargarLibro(libro);
				registrarHistorial(usuario.getNombre(), libro.getTitulo(), "Realizar descarga");
				System.out.println("Se ha realizado el préstamo");
				return;
			}
		}
		System.err.println("No se ha podido realizar la descarga");
	}
	
	public static void registrarHistorial(String usuario, String tituloLibro, String tipoOperacion) {
		historial.add(String.format("Operación: %s, Usuario: %s Libro: %s", tipoOperacion, usuario, tituloLibro));
	}
	
	public static void listarLibros() {
		System.out.println("Lista de libros");
		for (Libro libro: libros) {
			if (libro != null) {
				System.out.println(libro);
			}
		}
	}
	
	public static void listarUsuarios() {
		System.out.println("Lista de usuarios");
		for (Usuario usuario: usuarios) {
			if (usuario != null) {
				System.out.println(usuario);
			}
		}
	}
	
	public static void listarHistorial() {
		System.out.println("Historial");
		for (String registro: historial) {
			if (registro != null) {
				System.out.println(registro);
			}
		}
	}
}
