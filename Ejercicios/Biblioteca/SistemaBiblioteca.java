package Biblioteca;

public class SistemaBiblioteca {
	private static Libro[] libros = new Libro[5];
	private static Usuario[] usuarios = new Usuario[5];
	private static String[] historial = new String[100];
	private static int contadorLibros = 0;
	private static int contadorUsuarios = 0;
	private static int contadorHistorial = 0;
	
	public static void main(String[] args) {
		agregarLibro(new LibroDigital("L1", "A1", 2024, "1", 54000));
		agregarLibro(new LibroFisico("L2", "A2", 2023, "2", 10));
		agregarUsuario(new Estudiante("P1", "1"));
		agregarUsuario(new Estudiante("E1", "2"));
		listarLibros();
		listarUsuarios();
		listarHistorial();
		realizarPrestamo(usuarios[0], (LibroFisico)libros[1]);
		realizarDescarga(usuarios[0], (LibroDigital)libros[0]);
		realizarPrestamo(usuarios[0], (LibroFisico)libros[1]);
		realizarPrestamo(usuarios[1], (LibroFisico)libros[1]);
		realizarPrestamo(usuarios[0], (LibroFisico)libros[1]);
		realizarPrestamo(usuarios[0], (LibroFisico)libros[1]);
		realizarPrestamo(usuarios[0], (LibroFisico)libros[1]);
		realizarPrestamo(usuarios[0], (LibroFisico)libros[1]);
		realizarDescarga(usuarios[0], (LibroDigital)libros[0]);
		realizarDescarga(usuarios[1], (LibroDigital)libros[0]);
		listarLibros();
		listarUsuarios();
		listarHistorial();
	}
	
	public static void agregarLibro(Libro libro) {
		for (int i = 0; i < libros.length && contadorLibros < libros.length; ++i) {
			if (libros[i] == null) {
				libros[i] = libro;
				System.out.println("Se ha añadido el libro correctamente");
				++contadorLibros;
				return;
			}
		}
		System.err.println("No se ha podido añadir el libro");
	}
	
	public static void agregarUsuario(Usuario usuario) {
		for (int i = 0; i < usuarios.length && contadorUsuarios < usuarios.length; ++i) {
			if (usuarios[i] == null) {
				usuarios[i] = usuario;
				System.out.println("Se ha añadido el usuario correctamente");
				++contadorUsuarios;
				return;
			}
		}
		System.err.println("No se ha podido añadir el usuario correctamente");
	}
	
	public static void realizarPrestamo(Usuario usuario, LibroFisico libro) {
		for (int i = 0; i < libros.length && contadorHistorial < historial.length; ++i) {
			if (libros[i] != null && libros[i].getTitulo().equals(libro.getTitulo())) {
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
		for (int i = 0; i < libros.length && contadorHistorial < historial.length; ++i) {
			if (libros[i] != null && libros[i].getTitulo().equals(libro.getTitulo())) {
				usuario.descargarLibro(libro);
				registrarHistorial(usuario.getNombre(), libro.getTitulo(), "Realizar descarga");
				System.out.println("Se ha realizado el préstamo");
				return;
			}
		}
		System.err.println("No se ha podido realizar la descarga");
	}
	
	public static void registrarHistorial(String usuario, String tituloLibro, String tipoOperacion) {
		historial[contadorHistorial] = String.format("Operación: %s, Usuario: %s Libro: %s", tipoOperacion, usuario, tituloLibro);
		++contadorHistorial;
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
