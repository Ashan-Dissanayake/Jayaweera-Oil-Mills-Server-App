package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.InvoiceStatusDao;
import com.myproject.JOMServerApp.entity.Invoicestatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/invoicestasuses")
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusDao invoiceStatusdao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Invoicestatus> get(){

        List<Invoicestatus> invoicestatuses = this.invoiceStatusdao.findAll();


        invoicestatuses = invoicestatuses.stream().map(
                invoicestatus -> {
                    Invoicestatus i = new Invoicestatus();
                    i.setId(invoicestatus.getId());
                    i.setName(invoicestatus.getName());
                    return i;}
        ).collect(Collectors.toList());

        return invoicestatuses;
    }
}
