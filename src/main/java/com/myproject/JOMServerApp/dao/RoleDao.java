package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {

}

