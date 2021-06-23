package com.bandsmile.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Newsletter {
    @Id
    @GeneratedValue
    private Long id;

    @Email(message = "Verifiez votre email")
    @NotEmpty
    private String email;

    public Newsletter() {
    }

    public Newsletter(Long id, @Email(message = "Verifiez votre email") String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
