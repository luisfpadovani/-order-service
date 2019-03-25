package br.com.fiap.orderservice.Entity;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    private int id;
    private String email;
    private String nome;
    private String shippingAddress;
    private ArrayList<Produto> produtos;
    private Pagamento pagamento;
    private String data;
    private String status;
}
