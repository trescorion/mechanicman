package com.example.mechanic_service.repository;

import com.example.mechanic_service.model.ServiceOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOperationRepository extends JpaRepository<ServiceOperation, Long> {
}