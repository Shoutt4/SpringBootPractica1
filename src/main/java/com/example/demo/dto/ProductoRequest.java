package com.example.demo.dto;

import com.example.demo.model.Categoria;

public class ProductoRequest {

    private String nombre  ; 
    private double precio ; 
    private Long categoria ; 

    public ProductoRequest (){

    }

    public ProductoRequest( String nombre , double precio , Long categoria){
        this.nombre=nombre ; 
        this.precio=precio ; 
        this.categoria=categoria ; 
    }

    public String getNombre() {
        return nombre;
    }
    public Long getCategegoria() {
        return categoria;
    }
    public double getPrecio() {
        return precio;
    }
}
