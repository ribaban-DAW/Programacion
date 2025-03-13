package ExamenSegundaEvaluacion;

import java.util.*;
import java.util.stream.Collectors;

public class Flota {
	List<Vehiculo> vehiculos;
	
	public Flota() {
		vehiculos = new ArrayList<>();
	}
	
	// NOTA: Lo iba a hacer con un Optional<Vehiculo>, pero como me daba un pequeño
	// warning en el método eliminarVehiculo al intentar pasarle al remove un Optional,
	// así que he preferido devolver el vehículo o null si no lo encuentra.
	public Vehiculo buscarVehiculo(String matricula) {
		final String REGEX_MATRICULA = "^\\d{4}\\s[a-zA-Z]{3}$";
		// Si la matrícula no cumple con el REGEX, no va a existir ese vehículo
		// Esta comprobación ahorra iteraciones innecesarias.
		if (!matricula.matches(REGEX_MATRICULA)) {
			return null;
		}
		for (Vehiculo v : vehiculos) {
			if (v.getMatricula().equals(matricula)) {
				System.out.println(v); // Imprimo el vehículo para una mejor legibilidad en el main
				return v;
			}
		}
		System.err.println("No se ha podido encontrar el vehículo con matrícula \"" + matricula + "\"");
		return null;
	}
	
	// NOTA: Teniendo en cuenta que imprimo el mensaje de si la operación ha sido un éxito o no
	// devolver un true o false para comprobarlo es una *feature* que permite terminar la
	// ejecución en caso de que sea fallido con un if (!agregarVehiculo(...))
	public boolean agregarVehiculo(Vehiculo vehiculo) {
		for (Vehiculo v : vehiculos) {
			if (v.getMatricula().equals(vehiculo.getMatricula())) {
				System.err.println("No se ha podido añadir el vehículo con matrícula \"" + vehiculo.getMatricula() + "\" porque ya existe");
				return false;
			}
		}
		System.out.println("Se ha añadido el vehículo: " + vehiculo);
		return vehiculos.add(vehiculo);
	}
	
	// NOTA: Teniendo en cuenta que imprimo el mensaje de si la operación ha sido un éxito o no
	// devolver un true o false para comprobarlo es una *feature* que permite terminar la
	// ejecución en caso de que sea fallido con un if (!eliminarVehiculo(...))
	public boolean eliminarVehiculo(String matricula) {
		Vehiculo vehiculo = buscarVehiculo(matricula);
		if (vehiculo == null) {
			System.err.println("No se ha podido eliminar el vehículo con matrícula \"" + matricula + "\"");
			return false;
		}
		System.out.println("Se ha eliminado el vehículo con matrícula " + matricula);
		vehiculos.remove(vehiculo);
		return true;
	}
	
	public List<String> obtenerMatriculasDeUnAnio(int anio) {
		final int ANIO_VALIDO = 1800;
		if (anio < ANIO_VALIDO) {
			System.err.println("El año no puede ser previo a " + ANIO_VALIDO);
		}
		return vehiculos.stream()											// Lo convierto en Stream
						.filter(v -> v.getAnioFabricacion() == anio)		// Filtro por vehículos que sean del año proporcionado
						.map(Vehiculo::getMatricula)						// Aplico la referencia a método para obtener las matrículas
						.collect(Collectors.toCollection(ArrayList::new));	// Lo recolecto y lo convierto en un ArrayList
	}
	
	public double calcularPrecioMedioTotal(int dias) {
		// Si el día es menor que uno, se sale prematuramente para evitar iteraciones
		// innecesarias.
		if (dias < 1) {
			System.err.println("El alquiler debe ser de al menos un día");
			return 0;
		}
		if (vehiculos.size() == 0) {
			System.err.println("No se ha podido calcular el precio medio porque no hay vehículos en la flota");
			return 0;
		}
		return vehiculos.stream()											// Lo convierto en Stream
						.mapToDouble(v -> v.calcularPrecioAlquiler(dias))	// Calculo el precio del alquiler
						.sum()												// Los sumo
						/ vehiculos.size();									// Lo divido entre el número de vehículos que hay en la flota para obtener la media
	}
}
