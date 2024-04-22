package com.dorminic.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dorminic.auth.entites.Organization;
import java.util.UUID;

public interface OrgRepository extends JpaRepository<Organization, UUID>  {

}
