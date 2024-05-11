package com.gabrieldev.userms.app.rest;

import com.gabrieldev.userms.app.dto.UserDTO;
import com.gabrieldev.userms.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

    @Autowired
    private UserDomain userDomain;

    @GetMapping
    public ResponseEntity<UserDTO> findUserByUserName(@RequestParam("userName") String userName) {
        UserDTO user = userDomain.findByUserName(userName);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody UserDTO userDTO) {
        userDomain.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
