package models;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.CraftersException;

public class Conciertos extends Evento{

	private String artistaPrincipal;
	private String[] artistasInvitados;
	

	public Conciertos(int numEntradasVendidas, int capMax, EstadoEvento estado,
			String artistaPrincipal) throws CraftersException {
		super(numEntradasVendidas, capMax, estado);
		this.artistaPrincipal = artistaPrincipal;
		this.artistasInvitados = new String[10];
	}

	public Conciertos(int numEntradasVendidas, int capMax, EstadoEvento estado) throws CraftersException {
		super(numEntradasVendidas, capMax, estado);
	}

	public Conciertos(int numEntradasVendidas, int capMax) throws CraftersException {
		super(numEntradasVendidas, capMax);
	}

	
	public String getArtistaPrincipal() {
		return artistaPrincipal;
	}

	public void setArtistaPrincipal(String artistaPrincipal) {
		this.artistaPrincipal = artistaPrincipal;
	}

	public String[] getArtistasInvitados() {
		return artistasInvitados;
	}

	public void setArtistasInvitados(String[] artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}


	@Override
	public double calcularCosteBase() {
		double resultado=5000+2000+500*(artistasInvitados.length);
		return resultado;
	}

}
