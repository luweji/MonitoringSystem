package com.aQRIT.MonitoringSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aQRIT.MonitoringSystem.entities.Student;
import com.aQRIT.MonitoringSystem.forms.StudentForm;
import com.aQRIT.MonitoringSystem.repositories.StudentRepository;
import com.aQRIT.MonitoringSystem.specs.StudentSpecification;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Student getByStudentName(String studentName) {
        return studentRepository.findOne(StudentSpecification.studentName(studentName)).get();
    }

    public Student getByStudentNumber(String studentNumber) {
        return studentRepository.findOne(StudentSpecification.studentNumber(studentNumber)).get();
    }

    public StudentForm getForm(int id) {
        return new StudentForm(getById(id));
    }

    // public StudentForm getForm(String studentName) {
    //     return new StudentForm(getByStudentName(studentName));
    // }

    public StudentForm getForm(String studentNumber) {
        return new StudentForm(getByStudentNumber(studentNumber));
    }

    public Student save(StudentForm studentForm) {
        Student student = studentForm.getId() == null ? null : getById(studentForm.getId());
        return save(studentForm.toEntity(student));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.delete(getById(id));
    }

}