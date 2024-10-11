package com.example.demo.repo;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.product;
import com.example.demo.producto.Producto;


public interface productoRepo extends JpaRepository <product,Long>{

    

}
