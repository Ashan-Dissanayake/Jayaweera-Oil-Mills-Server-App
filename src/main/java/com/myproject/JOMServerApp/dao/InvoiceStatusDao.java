package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Invoicestatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusDao extends JpaRepository<Invoicestatus,Integer> {
}
