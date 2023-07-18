package com.myproject.JOMServerApp.dao;

import com.myproject.JOMServerApp.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModuleDao extends JpaRepository<Module,Integer> {
}
