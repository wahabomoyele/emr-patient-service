package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.BadRequestException;

import static org.apache.commons.lang3.StringUtils.*;

public enum Sex {
    MALE("MALE", "A male human", 2),
    FEMALE("FEMALE", "A female human", 1),
    OTHER("OTHER", "Any other sex apart from male and female", 3);

    Sex(String name, String description, int id) {
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public static Sex findByName(String name) {
        name = upperCase(name);
        for(Sex s : Sex.values()) {
            if(s.name.equals(name)) return s;
        }
        throw new BadRequestException("Invalid sex: " + name + ". Accepted options: Female, Male, Other");
    }

    private final String description;
    private final String name;
    private final Integer id;


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}

