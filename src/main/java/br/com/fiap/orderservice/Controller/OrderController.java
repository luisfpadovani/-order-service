package br.com.fiap.orderservice.Controller;

import br.com.fiap.orderservice.CustomException.OrderNotFoundException;
import br.com.fiap.orderservice.CustomException.OrderUpdateException;
import br.com.fiap.orderservice.Domain.Order;
import br.com.fiap.orderservice.Repository.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
public class OrderController  {
    OrderDao orderDao;
    Order[] orderList;

    public OrderController(){
        orderDao = new OrderDao();
        orderList = orderDao.returnList();
    }

    @GetMapping("/order/findByid/{idOrder}")
    public ResponseEntity<Order> findById(@PathVariable(value="idOrder", required=true) int idOrder) throws OrderNotFoundException {
        if(idOrder == 0){
            throw new OrderNotFoundException("ID Nullo");
        }
        return new ResponseEntity(orderDao.findById(idOrder), HttpStatus.OK);
    }

    @PutMapping("/order/{idOrder}")
    public ResponseEntity<Boolean> update(@PathVariable(value="idOrder", required=true) int idOrder,
                                        @RequestBody Order order) throws OrderNotFoundException {

        if(idOrder == 0){
            throw new OrderUpdateException("Atualização inválida");
        }

          return new ResponseEntity(orderDao.update(idOrder, order), HttpStatus.OK);
    }


    @DeleteMapping("/order/{idOrder}")
    public ResponseEntity<Order> delete(@PathVariable(value="idOrder", required=true) int idOrder) throws OrderNotFoundException {
        return new ResponseEntity(orderDao.delete(idOrder), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity save(@RequestBody Order order){
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(orderDao.save(order).getIdOrder()).toUri();
        return new ResponseEntity(location, HttpStatus.OK);
    }
}