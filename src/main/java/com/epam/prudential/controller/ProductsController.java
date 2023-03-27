package com.epam.prudential.controller;

import com.epam.prudential.model.Products;
import com.epam.prudential.service.ProductsService;
import com.epam.prudential.service.impl.ProductsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsServiceImpl productsServiceImpl) {
        this.productsService = productsServiceImpl;
    }

    @PostMapping
    public ResponseEntity addProducts(@RequestBody Products products) {
        productsService.addProducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping
    public ResponseEntity<List<Products>> updateProducts(@RequestBody Products products) {
        productsService.updateProducts(products);
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        return ResponseEntity.ok(productsService.getAllProducts());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducts(@PathVariable String id) {
        productsService.deleteProducts(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
