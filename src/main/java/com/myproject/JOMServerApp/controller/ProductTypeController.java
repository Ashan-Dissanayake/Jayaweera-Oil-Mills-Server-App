package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ProductTypeDao;
import com.myproject.JOMServerApp.entity.Producttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/producttypes")
public class ProductTypeController {

    @Autowired
    private ProductTypeDao productTypedao;

    @GetMapping(path="/list",produces = "application/json")

    public List<Producttype> get(){

        List<Producttype> producttypes = this.productTypedao.findAll();

        producttypes = producttypes.stream().map(
                producttype -> {
                    Producttype p = new Producttype();
                    p.setName(producttype.getName());
                    p.setId(producttype.getId());
                    return p;}
        ).collect(Collectors.toList());

        return producttypes;
    }
}
