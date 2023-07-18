package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Productstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStatusDao extends JpaRepository<Productstatus,Integer> {
}
