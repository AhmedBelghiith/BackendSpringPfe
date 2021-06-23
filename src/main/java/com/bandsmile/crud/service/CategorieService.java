package com.bandsmile.crud.service;

import com.bandsmile.crud.model.Categorie;
import com.bandsmile.crud.model.Commande;
import com.bandsmile.crud.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public Categorie saveCategorie(Categorie categorie){ return categorieRepository.save(categorie);}
    public List<Categorie> getCategorie(){return categorieRepository.findAll();}
    public Categorie getCategorieById(long id){return categorieRepository.findById(id).orElse(null);}
    public String deleteCategorie(Long id){
        categorieRepository.deleteById(id);
        return "Categorie supprimé !" +id;
    }
    public Categorie upadateCategorie(Categorie categorie){
        Categorie existingCategorie = categorieRepository.findById(categorie.getId()).orElse(null);
        existingCategorie.setType(categorie.getType());
        return categorieRepository.save(existingCategorie);
    }


}
