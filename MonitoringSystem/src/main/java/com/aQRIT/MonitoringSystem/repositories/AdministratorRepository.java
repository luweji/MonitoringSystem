package com.aQRIT.MonitoringSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.aQRIT.MonitoringSystem.entities.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer>, JpaSpecificationExecutor<Administrator> {
    
    public Administrator findByAdminName (String adminName);
    public Administrator findByUsername(String username);
    public Administrator findByAdminPassword(String adminPassword);
}