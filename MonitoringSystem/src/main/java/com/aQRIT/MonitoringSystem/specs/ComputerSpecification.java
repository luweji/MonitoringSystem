package com.aQRIT.MonitoringSystem.specs;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.aQRIT.MonitoringSystem.entities.Computer;

public class ComputerSpecification extends GenericSpecification<Computer> {
    public static Specification<Computer> id(int id) {
        return equal("id", id);
    }

    public static Specification<Computer> computerNumber(String computerNumber) {
        return equal("computerNumber", computerNumber);
    }
    
    public static Specification<Computer> computerNumberLike(String computerNumber) {
        return like("computerNumber", computerNumber);
    }

    public static Specification<Computer> computerDescription(String computerDescription) {
        return equal("computerDescription", computerDescription);
    }

    public static Specification<Computer> computerDescriptionLike(String computerDescription) {
        return like("computerDescription", computerDescription);
    }

    public static Specification<Computer> timeOfUse(LocalDateTime timeOfUse) {
        return equal("timeOfUse", timeOfUse);
    }

    public static Specification<Computer> timeOfUseLike(LocalDateTime timeOfUse) {
        return like("timeOfUse", timeOfUse);
    }
}
