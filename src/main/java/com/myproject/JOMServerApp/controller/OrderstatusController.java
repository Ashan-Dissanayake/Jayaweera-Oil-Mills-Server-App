package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.OrderstatusDao;
import com.myproject.JOMServerApp.entity.Orderstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/orderstatuses")
public class OrderstatusController {

    @Autowired
    private OrderstatusDao orderstatusdao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Orderstatus> get() {

        List<Orderstatus> orderstatuses = this.orderstatusdao.findAll();

        orderstatuses = orderstatuses.stream().map(
                orderstatus -> { Orderstatus o = new Orderstatus();
                            o.setId(orderstatus.getId());
                            o.setName(orderstatus.getName());
                            return o; }
        ).collect(Collectors.toList());

        return orderstatuses;

    }

}


