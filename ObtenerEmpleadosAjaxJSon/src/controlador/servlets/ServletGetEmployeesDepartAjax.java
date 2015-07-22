package controlador.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dominio.dto.Employees;
import modelo.persistencia.dao.EmpleadoHibernateDAO;
import modelo.services.EmpleadoService;

@SuppressWarnings("serial")
public class ServletGetEmployeesDepartAjax extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String eleccion = request.getParameter("eleccion");
		EmpleadoService es = new EmpleadoService(new EmpleadoHibernateDAO());
		List<Employees> lista_emple = es.getListEmpleadosDepart(eleccion);
		PrintWriter out = response.getWriter();
		
		int n_empleados = lista_emple.size();

		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<empleados>");
		for (int i = 0; i < n_empleados; i++) {
			out.println("<empleado>"); 
			out.println("<empleadoid>" + lista_emple.get(i).getEmployeeId() + "</empleadoid>");
			out.println("<empleadoNom>" + lista_emple.get(i).getFirstName() + "</empleadoNom>");
			out.println("</empleado>"); 
		}
		out.println("</empleados>");
	}

}
