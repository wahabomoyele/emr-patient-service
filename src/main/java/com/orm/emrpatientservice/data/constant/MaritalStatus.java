package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.BadRequestException;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.lowerCase;

public enum MaritalStatus {
    DIVORCED(1, "Divorced"),
    MARRIED(2, "Married"),
    SEPARATED(3, "Separated"),
    SINGLE(4, "Single"),
    WIDOWED(5, "Widowed");

    private final Integer id;
    private final String name;

    MaritalStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MaritalStatus findByName(String name) {
        name = capitalize(lowerCase(name));
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            if(maritalStatus.getName().equals(name))return maritalStatus;
        }
        MaritalStatus maritalStatus = findById(name);
        if(maritalStatus == null) throw new BadRequestException("Invalid marital status: " + name);
        return maritalStatus;
    }

    private static MaritalStatus findById(String a) {
        try {
            Integer id = Integer.valueOf(a);
            for(MaritalStatus maritalStatus : MaritalStatus.values()) {
                if(maritalStatus.id.equals(id)) return maritalStatus;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
