package com.bandsmile.crud.service;



import com.bandsmile.crud.model.User;
import com.bandsmile.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }
    public User getUserByName(String name){
        return userRepository.findByFirstname(name);
    }
    public User getUserByUsername(String username){return userRepository.findByUserName(username);}
    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "User supprimé !" +id;
    }
    public User upadateUser(User user){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setAdresse(user.getAdresse());
        existingUser.setAdresse2(user.getAdresse2());
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setTel(user.getTel());
        existingUser.setCountry(user.getCountry());
        existingUser.setCity(user.getCity());
        existingUser.setCodepost(user.getCodepost());
        return userRepository.save(existingUser);
    }

}
