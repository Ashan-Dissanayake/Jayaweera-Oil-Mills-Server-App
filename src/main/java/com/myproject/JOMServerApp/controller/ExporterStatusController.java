package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ExporterStatusDao;
import com.myproject.JOMServerApp.entity.Exporterstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/exporterstatuses")
public class ExporterStatusController {

    @Autowired
    private ExporterStatusDao exporterStatusdao;

    @GetMapping(path="/list",produces = "application/json")

    public List<Exporterstatus> get(){

        List<Exporterstatus> exporterstatuses = this.exporterStatusdao.findAll();

        exporterstatuses = exporterstatuses.stream().map(
                exporterstatus -> {
                    Exporterstatus e = new Exporterstatus();
                    e.setName(exporterstatus.getName());
                    e.setId(exporterstatus.getId());
                    return e;}
        ).collect(Collectors.toList());

        return exporterstatuses;
    }
}
