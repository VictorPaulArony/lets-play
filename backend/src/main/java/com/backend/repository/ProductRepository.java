package com.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {

}
