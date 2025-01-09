package ExamenEmpleadoArray;

public class Plantilla {
	private Empleado[] empleados;

	public Plantilla(int x) throws IllegalArgumentException {
		if (x < 1) {
			throw new IllegalArgumentException("Error en la aplicación: La plantilla no puede ser inferior a 1.");
		}
		empleados = new Empleado[x];
	}

	public void contratarEmpleado(Empleado empleado) {
		// Itero sobre los empleados
		for (int i = 0; i < empleados.length; ++i) {
			// Si no hay un empleado asignado, lo asigno y termina el método
			if (empleados[i] == null) {
				empleados[i] = empleado;
				System.out.printf("Empleado contratado: %s %s%n", empleado.getNombre(), empleado.getApellidos());
				return;
			}
		}
		System.err.println("No se puede contratar más empleados. La plantilla está llena.");
	}

	public Empleado[] getEmpleadoPorNombre(String filtroNombre) {
		int indiceListaEmpleados = 0;
		// Precalculo el tamaño para reservarlo en el array
		for (int i = 0; i < empleados.length && empleados[i] != null; ++i) {
			if (empleados[i].getNombre().contains(filtroNombre) || empleados[i].getApellidos().contains(filtroNombre)) {
				++indiceListaEmpleados;
			}
		}

		// Me creo el array y guardo los empleados
		Empleado[] listaEmpleados = new Empleado[indiceListaEmpleados];
		indiceListaEmpleados = 0;
		for (int i = 0; i < empleados.length && empleados[i] != null; ++i) {
			if (empleados[i].getNombre().contains(filtroNombre) || empleados[i].getApellidos().contains(filtroNombre)) {
				listaEmpleados[indiceListaEmpleados] = empleados[i];
				++indiceListaEmpleados;
			}
		}
		return listaEmpleados;
	}
}
