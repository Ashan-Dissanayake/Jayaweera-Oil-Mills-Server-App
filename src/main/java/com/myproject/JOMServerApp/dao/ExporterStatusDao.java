package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Exporterstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExporterStatusDao extends JpaRepository<Exporterstatus,Integer> {
}
