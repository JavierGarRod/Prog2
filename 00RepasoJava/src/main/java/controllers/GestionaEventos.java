package controllers;

import exceptions.CraftersException;
import models.Conciertos;
import models.EstadoEvento;
import models.EventosDeportivos;

public class GestionaEventos {

	public static void main(String[] args) throws CraftersException {
		EventosDeportivos ed1=new EventosDeportivos(500, 600);
		
		Conciertos c1=new Conciertos(200, 500, EstadoEvento.APLAZADO);
		System.out.println(c1.getPorcentajeOcupacion2(50));
		c1.modificaEstado(EstadoEvento.PROGRAMADO);
		System.out.println(c1.getEstado());
		
		Conciertos c2=new Conciertos(500, 500);
		try {
			c2.getPorcentajeOcupacion2(20);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
