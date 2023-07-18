package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.GenderDao;
import com.myproject.JOMServerApp.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/genders")
public class GenderController {

    @Autowired
    private GenderDao genderDao;

    @GetMapping(path="/list",produces = "application/json")

    public List<Gender> get(){

        List<Gender> genders = this.genderDao.findAll();

        genders = genders.stream().map(
                genderEntity -> {
                    Gender g = new Gender();
                    g.setName(genderEntity.getName());
                    g.setId(genderEntity.getId());
                    return g;}
        ).collect(Collectors.toList());

        return genders;
    }
}
