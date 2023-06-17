package com.aQRIT.MonitoringSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aQRIT.MonitoringSystem.entities.Administrator;
import com.aQRIT.MonitoringSystem.forms.AdministratorForm;
import com.aQRIT.MonitoringSystem.repositories.AdministratorRepository;
import com.aQRIT.MonitoringSystem.specs.AdministratorSpecification;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;
    
    // search administrator by an attribute
    public Administrator getById(Integer id) {
        return administratorRepository.findById(id).get();
    }

    public Administrator getByAdminName(String adminName) {
        return administratorRepository.findOne(AdministratorSpecification.adminName(adminName)).get();
    }

    public Administrator getByUsername(String username) {
        return administratorRepository.findOne(AdministratorSpecification.username(username)).get();
    }

    public Administrator getByAdminPassword(String adminPassword) {
        return administratorRepository.findOne(AdministratorSpecification.adminPassword(adminPassword)).get();
    }

    // retrieve all administrators
    public List<Administrator> getAll() {
        return administratorRepository.findAll();
    }

    public AdministratorForm getForm(int id) {
        return new AdministratorForm(getById(id));
    }
    
    // public AdministratorForm getForm(String adminName) {
    //     return new AdministratorForm(getByAdminName(adminName));
    // }

    public AdministratorForm getForm(String username) {
        return new AdministratorForm(getByUsername(username));
    }

    // public AdministratorForm getForm(String adminPassword) {
    //     return new AdministratorForm(getByAdminPassword(adminPassword));
    // }

    // create
    public Administrator save(AdministratorForm administratorForm) {
        Administrator administrator = administratorForm.getId() == null ? null : getById(administratorForm.getId());
        return save(administratorForm.toEntity(administrator));
    }

    // update
    public Administrator save(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    // delete
    public void delete(Integer id) {
        administratorRepository.delete(getById(id));
    }
}