package Concensionario;

public class Main {
	public static void main(String[] args) {
		Concesionario c = new Concesionario();
		c.registrarVehiculo(new Auto("Toyota", "Corolla", 2020, Combustible.GASOLINA, 4));
		c.registrarVehiculo(new Moto("Yamaha", "R3", 2019, Combustible.GASOLINA, 321));
		c.registrarVehiculo(new Auto("Tesla", "Model 3", 2023, Combustible.ELECTRICO, 4));
		c.listarVehiculos();
		c.filtrarPorCombustible(Combustible.GASOLINA);	
		
		// vehículo nulo
		try {
			c.registrarVehiculo(null);
		}
		catch (Exception e) { 
			System.err.println(e.getMessage());
		}
		
		// Primer campo vacío
		try {
			c.registrarVehiculo(new Auto("", "Model 3", 2023, Combustible.ELECTRICO, 4));
		}
		catch (Exception e) { 
			System.err.println(e.getMessage());
		}
		
		// Segundo campo vacío
		try {
			c.registrarVehiculo(new Auto("hola", "", 2023, Combustible.ELECTRICO, 4));
		}
		catch (Exception e) { 
			System.err.println(e.getMessage());
		}
		
		// Marca null
		try {
			c.registrarVehiculo(new Auto(null, "adios", 2023, Combustible.GASOLINA, 4));
		}
		catch (Exception e) { 
			System.err.println(e.getMessage());
		}
		
		
		// Modelo null
		try {
			c.registrarVehiculo(new Auto("hola", null, 2023, Combustible.GASOLINA, 4));
		}
		catch (Exception e) { 
			System.err.println(e.getMessage());
		}
		
		
		// Combustible null
		try {
			c.registrarVehiculo(new Auto("hola", "adios", 2023, Combustible.GASOLINA, 4));
		}
		catch (Exception e) { 
			System.err.println(e.getMessage());
		}		
	}
}
