package com.bandsmile.crud.service;

import com.bandsmile.crud.model.Contact;
import com.bandsmile.crud.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }
    public List<Contact> saveContacts(List<Contact> contacts){
        return contactRepository.saveAll(contacts);
    }
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }
    public Contact getContactById(long id){
        return contactRepository.findById(id).orElse(null);
    }
    public Contact getContactByName(String name){
        return contactRepository.findByName(name);
    }
    public String deleteContact(Long id){
        contactRepository.deleteById(id);
        return "Contact supprimé !" +id;
    }
    public Contact upadateContact(Contact contact){
        Contact existingContact = contactRepository.findById(contact.getId()).orElse(null);
        existingContact.setName(contact.getName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setTel(contact.getTel());
        existingContact.setSujet(contact.getSujet());
        existingContact.setMsg(contact.getMsg());
        return contactRepository.save(existingContact);
    }

}

