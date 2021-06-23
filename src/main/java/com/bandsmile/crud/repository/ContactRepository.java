package com.bandsmile.crud.repository;

import com.bandsmile.crud.model.Contact;
import com.bandsmile.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByName(String name);
}
