# Spring Boot JPA GET PUT POST

## Paso 1: 
Creara una base de datos en Postgres ejecutando el la terminal
```bash
psql -U postgres
```


```sql
CREATE USER chochos WITH PASSWORD ‘chochos’;
CREATE DATABASE chochos OWNER chochos;
```

## Paso2 Actualiza el modelo
Generar el modelo ```demo/src/main/java/com/example/demo/model/product.java```
```java
package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="producto")
@Entity
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String nombre;
  
    private String descripcion;
    private String lote;
    private float precioUnitario;
    private LocalDate fechaCaducidad;

}

```

> Nota que eliminamos los geters y seters pero agregamos dos etiquetas: @NoArgsConstructor y @AllArgsConstructor
> Revisa la etiqueta de @GeneratedValue y analiza que significa lo que esá entre paréntesis

## Paso 3 
agrega o edita el siguiente método al controlador ```demo/src/main/java/com/example/demo/producto/Producto.java```

```java
@GetMapping("producto/{id}")
public Optional<product> getById(@PathVariable Long id) {
    return repo.findById(id);
}
```

## Paso 4
Inserta un nuevo registro en una terminal diferente
```cmd
curl -s -X POST localhost:8080/producto \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Creatina", "descripcion":"Creatina de 500g holixlab", "lote":"12345", "precioUnitario":500.5, "fechaCaducidad":"2026-05-04"}'
```

## Paso 5

Consulta el registro mediante el api utilizando el navegador ```<url de la aplicacion>/producto/<idDelProducto>```
```cmd
curl -s -X GET localhost:8080/producto/1
```
## Paso 6
Agrega o edita el siguiente método al controlador ```demo/src/main/java/com/example/demo/producto/Producto.java```

```java
@PutMapping("producto/{id}")
public product putProduct(@PathVariable Long id, @RequestBody product product) {
    product.setId(id);
    return repo.save(product);
}
```
## Paso 7
Edita el un nuevo registro en una terminal diferente
```cmd
curl -s -X PUT localhost:8080/producto/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Proteina de Fresa", "descripcion":"Proteina de suero de leche 25g p/s, 2.2 kg ", "lote":"12345", "precioUnitario":500.5, "fechaCaducidad":"2027-06-07"}'
```
 repite el paso 5 para ver que los cambios se hayan relizado de forma correcta.

## Paso 8
Agrega o edita el siguiente método al controlador ```demo/src/main/java/com/example/demo/producto/Producto.java```

```java
@DeleteMapping("producto/{id}")
public String deleteMailbox(@PathVariable("id") Long id) {
    repo.deleteById(id);
    return "{\"success\":true}";
}
```
## Paso 9

Consulta el registro mediante el api utilizando el navegador ```<url de la aplicacion>/producto/<idDelProducto>```
```cmd
curl -s -X DELETE localhost:8080/producto/1
```
y consulta la lista de productops para validar


> * Si se te muere la ventana del codespace con spring iniciado pues matar el proceso con los siguientes comandos

>Bucar PID:
>```cmd
>fuser 8080/tcp
>```
>Matar proceso con el PID que regresa el comando anterior:
>```cmd
>kill <PID>
>```
> * Si requieres iniciar postgres porque se inicio tu contenedor otra vez usa los siguientes comandos
>```cmd
>sdo su
>service postgresql start
>```

