package ejRepaso1.Controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ejRepaso1.Exceptions.CraftersException;
import ejRepaso1.Models.Conciertos;


public class GestionaEvento {
	private static final Logger logger = LogManager.getLogger(GestionaEvento.class);
	
	public static void main(String[] args) {
		logger.debug("Empieza main");
		Conciertos e = null;  
		try {
			e = new Conciertos(1,100);
			throw new CraftersException("Lanzo excepción");
		} catch (CraftersException e1) {
			logger.error("Error en el main: "+e1.getMessage());
		}
		logger.debug("Acaba");
	}
}
