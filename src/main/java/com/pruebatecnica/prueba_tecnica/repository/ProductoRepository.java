package com.pruebatecnica.prueba_tecnica.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pruebatecnica.prueba_tecnica.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {

}
