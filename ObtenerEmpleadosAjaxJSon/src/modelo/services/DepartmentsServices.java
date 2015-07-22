package modelo.services;

import java.util.List;

import modelo.crud.Crud;
import modelo.dominio.dto.Departments;
import modelo.persistencia.dao.DepartmentsDAO;

public class DepartmentsServices {

	private DepartmentsDAO departmentDAO;

	public DepartmentsServices(Crud recuperarDao) {
		this.departmentDAO = (DepartmentsDAO) recuperarDao;
	}

	public List<Departments> getDepartmentsList() {
		return this.departmentDAO.getDepartmentsList();
	}

}
