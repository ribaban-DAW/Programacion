package ClaseTiendaOrdenadores;

import java.util.*;

// NOTA: Se podría añadir una comprobación en los setters para verificar que son válidos

public class Tienda {
	private String nombre;
	private String propietario;
	private String identificadorTributario;
	private List<Computador> computadores;
	private static final int numeroComputadores = 20; // Lo he puesto final porque es la cantidad máxima que puede soportar la tienda
	
	public Tienda(String nombre, String propietario, String identificadorTributario) {
		setNombre(nombre);
		setPropietario(propietario);
		setIdentificadorTributario(identificadorTributario);
		computadores = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPropietario() {
		return propietario;
	}
	
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	public String getIdentificadorTributario() {
		return identificadorTributario;
	}
	
	public void setIdentificadorTributario(String identificadorTributario) {
		this.identificadorTributario = identificadorTributario;
	}
	
	public boolean esTiendaLlena() {
		return (computadores.size() == numeroComputadores);
	}
	
	public boolean esTiendaVacia() {
		return (computadores.isEmpty());
	}
	
	public void agregarComputador(Computador computador) {
		if (computador == null) {
			System.err.println("El computador no puede estar vacío");
			return; // Quizá se podría lanzar una excepción
		}
		if (esTiendaLlena()) {
			System.err.println("No se ha podido agregar el computador porque la tienda está llena");
			return;
		}
		computadores.add(computador);
		System.out.printf("Se ha agregado el computador de la marca %s%n", computador.getMarca());
	}
	
	public Computador buscarComputador(String marca) {
		if (marca == null || marca.isEmpty()) {
			System.err.println("La marca no puede estar vacía");
			return null; // Quizá se podría lanzar una excepción
		}
		Iterator<Computador> it = computadores.iterator();
		while (it.hasNext()) {
			Computador computador = it.next();
			if (computador.getMarca().equalsIgnoreCase(marca)) {
				return computador;
			}
		}
		return null; // Quizá se podría lanzar una excepción
	}

	public Computador buscarComputadorPorSistemaOperativo(String sistemaOperativo) {
		if (sistemaOperativo == null || sistemaOperativo.isEmpty()) {
			System.err.println("El sistema operativo no puede estar vacío");
			return null; // Quizá se podría lanzar una excepción
		}
		Iterator<Computador> it = computadores.iterator();
		while (it.hasNext()) {
			Computador computador = it.next();
			if (computador.getSistemaOperativo().equalsIgnoreCase(sistemaOperativo)) {
				return computador;
			}
		}
		return null; // Quizá se podría lanzar una excepción
	}
	
	public Computador buscarPorRangoPrecio(double min, double max) {
		if (min < 0 || max < 0 || min > max) {
			System.err.println("Los rangos son incorrectos");
			return null; // Quizá se podría lanzar una excepción
		}
		Iterator<Computador> it = computadores.iterator();
		while (it.hasNext()) {
			Computador computador = it.next();
			double precio = computador.getPrecio();
			if (precio >= min && precio <= max) {
				return computador;
			}
		}
		return null; // Quizá se podría lanzar una excepción
	}
	
	public void eliminarComputador(String marca) {
		if (marca == null || marca.isEmpty()) {
			System.err.println("La marca no puede estar vacía");
			return; // Quizá se podría lanzar una excepción
		}
		if (esTiendaVacia()) {
			System.err.println("No se ha podido agregar el computador porque la tienda está vacía");
			return; // Quizá se podría lanzar una excepción
		}
		Computador computador = buscarComputador(marca);
		if (computador == null) {
			System.err.printf("Se ha eliminado el computador de la marca %s%n", marca);
			return; // Quizá se podría lanzar una excepción
		}
		computadores.remove(computador);
		System.out.printf("Se ha eliminado el computador de la marca %s%n", computador.getMarca());
	}
	
	@Override
	public String toString() {
		return (String.format("""
				Nombre: %s
				Propietario: %s
				Identificador tributario: %s
				Número total de computadores: %d
				""", nombre, propietario, identificadorTributario, computadores.size()));
	}
	
	public void mostrarDatos() {
		System.out.println(this);
		
		System.out.println("Lista de computadores:");
		for (Computador computador : computadores) {
			System.out.println(computador);
		}
	}
}
