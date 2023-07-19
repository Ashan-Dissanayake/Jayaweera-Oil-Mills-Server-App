package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.EmployeeDao;
import com.myproject.JOMServerApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@PermitAll
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping(produces = "application/json")
    public List<Employee> get(@RequestParam HashMap<String, String> params){

        String number = params.get("number");
        String genderid = params.get("genderid");
        String callingname = params.get("callingname");
        String designationid = params.get("designationid");

        List<Employee> employees = this.employeeDao.findAll();

        if (params.isEmpty()) return employees;

        employees = employees.stream().filter(
                employeeEntity -> {
                    if (number!=null) return employeeEntity.getNumber().equals(number);
                    if (genderid!=null) return employeeEntity.getGender().getId()==Integer.parseInt(genderid);
                    if (callingname!=null) return employeeEntity.getCallingname().contains(callingname);
                    if (designationid!=null) return employeeEntity.getDesignation().getId()==Integer.parseInt(designationid);
                    return false;}
        ).collect(Collectors.toList());

        return employees;
    }

    @GetMapping(path ="/list",produces = "application/json")
    public List<Employee> get() {

        List<Employee> employees = this.employeeDao.findAllNameId();

        employees = employees.stream().map(
                employee -> {
                    Employee e = new Employee(employee.getId(), employee.getCallingname());
                    return  e;
                }
        ).collect(Collectors.toList());

        return employees;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Employee employee){

        HashMap<String,String> response = new HashMap<>();
        String errors ="";

        if (employeeDao.findByNumber(employee.getNumber())!=null)
            errors = errors+"<br> Existing Number";
        if (employeeDao.findByNic(employee.getNic())!=null)
            errors = errors+"<br> Existing Nic";

        if (errors=="")
            employeeDao.save(employee);
        else errors = "Server Validation Errors : <br> "+ errors;

        response.put("id",String.valueOf(employee.getId()));
        response.put("url","/employees/"+employee.getId());
        response.put("errors",errors);

        return response;
    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, String> update(@RequestBody Employee employee){
        HashMap<String, String> response = new HashMap<>();

        String errors="";

        Employee emp1 = employeeDao.findByNumber(employee.getNumber());
        Employee emp2 = employeeDao.findByNic(employee.getNic());

        if (emp1!=null && employee.getId()!=emp1.getId())
            errors = errors + "<br> Existing Number";
        if (emp2!=null && employee.getId()!=emp2.getId())
            errors = errors + "<br> Existing NIC";

        if (errors=="") employeeDao.save(employee);
        else errors = "Server Validation Errors : <br> "+ errors;

        response.put("id",String.valueOf(employee.getId()));
        response.put("url","/employees/"+employee.getId());
        response.put("errors",errors);

        return response;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        System.out.println(id);
        HashMap<String,String> response = new HashMap<>();
        String errors="";
        Employee emp1 = employeeDao.findByMyId(id);
        if(emp1==null)
            errors = errors+"<br> Employee Does Not Existed";
        if(errors=="") employeeDao.delete(emp1);
        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(id));
        response.put("url","/employees/"+id);
        response.put("errors",errors);

        return response;
    }
}
