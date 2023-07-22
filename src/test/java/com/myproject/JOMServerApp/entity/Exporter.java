package com.myproject.JOMServerApp.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Exporter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "telephone")
    private String telephone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "contactperson")
    private String contactperson;
    @Basic
    @Column(name = "contacttlp")
    private String contacttlp;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "creditlimit")
    private BigDecimal creditlimit;
    @ManyToOne
    @JoinColumn(name = "exporterstatus_id", referencedColumnName = "id", nullable = false)
    private Exporterstatus exporterstatus;
    @ManyToOne
    @JoinColumn(name = "exportertype_id", referencedColumnName = "id", nullable = false)
    private Exportertype exportertype;
    @OneToMany(mappedBy = "exporter")
    private Collection<Order> orders;

    public Exporter(){}

    public  Exporter(Integer id, String name){
        this.id = id;
        this.name = name;
    }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getContacttlp() {
        return contacttlp;
    }

    public void setContacttlp(String contacttlp) {
        this.contacttlp = contacttlp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(BigDecimal creditlimit) {
        this.creditlimit = creditlimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exporter exporter = (Exporter) o;

        if (id != null ? !id.equals(exporter.id) : exporter.id != null) return false;
        if (name != null ? !name.equals(exporter.name) : exporter.name != null) return false;
        if (telephone != null ? !telephone.equals(exporter.telephone) : exporter.telephone != null) return false;
        if (email != null ? !email.equals(exporter.email) : exporter.email != null) return false;
        if (address != null ? !address.equals(exporter.address) : exporter.address != null) return false;
        if (contactperson != null ? !contactperson.equals(exporter.contactperson) : exporter.contactperson != null)
            return false;
        if (contacttlp != null ? !contacttlp.equals(exporter.contacttlp) : exporter.contacttlp != null) return false;
        if (description != null ? !description.equals(exporter.description) : exporter.description != null)
            return false;
        if (creditlimit != null ? !creditlimit.equals(exporter.creditlimit) : exporter.creditlimit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (contactperson != null ? contactperson.hashCode() : 0);
        result = 31 * result + (contacttlp != null ? contacttlp.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creditlimit != null ? creditlimit.hashCode() : 0);
        return result;
    }

    public Exporterstatus getExporterstatus() {
        return exporterstatus;
    }

    public void setExporterstatus(Exporterstatus exporterstatus) {
        this.exporterstatus = exporterstatus;
    }

    public Exportertype getExportertype() {
        return exportertype;
    }

    public void setExportertype(Exportertype exportertype) {
        this.exportertype = exportertype;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
