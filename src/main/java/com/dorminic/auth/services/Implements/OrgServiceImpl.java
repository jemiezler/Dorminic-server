package com.dorminic.auth.services.Implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dorminic.auth.config.RandomStringGenerator;
import com.dorminic.auth.entites.Organization;
import com.dorminic.auth.repositories.OrgRepository;
import com.dorminic.auth.services.OrgService;

@Service
public class OrgServiceImpl implements OrgService {
    private final OrgRepository orgRepository;

    @Autowired
    public OrgServiceImpl(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    public List<Organization> getAllOrganizations() {
        return orgRepository.findAll();
    }

    @Override
    public void addOrganization(Organization organization) throws SQLIntegrityConstraintViolationException {
        try {
            String orgKey = RandomStringGenerator.generateRandomString(8);
            String orgVerification = RandomStringGenerator.generateRandomString(8);
            organization.setOrg_key(orgKey);
            organization.setOrg_verification(orgVerification);
            orgRepository.save(organization);
        } catch (DataIntegrityViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Duplicate entry for organization: " + organization.getOrg_name());
        }
    }

    @Override
    public void deleteOrganization(UUID orgId) {
        orgRepository.deleteById(orgId);
    }
}