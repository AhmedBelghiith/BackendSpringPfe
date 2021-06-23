package com.bandsmile.crud.repository;

import com.bandsmile.crud.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande findByFirstname(String name);
}
