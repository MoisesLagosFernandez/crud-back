package com.crud.crudbackend.controller;

import com.crud.crudbackend.Model.Product;
import com.crud.crudbackend.dto.Message;
import com.crud.crudbackend.dto.ProductDTO;
import com.crud.crudbackend.service.ProductService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService poductService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> list() {
        List<Product> list = poductService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id) {
        if (!poductService.existsById(id))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        Product product = poductService.getOne(id).get();
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @GetMapping("/detail/{nombre}")
    public ResponseEntity<Product> getByNombre(@PathVariable("nombre") String nombre) {
        if (!poductService.existsByNombre(nombre))
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        Product product = poductService.findByNombre(nombre).get();
        return new ResponseEntity(product, HttpStatus.OK);
    }
    @GetMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO){
        if(StringUtils.isBlank(productDTO.getNombre()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(productDTO.getPrecio()<0)
            return new ResponseEntity(new Message("El precio debe ser mayor a 'O'"), HttpStatus.BAD_REQUEST);
        if(poductService.existsByNombre(productDTO.getNombre()))
            return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);

        Product product = new Product(productDTO.getNombre(), productDTO.getPrecio());
        poductService.save(product);
        return new ResponseEntity(new Message("Producto creado"), HttpStatus.OK);
    }
}
