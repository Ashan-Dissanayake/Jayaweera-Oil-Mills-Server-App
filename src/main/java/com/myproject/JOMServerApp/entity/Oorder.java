package com.myproject.JOMServerApp.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Oorder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "doplaced")
    private Date doplaced;
    @Basic
    @Column(name = "doexpected")
    private Date doexpected;
    @Basic
    @Column(name = "expectedgrandtotal")
    private BigDecimal expectedgrandtotal;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "exporter_id", referencedColumnName = "id", nullable = false)
    private Exporter exporter;
    @ManyToOne
    @JoinColumn(name = "orderstatus_id", referencedColumnName = "id", nullable = false)
    private Orderstatus orderstatus;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
    @OneToMany(mappedBy = "oorder",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<Orderproduct> orderproducts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDoplaced() {
        return doplaced;
    }

    public void setDoplaced(Date doplaced) {
        this.doplaced = doplaced;
    }

    public Date getDoexpected() {
        return doexpected;
    }

    public void setDoexpected(Date doexpected) {
        this.doexpected = doexpected;
    }

    public BigDecimal getExpectedgrandtotal() {
        return expectedgrandtotal;
    }

    public void setExpectedgrandtotal(BigDecimal expectedgrandtotal) {
        this.expectedgrandtotal = expectedgrandtotal;
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

        Oorder oorder = (Oorder) o;

        if (id != null ? !id.equals(oorder.id) : oorder.id != null) return false;
        if (doplaced != null ? !doplaced.equals(oorder.doplaced) : oorder.doplaced != null) return false;
        if (doexpected != null ? !doexpected.equals(oorder.doexpected) : oorder.doexpected != null) return false;
        if (expectedgrandtotal != null ? !expectedgrandtotal.equals(oorder.expectedgrandtotal) : oorder.expectedgrandtotal != null)
            return false;
        if (description != null ? !description.equals(oorder.description) : oorder.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (doplaced != null ? doplaced.hashCode() : 0);
        result = 31 * result + (doexpected != null ? doexpected.hashCode() : 0);
        result = 31 * result + (expectedgrandtotal != null ? expectedgrandtotal.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Exporter getExporter() {
        return exporter;
    }

    public void setExporter(Exporter exporter) {
        this.exporter = exporter;
    }

    public Orderstatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Orderstatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Collection<Orderproduct> getOrderproducts() {
        return orderproducts;
    }

    public void setOrderproducts(Collection<Orderproduct> orderproducts) {
        this.orderproducts = orderproducts;
    }
}
