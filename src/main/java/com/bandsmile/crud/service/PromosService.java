//package com.bandsmile.crud.service;
//
//import com.bandsmile.crud.model.Promos;
//import com.bandsmile.crud.repository.PromosRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class PromosService {
//    @Autowired
//    PromosRepository promosRepository;
//
//    public Promos savePromos(Promos promos){
//        return promosRepository.save(promos);
//    }
//    public List<Promos> savePromos(List<Promos> promosList){
//        return promosRepository.saveAll(promosList);
//    }
//    public List<Promos> getPromos(){
//        return promosRepository.findAll();
//    }
//    public Promos getPromosById(long id){
//        return promosRepository.findById(id).orElse(null);
//    }
//    public String deletePromos(Long id){
//        promosRepository.deleteById(id);
//        return "promotion supprimé !"+id;
//    }
//    public Promos updatePromos(Promos promos){
//        Promos existingPromos = promosRepository.findById(promos.getId()).orElse(null);
//        existingPromos.setPourcentage(promos.getPourcentage());
//        existingPromos.setDateDeb(promos.getDateDeb());
//        existingPromos.setDateFin(promos.getDateFin());
//        return promosRepository.save(existingPromos);
//    }
//
//}
