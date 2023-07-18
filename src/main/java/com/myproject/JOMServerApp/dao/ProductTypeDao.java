package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Producttype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeDao extends JpaRepository<Producttype,Integer> {
}
