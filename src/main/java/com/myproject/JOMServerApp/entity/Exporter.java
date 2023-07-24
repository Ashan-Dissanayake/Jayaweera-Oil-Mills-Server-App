package com.myproject.JOMServerApp.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Objects;

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
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Telephone Number")
    private String telephone;
    @Basic
    @Column(name = "email")
    @Pattern(regexp = "^(?=.{1,155}$)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid Email Address")
    private String email;
    @Basic
    @Column(name = "address")
    @Pattern(regexp = "^([\\w\\/\\-,\\s]{2,})$", message = "Invalid Address")
    private String address;
    @Basic
    @Column(name = "contactperson")
    private String contactperson;
    @Basic
    @Column(name = "contacttlp")
    @Pattern(regexp = "^0\\d{9}$", message = "Invalid Contact Number")
    private String contacttlp;
    @Basic
    @Column(name = "description")
    @Pattern(regexp = "^.*$", message = "Invalid Description")
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

public Exporter(){}

    public Exporter(int id, String name){
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
        return Objects.equals(id, exporter.id) && Objects.equals(name, exporter.name) && Objects.equals(telephone, exporter.telephone) && Objects.equals(email, exporter.email) && Objects.equals(address, exporter.address) && Objects.equals(contactperson, exporter.contactperson) && Objects.equals(contacttlp, exporter.contacttlp) && Objects.equals(description, exporter.description) && Objects.equals(creditlimit, exporter.creditlimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telephone, email, address, contactperson, contacttlp, description, creditlimit);
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

}
