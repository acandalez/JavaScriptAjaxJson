package controlador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletGetEmployeesDepart extends HttpServlet {

	/**
	 * Este servlet recupera la elección de departamentos.jsp en un String y lo settea en la
	 * request con el nombre de depart.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String eleccion = req.getParameter("eleccion");
		req.setAttribute("depart", eleccion);
		req.getRequestDispatcher("ListaEmlpesDepart.jsp").forward(req, resp);
	}
}
