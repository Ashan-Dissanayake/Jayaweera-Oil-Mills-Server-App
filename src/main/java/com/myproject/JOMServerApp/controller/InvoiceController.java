package com.myproject.JOMServerApp.controller;


import com.myproject.JOMServerApp.dao.InvoiceDao;
import com.myproject.JOMServerApp.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceDao invoicedao;

    @GetMapping(path ="/list",produces = "application/json")
    public List<Invoice> get() {

        List<Invoice> invoices = this.invoicedao.findAllNameID();

        invoices = invoices.stream().map(
                invoice -> {
                    Invoice i = new Invoice(invoice.getId(),invoice.getName());
                    return i;
                }
        ).collect(Collectors.toList());

        return invoices;

    }

    @GetMapping(produces = "application/json")
    public List<Invoice> get(@RequestParam HashMap<String, String> params){

        String invoicestatusid = params.get("invoicestatusid");
        String name = params.get("name");
        String date = params.get("date");

        List<Invoice> invoices = this.invoicedao.findAll();

        if (params.isEmpty()) return invoices;

        Stream<Invoice> istream = invoices.stream();
                    if (invoicestatusid!=null) istream = istream.filter(i -> i.getInvoicestatus().getId()==Integer.parseInt(invoicestatusid));
                    if (name!=null) istream = istream.filter(i -> i.getName().contains(name));
                    if (date!=null) istream = istream.filter(i -> i.getDate().toString().contains(date)) ;

        return istream.collect(Collectors.toList());

    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public HashMap<String, String> add(@RequestBody Oorder order) {
//        HashMap<String, String> response = new HashMap<>();
//
//        String errors = "";
//
//        for (Orderproduct op : order.getOrderproducts()) op.setOorder(order);
//
//        orderdao.save(order);
//
//        response.put("id", String.valueOf(order.getId()));
//        response.put("url", "/orders/" + order.getId());
//        response.put("errors", errors);
//
//        return response;
//
//    }


//    @PutMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public HashMap<String, String> update(@RequestBody Oorder order) {
//
//        HashMap<String, String> response = new HashMap<>();
//        String errors = "";
//
//        Oorder extOrder = orderdao.findByMyId(order.getId());
//
//
//        if (extOrder != null) {
//
//            try {
//                extOrder.getOrderproducts().clear();
//                order.getOrderproducts().forEach(neworderproduct -> {
//                    neworderproduct.setOorder(extOrder);
//                    extOrder.getOrderproducts().add(neworderproduct);
//                    neworderproduct.setOorder(extOrder);
//                });
//
//                BeanUtils.copyProperties(order, extOrder, "id","orderproducts","qty");
//
//                orderdao.save(extOrder); // Save the updated extUser object
//
//                response.put("id", String.valueOf(order.getId()));
//                response.put("url", "/orders/" + order.getId());
//                response.put("errors", errors);
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        return response;
//    }


//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public HashMap<String,String> delete(@PathVariable Integer id){
//
//        HashMap<String,String> responce = new HashMap<>();
//        String errors="";
//
//        Oorder ord = orderdao.findByMyId(id);
//
//        if(ord==null)
//            errors = errors+"<br> Order Does Not Existed";
//
//        if(errors=="") orderdao.delete(ord);
//        else errors = "Server Validation Errors : <br> "+errors;
//
//        responce.put("code",String.valueOf(id));
//        responce.put("url","/id/"+id);
//        responce.put("errors",errors);
//
//        return responce;
//    }

}


