package modelo.persistencia.dao;


import java.util.List;

import modelo.connection.SessionManager;
import modelo.crud.Crud;
import modelo.dominio.dto.Employees;
import modelo.persistencia.querys.SQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpleadoHibernateDAO implements Crud {

	public Employees leerEmpleado(int idEmpleado) {
		SessionFactory sessionFactory = SessionManager.getSessionFactory();
		Session s = sessionFactory.openSession();
		Employees emp = null;
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			emp = (Employees) s.get(Employees.class, idEmpleado);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			SessionManager.cerrarSession(s);
		}
		return emp;
	}

	public int comprobarLogin(String username, String password) {
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<Employees> getListEmpleadosDepart(String eleccion) {
		SessionFactory sessionFactory = SessionManager.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Employees> lista = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			lista = session.createSQLQuery(SQL.GETLISTEMPLOYEES + "'"+ eleccion + "')").addEntity(Employees.class).list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			SessionManager.cerrarSession(session);
		}
		return lista;
	}

}
