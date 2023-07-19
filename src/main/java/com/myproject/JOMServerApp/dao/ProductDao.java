package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product findByCode(String code);
}
