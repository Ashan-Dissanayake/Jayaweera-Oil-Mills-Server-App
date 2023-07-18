package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitDao extends JpaRepository<Unit,Integer> {
}
