package modelo.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;



public class Pool {

	private static final String fuente = "java:comp/env/jdbc/pool";
	private static DataSource fuenteDatos = null;;
	private static final Pool pool = new Pool();

	public static Pool getInstance() {
		return pool;
	}

	static{
		fuenteDatos = iniciarFuente();
	}

	private static DataSource iniciarFuente() {
		DataSource ds = null;

		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup(fuente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public static Connection getConnection() {
		Connection conexion = null;
		try {
			conexion = fuenteDatos.getConnection();
			// fuenteDatos.
		} catch (Exception e) {
			// log.error("Imposible obtener conexión a la base de datos");
		}
		return conexion;
	}

	public static void liberarRecursos(Connection conexion, Statement st,
			ResultSet rs) {

		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void liberarRecursos(Connection conexion, Statement st) {

		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
