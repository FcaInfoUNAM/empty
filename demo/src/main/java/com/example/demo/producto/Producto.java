package com.example.demo.producto;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.product;
import com.example.demo.repo.productoRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class Producto {
@Autowired
productoRepo repo;
@GetMapping("productos")
  public List<product> findAllProductos() {
    return this.repo.findAll();
  }

@PostMapping("producto")
  public product addProducto(@RequestBody product producto) {
    return repo.save(producto);
  }

@GetMapping("producto/{id}")
public Optional<product> getById(@PathVariable Long id) {
    return repo.findById(id);
}


@PutMapping("producto/{id}")
public product putProduct(@PathVariable Long id, @RequestBody product product) {
    product.setId(id);
    return repo.save(product);
}


}

