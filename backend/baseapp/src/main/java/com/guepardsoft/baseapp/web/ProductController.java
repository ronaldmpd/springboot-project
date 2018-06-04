package com.guepardsoft.baseapp.web;


import com.guepardsoft.baseapp.domain.Product;
import com.guepardsoft.baseapp.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")

public class ProductController {

  @Autowired
  ProductService productService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Product> getAllProducts(){
    return productService.getAllProducts();
  }

  @RequestMapping(path="/{id}",method = RequestMethod.GET)
  public Product getProductById(@PathVariable String id){
    return productService.getProductById(id);
  }


  @RequestMapping(method = RequestMethod.POST)
  public void addProduct(@RequestBody ProductRequestDTO newProductDTO){
    productService.addProduct(newProductDTO);
  }

  @RequestMapping(method = RequestMethod.PATCH)
  public void updateProduct(@RequestBody Product newProduct){
    productService.updateProduct(newProduct);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public void deleteProduct(@PathVariable String id){
    productService.deleteproduct(id);
  }


  public static class ProductRequestDTO{
    private String name;
    private String description;
    private Double price;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public Double getPrice() {
      return price;
    }

    public void setPrice(Double price) {
      this.price = price;
    }

    @Override
    public String toString() {
      return "ProductRequestDTO{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        '}';
    }
  }
}

