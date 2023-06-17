package com.aQRIT.MonitoringSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.aQRIT.MonitoringSystem.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student>{
    
    public Student findByStudentName(String studentName);
    public Student findByStudentNumber(String studentNumber);
}
