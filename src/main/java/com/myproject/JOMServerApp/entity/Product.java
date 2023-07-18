package com.myproject.JOMServerApp.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "jayaweeraoilmills", catalog = "")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "expireduration")
    private Integer expireduration;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "image")
    private byte[] image;
    @Basic
    @Column(name = "stock")
    private BigDecimal stock;
    @Basic
    @Column(name = "rpp")
    private BigDecimal rpp;
    @Basic
    @Column(name = "dointroduction")
    private Date dointroduction;
    @ManyToOne
    @JoinColumn(name = "producttype_id", referencedColumnName = "id", nullable = false)
    private Producttype producttype;
    @ManyToOne
    @JoinColumn(name = "productstatus_id", referencedColumnName = "id", nullable = false)
    private Productstatus productstatus;
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id", nullable = false)
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id", nullable = false)
    private Subcategory subcategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getExpireduration() {
        return expireduration;
    }

    public void setExpireduration(Integer expireduration) {
        this.expireduration = expireduration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getRpp() {
        return rpp;
    }

    public void setRpp(BigDecimal rpp) {
        this.rpp = rpp;
    }

    public Date getDointroduction() {
        return dointroduction;
    }

    public void setDointroduction(Date dointroduction) {
        this.dointroduction = dointroduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(price, that.price) && Objects.equals(expireduration, that.expireduration) && Objects.equals(description, that.description) && Arrays.equals(image, that.image) && Objects.equals(stock, that.stock) && Objects.equals(rpp, that.rpp) && Objects.equals(dointroduction, that.dointroduction);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, code, price, expireduration, description, stock, rpp, dointroduction);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    public Producttype getProducttype() {
        return producttype;
    }

    public void setProducttype(Producttype producttype) {
        this.producttype = producttype;
    }

    public Productstatus getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(Productstatus productstatus) {
        this.productstatus = productstatus;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
