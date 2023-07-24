package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Exporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExporterDao extends JpaRepository<Exporter,Integer> {

    Exporter findByEmail(String email);

    @Query("select e from Exporter e where e.id = :id")
    Exporter findByMyId(@Param("id") Integer id);

    @Query("SELECT NEW Exporter (e.id,e.name) FROM Exporter e")
    List<Exporter> findAllNameID();
}
