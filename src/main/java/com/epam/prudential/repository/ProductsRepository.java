package com.epam.prudential.repository;

import com.epam.prudential.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {
}
