package com.order.ordermanagement.Repository;

import com.order.ordermanagement.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional custom query methods if needed

    // Example: Find a product by name
    Product findByName(String name);

    // Example: Find all products that are stokable
    List<Product> findByStokableTrue();

}