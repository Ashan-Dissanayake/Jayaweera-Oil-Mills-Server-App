package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDao extends JpaRepository<Bank,Integer> {
}
