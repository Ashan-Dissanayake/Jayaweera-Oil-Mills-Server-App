package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Paymentstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentStatusDao extends JpaRepository<Paymentstatus,Integer> {
}
