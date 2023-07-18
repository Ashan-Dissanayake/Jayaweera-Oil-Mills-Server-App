package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.CategoryDao;
import com.myproject.JOMServerApp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryDao categorydao;

    @GetMapping(path = "/list",produces = "application/json")

    public List<Category> get(){

        List<Category> categories = this.categorydao.findAll();


        categories = categories.stream().map(
                category -> {
                    Category c = new Category();
                    c.setId(category.getId());
                    c.setName(category.getName());
                    return c;}
        ).collect(Collectors.toList());

        return categories;
    }
}
