package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="producto")
@Entity
public class product {
    @Id
    private long id;

    private String nombre;
  
    private String descripcion;
    private String lote;
    private float precioUnitario;
    private LocalDate fechaCaducidad;

    public product(long id, String nombre, String descripcion, String lote, float precioUnitario,
            LocalDate fechaCaducidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lote = lote;
        this.precioUnitario = precioUnitario;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }
    public float getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

}
