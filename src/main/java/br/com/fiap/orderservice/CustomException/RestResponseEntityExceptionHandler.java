package br.com.fiap.orderservice.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(OrderNotFoundException ex, WebRequest request) {
        ExceptionReponse exceptionResponse =
                new ExceptionReponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderUpdateException.class)
    public final ResponseEntity<Object> handleAllExceptions(OrderUpdateException ex, WebRequest request) {
        ExceptionReponse exceptionResponse =
                new ExceptionReponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerException.class)
    public final ResponseEntity<Object> handleAllExceptions(ServerException ex, WebRequest request) {
        ExceptionReponse exceptionResponse =
                new ExceptionReponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}