package br.com.fiap.orderservice.Domain;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private int idItem;
    private int idOrder;
    private String descricao;
    private int quantidade;
    private double valorUnitario;
}