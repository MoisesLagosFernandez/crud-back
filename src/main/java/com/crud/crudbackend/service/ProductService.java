package com.crud.crudbackend.service;


import com.crud.crudbackend.Model.Product;
import com.crud.crudbackend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }
    public Optional<Product> getOne (int id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByNombre(String nombre){

        return productRepository.findByNombre(nombre);
    }

    public boolean existsByNombre(String nombre){

        return productRepository.existsByNombre(nombre);
    }

    public void save(Product product) {

        productRepository.save(product);
    }
    public void delete(int id) {
        productRepository.deleteById(id);
    }
    public boolean existsById(int id) {
        return productRepository.existsById(id);
    }
}
