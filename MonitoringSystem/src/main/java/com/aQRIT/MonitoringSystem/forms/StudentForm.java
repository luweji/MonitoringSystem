package com.aQRIT.MonitoringSystem.forms;

import com.aQRIT.MonitoringSystem.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentForm {

    private Integer id;
    private String studentName;
    private String studentNumber;

    public StudentForm(Student student) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.studentNumber = student.getStudentNumber();
    }

    public Student toEntity(Student student) {
        if (student == null) {
            student = new Student();
        }

        student.setStudentName(studentName);
        student.setStudentNumber(studentNumber);

        return student;
    }

}