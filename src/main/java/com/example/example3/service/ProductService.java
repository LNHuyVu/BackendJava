package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.Product;

public interface ProductService {

    public Product createProduct(Product product);

    public Product getProductById(Long productId);

    public List<Product> getAllProducts();

    public Product updateProduct(Product product);

    public void deleteProduct(Long productId);
}
