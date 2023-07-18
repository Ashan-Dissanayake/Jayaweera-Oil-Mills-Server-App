package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ProductStatusDao;
import com.myproject.JOMServerApp.entity.Productstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/productstatuses")
public class ProductStatusController {

    @Autowired
    private ProductStatusDao productStatusdao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Productstatus> get(){

        List<Productstatus> productstatuses = this.productStatusdao.findAll();


        productstatuses = productstatuses.stream().map(
                productstatus -> {
                    Productstatus p = new Productstatus();
                    p.setName(productstatus.getName());
                    p.setId(productstatus.getId());
                    return p;}
        ).collect(Collectors.toList());

        return productstatuses;
    }
}
