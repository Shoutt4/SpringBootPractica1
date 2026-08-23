package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class ProductoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que 0")
    private Double precio;

    @NotNull(message = "La categoria es obligatoria")
    private Long categoria;

    public ProductoRequest() {

    }

    public ProductoRequest(String nombre, Double precio, Long categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getCategegoria() {
        return categoria;
    }

    public Double getPrecio() {
        return precio;
    }
}
