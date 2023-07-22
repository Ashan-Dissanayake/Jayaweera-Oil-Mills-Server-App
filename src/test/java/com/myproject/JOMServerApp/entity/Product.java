package com.myproject.JOMServerApp.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Product {
    @OneToMany(mappedBy = "product")
    private Collection<Orderproduct> orderproducts;

    public Collection<Orderproduct> getOrderproducts() {
        return orderproducts;
    }

    public void setOrderproducts(Collection<Orderproduct> orderproducts) {
        this.orderproducts = orderproducts;
    }
}
