package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.*;
import com.example.demo.service.*;

@RestController
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> saveProducto(@RequestBody Categoria categoria) {
        Categoria cat = this.categoriaService.saveCategoria(categoria);
        return ResponseEntity.ok(cat);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> getCategoria() {
        return ResponseEntity.ok(this.categoriaService.getCat());
    }
}
