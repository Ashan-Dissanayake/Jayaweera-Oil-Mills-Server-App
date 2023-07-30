package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.PaymentTypeDao;
import com.myproject.JOMServerApp.entity.Paymenttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/paymenttypes")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeDao paymentTypedao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Paymenttype> get(){

        List<Paymenttype> paymenttypes = this.paymentTypedao.findAll();


        paymenttypes = paymenttypes.stream().map(
                paymenttype -> {
                    Paymenttype p = new Paymenttype();
                    p.setId(paymenttype.getId());
                    p.setName(paymenttype.getName());
                    return p;}
        ).collect(Collectors.toList());

        return paymenttypes;
    }
}
