package modelo.services;

import java.util.List;

import modelo.crud.Crud;
import modelo.dominio.dto.Employees;
import modelo.persistencia.dao.EmpleadoHibernateDAO;

public class EmpleadoService {

	private EmpleadoHibernateDAO empeDAO;

	public  EmpleadoService(Crud recuperarDao) {
		this.empeDAO = (EmpleadoHibernateDAO) recuperarDao;
	}

	public Employees leerEmpeladoService(int numeroEmpleado) {
		return this.empeDAO.leerEmpleado(numeroEmpleado);
	}

	public int comprobarLogin(String username, String password) {
		return this.empeDAO.comprobarLogin(username, password);
	}

	public List<Employees> getListEmpleadosDepart(String eleccion) {
		return this.empeDAO.getListEmpleadosDepart(eleccion);
	}

}