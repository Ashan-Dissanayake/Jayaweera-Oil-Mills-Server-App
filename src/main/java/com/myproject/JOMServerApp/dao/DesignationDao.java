package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationDao extends JpaRepository<Designation,Integer> {
}
