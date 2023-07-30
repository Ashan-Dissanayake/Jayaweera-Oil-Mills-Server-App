package com.myproject.JOMServerApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "payment")
    private Collection<Cheqpayment> cheqpayments;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id", nullable = false)
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "paymenttype_id", referencedColumnName = "id", nullable = false)
    private Paymenttype paymenttype;
    @ManyToOne
    @JoinColumn(name = "paymentstatus_id", referencedColumnName = "id", nullable = false)
    private Paymentstatus paymentstatus;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(date, payment.date) && Objects.equals(amount, payment.amount) && Objects.equals(description, payment.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amount, description);
    }

    public Collection<Cheqpayment> getCheqpayments() {
        return cheqpayments;
    }

    public void setCheqpayments(Collection<Cheqpayment> cheqpayments) {
        this.cheqpayments = cheqpayments;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Paymenttype getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(Paymenttype paymenttype) {
        this.paymenttype = paymenttype;
    }

    public Paymentstatus getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(Paymentstatus paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
