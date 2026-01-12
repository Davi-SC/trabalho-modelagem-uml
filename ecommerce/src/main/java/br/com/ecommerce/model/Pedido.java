package main.java.br.com.ecommerce.model;

import java.util.List;

public class Pedido {
    private int id;
    private List<ItemPedido> itens;
    private Cliente cliente;
    private Pagamento pagamento;
    private double total;

    public Pedido(int id, List<ItemPedido> itens, Cliente cliente, Pagamento pagamento) {
        this.id = id;
        this.itens = itens;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.total = calcularTotal();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public double calcularTotal() {
        double total = 0.0;
        if (itens != null) {
            for (ItemPedido item : itens) {
                total += item.getQuantidade() * item.getProduto().getPreco();
            }
        }
        return total;
    }
}
