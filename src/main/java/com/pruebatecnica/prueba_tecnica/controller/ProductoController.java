package com.pruebatecnica.prueba_tecnica.controller;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.prueba_tecnica.entity.Producto;
import com.pruebatecnica.prueba_tecnica.service.ProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//localhost:8080/api/productos
@RequestMapping("/api/v1")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //localhost:8080/api/productos
    @PostMapping("/products")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    //localhost:8080/api/productos
    @GetMapping("/products")
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    //localhost:8080/api/productos/1
    @GetMapping("/products/{id}")
    public Producto obtenerProducto(@PathVariable Integer id) {
        return productoService.obtenerProducto(id);
    }

    //localhost:8080/api/productos/1
    @DeleteMapping("/products/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
    }

    //localhost:8080/api/productos
    @PutMapping("/products/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto productoDb = productoService.obtenerProducto(id);
        productoDb.setSku(producto.getSku());
        productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());
        productoDb.setCantidad(producto.getCantidad());
        return productoService.actualizarProducto(productoDb);
    }
}
