package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderDao extends JpaRepository<Gender,Integer> {
}
