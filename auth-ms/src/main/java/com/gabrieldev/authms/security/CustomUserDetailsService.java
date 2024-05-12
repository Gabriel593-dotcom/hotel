package com.gabrieldev.authms.security;

import com.gabrieldev.authms.app.dto.UserDTO;
import com.gabrieldev.authms.domain.exception.UserNotFoundException;
import com.gabrieldev.authms.domain.feignclient.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = Optional.of(userFeignClient.getUserByUsername(username)).orElseThrow(() -> new UserNotFoundException("User: " + username + " not found."));

        return new User(userDTO.getUserName(),
                userDTO.getPassword(),
                List.of(new SimpleGrantedAuthority(userDTO.getRole()))
        );
    }
}
