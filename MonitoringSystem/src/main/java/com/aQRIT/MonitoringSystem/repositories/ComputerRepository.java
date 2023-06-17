package com.aQRIT.MonitoringSystem.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aQRIT.MonitoringSystem.entities.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    
    public Computer findByComputerNumber(String computerNumber);
    public Computer findByComputerDescription (String computerDescription);
    public Computer findByTimeOfUse(LocalDateTime timeOfUse);
    // public Computer findByStudentNumber(String studentNumber);
}
