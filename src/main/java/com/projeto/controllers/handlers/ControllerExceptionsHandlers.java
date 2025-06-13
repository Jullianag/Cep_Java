package com.projeto.controllers.handlers;

import com.projeto.dtos.CustomError;
import com.projeto.services.exceptions.CepNotFoundException;
import com.projeto.services.exceptions.WebClientExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerWebExchange;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionsHandlers {

    @ExceptionHandler(WebClientExceptions.class)
    public ResponseEntity<CustomError> handleWebClient(WebClientExceptions ex, ServerWebExchange exchange) {
        CustomError error = new CustomError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                exchange.getRequest().getPath().toString()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<CustomError> handleCepNotFound(CepNotFoundException e, ServerWebExchange exchange) {
        CustomError err = new CustomError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                exchange.getRequest().getPath().toString()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
