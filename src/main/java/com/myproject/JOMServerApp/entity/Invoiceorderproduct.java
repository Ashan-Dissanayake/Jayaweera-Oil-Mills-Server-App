package com.myproject.JOMServerApp.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Invoiceorderproduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "qty")
    private BigDecimal qty;
    @Basic
    @Column(name = "linetotal")
    private BigDecimal linetotal;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false)
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "orderproduct_id", referencedColumnName = "id", nullable = false)
    private Orderproduct orderproduct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getLinetotal() {
        return linetotal;
    }

    public void setLinetotal(BigDecimal linetotal) {
        this.linetotal = linetotal;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Orderproduct getOrderproduct() {
        return orderproduct;
    }

    public void setOrderproduct(Orderproduct orderproduct) {
        this.orderproduct = orderproduct;
    }
}
