package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProductos() {
        return this.productoRepository.findAll();
    }

    public Producto createProducto(Producto pr) {
        return this.productoRepository.save(pr);
    }

    public Optional<Producto> getProducotoById(@PathVariable long id) {
        return this.productoRepository.findById(id);
    }

    public Producto updateProducto(Producto producto, long id) {
        Optional<Producto> productoBuscado = productoRepository.findById(id);

        if (productoBuscado.isPresent()) {
            productoBuscado.get().setNombre(producto.getNombre());
            productoBuscado.get().setPrecio(producto.getPrecio());
            return productoRepository.save(productoBuscado.get());
        } else {
            return null;
        }

    }

    public boolean deleteProducto(long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    public List<Producto> findByNombre(String nombre) {
        return this.productoRepository.findByNombre(nombre);
    }

    public List<Producto> obtenerProductoPrecio(double precio) {
        return this.productoRepository.findByPrecioGreaterThan(precio);
    }

    public List<Producto> obtenerProductoPrecioMenor(double precio) {
        return this.productoRepository.findByPrecioLessThan(precio);
    }

    public List<Producto> obtenerProductosNombre(String nombre) {
        return this.productoRepository.findByNombreContaining(nombre);
    }

    public List<Producto> obtenerProductosMayoresIguales(double precio) {
        return this.productoRepository.findByPrecioGreaterThanEqual(precio);
    }

    public List<Producto> filtrarPorPrecio(double precio){
        return this.productoRepository.buscarPorPrecio(precio) ; 
    }

    public List <Producto> filtrarPorNombrePrecio(String nombre , double precio ){
        return this.productoRepository.filtarNombrePrecio(nombre, precio) ; 
    }

    public List <Producto> filterPredioMayorMenor(double min , double max ){
        return this.productoRepository.filtroMayorMenorPrecios(min, max) ;
    }
}
