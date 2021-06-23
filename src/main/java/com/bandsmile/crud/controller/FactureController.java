//package com.bandsmile.crud.controller;
//
//import com.bandsmile.crud.model.Facture;
//import com.bandsmile.crud.service.FactureService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin("*")
//@RestController
//public class FactureController {
//    @Autowired
//    FactureService factureService;
//
//
//    @PostMapping("/AddFacture")
//    public Facture addFacture (@RequestBody Facture facture){
//        return factureService.saveFacture(facture);
//    }
//
//    @GetMapping("/Factures")
//    public List<Facture> findAllFactures(){
//        return factureService.getFactures();
//    }
//
//    @DeleteMapping("/DeleteFacture/{id}")
//    public String deleteFacture (@PathVariable Long id){
//        return factureService.deleteFacture(id);
//    }
//}
