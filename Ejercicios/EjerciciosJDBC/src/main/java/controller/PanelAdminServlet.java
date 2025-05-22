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

import config.Env;
import dao.UsuarioDAO;
import db.Conexion;
import model.UsuarioModelo;

/**
 * Servlet implementation class PanelAdminServlet
 */
@WebServlet("/PanelAdminServlet")
public class PanelAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanelAdminServlet() {
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
		else if (!usuario.getRol().equals("admin")) {
			System.err.println("SUS " + usuario.getNombre());
			response.sendRedirect("403.jsp");
			return;
		}
		
		try (Connection conn = new Conexion().conectar("BaseDeDatos")) {		
			List<UsuarioModelo> usuarios = new UsuarioDAO(conn).buscar();
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("/WEB-INF/view/panel_admin.jsp").forward(request, response);
			return;
		}
		catch (Exception e) {
			System.err.println("PanelAdminServlet: No se ha podido conectar a la base de datos: " + e.getMessage());
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
