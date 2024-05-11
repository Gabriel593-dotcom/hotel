package com.gabrieldev.userms.domain.mapper;

import com.gabrieldev.userms.app.dto.UserDTO;
import com.gabrieldev.userms.infra.db.entitie.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "userName", source = "user.userName")
    @Mapping(target = "password", source = "user.password")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "role", source = "user.role")
    UserDTO toDTO(User user);

    @Mapping(target = "userName", source = "dto.userName")
    @Mapping(target = "password", source = "dto.password")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "role", source = "dto.role")
    User toEntity(UserDTO dto);
}
