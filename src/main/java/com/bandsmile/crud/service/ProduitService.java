package com.bandsmile.crud.service;


import com.bandsmile.crud.model.Produit;
import com.bandsmile.crud.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit saveProduit(Produit produit){
      return produitRepository.save(produit);
    }
    public List<Produit> saveProduits(List<Produit> produits){
        return produitRepository.saveAll(produits);
    }
    public List<Produit> getProduits(){
        return produitRepository.findAll();
    }
    public Produit getProduitById(long id){
        return produitRepository.findById(id).orElse(null);
    }
    public Produit getProduitByName(String name){
        return produitRepository.findByName(name);
    }
    public String deleteProduit(Long id){
        produitRepository.deleteById(id);
        return "produit supprimé !"+id;
    }
    public Produit upadateProduit(Produit produit){
        Produit existingProduit = produitRepository.findById(produit.getId()).orElse(null);
        existingProduit.setName(produit.getName());
        existingProduit.setPrice(produit.getPrice());
        existingProduit.setImage(produit.getImage());
        existingProduit.setHovering(produit.getHovering());
        existingProduit.setVideo(produit.getVideo());
        existingProduit.setUtilisation(produit.getUtilisation());
        existingProduit.setStock(produit.getStock());
        existingProduit.setStatus(produit.getStatus());
        existingProduit.setOldprice(produit.getOldprice());
        return produitRepository.save(existingProduit);
    }











}
