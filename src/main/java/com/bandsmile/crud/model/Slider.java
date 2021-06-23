package com.bandsmile.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "slider")
public class Slider {
    @Id
    @Column(name = "slider_id")
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "entrez le titre")
    @Column(name = "titre")
    private String titre;
    @Column(name = "buttonName")
    private String buttonName;
    @Column(name = "buttonPosition")
    private String buttonPosition;


}



