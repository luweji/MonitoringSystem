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

import com.aQRIT.MonitoringSystem.entities.Administrator;
import com.aQRIT.MonitoringSystem.forms.AdministratorForm;
import com.aQRIT.MonitoringSystem.services.AdministratorService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping
    public String index(Model model) {
        List<Administrator> administrators = administratorService.getAll();

        model.addAttribute("message", "Hello from controller!");
        model.addAttribute("administrators", administrators);
        return "/views/administrator/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("administratorForm", new AdministratorForm());
        return "/views/administrator/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        AdministratorForm administratorForm = administratorService.getForm(id);
        model.addAttribute("administratorForm", administratorForm);
        return "/views/administrator/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        administratorService.delete(id);
        return String.format("redirect:/%s", "administrator");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute AdministratorForm administratorForm) {
        administratorService.save(administratorForm);
        return String.format("redirect:/%s", "administrator");
    }
}