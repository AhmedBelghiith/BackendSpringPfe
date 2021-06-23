package com.bandsmile.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "User")
public class User implements Serializable {
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

    @NotEmpty(message = "Nom d'utilisateur déjà existant ou champs vide, Merci de ressayer")
    @Column(name = "UserName", unique = true)
    private String userName;

    @NotEmpty(message = "Entrez un mot de passe")
    @Size(min = 8,message = "Minimum 8 caracteres")
    @Column(name = "Password")
    private String password;

    @NotEmpty(message = "Entrez votre numero")
    @Size(min = 8,max = 13)
    @Column(name = "Tel")
    private String tel;

    @NotEmpty(message = "Selectionnez un pays")
    @Column(name = "Country")
    private String country;

    @Size(min = 4)
    @Column(name = "City")
    private String city;

    @Column(name = "CodePost")
    private Integer codepost;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(User user) {
    }

    public User(Long id, @Size(min = 3, message = "Verifez votre Prenom") String firstname, @Size(min = 3, message = "Verifez votre nom") String lastname, @Email(message = "Verifiez Votre email") String email, @NotEmpty(message = "Entrez votre adresse") String adresse, String adresse2, @NotEmpty(message = "Nom d'utilisateur déjà existant ou champs vide, Merci de ressayer") String userName, @NotEmpty(message = "Entrez un mot de passe") @Size(min = 8, message = "Minimum 8 caracteres") String password, @NotEmpty(message = "Entrez votre numero") @Size(min = 8, max = 13) String tel, @NotEmpty(message = "Selectionnez un pays") String country, @Size(min = 4) String city, @Size(min = 4) Integer codepost, Set<Role> roles) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.adresse = adresse;
        this.adresse2 = adresse2;
        this.userName = userName;
        this.password = password;
        this.tel = tel;
        this.country = country;
        this.city = city;
        this.codepost = codepost;
        this.roles = roles;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
