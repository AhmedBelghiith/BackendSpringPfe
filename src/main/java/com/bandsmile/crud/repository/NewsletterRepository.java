package com.bandsmile.crud.repository;

import com.bandsmile.crud.model.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter,Long> {
}
