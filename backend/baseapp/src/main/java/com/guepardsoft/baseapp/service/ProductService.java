package com.guepardsoft.baseapp.service;


import com.guepardsoft.baseapp.domain.Product;
import com.guepardsoft.baseapp.repository.ProductRepository;
import com.guepardsoft.baseapp.web.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts(){
    List<Product> users = productRepository.findAll();
    return users;
  }

  public Product getProductById(String id){
    return productRepository.getProductByIdString(id);
  }

  public void addProduct(ProductController.ProductRequestDTO newUserDTO){
    Product product = new Product();
    product.setName(newUserDTO.getName());
    product.setDescription(newUserDTO.getDescription());
    product.setPrice(newUserDTO.getPrice());
    productRepository.save(product);
    System.out.println("add product --->" + product);
  }

  public void updateProduct(Product product){
    productRepository.save(product);
    System.out.println("Update product: " + product);
  }

  public void deleteproduct(String id){
    Product product = productRepository.getProductByIdString(id);
    productRepository.delete(product);
    System.out.println("Delete product: " + product);
  }
}
