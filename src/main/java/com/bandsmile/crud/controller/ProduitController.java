package com.bandsmile.crud.controller;

import com.bandsmile.crud.model.Produit;
import com.bandsmile.crud.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProduitController {
    @Autowired
    ProduitService produitService;

    @PostMapping("/AddProduit")
    public Produit addProduit (@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }
    @PostMapping("/AddProduits")
    public List<Produit> addProduits (@RequestBody List<Produit> produits){
        return produitService.saveProduits(produits);
    }

    @GetMapping("/Produits")
    public List<Produit> findAllProduits(){
        return produitService.getProduits();
    }

    @GetMapping("/ProduitById/{id}")
    public Produit getProduitById(@PathVariable Long id){
        return produitService.getProduitById(id);
    }

    @GetMapping("/ProduitByName/{name}")
    public Produit getProduitByName(@PathVariable String name){
        return produitService.getProduitByName(name);
    }

    @PutMapping("/UpdateProduit")
    public Produit updateProduit (@RequestBody Produit produit){
        return produitService.upadateProduit(produit);
    }

    @DeleteMapping("/DeleteProduit/{id}")
    public String deleteProduit (@PathVariable Long id){
        return produitService.deleteProduit(id);
    }


}
