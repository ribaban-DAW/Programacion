package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import model.PedidoModelo;
import model.PedidoProductoModelo;
import model.UsuarioModelo;

public class PedidoDAO {
	private Connection conexion;
	
	public PedidoDAO(Connection conexion) {
		setConexion(conexion);
	}
	
	public PedidoModelo crear(UsuarioModelo usuario, List<PedidoProductoModelo> pedidoProductos) throws SQLException {
		String queryPedido = """
				INSERT INTO Pedido(FK_UsuarioID)
				VALUES (?)
				""";
		conexion.setAutoCommit(false);
		try (PreparedStatement psPedido = conexion.prepareStatement(queryPedido, Statement.RETURN_GENERATED_KEYS)) {
			psPedido.setInt(1, usuario.getId());
			psPedido.execute();
			try (ResultSet rs = psPedido.getGeneratedKeys()) {
				if (rs.next()) {
					int id = rs.getInt(1);
					String queryPedidoProducto = """
							INSERT INTO Pedido_Producto(FK_PedidoID, FK_ProductoID, Cantidad)
							VALUES (?, ?, ?)
							""";
					try (PreparedStatement psPedidoProducto = conexion.prepareStatement(queryPedidoProducto)) {						
						for (PedidoProductoModelo pedidoProducto : pedidoProductos) {
							psPedidoProducto.setInt(1, id);
							psPedidoProducto.setInt(2, pedidoProducto.getProducto().getId());
							psPedidoProducto.setInt(3, pedidoProducto.getCantidad());
							psPedidoProducto.addBatch();
						}
						psPedidoProducto.executeBatch();
						return new PedidoModelo(id, usuario, pedidoProductos);
					}
				}
			}
		}
		catch (Exception e) {
			conexion.rollback();
			throw e;
		}
		finally {
			conexion.setAutoCommit(true);
		}
		return null;
	}

	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
