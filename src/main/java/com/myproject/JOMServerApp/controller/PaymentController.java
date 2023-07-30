package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.PaymentDao;
import com.myproject.JOMServerApp.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;

@CrossOrigin
@PermitAll
@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentDao paymentdao;

    @GetMapping(produces = "application/json")
    public List<Payment> get(){

        List<Payment> payments = this.paymentdao.findAll();

        return payments;
    }


}
