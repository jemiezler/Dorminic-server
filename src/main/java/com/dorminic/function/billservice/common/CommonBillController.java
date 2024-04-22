package com.dorminic.function.billservice.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apis/bill/common")
public class CommonBillController {

    private final CommonBillService commonBillService;

    @Autowired
    public CommonBillController(CommonBillService commonBillService) {
        this.commonBillService = commonBillService;
    }

    @GetMapping
    public ResponseEntity<List<CommonBillEntity>> getAllCommonBills() {
        List<CommonBillEntity> commonBills = commonBillService.getAllCommonBills();
        return ResponseEntity.ok(commonBills);
    }

    @PostMapping
    public ResponseEntity<CommonBillEntity> createCommonBill(@RequestBody CommonBillEntity commonBill) {
        CommonBillEntity createdCommonBill = commonBillService.createCommonBill(commonBill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCommonBill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonBillEntity> getCommonBillById(@PathVariable Long id) {
        CommonBillEntity commonBill = commonBillService.getCommonBillById(id);
        return ResponseEntity.ok(commonBill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonBillEntity> updateCommonBill(@PathVariable Long id, @RequestBody CommonBillEntity commonBill) {
        CommonBillEntity updatedCommonBill = commonBillService.updateCommonBill(id, commonBill);
        return ResponseEntity.ok(updatedCommonBill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommonBill(@PathVariable Long id) {
        commonBillService.deleteCommonBill(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<CommonBillEntity>> getCommonBillsByUserId(@PathVariable UUID userId) {
        List<CommonBillEntity> commonBills = commonBillService.getCommonBillsByUserId(userId);
        return ResponseEntity.ok(commonBills);
    }

    @GetMapping("/by-org/{organizationId}")
    public ResponseEntity<List<CommonBillEntity>> getCommonBillsByOrganizationId(@PathVariable UUID organizationId) {
        List<CommonBillEntity> commonBills = commonBillService.getCommonBillsByOrganizationId(organizationId);
        return ResponseEntity.ok(commonBills);
    }
}
