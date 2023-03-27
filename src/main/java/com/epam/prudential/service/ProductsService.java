package com.epam.prudential.service;

import com.epam.prudential.model.Products;

import java.util.List;


public interface ProductsService {

    public void addProducts(Products products);

    public List<Products> getAllProducts();

    public void updateProducts(Products products);

    public void deleteProducts(String id);
}
