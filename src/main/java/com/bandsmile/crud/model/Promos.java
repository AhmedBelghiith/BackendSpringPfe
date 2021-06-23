package com.bandsmile.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "promos")
public class Promos {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column(name = "pourcentage",nullable = false)
    private Double pourcentage;

    @NotEmpty
    @Column(name = "dateDeb")
    private Date dateDeb;

    @NotEmpty
    @Column(name = "dateFin")
    private Date dateFin;

    public Promos(Long id, Double pourcentage, Date dateDeb, Date dateFin) {
        this.id = id;
        this.pourcentage = pourcentage;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public Promos() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

}

