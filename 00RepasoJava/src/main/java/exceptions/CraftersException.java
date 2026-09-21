package exceptions;

public class CraftersException extends Exception{
	public CraftersException() {
		System.out.println("No es posible construir un evento con esos datos");
	}

}
