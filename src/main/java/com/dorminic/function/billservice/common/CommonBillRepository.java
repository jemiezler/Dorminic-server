package com.dorminic.function.billservice.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommonBillRepository extends JpaRepository<CommonBillEntity, Long> {
    List<CommonBillEntity> findByUser_Id(UUID userId);
    List<CommonBillEntity> findByOrganization_OrgID(UUID organizationId);
}