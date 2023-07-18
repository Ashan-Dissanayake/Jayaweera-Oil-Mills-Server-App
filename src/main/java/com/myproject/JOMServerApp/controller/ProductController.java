package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ProductDao;
import com.myproject.JOMServerApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductDao productdao;

    @GetMapping(produces = "application/json")
    public List<Product> get(@RequestParam HashMap<String, String> params){

        String name = params.get("name");
        String code = params.get("code");
        String statusid = params.get("statusid");

        List<Product> products = this.productdao.findAll();
        if (params.isEmpty()) return products;

        products = products.stream().filter(
                product -> {
                    if (name!=null) return product.getName().contains(name);
                    if (code!=null) return product.getCode().equalsIgnoreCase(code);
                    if (statusid!=null) return product.getProductstatus().getId()==Integer.parseInt(statusid);
                    return false;}
        ).collect(Collectors.toList());

        return products;

    }
}
