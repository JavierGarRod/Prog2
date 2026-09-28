package ejRepaso3.Models;

public class Pedido {
	private int id;
	Cliente cliente;
	private int importe;
	EstadoPedido estadoPedido;
	private int contador=0;
	
	
	public Pedido(int id, Cliente cliente, int importe, EstadoPedido estadoPedido) {
		super();
		this.id = contador++;
		this.cliente = cliente;
		this.importe = importe;
		this.estadoPedido = EstadoPedido.PENDIENTE;
	}


	public Pedido(int id2, Cliente cliente2, double importe2) {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public int getImporte() {
		return importe;
	}


	public void setImporte(int importe) {
		this.importe = importe;
	}


	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}


	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}


	public int getContador() {
		return contador;
	}


	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
	

}
