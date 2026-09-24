package ejRepaso1.Exceptions;

public class CraftersException extends Exception{
	
	public CraftersException(String string) {
		System.out.println("No es posible construir un evento con esos datos");
	}

}  
