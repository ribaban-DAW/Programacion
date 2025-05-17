package model;

public class PedidoProductoModelo {
	private ProductoModelo producto;
	private int cantidad;
	
	public PedidoProductoModelo(ProductoModelo producto, int cantidad) {
		setProducto(producto);
		setCantidad(cantidad);
	}
	
	public ProductoModelo getProducto() {
		return producto;
	}
	public void setProducto(ProductoModelo producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double calcularSubtotal() {
		return cantidad * producto.getPrecio();
	}
}
