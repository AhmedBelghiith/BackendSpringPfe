package com.bandsmile.crud.repository;

import com.bandsmile.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstname(String name);

    User findByUserName(String username);

}
