package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.DesignationDao;
import com.myproject.JOMServerApp.entity.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/designations")
public class DesignationController {

    @Autowired
    private DesignationDao designationDao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Designation> get(){

        List<Designation> designations = this.designationDao.findAll();


        designations = designations.stream().map(
                designationEntity -> {
                    Designation d = new Designation();
                    d.setName(designationEntity.getName());
                    d.setId(designationEntity.getId());
                    return d;}
        ).collect(Collectors.toList());

        return designations;
    }
}
