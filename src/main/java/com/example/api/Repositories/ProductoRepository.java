package com.example.api.Repositories;

import com.example.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(
            value="Select * FROM productos as prod WHERE prod.nombre LIKE %?1%",
            nativeQuery = true)
    public List<Producto> getByName(String name);

    @Query(
            value="Select * FROM productos as prod WHERE prod.tipo LIKE %?1%",
            nativeQuery = true)
    public List<Producto> getByType(String name);
}