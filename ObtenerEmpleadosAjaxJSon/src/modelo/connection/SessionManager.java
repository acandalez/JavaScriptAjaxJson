package modelo.connection;



import logger.Registrar_Logs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Esta clase carga la configuración de hibernate, además gestiona las sessiones
 * y la sessionFactory.
 * 
 * @author Juanjors
 */

public class SessionManager {

	private static SessionFactory sessionFactory = null;

	/**
	 * Este 'método' se ejecuta cuando alguna referencia de esta clase es
	 * llamada desde cualquier otro sitio del programa Carga la configuración
	 * del archivo hibernate.cfg.xml y lo asigna a sesionFactory
	 */
	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		Registrar_Logs.log.trace("Configuración cargada");
	}

	/**
	 * Devolvemos una Session de Hibernate abierta
	 * 
	 * @return Session (Una session abierta)
	 */
	public static Session getNewSesion() {
		return sessionFactory.openSession();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	/**
	 * Este método cierra la SessiónFactory (Se debe ejectuar al finalizar la
	 * aplicación).
	 * 
	 * @return boolean si se cierra o no correctamente.
	 */

	public static boolean cerrarFactory() {
		boolean ok = false;
		try {
			sessionFactory.close();
			ok = true;
		} catch (Exception e) {
			Registrar_Logs.log.error("Error al cerrar Factory");
			ok = false;
			e.printStackTrace();
		}
		return ok;
	}

	/**
	 * Cierra la Session parametrizada.
	 * 
	 * @param Session
	 * @return boolean si se cierra o no correctamente.
	 */
	public static boolean cerrarSession(Session s) {
		boolean ok = false;
		try {
			s.close();
			ok = true;
		} catch (Exception e) {
			e.printStackTrace();
			Registrar_Logs.log.error("Error al cerrar Session");
		}
		return ok;
	}
	

}