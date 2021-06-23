package com.bandsmile.crud.security;


import com.bandsmile.crud.model.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static User create (User user) {
    	return new User(user);
    }


//    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
//        return authorities.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
//                .collect(Collectors.toList());
//    }
}
