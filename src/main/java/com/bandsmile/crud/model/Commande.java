package com.bandsmile.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue
    private Long id;


    @Size(min = 3,message = "Verifez votre Prenom")
    @Column(name = "Firstname",nullable = false)
    private String firstname;

    @Size(min = 3,message = "Verifez votre nom")
    @Column(name = "Lastname",nullable = false)
    private String lastname;

    @Email(message = "Verifiez Votre email")
    @Column(name = "Email",nullable = false)
    private String email;

    @NotEmpty(message = "Entrez votre adresse")
    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Adresse2")
    private String adresse2;

    @NotEmpty(message = "Entrez votre numero")
    @Size(min = 8,max = 13)
    @Column(name = "Tel")
    private String tel;

    @NotEmpty(message = "Selectionnez un pays")
    @Column(name = "Country")
    private String country;

    @Size(min = 4)
    @Column(name = "City",nullable = false)
    private String city;

    @Size(min = 4)
    @Column(name = "CodePost",nullable = false)
    private Integer codepost;

    @Column(name = "prixTotale",nullable = false)
    private Double prixtotale;

    @Column(name = "qteProd")
    private Integer qteProd;

    public Commande() {
    }

    public Commande(Long id, @Size(min = 3, message = "Verifez votre Prenom") String firstname, @Size(min = 3, message = "Verifez votre nom") String lastname, @Email(message = "Verifiez Votre email") String email, @NotEmpty(message = "Entrez votre adresse") String adresse, String adresse2, @NotEmpty(message = "Entrez votre numero") @Size(min = 8, max = 13) String tel, @NotEmpty(message = "Selectionnez un pays") String country, @Size(min = 4) String city, @Size(min = 4) Integer codepost, Double prixtotale, Integer qteProd) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.adresse = adresse;
        this.adresse2 = adresse2;
        this.tel = tel;
        this.country = country;
        this.city = city;
        this.codepost = codepost;
        this.prixtotale = prixtotale;
        this.qteProd = qteProd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCodepost() {
        return codepost;
    }

    public void setCodepost(Integer codepost) {
        this.codepost = codepost;
    }

    public Double getPrixtotale() {
        return prixtotale;
    }

    public void setPrixtotale(Double prixtotale) {
        this.prixtotale = prixtotale;
    }

    public Integer getQteProd() {
        return qteProd;
    }

    public void setQteProd(Integer qteProd) {
        this.qteProd = qteProd;
    }
}
