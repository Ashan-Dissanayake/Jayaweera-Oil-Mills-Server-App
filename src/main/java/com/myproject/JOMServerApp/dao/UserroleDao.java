package com.myproject.JOMServerApp.dao;

import com.myproject.JOMServerApp.entity.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserroleDao extends JpaRepository<Userrole, Integer> {

    Userrole findById(int id);

}
