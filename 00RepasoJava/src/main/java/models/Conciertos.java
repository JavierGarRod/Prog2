package models;

import java.time.LocalDate;

import exceptions.CraftersException;

public class Conciertos extends Evento{

	
	public Conciertos(int id, String nombre, LocalDate fecha, int numEntradasVendidas, int capMax, EstadoEvento estado)
			throws CraftersException {
		super(id, nombre, fecha, numEntradasVendidas, capMax, estado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularCosteBase() {
		// TODO Auto-generated method stub
		return 0;
	}

}
