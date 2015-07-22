package modelo.handlertag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import modelo.dominio.dto.Employees;
import modelo.persistencia.dao.EmpleadoHibernateDAO;
import modelo.services.EmpleadoService;

public class MostrarEmplesTag extends SimpleTagSupport {

	private String nombreDepart;

	@Override
	public void doTag() throws JspException, IOException {
		EmpleadoService es = new EmpleadoService(new EmpleadoHibernateDAO());
		List<Employees> employees_depart = es.getListEmpleadosDepart(this.nombreDepart);
		
		if(!(employees_depart.size() == 0)){
		getJspContext().getOut().println("<table border='1'><tr><th>Nombre</th><th>Apellido</th><th>Teléfono</th><th>Email</th></tr>");
		for (Employees employees : employees_depart) {
			getJspContext().getOut().println("<tr>");
			getJspContext().getOut().println("<td>" + employees.getFirstName() + "</td>");
			getJspContext().getOut().println("<td>" + employees.getLastName() + "</td>");
			getJspContext().getOut().println("<td>" + employees.getPhoneNumber() + "</td>");
			getJspContext().getOut().println("<td>" + employees.getEmail() + "</td>");
			getJspContext().getOut().println("</tr>");
		}
	 }else
		 getJspContext().getOut().println("Este departamento no contiene empleados!!");
	}

	public String getNombreDepart() {
		return nombreDepart;
	}

	public void setNombreDepart(String nombreDepart) {
		this.nombreDepart = nombreDepart;
	}
	
	
}
