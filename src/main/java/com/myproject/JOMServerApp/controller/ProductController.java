package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ProductDao;
import com.myproject.JOMServerApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Product product){

        HashMap<String,String> response = new HashMap<>();
        String errors ="";

        if (productdao.findByCode(product.getCode())!=null)
            errors = errors+"<br> Existing Code";


        if (errors=="")
            productdao.save(product);
        else errors = "Server Validation Errors : <br> "+ errors;

        response.put("id",String.valueOf(product.getId()));
        response.put("url","/products/"+product.getId());
        response.put("errors",errors);

        return response;
    }


}
