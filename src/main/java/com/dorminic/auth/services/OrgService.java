package com.dorminic.auth.services;

import com.dorminic.auth.entites.Organization;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.UUID;

public interface OrgService {
    List<Organization> getAllOrganizations();
    void addOrganization(Organization organization) throws SQLIntegrityConstraintViolationException;
    void deleteOrganization(UUID orgID);
}
