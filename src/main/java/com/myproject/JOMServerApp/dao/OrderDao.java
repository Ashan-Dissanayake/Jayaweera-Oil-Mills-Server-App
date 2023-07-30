package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Oorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDao extends JpaRepository<Oorder,Integer> {

    @Query("select e from Oorder e where e.id = :id")
    Oorder findByMyId(@Param("id") Integer id);

    @Query("SELECT NEW Oorder(o.id,o.exporter) FROM Oorder o")
    List<Oorder> findAllByIdExporter();


}
