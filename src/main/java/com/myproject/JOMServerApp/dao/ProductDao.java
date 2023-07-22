package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product findByCode(String code);

    @Query("select e from Product e where e.id = :id")
    Product findByMyId(@Param("id") Integer id);

    @Query("select NEW Product (p.id,p.name,p.price)from Product p")
    List<Product> findAllByNameIdPrice();

}
