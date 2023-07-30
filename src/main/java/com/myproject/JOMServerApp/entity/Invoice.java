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
    @OneToMany(mappedBy = "invoice" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<Invoiceproduct> invoiceproducts;

    public Invoice(){}

    public Invoice(Integer id,String name){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != null ? !id.equals(invoice.id) : invoice.id != null) return false;
        if (grandtotal != null ? !grandtotal.equals(invoice.grandtotal) : invoice.grandtotal != null) return false;
        if (date != null ? !date.equals(invoice.date) : invoice.date != null) return false;
        if (name != null ? !name.equals(invoice.name) : invoice.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (grandtotal != null ? grandtotal.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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

    public Collection<Invoiceproduct> getInvoiceproducts() {
        return invoiceproducts;
    }

    public void setInvoiceproducts(Collection<Invoiceproduct> invoiceproducts) {
        this.invoiceproducts = invoiceproducts;
    }
}
