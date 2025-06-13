package com.projeto.controllers.handlers;

import com.projeto.dtos.CustomError;
import com.projeto.services.exceptions.WebClientExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionsHandlers {

    @ExceptionHandler(WebClientExceptions.class)
    public ResponseEntity<CustomError> handleWebClient(WebClientExceptions e, ServerHttpRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getURI().getPath());
        return ResponseEntity.status(status).body(err);
    }
}
