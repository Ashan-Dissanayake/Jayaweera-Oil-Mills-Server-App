package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Employeestatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeStatusDao extends JpaRepository<Employeestatus,Integer> {
}
