package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ExporterTypeDao;
import com.myproject.JOMServerApp.entity.Exportertype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/exportertypes")
public class ExporterTypeController {

    @Autowired
    private ExporterTypeDao exporterTypedao;

    @GetMapping(path="/list",produces = "application/json")

    public List<Exportertype> get(){

        List<Exportertype> exportertypes = this.exporterTypedao.findAll();

        exportertypes = exportertypes.stream().map(
                exportertype -> {
                    Exportertype e = new Exportertype();
                    e.setName(exportertype.getName());
                    e.setId(exportertype.getId());
                    return e;}
        ).collect(Collectors.toList());

        return exportertypes;
    }
}
