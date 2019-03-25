package br.com.fiap.orderservice.Controller;

import br.com.fiap.orderservice.Entity.OrderEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController

public class Order {

    private ArrayList<OrderEntity> orders = new ArrayList<>();

    @GetMapping("/order/findById/{id}")
    public Map<String, OrderEntity> findById(@PathVariable("id") int id) {
        HashMap<String, OrderEntity> mapa = new HashMap<>();

        try {
            OrderEntity order = this.orders.get(id);
            mapa.put("Order", order);
        } catch (Exception err) {
            mapa.put("Order", null);
        }
        return mapa;
    }

    @PostMapping("/order/save")
    public Map<String, String> save(@RequestBody OrderEntity order) {
        HashMap<String, String> mapa = new HashMap<>();
        try {
            this.orders.add(order);
            int id = this.orders.size() - 1;

            mapa.put("URL", "http://localhost:8080/order/findById/" + id);
        } catch (Exception err) {
            mapa.put("Order", "Não foi possivel salvar!");
        }

        return mapa;
    }

    @PostMapping("/order/update/{id}")
    public Map<String, String> update(@RequestBody OrderEntity order,
        @PathVariable("id") int id) {

        HashMap<String, String> mapa = new HashMap<>();
        try {
            this.orders.set(id, order);
            mapa.put("Mensagem", "Order atualizada!");
            mapa.put("URL", "http://localhost:8080/order/findById/" + id);
        } catch (Exception err) {
            mapa.put("Mensagem", "Esta order não existe!");
        }

        return mapa;
    }

    @PostMapping("/order/delete/{id}")
    public Map<String, String> delete(@PathVariable("id") int id) {

        HashMap<String, String> mapa = new HashMap<>();
        try {
            this.orders.remove(id);
            mapa.put("Mensagem", "Order: " + id + " removido!");
        } catch (Exception err) {
            mapa.put("Order", "Esta order não existe!");
        }

        return mapa;
    }
}
