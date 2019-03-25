package br.com.fiap.orderservice.Repository;


import br.com.fiap.orderservice.Domain.Order;
import br.com.fiap.orderservice.Domain.OrderItem;
public class OrderDao {

    private Order[] orderArray = null;

    public OrderDao(){
        orderArray = new Order[2000];
        for(int x =0; x < 1000;x++){
            Order order = new Order();
            order.setIdOrder(x);
            order.setEmail("email@email.com.br");
            order.setNome("Nome");
            order.setEndereco("Endereço");
            order.setValorTotal(40.00);
            order.setFormaPagamento("BOLETO");
            order.setDataPedido("05/31/2019");
            order.setStatus("AGUARDANDO PAGAMENTO");
            order.setIdTransacao("1256-521452-32515471-682476");
            order.setNumeroCartao("02541 02142 01795 03458 69985");
            order.setValidadeCartao("02/24");
            order.setBandeiraCartao("VISA");
            OrderItem[] item = new OrderItem[4];

            for (int i = 0; i < 4; i++){
                item[i] = new OrderItem();
                item[i].setIdItem(i);
                item[i].setIdOrder(1);
                item[i].setDescricao("Produto "+i);
                item[i].setQuantidade(i+2);
                item[i].setValorUnitario(10.00);
            }
            order.setItens(item);
            orderArray[x] = order;
        }
    }

    public Order[] returnList(){
        return orderArray;
    }

    public Order findById(int idOrder){
        return orderArray[idOrder];
    }

    public boolean delete(int idOrder){
        orderArray[idOrder] = null;
        return true;
    }

    public boolean update(int idOrder,Order order){
        Order orderUpdate = orderArray[idOrder];
        orderUpdate.setEmail(order.getEmail());
        orderUpdate.setNome(order.getNome());
        orderUpdate.setEndereco(order.getEndereco());
        orderUpdate.setValorTotal(order.getValorTotal());
        orderUpdate.setFormaPagamento(order.getFormaPagamento());
        orderUpdate.setDataPedido(order.getDataPedido());
        orderUpdate.setStatus(order.getStatus());
        orderUpdate.setIdTransacao(order.getIdTransacao());
        orderUpdate.setNumeroCartao(order.getNumeroCartao());
        orderUpdate.setValidadeCartao(order.getValidadeCartao());
        orderUpdate.setBandeiraCartao(order.getBandeiraCartao());

        int qtdItens = order.getItens().length;
        orderUpdate.setItens(null);
        OrderItem[] item = new OrderItem[qtdItens];
        for (int i = 0; i < qtdItens; i++){
            item[i] = new OrderItem();
            item[i].setIdItem(order.getItens()[i].getIdItem());
            item[i].setIdOrder(order.getItens()[i].getIdOrder());
            item[i].setDescricao(order.getItens()[i].getDescricao());
            item[i].setQuantidade(order.getItens()[i].getQuantidade());
            item[i].setValorUnitario(order.getItens()[i].getValorUnitario());
        }
        orderUpdate.setItens(item);
        return true;
    }

    public Order save(Order order){
        Order orderSave = new Order();
        orderSave.setIdOrder(order.getIdOrder());
        orderSave.setEmail(order.getEmail());
        orderSave.setNome(order.getNome());
        orderSave.setEndereco(order.getEndereco());
        orderSave.setValorTotal(order.getValorTotal());
        orderSave.setFormaPagamento(order.getFormaPagamento());
        orderSave.setDataPedido(order.getDataPedido());
        orderSave.setStatus(order.getStatus());
        orderSave.setIdTransacao(order.getIdTransacao());
        orderSave.setNumeroCartao(order.getNumeroCartao());
        orderSave.setValidadeCartao(order.getValidadeCartao());
        orderSave.setBandeiraCartao(order.getBandeiraCartao());
        OrderItem[] item = new OrderItem[order.getItens().length];
        for (int i = 0; i < order.getItens().length; i++){
            item[i] = new OrderItem();
            item[i].setIdItem(order.getItens()[i].getIdItem());
            item[i].setIdOrder(order.getItens()[i].getIdOrder());
            item[i].setDescricao(order.getItens()[i].getDescricao());
            item[i].setQuantidade(order.getItens()[i].getQuantidade());
            item[i].setValorUnitario(order.getItens()[i].getValorUnitario());
        }
        orderSave.setItens(item);
        orderArray[order.getIdOrder()] =orderSave;
        return orderSave;
    }
}
