package br.com.fiap.orderservice.Domain;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int idOrder;
    private String email;
    private String nome;
    private String endereco;
    private double valorTotal;
    private String formaPagamento;
    private String dataPedido;
    private String status;
    private String idTransacao;
    private String numeroCartao;
    private String validadeCartao;
    private String bandeiraCartao;
    private OrderItem[] itens;
}
