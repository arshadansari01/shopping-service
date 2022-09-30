package com.shopping.repository;

import com.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {


    List<Product> findByCategoryName(String brand);

    List<Product> findByName(String name);
}
