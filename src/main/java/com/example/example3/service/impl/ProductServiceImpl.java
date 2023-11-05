package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.Product;
import com.example.example3.repository.ProductRespository;
import com.example.example3.service.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRespository productRespository;

    @Override
    public Product createProduct(Product product) {
        return productRespository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalCategory = productRespository.findById(productId);
        return optionalCategory.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRespository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRespository.findById(product.getId()).get();
        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setThumbnail(product.getThumbnail());
        existingProduct.setCreated_at(product.getCreated_at());
        existingProduct.setUpdated_at(product.getUpdated_at());
        existingProduct.setDeleted(product.getDeleted());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setGalleries(product.getGalleries());
        existingProduct.setOrderDetails(product.getOrderDetails());
        Product updatedProduct = productRespository.save(existingProduct);
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRespository.deleteById(productId);
    }
}