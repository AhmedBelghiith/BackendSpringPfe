package com.bandsmile.crud.service;

import com.bandsmile.crud.model.Newsletter;
import com.bandsmile.crud.model.Slider;
import com.bandsmile.crud.model.User;
import com.bandsmile.crud.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsletterService {
    @Autowired
    NewsletterRepository newsletterRepository;

    public Newsletter saveNewsletter(Newsletter newsletter){
        return newsletterRepository.save(newsletter);
    }
    public List<Newsletter> getNewsletters(){
        return newsletterRepository.findAll();
    }
    public String deleteNewsletter(Long id){
        newsletterRepository.deleteById(id);
        return "Newsletter supprimé !"+id;
    }
    public Newsletter upadateNewsletter(Newsletter newsletter){
        Newsletter existingNewsletter = newsletterRepository.findById(newsletter.getId()).orElse(null);
        existingNewsletter.setEmail(newsletter.getEmail());
        return newsletterRepository.save(existingNewsletter);
    }
}
