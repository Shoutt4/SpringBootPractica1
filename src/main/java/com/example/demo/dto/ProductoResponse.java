package com.example.demo.dto;

public class ProductoResponse {

    private Long id;
    private String nombre;
    private double precio;

    public ProductoResponse(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

}
