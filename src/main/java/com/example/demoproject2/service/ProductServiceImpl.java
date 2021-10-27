package com.example.demoproject2.service;

import com.example.demoproject2.model.Product;
import com.example.demoproject2.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public Optional<Product> getOptionalProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product changeProduct() {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getEnabledProducts() {
        return productRepository.findAllByIsEnabled();
    }

    @Override
    public boolean productExists(Long id) {
        return productRepository.existsById(id);
    }
}
