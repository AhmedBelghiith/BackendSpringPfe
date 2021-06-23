package com.bandsmile.crud.repository;


import com.bandsmile.crud.model.Categorie;
import com.bandsmile.crud.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Commande findByType(String type);
}
