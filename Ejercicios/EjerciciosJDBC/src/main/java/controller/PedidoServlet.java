package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

import config.Env;
import dao.ProductoDAO;
import dao.PedidoDAO;
import model.ProductoModelo;
import model.UsuarioModelo;
import model.PedidoModelo;
import model.PedidoProductoModelo;
import db.Conexion;

/**
 * Servlet implementation class PedidoServlet
 */
@WebServlet("/PedidoServlet")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private int obtenerCantidadProductos() {
    	int cantidad = 0;
		
		try (Connection conn = new Conexion().conectar("BaseDeDatos")) {			
			cantidad = new ProductoDAO(conn).obtenerCantidad();
		}
		catch (Exception e) {
			System.err.println("PedidoServlet.obtenerCantidadProductos: No se ha podido conectar a la base de datos: " + e.getMessage());
		}
    	return cantidad;
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion == null) {
			response.sendRedirect("401.jsp");
			return;
		}
		UsuarioModelo usuario = (UsuarioModelo)sesion.getAttribute("user");
		int cantidadProductos = obtenerCantidadProductos();

		List<PedidoProductoModelo> pedidoProductos = new ArrayList<>();
		for (int i = 1; i <= cantidadProductos; ++i) {
			String cantidadString = request.getParameter("id-" + i);
			String nombre = request.getParameter("name-" + i);
			String precioString = request.getParameter("price-" + i);
			if (cantidadString == null || nombre == null || precioString == null
					|| cantidadString.isBlank() || nombre.isBlank() || precioString.isBlank()) {
				continue;
			}
			int cantidad = Integer.parseInt(cantidadString);
			if (cantidad == 0) {
				continue;
			}
			double precio = Double.parseDouble(precioString);
			pedidoProductos.add(new PedidoProductoModelo(new ProductoModelo(i, nombre, precio), cantidad));
		}
		
		try (Connection conn = new Conexion().conectar("BaseDeDatos")) {		
			try {				
				PedidoModelo pedido = new PedidoDAO(conn).crear(usuario, pedidoProductos);
				request.setAttribute("pedido", pedido);
				request.getRequestDispatcher("WEB-INF/view/menu_pedido.jsp").forward(request, response);
				return;
			}
			catch (Exception e) {
				System.err.println("PedidoServlet: No se ha podido obtener el pedido: " + e.getMessage());
			}
		}
		catch (Exception e) {
			System.err.println("PedidoServlet: No se ha podido conectar a la base de datos: " + e.getMessage());
		}
		response.sendRedirect("500.jsp");
	}

}
