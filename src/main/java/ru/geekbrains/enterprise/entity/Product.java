package ru.geekbrains.enterprise.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Product {

    private String id = UUID.randomUUID().toString();
    private String name = "";
    private String description = "";

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
