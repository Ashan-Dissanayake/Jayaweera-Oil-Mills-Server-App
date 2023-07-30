package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Cheqpayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheqPaymentDao extends JpaRepository<Cheqpayment,Integer> {
}
