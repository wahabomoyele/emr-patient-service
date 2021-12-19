package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.BadRequestException;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.lowerCase;

public enum  Education {
    PRIMARY(1, "Primary", "Primary School"),
    SECONDARY(2, "Secondary", "Secondary School"),
    TERTIARY(3, "Tertiary", "Tertiary Institution"),
    POST_GRADUATE(4, "Pg", "Post Graduate Education"),
    DOCTORATE(5, "Phd", "Doctorate"),
    NONE(6, "None", "No Education");

    public static Education findByName(String name) {
        name = capitalize(lowerCase(name));
        for (Education education : Education.values()) {
            if(education.getName().equals(name))return education;
        }
        Education education = findById(name);
        if(education == null) throw new BadRequestException("Invalid education: " + name);
        return education;
    }

    private static Education findById(String a) {
        try {
            Integer id = Integer.valueOf(a);
            for(Education education : Education.values()) {
                if(education.id.equals(id)) return education;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    Education(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private final Integer id;
    private final String name;
    private final String description;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
