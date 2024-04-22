package com.dorminic.function.billservice.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class CommonBillServiceImpl implements CommonBillService {

    private final CommonBillRepository commonBillRepository;

    @Autowired
    public CommonBillServiceImpl(CommonBillRepository commonBillRepository) {
        this.commonBillRepository = commonBillRepository;
    }

    @Override
    public List<CommonBillEntity> getAllCommonBills() {
        return commonBillRepository.findAll();
    }

    @Override
    public CommonBillEntity createCommonBill(CommonBillEntity commonBill) {
        return commonBillRepository.save(commonBill);
    }

    @Override
    public CommonBillEntity getCommonBillById(Long id) {
        return commonBillRepository.findById(id).orElse(null);
    }

    @Override
    public CommonBillEntity updateCommonBill(Long id, CommonBillEntity commonBill) {
        if (commonBillRepository.existsById(id)) {
            commonBill.setBillid(id);
            return commonBillRepository.save(commonBill);
        }
        return null;
    }

    @Override
    public void deleteCommonBill(Long id) {
        commonBillRepository.deleteById(id);
    }

    @Override
    public List<CommonBillEntity> getCommonBillsByUserId(UUID userId) {
        return commonBillRepository.findByUser_Id(userId);
    }

    @Override
    public List<CommonBillEntity> getCommonBillsByOrganizationId(UUID organizationId) {
        return commonBillRepository.findByOrganization_OrgID(organizationId);
    }
}
