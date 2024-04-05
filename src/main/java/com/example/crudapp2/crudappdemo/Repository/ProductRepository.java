package com.example.crudapp2.crudappdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudapp2.crudappdemo.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
    Product findByProductType(String productType);
}

