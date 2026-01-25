package com.pruebatecnica.prueba_tecnica.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebatecnica.prueba_tecnica.entity.Producto;
import com.pruebatecnica.prueba_tecnica.exception.ResourceNotFoundException;
import com.pruebatecnica.prueba_tecnica.repository.ProductoRepository;
import com.pruebatecnica.prueba_tecnica.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }
    @Override
    public Producto obtenerProducto(Integer id) {
        Producto producto = productoRepository.findById(id).orElseThrow(
            () ->{
                throw new ResourceNotFoundException("Producto no encontrado con id: " + id);
                }
        );
        return producto;
    }
    @Override
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}
