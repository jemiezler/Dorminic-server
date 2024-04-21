package com.dorminic.auth.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dorminic.auth.dtos.AddOrgDto;
import com.dorminic.auth.entites.Organization;
import com.dorminic.auth.repositories.OrgRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrgService {

    private final OrgRepository orgRepository;

    public AddOrgDto addOrg(AddOrgDto addorgDto) {
        // Generate UUID for the organization ID
        UUID orgId = UUID.randomUUID();
    
        // Convert AddOrgDto to Organization entity
        Organization organization = Organization.builder()
                                                .orgID(orgId)
                                                .OrgName(addorgDto.getOrgName())
                                                .orgkey(addorgDto.getOrgkey())
                                                .orgverify(addorgDto.getOrgverify())
                                                .build();
    
        // Save the organization to the database
        Organization savedOrganization = orgRepository.save(organization);
    
        // Update the orgID in the AddOrgDto with the generated UUID from the saved organization
        addorgDto.setOrgID(savedOrganization.getOrgID());
    
        // Return the updated AddOrgDto
        return addorgDto;
    }
    
}
