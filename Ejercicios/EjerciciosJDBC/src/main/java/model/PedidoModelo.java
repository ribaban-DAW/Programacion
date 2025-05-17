package model;

import java.util.List;

public class PedidoModelo {
	private Integer id;
	private UsuarioModelo usuario;
	private List<PedidoProductoModelo> pedidoProductos;
	
	public PedidoModelo(Integer id, UsuarioModelo usuario, List<PedidoProductoModelo> pedidoProductos) {
		setId(id);
		setUsuario(usuario);
		setPedidoProductos(pedidoProductos);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioModelo getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModelo usuario) {
		this.usuario = usuario;
	}

	public List<PedidoProductoModelo> getPedidoProductos() {
		return pedidoProductos;
	}

	public void setPedidoProductos(List<PedidoProductoModelo> pedidoProductos) {
		this.pedidoProductos = pedidoProductos;
	}

}
