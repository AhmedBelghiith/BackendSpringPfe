package com.bandsmile.crud.controller;

import com.bandsmile.crud.model.Contact;
import com.bandsmile.crud.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @PostMapping("/AddContact")
    public Contact addContact (@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }
    @PostMapping("/AddContacts")
    public List<Contact> addContacts (@RequestBody List<Contact> contacts){
        return contactService.saveContacts(contacts);
    }

    @GetMapping("/Contacts")
    public List<Contact> findAllContacts(){
        return contactService.getContacts();
    }

    @GetMapping("/ContactById/{id}")
    public Contact getContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }

    @GetMapping("/ContactByName/{name}")
    public Contact getContactByName(@PathVariable String name){
        return contactService.getContactByName(name);
    }

    @PutMapping("/UpdateContact")
    public Contact updateContact (@RequestBody Contact contact){
        return contactService.upadateContact(contact);
    }

    @DeleteMapping("/DeleteContact/{id}")
    public String deleteContact (@PathVariable Long id){
        return contactService.deleteContact(id);
    }


}
