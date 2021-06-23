package com.bandsmile.crud.model;

import javax.persistence.*;
import java.util.Date;

public class Facture {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "price")
    private Float price;
    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
