package com.projeto.services.exceptions;

public class CepNotFoundException extends RuntimeException {

  public CepNotFoundException(String message) {
    super(message);
  }
}
