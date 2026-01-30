package com.backend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "products")
@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String userId;

}
