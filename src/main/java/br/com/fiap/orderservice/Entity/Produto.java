package br.com.fiap.orderservice.Entity;

import lombok.*;

import javax.validation.constraints.Digits;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private int idPedido;
    private String descricao;

    @Digits(integer = 6, fraction = 2)
    private float valor;

    private int qtd;
}
