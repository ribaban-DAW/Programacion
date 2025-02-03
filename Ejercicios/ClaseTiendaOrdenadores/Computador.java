package ClaseTiendaOrdenadores;

//NOTA: Se podría añadir una comprobación en los setters para verificar que son válidos

public class Computador {
	private String marca;
	private int memoria;
	private String procesador;
	private String sistemaOperativo;
	private double precio;
	
	public Computador(String marca, int memoria, String procesador, String sistemaOperativo, double precio) {
		setMarca(marca);
		setMemoria(memoria);
		setProcesador(procesador);
		setSistemaOperativo(sistemaOperativo);
		setPrecio(precio);
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getMemoria() {
		return memoria;
	}
	
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	 
	public String getProcesador() {
		return procesador;
	}
	
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return String.format("""
				Marca: %s
				Memoria: %d GB
				Procesador: %s
				Sistema operativo: %s
				Precio: %.2f €""", marca, memoria, procesador, sistemaOperativo, precio);
	}
	
	public void mostrarDatos() {
		System.out.println(this);
	}
}
