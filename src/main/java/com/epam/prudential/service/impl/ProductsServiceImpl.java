package com.epam.prudential.service.impl;

import com.epam.prudential.model.Products;
import com.epam.prudential.repository.ProductsRepository;
import com.epam.prudential.service.ProductsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;


    @Override
    public void addProducts(Products products) {
        productsRepository.insert(products);
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();

    }

    @Override
    public void updateProducts(Products products) {
        Products savedProducts = productsRepository.findById(products.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Products by id %s", products.getId())));
        savedProducts.builder().productName(products.getProductName()).build();
        productsRepository.save(savedProducts);

    }

    @Override
    public void deleteProducts(String id) {
        productsRepository.deleteById(id);
    }
}
