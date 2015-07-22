package controlador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static logger.Registrar_Logs.*;

import modelo.persistencia.dao.DepartmentsDAO;
import modelo.services.DepartmentsServices;


/**
 * Este Servlet recupera la lista de todos los departamentos y los pasa a través de la request a 
 * departamentos.jsp utilizando forward.
 * @author Juanjors
 *
 */

@SuppressWarnings("serial")
public class ServletGetDepartmentsList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		DepartmentsServices ds = new DepartmentsServices(new DepartmentsDAO());
		request.setAttribute("departamentos", ds.getDepartmentsList());
		log.info("Lista de departamentos seteada en la request! ");
		request.getRequestDispatcher("departamentos.jsp").forward(request, resp);
	
	}
}
