package com.bandsmile.crud.controller;

import com.bandsmile.crud.model.Commande;
import com.bandsmile.crud.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")

@RestController
public class CommandeController {

    @Autowired
    CommandeService commandeService;


    @PostMapping("/AddCommande")
    public Commande addCommande (@RequestBody Commande commande){
        return commandeService.saveCommande(commande);
    }
    @PostMapping("/AddCommandes")
    public List<Commande> addCommandes (@RequestBody List<Commande> commandes){
        return commandeService.saveCommandes(commandes);
    }

    @GetMapping("/Commandes")
    public List<Commande> findAllCommandes(){
        return commandeService.getCommande();
    }

    @GetMapping("/CommandeById/{id}")
    public Commande getCommandeById(@PathVariable Long id){
        return commandeService.getCommandeById(id);
    }

    @GetMapping("/CommandeByName/{name}")
    public Commande getCommandeByName(@PathVariable String name){
        return commandeService.getCommandeByName(name);
    }

    @PutMapping("/UpdateCommande")
    public Commande updateCommande (@RequestBody Commande commande){
        return commandeService.upadateCommande(commande);
    }

    @DeleteMapping("/DeleteCommande/{id}")
    public String deleteCommande (@PathVariable Long id){
        return commandeService.deleteCommande(id);
    }


}
