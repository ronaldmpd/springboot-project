package com.guepardsoft.baseapp.repository;

import com.guepardsoft.baseapp.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {
  @Query("{id: ?0}")
  Product getProductByIdString(String id);
}
