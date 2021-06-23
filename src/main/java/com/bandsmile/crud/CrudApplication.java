package com.bandsmile.crud;

import com.bandsmile.crud.model.Role;
import com.bandsmile.crud.model.User;
import com.bandsmile.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication


public class CrudApplication {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
	public void initUsers() throws  ParseException {
		Long a = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		String password = "admin123";
		Role r = new Role(1,"ROLE_USER");
        Set<Role> r1 = new HashSet<Role>();
        r1.add(r);
		BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder() ;
		//List <Authority> authorities = registerRequest.getAuthorities();
		password = bCryptPasswordEncoder.encode(password);
		List<User> users = Stream.of(
				new User(a, "ahmed","sdfgsdgsdf","omar@basmile.com","123","tunisie","ahmed",password,"tunisie","tunisie","tunisie",2080, r1)
		).collect(Collectors.toList());
        userRepository.saveAll(users);
	}
    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

}
