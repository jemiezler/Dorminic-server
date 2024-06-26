package com.dorminic.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dorminic.auth.dtos.MessageDto;

@RestController
@CrossOrigin(origins = "*")
public class MessagesController {

    @GetMapping("/messages")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<MessageDto> message() {
        return ResponseEntity.ok(new MessageDto("user's message"));
    }

    @GetMapping("/protected/messages")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<MessageDto> protectedMessage() {
        return ResponseEntity.ok(new MessageDto("protected user's message"));
    }
}
