package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ExporterDao;
import com.myproject.JOMServerApp.dao.GenderDao;
import com.myproject.JOMServerApp.entity.Exporter;
import com.myproject.JOMServerApp.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/exporters")
public class ExportController {

    @Autowired
    private ExporterDao exporterdao;

    @GetMapping(path="/list",produces = "application/json")

    public List<Exporter> get(){

        List<Exporter> exporters = this.exporterdao.findAllNameId();

        exporters = exporters.stream().map(
                exporter -> {
                    Exporter x = new Exporter(exporter.getId(),exporter.getName());
                    return x;}
        ).collect(Collectors.toList());

        return exporters;
    }
}
