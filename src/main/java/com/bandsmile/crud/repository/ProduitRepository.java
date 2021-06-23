package com.bandsmile.crud.repository;

import com.bandsmile.crud.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Produit findByName(String name);
}
