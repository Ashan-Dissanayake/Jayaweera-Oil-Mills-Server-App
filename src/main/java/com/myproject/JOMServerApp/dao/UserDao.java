package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
