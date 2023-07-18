package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
