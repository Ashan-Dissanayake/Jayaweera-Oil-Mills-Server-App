package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Userstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserstatusDao extends JpaRepository<Userstatus,Integer> {

}

