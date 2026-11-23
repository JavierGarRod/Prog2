package TEMA2.Boletin4.Ej1;

public class ContadorHilo extends Thread{
	private ContadorVocales cont;
	private String texto;
	private char vocal;
	private int numVocales;
	
	
	public ContadorHilo(String texto, char vocal, ContadorVocales c) {
		this.texto = texto;
		this.vocal = vocal;
		this.cont=c;
	}


	@Override
	public void run() {
		int indice=0;
		
		while(indice<texto.length()) {
			char caracterActual=Character.toLowerCase(texto.charAt(indice));
			if(caracterActual==vocal) {
				numVocales+=1;
			}
			
			indice+=1;
		}
		
		cont.sumarVocales(numVocales);
	}
	
	
}
