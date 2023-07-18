package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.UnitDao;
import com.myproject.JOMServerApp.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/units")
public class UnitController {

    @Autowired
    private UnitDao unitdao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Unit> get(){

        List<Unit> units = this.unitdao.findAll();


        units = units.stream().map(
                unit -> {
                    Unit u = new Unit();
                    u.setId(unit.getId());
                    u.setName(unit.getName());
                    return u;}
        ).collect(Collectors.toList());

        return units;
    }
}
