package com.dorminic.function.billservice.extra;

import java.util.List;
import java.util.UUID;

public interface ExtraBillService {
    List<ExtraBillEntity> getAllExtraBills();
    ExtraBillEntity createExtraBill(ExtraBillEntity ExtraBill);
    ExtraBillEntity getExtraBillById(Long id);
    ExtraBillEntity updateExtraBill(Long id, ExtraBillEntity ExtraBill);
    void deleteExtraBill(Long id);
    List<ExtraBillEntity> getExtraBillsByUserId(UUID userId);
    List<ExtraBillEntity> getExtraBillsByOrganizationId(UUID organizationId);
}