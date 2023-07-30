package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.CheqStatusDao;
import com.myproject.JOMServerApp.entity.Cheqstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/cheqstatuses")
public class CheqStatusController {

    @Autowired
    private CheqStatusDao cheqStatusdao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Cheqstatus> get(){

        List<Cheqstatus> cheqstatuses = this.cheqStatusdao.findAll();


        cheqstatuses = cheqstatuses.stream().map(
                cheqstatus -> {
                    Cheqstatus c = new Cheqstatus();
                    c.setId(cheqstatus.getId());
                    c.setName(cheqstatus.getName());
                    return c;}
        ).collect(Collectors.toList());

        return cheqstatuses;
    }
}
