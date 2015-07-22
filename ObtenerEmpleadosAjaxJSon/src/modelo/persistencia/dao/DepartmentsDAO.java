package modelo.persistencia.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.connection.SessionManager;
import modelo.crud.Crud;
import modelo.dominio.dto.Departments;
import modelo.persistencia.querys.SQL;

public class DepartmentsDAO implements Crud {

	@SuppressWarnings("unchecked")
	public List<Departments> getDepartmentsList() {
		Session session = SessionManager.getNewSesion();
		List<Departments> listaDepartamentos = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			listaDepartamentos = session.createSQLQuery(SQL.GETLISTDEPARTMENTS)
					.addEntity(Departments.class).list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			SessionManager.cerrarSession(session);
		}
		return listaDepartamentos;
	}

}
