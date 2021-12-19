package com.orm.emrpatientservice.data.constant;

import com.orm.emrpatientservice.business.exception.BadRequestException;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.lowerCase;

public enum Religion {
    CHRISTIANITY(1, "Christianity"),
    ISLAM(2, "Islam"),
    OTHER(3, "Other");

    private final Integer id;
    private final String name;


    public static Religion findByName(String name) {
        name = capitalize(lowerCase(name));
        for (Religion religion : Religion.values()) {
            if(religion.getName().equals(name))return religion;
        }
        Religion religion = findById(name);
        if(religion == null) throw new BadRequestException("Invalid religion: " + name);
        return religion;
    }

    private static Religion findById(String a) {
        try {
            Integer id = Integer.valueOf(a);
            for(Religion religion : Religion.values()) {
                if(religion.id.equals(id)) return religion;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    Religion(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
