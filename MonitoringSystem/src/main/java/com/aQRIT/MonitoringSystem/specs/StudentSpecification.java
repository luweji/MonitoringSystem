package com.aQRIT.MonitoringSystem.specs;

import org.springframework.data.jpa.domain.Specification;

import com.aQRIT.MonitoringSystem.entities.Student;

public class StudentSpecification extends GenericSpecification<Student> {

    public static Specification<Student> id(int id) {
        return equal("id", id);
    }

    public static Specification<Student> studentName(String studentName) {
        return equal("studentName", studentName);
    }

    public static Specification<Student> studentNameLike(String studentName) {
        return like("studentName", studentName);
    }

    public static Specification<Student> studentNumber(String studentNumber) {
        return equal("studentNumber", studentNumber);
    }

    public static Specification<Student> studentNumberLike(String studentNumber) {
        return like("studentNumber", studentNumber);
    }
    
}