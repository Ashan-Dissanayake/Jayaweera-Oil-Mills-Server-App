package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Employee;
import com.myproject.JOMServerApp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentDao extends JpaRepository<Payment,Integer> {

    @Query("select p from Payment p where p.id = :id")
    Employee findByMyId(@Param("id") Integer id);
}
