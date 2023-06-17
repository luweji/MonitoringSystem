package com.aQRIT.MonitoringSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aQRIT.MonitoringSystem.entities.Computer;
import com.aQRIT.MonitoringSystem.entities.Student;
import com.aQRIT.MonitoringSystem.forms.ComputerForm;
import com.aQRIT.MonitoringSystem.services.ComputerService;
import com.aQRIT.MonitoringSystem.services.StudentService;

@Controller
@RequestMapping("/computer")
public class ComputerController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ComputerService computerService;

    @GetMapping
    public String index(Model model) {
        List<Computer> computers = computerService.getAll();

        model.addAttribute("message", "Hello from controller!");
        model.addAttribute("computers", computers);
        return "/views/computer/index";
    }
    // not sure if included talaga 'to ^'

    @GetMapping("/register")
    public String register(Model model) {
        ComputerForm computerForm = new ComputerForm();
        List<Student> students = studentService.getAll();

        model.addAttribute("computerForm", computerForm);
        model.addAttribute("students", students);
        return "/views/computer/edit";
    }
    
    // ** idk v
    // @GetMapping("/update/{id}")
    // public String update(@PathVariable int id, Model model) {
    //     ComputerForm computerForm = computerService.getForm(id);
    //     model.addAttribute("computerForm", computerForm);
    //     return "/views/computer/edit";
    // }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable int id) {
    //     computerService.delete(id);
    //     return String.format("redirect:/%s", "computer");
    // }
    // ** not sure if included talaga update and delete here ^

    @PostMapping("/save")
    public String save(@ModelAttribute ComputerForm computerForm) {
        computerService.save(computerForm);
        return String.format("redirect:/%s", "computer");
    }  
}