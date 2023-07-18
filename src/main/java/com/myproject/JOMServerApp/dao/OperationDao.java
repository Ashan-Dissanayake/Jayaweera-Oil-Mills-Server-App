package com.myproject.JOMServerApp.dao;

import com.myproject.JOMServerApp.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationDao extends JpaRepository<Operation,Integer> {
}
