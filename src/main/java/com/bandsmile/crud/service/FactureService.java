//package com.bandsmile.crud.service;
//
//import com.bandsmile.crud.model.Facture;
//import com.bandsmile.crud.repository.FactureRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class FactureService {
//
//    @Autowired
//    FactureRepository factureRepository;
//
//
//    public Facture saveFacture(Facture facture){
//        return factureRepository.save(facture);
//    }
//    public List<Facture> getFactures(){
//        return factureRepository.findAll();
//    }
//    public String deleteFacture(Long id){
//        factureRepository.deleteById(id);
//        return "Facture supprimé !"+id;
//    }
//}
