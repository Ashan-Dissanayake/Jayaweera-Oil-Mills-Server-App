package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryDao extends JpaRepository<Subcategory,Integer> {
}
