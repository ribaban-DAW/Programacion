package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UsuarioModelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import config.Env;
import dao.UsuarioDAO;
import db.Conexion;

/**
 * Servlet implementation class UsuarioCrearServlet
 */
@WebServlet("/UsuarioCrearServlet")
public class UsuarioCrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioCrearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("name");
		String contraseña = request.getParameter("pass");
		String rol = request.getParameter("role");
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		if (nombre == null || contraseña == null || rol == null
			|| nombre.isBlank() || contraseña.isBlank() || rol.isBlank()) {
			out.print("""
					{
						\"status\": 400,
						\"message\": \"No se ha recibido correctamente algún campo\"
					}
					""");
			out.flush();
			return;
		}
		
		Env env = new Env();
		Conexion conexion = new Conexion(env.getDBUsuario(), env.getDBContraseña());
		try (Connection conn = conexion.conectar("BaseDeDatos")) {
			UsuarioDAO dao = new UsuarioDAO(conn);
			if (dao.buscarExacto(nombre) != null) {
				out.print("""
						{
							\"status\": 400,
							\"message\": \"El nombre ya existe\"
						}
						""");
			}
			else {
				dao.crear(new UsuarioModelo(null, nombre, rol), contraseña);
				out.print("""
						{\"status\": 200,
						\"redirect\": \"PanelAdminServlet\"
						}
						""");
			}
			out.flush();
		}
		catch (Exception e) {
			System.err.println("UsuarioCrearServlet: No se ha podido conectar a la base de datos: " + e.getMessage());
		}
	}

}
