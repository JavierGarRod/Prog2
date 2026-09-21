package models;

import java.time.LocalDate;
import java.util.Objects;

import exceptions.CraftersException;

public abstract class Evento {
	private int id;
	private String nombre;
	LocalDate fecha;
	private int numEntradasVendidas;
	private int capMax;
	EstadoEvento estado;
	
	
	public Evento(int id, String nombre, LocalDate fecha, int numEntradasVendidas, int capMax, EstadoEvento estado) throws CraftersException {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.numEntradasVendidas = numEntradasVendidas;
		this.capMax = capMax;
		this.estado = estado;
		
		if(capMax <=0 || numEntradasVendidas <=0 || numEntradasVendidas > capMax) {
			throw new CraftersException();
		}
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNumEntradasVendidas() {
		return numEntradasVendidas;
	}

	public void setNumEntradasVendidas(int numEntradasVendidas) {
		this.numEntradasVendidas = numEntradasVendidas;
	}

	public int getCapMax() {
		return capMax;
	}

	public void setCapMax(int capMax) {
		this.capMax = capMax;
	}

	public EstadoEvento getEstado() {
		return estado;
	}

	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}
	

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", estado=" + estado + "]";
	}

	
	public void modificaEstado(EstadoEvento estadoNuevo) throws CraftersException{
		if(estado.equals(EstadoEvento.PENDIENTE) && estadoNuevo.equals(EstadoEvento.APLAZADO)) {
			System.out.println("No es posible pasar al estado: " + estadoNuevo);
			throw new CraftersException();
		}
		else if(estadoNuevo.equals(EstadoEvento.APLAZADO) && estadoNuevo.equals(EstadoEvento.PROGRAMADO)) {
			estado.equals(estadoNuevo);
		}
		
		estado.equals(estadoNuevo);
	}
	
	
	public int getPorcentajeOcupacion() {
		int resultado=(capMax*numEntradasVendidas)%100;
		return resultado;
	}
	
	public int getPorcentajeOcupacion2(int numEntradasNuevas) {
		int resultado=(capMax*(numEntradasVendidas+numEntradasNuevas))%100;
		return resultado;
	}
	
	public abstract double calcularCosteBase();
}
