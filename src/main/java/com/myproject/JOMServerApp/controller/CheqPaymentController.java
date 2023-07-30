package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.CheqPaymentDao;
import com.myproject.JOMServerApp.entity.Cheqpayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/cheqpayments")
public class CheqPaymentController {

    @Autowired
    private CheqPaymentDao cheqPaymentdao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Cheqpayment> get(){

        List<Cheqpayment> cheqpayments = this.cheqPaymentdao.findAll();


        cheqpayments = cheqpayments.stream().map(
                cheqpayment -> {
                    Cheqpayment c = new Cheqpayment();
                    c.setId(cheqpayment.getId());
                    c.setCheqnumber(cheqpayment.getCheqnumber());
               //     c.setPayment(cheqpayment.getPayment());
                    return c;}
        ).collect(Collectors.toList());

        return cheqpayments;
    }
}
