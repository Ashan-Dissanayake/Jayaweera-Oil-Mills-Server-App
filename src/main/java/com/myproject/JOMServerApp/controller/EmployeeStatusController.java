package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.EmployeeStatusDao;
import com.myproject.JOMServerApp.entity.Employeestatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/employeestatuses")
public class EmployeeStatusController {

    @Autowired
    private EmployeeStatusDao employeestatusDao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Employeestatus> get(){

        List<Employeestatus> employeestatuss = this.employeestatusDao.findAll();


        employeestatuss = employeestatuss.stream().map(
                employeestatusEntity -> {
                    Employeestatus d = new Employeestatus();
                    d.setName(employeestatusEntity.getName());
                    d.setId(employeestatusEntity.getId());
                    return d;}
        ).collect(Collectors.toList());

        return employeestatuss;
    }
}
