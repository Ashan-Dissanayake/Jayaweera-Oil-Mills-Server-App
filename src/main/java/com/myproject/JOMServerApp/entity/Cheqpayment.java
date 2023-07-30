package com.myproject.JOMServerApp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Cheqpayment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "cheqnumber")
    private String cheqnumber;
    @Basic
    @Column(name = "dorealized")
    private Date dorealized;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id", nullable = false)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id", nullable = false)
    private Bank bank;
    @ManyToOne
    @JoinColumn(name = "cheqstatus_id", referencedColumnName = "id", nullable = false)
    private Cheqstatus cheqstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheqnumber() {
        return cheqnumber;
    }

    public void setCheqnumber(String cheqnumber) {
        this.cheqnumber = cheqnumber;
    }

    public Date getDorealized() {
        return dorealized;
    }

    public void setDorealized(Date dorealized) {
        this.dorealized = dorealized;
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
        Cheqpayment that = (Cheqpayment) o;
        return Objects.equals(id, that.id) && Objects.equals(cheqnumber, that.cheqnumber) && Objects.equals(dorealized, that.dorealized) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cheqnumber, dorealized, description);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Cheqstatus getCheqstatus() {
        return cheqstatus;
    }

    public void setCheqstatus(Cheqstatus cheqstatus) {
        this.cheqstatus = cheqstatus;
    }
}
