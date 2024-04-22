package com.dorminic.function.billservice.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apis/bill/extra")
public class ExtraBillController {

    private final ExtraBillService extraBillService;

    @Autowired
    public ExtraBillController(ExtraBillService extraBillService) {
        this.extraBillService = extraBillService;
    }

    @GetMapping
    public ResponseEntity<List<ExtraBillEntity>> getAllExtraBills() {
        List<ExtraBillEntity> extraBills = extraBillService.getAllExtraBills();
        return ResponseEntity.ok(extraBills);
    }

    @PostMapping
    public ResponseEntity<ExtraBillEntity> createExtraBill(@RequestBody ExtraBillEntity extraBill) {
        ExtraBillEntity createdExtraBill = extraBillService.createExtraBill(extraBill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExtraBill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtraBillEntity> getExtraBillById(@PathVariable Long id) {
        ExtraBillEntity extraBill = extraBillService.getExtraBillById(id);
        return ResponseEntity.ok(extraBill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtraBillEntity> updateExtraBill(@PathVariable Long id, @RequestBody ExtraBillEntity extraBill) {
        ExtraBillEntity updatedExtraBill = extraBillService.updateExtraBill(id, extraBill);
        return ResponseEntity.ok(updatedExtraBill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExtraBill(@PathVariable Long id) {
        extraBillService.deleteExtraBill(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<ExtraBillEntity>> getExtraBillsByUserId(@PathVariable UUID userId) {
        List<ExtraBillEntity> extraBills = extraBillService.getExtraBillsByUserId(userId);
        return ResponseEntity.ok(extraBills);
    }

    @GetMapping("/by-org/{organizationId}")
    public ResponseEntity<List<ExtraBillEntity>> getExtraBillsByOrganizationId(@PathVariable UUID organizationId) {
        List<ExtraBillEntity> extraBills = extraBillService.getExtraBillsByOrganizationId(organizationId);
        return ResponseEntity.ok(extraBills);
    }
}
