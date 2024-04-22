package com.dorminic.function.billservice.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class ExtraBillServiceImpl implements ExtraBillService {

    private final ExtraBillRepository extraBillRepository;

    @Autowired
    public ExtraBillServiceImpl(ExtraBillRepository extraBillRepository) {
        this.extraBillRepository = extraBillRepository;
    }

    @Override
    public List<ExtraBillEntity> getAllExtraBills() {
        return extraBillRepository.findAll();
    }

    @Override
    public ExtraBillEntity createExtraBill(ExtraBillEntity extraBill) {
        return extraBillRepository.save(extraBill);
    }

    @Override
    public ExtraBillEntity getExtraBillById(Long id) {
        return extraBillRepository.findById(id).orElse(null);
    }

    @Override
    public ExtraBillEntity updateExtraBill(Long id, ExtraBillEntity extraBill) {
        if (extraBillRepository.existsById(id)) {
            extraBill.setBillid(id);
            return extraBillRepository.save(extraBill);
        }
        return null;
    }

    @Override
    public void deleteExtraBill(Long id) {
        extraBillRepository.deleteById(id);
    }

    @Override
    public List<ExtraBillEntity> getExtraBillsByUserId(UUID userId) {
        return extraBillRepository.findByUser_Id(userId);
    }

    @Override
    public List<ExtraBillEntity> getExtraBillsByOrganizationId(UUID organizationId) {
        return extraBillRepository.findByOrganization_OrgID(organizationId);
    }
}
