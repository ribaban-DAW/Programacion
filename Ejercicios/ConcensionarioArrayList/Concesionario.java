package ConcensionarioArrayList;

import java.util.*;

public class Concesionario {
	private List<Vehiculo> vehiculos;

	public Concesionario() {
		vehiculos = new ArrayList<Vehiculo>();
	}
	
	public void registrarVehiculo(Vehiculo vehiculo) throws IllegalArgumentException {
		if (vehiculo == null) {
			throw new IllegalArgumentException("El vehículo no puede ser nulo");
		}
		vehiculos.add(vehiculo);
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
