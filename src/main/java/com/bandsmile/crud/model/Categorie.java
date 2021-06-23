package com.bandsmile.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "categorie")
    private Collection<Produit> produits = new ArrayList<Produit>();

    public Categorie() {
    }

    public Categorie(Long id, @NotEmpty String type, Collection<Produit> produits) {
        this.id = id;
        this.type = type;
        this.produits = produits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }
}
