package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.ExporterDao;
import com.myproject.JOMServerApp.entity.Exporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/exporters")
public class ExporterController {

    @Autowired
    private ExporterDao exporterdao;

    @GetMapping(produces = "application/json")
    public List<Exporter> get(@RequestParam HashMap<String, String> params){

        String name = params.get("name");
        String email = params.get("email");
        String contactperson = params.get("contactperson");
        String exporterstatus = params.get("exporterstatus");
        String exportertype = params.get("exportertype");

        List<Exporter> exporters  = this.exporterdao.findAll();
        if (params.isEmpty()) return exporters;

        Stream<Exporter> estream = exporters.stream();

                    if (name!=null) estream = estream.filter(e -> e.getContactperson().contains(name));
                    if (email!=null) estream = estream.filter(e -> e.getEmail().contains(email));
                    if (contactperson!=null) estream = estream.filter(e -> e.getContactperson().contains(contactperson));
                    if (exporterstatus!=null) estream = estream.filter(e -> e.getExporterstatus().getId()==Integer.parseInt(exporterstatus));
                    if (exportertype!=null) estream = estream.filter(e -> e.getExportertype().getId()==Integer.parseInt(exportertype));


        return estream.collect(Collectors.toList());

    }

    @GetMapping(path ="/list",produces = "application/json")
    public List<Exporter> get() {

        List<Exporter> exporters = this.exporterdao.findAllNameID();

        exporters = exporters.stream().map(
                exporter -> {
                    Exporter e = new Exporter(exporter.getId(),exporter.getName());
                    return e;
                }
        ).collect(Collectors.toList());

        return exporters;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Exporter exporter){

        HashMap<String,String> response = new HashMap<>();
        String errors ="";

        if (exporterdao.findByEmail(exporter.getEmail())!=null)
            errors = errors+"<br> Existing Email";

        if (errors=="")
            exporterdao.save(exporter);
        else errors = "Server Validation Errors : <br> "+ errors;

        response.put("id",String.valueOf(exporter.getId()));
        response.put("url","/exporters/"+exporter.getId());
        response.put("errors",errors);

        return response;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, String> update(@RequestBody Exporter exporter){
        HashMap<String, String> response = new HashMap<>();

        String errors="";

        Exporter exp1 = exporterdao.findByEmail(exporter.getEmail());

        if (exp1!=null && exporter.getId()!=exp1.getId())
            errors = errors + "<br> Existing Email";

        if (errors=="") exporterdao.save(exporter);
        else errors = "Server Validation Errors : <br> "+ errors;

        response.put("id",String.valueOf(exporter.getId()));
        response.put("url","/exporters/"+exporter.getId());
        response.put("errors",errors);

        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        System.out.println(id);
        HashMap<String,String> response = new HashMap<>();
        String errors="";
        Exporter exp1 = exporterdao.findByMyId(id);
        if(exp1==null)
            errors = errors+"<br> Employee Does Not Exist";
        if(errors=="") exporterdao.delete(exp1);
        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(id));
        response.put("url","/exporters/"+id);
        response.put("errors",errors);

        return response; }
}
