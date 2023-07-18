package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.SubCategoryDao;
import com.myproject.JOMServerApp.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryDao subCategorydao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Subcategory> get(){

        List<Subcategory> subcategories = this.subCategorydao.findAll();


        subcategories = subcategories.stream().map(
                subcategory -> {
                    Subcategory d = new Subcategory();
                    d.setId(subcategory.getId());
                    d.setName(subcategory.getName());
                    d.setCategory(subcategory.getCategory());
                    return d;}
        ).collect(Collectors.toList());

        return subcategories;
    }
}
