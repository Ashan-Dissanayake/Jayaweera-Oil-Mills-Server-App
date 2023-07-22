package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Orderstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderstatusDao extends JpaRepository<Orderstatus,Integer> {
}
