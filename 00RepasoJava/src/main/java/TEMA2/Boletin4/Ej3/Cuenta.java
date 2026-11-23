package TEMA2.Boletin4.Ej3;

public class Cuenta implements Runnable{
	private Double saldo;

	public Double retirarDinero(Double dineroRetirar) {
		if(dineroRetirar>=saldo) {
			saldo=saldo-dineroRetirar;
		} else {
			//exception
		}
		
		return saldo;
	}
	
	public Double ingresarDinero(Double dineroIngresar) {
		saldo=saldo+dineroIngresar;
		
		return saldo;
		
	}

	@Override
	public void run() {
		System.out.println("Saldo en la cuenta: "+saldo);
		
	}
}
