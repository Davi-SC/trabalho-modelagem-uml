package main.java.br.com.ecommerce;

import main.java.br.com.ecommerce.model.*;
import main.java.br.com.ecommerce.service.PedidoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE E-COMMERCE ===\n");
        
        // Instanciar o serviço
        PedidoService pedidoService = new PedidoService();

        // Criando produtos
        Produto notebook = new Produto("Notebook",3500.00,"Notebook Gamer");
        
        Produto mouse = new Produto("Mouse",150.00,"Mouse sem fio");
        
        Produto memoria = new Produto("Memoria RAM",4500.00,"Memoria RAM 16GB");
        
        // Criando cliente
        Cliente cliente1 = new Cliente("João Silva","joao@email.com","(11) 98765-4321");
        
        // Pedido 1
        System.out.println("--- Criando Pedido 1 ---");
        
        ItemPedido item1 = new ItemPedido(1, notebook);
        ItemPedido item2 = new ItemPedido(2,mouse);
        List<ItemPedido> itensPedido1 = new ArrayList<>();
        itensPedido1.add(item1);
        itensPedido1.add(item2);

        Cartao pagamentoCartao = new Cartao("1234-5678-9012-3456","João Silva", new Date(), new Date());
        
        // Criar pedido
        Pedido pedido1 = pedidoService.criarPedido(cliente1, itensPedido1, pagamentoCartao);
        
        
        // Pedido 2
        System.out.println("\n--- Criando Pedido 2 ---");

        ItemPedido item3 = new ItemPedido(1, memoria);
        List<ItemPedido> itensPedido2 = new ArrayList<>();
        itensPedido2.add(item3);

        Pix pagamentoPix = new Pix("chave-pix-joao", new Date());

        Pedido pedido2 = pedidoService.criarPedido(cliente1, itensPedido2, pagamentoPix);


        // Listando todos os pedidos
        pedidoService.listarPedidos();
        
        
        // Buscando um pedido por ID
        System.out.println("\n=== BUSCANDO PEDIDO #2 ===");
        Pedido pedidoBuscado = pedidoService.buscarPedidoById(2);
        if (pedidoBuscado != null) {
            pedidoService.exibirDetalhes(pedidoBuscado);
        }
        
        
        // Cancelando um pedido
        System.out.println("\n=== CANCELANDO PEDIDO #1 ===");
        pedidoService.cancelarPedido(1);
        
        
        // Listando todos os pedidos após cancelamento
        System.out.println("\n=== PEDIDOS APÓS CANCELAMENTO ===");
        pedidoService.listarPedidos();
    }
}
