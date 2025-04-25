package cuestionario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CuestionarioServlet
 */
@WebServlet("/CuestionarioServlet")
public class CuestionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuestionarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int resultado = 0;
    	for (int i = 1;; ++i) {
    		String idString = request.getParameter("" + i);
    		if (idString == null) {
    			break;
    		}
    		int id = Integer.parseInt(idString);
    		if (id == 1) {    			
    			resultado++;
    		}
    	}
    	String mensaje;
    	String url;
    	if (resultado >= 5) {   
    		String[] mensajes = {
    				String.format("Locura, un %d", resultado),
    				String.format("Increíble, has sacado un %d", resultado),
    		};
    		int index = (int)(Math.random() * mensajes.length);
    		mensaje = mensajes[index];
    		url = "chopper-happy.gif";
    	}
    	else {
    		String[] mensajes = {
    				String.format("Bueno, un %d, no es el fin del mundo", resultado),
    				String.format("Pues un %d, la próxima irá mejor", resultado),
    		};
    		int index = (int)(Math.random() * mensajes.length);
    		mensaje = mensajes[index];
    		url = "chopper-crying.gif";
    	}
    	request.setAttribute("mensaje", mensaje);
    	request.setAttribute("resultado", resultado);
    	request.setAttribute("url", url);
    	request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}

}
