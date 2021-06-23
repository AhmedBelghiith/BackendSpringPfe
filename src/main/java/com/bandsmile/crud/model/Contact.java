package com.bandsmile.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Contact")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3,message = "votre nom doit contenir au moins 3 caracteres")
    private String name;
    @Email(message = "Vous devez respecter la forme d'un email")
    private String email;
    @Size(min = 8,max = 13,message = "Verifiez votre Numero")
    private String tel;
    @NotEmpty
    private String sujet;
    @NotEmpty
    private String msg;

    public Contact() {
    }

    public Contact(Long id, String name, String email, String tel, String sujet, String msg) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.sujet = sujet;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", sujet='" + sujet + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
