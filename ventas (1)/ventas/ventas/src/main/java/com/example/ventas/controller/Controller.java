package com.example.ventas.controller;

import com.example.ventas.model.producto;
import com.example.ventas.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class Controller {
    @Autowired
    private service service;

    // Obtener todos los productos
    @GetMapping
    public List<producto> getAllProducts() {
        return service.getAllproducto();
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<producto> getProductById(@PathVariable Long id) {
        producto product = service.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo producto
    @PostMapping
    public producto createProduct(@RequestBody producto product) {
        return service.saveProduct(product);
    }

    // Actualizar un producto
    @PutMapping("/{id}")
    public ResponseEntity<producto> updateProduct(@PathVariable Long id, @RequestBody producto product) {
        producto updatedProduct = service.updateproducto(id, product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteproducto(id);
        return ResponseEntity.noContent().build();
    }
}
