package com.dorminic.auth.controllers;

import com.dorminic.auth.config.UserAuthenticationProvider;
import com.dorminic.auth.dtos.AddOrgDto;
import com.dorminic.auth.dtos.CredentialsDto;
import com.dorminic.auth.dtos.OrgDto;
import com.dorminic.auth.dtos.SignUpDto;
import com.dorminic.auth.dtos.UserDto;
import com.dorminic.auth.entites.Organization;
import com.dorminic.auth.services.OrgService;
import com.dorminic.auth.services.UserService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final OrgService orgService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.userregister(user);
        createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
    
    

    @PostMapping("/apis/org/register")
    public ResponseEntity<AddOrgDto> organizationAdd(@RequestBody @Valid AddOrgDto org) {
        AddOrgDto createOrg = orgService.addOrg(org);
        return ResponseEntity.created(URI.create("/orgs/"+createOrg.getOrgID())).body(createOrg);
    }

}
