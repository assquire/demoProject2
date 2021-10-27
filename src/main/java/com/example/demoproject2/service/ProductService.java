package com.example.demoproject2.service;

import com.example.demoproject2.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Product saveProduct(Product product);

    Product getProduct(Long id);

    Optional<Product> getOptionalProduct(Long id);

    Product changeProduct();

    void deleteProduct(Long id);

    List<Product> getProducts();

    List<Product> getEnabledProducts();

    boolean productExists(Long id);

}
