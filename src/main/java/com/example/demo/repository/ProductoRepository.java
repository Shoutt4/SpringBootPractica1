package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);

    List<Producto> findByPrecioGreaterThan(double precio);

    List<Producto> findByPrecioLessThan(double precio);

    List<Producto> findByNombreContaining(String nombre);

    List<Producto> findByPrecioGreaterThanEqual(double precio) ; 
}
