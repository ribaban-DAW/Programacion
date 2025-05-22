package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UsuarioModelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import config.Env;
import dao.UsuarioDAO;
import db.Conexion;

/**
 * Servlet implementation class UsuarioActualizarServlet
 */
@WebServlet("/UsuarioActualizarServlet")
public class UsuarioActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioActualizarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		String nombre = request.getParameter("name");
		String rol = request.getParameter("role");
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		if (idString == null || nombre == null || rol == null
			|| idString.isBlank() || nombre.isBlank() || rol.isBlank()) {
			out.print("""
					{
						\"status\": 400,
						\"message\": \"No se ha recibido correctamente algún campo\"
					}
					""");
			out.flush();
			return;
		}
		
		int id = Integer.parseInt(idString);
		
		{
			HttpSession sesion = request.getSession(false);
			if (sesion == null) {
				out.print("""
						{
							\"status\": 401,
							\"redirect\": \"401.jsp\"
						}
						""");
				out.flush();
				return;
			}
			UsuarioModelo usuario = (UsuarioModelo)sesion.getAttribute("user");
			if (usuario.getId().equals(id) && !rol.equals(usuario.getRol())) {
				out.print("""
						{
							\"status\": 400,
							\"message\": \"No puedes cambiarte de rol a ti mismo\"
						}
						""");
				out.flush();
				return;
			}
		}
		
		try (Connection conn = new Conexion().conectar("BaseDeDatos")) {
			UsuarioDAO dao = new UsuarioDAO(conn);
			UsuarioModelo usuario = dao.buscar(id);
			UsuarioModelo existe = dao.buscarExacto(nombre);
			if (existe == null || existe.getId().equals(usuario.getId())) {
				String contraseñaAntigua = request.getParameter("old-pass");
				String contraseñaNueva = request.getParameter("new-pass");
				if ((contraseñaAntigua == null || contraseñaAntigua.isBlank())
					&& (contraseñaNueva == null || contraseñaNueva.isBlank())) {					
					dao.actualizar(new UsuarioModelo(id, nombre, rol));
					out.print("""
						{\"status\": 200,
						\"redirect\": \"PanelAdminServlet\"
						}
						""");
				}
				else if (dao.autenticar(usuario.getNombre(), contraseñaAntigua) != null) {
					if (contraseñaNueva == null || contraseñaNueva.isBlank()) {
						out.print("""
								{
									\"status\": 400,
									\"message\": \"La contraseña nueva no es válida\"
								}
								""");
					}
					else {
						dao.actualizar(new UsuarioModelo(id, nombre, rol), contraseñaNueva);
						out.print("""
								{\"status\": 200,
								\"redirect\": \"PanelAdminServlet\"
								}
								""");
					}
				}
				else {
					out.print("""
							{
								\"status\": 400,
								\"message\": \"Usuario o contraseña incorrectos\"
							}
							""");
				}
			}
			else {
				out.print("""
						{
							\"status\": 400,
							\"message\": \"El nombre ya existe\"
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
			System.err.println("UsuarioActualizarServlet: No se ha podido conectar a la base de datos: " + e.getMessage());
		}
	}
}
