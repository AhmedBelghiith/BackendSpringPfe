package com.bandsmile.crud.model;
import javax.persistence.*;

@Entity
@Table(name = "Panier")
public class Panier {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "totalePanier",nullable = false)
    private Double totalePanier;


}
