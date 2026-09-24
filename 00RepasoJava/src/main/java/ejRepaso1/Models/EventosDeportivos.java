package ejRepaso1.Models;

import java.time.LocalDate;

import ejRepaso1.Exceptions.CraftersException;

public class EventosDeportivos extends Evento{
	private boolean sonTelevisados;

	public EventosDeportivos(int numEntradasVendidas, int capMax,
			EstadoEvento estado, boolean sonTelevisados) throws CraftersException {
		super(numEntradasVendidas, capMax, estado);
		this.sonTelevisados = sonTelevisados;
	}
	
	

	public EventosDeportivos(int numEntradasVendidas, int capMax) throws CraftersException {
		super(numEntradasVendidas, capMax);
	}



	public boolean isSonTelevisados() {
		return sonTelevisados;
	}

	public void setSonTelevisados(boolean sonTelevisados) {
		this.sonTelevisados = sonTelevisados;
	}
	

	@Override
	public double calcularCosteBase() {
		double resultado=0;
		double alquiler=0;
		if(getCapMax()>3000) {
			alquiler=150000;
		}
		else {
			alquiler=75000;
		}
		if(sonTelevisados) {
			resultado=alquiler-10000;
		}
		else {
			resultado=alquiler;
		}
		
		return resultado;
	}

}
