package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Paymenttype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeDao extends JpaRepository<Paymenttype,Integer> {
}
