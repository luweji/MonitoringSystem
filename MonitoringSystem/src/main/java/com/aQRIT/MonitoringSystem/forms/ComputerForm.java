package com.aQRIT.MonitoringSystem.forms;

import java.time.LocalDateTime;

import com.aQRIT.MonitoringSystem.entities.Computer;
import com.aQRIT.MonitoringSystem.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerForm {

    private int id;
    private String computerNumber;
    private String computerDescription;
    private LocalDateTime timeOfUse;
    private String studentNumber;

    public Computer toEntity(Computer computer, Student student) {
        if (computer == null) {
            computer = new Computer();
        }

        computer.setComputerNumber(computerNumber);
        computer.setComputerDescription(computerDescription);
        computer.setTimeOfUse(timeOfUse);
        student.setStudentNumber(studentNumber); 
        // not sure dyan sa studentNumber if nandito ba dapat ^

        return computer;
    }

}