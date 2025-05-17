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
import dao.UsuarioDAO;
import db.Conexion;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		if (accion == null || accion.isBlank()) {
			request.getRequestDispatcher("PanelAdminServlet").forward(request, response);
			return;
		}
		
		Integer id = null;
		if (!accion.equals("create")) {
			String idString = request.getParameter("id");
			if (!accion.equals("read")) {
				if (idString == null || idString.isBlank()) {
					request.getRequestDispatcher("PanelAdminServlet").forward(request, response);
					return;
				}
			}
			if (idString != null && !idString.isBlank()) {
				try {			
					id = Integer.parseInt(idString);
				}
				catch (Exception e) {
					request.setAttribute("error", "El id tiene que ser un número");
					request.getRequestDispatcher("WEB-INF/view/panel_admin.jsp").forward(request, response);
					return;
				}
			}
		}
		
		Env env = new Env();
		Conexion conexion = new Conexion(env.getDBUsuario(), env.getDBContraseña());
		try (Connection conn = conexion.conectar("BaseDeDatos")) {
			UsuarioDAO dao = new UsuarioDAO(conn);
			if (accion.equals("create")) {				
				request.getRequestDispatcher("WEB-INF/view/usuario_crear.jsp").forward(request, response);
				return;
			}
			else if (accion.equals("read")) {
				String nombre = request.getParameter("name");
				String rol = request.getParameter("role");
				List<UsuarioModelo> usuarios = dao.buscar(id, nombre, rol);
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("WEB-INF/view/panel_admin.jsp").forward(request, response);
				return;
			}
			else if (accion.equals("update")) {
				String nombre = request.getParameter("name");
				String rol = request.getParameter("role");
				request.setAttribute("user", new UsuarioModelo(id, nombre, rol));
				request.getRequestDispatcher("WEB-INF/view/usuario_actualizar.jsp").forward(request, response);
				return;
			}
			else if (accion.equals("delete")) {
				HttpSession sesion = request.getSession(false);
				if (sesion == null) {
					response.sendRedirect("401.jsp");
					return;
				}
				UsuarioModelo usuario = (UsuarioModelo)sesion.getAttribute("user");
				if (usuario.getId().equals(id)) {
					request.setAttribute("error", "No puedes eliminarte a ti mismo");
				}
				else {					
					dao.eliminar(id);
				}
				request.getRequestDispatcher("PanelAdminServlet").forward(request, response);
				return;
			}
		}
		catch (Exception e) {
			System.err.println("UsuarioServlet: No se ha podido conectar a la base de datos: " + e.getMessage());
		}
		response.sendRedirect("500.jsp");
	}
}
