package com.bandsmile.crud.controller;

import com.bandsmile.crud.model.Categorie;
import com.bandsmile.crud.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @PostMapping("/AddCategorie")
    public Categorie addCategorie (@RequestBody Categorie categorie){
        return categorieService.saveCategorie(categorie);
    }

    @GetMapping("/Categories")
    public List<Categorie> findAllCategories(){
        return categorieService.getCategorie();
    }

    @GetMapping("/Categorie/{id}")
    public Categorie getCategorieById(@PathVariable Long id){
        return categorieService.getCategorieById(id);
    }

    @PutMapping("/UpdateCategorie")
    public Categorie updateCategorie (@RequestBody Categorie categorie){
        return categorieService.upadateCategorie(categorie);
    }

    @DeleteMapping("DeleteCategorie/{id}")
    public String deleteCategorie (@PathVariable Long id){
        return categorieService.deleteCategorie(id);
    }


}
