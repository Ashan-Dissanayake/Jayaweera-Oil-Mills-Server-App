package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.OrderDao;
import com.myproject.JOMServerApp.entity.Oorder;
import com.myproject.JOMServerApp.entity.Orderproduct;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderDao orderdao;

    @GetMapping(produces = "application/json")
    public List<Oorder> get(@RequestParam HashMap<String, String> params){

        String exporterid = params.get("exporterid");
        String employeeid = params.get("employeeid");
        String doplaced = params.get("doplaced");

        List<Oorder> orders = this.orderdao.findAll();

        if (params.isEmpty()) return orders;

        orders = orders.stream().filter(
                order -> {
                    if (exporterid!=null) return order.getExporter().getId()==Integer.parseInt(exporterid);
                    if (employeeid!=null) return order.getEmployee().getId()==Integer.parseInt(employeeid);
                    if (doplaced!=null) return order.getDoplaced().toString().contains(doplaced);
                    return false;}
        ).collect(Collectors.toList());

        return orders;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, String> add(@RequestBody Oorder order) {
        HashMap<String, String> response = new HashMap<>();

        String errors = "";

        for (Orderproduct op : order.getOrderproducts()) op.setOorder(order);

        orderdao.save(order);

        response.put("id", String.valueOf(order.getId()));
        response.put("url", "/orders/" + order.getId());
        response.put("errors", errors);

        return response;

    }


    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String, String> update(@RequestBody Oorder order) {

        HashMap<String, String> response = new HashMap<>();
        String errors = "";

        Oorder extOrder = orderdao.findByMyId(order.getId());


        if (extOrder != null) {

            try {
                extOrder.getOrderproducts().clear();
                order.getOrderproducts().forEach(neworderproduct -> {
                    neworderproduct.setOorder(extOrder);
                    extOrder.getOrderproducts().add(neworderproduct);
                    neworderproduct.setOorder(extOrder);
                });

                BeanUtils.copyProperties(order, extOrder, "id","orderproducts","qty");

                orderdao.save(extOrder); // Save the updated extUser object

                response.put("id", String.valueOf(order.getId()));
                response.put("url", "/orders/" + order.getId());
                response.put("errors", errors);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return response;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Oorder ord = orderdao.findByMyId(id);

        if(ord==null)
            errors = errors+"<br> Order Does Not Existed";

        if(errors=="") orderdao.delete(ord);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("code",String.valueOf(id));
        responce.put("url","/id/"+id);
        responce.put("errors",errors);

        return responce;
    }

}


