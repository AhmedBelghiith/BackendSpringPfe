package com.bandsmile.crud.controller;

import com.bandsmile.crud.model.Newsletter;
import com.bandsmile.crud.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class NewsletterController {
    @Autowired
    NewsletterService newsletterService;


    @PostMapping("/AddNewsletter")
    public Newsletter addNewsletter (@RequestBody Newsletter newsletter){
        return newsletterService.saveNewsletter(newsletter);
    }

    @GetMapping("/Newsletters")
    public List<Newsletter> findAllNewsletters(){
        return newsletterService.getNewsletters();
    }
    @PutMapping("/UpdateNewsletter")
    public Newsletter updateNewsletter (@RequestBody Newsletter newsletter){
        return newsletterService.upadateNewsletter(newsletter);
    }

    @DeleteMapping("/DeleteNewsletter/{id}")
    public String deleteNewsletter (@PathVariable Long id){
        return newsletterService.deleteNewsletter(id);
    }
}
