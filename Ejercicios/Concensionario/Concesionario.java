package Concensionario;

public class Concesionario {
	private static final int CAPACIDAD_MAXIMA = 10;
	private Vehiculo vehiculos[];
	private int contadorVehiculos;
	
	
	public Concesionario() {
		vehiculos = new Vehiculo[CAPACIDAD_MAXIMA];
		contadorVehiculos = 0;
	}
	
	public void registrarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
		if (vehiculo == null) {
			throw new IllegalArgumentException("El vehículo no puede ser nulo");
		}
		if (contadorVehiculos >= CAPACIDAD_MAXIMA) {
			System.err.printf("No se puede registrar el vehículo %s %s, porque se ha alcanzado la capacidad máxima%n", vehiculo.getMarca(), vehiculo.getModelo());
			return;
		}
		vehiculos[contadorVehiculos] = vehiculo;
		++contadorVehiculos;
		System.out.printf("Vehículo registrado exitosamente: %s %s%n", vehiculo.getMarca(), vehiculo.getModelo());
	}
	
	public void listarVehiculos() {
		System.out.println("Lista de vehículos en el concesionario:");
		for (Vehiculo v : vehiculos) {
			if (v == null) {
				return;
			}
			v.mostrarInformacion();
		}
	}
	
	public void filtrarPorCombustible(Combustible combustible) {
		System.out.println("Vehículos con combustible: " + combustible);
		for (Vehiculo v: vehiculos) {
			if (v != null && v.getTipoCombustible() == combustible) {
				v.mostrarInformacion();
			}
		}
	}
}
