package controlador.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.dominio.dto.DetalleEmpleado;
import modelo.dominio.dto.Employees;
import modelo.persistencia.dao.EmpleadoHibernateDAO;
import modelo.services.EmpleadoService;

@SuppressWarnings("serial")
public class ServletObtenerDetallesEmpleadoJson extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		int trabajador = Integer.parseInt(req.getParameter("trabajador"));
		EmpleadoService es = new EmpleadoService(new EmpleadoHibernateDAO());
		Employees empleado = es.leerEmpeladoService(trabajador);
		DetalleEmpleado detalle = new DetalleEmpleado(empleado.getFirstName(), empleado.getLastName(), empleado.getPhoneNumber(), empleado.getEmail());
		Gson gson = new Gson();
		String empleadoJSON = gson.toJson(detalle);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(empleadoJSON);
	}
	
}
