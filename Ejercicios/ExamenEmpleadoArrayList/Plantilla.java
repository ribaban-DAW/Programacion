package ExamenEmpleadoArrayList;

import java.util.*;

public class Plantilla {
	private List<Empleado> empleados;

	public Plantilla() {
		empleados = new ArrayList<>();
	}

	public void contratarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}

	public List<Empleado> getEmpleadoPorNombre(String filtroNombre) {
		List<Empleado> listaEmpleados = new ArrayList<>();
		for (Empleado e: empleados) {
			if (e.getNombre().contains(filtroNombre) || e.getApellidos().contains(filtroNombre)) {
				listaEmpleados.add(e);
			}
		}
		return listaEmpleados;
	}
}