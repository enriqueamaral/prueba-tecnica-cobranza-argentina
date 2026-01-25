package com.pruebatecnica.prueba_tecnica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebatecnica.prueba_tecnica.entity.Producto;
@Service
public interface ProductoService {
    Producto crearProducto(Producto producto);
    List<Producto> obtenerProductos();
    Producto obtenerProducto(Integer id);
    void eliminarProducto(Integer id);
    Producto actualizarProducto(Producto producto);
}
