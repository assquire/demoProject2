package com.example.demoproject2.repo;

import com.example.demoproject2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM PRODUCT p WHERE p.enabled = true", nativeQuery = true)
    List<Product> findAllByIsEnabled();

}
