package com.dorminic.auth.mappers;

import com.dorminic.auth.dtos.SignUpDto;
import com.dorminic.auth.dtos.UserDto;
import com.dorminic.auth.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}

