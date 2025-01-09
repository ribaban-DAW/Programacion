package Concensionario;

public abstract class Vehiculo {
	private String marca;
	private String modelo;
	private int año;
	private Combustible tipoCombustible;
	
	public Vehiculo(String marca, String modelo, int año, Combustible tipoCombustible) throws IllegalArgumentException {
		if (tipoCombustible == null || marca == null || modelo == null) {
			throw new IllegalArgumentException("No puede haber argumentos nulos");
		}
		if (marca.isEmpty() || modelo.isEmpty()) {
			throw new IllegalArgumentException("Ningún campo puede estar vacío");
		}
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.tipoCombustible = tipoCombustible;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public int getAño() {
		return this.año;
	}
	
	public Combustible getTipoCombustible() {
		return this.tipoCombustible;
	}
	
	public abstract void mostrarInformacion();
}