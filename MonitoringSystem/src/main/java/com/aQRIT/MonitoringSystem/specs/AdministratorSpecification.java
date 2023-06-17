package com.aQRIT.MonitoringSystem.specs;

import org.springframework.data.jpa.domain.Specification;

import com.aQRIT.MonitoringSystem.entities.Administrator;

public class AdministratorSpecification extends GenericSpecification<Administrator> {
    
    public static Specification<Administrator> id(int id) {
        return equal("id", id);
    }
    public static Specification<Administrator> adminName(String adminName) {
        return equal("adminName", adminName);
    }
    public static Specification<Administrator> adminNameLike(String adminName) {
        return like("adminName", adminName);
    }
    public static Specification<Administrator> username(String username) {
        return equal("username", username);
    }
    public static Specification<Administrator> usernameLike(String username) {
        return like("username", username);
    }
    public static Specification<Administrator> adminPassword(String adminPassword) {
        return equal("adminPassword", adminPassword);
    }
    public static Specification<Administrator> adminPasswordLike(String adminPassword) {
        return like("adminPassword", adminPassword);
    }
}