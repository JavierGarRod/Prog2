package ejRepaso3.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ejRepaso3.Models.Cliente;
import ejRepaso3.Models.Pedido;

public class PedidoRepository {

    private final Map<Integer, Pedido> pedidos = new ConcurrentHashMap<>();
    private final AtomicInteger siguienteId = new AtomicInteger(1);

    // CREATE
    public Pedido crear(Cliente cliente, double importe) {
        int id = siguienteId.getAndIncrement();

        Pedido pedido = new Pedido(id, cliente, importe);
        pedidos.put(id, pedido);

        return pedido;
    }

    // READ
    public Pedido buscarPorId(int id) {
        return pedidos.get(id);
    }

    // READ
    public List<Pedido> buscarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    // UPDATE
    public void actualizar(Pedido pedido) {
        if (!pedidos.containsKey(pedido.getId())) {
            throw new IllegalArgumentException(
                    "No existe el pedido con id " + pedido.getId()
            );
        }

        pedidos.put(pedido.getId(), pedido);
    }

    // DELETE
    public void eliminar(int id) {
        if (pedidos.remove(id) == null) {
            throw new IllegalArgumentException(
                    "No existe el pedido con id " + id
            );
        }
    }
}