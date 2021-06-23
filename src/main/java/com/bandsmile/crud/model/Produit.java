package com.bandsmile.crud.model;



import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3,message = "Le nom doit contenir au moins 3 caractères")
    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private Double price;


    @Column(name = "Image", nullable = false)
    private String image;


    @Column(name = "Hovering", nullable = false)
    private String hovering;


    @Column(name = "Description", nullable = false)
    private String description;


    //demonstration
    @Column(name = "Video", nullable = false)
    private String video;


    @Column(name = "Utilisation", nullable = false)
    private String utilisation;


    @Column(name = "Stock", nullable = false)
    private String stock;


    @Column(name = "Status", nullable = false)
    private String status;


    @Column(name = "Oldprice", nullable = false)
    private Double oldprice;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    public Produit() {
    }

    public Produit(Long id, String name, Double price, String image, String hovering, String description, String video, String utilisation, String stock, String status, Double oldprice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.hovering = hovering;
        this.description = description;
        this.video = video;
        this.utilisation = utilisation;
        this.stock = stock;
        this.status = status;
        this.oldprice = oldprice;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHovering() {
        return hovering;
    }

    public void setHovering(String hovering) {
        this.hovering = hovering;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getUtilisation() {
        return utilisation;
    }

    public void setUtilisation(String utilisation) {
        this.utilisation = utilisation;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", hovering='" + hovering + '\'' +
                ", description='" + description + '\'' +
                ", video='" + video + '\'' +
                ", utilisation='" + utilisation + '\'' +
                ", stock='" + stock + '\'' +
                ", status='" + status + '\'' +
                ", oldprice=" + oldprice +
                '}';
    }
}
