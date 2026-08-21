package com.example.demo.controller;

import com.example.demo.dto.ProductoResponse;
import com.example.demo.model.Categoria;
import com.example.demo.model.Producto;
import com.example.demo.dto.ProductoRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.ProductoService;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos() {
        return ResponseEntity.ok(this.productoService.getProductos());
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto pr) {
        Producto nePr = productoService.createProducto(pr);
        return ResponseEntity.status(HttpStatus.CREATED).body(nePr);
    }

    @GetMapping("/Productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable long id) {
        Optional<Producto> pr = productoService.getProducotoById(id);
        if (pr.isPresent()) {
            return ResponseEntity.ok(pr.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/Productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto pr, @PathVariable long id) {
        Producto newPr = productoService.updateProducto(pr, id);

        if (newPr != null) {
            return ResponseEntity.status(201).body(newPr);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable long id) {
        boolean bander = productoService.deleteProducto(id);

        if (bander) {
            return ResponseEntity.ok("producto elimiando");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/productos/buscar")
    public ResponseEntity<List<Producto>> findByNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(productoService.findByNombre(nombre));
    }

    @GetMapping("/productos/precio")
    public ResponseEntity<List<Producto>> getProductosByPrecio(@RequestParam double precio) {
        return ResponseEntity.ok(this.productoService.obtenerProductoPrecio(precio));
    }

    @GetMapping("/productos/precio-menor")
    public ResponseEntity<List<Producto>> getPrecioMenorPorPrecio(@RequestParam double precio) {
        return ResponseEntity.ok(this.productoService.obtenerProductoPrecioMenor(precio));
    }

    @GetMapping("/productos/obtener-coincidencias")
    public ResponseEntity<List<Producto>> getProductosNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(this.productoService.obtenerProductosNombre(nombre));
    }

    @GetMapping("/precio/filter-mayor-igual")
    public ResponseEntity<List<Producto>> getProductosprecios(@RequestParam double precio) {
        return ResponseEntity.ok(productoService.obtenerProductosMayoresIguales(precio));
    }

    @GetMapping("/producto/precio-filtro")
    public ResponseEntity<List<Producto>> filtroPrecio(@RequestParam double precio) {
        List<Producto> productosNew = this.productoService.filtrarPorPrecio(precio);
        if (productosNew != null) {
            return ResponseEntity.ok(productosNew);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/productos/nombre-precio")
    public ResponseEntity<List<Producto>> filtrarPrecioNombre(@RequestParam String nombre,
            @RequestParam double precio) {
        List<Producto> nelList = this.productoService.filtrarPorNombrePrecio(nombre, precio);
        if (nelList != null) {
            return ResponseEntity.ok(nelList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/productos/precio-mayor-menor")
    public ResponseEntity<List<Producto>> getProductosMinMax(@RequestParam double min, @RequestParam double max) {
        return ResponseEntity.ok(this.productoService.filterPredioMayorMenor(min, max));
    }

    @GetMapping("/xd")
    public ResponseEntity<List<ProductoResponse>> obtenerProductosConvertidos() {
        return ResponseEntity.ok(this.productoService.getProductosConvertidos());
    }

    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
