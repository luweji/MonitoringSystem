package com.aQRIT.MonitoringSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aQRIT.MonitoringSystem.entities.Student;
import com.aQRIT.MonitoringSystem.forms.StudentForm;
import com.aQRIT.MonitoringSystem.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String index(Model model) {
        List<Student> students = studentService.getAll();

        model.addAttribute("message", "Hello from controller!");
        model.addAttribute("students", students);
        return "/views/student/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        return "/views/student/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        StudentForm studentForm = studentService.getForm(id);
        model.addAttribute("studentForm", studentForm);
        return "/views/student/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return String.format("redirect:/%s", "student");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute StudentForm studentForm) {
        studentService.save(studentForm);
        return String.format("redirect:/%s", "student");
    }  
}