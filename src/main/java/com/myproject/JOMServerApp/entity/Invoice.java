package com.myproject.JOMServerApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "grandtotal")
    private BigDecimal grandtotal;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "oorder_id", referencedColumnName = "id", nullable = false)
    private Oorder oorder;
    @ManyToOne
    @JoinColumn(name = "invoicestatus_id", referencedColumnName = "id", nullable = false)
    private Invoicestatus invoicestatus;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @JsonIgnore
    @OneToMany(mappedBy = "invoice")
    private Collection<Invoiceorderproduct> invoiceorderproducts;

    public Invoice(){}

    public Invoice(int id, String name){
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(BigDecimal grandtotal) {
        this.grandtotal = grandtotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Oorder getOorder() {
        return oorder;
    }

    public void setOorder(Oorder oorder) {
        this.oorder = oorder;
    }

    public Invoicestatus getInvoicestatus() {
        return invoicestatus;
    }

    public void setInvoicestatus(Invoicestatus invoicestatus) {
        this.invoicestatus = invoicestatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Collection<Invoiceorderproduct> getInvoiceorderproducts() {
        return invoiceorderproducts;
    }

    public void setInvoiceorderproducts(Collection<Invoiceorderproduct> invoiceorderproducts) {
        this.invoiceorderproducts = invoiceorderproducts;
    }
}
