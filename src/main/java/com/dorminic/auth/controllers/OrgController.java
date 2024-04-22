package com.dorminic.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dorminic.auth.entites.Organization;
import com.dorminic.auth.services.OrgService;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/apis/org")
public class OrgController {
    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @GetMapping("/all")
    public List<Organization> getAllOrganizations() {
        return orgService.getAllOrganizations();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrganization(@RequestBody Organization organization) throws SQLIntegrityConstraintViolationException {
        orgService.addOrganization(organization);
        return ResponseEntity.status(HttpStatus.CREATED).body("Organization added successfully");
    }

    @DeleteMapping("/delete/{orgId}")
        public ResponseEntity<String> deleteOrganization(@PathVariable String orgId) {
            UUID orgUUID = UUID.fromString(orgId);
            orgService.deleteOrganization(orgUUID);
            return ResponseEntity.ok("Organization deleted successfully");
    }
}
