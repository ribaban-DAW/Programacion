package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import dao.UsuarioDAO;
import model.UsuarioModelo;
import db.Conexion;
import config.Env;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("username");
		String contraseña = request.getParameter("password");
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		if (nombre == null || contraseña == null || nombre.isBlank() || contraseña.isBlank()) {
			out.print("""
					{
						\"status\": 400,
						\"message\": \"Usuario o contraseña incorrectos\"
					}
					""");
			out.flush();
			return;
		}

		try (Connection conn = new Conexion().conectar("BaseDeDatos")) {			
			UsuarioModelo usuario = new UsuarioDAO(conn).autenticar(nombre, contraseña);
			if (usuario == null) {
				out.print("""
						{
							\"status\": 400,
							\"message\": \"Usuario o contraseña incorrectos\"
						}
						""");
				out.flush();
				return;
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", usuario);
			if (usuario.getRol().equals("admin")) {
				out.print("""
						{\"status\": 200,
						\"redirect\": \"PanelAdminServlet\"
						}
						""");
			}
			else if (usuario.getRol().equals("normal")) {
				out.print("""
						{
						\"status\": 200, 
						\"redirect\": \"MenuProductoServlet\"
						}
						""");
			}
			out.flush();
		}
		catch (Exception e) {
			out.print("""
					{
						\"status\": 500,
						\"redirect\": \"500.jsp\"
					}
					""");
			System.err.println("LoginServlet: No se ha podido conectar a la base de datos: " + e.getMessage());
		}
	}
}
