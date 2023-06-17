package com.aQRIT.MonitoringSystem.forms;

import com.aQRIT.MonitoringSystem.entities.Administrator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministratorForm {

    private Integer id;
    private String adminName;
    private String username;
    private String adminPassword;

    public AdministratorForm(Administrator administrator) {
        this.id = administrator.getId();
        this.username = administrator.getAdminName();
        this.username = administrator.getUsername();
        this.adminPassword = administrator.getAdminPassword();
    }

    public Administrator toEntity(Administrator administrator) {
        if (administrator == null) {
            administrator = new Administrator();
        }

        administrator.setAdminName(adminName);
        administrator.setUsername(username);
        administrator.setAdminPassword(adminPassword);

        return administrator;
    }

}