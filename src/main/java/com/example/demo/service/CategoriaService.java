package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CategoriaRepository;
import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria saveCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public List<Categoria> getCategorias() {
        return this.categoriaRepository.findAll();
    }

    public List<Categoria> getCat() {
        return this.categoriaRepository.findCategoriasConProducto();
    }
}
