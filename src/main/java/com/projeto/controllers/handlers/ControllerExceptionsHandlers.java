package com.projeto.controllers.handlers;

import com.projeto.services.exceptions.WebClientExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionsHandlers {

    @ExceptionHandler(WebClientExceptions.class)
    public ResponseEntity<String> handleWebClient(WebClientExceptions e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
