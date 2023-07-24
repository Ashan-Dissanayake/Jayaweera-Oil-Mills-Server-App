package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDao extends JpaRepository<Invoice,Integer> {

    @Query("select i from Invoice i where i.id = :id")
    Invoice findByMyId(@Param("id") Integer id);

    @Query("SELECT NEW Invoice (i.id,i.name) FROM Invoice i")
    List<Invoice> findAllNameID();
}
