package com.Ironhack.LOTRProject.JWTLogin;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("Kirutasu".equals(username)) {
            return new User("Kirutasu",
                    "$2a$12$iKFnPbw7R0SVlziBq4libOd0o3U0iymCxtOE8S00gu5x5TMN2OwsO",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }
}
