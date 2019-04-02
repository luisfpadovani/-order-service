package br.com.fiap.orderservice.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderUpdateException extends RuntimeException {
    public OrderUpdateException(String message) {
        super(message);
    }
}