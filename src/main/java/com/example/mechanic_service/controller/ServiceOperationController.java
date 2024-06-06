package com.example.mechanic_service.controller;

import com.example.mechanic_service.model.ServiceOperation;
import com.example.mechanic_service.service.ServiceOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-operations")
public class ServiceOperationController {

    @Autowired
    private ServiceOperationService serviceOperationService;

    @GetMapping
    public List<ServiceOperation> getAllServiceOperations() {
        return serviceOperationService.getAllServiceOperations();
    }

    @PostMapping
    public ServiceOperation createServiceOperation(@RequestBody ServiceOperation serviceOperation) {
        return serviceOperationService.createServiceOperation(serviceOperation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOperation> updateServiceOperation(@PathVariable Long id, @RequestBody ServiceOperation serviceOperationDetails) {
        ServiceOperation updatedServiceOperation = serviceOperationService.updateServiceOperation(id, serviceOperationDetails);
        return ResponseEntity.ok(updatedServiceOperation);
    }


    @DeleteMapping("/{id}")
    public void deleteServiceOperation(@PathVariable Long id) {
        serviceOperationService.deleteServiceOperation(id);
    }

}
