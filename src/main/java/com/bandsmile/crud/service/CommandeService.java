package com.bandsmile.crud.service;

import com.bandsmile.crud.model.Commande;
import com.bandsmile.crud.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    public Commande saveCommande(Commande commande){
        return commandeRepository.save(commande);
    }
    public List<Commande> saveCommandes(List<Commande> commandes){
        return commandeRepository.saveAll(commandes);
    }
    public List<Commande> getCommande(){
        return commandeRepository.findAll();
    }
    public Commande getCommandeById(long id){
        return commandeRepository.findById(id).orElse(null);
    }
    public Commande getCommandeByName(String name){
        return commandeRepository.findByFirstname(name);
    }
    public String deleteCommande(Long id){
        commandeRepository.deleteById(id);
        return "Commande supprimé !" +id;
    }
    public Commande upadateCommande(Commande commande){
        Commande existingCommande = commandeRepository.findById(commande.getId()).orElse(null);
        existingCommande.setFirstname(commande.getFirstname());
        existingCommande.setLastname(commande.getLastname());
        existingCommande.setEmail(commande.getEmail());
        existingCommande.setAdresse(commande.getAdresse());
        existingCommande.setAdresse2(commande.getAdresse2());
        existingCommande.setTel(commande.getTel());
        existingCommande.setCountry(commande.getCountry());
        existingCommande.setCity(commande.getCity());
        existingCommande.setCodepost(commande.getCodepost());
        existingCommande.setPrixtotale(commande.getPrixtotale());
        existingCommande.setQteProd(commande.getQteProd());
        return commandeRepository.save(existingCommande);
    }

}
