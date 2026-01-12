package main.java.br.com.ecommerce.service;

import main.java.br.com.ecommerce.model.Cliente;
import main.java.br.com.ecommerce.model.ItemPedido;
import main.java.br.com.ecommerce.model.Pagamento;
import main.java.br.com.ecommerce.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private int proximoId = 1;

    public Pedido criarPedido(Cliente cliente, List<ItemPedido> itens, Pagamento pagamento) {
        Pedido pedido = new Pedido(proximoId++, itens, cliente, pagamento);

        pedidos.add(pedido);
        System.out.println("Pedido #" + pedido.getId() + " criado com sucesso!");
        return pedido;
    }

    public Pedido buscarPedidoById(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        System.out.println("Pedido #" + id + " não encontrado.");
        return null;
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }
        
        System.out.println("\n=== LISTA DE PEDIDOS ===");
        for (Pedido pedido : pedidos) {
            exibirDetalhes(pedido);
            System.out.println("------------------------");
        }
    }

    public void cancelarPedido(int id) {
        Pedido pedido = buscarPedidoById(id);
        if (pedido != null) {
            pedidos.remove(pedido);
            System.out.println("Pedido #" + id + " cancelado com sucesso!");
        }
    }

    public void exibirDetalhes(Pedido pedido) {
        System.out.println("Pedido #" + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Itens:");
        
        for (ItemPedido item : pedido.getItens()) {
            System.out.println("  - " + item.getProduto().getNome() + 
                             " | Qtd: " + item.getQuantidade() + 
                             " | Preço: R$ " + item.getProduto().getPreco() +
                             " | Subtotal: R$ " + (item.getQuantidade() * item.getProduto().getPreco()));
        }
        
        System.out.println("Total: R$ " + pedido.calcularTotal());
        
        Pagamento pag = pedido.getPagamento();
        System.out.println("Forma de Pagamento: " + pag.getClass().getSimpleName());
    }
}
