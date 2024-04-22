package com.dorminic.function.billservice.extra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExtraBillRepository extends JpaRepository<ExtraBillEntity, Long> {
    List<ExtraBillEntity> findByUser_Id(UUID userId);
    List<ExtraBillEntity> findByOrganization_OrgID(UUID organizationId);
}