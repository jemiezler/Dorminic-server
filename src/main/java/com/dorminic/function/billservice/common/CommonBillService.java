package com.dorminic.function.billservice.common;

import java.util.List;
import java.util.UUID;

public interface CommonBillService {
    List<CommonBillEntity> getAllCommonBills();
    CommonBillEntity createCommonBill(CommonBillEntity commonBill);
    CommonBillEntity getCommonBillById(Long id);
    CommonBillEntity updateCommonBill(Long id, CommonBillEntity commonBill);
    void deleteCommonBill(Long id);
    List<CommonBillEntity> getCommonBillsByUserId(UUID userId);
    List<CommonBillEntity> getCommonBillsByOrganizationId(UUID organizationId);
}