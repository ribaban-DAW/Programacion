package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UsuarioModelo;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import config.Env;
import db.Conexion;
import dao.ProductoDAO;
import model.ProductoModelo;

/**
 * Servlet implementation class MenuProductoServlet
 */
@WebServlet("/MenuProductoServlet")
public class MenuProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion == null) {
			response.sendRedirect("401.jsp");
			return;
		}
		UsuarioModelo usuario = (UsuarioModelo)sesion.getAttribute("user");
		if (usuario == null) {
			response.sendRedirect("401.jsp");
			return;
		}
		
		Env env = new Env();
		Conexion conexion = new Conexion(env.getDBUsuario(), env.getDBContraseña());
		try (Connection conn = conexion.conectar("BaseDeDatos")) {			
			List<ProductoModelo> productos = new ProductoDAO(conn).buscar();
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("WEB-INF/view/menu_producto.jsp").forward(request, response);
			return;
		}
		catch (Exception e) {
			System.err.println("MenuProductoServlet: No se ha podido conectar a la base de datos: " + e.getMessage());
		}
		response.sendRedirect("500.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
