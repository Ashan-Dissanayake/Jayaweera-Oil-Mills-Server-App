package com.myproject.JOMServerApp.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Orderproduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "qty")
    private BigDecimal qty;
    @Basic
    @Column(name = "expectedlinetotal")
    private BigDecimal expectedlinetotal;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

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

    public BigDecimal getExpectedlinetotal() {
        return expectedlinetotal;
    }

    public void setExpectedlinetotal(BigDecimal expectedlinetotal) {
        this.expectedlinetotal = expectedlinetotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderproduct that = (Orderproduct) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (qty != null ? !qty.equals(that.qty) : that.qty != null) return false;
        if (expectedlinetotal != null ? !expectedlinetotal.equals(that.expectedlinetotal) : that.expectedlinetotal != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (qty != null ? qty.hashCode() : 0);
        result = 31 * result + (expectedlinetotal != null ? expectedlinetotal.hashCode() : 0);
        return result;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
