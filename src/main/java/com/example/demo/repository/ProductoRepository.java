package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);

    List<Producto> findByPrecioGreaterThan(double precio);

    List<Producto> findByPrecioLessThan(double precio);

    List<Producto> findByNombreContaining(String nombre);

    List<Producto> findByPrecioGreaterThanEqual(double precio);

    @Query("SELECT p FROM Producto p where p.precio <= :precio")
    List<Producto> buscarPorPrecio(
            @Param("precio") double precio);

    @Query("SELECT p FROM Producto p where p.precio>= :precio AND p.nombre LIKE %:nombre%")
    List<Producto> filtarNombrePrecio(
            @Param("nombre") String nombre,
            @Param("precio") double precio);

    @Query("SELECT p FROM Producto p  WHERE p.precio>= :min AND p.precio <= :max")
    List<Producto> filtroMayorMenorPrecios(
            @Param("min") double min,
            @Param("max") double max);
}
