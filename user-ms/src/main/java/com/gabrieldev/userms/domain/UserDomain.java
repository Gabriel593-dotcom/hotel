package com.gabrieldev.userms.domain;

import com.gabrieldev.userms.app.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserDomain {

    UserDTO findByUserName(String userName);

    void saveUser(UserDTO userDTO);
}
