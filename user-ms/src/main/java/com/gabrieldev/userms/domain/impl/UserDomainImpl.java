package com.gabrieldev.userms.domain.impl;

import com.gabrieldev.userms.app.dto.UserDTO;
import com.gabrieldev.userms.domain.UserDomain;
import com.gabrieldev.userms.domain.exception.UserNotFoundException;
import com.gabrieldev.userms.domain.mapper.UserMapper;
import com.gabrieldev.userms.domain.utils.UserRole;
import com.gabrieldev.userms.infra.db.entitie.User;
import com.gabrieldev.userms.infra.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDomainImpl implements UserDomain {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .map(user -> mapper.toDTO(user))
                .orElseThrow(() -> new UserNotFoundException("user not found."));
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        user.setId(null);
        user.setRole(UserRole.findRoleName(user.getRole()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
