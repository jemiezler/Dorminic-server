package com.dorminic.auth.dtos;

import java.util.UUID;

import com.dorminic.auth.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;
    private Role role;
    private UUID orgID;
}
