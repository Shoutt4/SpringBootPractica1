package com.example.demo.exception;

public class CategoriaNotFoundException extends RuntimeException {

    public CategoriaNotFoundException(String mensaje) {
        super(mensaje);
    }
}
