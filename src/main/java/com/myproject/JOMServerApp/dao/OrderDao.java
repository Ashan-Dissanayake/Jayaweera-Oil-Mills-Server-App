package com.myproject.JOMServerApp.dao;


import com.myproject.JOMServerApp.entity.Employee;
import com.myproject.JOMServerApp.entity.Oorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDao extends JpaRepository<Oorder,Integer> {

    @Query("select e from Oorder e where e.id = :id")
    Oorder findByMyId(@Param("id") Integer id);

}
