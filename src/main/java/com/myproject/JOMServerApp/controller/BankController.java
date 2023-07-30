package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.BankDao;
import com.myproject.JOMServerApp.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/banks")
public class BankController {

    @Autowired
    private BankDao bankdao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Bank> get(){

        List<Bank> banks = this.bankdao.findAll();


        banks = banks.stream().map(
                bank -> {
                    Bank b = new Bank();
                    b.setId(bank.getId());
                    b.setName(bank.getName());
                    return b;}
        ).collect(Collectors.toList());

        return banks;
    }
}
