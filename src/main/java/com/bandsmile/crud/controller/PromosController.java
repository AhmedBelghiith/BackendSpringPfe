//package com.bandsmile.crud.controller;
//
//import com.bandsmile.crud.model.Promos;
//import com.bandsmile.crud.service.PromosService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin("*")
//@RestController
//public class PromosController {
//    @Autowired
//    PromosService promosService;
//
//
//    @PostMapping("/AddPromos")
//    public Promos addPromos (@RequestBody Promos promos){
//        return promosService.savePromos(promos);
//    }
//
//    @GetMapping("/Promos")
//    public List<Promos> findAllPromos(){
//        return promosService.getPromos();
//    }
//    @PutMapping("/UpdatePromos")
//    public Promos updatePromos (@RequestBody Promos promos){
//        return promos.updatePromos(promos);
//    }
//
//    @DeleteMapping("/DeletePromos/{id}")
//    public String deletePromos (@PathVariable Long id){
//        return promosService.deletePromos(id);
//    }
//}
