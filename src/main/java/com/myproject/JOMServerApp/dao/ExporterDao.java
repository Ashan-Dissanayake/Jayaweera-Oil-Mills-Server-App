package com.myproject.JOMServerApp.dao;



import com.myproject.JOMServerApp.entity.Exporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExporterDao extends JpaRepository<Exporter,Integer> {

    @Query("SELECT NEW Exporter (e.id, e.name) FROM Exporter e")
    List<Exporter> findAllNameId();
}
