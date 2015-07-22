package controlador.listeners;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static logger.Registrar_Logs.*;


public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		log.info("Se ha creado una session con la id: " + hse.getSession().getId());
	
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		log.info("Se ha destruido la session con la id: " + hse.getSession().getId());
	
		
	}

}
