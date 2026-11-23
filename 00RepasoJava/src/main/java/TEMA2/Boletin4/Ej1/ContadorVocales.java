package TEMA2.Boletin4.Ej1;

import java.util.Scanner;

public class ContadorVocales{
	private int vocalesTotales;

	public ContadorVocales() {
		this.vocalesTotales = 0;
	}
	
	public synchronized void sumarVocales(int cantidad) {
		this.vocalesTotales=this.vocalesTotales+cantidad;
	}
	
	public synchronized int getVocalesTotales() {
		return this.vocalesTotales;
	}
}
