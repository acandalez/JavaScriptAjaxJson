package controlador.listeners;

import java.util.HashMap;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import static logger.Registrar_Logs.*;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestDestroyed");

	}

	@SuppressWarnings("unchecked")
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HashMap<String, HttpSession> sesiones = (HashMap<String, HttpSession>) sre
				.getServletContext().getAttribute("sesiones");

		System.out.println("RequestInit");
		log.info("El numero de sesiones activas es de: " + sesiones.size());

	}
}
