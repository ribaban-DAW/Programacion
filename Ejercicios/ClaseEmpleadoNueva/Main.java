package ClaseEmpleadoNueva;

public class Main {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		
		empresa.agregarPersona(new Cliente("El cliente", 25, "123456789"));
		Empleado empleado = new Empleado("El empleado", 28, 1578.50);
		empresa.agregarPersona(empleado);
		Empleado empleado2 = new Empleado("El empleado 2", 20, 1200);
		empresa.agregarPersona(empleado2);
		
		Directivo directivo = new Directivo("El directivo", 30, 1800, "Gran categoría");
		directivo.agregarSubordinado(empleado);
		directivo.agregarSubordinado(empleado2);
		empresa.agregarPersona(directivo);
		
		empresa.mostrarInformacion();
	}
}
