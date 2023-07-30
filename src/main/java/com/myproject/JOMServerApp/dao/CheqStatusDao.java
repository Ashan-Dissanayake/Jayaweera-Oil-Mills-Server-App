package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Cheqstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheqStatusDao extends JpaRepository<Cheqstatus,Integer> {
}
