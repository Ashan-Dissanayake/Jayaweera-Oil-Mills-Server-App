package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.PaymentStatusDao;
import com.myproject.JOMServerApp.entity.Paymentstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/paymentstatuses")
public class PaymentStatusController {

    @Autowired
    private PaymentStatusDao paymentStatusdao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Paymentstatus> get(){

        List<Paymentstatus> paymentstatuses = this.paymentStatusdao.findAll();


        paymentstatuses = paymentstatuses.stream().map(
                paymentstatus -> {
                    Paymentstatus p = new Paymentstatus();
                    p.setId(paymentstatus.getId());
                    p.setName(paymentstatus.getName());
                    return p;}
        ).collect(Collectors.toList());

        return paymentstatuses;
    }
}
