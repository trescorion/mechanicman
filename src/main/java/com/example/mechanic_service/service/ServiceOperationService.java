package com.example.mechanic_service.service;

import com.example.mechanic_service.model.ServiceOperation;
import com.example.mechanic_service.repository.CustomerRepository;
import com.example.mechanic_service.repository.ServiceOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOperationService {

    @Autowired
    private ServiceOperationRepository serviceOperationRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<ServiceOperation> getAllServiceOperations() {
        return serviceOperationRepository.findAll();
    }

    public ServiceOperation createServiceOperation(ServiceOperation serviceOperation) {
        return serviceOperationRepository.save(serviceOperation);
    }

    public ServiceOperation updateServiceOperation(Long id, ServiceOperation serviceOperationDetails) {
        ServiceOperation serviceOperation = serviceOperationRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Service operation not found"));
        serviceOperation.setDate(serviceOperationDetails.getDate());
        serviceOperation.setOperationDescription(serviceOperationDetails.getOperationDescription());
        serviceOperation.setFee(serviceOperationDetails.getFee());
        serviceOperation.setCustomer(customerRepository.findById(serviceOperationDetails.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found")));
        return serviceOperationRepository.save(serviceOperation);
    }

    public void deleteServiceOperation(Long id) {
        serviceOperationRepository.deleteById(id);
    }
}