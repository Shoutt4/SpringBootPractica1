package com.example.demo.controller;
import  com.example.demo.model.Producto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.ProductoService;
import java.util.*;

@RestController
public class ProductoController {
    private final ProductoService productoService ;

    public ProductoController(ProductoService productoService){
        this.productoService=productoService ; 
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos(){
        return ResponseEntity.ok(this.productoService.getProductos()) ;
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto pr){
       Producto nePr = productoService.createProducto(pr) ; 
       return ResponseEntity.status(HttpStatus.CREATED).body(nePr) ;
    }
    @GetMapping("/Productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable long id ){
        Optional<Producto> pr = productoService.getProducotoById(id) ; 
        if(pr.isPresent()){
            return ResponseEntity.ok(pr.get()); 
        }
        return ResponseEntity.notFound().build() ; 
    }

    @PutMapping("/Productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto pr , @PathVariable long id){
        Producto newPr = productoService.updateProducto(pr, id) ; 

        if(newPr!=null){
            return ResponseEntity.status(201).body(newPr);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducto (@PathVariable long id){
        boolean bander = productoService.deleteProducto(id) ; 

        if(bander){
            return ResponseEntity.ok("producto elimiando"); 
        }else {
            return ResponseEntity.notFound().build(); 
        }
    }
}
