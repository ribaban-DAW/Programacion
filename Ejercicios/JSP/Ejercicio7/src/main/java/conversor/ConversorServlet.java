package conversor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ConversorServlet
 */
@WebServlet("/ConversorServlet")
public class ConversorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConversorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String precioString = request.getParameter("cantidad");
		String tipo = request.getParameter("tipo");
		
		double resultado;
		String simbolo;
		
		double precio = Double.parseDouble(precioString);
		if (tipo.equals("euros")) {
			resultado = Conversor.aEuros(precio);
			simbolo = "€";
		}
		else {
			resultado = Conversor.aPesetas(precio);
			simbolo = "₧";
		}
		response.getWriter().write(String.format("%.2f %s", resultado, simbolo));
	}

}
