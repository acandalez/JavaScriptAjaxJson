package controlador.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext cnt = sce.getServletContext();
		HashMap<String, HttpSession> sesiones = new HashMap<String, HttpSession>();
		cnt.setAttribute("sesiones", sesiones);
	}

}
