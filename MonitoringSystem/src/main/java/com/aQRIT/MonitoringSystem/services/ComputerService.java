package com.aQRIT.MonitoringSystem.services;

import java.util.List;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aQRIT.MonitoringSystem.entities.Computer;
import com.aQRIT.MonitoringSystem.entities.Student;
import com.aQRIT.MonitoringSystem.forms.ComputerForm;
import com.aQRIT.MonitoringSystem.repositories.ComputerRepository;
// import com.aQRIT.MonitoringSystem.specs.ComputerSpecification;

@Service
public class ComputerService {
    
    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private StudentService studentService;

    public void save(ComputerForm computerForm) {
        Computer computer = computerRepository.findById(computerForm.getId()).get();
        Student student = studentService.getByStudentNumber(computerForm.getStudentNumber());
        computerRepository.save(computerForm.toEntity(computer, student));
    }

    // **not included to sa codes ni sir v [pwede icomment if may prob]
    public List<Computer> getAll() {
        return computerRepository.findAll();
    }
    // **
    // public Computer getById(Integer id) {
    //     return computerRepository.findById(id).get();
    // }

    // xx nag-eerror talaga to v
    // public ComputerForm getForm(int id) {
    //     return new ComputerForm(getById(id));
    // }

    // **pwede to icomment if may prob v; wag lang yung delete
    // public Computer save(Computer computer) {
    //     return computerRepository.save(computer);
    // }

    // ** 
    // public void delete(Integer id) {
    //     computerRepository.delete(getById(id));
    // }
}