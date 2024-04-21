package com.dorminic.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dorminic.auth.entites.Organization;

public interface OrgRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByOrgkeyAndOrgverify(String orgkey, String orgverify);
}
