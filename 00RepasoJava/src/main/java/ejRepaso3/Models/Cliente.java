package ejRepaso3.Models;

import java.util.Objects;

public class Cliente {
	private String nombre;
	private String correo;
	private String tlf;
	
	
	public Cliente(String nombre, String correo, String string) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.tlf = string;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(correo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(correo, other.correo);
	}


	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
