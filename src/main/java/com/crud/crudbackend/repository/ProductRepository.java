package com.crud.crudbackend.repository;

import com.crud.crudbackend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByNombre(String nombre);
    boolean existsByNombre (String nombre);

}
